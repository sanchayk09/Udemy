package hibernatedmeo;

import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernatetutorial.Entity.Course;
import hibernatetutorial.Entity.Instructor;
import hibernatetutorial.Entity.InstructorDetail;
import hibernatetutorial.Entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		// Create Session factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//Create Session
		
		Session session=factory.getCurrentSession();
		try 
		{
			//use session object to save java object
			
			
			session.beginTransaction();
			Instructor tempinst=session.get(Instructor.class, 1);
			
			Course tempCourse=new Course("Art of Leading");
			Course tempCourse1=new Course("Learn New World");
			
			tempinst.Add(tempCourse);
			tempinst.Add(tempCourse1);
			
			
			session.save(tempCourse);
			session.save(tempCourse1);
			
			//commit transaction
			session.getTransaction().commit();
			
		}
		finally 
		{
			
			
			factory.close();
			
		}
 
	}

}
