package com.dao;

import com.dto.Employee;
import com.exception.DataNotFoundException;
import com.exception.SomethingWentWrong;

public interface GPMDao {
	public void login(String id, String password) throws DataNotFoundException, SomethingWentWrong;
	
	public void createEmployee(Employee emp) throws SomethingWentWrong;
}
