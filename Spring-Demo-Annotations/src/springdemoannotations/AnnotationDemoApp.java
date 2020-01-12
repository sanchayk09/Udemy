package springdemoannotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		// read spring config file
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext("applicationContext.xml");
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
