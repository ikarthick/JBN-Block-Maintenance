package com.jbn.block.maintenance.residence.charges.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "resident_charge")
public class ResidentCharge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESIDENT_CHARGE_ID")
    private Integer residentPaymentTrxId;

    @Column(name = "EB_CHARGE")
    private Integer ebCharge;

    @Column(name = "MAINTENANCE_CHARGE")
    private Integer maintenanceCharge;

    @Column(name = "WATER_CHARGE")
    private Double waterCharge;

    @Column(name = "RESIDENT_ID")
    private Integer residentId;

    @Column(name = "UPDATED_ON")
    private LocalDateTime updatedOn;

    @Column(name = "CREATED_ON")
    private LocalDateTime createdOn;

    @Column(name = "RECORD_DATE")
    private Date recordDate;

}

