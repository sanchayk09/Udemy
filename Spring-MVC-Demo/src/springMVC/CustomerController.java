package springMVC;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/customer")
public class CustomerController {

	// Initbinder to remove white trailing, leadinWg and only white space
	@InitBinder
	public void InitBinder(WebDataBinder theWebDataBinder)
	{
		StringTrimmerEditor st=new StringTrimmerEditor(true);
		theWebDataBinder.registerCustomEditor(String.class, st);
	}
	
	
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel)
	{
		theModel.addAttribute("customer",new Customer());
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") 
	Customer theCustomer, BindingResult theBndingResult)
	{
		if(theBndingResult.hasErrors())
		{
			return "customer-form";
		}
		else
		return "customer-confirmation";
	}
}
