package com.crm.sdet37.GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * 
 * @author Goutham
 *
 */
public class FileUtility {
/**
 * 
 * @param key
 * @return
 * @throws Throwable
 */
	public String getProperty(String key) throws Throwable {
		FileInputStream fileInputStream = new FileInputStream(IConstant.proprtyFilePath);
		Properties property=new Properties();
		property.load(fileInputStream);
		String value = property.getProperty(key);
		return value;
	}
}
