package com.jbn.block.maintenance.Controller;

import com.jbn.block.maintenance.DTO.WaterMeterLogsDTO;
import com.jbn.block.maintenance.Service.WaterMeterLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WaterMeterLogsController {

    @Autowired
    WaterMeterLogService waterMeterLogService;

    @PostMapping("add/waterLog")
    public ResponseEntity<WaterMeterLogsDTO> addWaterLog(@RequestBody WaterMeterLogsDTO waterMeterLogsDTO){
        return new ResponseEntity<>(waterMeterLogService.saveWaterLog(waterMeterLogsDTO), HttpStatus.CREATED);
    }
}
