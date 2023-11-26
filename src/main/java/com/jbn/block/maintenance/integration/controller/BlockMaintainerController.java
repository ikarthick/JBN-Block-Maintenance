package com.jbn.block.maintenance.integration.controller;

import com.jbn.block.maintenance.common.response.ApiResponse;
import com.jbn.block.maintenance.common.service.ExcelService;
import com.jbn.block.maintenance.common.service.ExcelToPdfConverter;
import com.jbn.block.maintenance.integration.dto.MonthlyExpenseUploadDto;
import com.jbn.block.maintenance.integration.service.BlockMaintainerService;
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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@Tag(name = "Block Maintainer Endpoint")
public class BlockMaintainerController {
    private final BlockMaintainerService blockMaintainerService;
    private final ExcelService excelService;

    @Autowired
    public BlockMaintainerController(BlockMaintainerService blockMaintainerService, ExcelService excelService) {
        this.blockMaintainerService = blockMaintainerService;
        this.excelService = excelService;
    }

    @PostMapping(value = "/monthly/bill/upload", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Monthly Bill upload",description = "Monthly bill Upload", operationId = "1")
    public ResponseEntity<ApiResponse> monthlyExpenseUpload(@RequestBody MonthlyExpenseUploadDto monthlyExpenseUploadDto){
        return new ResponseEntity<>(blockMaintainerService.monthlyExpenseUpload(monthlyExpenseUploadDto), HttpStatus.CREATED);
    }

    //todo - draft template and document generation
    @PostMapping("/insert")
    public void insertDataAndGenerateDocument() {
        // Sample data for demonstration
        String inputFile = "src/main/resources/template/Block-Maintenance-Template.html";
        String outputFile = "src/main/resources/template/output/Block-Maintenance-Template-Output.html";
        Map<String, String> placeholders = new HashMap<>();
        placeholders.put("{Month}", "DEC");
        placeholders.put("{Year}", "2023");

        try {
            // Read the content of the input HTML file
            String htmlContent = new String(Files.readAllBytes(Path.of(inputFile)));

            // Replace placeholders with values
            for (Map.Entry<String, String> entry : placeholders.entrySet()) {
                htmlContent = htmlContent.replace(entry.getKey(), entry.getValue());
            }

            // Write the modified content to the output HTML file
            Files.write(Path.of(outputFile), htmlContent.getBytes());

            System.out.println("HTML file processed successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
