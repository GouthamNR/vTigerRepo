package com.crm.sdet37.GenericUtility;

public interface IConstant {
	String proprtyFilePath ="./src/test/resources/Vtiger.properties.txt";
	String excelFilePath="./src/test/resources/VTigerTestData.xlsx";
	String chromeKey="webDriver.chrome.driver";
	String chromeValue="./src/test/resources/chromedriver.exe";
	String DbUrl= "jdbc:mysql://localhost:3306/";
	String DbUserName="root";
	String DbPassword="root";
	int implicitlyWaitDuration=10;
	int explicitlyWaitDuration=20;

}
