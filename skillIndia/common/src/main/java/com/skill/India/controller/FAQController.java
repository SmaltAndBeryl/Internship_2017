package com.skill.India.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.common.Privilege;
import com.skill.India.dto.FAQBatchWiseCandidateDetailsDto;
import com.skill.India.dto.FAQCandidatesEnrolledAssessedCertifiedMonthWiseDto;
import com.skill.India.dto.FAQCandidatesTrainedAssessedCertifiedDto;
import com.skill.India.dto.FAQStatusOfAParticularBatchWithIdDto;
import com.skill.India.dto.FAQTotalBatchesWithTotalCandidatesEnrolledMonthWiseDto;
import com.skill.India.dto.FAQTotalNumberOfBatchesAndTotalEnrolledInAParticularStateDto;
import com.skill.India.dto.FAQTrainingCentresNotTakingAnyBatchesDto;
import com.skill.India.service.FAQService;

/**
 * @author Aashish sharma
 *
 */
@RestController
public class FAQController {
	
	@Autowired
	private FAQService fAQService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FAQController.class);
	
	@Privilege(value={"SCGJ"})
	@RequestMapping("/getFAQTotalCandidatesTrainedAssessedCertified")
	public Collection<FAQCandidatesTrainedAssessedCertifiedDto> getTotalCandidatesTrainedAssessedCertified()  {
		try
		{
			return fAQService.getTotalCandidatesTrainedAssessedCertifiedDao();
		}
		catch(Exception exception)
		{
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping(method=RequestMethod.POST,value="/getFAQTotalCandidatesTrainedAssessedCertifiedSchemeWise")
	public Collection<FAQCandidatesTrainedAssessedCertifiedDto> getTotalCandidatesTrainedAssessedCertifiedSchemeWise(@RequestParam("batchType") String batchType) {
		try
		{
			return fAQService.getTotalCandidatesTrainedAssessedCertifiedSchemeWise(batchType);
		}
		catch(Exception exception)
		{
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping(value="/getFAQTotalTrainingCentresInAState",method=RequestMethod.POST)
	public Integer getTotalTrainingCentresInAState(@RequestParam("state") String state) {
		try
		{
			return fAQService.getTotalTrainingCentresInAState(state);
		}
		catch(Exception exception)
		{
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping(value="/getFAQCountOfTotalTrainingCentresConductingTraining")
	public Integer getCountOfTotalTrainingCentresConductingTraining() {
		try
		{
			return fAQService.getCountOfTotalTrainingCentresConductingTraining();
		}
		catch(Exception exception)
		{
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping(value="/getFAQCountOfCandidatesAssessmentUpcomingForAMonth",method=RequestMethod.POST)
	public Integer getCountOfCandidatesAssessmentUpcomingForAMonth(@RequestParam("month") String month) {
		try
		{
			return fAQService.getCountOfCandidatesAssessmentUpcomingForAMonth(month);
		}
		catch(Exception exception)
		{
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping(value="/getFAQNameOfAgencyToWhichABatchIsAssigned",method=RequestMethod.POST)
	public String getNameOfAgencyToWhichABatchIsAssigned(@RequestParam("batchId") Integer batchId)throws EmptyResultDataAccessException {
		try
		{
			return fAQService.getNameOfAgencyToWhichABatchIsAssigned(batchId);
		}
		catch(Exception exception)
		{
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping(value="/getFAQTotalCountOfBatchesAssignedToAAssessmentAgency",method=RequestMethod.POST)
	public Integer getTotalCountOfBatchesAssignedToAAssessmentAgency(@RequestParam("agencyName") String agencyName)throws EmptyResultDataAccessException {
		try
		{
			return fAQService.getTotalCountOfBatchesAssignedToAAssessmentAgency(agencyName);
		}
		catch(Exception exception)
		{
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping(value="/getFAQCountOfTotalNumberOfBatchesAndTotalEnrolledInAParticularState",method=RequestMethod.POST)
	public Collection<FAQTotalNumberOfBatchesAndTotalEnrolledInAParticularStateDto> getCountOfTotalNumberOfBatchesAndTotalEnrolledInAParticularState(@RequestParam("state") String state) {
		try
		{
			return fAQService.getCountOfTotalNumberOfBatchesAndTotalEnrolledInAParticularState(state);
		}
		catch(Exception exception)
		{
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping(value="/getFAQCountOfTotalNumberOfBatchesAndTotalEnrolledInAParticularScheme",method=RequestMethod.POST)
	public Collection<FAQTotalNumberOfBatchesAndTotalEnrolledInAParticularStateDto> getCountTotalNumberOfBatchesInAParticularScheme(@RequestParam("batchType") String batchType) {
		try
		{
			return fAQService.getCountOfTotalNumberOfBatchesAndTotalEnrolledInAParticularStateSchemeWise(batchType);
		}
		catch(Exception exception)
		{
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping(value="/getFAQCountTotalAssessorsOfAParticularAgencyInAParticularState",method=RequestMethod.POST)
	public Integer getCountTotalAssessorsOfAParticularAgencyInAParticularState(@RequestParam("agencyName") String agencyName, @RequestParam("state") String state) {
		try
		{
			return fAQService.getCountTotalAssessorsOfAParticularAgencyInAParticularState(agencyName, state);
		}
		catch(Exception exception)
		{
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping(value="/getFAQStatusOfAParticularBatchWithId",method=RequestMethod.POST)
	public Collection<FAQStatusOfAParticularBatchWithIdDto> getStatusOfAParticularBatchWithId(@RequestParam("batchId") Integer batchId) {
		try
		{
			return fAQService.getStatusOfAParticularBatchWithId(batchId);
		}
		catch(Exception exception)
		{
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping(value="/getFAQCountBatchesForWhichResultIsPending")
	public Integer getCountBatchesForWhichResultIsPending() {
		try
		{
			return fAQService.getCountBatchesForWhichResultIsPending();
		}
		catch(Exception exception)
		{
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping(value="/getFAQBatchWiseCandidatesDetails",method=RequestMethod.POST)
	public Collection<FAQBatchWiseCandidateDetailsDto> getBatchWiseCandidatesDetails(@RequestParam("batchId") Integer batchId) {
		try
		{
			return fAQService.getBatchWiseCandidatesDetails(batchId);
		}
		catch(Exception exception)
		{
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping("/getFAQCountTotalNonAssignedBatches")
	public Integer getCountTotalNonAssignedBatches() {
		try
		{
			return fAQService.getCountTotalNonAssignedBatches();
		}
		catch(Exception exception)
		{
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping("/getFAQTrainingCentresNotTakingAnyBatches")
	public Collection<FAQTrainingCentresNotTakingAnyBatchesDto> getTrainingCentresNotTakingAnyBatchesc(){
		try
		{
			return fAQService.getTrainingCentresNotTakingAnyBatches();
		}
		catch(Exception exception)
		{
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping(method=RequestMethod.POST,value="/getFAQCandidatesEnrolledAssessedCertifiedMonthWise")
	public Collection<FAQCandidatesEnrolledAssessedCertifiedMonthWiseDto> getCountTotalCandidatesEnrolledMonthWise(@RequestParam("year") Integer year, @RequestParam("candidates") String candidates) {
		try
		{
			if(candidates.equalsIgnoreCase("Enrolled"))
			{
				return fAQService.getCountOfFAQCandidatesEnrolledMonthWise(year);
			}
			else if(candidates.equalsIgnoreCase("Assessed"))
			{
				return fAQService.getCountOfFAQCandidatesAssessedMonthWise(year);
			}
			else if(candidates.equalsIgnoreCase("Certified"))
			{
				return fAQService.getCountOfFAQCandidatesCertifiedMonthWise(year);
			}
			else
			{
				LOGGER.error("Incorrect Value for the selected type 'Candidate' or 'Year'");
				return null;
			}
		}
		catch(Exception e)
		{
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+e);
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping(method=RequestMethod.POST,value="/getFAQCandidatesEnrolledAssessedCertifiedMonthAndSchemeWise")
	public Collection<FAQCandidatesEnrolledAssessedCertifiedMonthWiseDto> getCountTotalCandidatesEnrolledMonthAndSchemeWise(@RequestParam("year") Integer year, @RequestParam("candidates") String candidates, @RequestParam("batchType") String batchType)
	{
		try
		{
			if(candidates.equalsIgnoreCase("Enrolled"))
			{
				return fAQService.getCountOfFAQCandidatesEnrolledMonthAndSchemeWise(year, batchType);
			}
			else if(candidates.equalsIgnoreCase("Assessed"))
			{
				return fAQService.getCountOfFAQCandidatesAssessedMonthAndSchemeWise(year, batchType);
			}
			else if(candidates.equalsIgnoreCase("Certified"))
			{
				return fAQService.getCountOfFAQCandidatesCertifiedMonthAndSchemeWise(year, batchType);
			}
			else
			{
				LOGGER.error("Incorrect Value for the selected type 'Candidate' or 'Year'");
				return null;
			}
		}
		catch(Exception e)
		{
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+e);
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping(method=RequestMethod.POST,value="/getFAQTotalBatchesWithTotalCandidatesEnrolledYearWise")
	public Collection<FAQTotalBatchesWithTotalCandidatesEnrolledMonthWiseDto> getTotalBatchesWithTotalCandidatesEnrolledYearWise(@RequestParam("year") int year) {
		try
		{
			return fAQService.getTotalBatchesWithTotalCandidatesEnrolledYearWise(year);
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
