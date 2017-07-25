package com.skill.India.POC;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HighChartPageController {

	@RequestMapping("/high")
	  public  String user(HttpServletResponse response) {
		response.addHeader("test", "test");
	    return "pieHighchart";
	  }
}
