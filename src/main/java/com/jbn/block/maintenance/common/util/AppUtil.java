package com.jbn.block.maintenance.common.util;

import com.jbn.block.maintenance.block.dto.BlockExpenseDto;
import com.jbn.block.maintenance.block.entity.BlockExpense;
import com.jbn.block.maintenance.eb.dto.EbChargeDetailDto;
import com.jbn.block.maintenance.eb.entity.EbChargeDetail;
import com.jbn.block.maintenance.residence.details.dto.ResidentDetailDto;
import com.jbn.block.maintenance.water.dto.WaterChargeDetailDto;
import com.jbn.block.maintenance.water.dto.WaterMeterLogsDTO;
import com.jbn.block.maintenance.residence.details.entity.ResidentDetail;
import com.jbn.block.maintenance.water.entity.WaterChargeDetail;
import com.jbn.block.maintenance.water.entity.WaterMeterLogs;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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

    public EbChargeDetail mapDtoToEntity(EbChargeDetailDto ebChargeDetailDto){
        return modelMapper.map(ebChargeDetailDto, EbChargeDetail.class);
    }

    public WaterChargeDetail mapDtoToEntity(WaterChargeDetailDto waterChargeDetailDto){
        return modelMapper.map(waterChargeDetailDto, WaterChargeDetail.class);
    }

    public BlockExpense mapDtoToEntity(BlockExpenseDto blockExpenseDto){
        return modelMapper.map(blockExpenseDto, BlockExpense.class);
    }

    public static boolean isInPreviousMonth(Date date) {
        // Convert java.util.Date to java.time.LocalDate
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Calculate the start of the current month
        LocalDate startOfCurrentMonth = currentDate.withDayOfMonth(1);

        // Calculate the start of the previous month
        LocalDate startOfPreviousMonth = startOfCurrentMonth.minusMonths(1);

        // Check if the given date is after the start of the previous month
        // and before the start of the current month
        return localDate.isAfter(startOfPreviousMonth) && localDate.isBefore(startOfCurrentMonth);
    }
}
