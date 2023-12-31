package com.jbn.block.maintenance.block.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BlockExpenseDto implements Serializable {

    private Integer maintenanceCharge;

    private Integer sweeperCharge;

    private Integer pumpOperatorSalary;

    private String otherExpensesName;

    private Integer otherExpenses;

}