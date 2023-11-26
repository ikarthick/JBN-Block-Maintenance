package com.jbn.block.maintenance.integration.controller;

import com.jbn.block.maintenance.common.response.ApiResponse;
import com.jbn.block.maintenance.integration.dto.MonthlyExpenseUploadDto;
import com.jbn.block.maintenance.integration.service.BlockMaintainerService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@Tag(name = "Block Maintainer Endpoint")
public class BlockMaintainerController {
    private final BlockMaintainerService blockMaintainerService;

    @Autowired
    public BlockMaintainerController(BlockMaintainerService blockMaintainerService) {
        this.blockMaintainerService = blockMaintainerService;
    }

    @PostMapping(value = "/monthly/bill/upload", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Monthly Bill upload",description = "Monthly bill Upload", operationId = "1")
    public ResponseEntity<ApiResponse> monthlyExpenseUpload(@RequestBody MonthlyExpenseUploadDto monthlyExpenseUploadDto){
        return new ResponseEntity<>(blockMaintainerService.monthlyExpenseUpload(monthlyExpenseUploadDto), HttpStatus.CREATED);
    }
}
