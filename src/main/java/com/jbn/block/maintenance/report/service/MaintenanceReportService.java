package com.jbn.block.maintenance.report.service;


import com.jbn.block.maintenance.water.repository.WaterMeterLogsRepository;
import com.jbn.block.maintenance.common.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MaintenanceReportService {

    @Autowired
    WaterMeterLogsRepository waterMeterLogsRepository;

    @Autowired
    AppUtil appUtil;

    public MaintenanceReportService(WaterMeterLogsRepository waterMeterLogsRepository, AppUtil appUtil) {
        this.waterMeterLogsRepository = waterMeterLogsRepository;
        this.appUtil = appUtil;
    }

}
