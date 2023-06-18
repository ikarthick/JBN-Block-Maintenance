package com.jbn.block.maintenance.Repository;

import com.jbn.block.maintenance.Entity.WaterMeterLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterMeterLogsRepository extends JpaRepository<WaterMeterLogs, Long> {
}
