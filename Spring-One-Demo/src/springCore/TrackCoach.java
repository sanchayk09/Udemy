package springCore;

public class TrackCoach implements ICoach {

	private IFortuneService fortuneService;
	public TrackCoach() {
		
	
	}
	public TrackCoach(IFortuneService fortuneService) {
	
		this.fortuneService = fortuneService;
	}

	@Override
	public String DailyWorkOut() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Just Do it :" +fortuneService.getFortune();
	}

}
