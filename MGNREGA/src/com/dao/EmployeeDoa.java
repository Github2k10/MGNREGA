package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dto.Employee;
import com.exception.SomethingWentWrong;

public class EmployeeDoa {
	public static boolean createEmployee(Employee employee) throws SomethingWentWrong {
		Connection connection = null;
		
		try {
			connection  = ConnectToDataBase.makeConnnection();
			PreparedStatement statement = connection.prepareStatement("insert into employee (ename, email_id, contact, dob, joining_date) values (?, ?, ?, ?, CURDATE())");
			
			
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
		
		return true;
	}
}
