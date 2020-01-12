package hibernatedmeo;

import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernatetutorial.Entity.Course;
import hibernatetutorial.Entity.Instructor;
import hibernatetutorial.Entity.InstructorDetail;
import hibernatetutorial.Entity.Review;
import hibernatetutorial.Entity.Student;

public class CreateCourseAndReviewDemo {

	public static void main(String[] args) {
		// Create Session factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		//Create Session
		
		Session session=factory.getCurrentSession();
		try 
		{	
			session.beginTransaction();
		
			Course tempCourse=new Course("How to lead");
			tempCourse.addReview(new Review("Perfact use of Languages"));
			tempCourse.addReview(new Review("Excelllent shielding skill"));
			tempCourse.addReview(new Review("Team Player"));
			session.save(tempCourse);
			System.out.println(tempCourse.getReviews());
			session.getTransaction().commit();
			
		}
		finally 
		{
			session.close();
			factory.close();
		}
 
	}

}
