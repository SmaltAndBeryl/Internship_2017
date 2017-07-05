package com.skill.India.POC;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FAQ {
	
	@RequestMapping("/FAQpage")  
	  public  String user() {
	    return "faq";
	  }

}





