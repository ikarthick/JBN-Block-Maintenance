package com.jbn.block.maintenance.Entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "WATER_METER_LOGS")
public class WaterMeterLogs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WATER_METER_ID")
    private long waterMeterId;

    @Column(name = "WATER_METER_READING")
    private Integer waterMeterReading;

    @Column(name = "WATER_METER_LOG_DATE")
    private LocalDateTime waterMeterLogDate;

    @OneToOne
    @JoinColumn(name = "MONTHLY_REPORT_ID")
    private MonthlyReport monthlyReport;

//     Optional convenience methods for maintaining the relationship

    public MonthlyReport getOwner() {
        return monthlyReport;
    }

    public void setMonthlyReport(MonthlyReport monthlyReport) {
        this.monthlyReport = monthlyReport;
    }


}
