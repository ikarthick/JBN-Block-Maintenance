package com.jbn.block.maintenance.Service;

import com.jbn.block.maintenance.DTO.HouseOwnerDTO;
import com.jbn.block.maintenance.Entity.HouseOwner;
import com.jbn.block.maintenance.Exception.ResourceNotFoundException;
import com.jbn.block.maintenance.Repository.HouseOwnerRepository;
import com.jbn.block.maintenance.Utility.AppUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseOwnerService {

    @Autowired
    HouseOwnerRepository houseOwnerRepository;

    @Autowired
    AppUtil appUtil;

    public HouseOwnerDTO addHouseOwner(HouseOwnerDTO houseOwnerDTO) {

        HouseOwner houseOwner = appUtil.mapDTOToEntity(houseOwnerDTO);
        houseOwnerRepository.save(houseOwner);
        return appUtil.mapEntityToDTO(houseOwner);
    }

    //todo - need to fix this endpoint
    public List<HouseOwnerDTO> getAllHouseOwners() {
        List<HouseOwner> houseOwnerList= houseOwnerRepository.findAll();
        return appUtil.mapEntityListToDTO(houseOwnerList);
    }

    public HouseOwnerDTO getHouseOwnerById(long id) {
        HouseOwner houseOwner = houseOwnerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("House Owner", "id", id));
        return appUtil.mapEntityToDTO(houseOwner);
    }

    public HouseOwnerDTO updateHouseOwner(HouseOwnerDTO houseOwnerDTO, long id) {

        //get entity by ownerId from the database
        HouseOwner houseOwner = houseOwnerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("House Owner", "id", id));

        houseOwner.setOwnerAge(houseOwnerDTO.getOwnerAge());
        houseOwner.setOwnerFullName(houseOwnerDTO.getOwnerFullName());
        houseOwner.setOwnerDoorNo(houseOwnerDTO.getOwnerDoorNo());

        HouseOwner updatedHouseOwner = houseOwnerRepository.save(houseOwner);
        return appUtil.mapEntityToDTO(updatedHouseOwner);
    }

    public String deleteHouseOwner(long id) {
        HouseOwner houseOwner = houseOwnerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("House Owner", "id", id));
        houseOwnerRepository.delete(houseOwner);
        return "House Owner has been Deleted Successfully";
    }
}
