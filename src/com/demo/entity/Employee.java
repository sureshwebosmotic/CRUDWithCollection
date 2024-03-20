package com.demo.entity;

import java.time.LocalDate;
import java.util.List;

public class Employee {

	private String employeeId;
	
	private String name;
	
	private List<String> skills;
	
	private Integer age;
	
	private String salary;
	
	private LocalDate joiningDate;
	
	public Employee() {
		
	}
	
	public Employee(String name, List<String> skills, Integer age, String salary, LocalDate joiningDate) {
		super();
		this.name = name;
		this.skills = skills;
		this.age = age;
		this.salary = salary;
		this.joiningDate = joiningDate;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", skills=" + skills + ", age=" + age
				+ ", salary=" + salary + ", joiningDate=" + joiningDate + "]";
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	
	
}
