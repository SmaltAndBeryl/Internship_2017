package com.skill.India.POC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManageRegistrationController {
	@RequestMapping("/approveReject")  
	  public  String user() {
	    return "MR_ApproveRejectFormTable";
	  }
}