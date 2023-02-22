package com.ui;

import java.sql.Connection;
import java.sql.SQLException;

import com.dao.ConnectToDataBase;

public class Main {

	public static void main(String[] args) {
		Connection connection = null;
		try {
			connection = ConnectToDataBase.makeConnnection();
			System.out.println("connection stablished");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ConnectToDataBase.closeConnection(connection);
				System.out.println("connection closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
