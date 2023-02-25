package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.Employee;
import com.dto.EmployeeImp;
import com.dto.Project;
import com.dto.ProjectImp;
import com.exception.DataNotFoundException;
import com.exception.SomethingWentWrong;

public class EmployeeDoa {
	private static boolean isResultSetEmpty(ResultSet resultSet) throws SQLException {
		return (!resultSet.isBeforeFirst() && resultSet.getRow() == 0) ? true : false;
	}
	
	
	private static List<Employee> getList(ResultSet resultSet) throws SQLException{
		List<Employee> list = new ArrayList<>();
		
		while(resultSet.next()) {
			Employee employee = new EmployeeImp();
			
			employee.setEid(resultSet.getInt("eid"));
			employee.setName(resultSet.getString("ename"));
			employee.setEmail(resultSet.getString("email_id"));
			employee.setContact(resultSet.getString("contact"));
			employee.setWages(resultSet.getDouble("wages"));
		
			employee.setDob(Date.valueOf(resultSet.getDate("dob") + "").toLocalDate());
			employee.setJoiningDate(Date.valueOf(resultSet.getDate("joining_date") + "").toLocalDate());
			
			
			list.add(employee);
		}
		
		return list;
	}
	
	
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
			resultSet.next();
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
			throw new DataNotFoundException("Employee Not found with this Id");
		} finally {
			try {
				ConnectToDataBase.closeConnection(connection);
			} catch (SQLException e) {
				throw new SomethingWentWrong();
			}
		}
		
		return employee;
	}
	
	
	public static boolean assignProjectToEmployee(Integer eid, Integer pid) throws SomethingWentWrong {
		Connection connection = null;
		
		try {
			connection = ConnectToDataBase.makeConnnection();
			
			PreparedStatement statement = connection.prepareStatement("update employee set epid = ? where eid = ?");
			statement.setInt(1, pid);
			statement.setInt(2, eid);
			
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
	
	public static boolean deleteEmployee(Integer eid) throws SomethingWentWrong {
		Connection connection = null;
		
		try {
			connection = ConnectToDataBase.makeConnnection();
			
			PreparedStatement statement = connection.prepareStatement("delete from employee where eid = ?");
			statement.setInt(1, eid);
			
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
	
	
	public static boolean giveWagesToEmployee(Integer id, Double amount) throws SomethingWentWrong, DataNotFoundException {
		Connection connection = null;
		
		try {
			connection = ConnectToDataBase.makeConnnection();
			
			PreparedStatement statement = connection.prepareStatement("update employee set wages = ? where eid = ?");
			statement.setDouble(1, amount);
			statement.setInt(2, id);
			
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DataNotFoundException("Employee Not found with this Id");
		} finally {
			try {
				ConnectToDataBase.closeConnection(connection);
			} catch (SQLException e) {
				throw new SomethingWentWrong();
			}
		}
		
		return true;
	}
	
	
	public static boolean listEmployeeWorkinigOnProject(Integer pid) throws SomethingWentWrong, DataNotFoundException {
		Connection connection = null;
		List<Employee> list = null;
		
		try {
			connection = ConnectToDataBase.makeConnnection();
			
			PreparedStatement statement = connection.prepareStatement("select eid, ename, email_id, contact, dob, joining_date, wages, work_days from employee as e inner join project p on e.epid = p.pid where p.pid = ?");
			statement.setInt(1, pid);
			
			ResultSet resultSet = statement.executeQuery();
			
			if(isResultSetEmpty(resultSet)) {
				throw new DataNotFoundException("Project table is empty");
			}
			
			list = getList(resultSet);
		} catch (SQLException e) {
			throw new DataNotFoundException("Employee Not found with this Id");
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