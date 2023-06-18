package com.jbn.block.maintenance.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonthlyReportDTO {

    private long monthlyReportId;
    private Integer TotalBalance;
    private Integer monthlyMaintenanceCharges;
    private Integer monthlySweeperSalary;
    private Integer monthlyPumpOperatorSalary;
    private Integer monthlyEBWellCharges;
    private Integer monthlyEBStaircaseCharges;
    private Integer monthlyCommonSumpCharges;
    private Integer monthlyMetroWaterCharges;
    private Integer monthlyPrivateTankCharges;
    private Integer ownerPreviousDues;
    private Integer ownerAdvancesPaid;
    private HouseOwnerDTO houseOwner;

}
