package com.demo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.demo.entity.Employee;
import com.demo.service.EmployeeService;
import com.demo.service.IEmployeeService;
// This Class is used for taking input from user and calling service method for CRUD operation. we are taking total three employees's details.
public class Main {

	public static void main(String[] args) {
		//defined list to store multiple skill for first Employee.
		List<String> firstEmpSkills = new ArrayList<>();
		
		//defined list to store multiple skill for second Employee.
		List<String> secondEmpSkills = new ArrayList<>();
		
		//defined list to store multiple skill for third Employee.
		List<String> thirdEmpSkills = new ArrayList<>();
		
		//used Scanner class for taking input from user
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter First Employee's name");
		
		String firstEmpName = scanner.nextLine();
		System.out.println("Enter First Employee's age, please don't enter any other data type's value.");
		
		Integer firstEmpAge = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter First Employee's skill no 1");
		
		String skill = scanner.nextLine();
		
		firstEmpSkills.add(skill);
		
		System.out.println("Enter First Employee's skill no 2");
		skill = scanner.nextLine();
		
		firstEmpSkills.add(skill);

		System.out.println("Enter First Employee's salary");

		String firstEmpSalary = scanner.nextLine();
		System.out.println("Enter First Employee's joining date in the form of 2008-07-09 (yyyy-mm-dd)");
		
		String firstEmpJoiningDate = scanner.nextLine();
		//prevent from storing the future joining date which is invalid.
		while(LocalDate.parse(firstEmpJoiningDate).isAfter(LocalDate.now())){
			System.out.println("please don't provide future joining date, enter valid joining date");
			firstEmpJoiningDate = scanner.nextLine();
		}
		System.out.println("Enter Second Employee's name");
		String secondEmpName = scanner.nextLine();
		
		System.out.println("Enter Second Employee's age, please don't enter any other data type's value.");
		Integer secondEmpAge = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Enter Second Employee's skill no 1");
		skill = scanner.nextLine();
		secondEmpSkills.add(skill);
		
		System.out.println("Enter Second Employee's skill no 2");
		skill = scanner.nextLine();
		secondEmpSkills.add(skill);
		
		System.out.println("Enter Second Employee's salary");
		String secondEmpsalary = scanner.nextLine();
		
		System.out.println("Enter Second Employee's joining date in the form of 2008-07-09 (yyyy-mm-dd)");
		String secondEmpJoiningDate = scanner.nextLine();
		//prevent from storing the future joining date which is invalid.
		while(LocalDate.parse(secondEmpJoiningDate).isAfter(LocalDate.now())){
			System.out.println("please don't provide future joining date, enter valid joining date");
			secondEmpJoiningDate = scanner.nextLine();
		}
		
		System.out.println("Enter Third Employee's name");
		String thirdEmpName = scanner.nextLine();
		
		System.out.println("Enter Third Employee's age, please don't enter any other data type's value.");
		Integer thirdEmpAge = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Enter Third Employee's skill no 1");
		skill = scanner.nextLine();
		thirdEmpSkills.add(skill);
		
		System.out.println("Enter Third Employee's skill no 2");
		skill = scanner.nextLine();
		thirdEmpSkills.add(skill);
		
		System.out.println("Enter Third Employee's salary");
		String thirdEmpsalary = scanner.nextLine();
		
		System.out.println("Enter Third Employee's joining date in the form of 2008-07-09 (yyyy-mm-dd)");
		String thirdEmpJoiningDate = scanner.nextLine();
		//prevent from storing the future joining date which is invalid.
		while(LocalDate.parse(thirdEmpJoiningDate).isAfter(LocalDate.now())){
			System.out.println("please don't provide future joining date, enter valid joining date");
			thirdEmpJoiningDate = scanner.nextLine();
		}
		
		Employee firstEmp = new Employee(firstEmpName, firstEmpSkills, firstEmpAge, firstEmpSalary, LocalDate.parse(firstEmpJoiningDate));
		Employee secondEmp = new Employee(secondEmpName, secondEmpSkills, secondEmpAge, secondEmpsalary, LocalDate.parse(secondEmpJoiningDate));
		Employee thirdEmp = new Employee(thirdEmpName, thirdEmpSkills, thirdEmpAge, thirdEmpsalary, LocalDate.parse(thirdEmpJoiningDate));

		
		IEmployeeService empService = new EmployeeService();
		Employee createdFirstEmp = empService.createEmployee(firstEmp);
		Employee createdSecondEmp = empService.createEmployee(secondEmp);
		Employee createdThirdEmp = empService.createEmployee(thirdEmp);

		System.out.println("created Employees :");
		System.out.println(createdFirstEmp.toString());
		System.out.println(createdSecondEmp.toString());
		System.out.println(createdThirdEmp.toString());

		//used this for providing line space
		System.out.println("");

		System.out.println("Enter Employee's Id for Updating the details");
		String empId = scanner.nextLine();
		
		System.out.println("update Employee's salary");
		String empSalary = scanner.nextLine();
		//we are updating only one field for now which is salary.
		Employee tobeUpdateEmp = new Employee(firstEmpName, firstEmpSkills, firstEmpAge, empSalary, LocalDate.parse(firstEmpJoiningDate));
		tobeUpdateEmp.setEmployeeId(empId);
		String result = empService.updateEmployee(tobeUpdateEmp, empId);
		System.out.println("updated");
		System.out.println(result);
		
		System.out.println("");

		System.out.println("Enter Employee's Id for retrive the employee");
		empId = scanner.nextLine();
		
		Employee retrivedEmp = empService.retrieveEmployee(empId);
		System.out.println("retrived Employee:" +" "+ retrivedEmp.toString());
		
		System.out.println("");

		System.out.println("Enter Employee's Id for remove the employee");
		empId = scanner.nextLine();
		String removed = empService.deleteEmployee(empId);
		System.out.println("removed : ");
		System.out.println(removed);
		
		System.out.println("");

		System.out.println("Enter Sort for sorting the employees by age");
		String sort = scanner.nextLine();
		if (sort.equalsIgnoreCase("Sort")) {
			System.out.println("sorted Employees By age");
			empService.sortByAge();
		} else {
			System.out.println("Input is wrong.");
		}
	}

}
