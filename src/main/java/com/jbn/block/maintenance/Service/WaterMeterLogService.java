package com.jbn.block.maintenance.Service;

import com.jbn.block.maintenance.DTO.WaterMeterLogsDTO;
import com.jbn.block.maintenance.Entity.WaterMeterLogs;
import com.jbn.block.maintenance.Repository.WaterMeterLogsRepository;
import com.jbn.block.maintenance.Utility.AppUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class WaterMeterLogService {

    @Autowired
    WaterMeterLogsRepository waterMeterLogsRepository;

    @Autowired
    AppUtil appUtil;

    public WaterMeterLogsDTO saveWaterLog(WaterMeterLogsDTO waterMeterLogsDTO){
        waterMeterLogsDTO.setWaterMeterLogDate(LocalDateTime.now());
        WaterMeterLogs waterMeterLogsEntity = appUtil.mapDTOToEntity(waterMeterLogsDTO);
        waterMeterLogsRepository.save(waterMeterLogsEntity);
        log.info("Water Meter Log Updated");
        return waterMeterLogsDTO;
    }
}
