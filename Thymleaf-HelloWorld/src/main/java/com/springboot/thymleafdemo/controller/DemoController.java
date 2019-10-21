package com.springboot.thymleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	public DemoController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/hello")
	public String SayHello(Model theModel)
	{
		theModel.addAttribute("data",new java.util.Date());
		return "Hello-world";
	}

}
