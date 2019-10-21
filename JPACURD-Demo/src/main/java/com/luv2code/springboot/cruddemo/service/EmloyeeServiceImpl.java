package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public class EmloyeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;
	@Autowired
	public EmloyeeServiceImpl(EmployeeDAO theEmployeeDAO) {
		employeeDAO=theEmployeeDAO;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		
		return employeeDAO.findByID(id);
	}

	@Override
	@Transactional
	public void save(Employee emp) {
		
		employeeDAO.save(emp);
		
	}

	@Override
	@Transactional
	public void delete(int id) {
		
		employeeDAO.deleteByID(id);
	}

}
