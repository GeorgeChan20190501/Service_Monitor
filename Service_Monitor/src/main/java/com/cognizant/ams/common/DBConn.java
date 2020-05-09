package com.cognizant.ams.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	private static  Connection connection;
	
	public static Connection getConn() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url="jdbc:sqlserver://localhost:1433;DatabaseName=George";
			String username="sa";
			String password="f10011116";
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
