package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dto.GPM;
import com.dto.GPMImp;
import com.exception.DataNotFoundException;
import com.exception.SomethingWentWrong;
import com.ui.AfterLogin;

public class GPMDao {
	private static boolean isResultSetEmpty(ResultSet resultSet) throws SQLException {
		return (!resultSet.isBeforeFirst() && resultSet.getRow() == 0) ? true : false;
	}
	
	private static List<GPM> getList(ResultSet resultSet) throws SQLException{
		List<GPM> list = new ArrayList<>();
		
		while(resultSet.next()) {
			GPM gpm = new GPMImp();
			
			gpm.setGPMid(resultSet.getInt("gid"));
			gpm.setName(resultSet.getString("gname"));
			gpm.setEmail(resultSet.getString("email_id"));
			gpm.setPassword(resultSet.getString("password"));
			gpm.setDistrict(resultSet.getString("district"));
			gpm.setState(resultSet.getString("state"));
			gpm.setContact(resultSet.getString("contact"));
			
			list.add(gpm);
		}
		
		return list;
	}
	
	public static void login(String email, String password, Scanner scanner) throws DataNotFoundException, SomethingWentWrong {
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
				System.out.println("\n\n******************************************************************");
				System.out.println("          Login successfull as Gram Panchayat Member            ");
				System.out.println("******************************************************************");
				 AfterLogin.forGPM(scanner);
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
	
	
	public static boolean createGPM(GPM gpm) throws SomethingWentWrong {
		Connection connection = null;
		
		try {
			connection = ConnectToDataBase.makeConnnection();
			
			PreparedStatement statement = connection.prepareStatement("insert into gpm (gname, email_id, password, district, state, contact) values (?, ?, ?, ?, ?, ?)");
			
			statement.setString(1, gpm.getName());
			statement.setString(2, gpm.getEmail());
			statement.setString(3, gpm.getPassword());
			statement.setString(4, gpm.getDistrict());
			statement.setString(5, gpm.getState());
			statement.setString(6, gpm.getContact());
			
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
	
	
	public static List<GPM> getListOffGPM() throws SomethingWentWrong, DataNotFoundException{
		Connection connection = null;
		List<GPM> list = null;
		
		try {
			connection = ConnectToDataBase.makeConnnection();
			
			PreparedStatement statement = connection.prepareStatement("select * from gpm");
			
			ResultSet resultSet = statement.executeQuery();
			
			if(isResultSetEmpty(resultSet)) {
				throw new DataNotFoundException("GPM table is empty");
			}
			
			list = getList(resultSet);
		} catch (SQLException e) {
			
		} finally {
			try {
				ConnectToDataBase.closeConnection(connection);
			} catch (SQLException e) {
				throw new SomethingWentWrong();
			}
		}
		return list;
	}
	
	public static boolean deleteGPM(Integer id) throws SomethingWentWrong {
		Connection connection = null;
		
		try {
			connection = ConnectToDataBase.makeConnnection();
			
			PreparedStatement statement = connection.prepareStatement("delete from gpm where gid = ?");
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			
		} finally {
			try {
				ConnectToDataBase.closeConnection(connection);
			} catch (SQLException e) {
				throw new SomethingWentWrong();
			}
		}
		
		return true;
	}
	
	public static boolean assignProjectToGPM(Integer gpmid, Integer pid) throws SomethingWentWrong {
		Connection connection = null;
		
		try {
			connection = ConnectToDataBase.makeConnnection();
			
			PreparedStatement statement = connection.prepareStatement("update gpm set pid = ? where gid = ?");
			statement.setInt(1, pid);
			statement.setInt(2, gpmid);
			
			statement.executeUpdate();
			
			PreparedStatement statement2 = connection.prepareStatement("update project set gpmid = ? where pid = ?");
			statement2.setInt(1, gpmid);
			statement2.setInt(2, pid);
			
			statement2.executeUpdate();
		} catch (SQLException e) {
			
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