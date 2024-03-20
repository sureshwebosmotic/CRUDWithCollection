package com.demo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.demo.entity.Employee;
import com.demo.service.EmployeeService;
import com.demo.service.IEmployeeService;
// This Class is used for taking input from user and calling service method for CRUD operation. we are taking total three employees's details.
public class Main {

	public static void main(String[] args) {
		
		
				
		//used Scanner class for taking input from user
		Scanner scanner = new Scanner(System.in);
		IEmployeeService empService = new EmployeeService();

		
		
		Integer enteredNumber;
		
		do {
			menu();
			enteredNumber = scanner.nextInt();
			scanner.nextLine();
			switch (enteredNumber) {
			case 1:
				
				System.out.println("Enter Employee's name.");
				String empName = scanner.nextLine();
				
				System.out.println("Enter Employee's age, please don't enter any other data type's value.");
				Integer empAge = scanner.nextInt();
				scanner.nextLine();
				
				
				System.out.println("Enter Employee's skills in following formate (i.e. A,B,C) don't give any space.");
				String[] skills = scanner.nextLine().split(",");
				//defined list to store multiple skill for Employee.
				List<String> empSkills = new ArrayList<>(Arrays.asList(skills));

				System.out.println("Enter Employee's salary");
				String empSalary = scanner.nextLine();
				System.out.println("Enter First Employee's joining date in the form of 2008-07-09 (yyyy-mm-dd)");
				
				String empJoiningDate = scanner.nextLine();
				//prevent from storing the future joining date which is invalid.
				while(LocalDate.parse(empJoiningDate).isAfter(LocalDate.now())){
					System.out.println("please don't provide future joining date, enter valid joining date");
					empJoiningDate = scanner.nextLine();
				}
				
				Employee Emp = new Employee(empName, empSkills, empAge, empSalary, LocalDate.parse(empJoiningDate));
				Employee createdEmp = empService.createEmployee(Emp);
				System.out.println("created Employee :");
				System.out.println(createdEmp.toString());
				break;
			case 2:
				 
				System.out.println("Enter Employee's Id for retrive the employee");
				String empId = scanner.nextLine();
				Employee retrivedEmp = empService.retrieveEmployee(empId);
				System.out.println("retrived Employee:" +" "+ retrivedEmp.toString());
                break;
			case 3:
				System.out.println("Enter Employee's Id, which need to update");
				String empIdToUpdate = scanner.nextLine();
				
				System.out.println("update Employee's name.");
				String updateEmpName = scanner.nextLine();
				
				System.out.println("update Employee's age, please don't enter any other data type's value.");
				Integer updateEmpAge = scanner.nextInt();
				scanner.nextLine();
				
				System.out.println("update Employee's skills in following formate (i.e. A,B,C) don't give any space after comma.");
				String[] updateSkills = scanner.nextLine().split(",");
				//defined list to store multiple skill for Employee.
				List<String> updateEmpSkills = new ArrayList<>(Arrays.asList(updateSkills));

				System.out.println("update Employee's salary");
				String updateEmpSalary = scanner.nextLine();
				System.out.println("update Employee's joining date in the form of 2008-07-09 (yyyy-mm-dd)");
				
				String updateEmpJoiningDate = scanner.nextLine();
				//prevent from storing the future joining date which is invalid.
				while(LocalDate.parse(updateEmpJoiningDate).isAfter(LocalDate.now())){
					System.out.println("please don't provide future joining date, enter valid joining date");
					updateEmpJoiningDate = scanner.nextLine();
				}
				
				Employee updateEmp = new Employee(updateEmpName, updateEmpSkills, updateEmpAge, updateEmpSalary, LocalDate.parse(updateEmpJoiningDate));
				updateEmp.setEmployeeId(empIdToUpdate);
				String result = empService.updateEmployee(updateEmp, empIdToUpdate);
				System.out.println(result);
                break;
			case 4:
				 
				System.out.println("Enter Employee's Id for remove the employee");
				empId = scanner.nextLine();
				String removed = empService.deleteEmployee(empId);
				System.out.println(removed);
                break;
			case 5:
				 
				System.out.println("sorted Employees By age");
				empService.sortByAge();
                break;
			case 6:
				 
				List<Employee> employees = empService.retrieveEmployees();
				employees.forEach(emp -> System.out.println(emp.toString()));
                break;
			default:
				System.out.println("Invalid input");
				break;
			}
		}while(enteredNumber!=10);
		
		
	}
	
	public static void menu() {
		System.out.println("Enter 1 to add employee");
		System.out.println("Enter 2 to retrive employee by empId");
		System.out.println("Enter 3 to update employee");
		System.out.println("Enter 4 to delete employee by empId");
		System.out.println("Enter 5 to sort employees by age");
		System.out.println("Enter 6 to retrieve all employees");
		System.out.println("Enter 10 to exit the program.");
	}

}
