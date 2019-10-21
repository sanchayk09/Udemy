package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.*;
import java.util.*;
public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public  void save(Employee emp);
	public void delete(int id);
	
	

}
