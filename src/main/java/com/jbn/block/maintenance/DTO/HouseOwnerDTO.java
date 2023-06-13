package com.jbn.block.maintenance.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseOwnerDTO {

    private long ownerId;
    private String ownerFullName;
    private Integer ownerAge;
    private Integer ownerDoorNo;

}
