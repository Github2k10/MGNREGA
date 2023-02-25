package com.ui;

import java.util.Scanner;

import com.dao.GPMDao;
import com.exception.DataNotFoundException;
import com.exception.SomethingWentWrong;

public class Login {
	private static final String DBOuserid;
	private static final String DBOpassword;
	
	static {
		DBOuserid = "admin";
		DBOpassword = "admin";
	}
	
	public static void DBOLogin(String id, String password, Scanner scanner) {
		if(DBOuserid.equals(id)) {
			if(DBOpassword.equals(password)) {
				System.out.println("\n\n******************************************************************");
				System.out.println("        Login successfully as Block Development Officer           ");
				System.out.println("******************************************************************");
				AfterLogin.forBDO(scanner);
			} else {
				System.out.println("\n\n**********************************");
				System.out.println("        Password Wrong!!!           ");
				System.out.println("**********************************\n");
			}
		} else {
			System.out.println("\n\n******************************");
			System.out.println("        User ID wrong           ");
			System.out.println("******************************\n");
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
