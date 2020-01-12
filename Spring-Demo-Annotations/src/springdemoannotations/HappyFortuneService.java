package springdemoannotations;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements IFortuneService {

	@Override
	public String getFortuneService() {
		
		return "Today is Your Lucky Day !";
	}

}
