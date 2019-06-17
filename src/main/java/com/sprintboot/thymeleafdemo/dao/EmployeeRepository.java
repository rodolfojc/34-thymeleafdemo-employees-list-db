package com.sprintboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprintboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//ADDD METHOD TO SORT BY LAST NAME 
	public List<Employee> findAllByOrderByLastNameAsc();
	
}
