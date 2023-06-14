package com.jbn.block.maintenance.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "HOUSE_OWNER_DETAILS")
public class HouseOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OWNER_ID")
    private Long ownerId;

    @Column(name = "OWNER_FULL_NAME", nullable = false)
    private String ownerFullName;

    @Column(name = "OWNER_AGE")
    private Integer ownerAge;

    @Column(name = "OWNER_DOOR_NO", nullable = false)
    private Integer ownerDoorNo;

    @Column(name = "OWNER_PHONE_NO")
    private String ownerPhoneNo;

    @Column(name = "OWNER_EMAIL_ID", nullable = false)
    private String ownerEmailId;

    @OneToMany(mappedBy = "houseOwner")
    private List<WaterMeterLogs> waterMeterLogs;

}
