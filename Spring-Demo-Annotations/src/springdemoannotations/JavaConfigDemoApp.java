package springdemoannotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		// read spring config file but using JAVA config file not xml file
		/*ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext("applicationContext.xml");*/
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SportConfig.class);
		//get bean from spring container
		//for specific bean id
		//ICoach theCoach=context.getBean("thatSillyCoach",ICoach.class);
		//for default bean id
		ICoach theCoach=context.getBean ("tennisCoach",ICoach.class);
		//call a method from bean
		System.out.println(theCoach.getDailyWorkOut());
		System.out.println(theCoach.getDailyFortune());	
		//close container
		context.close();
	}

}
