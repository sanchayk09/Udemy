package springdemoannotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component //default bean id can be accessed using class name  first letter small it is created by spring itself
//with specific bean id @Component("thatSillyCoach")
public class TennisCoach implements ICoach {

	//directly filed dependency injection
	@Autowired
	@Qualifier("happyFortuneService")
	private IFortuneService fortuneService;
	
	@Override
	public String getDailyWorkOut() {
		
		return "Practice your backend volley";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortuneService(); 
	}
/*//Example of constructor injection
	@Autowired
	public TennisCoach(@Qualifier("happyFortuneService") IFortuneService fortuneService) {
		
		this.fortuneService = fortuneService;
	}
*/
	
	//Example of setter injection
	public TennisCoach()
	{
		System.out.println("Inside Constructor");
	}
	/*@Autowired
	public void setFortuneService(IFortuneService theFortuneService)
	{
		System.out.println("Inside Set Method");
		fortuneService=theFortuneService;
	}*/

	
}
