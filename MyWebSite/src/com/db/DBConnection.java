package com.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;



public class DBConnection {

	
	public static void main(String[] args) {
		System.out.println(new DBConnection().insertIpAddress("10.6.5.2"));
	}

	public  Connection getConnection() {
		
		ResourceBundle rb1=ResourceBundle.getBundle("Environment");
        String environment = rb1.getString("ActiveEnvironment");
        ResourceBundle rb2=ResourceBundle.getBundle(environment+"_Config");
        
        
		Connection conn=null;
		String url = rb2.getString("URL");
		String dbName = rb2.getString("dbInstanceName");
		String driver = rb2.getString("driver");
		String userName = rb2.getString("userName");
		String password = rb2.getString("password");

		/*
		 * String url = "jdbc:mysql://localhost:3306/"; String dbName =
		 * "SecOnt"; String driver = "com.mysql.jdbc.Driver"; String userName =
		 * "root"; String password = "soon1234";
		 */
		try {
			Class.forName(driver).newInstance();
		
			conn = DriverManager.getConnection(url + dbName, userName, password);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Connection Failure to the database.");
		}
		return conn;
	}
	
	
public int insertIpAddress(String ipAddress){
		
		try{ 
			
			Connection con=new DBConnection().getConnection();
		Statement  stmt = con.createStatement();
	
	
		
	      String sqlInsert = "Insert into userinfo values ('"+ipAddress+"',NOW())";
	    return stmt.executeUpdate(sqlInsert);
	   
	
		}catch(Exception ae){
			
		}
		
		return 0;
	}

}
