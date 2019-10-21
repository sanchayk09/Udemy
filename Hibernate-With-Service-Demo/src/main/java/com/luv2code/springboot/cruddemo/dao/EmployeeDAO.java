package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	
	public Employee findByID(int id);
	
	public void save(Employee theEmployee);
	
	public void deleteByID(int id);

}
