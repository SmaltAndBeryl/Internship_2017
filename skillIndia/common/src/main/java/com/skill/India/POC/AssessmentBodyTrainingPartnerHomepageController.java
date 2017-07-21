package com.skill.India.POC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

	@Controller
		public class AssessmentBodyTrainingPartnerHomepageController {

		@RequestMapping("/usersHomepage")  
		  public  String user() {
		    return "MasterTemplate2";
		  }
}