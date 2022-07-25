package com.crm.javaSqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class toReadTheDataFromTableTest {
public static void main(String[] args) throws SQLException {
 Driver sqlDriver = new Driver();
 DriverManager.registerDriver(sqlDriver);
 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
 Statement statement = connection.createStatement();
 ResultSet result = statement.executeQuery("select * from student");
 while (result.next())
 {
	 System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4)+"\t");
 }
 connection.close();
}
}
