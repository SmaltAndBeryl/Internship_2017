package com.skill.India.controller;


import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.common.Privilege;
import com.skill.India.dto.DashboardTotalCandidatesTrainedWithBatchTypeInLastThreeYearsDto;
import com.skill.India.dto.DashboardTotalBatchesAccordingToJobRoleDto;
import com.skill.India.dto.DashboardTotalCandidatesCertifiedWithModeInLastThreeYearsDto;
import com.skill.India.dto.DashboardTopStatesWithMaxTrainingCentersDto;
import com.skill.India.service.DashboardService;;

@RestController
class DashboardController {
	
	@Autowired
	private DashboardService dashboardService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DashboardController.class);
	
	@Privilege(value={"SCGJ"})
	@RequestMapping("/getDashboardTotalCandidatesEnrolled")
	public Integer getTotalCandidatesEnrolled() {
		
		try
		{
			return dashboardService.getTotalCandidatesEnrolled();
		}
		catch(Exception exception)
		{
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping("/getDashboardTotalCandidatesAccessed")
	public Integer getTotalCandidatesAccessed() {
		
		try
		{
			return dashboardService.getTotalCandidatesAccessed();
		}
		catch(Exception exception)
		{
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping("/getDashboardTotalCandidatesCertified")
	public Integer getTotalCandidatesCertified() {
		
		try
		{
			return dashboardService.getTotalCandidatesCertified();
		}
		catch(Exception exception)
		{
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping("/getDashboardTotalTrainingPartners")
	public Integer getTotalTrainingPartners() {
		
		try
		{
			return dashboardService.getTotalTrainingPartners();
		}
		catch(Exception exception)
		{
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping("/getDashboardTotalTrainingCentersInIndia")
	public Integer getTotalTrainingCentersInIndia() {
		
		try
		{
			return dashboardService.getTotalTrainingCentersInIndia();
		}
		catch(Exception exception)
		{
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping("/getDashboardTotalBatchesAccordingToJobRole")
	public Collection<DashboardTotalBatchesAccordingToJobRoleDto> getTotalBatchesAccordingToJobRole() {
		try
		{
			return dashboardService.getTotalBatchesAccordingToJobRole();
		}
		catch(Exception exception)
		{
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			return null;
		}
	}
		
	@Privilege(value={"SCGJ"})
	@RequestMapping("/getDashboardTotalCandidatesTrainedWithBatchTypeInLastThreeYears")
	public Collection<DashboardTotalCandidatesTrainedWithBatchTypeInLastThreeYearsDto> getTotalCandidatesTrainedWithBatchTypeInLastThreeYears() {
		try
		{
			return dashboardService.getTotalCandidatesTrainedWithBatchTypeInLastThreeYears();
		}
		catch(Exception exception)
		{
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			return null;
		}
	}


	@Privilege(value={"SCGJ"})
	@RequestMapping("/getDashboardTotalCandidatesCertifiedWithModeInLastThreeYears")
	public Collection<DashboardTotalCandidatesCertifiedWithModeInLastThreeYearsDto> getTotalCandidatesCertifiedWithModeInLastThreeYears() {
		try
		{
			return dashboardService.getTotalCandidatesCertifiedWithModeInLastThreeYears();
		}
		catch(Exception exception)
		{
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			return null;
		}
		
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping("/getDashboardTopStatesWithMaxTrainingCenters")
	public Collection<DashboardTopStatesWithMaxTrainingCentersDto> getTopStatesWithMaxTrainingCenters() {
		try
		{
			return dashboardService.getTopStatesWithMaxTrainingCenters();
		}
		catch(Exception exception)
		{
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			return null;
		}
	}
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public void handleMissingParams(MissingServletRequestParameterException exception) {
	    String parameterName = exception.getParameterName();
	    LOGGER.error(parameterName + " parameter is missing");
	    // Handling Missing Parameters Exceptions Here
	}
	
}