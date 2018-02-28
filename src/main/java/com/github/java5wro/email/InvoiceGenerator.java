package com.github.java5wro.email;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InvoiceGenerator {

    private  final String FILE_NAME = "invoice.xlsx";

    public  byte[] invoiceGenerator()  {


        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Invoice data");
        Object[][] invoiceData = {
                { "Firstname", "Lastname", "Price", "Data"},
                { "***Firstname***", "***Lastname***", "***Price***", "***Data***"}
        };

        int rowNum = 0;
        System.out.println("Creating excel");

        for (Object[] data : invoiceData) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : data) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }

        for(int i = 0; i < 10; i++) {
            sheet.autoSizeColumn(i);
        }

        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return outputStream.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}