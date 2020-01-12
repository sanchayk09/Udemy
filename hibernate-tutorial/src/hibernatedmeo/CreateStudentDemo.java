package hibernatedmeo;

import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernatetutorial.Entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// Create Session factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
		//Create Session
		
		Session session=factory.getCurrentSession();
		try 
		{
			//use session object to save java object
			
			//create a student object
			Student tempstud=new Student("Sachin","Tendulkar","sachink09@gmail.com");
			//Start transaction
			session.beginTransaction();
			//save the student object
			session.save(tempstud);
			//commit transaction
			session.getTransaction().commit();
			
		}
		finally 
		{
			factory.close();
			
		}
 
	}

}
