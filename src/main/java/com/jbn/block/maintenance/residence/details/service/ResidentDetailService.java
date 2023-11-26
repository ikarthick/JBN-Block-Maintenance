package com.jbn.block.maintenance.residence.details.service;

import com.jbn.block.maintenance.residence.details.dto.ResidentDetailDto;
import com.jbn.block.maintenance.residence.details.entity.ResidentDetail;
import com.jbn.block.maintenance.exception.ResourceNotFoundException;
import com.jbn.block.maintenance.residence.details.repository.ResidentDetailRepository;
import com.jbn.block.maintenance.common.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResidentDetailService {

    @Autowired
    ResidentDetailRepository residentDetailRepository;

    @Autowired
    AppUtil appUtil;

    public ResidentDetailDto addHouseOwner(ResidentDetailDto residentDetailDto) {

        ResidentDetail residentDetail = appUtil.mapDTOToEntity(residentDetailDto);
        residentDetailRepository.save(residentDetail);
        return appUtil.mapEntityToDTO(residentDetail);
    }
    public List<ResidentDetailDto> getAllHouseOwners() {
        List<ResidentDetail> residentDetailList = residentDetailRepository.findAll();
        return appUtil.mapEntityListToDTO(residentDetailList);
    }

    public ResidentDetailDto getHouseOwnerById(long id) {
        ResidentDetail residentDetail = residentDetailRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("House Owner", "id", id));
        return appUtil.mapEntityToDTO(residentDetail);
    }

    public ResidentDetailDto updateHouseOwner(ResidentDetailDto residentDetailDto, long id) {

        //get entity by ownerId from the database
        ResidentDetail residentDetail = residentDetailRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("House Owner", "id", id));

        residentDetail.setAge(residentDetailDto.getAge());
        residentDetail.setFullName(residentDetailDto.getFullName());
        residentDetail.setDoorNo(residentDetailDto.getDoorNo());

        ResidentDetail updatedResidentDetail = residentDetailRepository.save(residentDetail);
        return appUtil.mapEntityToDTO(updatedResidentDetail);
    }

    public String deleteHouseOwner(long id) {
        ResidentDetail residentDetail = residentDetailRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("House Owner", "id", id));
        residentDetailRepository.delete(residentDetail);
        return "House Owner has been Deleted Successfully";
    }
}
