package com.jbn.block.maintenance.residence.balance.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "resident_balance")
public class ResidentBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESIDENT_BALANCE_ID")
    private Integer residentBalanceId;

    @Column(name = "RESIDENT_ID")
    private Integer residentId;

    @Column(name = "BALANCE_AMOUNT")
    private Double balanceAmount;

    @Column(name = "CREATED_ON")
    private Date createdOn;

    @Column(name = "UPDATED_ON")
    private Date updatedOn;

    @Column(name = "RECORD_DATE")
    private Date recordDate;

}
