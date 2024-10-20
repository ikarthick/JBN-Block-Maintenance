package com.jbn.block.maintenance.residence.payment.service;

import com.jbn.block.maintenance.common.response.ApiResponse;
import com.jbn.block.maintenance.exception.BlockMaintenanceGenericException;
import com.jbn.block.maintenance.residence.balance.entity.ResidentBalance;
import com.jbn.block.maintenance.residence.balance.repository.ResidentBalanceRepository;
import com.jbn.block.maintenance.residence.payment.dto.ResidentPaymentTrxDto;
import com.jbn.block.maintenance.residence.payment.entity.ResidentPaymentTrx;
import com.jbn.block.maintenance.residence.payment.repository.ResidentPaymentTrxRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ResidentPaymentService {

    private final ModelMapper modelMapper;
    private final ResidentPaymentTrxRepository residentPaymentTrxRepository;
    private final ResidentBalanceRepository residentBalanceRepository;

    private final String RAZOR_PAYMENT_KEY = "rzp_test_TimfOCNK1shyQg";
    private final String RAZOR_PAYMENT_SECRET_KEY = "jIPrfvyuQthsWIW3g8FLwyXt";
    private final String CURRENCY = "INR";


    public ResidentPaymentService(ModelMapper modelMapper, ResidentPaymentTrxRepository residentPaymentTrxRepository, ResidentBalanceRepository residentBalanceRepository) {
        this.modelMapper = modelMapper;
        this.residentPaymentTrxRepository = residentPaymentTrxRepository;
        this.residentBalanceRepository = residentBalanceRepository;
    }

    public ApiResponse recordResidentTransaction(ResidentPaymentTrxDto residentPaymentTrxDto){

        if(Optional.ofNullable(residentPaymentTrxDto).isPresent()
                && Optional.ofNullable(residentPaymentTrxDto.getResidentId()).isPresent()) {

            ResidentPaymentTrx residentPaymentTrx = modelMapper.map(residentPaymentTrxDto, ResidentPaymentTrx.class);
            residentPaymentTrx.setRecordDate(new Date());
            residentPaymentTrx.setCreatedOn(new Date());
            residentPaymentTrx.setUpdatedOn(new Date());
            ResidentPaymentTrx savedTransaction = residentPaymentTrxRepository.save(residentPaymentTrx);
            //update the resident balance
            ResidentBalance residentBalance = updateResidentBalance(savedTransaction.getResidentId(), savedTransaction.getAmountPaid(), "Credit");

            return new ApiResponse<>("Success", "Successfully recorded payment transaction", residentBalance);
        } else {
            throw new BlockMaintenanceGenericException("Resident Id is not present in payment transaction");
        }
    }

    public ResidentBalance updateResidentBalance(Integer residentId, Double amount, String status){

        if(Optional.ofNullable(residentId).isPresent()){
            ResidentBalance existingResidentBalanceRecord = residentBalanceRepository
                    .findByResidentId(residentId);
            if (Optional.ofNullable(existingResidentBalanceRecord).isPresent()) {
                Double currentBalance = StringUtils.equals(status, "Credit") ? existingResidentBalanceRecord.getBalanceAmount() + amount
                        : existingResidentBalanceRecord.getBalanceAmount() - amount;
                existingResidentBalanceRecord.setBalanceAmount(currentBalance);
                existingResidentBalanceRecord.setUpdatedOn(new Date());
                return residentBalanceRepository.save(existingResidentBalanceRecord);
            } else {
                ResidentBalance residentBalance = new ResidentBalance();
                residentBalance.setResidentId(residentId);
                Double currentBalance = StringUtils.equals(status, "Credit") ? amount : -amount;
                residentBalance.setBalanceAmount(currentBalance);
                residentBalance.setUpdatedOn(new Date());
                residentBalance.setRecordDate(new Date());
                residentBalance.setCreatedOn(new Date());
                return residentBalanceRepository.save(residentBalance);
            }
        }
        return null;
    }

    public void createTransaction(Double amount) {
        try {

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("amount", (amount*100) );
            jsonObject.put("currency", CURRENCY);

            RazorpayClient razorpayClient = new RazorpayClient(RAZOR_PAYMENT_KEY, RAZOR_PAYMENT_SECRET_KEY);

            Order order = razorpayClient.orders.create(jsonObject);
            System.out.println(order);

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }


}
