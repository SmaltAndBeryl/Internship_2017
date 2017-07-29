package com.skill.India.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
@RequestMapping("/")
public String loginpage()
{
	return "index3";
}
	
}
