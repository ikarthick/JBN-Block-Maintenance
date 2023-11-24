package com.jbn.block.maintenance.eb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EbChargeDetailDto {

    private Integer blockPumpCharges;
    private Integer commonSumpCharge;
    private Integer staircaseCharge;

}


