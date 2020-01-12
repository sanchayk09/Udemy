package hibernatedmeo;

import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernatetutorial.Entity.Course;
import hibernatetutorial.Entity.Instructor;
import hibernatetutorial.Entity.InstructorDetail;
import hibernatetutorial.Entity.Student;

public class CreateCourseDemo {

	public static void main(String[] args) {
		// Create Session factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		//Create Session
		
		Session session=factory.getCurrentSession();
		try 
		{
			//use session object to save java object
			
			//create a student object
			Instructor myInstructor=new Instructor("Chris","Evans","cap_ame@udemy.com");
			InstructorDetail newInstructorDetail=new InstructorDetail("Lead","Fight");
			/*Associated two entity with one to one relationship*/
			myInstructor.setInstructorDetail(newInstructorDetail);
			//Start transaction
			session.beginTransaction();
			//save the object along withh association keeping cascading in mind.
			
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
