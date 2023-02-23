package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dto.Employee;
import com.exception.DataNotFoundException;
import com.exception.SomethingWentWrong;

public class GPMDaoImp implements GPMDao{
	@Override
	public void login(String email, String password) throws DataNotFoundException, SomethingWentWrong {
		Connection connection = null;
		
		try {
			connection = ConnectToDataBase.makeConnnection();
			
			String query = "select gid, password from gpm where email_id = ?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, email);
			
			ResultSet resultset = statement.executeQuery();
			
			resultset.next();
			
			String passwordString = resultset.getString("password");
			
			if(passwordString.equals(password)) {
				 System.out.println("Login successfull as GPM\n\n");
			} else {
				System.out.println("Wrong password \n\n");
			}
			
		} catch (SQLException e) {
			throw new DataNotFoundException("Data Not Found!!!");
		} finally {
			try {
				ConnectToDataBase.closeConnection(connection);
			} catch (SQLException e) {
				throw new SomethingWentWrong();
			}
		}
	}

	@Override
	public void createEmployee(Employee emp) throws SomethingWentWrong {
		Connection connection = null;
		
		try {
			connection = ConnectToDataBase.makeConnnection();
			
			String query = "insert into employee (eid, ename, email, dob) values (?, ?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, emp.getEid());
			statement.setString(2, emp.getName());
			statement.setString(3, emp.getEmail());
			statement.setString(5, emp.getDob()+"");
			
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new SomethingWentWrong();
		} finally {
			try {
				ConnectToDataBase.closeConnection(connection);
			} catch (SQLException e) {
				throw new SomethingWentWrong();
			}
		}
		
	}
	
	
	

}
