package com.skill.India.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.dto.DashboardDto;
import com.skill.India.service.DashboardService;

@RestController
public class DashboardController {
	
	@Autowired
	private DashboardService dashboardService;
	
	@RequestMapping("/totalCandidateEnrolled")
	public int totalCandidateEnrolled() {
		
		//return 
		return 0;
	}
	
	@RequestMapping("/totalCandidateAssessed")
	public int totalCandidateAssessed() {
		return 0;
	}
	
	@RequestMapping("/totalCandidateCertified")
	public int totalCandidateCertified() {
		return 0;
	}
	
	@RequestMapping("/totalTrainingPartner")
	public int totalTrainingPartner() {
		return 0;
	}
	
	@RequestMapping("/totalTrainingCenter")
	public int totalTrainingCenter() {
		return 0;
	}
	
	@RequestMapping(value="/topStates", produces="application/json")
	public List<DashboardDto> getStates() {
		return dashboardService.getStates();
	}

}
