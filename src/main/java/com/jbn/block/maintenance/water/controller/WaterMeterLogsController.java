package com.jbn.block.maintenance.water.controller;

import com.jbn.block.maintenance.water.dto.WaterMeterLogsDTO;
import com.jbn.block.maintenance.water.service.WaterMeterLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/water")
public class WaterMeterLogsController {

    @Autowired
    WaterMeterLogService waterMeterLogService;

    @PostMapping("/log")
    public ResponseEntity<WaterMeterLogsDTO> addWaterLog(@RequestBody WaterMeterLogsDTO waterMeterLogsDTO){
        return new ResponseEntity<>(waterMeterLogService.saveWaterLog(waterMeterLogsDTO), HttpStatus.CREATED);
    }
}
