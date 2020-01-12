package springdemoannotations;

public class SwimCoach implements ICoach {

	private IFortuneService fortuneService;
	public SwimCoach(IFortuneService fortuneService) {
		
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkOut() {
		return "swim 1000 m daily";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortuneService();
	}

}
