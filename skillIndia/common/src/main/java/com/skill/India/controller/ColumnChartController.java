package com.skill.India.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ColumnChartController {

	@RequestMapping("/groupedColumnChart")  
	  public  String groupedColumnChart() {
	    return "groupedColumnChart";   //returns template for columnchart
	  }
	

	@RequestMapping("/stackedColumnChart")  
	  public  String stackedColumnChart() {
	    return "stackedColumnChart";   //returns template for columnchart
	  }
	
	
	@RequestMapping("/columnchart")  
	  public  String user() {
	    return "columnChart";   //returns template for columnchart
	  }
	
	@RequestMapping("/dashboard")
	  public String dashboard() {
		return "Dashboard";
	}
	

	@RequestMapping("/piechart")
	  public String pieChart() {
		return "pieChart";
	}
}
