package com.jbn.block.maintenance.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "MONTHLY_REPORT")
@Data
public class MonthlyReport {

    @Id
    private Long monthlyReportId;
    private Integer ownerTotalAmountPayable;
    private Integer ownerPreviousDues;
    private Integer ownerAdvancesPaid;

    @OneToOne(mappedBy = "monthlyReport", cascade = CascadeType.ALL)
    private CommonCharges commonCharges;

    @ManyToOne
    @JoinColumn(name = "OWNER_DOOR_NO", referencedColumnName = "OWNER_DOOR_NO")
    private HouseOwner houseOwner;

    @OneToOne(mappedBy = "monthlyReport", cascade = CascadeType.ALL)
    private WaterMeterLogs waterMeterLogs;

    // Constructors, getters, and setters

    // Optional convenience methods for maintaining the relationship

    public HouseOwner getOwner() {
        return houseOwner;
    }

    public void setOwner(HouseOwner houseOwner) {
        this.houseOwner = houseOwner;
    }

    public void setWaterMeterLog(WaterMeterLogs waterMeterLog) {
        this.waterMeterLogs = waterMeterLog;
        waterMeterLog.setMonthlyReport(this);
    }

    public void removeWaterMeterLog() {
        if (waterMeterLogs != null) {
            waterMeterLogs.setMonthlyReport(null);
            this.waterMeterLogs = null;
        }
    }

}
