package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.demo.entity.Employee;
//This is a service class used for providing business logic.
public class EmployeeService implements IEmployeeService{

	// made the list to store the employees.
	List<Employee> emps = new ArrayList<Employee>();
	
	// to create the employee.
	@Override
	public Employee createEmployee(Employee employee) {
		
		employee.setEmployeeId(UUID.randomUUID().toString());
		emps.add(employee);
		return employee;
	}
	
	// to update the employee, if empId is wrong will print the reason and return null.
	@Override
	public String updateEmployee(Employee employee, String empId) {
		for(int i=0; i<emps.size(); i++) {
			if(emps.get(i).getEmployeeId().equals(empId)) {
				employee.setEmployeeId(empId);
				emps.set(i, employee);
				return "Employee updated Successfully of empId : " + empId;
			}
		}
		System.out.println("EMPLOYEE DOES NOT EXIST WITH EMPID : " + empId);
		return null;
	}
	
	//to delete the employee by empId, if empId is wrong will print the reason and return null.
	@Override
	public String deleteEmployee(String empId) {
		
		for(int i=0; i<emps.size(); i++) {
			if(emps.get(i).getEmployeeId().equals(empId)) {
				emps.remove(emps.get(i));
				return "Employee removed Successfully of empId : " + empId;
			}
		}
		System.out.println("EMPLOYEE DOES NOT EXIST WITH EMPID : " + empId);
		return null;
	}
	
	//to retrieve the employee by empId, if empId is wrong will print the reason and return null.
	@Override
	public Employee retrieveEmployee(String empId) {
		
		for(int i=0; i<emps.size(); i++) {
			if(emps.get(i).getEmployeeId().equals(empId)) {
				return emps.get(i);
			}
		}
		System.out.println("EMPLOYEE DOES NOT EXIST WITH EMPID : " + empId);
		return null;
	}
	
	// to sort the employees by their age.
	@Override
	public void sortByAge() {
		int n = emps.size();
		for(int i=0; i<n; i++) {
			
			for(int j=0; j<n-i-1; j++) {
				if(emps.get(j).getAge()>emps.get(j+1).getAge()) {
					Employee tempEmp = emps.get(j);
					emps.set(j, emps.get(j+1));
					emps.set(j+1, tempEmp);
				}
			}
		}
		
		emps.forEach(emp->{
			System.out.println(emp);
		});
	}
}
