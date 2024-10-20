package com.jbn.block.maintenance.residence.payment.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResidentPaymentTrxDto {

    @Schema(defaultValue = "1")
    private Integer residentId;
    @Schema(defaultValue = "1000")
    private Double amountPaid;

}
