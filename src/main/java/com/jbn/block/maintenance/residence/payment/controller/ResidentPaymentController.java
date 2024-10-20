package com.jbn.block.maintenance.residence.payment.controller;

import com.jbn.block.maintenance.common.response.ApiResponse;
import com.jbn.block.maintenance.residence.payment.dto.ResidentPaymentTrxDto;
import com.jbn.block.maintenance.residence.payment.service.ResidentPaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/resident/payment")
public class ResidentPaymentController {

    private final ResidentPaymentService residentPaymentService;

    public ResidentPaymentController(ResidentPaymentService residentPaymentService) {
        this.residentPaymentService = residentPaymentService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> recordResidentTransaction(@Valid @RequestBody ResidentPaymentTrxDto residentPaymentTrxDto){
        return new ResponseEntity<>(residentPaymentService.recordResidentTransaction(residentPaymentTrxDto), HttpStatus.CREATED);
    }
}
