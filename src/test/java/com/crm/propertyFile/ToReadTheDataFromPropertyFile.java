package com.crm.propertyFile;

import java.io.FileInputStream;
import java.util.Properties;

public class ToReadTheDataFromPropertyFile {
public static void main(String[] args) throws Throwable {
	FileInputStream fis = new FileInputStream("./src/test/resources/Vtiger.properties.txt");
	Properties properties = new Properties();
	properties.load(fis);
	String url = properties.getProperty("url");
	System.out.println(url);
}  
}
