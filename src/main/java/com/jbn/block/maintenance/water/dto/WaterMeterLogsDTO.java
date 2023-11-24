package com.jbn.block.maintenance.water.dto;

import com.jbn.block.maintenance.residence.dto.ResidentDetailDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WaterMeterLogsDTO {

    private long waterMeterLogId;
    private Integer residentId;
    private LocalDateTime recordDate;
    private Double readingValue;
}
