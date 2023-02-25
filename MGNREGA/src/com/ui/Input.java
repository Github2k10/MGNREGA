package com.ui;

import java.time.LocalDate;
import java.util.Scanner;

import com.dto.Employee;
import com.dto.EmployeeImp;
import com.dto.GPM;
import com.dto.GPMImp;
import com.dto.Project;
import com.dto.ProjectImp;

public class Input {
	
	public static Employee forEmployee(Scanner scanner) {
		Employee employee = new EmployeeImp();
		
		System.out.println("Enter Employee Name: ");
		employee.setName(scanner.nextLine());
		
		System.out.println("Enter Employee Email Id: ");
		employee.setEmail(scanner.nextLine());
		
		System.out.println("Enter Employee Contac No:");
		employee.setContact(scanner.nextLine());
		
		System.out.println("Enter Date of Birth(YYYY-MM-DD): ");
		employee.setDob(LocalDate.parse(scanner.nextLine()));
		
		return employee;
	}
	
	public static GPM forGPM(Scanner scanner) {
		GPM gpm = new GPMImp();
		
		System.out.print("\nEnter Gram Panchayat Member Name: ");
		gpm.setName(scanner.nextLine());
		
		System.out.print("Enter Gram Panchayat Member Email Id: ");
		gpm.setEmail(scanner.nextLine());
		
		System.out.print("Enter Gram Panchayat Member Contac No:");
		gpm.setContact(scanner.nextLine());
		
		System.out.print("Enter Gram Panchayat Member District: ");
		gpm.setDistrict(scanner.nextLine());
		
		System.out.print("Enter Gram Panchayat Member State: ");
		gpm.setState(scanner.nextLine());
		
		System.out.print("Set Password(Max 12 digits): ");
		gpm.setPassword(scanner.nextLine());
		
		return gpm;
	}
	
	
	public static Project forProject(Scanner scanner) {
		Project project = new ProjectImp();
		
		System.out.print("Enter Project Name: ");
		project.setPname(scanner.nextLine());
		
		System.out.print("Enter Project Cost to build: ");
		project.setPcost(Double.parseDouble(scanner.nextLine()));
		
		return project;
	}
}
