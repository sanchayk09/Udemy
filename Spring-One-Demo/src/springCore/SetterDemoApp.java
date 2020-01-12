package springCore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {
	
	public static void main(String[] args)
	{
		// load spring config file
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//retrive bean from spring container
		CricketCoach theCricketCoach=context.getBean("myCricketCoach",CricketCoach.class);
		//Call methods on Beans
				System.out.println(theCricketCoach.DailyWorkOut());
				System.out.println(theCricketCoach.getEmailAddress());
				System.out.println(theCricketCoach.getTeam());
				System.out.println(theCricketCoach.getDailyFortune());
		//close context
		context.close();
	}

}
