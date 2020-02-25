package com.chainsys.busticketapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.TimeZone;

public class ConnectionUtil {
/*	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
		} catch (Exception e) {
			throw new RuntimeException("Unable to get Database connection");
		}
		return connection;
	}*/
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			TimeZone timeZone = TimeZone.getTimeZone("Asia/Kolkata");
			TimeZone.setDefault(timeZone);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@13.235.147.120:1521:XE", "vignesh", "vignesh");
		} catch (Exception e) {
			throw new RuntimeException("Unable to get Database connection");
		}
		return connection;
	}


}
