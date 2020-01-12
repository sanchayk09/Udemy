package springMVC;

import java.util.LinkedHashMap;

public class Student {
	private String firstName;
	private String lastName;
	private String country;
	private LinkedHashMap<String,String> countryOption=new LinkedHashMap<String,String>();
	
	public Student()
	{
		countryOption.put("Bra", "Brazil");
		countryOption.put("Ind", "India");
		countryOption.put("Aus", "Austarlia");
		countryOption.put("Nz","Newzeland");
	}

	
	
	public LinkedHashMap<String, String> getCountryOption() {
		return countryOption;
	}

	public void setCountryOption(LinkedHashMap<String, String> countryOption) {
		this.countryOption = countryOption;
	}

	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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
