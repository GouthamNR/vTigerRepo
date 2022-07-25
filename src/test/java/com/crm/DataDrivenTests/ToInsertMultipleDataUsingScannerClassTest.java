package com.crm.DataDrivenTests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToInsertMultipleDataUsingScannerClassTest {
public static void main(String[] args) throws Throwable {
	Scanner scan = new Scanner(System.in);
	FileInputStream fis = new FileInputStream("./src/test/resources/multiData.xlsx");
	Workbook workBook = WorkbookFactory.create(fis);
	Sheet sheet = workBook.getSheet("data");
	System.out.println("enter the cell Data");
	for (int i = 0; i < 5; i++) {
		Row row = sheet.createRow(i);
		Cell cell = row.createCell(0);
		cell.setCellValue(scan.next());
		//String cellData = cell.getStringCellValue();
		//System.out.println(cellData);
	}
	scan.close();
	FileOutputStream fout = new FileOutputStream("./src/test/resources/multiData.xlsx");
	workBook.write(fout);
}
}
