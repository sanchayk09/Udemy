package com.luv2code.springdemo.rest;

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

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers()
	{
		return customerService.getCustomers();
	}
	
	@GetMapping("/customers/{customerID}")
	public Customer getCustomers(@PathVariable int customerID)
	{
		Customer theCustomer=customerService.getCustomer(customerID);
		
		if(theCustomer==null)
			throw new CustomerNotFoundException("Customer not found  with ID :"+customerID);
		return theCustomer;
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer)
	{
		theCustomer.setId(0);
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer)
	{
		/*
		since id is not being provide here so hibernate will always do the update operation
		theCustomer.setId(0);*/
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	@DeleteMapping("/customers/{customerID}")
	public String deleteCustomers(@PathVariable int customerID)
	{
		customerService.deleteCustomer(customerID);
		
		
		return "Deleted Customer with Id :"+customerID;
	}
	
}
