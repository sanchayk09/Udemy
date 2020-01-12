package hibernatedmeo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import hibernatetutorial.Entity.Course;
import hibernatetutorial.Entity.Instructor;
import hibernatetutorial.Entity.InstructorDetail;
import hibernatetutorial.Entity.Student;

public class FetchJoinDemo {

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
			session.beginTransaction();
			
			int idinst=1;
			Query<Instructor> query=session.createQuery("select i from Instructor i "
													+"join fetch i.courses "+
													"where i.id=:theID"
													,Instructor.class);
		
			query.setParameter("theID", idinst);
			Instructor tempInstructor=query.getSingleResult();
			System.out.println(tempInstructor);
			session.getTransaction().commit();
			session.close();
			System.out.println(tempInstructor.getCourses());
		}
		finally 
		{
			
			factory.close();
			
		}
	}
}