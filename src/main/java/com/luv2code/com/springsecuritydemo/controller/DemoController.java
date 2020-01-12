package com.luv2code.com.springsecuritydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	@GetMapping("/")
	public String ShowHome()
	{
		return "Home-Page";
	}
	@GetMapping("/leaders")
	public String ShowLeader()
	{
		return "leaders";
	}
	@GetMapping("/system")
	public String ShowAdmin()
	{
		return "leaders";
	}
	@GetMapping("/access-denied")
	public String ShowAccessDenied()
	{
		return "access-denied";
	}
}
