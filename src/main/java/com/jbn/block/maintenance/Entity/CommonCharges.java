package com.jbn.block.maintenance.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "COMMON_CHARGES")
public class CommonCharges {

    @Id
    private Long commonChargeId;
    private Integer overallTotalBalance;  //Total amount holding by Block Representative
    private Integer monthlyMaintenanceCharges; //Amount entered should be 200 (per person)
    private Integer monthlySweeperSalary;
    private Integer monthlyPumpOperatorSalary;
    private Integer monthlyEbWellCharges;
    private Integer monthlyEbStaircaseCharges;
    private Integer monthlyCommonSumpCharges;
    private Integer monthlyMetroWaterCharges;
    private Integer monthlyPrivateTankCharges;
    @OneToOne
    @JoinColumn(name = "MONTHLY_REPORT_ID")
    private MonthlyReport monthlyReport;
}
