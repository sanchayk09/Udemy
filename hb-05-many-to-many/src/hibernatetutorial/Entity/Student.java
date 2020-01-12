package hibernatetutorial.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int ID;
	@Column(name="first_Name")
	private String firstName;
	public Student( String firstName, String lastName, String emailAddress) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "Student [ID=" + ID + ", firstName=" + firstName + ", lastName=" + lastName + ", emailAddress="
				+ emailAddress + "]";
	}

	@Column(name="last_Name")
	private String lastName;
	@Column(name="email")
	private String emailAddress;

	@ManyToMany(fetch=FetchType.LAZY,cascade=
		{CascadeType.MERGE,
		CascadeType.PERSIST,CascadeType.REFRESH}	
		)

	@JoinTable(
		name="course_student",
				joinColumns=@JoinColumn(name="student_id"),
						inverseJoinColumns=@JoinColumn(name="course_id")
		
		
		)

	private List<Course> courses;

	
	public List<Course> getCourses() {
		return courses;
	}

	public void addCourse(Course theCourse)
	{
		if(courses==null)
			courses=new ArrayList<>();
		courses.add(theCourse);
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Student()
	{
		
	}



}
