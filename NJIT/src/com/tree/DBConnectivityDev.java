package com.tree;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
 

import java.sql.Connection;
import java.sql.DriverManager;







public class DBConnectivityDev {

	public static void main(String[] args) {
		
		System.out.println(DBConnectivityDev.getconnect());	
				}
	
	public static Connection getconnect(){
		Connection con=null;
	
	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con=DriverManager.getConnection("jdbc:sqlserver://LENOVO-PC\\SQL2012:1436;Database=TestDataBase;User=;Password=");
		//con=DriverManager.getConnection("jdbc:sqlserver://QADB03\\SQL2005:1436;Database=VSSLogging;User=CVPUtils;Password=IvR4dm!n");
		
	}catch(Exception ae){
		ae.printStackTrace();
	}
	return  con;
	}

}



