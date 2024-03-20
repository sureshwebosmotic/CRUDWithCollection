package com.demo.service;

import java.util.List;

import com.demo.entity.Employee;

// This interface is used for defining service methods which service class will implement.
public interface IEmployeeService {

	// to create the employee.
	public Employee createEmployee(Employee employee);
	
	// to update the employee, if empId is wrong will print the reason and return null.
	public String updateEmployee(Employee employee, String empId);
	
	//to delete the employee by empId, if empId is wrong will print the reason and return null.
	public String deleteEmployee(String empId);
	
	//to retrieve the employee by empId, if empId is wrong will print the reason and return null.
	public Employee retrieveEmployee(String empId);
	
	// to sort the employees by their age.
	public void sortByAge();
	
	//to retrieve all the employees.
	public List<Employee> retrieveEmployees();
}
