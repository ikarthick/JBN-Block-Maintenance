package com.jbn.block.maintenance.water.service;

import com.jbn.block.maintenance.water.dto.WaterMeterLogsDTO;
import com.jbn.block.maintenance.water.entity.WaterMeterLogs;
import com.jbn.block.maintenance.water.repository.WaterMeterLogsRepository;
import com.jbn.block.maintenance.common.util.AppUtil;
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
        waterMeterLogsDTO.setRecordDate(LocalDateTime.now());
        WaterMeterLogs waterMeterLogsEntity = appUtil.mapDTOToEntity(waterMeterLogsDTO);
        waterMeterLogsRepository.save(waterMeterLogsEntity);
        log.info("Water Meter Log Updated");
        return waterMeterLogsDTO;
    }
}
