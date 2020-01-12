package springMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	
	//need a controller method to Show the form
	@RequestMapping("/showForm")
	public String showForm()
	{
		return "HelloWorld-Form";
	}
	
	//need a controller method to process the form
	@RequestMapping("/processForm")
	public String processForm()
	{
		return "HelloWorld";
	}
	
}
