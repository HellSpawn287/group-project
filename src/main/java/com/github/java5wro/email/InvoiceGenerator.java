package com.github.java5wro.email;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InvoiceGenerator {

    private static final String FILE_NAME = "invoice.xlsx";

    public static void main(String[] args) {


        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Invoice data");
        Object[][] invoiceData = {
                {"Invoice number", "Firstname", "Lastname", "Price", "Data"},
                {"***Invoice number***", "***Firstname***", "***Lastname***", "***Price***", "***Data***"}
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

        for(int i = 0; i < invoiceData.length; i++) {
            sheet.autoSizeColumn(i);
        }

        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }
}