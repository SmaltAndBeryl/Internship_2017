package com.skill.India.POC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ColumnChartController {

	@RequestMapping("/columnchart")  
	  public  String user() {
	    return "columnchart";   //returns template for columnchart
	  }
}
