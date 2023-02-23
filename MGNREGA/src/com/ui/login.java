package com.ui;


public class login {
	private static final String DBOuserid;
	private static final String DBOpassword;
	
	static {
		DBOuserid = "abc@gmail.com";
		DBOpassword = "abc@123";
	}
	
	public static void DBOLogin(String id, String password) {
		if(DBOuserid.equals(id)) {
			if(DBOpassword.equals(password)) {
				System.out.println("Login successfully as DBO");
			} else {
				System.out.println("Password Wrong!!!");
			}
		} else {
			System.out.println("User ID wrong");
		}
	}
	
	public static void GPMLogin(String id, String password) {
		
	}
}
