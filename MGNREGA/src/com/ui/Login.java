package com.ui;

import java.util.Scanner;

import com.dao.GPMDao;
import com.exception.DataNotFoundException;
import com.exception.SomethingWentWrong;

public class Login {
	private static final String DBOuserid;
	private static final String DBOpassword;
	
	static {
		DBOuserid = "abc";
		DBOpassword = "123";
	}
	
	public static void DBOLogin(String id, String password, Scanner scanner) {
		if(DBOuserid.equals(id)) {
			if(DBOpassword.equals(password)) {
				System.out.println("Login successfully as DBO");
				AfterLogin.forBDO(scanner);
			} else {
				System.out.println("Password Wrong!!!");
			}
		} else {
			System.out.println("User ID wrong");
		}
	}
	
	public static void GPMLogin(String id, String password, Scanner scanner) {
		try {
			GPMDao.login(id, password, scanner);
		} catch (DataNotFoundException | SomethingWentWrong e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
