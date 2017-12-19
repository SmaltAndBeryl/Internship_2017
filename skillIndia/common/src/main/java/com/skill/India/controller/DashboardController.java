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
		
		LOGGER.debug("Request Received from front end to get Total Candidates Enrolled for Dashboard Panel");
		try
		{
		
			return dashboardService.getTotalCandidatesEnrolled();
		}
		catch(Exception exception)
		{
			
			LOGGER.error("An exception occured while finding total candidates enrolled :"+exception);
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping("/getDashboardTotalCandidatesAccessed")
	public Integer getTotalCandidatesAccessed() {
		
		LOGGER.debug("Request Received from front end to get Total Candidates Assessed for Dashboard Panel");
		try
		{
			
			return dashboardService.getTotalCandidatesAccessed();
		}
		catch(Exception exception)
		{
			
			LOGGER.error("An exception occured while finding total candidates assessed :"+exception);
			LOGGER.debug("Returning NULL");
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping("/getDashboardTotalCandidatesCertified")
	public Integer getTotalCandidatesCertified() {
		
		LOGGER.debug("Request Received from front end to get Total Candidates Certified for Dashboard Panel");
		try
		{
			
			return dashboardService.getTotalCandidatesCertified();
		}
		catch(Exception exception)
		{
			
			LOGGER.error("An exception occured while finding total candidates certified :"+exception);
			LOGGER.debug("Returning NULL");
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping("/getDashboardTotalTrainingPartners")
	public Integer getTotalTrainingPartners() {
		
		LOGGER.debug("Request Received from front end to get Total Number of Training Partners for Dashboard Panel");
		try
		{
			
			return dashboardService.getTotalTrainingPartners();
		}
		catch(Exception exception)
		{
			
			LOGGER.error("An exception occured while finding total training partners  :"+exception);
			LOGGER.debug("Returning NULL");
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping("/getDashboardTotalTrainingCentersInIndia")
	public Integer getTotalTrainingCentersInIndia() {
		
		LOGGER.debug("Request Received from front end to get Total Number of Training Centers for Dashboard Panel");
		try
		{
			
			return dashboardService.getTotalTrainingCentersInIndia();
		}
		catch(Exception exception)
		{
			
			LOGGER.error("An exception occured while finding total training centers in India  :"+exception);
			LOGGER.debug("Returning NULL");
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping("/getDashboardTotalBatchesAccordingToJobRole")
	public Collection<DashboardTotalBatchesAccordingToJobRoleDto> getTotalBatchesAccordingToJobRole() {
		
		LOGGER.debug("Request Received from front end to get data for High Charts - Total Batches According to Job Role for Dashboard");
		try
		{
			return dashboardService.getTotalBatchesAccordingToJobRole();
		}
		catch(Exception exception)
		{
	
			LOGGER.error("An exception occured while finding total batches according to job role :"+exception);
			LOGGER.debug("Returning NULL");
			return null;
		}
	}
		
	@Privilege(value={"SCGJ"})
	@RequestMapping("/getDashboardTotalCandidatesTrainedWithBatchTypeInLastThreeYears")
	public Collection<DashboardTotalCandidatesTrainedWithBatchTypeInLastThreeYearsDto> getTotalCandidatesTrainedWithBatchTypeInLastThreeYears() {
		
		LOGGER.debug("Request Received from front end to get data for High Charts - Total Candidates Trained According to Batch Type for Dashboard");
		try
		{
			return dashboardService.getTotalCandidatesTrainedWithBatchTypeInLastThreeYears();
		}
		catch(Exception exception)
		{
			
			LOGGER.error("An exception occured while finding total candidates with batch type for last three years :"+exception);
			LOGGER.debug("Returning NULL");
			return null;
		}
	}


	@Privilege(value={"SCGJ"})
	@RequestMapping("/getDashboardTotalCandidatesCertifiedWithModeInLastThreeYears")
	public Collection<DashboardTotalCandidatesCertifiedWithModeInLastThreeYearsDto> getTotalCandidatesCertifiedWithModeInLastThreeYears() {
		
		LOGGER.debug("Request Received from front end to get data for High Charts - Total Candidates Certified According to Mode In last Three Years for Dashboard");
		try
		{
			
			return dashboardService.getTotalCandidatesCertifiedWithModeInLastThreeYears();
		}
		catch(Exception exception)
		{
		
			LOGGER.error("An exception occured while finding total candidates certified in a mode for past three years :"+exception);
			LOGGER.debug("Returning NULL");
			return null;
		}
		
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping("/getDashboardTopStatesWithMaxTrainingCenters")
	public Collection<DashboardTopStatesWithMaxTrainingCentersDto> getTopStatesWithMaxTrainingCenters() {
		
		LOGGER.debug("Request Received from front end to get data for High Charts - Top States According to Max Training Centers for Dashboard");
		try
		{
			return dashboardService.getTopStatesWithMaxTrainingCenters();
		}
		catch(Exception exception)
		{
			LOGGER.error("An exception occured while finding states with maximum training center :"+exception);
			LOGGER.debug("Returning NULL");
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