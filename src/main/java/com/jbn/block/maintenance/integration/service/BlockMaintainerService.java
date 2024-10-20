package com.jbn.block.maintenance.integration.service;

import com.jbn.block.maintenance.block.dto.BlockExpenseDto;
import com.jbn.block.maintenance.block.entity.BlockExpense;
import com.jbn.block.maintenance.block.repository.BlockExpenseRepository;
import com.jbn.block.maintenance.common.response.ApiResponse;
import com.jbn.block.maintenance.common.util.AppUtil;
import com.jbn.block.maintenance.eb.dto.EbChargeDetailDto;
import com.jbn.block.maintenance.eb.entity.EbChargeDetail;
import com.jbn.block.maintenance.eb.repository.EbChargeDetailRepository;
import com.jbn.block.maintenance.exception.BlockMaintenanceGenericException;
import com.jbn.block.maintenance.integration.dto.MonthlyExpenseUploadDto;
import com.jbn.block.maintenance.residence.charges.service.ResidentChargeService;
import com.jbn.block.maintenance.water.dto.WaterChargeDetailDto;
import com.jbn.block.maintenance.water.entity.WaterChargeDetail;
import com.jbn.block.maintenance.water.repository.WaterChargeDetailRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class BlockMaintainerService {

    private final BlockExpenseRepository blockExpenseRepository;
    private final EbChargeDetailRepository ebChargeDetailRepository;
    private final WaterChargeDetailRepository waterChargeDetailRepository;
    private final AppUtil appUtil;
    private final ResidentChargeService residentChargeService;

    public BlockMaintainerService(BlockExpenseRepository blockExpenseRepository,
                                  EbChargeDetailRepository ebChargeDetailRepository,
                                  WaterChargeDetailRepository waterChargeDetailRepository, AppUtil appUtil, ResidentChargeService residentChargeService) {
        this.blockExpenseRepository = blockExpenseRepository;
        this.ebChargeDetailRepository = ebChargeDetailRepository;
        this.waterChargeDetailRepository = waterChargeDetailRepository;
        this.appUtil = appUtil;
        this.residentChargeService = residentChargeService;
    }

    public ApiResponse monthlyExpenseUpload(MonthlyExpenseUploadDto monthlyExpenseUploadDto) {

        //Upload all the monthly expenses
        BlockExpenseDto blockExpenseDto = monthlyExpenseUploadDto.getBlockExpense();
        BlockExpense blockExpenseEntityObj = appUtil.mapDtoToEntity(blockExpenseDto);
        Integer carryOverBalance = calculateBlockBalance(blockExpenseDto);
        blockExpenseEntityObj.setCarryOverBalance(carryOverBalance);
        blockExpenseEntityObj.setRecordDate(new Date());
        blockExpenseEntityObj.setCreatedOn(new Date());
        blockExpenseEntityObj.setUpdatedOn(new Date());
        //save block expense for current month
        BlockExpense savedBlockExpense = blockExpenseRepository.save(blockExpenseEntityObj);

        EbChargeDetailDto electricityCharges = monthlyExpenseUploadDto.getElectricityCharges();
        EbChargeDetail ebChargeDetailEntityObj = appUtil.mapDtoToEntity(electricityCharges);
        ebChargeDetailEntityObj.setCreatedOn(new Date());
        ebChargeDetailEntityObj.setUpdatedOn(new Date());
        ebChargeDetailEntityObj.setRecordDate(new Date());
        EbChargeDetail savedEbChargeDetail = ebChargeDetailRepository.save(ebChargeDetailEntityObj);

        WaterChargeDetailDto waterCharges = monthlyExpenseUploadDto.getWaterCharges();
        WaterChargeDetail waterMeterLogsEntityObj = appUtil.mapDtoToEntity(waterCharges);
        waterMeterLogsEntityObj.setCreatedOn(new Date());
        waterMeterLogsEntityObj.setRecordDate(new Date());
        waterMeterLogsEntityObj.setUpdatedOn(new Date());
        WaterChargeDetail savedWaterChargeDetail = waterChargeDetailRepository.save(waterMeterLogsEntityObj);

        //update mapping Id
        savedBlockExpense.setEbChargeDetailId(savedEbChargeDetail.getEbChargeDetailId());
        savedBlockExpense.setWaterChargeDetailId(savedWaterChargeDetail.getWaterChargeDetailId());
        BlockExpense savedBlockExpenseObj = blockExpenseRepository.save(savedBlockExpense);

        //Compute Resident Charges based on Block Expenses
        residentChargeService.generateResidentMonthlyCharges(savedBlockExpenseObj);

        return new ApiResponse<>("Success", "Block Expenses has been recorded successfully", savedBlockExpense);

    }

    public Integer calculateBlockBalance(BlockExpenseDto blockExpenseDto) {
        Optional<BlockExpense> previousMonthRecord = blockExpenseRepository.findFirstByIsActiveTrueOrderByRecordDateDesc();
        if (Optional.ofNullable(previousMonthRecord).isPresent()
                && AppUtil.isInPreviousMonth(previousMonthRecord.get().getRecordDate())
                && Optional.ofNullable(blockExpenseDto).isPresent()) {
            //fetch latest carryOverBalance
            Integer previousCarryOverBalance = previousMonthRecord.get().getCarryOverBalance();
            Integer incurredReceipt = blockExpenseDto.getMaintenanceCharge() + previousCarryOverBalance;
            Integer otherExpenses = Optional.ofNullable(blockExpenseDto.getOtherExpenses()).isPresent() ? blockExpenseDto.getOtherExpenses() : 0;
            Integer totalExpenses = blockExpenseDto.getPumpOperatorSalary() + blockExpenseDto.getSweeperCharge()
                    + otherExpenses;
           return incurredReceipt - totalExpenses;
        } else {
            throw new BlockMaintenanceGenericException("Block Expenses has been already updated for current month "+ new Date());
        }
    }

}
