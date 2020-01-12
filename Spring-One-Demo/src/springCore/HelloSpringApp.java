package springCore;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		// Load the spring config file
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext("applicationContext.xml");
		//retrive method from spring container
		ICoach theCoach=context.getBean("myCoach", ICoach.class);
		
		//Call methods on Beans
		System.out.println(theCoach.DailyWorkOut());
		System.out.println(theCoach.getDailyFortune());
		//Close the context
		context.close();
	}

}
