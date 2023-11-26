package com.jbn.block.maintenance.common.service;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class ExcelService {

    private static final Logger logger = LoggerFactory.getLogger(ExcelService.class);

    public void writeDataToExcel(String templateFilePath, String outputFilePath, String sheetName, Object[][] data, int startRow, int startColumn) {
        try (InputStream templateInputStream = new FileInputStream(templateFilePath);
             Workbook workbook = WorkbookFactory.create(templateInputStream)) {

            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                sheet = workbook.createSheet(sheetName);
            }

            for (int rowNum = 0; rowNum < data.length; rowNum++) {
                Row row = sheet.getRow(startRow + rowNum);

                if (row == null) {
                    row = sheet.createRow(startRow + rowNum);
                }

                for (int colNum = 0; colNum < data[rowNum].length; colNum++) {
                    Cell cell = row.getCell(startColumn + colNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    setCellValue(cell, data[rowNum][colNum]);
                }
            }

            try (FileOutputStream outputStream = new FileOutputStream(outputFilePath)) {
                workbook.write(outputStream);
                outputStream.flush(); // Flush the stream
                logger.info("Data successfully written to output file: {}", outputFilePath);
            }

        } catch (IOException e) {
            logger.error("Error writing data to Excel file", e);
            e.printStackTrace();
        }
    }


        private void setCellValue(Cell cell, Object value) {
        if (value instanceof String) {
            cell.setCellValue((String) value);
        } else if (value instanceof Double) {
            cell.setCellValue((Double) value);
        } else if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        }
        // Add more data types as needed
    }

    public static String readExcelAsString(String filePath) throws IOException {
        try (InputStream inputStream = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(inputStream)) {

            StringBuilder content = new StringBuilder();

            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                Sheet sheet = workbook.getSheetAt(i);

                for (Row row : sheet) {
                    for (Cell cell : row) {
                        content.append(cell.toString()).append("\t");
                    }
                    content.append("\n");
                }
            }

            return content.toString();
        } catch (InvalidFormatException e) {
            throw new IOException("Error reading Excel file", e);
        }
    }

    public static void writeStringToExcel(String filePath, String content) throws IOException {
        try (OutputStream outputStream = new FileOutputStream(filePath);
             Workbook workbook = new XSSFWorkbook()) {

            Sheet sheet = workbook.createSheet("Sheet1");
            String[] rows = content.split("\n");

            for (int i = 0; i < rows.length; i++) {
                String[] columns = rows[i].split("\t");
                Row row = sheet.createRow(i);

                for (int j = 0; j < columns.length; j++) {
                    Cell cell = row.createCell(j);
                    cell.setCellValue(columns[j]);
                }
            }

            workbook.write(outputStream);
        }
    }
}