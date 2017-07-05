package com.skill.India.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.dto.FAQCandidatesTrainedAssessedCertifiedDto;
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
}
