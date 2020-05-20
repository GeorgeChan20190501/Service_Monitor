package com.cognizant.ams.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	private static  Connection connection;
	
	public static Connection getConn() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url="jdbc:sqlserver://10.164.4.53:1433;DatabaseName=TestEnv";
			String username="TestEnv";
			String password="TestEnv";
			connection=DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	public static void main(String[] args) {
		System.out.println(getConn());
	}
}
