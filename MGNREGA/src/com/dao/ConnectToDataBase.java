package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectToDataBase {
	static String url;
	static String username;
	static String password;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			ResourceBundle bundle = ResourceBundle.getBundle("dbDetails");
			url = bundle.getString("url");
			username = bundle.getString("username");
			password = bundle.getString("password");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	static public Connection makeConnnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	
	static public void closeConnection(Connection connection) throws SQLException {
		if(connection != null) {
			connection.close();
		}
	}
}
