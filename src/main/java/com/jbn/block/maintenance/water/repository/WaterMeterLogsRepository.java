package com.jbn.block.maintenance.water.repository;

import com.jbn.block.maintenance.water.entity.WaterMeterLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterMeterLogsRepository extends JpaRepository<WaterMeterLogs, Long> {
}
