package springCore;

public class CricketCoach implements ICoach {

	private String emailAddress;
	
	private String team;
	
	private IFortuneService fortuneService;

	public CricketCoach() {
		System.out.println("Inside no-arg constructor");
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("Inside Setter method for Email");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("Inside Setter method for Team");
		this.team = team;
	}
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	public void setFortuneService(IFortuneService fortuneService) {
		System.out.println("Inside Setter method");
		this.fortuneService = fortuneService;
	}

	@Override
	public String DailyWorkOut() {
		return "Practice fast bowling for 15 min. ";
	}

	


}
