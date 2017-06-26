package com.skill.India.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.dto.DashboardDto;
import com.skill.India.service.DashboardService;;

@RestController
class DashboardController {
	
	@Autowired
	private DashboardService dashboardService;
	
	@RequestMapping("/totalCandidatesEnrolled")
	public Integer candidatesEnrolled() {
		
		return dashboardService.getCandidatesEnrolled();
	}
	
	@RequestMapping("/totalCandidatesAccessed")
	public Integer candidatesAccessed() {
		
		return dashboardService.getCandidatesAccessed();
	}
	
	@RequestMapping("/totalCandidatesCertified")
	public Integer candidatesCertify() {
		
		return dashboardService.getCandidatesCertified();
	}
	
	@RequestMapping("/totalTrainingPartners")
	public Integer trainingPartners() {
		
		return dashboardService.getTrainingPartners();
	}
	
	@RequestMapping("/totalTrainingCenters")
	public Integer trainingCenters() {
		
		return dashboardService.getTrainingCenters();
	}
	/*	
	@Autowired
	JdbcTemplate jdbc;
	
	@RequestMapping("/test")
	public int test() {
		
		jdbc.execute("insert into user(name,age) values('ashish',21)");
		return 1;
	}*/	
	@RequestMapping(value="/topStates", produces="application/json")
	public List<DashboardDto> getStates() {
		return dashboardService.getStates();
	}


}