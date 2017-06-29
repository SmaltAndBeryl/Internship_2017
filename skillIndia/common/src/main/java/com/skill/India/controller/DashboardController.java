package com.skill.India.controller;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.dto.DashboardTotalCandidatesTrainedWithBatchTypeInLastThreeYearsDto;
import com.skill.India.dto.DashboardTotalBatchesAccordingToJobRoleDto;
import com.skill.India.dto.DashboardTotalCandidatesCertifiedWithModeInLastThreeYearsDto;
import com.skill.India.dto.DashboardTopStatesWithMaxTrainingCentersDto;
import com.skill.India.service.DashboardService;;

@RestController
class DashboardController {
	
	@Autowired
	private DashboardService dashboardService;
	
	@RequestMapping("/getTotalCandidatesEnrolled")
	public Integer getTotalCandidatesEnrolled() {
		
		return dashboardService.getTotalCandidatesEnrolled();
	}
	
	@RequestMapping("/getTotalCandidatesAccessed")
	public Integer getTotalCandidatesAccessed() {
		
		return dashboardService.getTotalCandidatesAccessed();
	}
	
	@RequestMapping("/getTotalCandidatesCertified")
	public Integer getTotalCandidatesCertified() {
		
		return dashboardService.getTotalCandidatesCertified();
	}
	
	@RequestMapping("/getTotalTrainingPartners")
	public Integer getTotalTrainingPartners() {
		
		return dashboardService.getTotalTrainingPartners();
	}
	
	@RequestMapping("/getTotalTrainingCentersInIndia")
	public Integer getTotalTrainingCentersInIndia() {
		
		return dashboardService.getTotalTrainingCentersInIndia();
	}
	
	@RequestMapping("/getTotalBatchesAccordingToJobRole")
	public Collection<DashboardTotalBatchesAccordingToJobRoleDto> getTotalBatchesAccordingToJobRole() {
		return dashboardService.getTotalBatchesAccordingToJobRole();
	}
		
	@RequestMapping("/getTotalCandidatesTrainedWithBatchTypeInLastThreeYears")
	public Collection<DashboardTotalCandidatesTrainedWithBatchTypeInLastThreeYearsDto> getTotalCandidatesTrainedWithBatchTypeInLastThreeYears() {
		return dashboardService.getTotalCandidatesTrainedWithBatchTypeInLastThreeYears();
	}


	@RequestMapping("/getTotalCandidatesCertifiedWithModeInLastThreeYears")
	public Collection<DashboardTotalCandidatesCertifiedWithModeInLastThreeYearsDto> getTotalCandidatesCertifiedWithModeInLastThreeYears() {
		return dashboardService.getTotalCandidatesCertifiedWithModeInLastThreeYears();
		
	}
	
	
	@RequestMapping("/getTopStatesWithMaxTrainingCenters")
	public Collection<DashboardTopStatesWithMaxTrainingCentersDto> getTopStatesWithMaxTrainingCenters() {
		return dashboardService.getTopStatesWithMaxTrainingCenters();
	}
	
}