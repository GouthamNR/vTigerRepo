package com.crm.javaSqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ToInsertTheDataToTableTest {
public static void main(String[] args) throws Exception {
	Driver sqlDriver = new Driver();
	DriverManager.registerDriver(sqlDriver);
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
	Statement statement = connection.createStatement();
	int result = statement.executeUpdate("insert into student values('supriya','----','1996/06/01','1232')");
	if (result==1) {
		System.out.println("PASS: Query OK, 1 row affected");
	}
	else {
		System.out.println("FAIL: Not able to update the Table");
	}
}
}
