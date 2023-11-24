package com.jbn.block.maintenance.residence.details.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResidentDetailDto {

    private Long residentId;
    private String fullName;
    private Integer age;
    private Long doorNo;
    private String phoneNo;
    private String emailId;

}
