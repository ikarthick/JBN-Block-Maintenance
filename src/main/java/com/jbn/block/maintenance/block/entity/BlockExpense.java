package com.jbn.block.maintenance.block.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "block_expenses")
public class BlockExpense implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BLOCK_EXPENSE_ID")
    private Integer blockExpenseId;

    @Column(name = "MAINTENANCE_CHARGE", nullable = false)
    private Integer maintenanceCharge;

    @Column(name = "SWEEPER_SALARY")
    private Integer sweeperCharge;

    @Column(name = "PUMP_OPERATOR_SALARY", nullable = false)
    private Integer pumpOperatorSalary;

    @Column(name = "OTHER_EXPENSES_NAME")
    private String otherExpensesName;

    @Column(name = "OTHER_EXPENSES")
    private Integer otherExpenses;

    @Column(name = "CARRY_OVER_BALANCE")
    private Integer carryOverBalance;
}
