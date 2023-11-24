package com.jbn.block.maintenance.residence.details.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "resident_details")
public class ResidentDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESIDENT_ID")
    private Long residentId;

    @Column(name = "FULL_NAME", nullable = false)
    private String fullName;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "DOOR_NO", nullable = false)
    private Long doorNo;

    @Column(name = "PHONE_NO")
    private String phoneNo;

    @Column(name = "EMAIL_ID", nullable = false)
    private String emailId;
}
