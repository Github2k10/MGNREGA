package com.ui;

import java.util.List;
import java.util.Scanner;

import com.dao.EmployeeDoa;
import com.dao.ProjectDoa;
import com.dto.Employee;
import com.dto.Project;
import com.exception.DataNotFoundException;
import com.exception.SomethingWentWrong;

public class AfterLogin {

	// Gram Panchayat Member
	public static void forGPM(Scanner scanner) {
		Integer n = null;
		
		do {
			System.out.println(
					"1. Create new Employee\n2. View details of Employee\n3. delete employee\n4 Assign Employee to a product\n5. View total number of days worked in the project and also their wages\n6. Logut");
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

			case 4:

			case 5:
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
		do {
			System.out.println(
					"\n1. Create Project\n2. view List of Project\n3. Create new GPM\n4. View all the GPM\n5. Allocate project to GPM\n6. See list of employee working on that project and their wages\n7. Logout");
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

			case 3:

			case 4:

			case 5:

			case 6:

			case 7:
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
