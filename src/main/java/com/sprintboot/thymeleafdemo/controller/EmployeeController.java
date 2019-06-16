package com.sprintboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sprintboot.thymeleafdemo.entity.Employee;
import com.sprintboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/list")
	public String listEmployees (Model theModel) {
		
		// GET EMPLOYEE FROM DB
		List<Employee>  theEmployees = employeeService.findAll();
		
		// ADD TO THE SPRING MODEL
		theModel.addAttribute("employees", theEmployees);
		
		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd (Model theModel) {
		
		//CREATE MODEL ATTRIBUTE TO BIND DATA
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
		
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		
		//SAVE THE EMPLOYEE
		this.employeeService.addEmployee(theEmployee);
		
		//USE A REDICRECT TO PREVENT DUPLICATE SUBMISSIONS - POST-REDIRECT-GET PATTERN
		return "redirect:/employees/list";
		
	}
	
	
	
	
}
