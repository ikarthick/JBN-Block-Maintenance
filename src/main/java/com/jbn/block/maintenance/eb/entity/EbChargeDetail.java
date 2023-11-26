package com.jbn.block.maintenance.eb.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "eb_charge_detail")
public class EbChargeDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EB_CHARGE_DETAIL_ID")
    private Integer ebChargeDetailId;

    @Column(name = "BLOCK_PUMP_CHARGE")
    private Integer blockPumpCharges;

    @Column(name = "COMMON_SUMP_CHARGE")
    private Integer commonSumpCharge;

    @Column(name = "STAIRCASE_CHARGE")
    private Integer staircaseCharge;

    @Column(name = "CREATED_ON")
    private Date createdOn;

    @Column(name = "UPDATED_ON")
    private Date updatedOn;

    @Column(name = "RECORD_DATE")
    private Date recordDate;

}
