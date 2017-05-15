package com.skill.India.POC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HighChartPageController {

	@RequestMapping("/high")
	  public  String user() {
	    return "pieHighchart";
	  }
}
