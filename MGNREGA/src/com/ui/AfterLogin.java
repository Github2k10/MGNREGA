package com.ui;

import java.util.Scanner;

public class AfterLogin {
	
	
	public static void forGPM(Scanner scanner) {
		
		do {
			System.out.println("1. Create new Employee\n2. View details of Employee\n3. Assign Employee to a product\n4. View total number of days worked in the project and also their wages\n5. Logut");
			boolean flag = false;
			
			int choise = Integer.parseInt(scanner.nextLine());
			
			switch (choise) {
			case 1 : 
				
			case 2 :
				
			case 3 :
				
			case 4 :
				
			case 5 : flag = true;
			         break;
			default:
				System.out.println("Unexpected value: " + choise);
			}
			
			if(flag) break;
		} while (true);
		
		System.out.print("Logut successfully as GPM");
	}
	
public static void forBDO(Scanner scanner) {
		
		do {
			System.out.println("1. Create Project\n2. view List of Project\n3. Create new GPM\n4. View all the GPM\n5. Allocate project to GPM\n6. See list of employee working on that project and their wages\n7. Logout");
			boolean flag = false;
			
			int choise = Integer.parseInt(scanner.nextLine());
			
			switch (choise) {
			case 1 : 
				
			case 2 :
				
			case 3 :
				
			case 4 :
				
			case 5 :
			
			case 6 :
				
			case 7 : flag = true;
			         break;
			default:
				System.out.println("Unexpected value: " + choise);
			}
			
			if(flag) break;
		} while (true);
		
		System.out.print("Logut successfully as BDO");
	}
}
