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
	
	@RequestMapping("/getDashboardTotalCandidatesEnrolled")
	public Integer getTotalCandidatesEnrolled() {
		
		return dashboardService.getTotalCandidatesEnrolled();
	}
	
	@RequestMapping("/getDashboardTotalCandidatesAccessed")
	public Integer getTotalCandidatesAccessed() {
		
		return dashboardService.getTotalCandidatesAccessed();
	}
	
	@RequestMapping("/getDashboardTotalCandidatesCertified")
	public Integer getTotalCandidatesCertified() {
		
		return dashboardService.getTotalCandidatesCertified();
	}
	
	@RequestMapping("/getDashboardTotalTrainingPartners")
	public Integer getTotalTrainingPartners() {
		
		return dashboardService.getTotalTrainingPartners();
	}
	
	@RequestMapping("/getDashboardTotalTrainingCentersInIndia")
	public Integer getTotalTrainingCentersInIndia() {
		
		return dashboardService.getTotalTrainingCentersInIndia();
	}
	
	@RequestMapping("/getDashboardTotalBatchesAccordingToJobRole")
	public Collection<DashboardTotalBatchesAccordingToJobRoleDto> getTotalBatchesAccordingToJobRole() {
		return dashboardService.getTotalBatchesAccordingToJobRole();
	}
		
	@RequestMapping("/getDashboardTotalCandidatesTrainedWithBatchTypeInLastThreeYears")
	public Collection<DashboardTotalCandidatesTrainedWithBatchTypeInLastThreeYearsDto> getTotalCandidatesTrainedWithBatchTypeInLastThreeYears() {
		return dashboardService.getTotalCandidatesTrainedWithBatchTypeInLastThreeYears();
	}


	@RequestMapping("/getDashboardTotalCandidatesCertifiedWithModeInLastThreeYears")
	public Collection<DashboardTotalCandidatesCertifiedWithModeInLastThreeYearsDto> getTotalCandidatesCertifiedWithModeInLastThreeYears() {
		return dashboardService.getTotalCandidatesCertifiedWithModeInLastThreeYears();
		
	}
	
	
	@RequestMapping("/getDashboardTopStatesWithMaxTrainingCenters")
	public Collection<DashboardTopStatesWithMaxTrainingCentersDto> getTopStatesWithMaxTrainingCenters() {
		return dashboardService.getTopStatesWithMaxTrainingCenters();
	}
	
}