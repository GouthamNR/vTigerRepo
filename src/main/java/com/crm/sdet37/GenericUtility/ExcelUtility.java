package com.crm.sdet37.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author Goutham
 *
 */
public class ExcelUtility {
	/**
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
public String getCellvalue(String sheetName,int rowNum,int cellNum) throws Throwable {
	FileInputStream fileInputStream=new FileInputStream(IConstant.excelFilePath);
	Workbook workbook = WorkbookFactory.create(fileInputStream);
	Sheet sheet = workbook.getSheet(sheetName);
	Row row = sheet.getRow(rowNum);
	Cell cell = row.getCell(cellNum);
	DataFormatter data = new DataFormatter();
	String value = data.formatCellValue(cell);
	return value;
}
/**
 * 
 * @param sheetName
 * @param rowNum
 * @param cellNum
 * @param cellData
 * @throws Throwable
 */
public void setCellValue(String sheetName, int rowNum, int cellNum, String cellData) throws Throwable {
	FileInputStream fileInputStream=new FileInputStream(IConstant.excelFilePath);
	Workbook workbook = WorkbookFactory.create(fileInputStream);
	Sheet sheet = workbook.getSheet(sheetName);
	Row row = sheet.createRow(rowNum);
	Cell cell = row.createCell(cellNum);
	cell.setCellValue(cellData);
	FileOutputStream fileOutputstream= new FileOutputStream(IConstant.excelFilePath);
	workbook.write(fileOutputstream);
}
/**
 * 
 * @param sheetName
 * @return
 * @throws Throwable
 */
public int getLastCellNum(String sheetName ) throws Throwable {
	FileInputStream fileInputStream=new FileInputStream(IConstant.excelFilePath);
	Workbook workbook = WorkbookFactory.create(fileInputStream);
	Sheet sheet = workbook.getSheet(sheetName);
	int row = sheet.getLastRowNum();
	return row;
}
}
