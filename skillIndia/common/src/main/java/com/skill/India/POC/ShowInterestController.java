package com.skill.India.POC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowInterestController {

	@RequestMapping("/showInterest")  
	  public  String user() {
	    return "showInterest";  
	  }
}
