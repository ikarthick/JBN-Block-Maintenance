package com.jbn.block.maintenance.residence.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResidentPaymentTrxDto {

    private Integer residentId;
    private Double amountPaid;

}
