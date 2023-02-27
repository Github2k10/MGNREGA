package com.ui;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("=============================Welcome to MGNREGA Project=============================\n");
		
		do {
			System.out.println("1. Login as Block Development Officer\n2. Login as Gram Panchayat Member\n99. Exit\n");
			System.out.print("Enter selection: ");
			Integer choice = 98;
			try {
				choice = Integer.parseInt(scanner.nextLine());
			} catch(Exception ex) {
				
			}
			
			boolean flag = false;
			String userId = null;
			String password = null;
			
			switch(choice) {
			case 99 : flag = true;
					 break;
			
			case 1 : System.out.print("\nEnter DBO userId: ");
					 userId = scanner.nextLine();
					 System.out.print("Enter DBO password: ");
					 password = scanner.nextLine();
					 
					 Login.DBOLogin(userId, password, scanner);
					 break;
			
			case 2 : System.out.print("Enter GPM userId: ");
					 userId = scanner.nextLine();
					 System.out.print("Enter GPM password: ");
					 password = scanner.nextLine();	
					 
					 Login.GPMLogin(userId, password, scanner);
					 break;
			
			default : System.out.println("invalid input!!!!\n\n");
			}
			
			if(flag) {
				break;
			}
		} while (true);
		
		
		System.out.println("\n\n****************************************************************");
		System.out.println("                  Thank you for visting");
		System.out.println("****************************************************************\n");
		scanner.close();
	}

}
 
