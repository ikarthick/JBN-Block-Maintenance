package com.jbn.block.maintenance.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseOwnerDTO {

    private Long ownerId;
    private String ownerFullName;
    private Integer ownerAge;
    private Long ownerDoorNo;
    private String ownerPhoneNo;
    private String ownerEmailId;

}
