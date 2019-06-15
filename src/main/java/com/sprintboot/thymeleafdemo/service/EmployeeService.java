package com.sprintboot.thymeleafdemo.service;

import java.util.List;

import com.sprintboot.thymeleafdemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void addEmployee(Employee theEmployee);
	
	public void deleteEmployeeById(int theId);
	
}
