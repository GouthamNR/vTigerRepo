package com.crm.DataDrivenTests;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToInsertDataInToExcelTest {
public static void main(String[] args) throws Throwable {
	FileInputStream fis = new FileInputStream("./src/test/resources/insertData.xlsx");
	Workbook workBook = WorkbookFactory.create(fis);
	Sheet sheet = workBook.getSheet("data");
	Row row = sheet.createRow(0);
	Cell cell = row.createCell(0);
	cell.setCellValue("goutham");
	String cellData = cell.getStringCellValue();
	System.out.println(cellData);
	FileOutputStream fout = new FileOutputStream("./src/test/resources/insertData.xlsx");
	workBook.write(fout);
}
}
