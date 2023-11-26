package com.jbn.block.maintenance.water.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WaterMeterLogsDTO {
    private Integer residentId;
    private LocalDateTime recordDate;
    private Double readingValue;
    private Boolean meterStatus;
}
