package com.skill.India.POC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TpStatusController {

	@RequestMapping("/statusTp")  
	  public  String user() {
	    return "TpApplicationStatus";
	  }
}
