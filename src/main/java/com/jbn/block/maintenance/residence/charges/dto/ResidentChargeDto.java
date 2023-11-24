package com.jbn.block.maintenance.residence.charges.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResidentChargeDto {

    private Integer residentChargeId;
    private Integer ebCharge;
    private Integer maintenanceCharge;
    private Double waterCharge;
    private Integer residentId;
    private LocalDateTime updatedOn;
    private LocalDateTime createdOn;
    private Date recordDate;
}

