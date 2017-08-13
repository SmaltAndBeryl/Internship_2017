package com.skill.India.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Random {

	@RequestMapping("/profile")
	public String func()
	{
		return "ProfileCreationtrainingPartner";
	}
	
	@RequestMapping("/test")
	public String func1()
	{
		return "Testing";
	}
}
