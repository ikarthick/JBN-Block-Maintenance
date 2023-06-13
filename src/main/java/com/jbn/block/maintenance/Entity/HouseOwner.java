package com.jbn.block.maintenance.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "HouseOwner")
public class HouseOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ownerId;

    @Column(name = "ownerFullName", nullable = false)
    private String ownerFullName;

    @Column(name = "ownerAge")
    private Integer ownerAge;

    @Column(name = "ownerDoorNo", nullable = false)
    private Integer ownerDoorNo;

}
