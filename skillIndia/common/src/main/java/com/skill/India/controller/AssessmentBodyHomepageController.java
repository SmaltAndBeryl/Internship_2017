package com.skill.India.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.dto.AssessmentBodyHomepageDto;
import com.skill.India.service.AssessmentBodyHomepageService;


@RestController
public class AssessmentBodyHomepageController {

	@Autowired
	private AssessmentBodyHomepageService assessmentBodyHomepageService;
	
	@RequestMapping("/getPastBatchesAssessmentBodyHomepage")
	public Collection<AssessmentBodyHomepageDto> getpastBatchesAssessmentBodyHomepageRowMapper(){
		return assessmentBodyHomepageService.getpastBatchesAssessmentBodyHomepageRowMapper();
	}
	
	@RequestMapping("/getUpcomingBatchesAssessmentBodyHomepage")
	public Collection<AssessmentBodyHomepageDto> getupcomingBatchesAssessmentBodyHomepageRowMapper(){
		return assessmentBodyHomepageService.getupcomingBatchesAssessmentBodyHomepageRowMapper();
	}
	
	@RequestMapping("/getAssignedBatchesAssessmentBodyHomepage")
	public Collection<AssessmentBodyHomepageDto> getassigneddBatchesAssessmentBodyHomepageRowMapper(){
		return assessmentBodyHomepageService.getassignedBatchesAssessmentBodyHomepageRowMapper();
	}
	
	@RequestMapping("/getConfirmedBatchesAssessmentBodyHomepage")
	public Collection<AssessmentBodyHomepageDto> getconfirmedBatchesAssessmentBodyHomepageRowMapper(){
		return assessmentBodyHomepageService.getconfirmedBatchesAssessmentBodyHomepageRowMapper();
	}
}
