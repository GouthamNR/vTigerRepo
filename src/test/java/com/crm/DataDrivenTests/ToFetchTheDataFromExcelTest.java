package com.crm.DataDrivenTests;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToFetchTheDataFromExcelTest {
public static void main(String[] args) throws Throwable {
	FileInputStream fis = new FileInputStream("./src/test/resources/details.xlsx");
	Workbook workbook = WorkbookFactory.create(fis);
	Sheet sheet = workbook.getSheet("data");
	Row row = sheet.getRow(1);
	Cell cell = row.getCell(0);
	String celldata = cell.getStringCellValue();
	System.err.println("Name : " +celldata);
	Row row1 = sheet.getRow(1);
	Cell cell1 = row1.getCell(1);
	String celldata1 = cell1.getStringCellValue();
	System.err.println("gender : " +celldata1);
	Row row2 = sheet.getRow(1);
	Cell cell2 = row2.getCell(2);
	String celldata2 = cell2.getStringCellValue();
	System.err.println("age : " +celldata2);
	Row row3 = sheet.getRow(1);
	Cell cell3 = row3.getCell(3);
	int celldata3 = (int)cell3.getNumericCellValue();
	System.err.println("Number : " +celldata3);
}
}
