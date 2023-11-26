package com.jbn.block.maintenance.water.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "water_meter_logs")
public class WaterMeterLogs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WATER_METER_LOG_ID")
    private Integer waterMeterLogId;

    @Column(name = "RECORD_DATE")
    private Date recordDate;

    @Column(name = "READING_VALUE")
    private Integer readingValue;

    @Column(name = "METER_STATUS")
    private Boolean meterStatus;

    @Column(name = "RESIDENT_ID")
    private Integer residentId;

    @Column(name = "WATER_CONSUMED")
    private Integer waterConsumed;

}
