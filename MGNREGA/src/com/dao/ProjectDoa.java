package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.Project;
import com.dto.ProjectImp;
import com.exception.DataNotFoundException;
import com.exception.SomethingWentWrong;

public class ProjectDoa {
	private static boolean isResultSetEmpty(ResultSet resultSet) throws SQLException {
		return (!resultSet.isBeforeFirst() && resultSet.getRow() == 0) ? true : false;
	}
	
	private static List<Project> getList(ResultSet resultSet) throws SQLException{
		List<Project> list = new ArrayList<>();
		
		while(resultSet.next()) {
			Project project = new ProjectImp();
			
			project.setPid(resultSet.getInt("pid"));
			project.setPname(resultSet.getString("pname"));
			project.setPcost(resultSet.getDouble("pcost"));
			project.setPduration(resultSet.getInt("pduration"));
			project.setGPMid(resultSet.getInt("gpmid"));
			
			list.add(project);
		}
		
		return list;
	}
	
	public static boolean createProject(Project project) throws SomethingWentWrong {
		Connection connection = null;
		
		try {
			connection  = ConnectToDataBase.makeConnnection();
			PreparedStatement statement = connection.prepareStatement("insert into project (pname, pcost) values (?, ?)");
			
			statement.setString(1, project.getPname());
			statement.setDouble(2, project.getPcost());
			
			statement.executeUpdate();
			System.out.println("\n\n***************************************************");
			System.out.println("       Project Created Successfully         ");
			System.out.println("***************************************************");
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
	
	
	public static List<Project> projectList() throws DataNotFoundException, SomethingWentWrong{
		List<Project> list = null;
		Connection connection = null;
		
		try {
			connection = ConnectToDataBase.makeConnnection();
			
			PreparedStatement statement = connection.prepareStatement("select * from project");
			
			ResultSet resultSet = statement.executeQuery();
			
			if(isResultSetEmpty(resultSet)) {
				throw new DataNotFoundException("Project table is empty");
			}
			
			list = getList(resultSet);
		} catch (SQLException e) {
			throw new SomethingWentWrong();
		} finally {
			try {
				ConnectToDataBase.closeConnection(connection);
			} catch (SQLException e) {
				throw new SomethingWentWrong();
			}
		}
		
		return list;
	}
	
	public static boolean deleteproject(Integer id) throws SomethingWentWrong, DataNotFoundException {
		Connection connection = null;
		
		try {
			connection = ConnectToDataBase.makeConnnection();
			
			PreparedStatement statement = connection.prepareStatement("delete from project where pid = ?");
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DataNotFoundException("Project Not found");
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