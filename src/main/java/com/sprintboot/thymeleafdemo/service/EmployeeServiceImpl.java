package com.sprintboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprintboot.thymeleafdemo.dao.EmployeeRepository;
import com.sprintboot.thymeleafdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	//CONSTRUCTOR INJECTION
	@Autowired
	public EmployeeServiceImpl (EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		if(result.isPresent()) {
			theEmployee = result.get();
		}else {
			throw new RuntimeException("Did not found employee id - "+theId);
		}
		
		return theEmployee;
	}

	@Override
	public void addEmployee(Employee theEmployee) {
		this.employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteEmployeeById(int theId) {
		this.employeeRepository.deleteById(theId);
	}
	

}
