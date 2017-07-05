package com.skill.India.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.FAQCandidatesTrainedAssessedCertifiedDao;
import com.skill.India.dao.FAQQuestionCommonDao;
import com.skill.India.dto.FAQCandidatesTrainedAssessedCertifiedDto;

@Service
public class FAQService {
	
	@Autowired
	private FAQCandidatesTrainedAssessedCertifiedDao fAQCandidatesTrainedAssessedCertifiedDao;
	
	@Autowired
	private FAQQuestionCommonDao fAQQuestionCommonDao;
	
	public Collection<FAQCandidatesTrainedAssessedCertifiedDto> getTotalCandidatesTrainedAssessedCertifiedDao() {
		return fAQCandidatesTrainedAssessedCertifiedDao.getTotalCandidatesTrainedAssessedCertified();
	}
	
	public Collection<FAQCandidatesTrainedAssessedCertifiedDto> getTotalCandidatesTrainedAssessedCertifiedSchemeWise(String batchType) {
		return fAQCandidatesTrainedAssessedCertifiedDao.getTotalCandidatesTrainedAssessedCertifiedSchemeWise(batchType);
	}
	
	public Integer getTotalTrainingCentresInAState(String state) {
		return fAQQuestionCommonDao.getTotalTrainingCentresInAState(state);
	}

	public Integer getCountOfTotalTrainingCentresConductingTraining() {
		return fAQQuestionCommonDao.getCountOfTotalTrainingCentresConductingTraining();
	}
}
