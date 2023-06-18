package com.jbn.block.maintenance.Repository;

import com.jbn.block.maintenance.Entity.MonthlyReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthlyReportRepository extends JpaRepository<MonthlyReport, Long> {
}
