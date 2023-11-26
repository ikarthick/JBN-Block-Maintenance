package com.jbn.block.maintenance.residence.charges.service;

import com.jbn.block.maintenance.block.entity.BlockExpense;
import com.jbn.block.maintenance.block.repository.BlockExpenseRepository;
import com.jbn.block.maintenance.common.response.ApiResponse;
import com.jbn.block.maintenance.eb.entity.EbChargeDetail;
import com.jbn.block.maintenance.eb.repository.EbChargeDetailRepository;
import com.jbn.block.maintenance.exception.BlockMaintenanceGenericException;
import com.jbn.block.maintenance.residence.charges.entity.ResidentCharge;
import com.jbn.block.maintenance.residence.charges.repository.ResidentChargeRepository;
import com.jbn.block.maintenance.residence.details.entity.ResidentDetail;
import com.jbn.block.maintenance.residence.details.repository.ResidentDetailRepository;
import com.jbn.block.maintenance.water.entity.WaterChargeDetail;
import com.jbn.block.maintenance.water.entity.WaterMeterLogs;
import com.jbn.block.maintenance.water.repository.WaterChargeDetailRepository;
import com.jbn.block.maintenance.water.repository.WaterMeterLogsRepository;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ResidentChargeService {

    private final ResidentChargeRepository residentChargeRepository;
    private final BlockExpenseRepository blockExpenseRepository;
    private final EbChargeDetailRepository ebChargeDetailRepository;
    private final WaterChargeDetailRepository waterChargeDetailRepository;
    private final ResidentDetailRepository residentDetailRepository;
    private final WaterMeterLogsRepository waterMeterLogsRepository;

    public ResidentChargeService(ResidentChargeRepository residentChargeRepository, BlockExpenseRepository blockExpenseRepository, EbChargeDetailRepository ebChargeDetailRepository, WaterChargeDetailRepository waterChargeDetailRepository, ResidentDetailRepository residentDetailRepository, WaterMeterLogsRepository waterMeterLogsRepository) {
        this.residentChargeRepository = residentChargeRepository;
        this.blockExpenseRepository = blockExpenseRepository;
        this.ebChargeDetailRepository = ebChargeDetailRepository;
        this.waterChargeDetailRepository = waterChargeDetailRepository;
        this.residentDetailRepository = residentDetailRepository;
        this.waterMeterLogsRepository = waterMeterLogsRepository;
    }


    public List<ResidentCharge> generateResidentMonthlyCharges(BlockExpense blockExpenseObj) {
        List<ResidentCharge> residentChargeList = new ArrayList<>();
       if(Optional.ofNullable(blockExpenseObj).isPresent()) {
           //fetch all resident records
           List<ResidentDetail> residentDetailList = residentDetailRepository.findAll();
           Integer blkMaintenanceCharge = blockExpenseObj.getMaintenanceCharge();
           Integer totalWaterConsumptionConsumptionPerUnit = calculateTotalWaterConsumptionPerUnit(blockExpenseObj);
           Integer totalEBChargesPerResident = calculateTotalEBChargesPerResident(blockExpenseObj);
           residentDetailList.forEach(resident -> {
               ResidentCharge savedResidentCharge = constructAndSaveResidentCharge(totalEBChargesPerResident
                       ,resident.getResidentId()
                       ,blkMaintenanceCharge
                       ,totalWaterConsumptionConsumptionPerUnit);
               residentChargeList.add(savedResidentCharge);
           });
       } else {
           throw new BlockMaintenanceGenericException("Block Expense Object is not present while computing resident charges");
       }
       return residentChargeList;
    }

    private ResidentCharge constructAndSaveResidentCharge(Integer totalEBChargesPerResident, Integer residentId, Integer blkMaintenanceCharge, Integer totalWaterConsumptionConsumption) {
        ResidentCharge residentCharge = new ResidentCharge();
        residentCharge.setEbCharge(totalEBChargesPerResident);
        residentCharge.setResidentId(residentId);
        residentCharge.setMaintenanceCharge(blkMaintenanceCharge/15);
        residentCharge.setCreatedOn(new Date());
        residentCharge.setUpdatedOn(new Date());
        residentCharge.setRecordDate(new Date());
        //todo - need to calculate based on water meter log
        residentCharge.setWaterCharge(totalWaterConsumptionConsumption/15);

        //save residentCharges
        return residentChargeRepository.save(residentCharge);
    }

    private Integer calculateTotalWaterConsumptionPerUnit(BlockExpense blockExpense) {
        WaterChargeDetail waterChargeDetail = waterChargeDetailRepository.getById(blockExpense.getWaterChargeDetailId());
        Integer metroWaterCharge = Optional.ofNullable(waterChargeDetail.getMetroWaterCharge()).isPresent()
                ? waterChargeDetail.getMetroWaterCharge(): 0;
        Integer privateTankerCharge = Optional.ofNullable(waterChargeDetail.getPrivateTankerCharge()).isPresent()
                ? waterChargeDetail.getPrivateTankerCharge() : 0;
        return (metroWaterCharge + privateTankerCharge)/15;
    }

    private Integer calculateTotalEBChargesPerResident(BlockExpense blockExpense) {
        EbChargeDetail ebChargeDetail = ebChargeDetailRepository.getById(blockExpense.getEbChargeDetailId());
        Integer ebBlockPumpCharges = Optional.ofNullable(ebChargeDetail.getBlockPumpCharges()).isPresent()
                ? ebChargeDetail.getBlockPumpCharges(): 0;
        Integer ebStairCaseCharges = Optional.ofNullable(ebChargeDetail.getStaircaseCharge()).isPresent()
                ? ebChargeDetail.getStaircaseCharge() : 0;
        Integer ebCommonSumpCharges = Optional.ofNullable(ebChargeDetail.getCommonSumpCharge()).isPresent()
                ? ebChargeDetail.getCommonSumpCharge() : 0;
        //average EbCharge per flat
        return (ebCommonSumpCharges + ebStairCaseCharges + ebBlockPumpCharges)/15;
    }
}
