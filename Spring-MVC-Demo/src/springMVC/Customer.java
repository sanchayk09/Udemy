package springMVC;

import javax.validation.constraints.*;


public class Customer {

	public Customer() {
		
	}
	
	private String firstName;
	@NotNull(message="Is Required")
	@Size(min=1, message="Is Required")
	private String lastName;
	@Min(value=1,message="Must not be grater than 0")
	@Max(value=10,message="Must not be less than 11")
	
	private int freePasses;
	public int getFreePasses() {
		return freePasses;
	}
	public void setFreePasses(int freePasses) {
		this.freePasses = freePasses;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
