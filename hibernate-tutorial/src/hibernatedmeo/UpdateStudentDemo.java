package hibernatedmeo;

import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernatetutorial.Entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// Create Session factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
		//Create Session
		
		Session session=factory.getCurrentSession();
		try 
		{
			// start a transaction
			//session.beginTransaction();
			
			/*Student std=session.get(Student.class, 12);
			std.setFirstName("Marshal");
			session.getTransaction().commit();
			System.out.println("Done!");*/
			
			session.beginTransaction();
			session.createQuery("Update Student set email='luv2Code@gmail.com'").executeUpdate();
			
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally 
		{
			factory.close();
			
		}
 
	}

}
