package springCore;

public class BaseBallCoach implements ICoach {

	private IFortuneService fortuneService;
	 public BaseBallCoach(IFortuneService theFortuneService)
	 {
		 fortuneService=theFortuneService;
	 }
	
	
	@Override
	public String DailyWorkOut()
	{
		return "Spend 30 min on batting practice";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}
}
							