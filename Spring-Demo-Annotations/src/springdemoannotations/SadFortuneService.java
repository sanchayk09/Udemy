package springdemoannotations;

public class SadFortuneService implements IFortuneService {

	@Override
	public String getFortuneService() {
		
		return "Today is a sad day" ;
	}

}
