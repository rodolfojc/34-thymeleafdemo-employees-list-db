package com.sprintboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sprintboot.thymeleafdemo.entity.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	// LOAD EMPLOYEE DATA
	private List<Employee> theEmployees;
	
	@PostConstruct
	private void loadData() {
		
		//CREATE EMPLOYEES
		Employee tempEmployee1 = new Employee(1, "Rodolfo", "Carvajal", "rodolfo@rodolfo.com");
		Employee tempEmployee2 = new Employee(2, "Juan", "Velasquez", "juan@juan.com");
		Employee tempEmployee3 = new Employee(3, "Cesar", "Padron", "cesar@cesar.com");
		
		//CREATE LIST
		theEmployees = new ArrayList<>();
				
		//ADD TO THE LIST
		theEmployees.add(tempEmployee1);
		theEmployees.add(tempEmployee2);
		theEmployees.add(tempEmployee3);
		
	}
	
	// ADD MAPPING "/LIST"
	@GetMapping("/list")
	public String listEmployees (Model theModel) {
		
		// ADD TO THE SPRING MODEL
		theModel.addAttribute("employees", theEmployees);
		
		return "list-employees";
	}
}
