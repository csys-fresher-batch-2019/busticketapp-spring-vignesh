package com.chainsys.busticketapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

import org.springframework.stereotype.Component;

import com.chainsys.busticketapp.exception.DBException;
@Component
public class ConnectionUtil {
/*	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to get Database connection");
		}
		return connection;
	} */
	
		public static Connection getConnection() throws DBException{
		Connection connection = null;
		try {
			TimeZone timeZone = TimeZone.getTimeZone("Asia/Kolkata");
			TimeZone.setDefault(timeZone);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@13.235.147.120:1521:XE", "vignesh", "vignesh");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to get Database connection", e);
		}
		return connection;
	} 

}
