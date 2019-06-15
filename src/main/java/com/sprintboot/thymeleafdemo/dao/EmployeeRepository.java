package com.sprintboot.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprintboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
