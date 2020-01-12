package hibernatedmeo;

import java.util.List;

import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernatetutorial.Entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// Create Session factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
		//Create Session
		
		Session session=factory.getCurrentSession();
		try 
		{
			session.beginTransaction();
			
			Student tempstud=session.get(Student.class, 12);
			tempstud.setFirstName("Robin");
			session.getTransaction().commit();
					
			System.out.println("Done!");
			
	
		}
		finally 
		{
			
			factory.close();
			
		}
 
	}

}
