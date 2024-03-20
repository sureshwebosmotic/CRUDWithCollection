package com.demo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.demo.entity.Employee;
import com.demo.service.EmployeeService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("");
		List<String> skills1 = new ArrayList<>();
		
		
		List<String> skills2 = new ArrayList<>();
		
		List<String> skills3 = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First Employee's name");
		String empName = sc.nextLine();
		System.out.println("Enter First Employee's age");

		Integer age = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter First Employee's skill no 1");
		
		String inSkills1 = sc.nextLine();
		
		
		
		System.out.println("Enter First Employee's skill no 2");
		String inSskills2 = sc.nextLine();
		skills1.add(inSkills1);
		skills1.add(inSskills2);

		System.out.println("Enter First Employee's salary");

		String salary = sc.nextLine();
		System.out.println("Enter First Employee's joining date in the form of 2008-07-09 (yyyy-mm-dd)");

		String joiningdate = sc.nextLine();
		
		System.out.println("Enter Second Employee's name");
		String empName1 = sc.nextLine();
		System.out.println("Enter Second Employee's age");

		Integer age1 = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Second Employee's skill no 1");
		String inSkills3 = sc.nextLine();
		skills2.add(inSkills3);
		System.out.println("Enter Second Employee's skill no 2");
		String inSskills4 = sc.nextLine();
		skills2.add(inSskills4);
		System.out.println("Enter Second Employee's salary");

		String salary1 = sc.nextLine();
		System.out.println("Enter Second Employee's joining date in the form of 2008-07-09 (yyyy-mm-dd)");

		String joiningdate1 = sc.nextLine();
		
		System.out.println("Enter Third Employee's name");
		String empName2 = sc.nextLine();
		System.out.println("Enter Third Employee's age");

		Integer age2 = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Third Employee's skill no 1");
		String inSkills5 = sc.nextLine();
		skills3.add(inSkills5);
		System.out.println("Enter Third Employee's skill no 2");
		String inSskills6 = sc.nextLine();
		skills3.add(inSskills6);
		System.out.println("Enter Third Employee's salary");

		String salary2 = sc.nextLine();
		System.out.println("Enter Third Employee's joining date in the form of 2008-07-09 (yyyy-mm-dd)");

		String joiningdate2 = sc.nextLine();
		Employee emp1 = new Employee(empName, skills1, age, salary, LocalDate.parse(joiningdate));
		Employee emp2 = new Employee(empName1, skills2, age1, salary1, LocalDate.parse(joiningdate1));
		Employee emp3 = new Employee(empName2, skills3, age2, salary2, LocalDate.parse(joiningdate2));
//		Employee emp4 = new Employee("Shyam", skills2, 32, "20000", LocalDate.parse("2009-09-07"));
//		Employee emp5 = new Employee("Joe", skills1, 41, "25000", LocalDate.parse("2006-05-05"));
//		Employee emp6 = new Employee("Jack", skills2, 23, "46000", LocalDate.parse("2013-11-11"));
//		Employee emp7 = new Employee("Ram", skills1, 35, "43300", LocalDate.parse("2015-08-25"));
//		Employee emp8 = new Employee("Manas", skills2, 39, "18500", LocalDate.parse("2022-03-17"));

		EmployeeService empService = new EmployeeService();
		Employee createdEmp1 = empService.createEmployee(emp1);
		Employee createdEmp2 = empService.createEmployee(emp2);
		Employee createdEmp3 = empService.createEmployee(emp3);
//		Employee createdEmp4 = empService.createEmployee(emp4);
//		Employee createdEmp5 = empService.createEmployee(emp5);
//		Employee createdEmp6 = empService.createEmployee(emp6);
//		Employee createdEmp7 = empService.createEmployee(emp7);
//		Employee createdEmp8 = empService.createEmployee(emp8);

		System.out.println("created Employees :");
		System.out.println(createdEmp1.toString());
		System.out.println(createdEmp2.toString());
		System.out.println(createdEmp3.toString());
//		System.out.println(createdEmp4.toString());
//		System.out.println(createdEmp5.toString());
//		System.out.println(createdEmp6.toString());
//		System.out.println(createdEmp7.toString());
//		System.out.println(createdEmp8.toString());
		System.out.println("");

		System.out.println("Enter Employee's Id for Updating the details");
		String empId = sc.nextLine();
		System.out.println("update Employee's salary");
		String empSalary = sc.nextLine();
		createdEmp1.setSalary(empSalary);
		String result = empService.updateEmployee(createdEmp1, empId);
		System.out.println("updated");
		System.out.println(result);
		System.out.println("");

		System.out.println("Enter Employee's Id for retrive the employee");
		String empIdFR = sc.nextLine();
		
		Employee retrivedEmp = empService.retrieveEmployee(empIdFR);
		System.out.println("retrived Employee:" +" "+ retrivedEmp.toString());
		System.out.println("");

		System.out.println("Enter Employee's Id for remove the employee");
		String empIdFD = sc.nextLine();
		String removed = empService.deleteEmployee(empIdFD);
		System.out.println("removed : ");

		System.out.println(removed);
		System.out.println("");

		System.out.println("Enter Sort for sorting the employees by age");
		String sort = sc.nextLine();
		if(sort.equals(sort)) {
			System.out.println("sorted Employees By age");
			empService.sortByAge();
		}else {
			System.out.println("Input is wrong.");
		}
	}

}
