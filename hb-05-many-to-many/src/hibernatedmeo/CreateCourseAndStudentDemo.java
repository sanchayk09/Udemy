package hibernatedmeo;

import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernatetutorial.Entity.Course;
import hibernatetutorial.Entity.Instructor;
import hibernatetutorial.Entity.InstructorDetail;
import hibernatetutorial.Entity.Review;
import hibernatetutorial.Entity.Student;

public class CreateCourseAndStudentDemo {

	public static void main(String[] args) {
		// Create Session factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		//Create Session
		
		Session session=factory.getCurrentSession();
		try 
		{	
			session.beginTransaction();
			Student std=session.get(Student.class,11);
			
			
			System.out.println(std);
			
			System.out.println("\n\n******************\n\n");
			System.out.println(std.getCourses());
			
			session.getTransaction().commit();
			
		}
		finally 
		{
			
			session.close();
			factory.close();
		}
 
	}

}
