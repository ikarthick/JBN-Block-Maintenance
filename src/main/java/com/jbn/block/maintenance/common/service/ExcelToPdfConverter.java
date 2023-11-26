package com.jbn.block.maintenance.common.service;

import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

import java.io.*;
import java.util.Iterator;

public class ExcelToPdfConverter {

    public static void convertExcelToPdf(String excelFilePath, String pdfFilePath) throws IOException {
        try (InputStream excelInputStream = new FileInputStream(excelFilePath);
             Workbook workbook = WorkbookFactory.create(excelInputStream);
             PDDocument document = new PDDocument()) {

            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                Sheet sheet = workbook.getSheetAt(i);

                PDPage page = new PDPage(PDRectangle.A4);
                document.addPage(page);

                try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                    contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
                    contentStream.beginText();
                    contentStream.newLineAtOffset(50, 700); // Adjust the offset as needed

                    Iterator<Row> rowIterator = sheet.iterator();

                    while (rowIterator.hasNext()) {
                        Row row = rowIterator.next();
                        Iterator<Cell> cellIterator = row.cellIterator();

                        while (cellIterator.hasNext()) {
                            Cell cell = cellIterator.next();
                            contentStream.showText(cell.toString() + "  ");
                        }

                        contentStream.newLineAtOffset(0, -15); // Adjust the offset as needed
                    }

                    contentStream.endText();
                }
            }

            document.save(pdfFilePath);
        }
    }

    public static void testVmConvertor() {
        try {
            // Load the PDF document
            PDDocument document = PDDocument.load(new File("src/main/resources/template/output/pdf/SOP_Paris.pdf"));

            // Extract text from the PDF
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            String pdfText = pdfTextStripper.getText(document);

            // Create a Velocity Template
            String velocityTemplate = "#set($pdfContent = \"" + pdfText + "\")\n" +
                    "Hello, this is my PDF content:\n" +
                    "$pdfContent";

            // Write the Velocity Template to a .vm file
            try (FileWriter writer = new FileWriter("SOP_Paris.vm")) {
                writer.write(velocityTemplate);
            }

            // Close the PDF document
            document.close();

            System.out.println("Conversion completed successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}