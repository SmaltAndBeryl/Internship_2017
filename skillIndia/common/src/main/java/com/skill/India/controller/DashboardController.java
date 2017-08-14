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
		LOGGER.info("In DashboardController - getTotalCandidatesEnrolled");
		LOGGER.info("Request Received from front end to get Total Candidates Enrolled for Dashboard Panel");
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
		LOGGER.info("In DashboardController - getTotalCandidatesAccessed");
		LOGGER.info("Request Received from front end to get Total Candidates Assessed for Dashboard Panel");
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
		LOGGER.info("In DashboardController - getTotalCandidatesCertified");
		LOGGER.info("Request Received from front end to get Total Candidates Certified for Dashboard Panel");
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
		LOGGER.info("In DashboardController - getTotalTrainingPartners");
		LOGGER.info("Request Received from front end to get Total Number of Training Partners for Dashboard Panel");
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
		LOGGER.info("In DashboardController - getTotalTrainingCentersInIndia");
		LOGGER.info("Request Received from front end to get Total Number of Training Centers for Dashboard Panel");
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
		LOGGER.info("In DashboardController - getTotalBatchesAccordingToJobRole");
		LOGGER.info("Request Received from front end to get data for High Charts - Total Batches According to Job Role for Dashboard");
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
		LOGGER.info("In DashboardController - getTotalCandidatesTrainedWithBatchTypeInLastThreeYears");
		LOGGER.info("Request Received from front end to get data for High Charts - Total Candidates Trained According to Batch Type for Dashboard");
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
		LOGGER.info("In DashboardController - getTotalCandidatesCertifiedWithModeInLastThreeYears");
		LOGGER.info("Request Received from front end to get data for High Charts - Total Candidates Certified According to Mode In last Three Years for Dashboard");
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
		LOGGER.info("In DashboardController - getTopStatesWithMaxTrainingCenters");
		LOGGER.info("Request Received from front end to get data for High Charts - Top States According to Max Training Centers for Dashboard");
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
		LOGGER.info("In DashboardController Handling Exceptions Missing Parameters - handleMissingParams");
		String parameterName = exception.getParameterName();
	    LOGGER.error(parameterName + " parameter is missing");
	    // Handling Missing Parameters Exceptions Here
	}
	
}