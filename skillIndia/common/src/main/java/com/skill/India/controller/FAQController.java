package com.skill.India.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.dto.FAQBatchWiseCandidateDetailsDto;
import com.skill.India.dto.FAQCandidatesTrainedAssessedCertifiedDto;
import com.skill.India.dto.FAQStatusOfAParticularBatchWithIdDto;
import com.skill.India.service.FAQService;

@RestController
public class FAQController {
	
	@Autowired
	private FAQService fAQService;
	
	
	@RequestMapping("/getFAQTotalCandidatesTrainedAssessedCertified")
	public Collection<FAQCandidatesTrainedAssessedCertifiedDto> getTotalCandidatesTrainedAssessedCertified()  {
		return fAQService.getTotalCandidatesTrainedAssessedCertifiedDao();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/getFAQTotalCandidatesTrainedAssessedCertifiedSchemeWise")
	public Collection<FAQCandidatesTrainedAssessedCertifiedDto> getTotalCandidatesTrainedAssessedCertifiedSchemeWise(@RequestParam("batchType") String batchType) {
		return fAQService.getTotalCandidatesTrainedAssessedCertifiedSchemeWise(batchType);
	}
	
	@RequestMapping(value="/getFAQTotalTrainingCentresInAState",method=RequestMethod.POST)
	public Integer getTotalTrainingCentresInAState(@RequestParam("state") String state) {
		return fAQService.getTotalTrainingCentresInAState(state);
	}
	
	@RequestMapping(value="/getFAQCountOfTotalTrainingCentresConductingTraining")
	public Integer getCountOfTotalTrainingCentresConductingTraining() {
		return fAQService.getCountOfTotalTrainingCentresConductingTraining();
	}
	
	@RequestMapping(value="/getFAQCountOfCandidatesAssessmentUpcomingForAMonth",method=RequestMethod.POST)
	public Integer getCountOfCandidatesAssessmentUpcomingForAMonth(@RequestParam("month") String month) {
		return fAQService.getCountOfCandidatesAssessmentUpcomingForAMonth(month);
	}
	
	@RequestMapping(value="/getFAQNameOfAgencyToWhichABatchIsAssigned",method=RequestMethod.POST)
	public String getNameOfAgencyToWhichABatchIsAssigned(@RequestParam("batchId") Integer batchId)throws EmptyResultDataAccessException {
		return fAQService.getNameOfAgencyToWhichABatchIsAssigned(batchId);
	}
	
	@RequestMapping(value="/getFAQTotalCountOfBatchesAssignedToAAssessmentAgency",method=RequestMethod.POST)
	public Integer getTotalCountOfBatchesAssignedToAAssessmentAgency(@RequestParam("agencyName") String agencyName)throws EmptyResultDataAccessException {
		return fAQService.getTotalCountOfBatchesAssignedToAAssessmentAgency(agencyName);
	}
	
	@RequestMapping(value="/getFAQCountTotalNumberOfBatchesInAParticularState",method=RequestMethod.POST)
	public Integer getCountTotalNumberOfBatchesInAParticularState(@RequestParam("state") String state) {
		return fAQService.getCountTotalNumberOfBatchesInAParticularState(state);
	}
	
	@RequestMapping(value="getFAQTotalNumberOfBatchesInAParticularScheme",method=RequestMethod.POST)
	public Integer getCountTotalNumberOfBatchesInAParticularScheme(@RequestParam("batchType") String batchType) {
		return fAQService.getTotalNumberOfBatchesInAParticularScheme(batchType);
	}
	
	@RequestMapping(value="/getFAQCountTotalAssessorsOfAParticularAgencyInAParticularState",method=RequestMethod.POST)
	public Integer getCountTotalAssessorsOfAParticularAgencyInAParticularState(@RequestParam("agencyName") String agencyName, @RequestParam("state") String state) {
		return fAQService.getCountTotalAssessorsOfAParticularAgencyInAParticularState(agencyName, state);
	}
	
	@RequestMapping(value="/getFAQStatusOfAParticularBatchWithId",method=RequestMethod.POST)
	public Collection<FAQStatusOfAParticularBatchWithIdDto> getStatusOfAParticularBatchWithId(@RequestParam("batchId") Integer batchId) {
		return fAQService.getStatusOfAParticularBatchWithId(batchId);
	}
	
	@RequestMapping(value="/getFAQCountBatchesForWhichResultIsPending")
	public Integer getCountBatchesForWhichResultIsPending() {
		return fAQService.getCountBatchesForWhichResultIsPending();
	}
	
	@RequestMapping(value="/getFAQBatchWiseCandidatesDetails",method=RequestMethod.POST)
	public Collection<FAQBatchWiseCandidateDetailsDto> getBatchWiseCandidatesDetails(@RequestParam("batchId") Integer batchId) {
		return fAQService.getBatchWiseCandidatesDetails(batchId);
	}
	
	@RequestMapping("/getFAQCountTotalNonAssignedBatches")
	public Integer getCountTotalNonAssignedBatches() {
		return fAQService.getCountTotalNonAssignedBatches();
	}
	
	@RequestMapping("/getFAQCountTotalTrainingCentresNotTakingAnyBatches")
	public Integer getCountTotalTrainingCentresNotTakingAnyBatches(){
		return fAQService.getCountTotalTrainingCentresNotTakingAnyBatches();
	}
}
