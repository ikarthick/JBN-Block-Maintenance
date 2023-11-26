package com.jbn.block.maintenance.water.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "water_charge_detail")
public class WaterChargeDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WATER_CHARGE_DETAIL_ID")
    private Integer waterChargeDetailId;

    @Column(name = "METRO_CHARGE")
    private Integer metroWaterCharge;

    @Column(name = "PRIVATE_TANKER_CHARGE")
    private Integer privateTankerCharge;

    @Column(name = "CREATED_ON")
    private Date createdOn;

    @Column(name = "UPDATED_ON")
    private Date updatedOn;

    @Column(name = "RECORD_DATE")
    private Date recordDate;

}
