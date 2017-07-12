package com.skill.India.POC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

	@Controller
		public class AbStatusController {

		@RequestMapping("/statusAb")  
		  public  String user() {
		    return "AbApplicationStatus";
		  }
}