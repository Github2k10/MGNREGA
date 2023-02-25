package com.ui;

import java.util.List;
import java.util.Scanner;

import com.dao.EmployeeDoa;
import com.dao.GPMDao;
import com.dao.ProjectDoa;
import com.dto.Employee;
import com.dto.GPM;
import com.dto.Project;
import com.exception.DataNotFoundException;
import com.exception.SomethingWentWrong;

public class AfterLogin {

	// Gram Panchayat Member
	public static void forGPM(Scanner scanner) {
		Integer n = null;
		Integer p = null;
		
		do {
			System.out.println(
					"1. Create new Employee\n2. View details of Employee\n3. delete employee\n4. "
					+ "Assign Employee to a project\n5. Give wages to employee\n6. "
					+ "View total number of days worked in the project and also their wages\n7. Logut");
			boolean flag = false;

			int choise = Integer.parseInt(scanner.nextLine());

			switch (choise) {
			case 1:
				Employee employee = Input.forEmployee(scanner);

				try {
					EmployeeDoa.createEmployee(employee);
				} catch (SomethingWentWrong e) {
					System.out.println(e.getMessage());
				}
				break;

			case 2: System.out.println("Enter Employee Id: ");
					n = Integer.parseInt(scanner.nextLine());
					try {
						EmployeeDoa.viewDetails(n);
					} catch (DataNotFoundException |SomethingWentWrong e) {
						System.out.println(e.getMessage());
					}
					break;
					
			case 3: System.out.println("Enter Employee Id: ");
					n = Integer.parseInt(scanner.nextLine());
					try {
						EmployeeDoa.deleteEmployee(n);
					} catch (SomethingWentWrong e) {
						System.out.println(e.getMessage());
					}
					break;
				
			case 4: System.out.println("Enter Employee Id: ");
					n = Integer.parseInt(scanner.nextLine());
					
					System.out.println("Enter Project Id: ");
				    p = Integer.parseInt(scanner.nextLine());
				    
					try {
						EmployeeDoa.assignProjectToEmployee(n, p);
						System.out.println("Project assigned succuessfully to Employee");
					} catch (SomethingWentWrong e) {
						System.out.println(e.getMessage());
					}
					break;
				
			case 5: System.out.println("Enter Employee Id: ");
					n = Integer.parseInt(scanner.nextLine());
					
					System.out.println("Enter Project Id: ");
				    Double amount = Double.parseDouble(scanner.nextLine());
				
					try {
						EmployeeDoa.giveWagesToEmployee(p, amount);
						System.out.println("Wages given to Employee Successfully");
					} catch (SomethingWentWrong e) {
						System.out.println(e.getMessage());
					}
				
			case 6: 

			case 7:
				flag = true;
				break;
			default:
				System.out.println("Unexpected value: " + choise);
			}

			if (flag)
				break;
		} while (true);

		System.out.print("Logut successfully as GPM");
	}

	// Block Development Officer
	public static void forBDO(Scanner scanner) {
		Integer n = null;
		
		do {
			System.out.println(
					"\n1. Create Project\n2. view List of Project\n3. Create new GPM\n4. Delete project\n5. "
					+ "View all the GPM\n6. delete GPM\n7. Allocate project to GPM\n8. "
					+ "See list of employee working on that project and their wages\n9. Logout");
			boolean flag = false;

			int choise = Integer.parseInt(scanner.nextLine());

			switch (choise) {
			case 1:
				Project project = Input.forProject(scanner);
				try {
					ProjectDoa.createProject(project);
				} catch (SomethingWentWrong e) {
					e.printStackTrace();
				}
				break;

			case 2:
				try {
					List<Project> list = ProjectDoa.projectList();

					list.forEach(System.out::println);
				} catch (DataNotFoundException | SomethingWentWrong e) {
					e.printStackTrace();
				}
				break;

			case 3: GPM gpm = Input.forGPM(scanner);
					
					try {
						GPMDao.createGPM(gpm);
						System.out.println("Gram Pancahayat Member created successfully");
					} catch (SomethingWentWrong e) {
						System.out.println(e.getMessage());
					}
					break;

			case 4: System.out.println("Enter project Id: ");
					n = Integer.parseInt(scanner.nextLine());
					
					try {
						ProjectDoa.deleteproject(n);
						System.out.println("Project Deleted Successfully");
					} catch (SomethingWentWrong e) {
						System.out.println(e.getMessage());
					}
					break;

			case 5: try {
						GPMDao.getListOffGPM();
					} catch (SomethingWentWrong | DataNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
					
			case 6: System.out.println("Enter Gram Panchayat Member Id: ");
					n = Integer.parseInt(scanner.nextLine());
					
					try {
						GPMDao.deleteGPM(n);
						System.out.println("Gram Panchayat Deleted successfully");
					} catch (SomethingWentWrong e) {
						System.out.println(e.getMessage());
					}
					break;
				
			case 7: System.out.println("Enter Gram Panchayat Member Id: ");
					n = Integer.parseInt(scanner.nextLine());
					
					System.out.println("Enter Gram Panchayat Member Id: ");
					int p = Integer.parseInt(scanner.nextLine());
					
					try {
						GPMDao.assignProjectToGPM(n, p);
						System.out.println("Project Assigned to Gram Panchayat");
					} catch (SomethingWentWrong e) {
						System.out.println(e.getMessage());
					}
				
			case 8:

			case 9:
				flag = true;
				System.out.print("Logut successfully as BDO");
				break;
			default:
				System.out.println("Unexpected value: " + choise);
			}

			if (flag)
				break;
		} while (true);

	}
}
