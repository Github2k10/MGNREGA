package com.ui;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.println("1. Login as BDO\n2. Login as Gram Panchayat Member\n99. Exit");
			int choice = Integer.parseInt(scanner.nextLine());
			boolean flag = false;
			switch(choice) {
			case 99 : flag = true;
					 break;
			
			case 1 : System.out.println("Enter DBO userId: ");
					 String userId = scanner.nextLine();
					 System.out.println("Enter DBO password: ");
					 String password = scanner.nextLine();
					 
					 login.DBOLogin(userId, password);
					 break;
			
			default : System.out.println("invalid input!!!!\n");
			}
			
			if(flag) {
				break;
			}
		} while (true);
		
		System.out.print("Thank you for visting");
		scanner.close();
	}

}
