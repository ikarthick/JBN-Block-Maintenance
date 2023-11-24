package com.jbn.block.maintenance.common.util;

import com.jbn.block.maintenance.residence.dto.ResidentDetailDto;
import com.jbn.block.maintenance.water.dto.WaterMeterLogsDTO;
import com.jbn.block.maintenance.residence.entity.ResidentDetail;
import com.jbn.block.maintenance.water.entity.WaterMeterLogs;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AppUtil {

    @Autowired
    ModelMapper modelMapper;

    public ResidentDetailDto mapEntityToDTO(ResidentDetail residentDetail){
        return modelMapper.map(residentDetail, ResidentDetailDto.class);
    }

    public ResidentDetail mapDTOToEntity(ResidentDetailDto residentDetailDto){
        return modelMapper.map(residentDetailDto, ResidentDetail.class);
    }

    public List<ResidentDetailDto> mapEntityListToDTO(List<ResidentDetail> residentDetailList) {
        return residentDetailList.stream()
                .map(residentDetail -> modelMapper.map(residentDetail, ResidentDetailDto.class))
                .collect(Collectors.toList());
    }

    public WaterMeterLogs mapDTOToEntity(WaterMeterLogsDTO waterMeterLogsDTO){
        return modelMapper.map(waterMeterLogsDTO, WaterMeterLogs.class);
    }
}
