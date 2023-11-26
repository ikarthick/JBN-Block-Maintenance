package com.jbn.block.maintenance.integration.dto;

import com.jbn.block.maintenance.block.dto.BlockExpenseDto;
import com.jbn.block.maintenance.block.entity.BlockExpense;
import com.jbn.block.maintenance.eb.dto.EbChargeDetailDto;
import com.jbn.block.maintenance.water.dto.WaterChargeDetailDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyExpenseUploadDto {

    private BlockExpenseDto blockExpense;
    private EbChargeDetailDto electricityCharges;
    private WaterChargeDetailDto waterCharges;

}
