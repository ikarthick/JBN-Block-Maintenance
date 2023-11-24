package com.jbn.block.maintenance.residence.balance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResidentBalanceDto {

    private Integer residentBalanceId;
    private Integer residentId;
    private Double balanceAmount;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private Date recordDate;

}