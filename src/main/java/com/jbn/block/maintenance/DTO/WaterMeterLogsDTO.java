package com.jbn.block.maintenance.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WaterMeterLogsDTO {

    private long waterMeterId;
    private Integer waterMeterReading;
    private LocalDateTime waterMeterLogDate;
    private HouseOwnerDTO houseOwner;
}
