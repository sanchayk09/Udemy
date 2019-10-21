package com.luv2code.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {


	@GetMapping("/")
	public String Greet()
	{
		return "Hello World " + LocalDateTime.now();
	}
	@GetMapping("/workout")
	public String getDailyWorkout()
	{
		return "run hard 5k";
	}
	@GetMapping("/fortune")
	public String getDailyFortune()
	{
		return "Seven Blessings";
	}
}
