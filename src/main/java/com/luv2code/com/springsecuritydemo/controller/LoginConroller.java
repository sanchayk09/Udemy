package com.luv2code.com.springsecuritydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class LoginConroller {
	
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage()
	{
		return "fancy-login";
	}
	

}
