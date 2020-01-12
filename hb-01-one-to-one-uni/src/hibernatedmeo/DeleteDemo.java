package hibernatedmeo;

import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernatetutorial.Entity.Instructor;
import hibernatetutorial.Entity.InstructorDetail;
import hibernatetutorial.Entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		// Create Session factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//Create Session
		
		Session session=factory.getCurrentSession();
		try 
		{
			//use session object to save java object
			
			//create a student object
			Instructor myInstructor=new Instructor("Chad","Darby","Luv2code@udemy.com");
			InstructorDetail newInstructorDetail=new InstructorDetail("Luv2code","Coding");
			myInstructor.setInstructorDetail(newInstructorDetail);
			//Start transaction
			session.beginTransaction();
			//save the student object
			session.save(myInstructor);
			//commit transaction
			session.getTransaction().commit();
			
		}
		finally 
		{
			
			
			factory.close();
			
		}
 
	}

}
