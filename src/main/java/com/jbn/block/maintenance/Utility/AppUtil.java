package com.jbn.block.maintenance.Utility;

import com.jbn.block.maintenance.DTO.HouseOwnerDTO;
import com.jbn.block.maintenance.DTO.WaterMeterLogsDTO;
import com.jbn.block.maintenance.Entity.HouseOwner;
import com.jbn.block.maintenance.Entity.WaterMeterLogs;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppUtil {

    @Autowired
    ModelMapper modelMapper;

    public HouseOwnerDTO mapEntityToDTO(HouseOwner houseOwner){
        return modelMapper.map(houseOwner, HouseOwnerDTO.class);
    }

    public HouseOwner mapDTOToEntity(HouseOwnerDTO houseOwnerDTO){
        return modelMapper.map(houseOwnerDTO, HouseOwner.class);
    }

    public List<HouseOwnerDTO> mapEntityListToDTO(List<HouseOwner> houseOwnerList){
        return modelMapper.map(houseOwnerList, new TypeToken<List<Character>>() {}.getType());
    }

    public WaterMeterLogs mapDTOToEntity(WaterMeterLogsDTO waterMeterLogsDTO){
        return modelMapper.map(waterMeterLogsDTO, WaterMeterLogs.class);
    }
}
