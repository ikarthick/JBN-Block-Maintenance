package com.jbn.block.maintenance.water.repository;

import com.jbn.block.maintenance.water.entity.WaterMeterLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface WaterMeterLogsRepository extends JpaRepository<WaterMeterLogs, Long> {

    //returns the latest record based on resident Id
    WaterMeterLogs findByResidentIdOrderByWaterMeterLogIdDesc(Integer residentId);

}
