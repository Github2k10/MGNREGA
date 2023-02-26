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
					"\n1. Create new Employee\n2. View details of Employee\n3. delete employee\n4. "
					+ "Assign Employee to a project\n5. Give wages to employee\n6. "
					+ "View total number of days worked in the project and also their wages\n7. Logut\n");
			System.out.print("Enter selection: ");
			boolean flag = false;

			int choise = Integer.parseInt(scanner.nextLine());

			switch (choise) {
			case 1:
				Employee employee = Input.forEmployee(scanner);

				try {
					EmployeeDoa.createEmployee(employee);
					System.out.println("\n\n***************************************************");
					System.out.println("       Employee Created Successfully         ");
					System.out.println("***************************************************");
				} catch (SomethingWentWrong e) {
					System.out.println(e.getMessage());
				}
				break;

			case 2: System.out.println("Enter Employee Id: ");
					try {
						n = Integer.parseInt(scanner.nextLine());
					} catch(Exception ex) {
						System.out.println("Invalid Input!!!");
						continue;
					}
					try {
						Employee emp =  EmployeeDoa.viewDetails(n);
						
						System.out.println(emp.toString());
					} catch (DataNotFoundException |SomethingWentWrong e) {
						System.out.println(e.getMessage());
					}
					break;
					
			case 3: System.out.println("Enter Employee Id: ");
					try {
						n = Integer.parseInt(scanner.nextLine());
					} catch(Exception ex) {
						System.out.println("Invalid Input!!!");
						continue;
					}
					try {
						EmployeeDoa.deleteEmployee(n);
					} catch (SomethingWentWrong e) {
						System.out.println(e.getMessage());
					}
					break;
				
			case 4: System.out.println("Enter Employee Id: ");
					try {
						n = Integer.parseInt(scanner.nextLine());
					} catch(Exception ex) {
						System.out.println("Invalid Input!!!");
						continue;
					}
					
					System.out.println("Enter Project Id: ");
				    try {
						p = Integer.parseInt(scanner.nextLine());
					} catch(Exception ex) {
						System.out.println("Invalid Input!!!");
						continue;
					}
				    
					try {
						EmployeeDoa.assignProjectToEmployee(n, p);
						System.out.println("Project assigned succuessfully to Employee");
					} catch (SomethingWentWrong e) {
						System.out.println(e.getMessage());
					}
					break;
				
			case 5: System.out.println("Enter Employee Id: ");
					try {
						n = Integer.parseInt(scanner.nextLine());
					} catch(Exception ex) {
						System.out.println("Invalid Input!!!");
						continue;
					}
					
					System.out.println("Enter Project Id: ");
				    Double amount = Double.parseDouble(scanner.nextLine());
				
					try {
						EmployeeDoa.giveWagesToEmployee(n, amount);
						System.out.println("Wages given to Employee Successfully");
					} catch (SomethingWentWrong | DataNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				
			case 6: 

			case 7:
				flag = true;
				break;
			
			default: System.out.println("\n\n****************************************************************");
	 		 		 System.out.println("                    Unexpected value: " + choise + "                ");
	 		 		 System.out.println("****************************************************************\n");
	 		 		 
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
			
			System.out.print("\nEnter selection: ");
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

					System.out.println("\n**************************************************************\n");
					list.forEach(System.out::println);
					System.out.println("\n**************************************************************");
				} catch (DataNotFoundException | SomethingWentWrong e) {
					e.printStackTrace();
				}
				break;

			case 3: GPM gpm = Input.forGPM(scanner);
					
					try {
						GPMDao.createGPM(gpm);
						System.out.println("\n\n****************************************************************");
						System.out.println("       Gram Pancahayat Member created successfully         ");
						System.out.println("****************************************************************");
					} catch (SomethingWentWrong e) {
						System.out.println(e.getMessage());
					}
					break;

			case 4: System.out.print("\nEnter project Id: ");try {
						n = Integer.parseInt(scanner.nextLine());
					} catch(Exception ex) {
						System.out.println("Invalid Input!!!");
						continue;
					}
					
					try {
						ProjectDoa.deleteproject(n);
						System.out.println("\n\n****************************************************************");
						System.out.println("                Project Deleted Successfully               ");
						System.out.println("****************************************************************");
					} catch (SomethingWentWrong | DataNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;

			case 5: try {
						List<GPM> list = GPMDao.getListOffGPM();
						System.out.println("\n****************************************************************************************************************************************************\n");
						list.forEach(System.out::println);
						System.out.println("\n****************************************************************************************************************************************************");
						
					} catch (SomethingWentWrong | DataNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
					
			case 6: System.out.print("\nEnter Gram Panchayat Member Id: ");try {
						n = Integer.parseInt(scanner.nextLine());
					} catch(Exception ex) {
						System.out.println("Invalid Input!!!");
						continue;
					}
					
					try {
						GPMDao.deleteGPM(n);
						System.out.println("\n\n****************************************************************");
						System.out.println("              Gram Panchayat Deleted successfully             ");
						System.out.println("****************************************************************");
					} catch (SomethingWentWrong e) {
						System.out.println(e.getMessage());
					}
					break;
				
			case 7: System.out.print("\nEnter Gram Panchayat Member Id: ");
					try {
						n = Integer.parseInt(scanner.nextLine());
					} catch(Exception ex) {
						System.out.println("Invalid Input!!!");
						continue;
					}
					
					System.out.print("Enter Gram Panchayat Member Id: ");
					int p = 0;
					try {
						p = Integer.parseInt(scanner.nextLine());
					} catch(Exception ex) {
						System.out.println("Invalid Input!!!");
						continue;
					}
					
					try {
						GPMDao.assignProjectToGPM(n, p);
						System.out.println("\n\n****************************************************************");
						System.out.println("              Project Assigned to Gram Panchayat             ");
						System.out.println("****************************************************************");
					} catch (SomethingWentWrong e) {
						System.out.println(e.getMessage());
					}
					break;
				
			case 8: System.out.print("\nEnter Project Id: ");
					try {
						n = Integer.parseInt(scanner.nextLine());
					} catch(Exception ex) {
						System.out.println("Invalid Input!!!");
						continue;
					}
					
					try {
						System.out.println("\n**************************************************************\n");
						EmployeeDoa.listEmployeeWorkinigOnProject(n);
						System.out.println("\n**************************************************************");
					} catch (SomethingWentWrong | DataNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;

			case 9: flag = true;
					System.out.println("\n\n****************************************************************");
					System.out.println("                 Logut successfully as BDO                ");
					System.out.println("****************************************************************\n");
							break;
					
			default: System.out.println("\n\n****************************************************************");
			 		 System.out.println("                    Unexpected value: " + choise + "                ");
	  	 			 System.out.println("****************************************************************\n");
			}

			if (flag)
				break;
		} while (true);

	}
}
