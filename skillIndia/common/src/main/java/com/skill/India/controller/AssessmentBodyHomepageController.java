package com.skill.India.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.common.UserIdtoApplicationIdUtility;
import com.skill.India.dto.AssessmentBodyHomepageDto;
import com.skill.India.dto.SessionManagementDto;
import com.skill.India.service.AssessmentBodyHomepageService;


@RestController
public class AssessmentBodyHomepageController {

	@Autowired
	private SessionManagementDto sessionManagementDto;
	
	@Autowired
	private UserIdtoApplicationIdUtility userIdtoApplicationIdUtility;
	
	String userId = sessionManagementDto.getUsername();
	
	int applicationId = userIdtoApplicationIdUtility.getApplicationId(userId);
	
	@Autowired
	private AssessmentBodyHomepageService assessmentBodyHomepageService;
	
//	@RequestMapping("/getPastBatchesAssessmentBodyHomepage")
//	public Collection<AssessmentBodyHomepageDto> getpastBatchesAssessmentBodyHomepageRowMapper(@RequestParam("applicationId")int applicationId){
//		
//		//System.out.println("CGCxhsvdcvdhcbdkb kdb............."+applicationId);
//		return assessmentBodyHomepageService.getpastBatchesAssessmentBodyHomepageRowMapper(applicationId);
//	}
	
	@RequestMapping("/getPastBatchesAssessmentBodyHomepage")
	public Collection<AssessmentBodyHomepageDto> getpastBatchesAssessmentBodyHomepageRowMapper(){
		
		//System.out.println("CGCxhsvdcvdhcbdkb kdb............."+applicationId);
		return assessmentBodyHomepageService.getpastBatchesAssessmentBodyHomepageRowMapper(applicationId);
	}
	
//	@RequestMapping("/getUpcomingBatchesAssessmentBodyHomepage")
//	public Collection<AssessmentBodyHomepageDto> getupcomingBatchesAssessmentBodyHomepageRowMapper(@RequestParam("applicationId")int applicationId){
//		return assessmentBodyHomepageService.getupcomingBatchesAssessmentBodyHomepageRowMapper(applicationId);
//	}
	
	@RequestMapping("/getUpcomingBatchesAssessmentBodyHomepage")
	public Collection<AssessmentBodyHomepageDto> getupcomingBatchesAssessmentBodyHomepageRowMapper(){
		return assessmentBodyHomepageService.getupcomingBatchesAssessmentBodyHomepageRowMapper(applicationId);
	}
	
//	@RequestMapping("/getShownInterestBatchesAssessmentBodyHomepage")
//	public Collection<AssessmentBodyHomepageDto> getshownInterestAssessmentBodyHomepageRowMapper(@RequestParam("applicationId")int applicationId){
//		return assessmentBodyHomepageService.getshownInterestAssessmentBodyHomepageRowMapper(applicationId);
//	}
	
	@RequestMapping("/getShownInterestBatchesAssessmentBodyHomepage")
	public Collection<AssessmentBodyHomepageDto> getshownInterestAssessmentBodyHomepageRowMapper(){
		return assessmentBodyHomepageService.getshownInterestAssessmentBodyHomepageRowMapper(applicationId);
	}
	
//	@RequestMapping("/getAssignedBatchesAssessmentBodyHomepage")
//	public Collection<AssessmentBodyHomepageDto> getassigneddBatchesAssessmentBodyHomepageRowMapper(@RequestParam("applicationId")int applicationId){
//		return assessmentBodyHomepageService.getassignedBatchesAssessmentBodyHomepageRowMapper(applicationId);
//	}
	
	@RequestMapping("/getAssignedBatchesAssessmentBodyHomepage")
	public Collection<AssessmentBodyHomepageDto> getassigneddBatchesAssessmentBodyHomepageRowMapper(){
		return assessmentBodyHomepageService.getassignedBatchesAssessmentBodyHomepageRowMapper(applicationId);
	}
	
//	@RequestMapping("/getConfirmedBatchesAssessmentBodyHomepage")
//	public Collection<AssessmentBodyHomepageDto> getconfirmedBatchesAssessmentBodyHomepageRowMapper(@RequestParam("applicationId")int applicationId){
//		return assessmentBodyHomepageService.getconfirmedBatchesAssessmentBodyHomepageRowMapper(applicationId);
//	}
	
	@RequestMapping("/getConfirmedBatchesAssessmentBodyHomepage")
	public Collection<AssessmentBodyHomepageDto> getconfirmedBatchesAssessmentBodyHomepageRowMapper(){
		return assessmentBodyHomepageService.getconfirmedBatchesAssessmentBodyHomepageRowMapper(applicationId);
	}
}
