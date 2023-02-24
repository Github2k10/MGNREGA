package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dto.Employee;
import com.dto.EmployeeImp;
import com.exception.DataNotFoundException;
import com.exception.SomethingWentWrong;

public class EmployeeDoa {
	public static boolean createEmployee(Employee employee) throws SomethingWentWrong {
		Connection connection = null;
		
		try {
			connection  = ConnectToDataBase.makeConnnection();
			PreparedStatement statement = connection.prepareStatement("insert into employee (ename, email_id, contact, dob, joining_date) values (?, ?, ?, ?, CURDATE())");
			
			statement.setString(1, employee.getName());
			statement.setString(2, employee.getEmail());
			statement.setString(3, employee.getContact());
			statement.setDate(4, Date.valueOf(employee.getDob()));
			
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
	
	
	public static Employee viewDetails(int id) throws DataNotFoundException, SomethingWentWrong {
		Employee employee = null;
		Connection connection = null;
		
		try {
			connection = ConnectToDataBase.makeConnnection();
			
			PreparedStatement statement = connection.prepareStatement("select * from employee where eid = ?");
			statement.setInt(1, id);
			
			ResultSet resultSet = statement.executeQuery();
			
			employee = new EmployeeImp();
			
			employee.setEid(id);
			employee.setName(resultSet.getString("ename"));
			employee.setEmail(resultSet.getString("email_id"));
			employee.setContact(resultSet.getString("contact"));
			employee.setDob(Date.valueOf(resultSet.getDate("dob") + "").toLocalDate());
			employee.setJoiningDate(Date.valueOf(resultSet.getDate("joining_date") + "").toLocalDate());
			employee.setWages(resultSet.getDouble("wages"));
			employee.setEpid(resultSet.getInt("epid"));
			
		} catch (SQLException e) {
			throw new DataNotFoundException("Employee not found with this Id");
		} finally {
			try {
				ConnectToDataBase.closeConnection(connection);
			} catch (SQLException e) {
				throw new SomethingWentWrong();
			}
		}
		
		return employee;
	}
}
