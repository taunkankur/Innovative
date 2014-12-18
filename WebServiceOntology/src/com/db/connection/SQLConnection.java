package com.db.connection;

import java.sql.Connection;
import java.sql.DriverManager;


public  class SQLConnection {

	public static void main(String[] args) {
		System.out.println(SQLConnection.getConnection());
	}
	

	public static Connection getConnection() {
		Connection conn=null;
		String url = "jdbc:mysql://cis.csi.cuny.edu:3306/";
		String dbName = "secont";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "soon1234";

		/*
		 * String url = "jdbc:mysql://localhost:3306/"; String dbName =
		 * "SecOnt"; String driver = "com.mysql.jdbc.Driver"; String userName =
		 * "root"; String password = "soon1234";
		 */
		try {
			Class.forName(driver).newInstance();
			conn=DriverManager.getConnection("jdbc:mysql://cis.csi.cuny.edu:3306/secont?user=root&password=soon1234&useUnicode=true&characterEncoding=UTF-8");
//			conn = DriverManager.getConnection(url + dbName, userName, password);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Connection Failure to the database.");
		}
		return conn;
	}
}

