package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;
	@Autowired
	public EmployeeRestController(EmployeeService theemployeeService) {
		employeeService=theemployeeService;
	}

	@GetMapping("/employees")
	public List<Employee> EmployeeList()
	{
		return employeeService.findAll();
	}
	@GetMapping("/employees/{employeeID}")
	public Employee findByID(@PathVariable int employeeID)
	{
		Employee emp=employeeService.findById(employeeID);
		if(emp==null)
			throw new RuntimeException("null not excepted");
		return emp; 
	}
	@PostMapping("/employees")
	public void addEmployee(@RequestBody Employee theemp)
	{
		theemp.setId(0);
		employeeService.save(theemp);
	}
	@PutMapping("/employees")
	public void updateEmployee(@RequestBody Employee theemp)
	{
		
		employeeService.save(theemp);
	}
	
	@DeleteMapping("/employees/{empID}")
	public String deleteEmployee(@PathVariable int empID)
	{
		Employee emp=employeeService.findById(empID);
		if(emp==null)
			throw new RuntimeException("Employee not found");
		employeeService.delete(empID);
		return "Deleted Employee with id: "+ empID;
		
	}
	
}
