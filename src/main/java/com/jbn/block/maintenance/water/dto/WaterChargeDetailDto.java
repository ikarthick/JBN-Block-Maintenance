package com.jbn.block.maintenance.water.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WaterChargeDetailDto {

    private Integer waterChargeDetailId;
    private Integer metroCharge;
    private Integer privateTankerCharge;

}
