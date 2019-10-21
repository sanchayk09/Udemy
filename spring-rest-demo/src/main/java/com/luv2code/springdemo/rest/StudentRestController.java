package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> stdList;
	@PostConstruct
	public void LoadData()
	{
		 stdList=new ArrayList<Student>();
		stdList.add(new Student(1,"Saurav","Ganguly"));
		stdList.add(new Student(2,"Sachin","Tendulkar"));
		stdList.add(new Student(3,"Mitali","Raj"));
		stdList.add(new Student(4,"Rahul","Dravid"));
		
	}
	@GetMapping("/student")
	public List<Student> getStudents()
	{
		return stdList;
	}

	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable int id)
	{
		if(id>stdList.size() || id<0)
			throw new StudentNotFoundException("Student Not Found :" + id);
		return stdList.get(id);
	}
	/*Moved these codes to Global exception handler part
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException   ex)
	{
		StudentErrorResponse sp=new StudentErrorResponse();
		sp.setStatus(HttpStatus.NOT_FOUND.value());
		sp.setMessage(ex.getMessage());
		sp.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(sp,HttpStatus.NOT_FOUND);
				
	}

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleGenericException(Exception   ex)
	{
		StudentErrorResponse sp=new StudentErrorResponse();
		sp.setStatus(HttpStatus.BAD_REQUEST.value());
		sp.setMessage(ex.getMessage());
		sp.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(sp,HttpStatus.BAD_REQUEST);
				
	}
	*/
}
