package hibernatedmeo;

import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernatetutorial.Entity.Instructor;
import hibernatetutorial.Entity.InstructorDetail;
import hibernatetutorial.Entity.Student;

public class GetInstructorDetailsDemo {

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
			
			session.beginTransaction();
			InstructorDetail instdet=session.get(InstructorDetail.class, 8);
			System.out.println(instdet);
			System.out.println("\n\n***********\n\n"+instdet.getInstructor());
			session.getTransaction().commit();
			
		}
		finally 
		{
			
			
			factory.close();
			
		}
 
	}

}
