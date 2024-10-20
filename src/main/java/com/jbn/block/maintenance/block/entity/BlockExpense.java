package com.jbn.block.maintenance.block.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "block_expenses")
@NamedEntityGraph(
        name = "blockExpenseGraph",
        attributeNodes = {
                @NamedAttributeNode("ebChargeDetailId"),
                @NamedAttributeNode("waterChargeDetailId")
        }
)
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

    @Column(name = "RECORD_DATE")
    private Date recordDate;

    @Column(name = "CREATED_ON")
    private Date createdOn;

    @Column(name = "UPDATED_ON")
    private Date updatedOn;

    @Column(name = "EB_CHARGE_DETAIL_ID")
    private Integer ebChargeDetailId;

    @Column(name = "WATER_CHARGE_DETAIL_ID")
    private Integer waterChargeDetailId;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;
}
