package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.dto.Project;
import com.exception.SomethingWentWrong;

public class ProjectDoa {
	public static boolean createProject(Project project) throws SomethingWentWrong {
		Connection connection = null;
		
		try {
			connection  = ConnectToDataBase.makeConnnection();
			PreparedStatement statement = connection.prepareStatement("insert into project (pname, pcost) values (?, ?)");
			
			statement.setString(1, project.getPname());
			statement.setDouble(2, project.getPcost());
			
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
	
	
	public static List<Project> projectList(){
		
	}
}
