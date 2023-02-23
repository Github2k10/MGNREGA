package com.dao;

import java.util.Scanner;

import com.dto.Employee;
import com.exception.DataNotFoundException;
import com.exception.SomethingWentWrong;

public interface GPMDao {
	public void login(String id, String password, Scanner scanner) throws DataNotFoundException, SomethingWentWrong;
	
	public void createEmployee(Employee emp) throws SomethingWentWrong;
}
