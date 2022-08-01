package com.crm.sdet37.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
static Driver driverref;
static Connection connection;
static ResultSet result;

public void connectToDataBase(String DbName) throws Throwable {
	driverref=new Driver();
	DriverManager.registerDriver(driverref);
	DriverManager.getConnection(IConstant.DbUrl+DbName, IConstant.DbUserName, IConstant.DbPassword);
}

public boolean executeQuery(String query,int columnNum, String actualData) throws Throwable {
	result=connection.createStatement().executeQuery(query);
	boolean flag = false;
	while (result.next()) {
		if (result.getString(columnNum).equals(actualData)) {
			flag=true;
			break;
		}
		else {
			flag=false;
		}
	}
	return flag;
}

public void executeUpdate(String query) throws Throwable {
	int res=connection.createStatement().executeUpdate(query);
	if (res==1) {
		System.out.println("PASS: Updated");
	}
	else {
		System.out.println("FAIL: Not updated");
	}
}
}
