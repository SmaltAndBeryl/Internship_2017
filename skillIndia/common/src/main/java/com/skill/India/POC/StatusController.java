package com.skill.India.POC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

public class StatusController {
	@RequestMapping("/status")  
	  public  String user() {
	    return "AbApplicationStatus";
	  }
}