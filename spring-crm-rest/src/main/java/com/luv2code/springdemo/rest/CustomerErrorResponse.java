package com.luv2code.springdemo.rest;

public class CustomerErrorResponse {

	private int status;
	private long timestamp;
	private String message;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public CustomerErrorResponse(int status, long timestamp, String message) {
		this.status = status;
		this.timestamp = timestamp;
		this.message = message;
	}
	public CustomerErrorResponse() {
	}
	
	
}
