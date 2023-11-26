package com.jbn.block.maintenance.water.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "water_meter_logs")
public class WaterMeterLogs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WATER_METER_LOG_ID")
    private long waterMeterLogId;

    @Column(name = "RECORD_DATE")
    private LocalDateTime recordDate;

    @Column(name = "READING_VALUE")
    private Double readingValue;

    @Column(name = "METER_STATUS")
    private Boolean meterStatus;

    @Column(name = "RESIDENT_ID")
    private Integer residentId;

}
