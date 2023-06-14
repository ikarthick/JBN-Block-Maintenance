package com.jbn.block.maintenance.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "WATER_METER_LOGS")
public class WaterMeterLogs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WATER_METER_ID")
    private long waterMeterId;

    @Column(name = "WATER_METER_READING")
    private Integer waterMeterReading;

    @Column(name = "WATER_METER_LOG_DATE")
    private Date waterMeterLogDate;

    @ManyToOne
    @JoinColumn(name="owner_door_no", referencedColumnName="owner_door_no")
    private HouseOwner houseOwner;

}
