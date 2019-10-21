package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


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

}
