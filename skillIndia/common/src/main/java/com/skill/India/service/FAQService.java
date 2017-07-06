package com.skill.India.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.skill.India.dao.FAQBatchWiseCandidateDetailsDao;
import com.skill.India.dao.FAQCandidatesTrainedAssessedCertifiedDao;
import com.skill.India.dao.FAQQuestionsCommonDao;
import com.skill.India.dao.FAQStatusOfAParticularBatchWithIdDao;
import com.skill.India.dto.FAQBatchWiseCandidateDetailsDto;
import com.skill.India.dto.FAQCandidatesTrainedAssessedCertifiedDto;
import com.skill.India.dto.FAQStatusOfAParticularBatchWithIdDto;

@Service
public class FAQService {
	
	@Autowired
	private FAQCandidatesTrainedAssessedCertifiedDao fAQCandidatesTrainedAssessedCertifiedDao;
	
	@Autowired
	private FAQQuestionsCommonDao fAQQuestionCommonDao;
	
	@Autowired
	private FAQStatusOfAParticularBatchWithIdDao fAQStatusOfAParticularBatchWithIdDao;
	
	@Autowired
	private FAQBatchWiseCandidateDetailsDao fAQBatchWiseCandidateDetailsDao;
	
	public Collection<FAQCandidatesTrainedAssessedCertifiedDto> getTotalCandidatesTrainedAssessedCertifiedDao() {
		return fAQCandidatesTrainedAssessedCertifiedDao.getTotalCandidatesTrainedAssessedCertified();
	}
	
	public Collection<FAQCandidatesTrainedAssessedCertifiedDto> getTotalCandidatesTrainedAssessedCertifiedSchemeWise(String batchType) {
		if(batchType.equals("PMKVY"))
		{
			batchType="Star";
		}
		else
		{
			batchType="Non-Star";
		}
		return fAQCandidatesTrainedAssessedCertifiedDao.getTotalCandidatesTrainedAssessedCertifiedSchemeWise(batchType);
	}
	
	public Integer getTotalTrainingCentresInAState(String state) {
		return fAQQuestionCommonDao.getTotalTrainingCentresInAState(state);
	}

	public Integer getCountOfTotalTrainingCentresConductingTraining() {
		return fAQQuestionCommonDao.getCountOfTotalTrainingCentresConductingTraining();
	}
	
	public Integer getCountOfCandidatesAssessmentUpcomingForAMonth(String month) {
		return fAQQuestionCommonDao.getCountOfCandidatesAssessmentUpcomingForAMonth(month);
	}
	
	public String getNameOfAgencyToWhichABatchIsAssigned(Integer batchId)throws EmptyResultDataAccessException {
		return fAQQuestionCommonDao.getNameOfAgencyToWhichABatchIsAssigned(batchId);
	}
	
	public Integer getTotalCountOfBatchesAssignedToAAssessmentAgency(String agencyName)throws EmptyResultDataAccessException {
		return fAQQuestionCommonDao.getTotalCountOfBatchesAssignedToAAssessmentAgency(agencyName);
	}
	
	public Integer getCountTotalNumberOfBatchesInAParticularState(String state) {
		return fAQQuestionCommonDao.getCountTotalNumberOfBatchesInAParticularState(state);
	}
	
	public Integer getTotalNumberOfBatchesInAParticularScheme(String batchType) {
		if(batchType.equals("PMKVY"))
		{
			batchType="Star";
		}
		else
		{
			batchType="Non-Star";
		}
		return fAQQuestionCommonDao.getCountTotalNumberOfBatchesInAParticularScheme(batchType);
	}
	
	public Integer getCountTotalAssessorsOfAParticularAgencyInAParticularState(String agencyName,String state) {
		return fAQQuestionCommonDao.getCountTotalAssessorsOfAParticularAgencyInAParticularState(agencyName, state);
	}
	
	public Collection<FAQStatusOfAParticularBatchWithIdDto> getStatusOfAParticularBatchWithId(Integer batchId) {
		return fAQStatusOfAParticularBatchWithIdDao.getStatusOfAParticularBatchWithId(batchId);
	}
	
	public Integer getCountBatchesForWhichResultIsPending() {
		return fAQQuestionCommonDao.getCountBatchesForWhichResultIsPending();
	}
	
	public Collection<FAQBatchWiseCandidateDetailsDto> getBatchWiseCandidatesDetails(Integer batchId) {
		return fAQBatchWiseCandidateDetailsDao.getBatchWiseCandidatesDetails(batchId);
	}

	public Integer getCountTotalNonAssignedBatches() {
		return fAQQuestionCommonDao.getCountTotalNonAssignedBatches();
	}
}
