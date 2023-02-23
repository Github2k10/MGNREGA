package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exception.DataNotFoundException;
import com.exception.SomethingWentWrong;

public class GPMDaoImp implements GPMDao{
	@Override
	public void login(String email, String password) throws DataNotFoundException, SomethingWentWrong {
		Connection connection = null;
		System.out.print("inside GPM");
		
		try {
			connection = ConnectToDataBase.makeConnnection();
			
			String query = "select gid, password from gpm where email_id = ?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, email);
			
			ResultSet resultset = statement.executeQuery();
			
			resultset.next();
			
			int id = resultset.getInt("gid");
			String passwordString = resultset.getString("password");
			
//			if(passwordString.equals(password)) {
//				 System.out.println("Login successfull as GPM");
//			} else {
//				System.out.println("Wrong password");
//			}
			
			System.out.print(id + " " + passwordString + " " + email);
			
		} catch (SQLException e) {
			throw new DataNotFoundException("User Data not found");
		} finally {
			try {
				ConnectToDataBase.closeConnection(connection);
			} catch (SQLException e) {
				throw new SomethingWentWrong("");
			}
		}
		
	}

}
