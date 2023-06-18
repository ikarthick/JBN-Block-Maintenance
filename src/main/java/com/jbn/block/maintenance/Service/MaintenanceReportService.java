package com.jbn.block.maintenance.Service;


import com.jbn.block.maintenance.Repository.WaterMeterLogsRepository;
import com.jbn.block.maintenance.Utility.AppUtil;
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
