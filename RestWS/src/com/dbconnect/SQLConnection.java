package com.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;


public  class SQLConnection {

	

	public static Connection getConnection() {
		Connection conn=null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "secont";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "";

		/*
		 * String url = "jdbc:mysql://localhost:3306/"; String dbName =
		 * "SecOnt"; String driver = "com.mysql.jdbc.Driver"; String userName =
		 * "root"; String password = "soon1234";
		 */
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbName, userName, password);
			
			
		} catch (Exception e) {
			System.out.println("Connection Failure to the database");
		}
		return conn;
	}
}
