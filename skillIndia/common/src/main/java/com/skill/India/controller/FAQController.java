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
		LOGGER.info("In FAQController - getTotalCandidatesTrainedAssessedCertified");
		LOGGER.info("Request Received from front end to get data for Total Candidates Trained, Assessed, Certified for FAQ");
		try
		{
			LOGGER.info("In TRY block");
			LOGGER.info("Sending Request to service");
			return fAQService.getTotalCandidatesTrainedAssessedCertifiedDao();
		}
		catch(Exception exception)
		{
			LOGGER.info("In CATCH block");
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			LOGGER.info("returning NULL");
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping(method=RequestMethod.POST,value="/getFAQTotalCandidatesTrainedAssessedCertifiedSchemeWise")
	public Collection<FAQCandidatesTrainedAssessedCertifiedDto> getTotalCandidatesTrainedAssessedCertifiedSchemeWise(@RequestParam("batchType") String batchType) {
		LOGGER.info("In FAQController - getTotalCandidatesTrainedAssessedCertifiedSchemeWise");
		LOGGER.info("Request Received from front end to get data for Total Candidates Trained, Assessed, Certified Scheme Wise for FAQ");
		LOGGER.info("Parameters Received from front end are - 'batchType': ",batchType);
		try
		{
			LOGGER.info("In TRY block");
			LOGGER.info("Sending Request to service");
			return fAQService.getTotalCandidatesTrainedAssessedCertifiedSchemeWise(batchType);
		}
		catch(Exception exception)
		{
			LOGGER.info("In CATCH block");
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			LOGGER.info("returning NULL");
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping(value="/getFAQTotalTrainingCentresInAState",method=RequestMethod.POST)
	public Integer getTotalTrainingCentresInAState(@RequestParam("state") String state) {
		LOGGER.info("In FAQController - getTotalTrainingCentresInAState");
		LOGGER.info("Request Received from front end to get data for Total Training Centres in a State for FAQ");
		LOGGER.info("Parameters Received from front end are - 'state': ",state);
		try
		{
			LOGGER.info("In TRY block");
			LOGGER.info("Sending Request to service");
			return fAQService.getTotalTrainingCentresInAState(state);
		}
		catch(Exception exception)
		{
			LOGGER.info("In CATCH block");
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			LOGGER.info("returning NULL");
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping(value="/getFAQCountOfTotalTrainingCentresConductingTraining")
	public Integer getCountOfTotalTrainingCentresConductingTraining() {
		LOGGER.info("In FAQController - getCountOfTotalTrainingCentresConductingTraining");
		LOGGER.info("Request Received from front end to get Total Training Centres conducting training for FAQ");
		try
		{
			LOGGER.info("In TRY block");
			LOGGER.info("Sending Request to service");
			return fAQService.getCountOfTotalTrainingCentresConductingTraining();
		}
		catch(Exception exception)
		{
			LOGGER.info("In CATCH block");
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			LOGGER.info("returning NULL");
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping(value="/getFAQCountOfCandidatesAssessmentUpcomingForAMonth",method=RequestMethod.POST)
	public Integer getCountOfCandidatesAssessmentUpcomingForAMonth(@RequestParam("month") String month) {
		LOGGER.info("In FAQController - getCountOfCandidatesAssessmentUpcomingForAMonth");
		LOGGER.info("Request Received from front end to get Total Candidates Assessment Upcoming for a month for FAQ");
		LOGGER.info("Parameters Received from front end are - 'month': ",month);
		try
		{
			LOGGER.info("In TRY block");
			LOGGER.info("Sending Request to service");
			return fAQService.getCountOfCandidatesAssessmentUpcomingForAMonth(month);
		}
		catch(Exception exception)
		{
			LOGGER.info("In CATCH block");
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			LOGGER.info("returning NULL");
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping(value="/getFAQNameOfAgencyToWhichABatchIsAssigned",method=RequestMethod.POST)
	public String getNameOfAgencyToWhichABatchIsAssigned(@RequestParam("batchId") Integer batchId)throws EmptyResultDataAccessException {
		LOGGER.info("In FAQController - getNameOfAgencyToWhichABatchIsAssigned");
		LOGGER.info("Request Received from front end to get Agency Name to which a Batch is Assigned for FAQ");
		LOGGER.info("Parameters Received from front end are - 'batchId': ",batchId);
		try
		{
			LOGGER.info("In TRY block");
			LOGGER.info("Sending Request to service");
			return fAQService.getNameOfAgencyToWhichABatchIsAssigned(batchId);
		}
		catch(Exception exception)
		{
			LOGGER.info("In CATCH block");
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			LOGGER.info("returning NULL");
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping(value="/getFAQTotalCountOfBatchesAssignedToAAssessmentAgency",method=RequestMethod.POST)
	public Integer getTotalCountOfBatchesAssignedToAAssessmentAgency(@RequestParam("agencyName") String agencyName)throws EmptyResultDataAccessException {
		LOGGER.info("In FAQController - getTotalCountOfBatchesAssignedToAAssessmentAgency");
		LOGGER.info("Request Received from front end to get Total Batches assigned to a Assessment Agency for FAQ");
		LOGGER.info("Parameters Received from front end are - 'agencyName': ",agencyName);
		try
		{
			LOGGER.info("In TRY block");
			LOGGER.info("Sending Request to service");
			return fAQService.getTotalCountOfBatchesAssignedToAAssessmentAgency(agencyName);
		}
		catch(Exception exception)
		{
			LOGGER.info("In CATCH block");
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			LOGGER.info("returning NULL");
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping(value="/getFAQCountOfTotalNumberOfBatchesAndTotalEnrolledInAParticularState",method=RequestMethod.POST)
	public Collection<FAQTotalNumberOfBatchesAndTotalEnrolledInAParticularStateDto> getCountOfTotalNumberOfBatchesAndTotalEnrolledInAParticularState(@RequestParam("state") String state) {
		LOGGER.info("In FAQController - getCountOfTotalNumberOfBatchesAndTotalEnrolledInAParticularState");
		LOGGER.info("Request Received from front end to get Total Batches and Total Candidates Enrolled In a Particular state for FAQ");
		LOGGER.info("Parameters Received from front end are - 'state': ",state);
		
		try
		{
			LOGGER.info("In TRY block");
			LOGGER.info("Sending Request to service");
			return fAQService.getCountOfTotalNumberOfBatchesAndTotalEnrolledInAParticularState(state);
		}
		catch(Exception exception)
		{
			LOGGER.info("In CATCH block");
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			LOGGER.info("returning NULL");
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping(value="/getFAQCountOfTotalNumberOfBatchesAndTotalEnrolledInAParticularScheme",method=RequestMethod.POST)
	public Collection<FAQTotalNumberOfBatchesAndTotalEnrolledInAParticularStateDto> getCountTotalNumberOfBatchesInAParticularScheme(@RequestParam("batchType") String batchType) {
		LOGGER.info("In FAQController - getCountTotalNumberOfBatchesInAParticularScheme");
		LOGGER.info("Request Received from front end to get Total Batches and Total Candidates Enrolled In a Particular scheme for FAQ");
		LOGGER.info("Parameters Received from front end are - 'batchType': ",batchType);
		try
		{
			LOGGER.info("In TRY block");
			LOGGER.info("Sending Request to service");
			return fAQService.getCountOfTotalNumberOfBatchesAndTotalEnrolledInAParticularStateSchemeWise(batchType);
		}
		catch(Exception exception)
		{
			LOGGER.info("In CATCH block");
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			LOGGER.info("returning NULL");
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping(value="/getFAQCountTotalAssessorsOfAParticularAgencyInAParticularState",method=RequestMethod.POST)
	public Integer getCountTotalAssessorsOfAParticularAgencyInAParticularState(@RequestParam("agencyName") String agencyName, @RequestParam("state") String state) {
		LOGGER.info("In FAQController - getCountTotalAssessorsOfAParticularAgencyInAParticularState");
		LOGGER.info("Request Received from front end to get Total Assessors Of A particular Agency in a particular State for FAQ");
		LOGGER.info("Parameters Received from front end are - 'agencyName':"+agencyName+" 'state': ",state);
		try
		{
			LOGGER.info("In TRY block");
			LOGGER.info("Sending Request to service");
			return fAQService.getCountTotalAssessorsOfAParticularAgencyInAParticularState(agencyName, state);
		}
		catch(Exception exception)
		{
			LOGGER.info("In CATCH block");
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			LOGGER.info("returning NULL");
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping(value="/getFAQStatusOfAParticularBatchWithId",method=RequestMethod.POST)
	public Collection<FAQStatusOfAParticularBatchWithIdDto> getStatusOfAParticularBatchWithId(@RequestParam("batchId") Integer batchId) {
		LOGGER.info("In FAQController - getStatusOfAParticularBatchWithId");
		LOGGER.info("Request Received from front end to get Status of A Partcular batch for FAQ");
		LOGGER.info("Parameters Received from front end are - 'batchId': ",batchId);
		try
		{
			LOGGER.info("In TRY block");
			LOGGER.info("Sending Request to service");
			return fAQService.getStatusOfAParticularBatchWithId(batchId);
		}
		catch(Exception exception)
		{
			LOGGER.info("In CATCH block");
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			LOGGER.info("returning NULL");
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping(value="/getFAQCountBatchesForWhichResultIsPending")
	public Integer getCountBatchesForWhichResultIsPending() {
		LOGGER.info("In FAQController - getCountBatchesForWhichResultIsPending");
		LOGGER.info("Request Received from front end to get Total Batches for which Result is Pending for FAQ");
		try
		{
			LOGGER.info("In TRY block");
			LOGGER.info("Sending Request to service");
			return fAQService.getCountBatchesForWhichResultIsPending();
		}
		catch(Exception exception)
		{
			LOGGER.info("In CATCH block");
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			LOGGER.info("returning NULL");
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping(value="/getFAQBatchWiseCandidatesDetails",method=RequestMethod.POST)
	public Collection<FAQBatchWiseCandidateDetailsDto> getBatchWiseCandidatesDetails(@RequestParam("batchId") Integer batchId) {
		LOGGER.info("In FAQController - getBatchWiseCandidatesDetails");
		LOGGER.info("Request Received from front end to get Batche wise Candidate details for FAQ");
		LOGGER.info("Parameters Received from front end are - 'batchId': ",batchId);
		try
		{
			LOGGER.info("In TRY block");
			LOGGER.info("Sending Request to service");
			return fAQService.getBatchWiseCandidatesDetails(batchId);
		}
		catch(Exception exception)
		{
			LOGGER.info("In CATCH block");
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			LOGGER.info("returning NULL");
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping("/getFAQCountTotalNonAssignedBatches")
	public Integer getCountTotalNonAssignedBatches() {
		LOGGER.info("In FAQController - getCountTotalNonAssignedBatches");
		LOGGER.info("Request Received from front end to get Total Non-Assigned Batches for FAQ");
		try
		{
			LOGGER.info("In TRY block");
			LOGGER.info("Sending Request to service");
			return fAQService.getCountTotalNonAssignedBatches();
		}
		catch(Exception exception)
		{
			LOGGER.info("In CATCH block");
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			LOGGER.info("returning NULL");
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping("/getFAQTrainingCentresNotTakingAnyBatches")
	public Collection<FAQTrainingCentresNotTakingAnyBatchesDto> getTrainingCentresNotTakingAnyBatchesc(){
		LOGGER.info("In FAQController - getTrainingCentresNotTakingAnyBatchesc");
		LOGGER.info("Request Received from front end to get Training centres not taking any Batches for FAQ");
		try
		{
			LOGGER.info("In TRY block");
			LOGGER.info("Sending Request to service");
			return fAQService.getTrainingCentresNotTakingAnyBatches();
		}
		catch(Exception exception)
		{
			LOGGER.info("In CATCH block");
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			LOGGER.info("returning NULL");
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping(method=RequestMethod.POST,value="/getFAQCandidatesEnrolledAssessedCertifiedMonthWise")
	public Collection<FAQCandidatesEnrolledAssessedCertifiedMonthWiseDto> getCountTotalCandidatesEnrolledMonthWise(@RequestParam("year") Integer year, @RequestParam("candidates") String candidates) {
		LOGGER.info("In FAQController - getCountTotalCandidatesEnrolledMonthWise");
		LOGGER.info("Request Received from front end to get Total Candidates Enrolled or Assessed or Certified in a Particular year for FAQ");
		LOGGER.info("Parameters Received from front end are - 'year': "+year+" 'candidates:'",candidates);
		try
		{
			LOGGER.info("In TRY block");
			if(candidates.equalsIgnoreCase("Enrolled"))
			{
				LOGGER.info("Selected field is - Enrolled");
				LOGGER.info("Sending Request to service");
				return fAQService.getCountOfFAQCandidatesEnrolledMonthWise(year);
			}
			else if(candidates.equalsIgnoreCase("Assessed"))
			{
				LOGGER.info("Selected field is - Assessed");
				LOGGER.info("Sending Request to service");
				return fAQService.getCountOfFAQCandidatesAssessedMonthWise(year);
			}
			else if(candidates.equalsIgnoreCase("Certified"))
			{
				LOGGER.info("Selected field is - Certified");
				LOGGER.info("Sending Request to service");
				return fAQService.getCountOfFAQCandidatesCertifiedMonthWise(year);
			}
			else
			{
				LOGGER.info("Selected field is - Unknown");
				LOGGER.error("Incorrect Value for the selected type 'Candidate' or 'Year'");
				LOGGER.info("Returning NULL");
				return null;
			}
		}
		catch(Exception e)
		{
			LOGGER.info("In CATCH block");
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+e);
			LOGGER.info("returning NULL");
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping(method=RequestMethod.POST,value="/getFAQCandidatesEnrolledAssessedCertifiedMonthAndSchemeWise")
	public Collection<FAQCandidatesEnrolledAssessedCertifiedMonthWiseDto> getCountTotalCandidatesEnrolledMonthAndSchemeWise(@RequestParam("year") Integer year, @RequestParam("candidates") String candidates, @RequestParam("batchType") String batchType)
	{
		LOGGER.info("In FAQController - getCountTotalCandidatesEnrolledMonthAndSchemeWise");
		LOGGER.info("Request Received from front end to get Total Candidates Enrolled or Assessed or Certified in a Particular year For a particular Scheme for FAQ");
		LOGGER.info("Parameters Received from front end are - 'year': "+year+" 'candidates:'"+candidates+" 'batchType:'",batchType);
		try
		{
			LOGGER.info("In TRY block");
			if(candidates.equalsIgnoreCase("Enrolled"))
			{
				LOGGER.info("Selected field is - Enrolled");
				LOGGER.info("Sending Request to service");
				return fAQService.getCountOfFAQCandidatesEnrolledMonthAndSchemeWise(year, batchType);
			}
			else if(candidates.equalsIgnoreCase("Assessed"))
			{
				LOGGER.info("Selected field is - Assessed");
				LOGGER.info("Sending Request to service");
				return fAQService.getCountOfFAQCandidatesAssessedMonthAndSchemeWise(year, batchType);
			}
			else if(candidates.equalsIgnoreCase("Certified"))
			{
				LOGGER.info("Selected field is - Certified");
				LOGGER.info("Sending Request to service");
				return fAQService.getCountOfFAQCandidatesCertifiedMonthAndSchemeWise(year, batchType);
			}
			else
			{
				LOGGER.info("Selected field is - Unknown");
				LOGGER.error("Incorrect Value for the selected type 'Candidate' or 'Year'");
				LOGGER.info("Returning NULL");
				return null;
			}
		}
		catch(Exception e)
		{
			LOGGER.info("In CATCH block");
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+e);
			LOGGER.info("returning NULL");
			return null;
		}
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping(method=RequestMethod.POST,value="/getFAQTotalBatchesWithTotalCandidatesEnrolledYearWise")
	public Collection<FAQTotalBatchesWithTotalCandidatesEnrolledMonthWiseDto> getTotalBatchesWithTotalCandidatesEnrolledYearWise(@RequestParam("year") int year) {
		LOGGER.info("In FAQController - getTotalBatchesWithTotalCandidatesEnrolledYearWise");
		LOGGER.info("Request Received from front end to get Total Batches with Total Candidates Enrolled in a Particular year for FAQ");
		LOGGER.info("Parameters Received from front end are - 'year': ",year);
		try
		{
			LOGGER.info("In TRY block");
			LOGGER.info("Sending Request to service");
			return fAQService.getTotalBatchesWithTotalCandidatesEnrolledYearWise(year);
		}
		catch(Exception exception)
		{
			LOGGER.info("In CATCH block");
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+exception);
			LOGGER.info("returning NULL");
			return null;
		}
		
	}
	
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public void handleMissingParams(MissingServletRequestParameterException exception) {
		LOGGER.info("In FAQController Handling Exceptions Missing Parameters - handleMissingParams");
		String parameterName = exception.getParameterName();
	    LOGGER.error(parameterName + " parameter is missing");
	    // Handling Missing Parameters Exceptions Here
	}
}
