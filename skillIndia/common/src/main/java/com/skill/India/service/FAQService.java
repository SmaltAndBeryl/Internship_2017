package com.skill.India.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.skill.India.dao.FAQBatchWiseCandidateDetailsDao;
import com.skill.India.dao.FAQCandidatesEnrolledAssessedCertifiedMonthWiseDao;
import com.skill.India.dao.FAQCandidatesTrainedAssessedCertifiedDao;
import com.skill.India.dao.FAQQuestionsCommonDao;
import com.skill.India.dao.FAQStatusOfAParticularBatchWithIdDao;
import com.skill.India.dao.FAQTotalBatchesWithTotalCandidatesEnrolledYearWiseDao;
import com.skill.India.dao.FAQTotalNumberOfBatchesAndTotalEnrolledInAParticularStateDao;
import com.skill.India.dao.FAQTrainingCentresNotTakingAnyBatchesDao;
import com.skill.India.dto.FAQBatchWiseCandidateDetailsDto;
import com.skill.India.dto.FAQCandidatesEnrolledAssessedCertifiedMonthWiseDto;
import com.skill.India.dto.FAQCandidatesTrainedAssessedCertifiedDto;
import com.skill.India.dto.FAQStatusOfAParticularBatchWithIdDto;
import com.skill.India.dto.FAQTotalBatchesWithTotalCandidatesEnrolledMonthWiseDto;
import com.skill.India.dto.FAQTotalNumberOfBatchesAndTotalEnrolledInAParticularStateDto;
import com.skill.India.dto.FAQTrainingCentresNotTakingAnyBatchesDto;

/**
 * @author Aashish sharma
 *
 */
@Service
public class FAQService {
	
	@Autowired
	private FAQCandidatesTrainedAssessedCertifiedDao fAQCandidatesTrainedAssessedCertifiedDao;
	
	@Autowired
	private FAQQuestionsCommonDao fAQQuestionCommonDao;
	
	@Autowired
	private FAQTotalBatchesWithTotalCandidatesEnrolledYearWiseDao fAQTotalBatchesWithTotalCandidatesEnrolledYearWiseDao;
	
	@Autowired
	private FAQStatusOfAParticularBatchWithIdDao fAQStatusOfAParticularBatchWithIdDao;
	
	@Autowired
	private FAQBatchWiseCandidateDetailsDao fAQBatchWiseCandidateDetailsDao;
	
	@Autowired
	private FAQCandidatesEnrolledAssessedCertifiedMonthWiseDao fAQCandidatesEnrolledAssessedCertifiedMonthWiseDao;
	
	@Autowired
	private FAQTotalNumberOfBatchesAndTotalEnrolledInAParticularStateDao fAQTotalNumberOfBatchesAndTotalEnrolledInAParticularStateDao;
	
	@Autowired
	private FAQTrainingCentresNotTakingAnyBatchesDao fAQTrainingCentresNotTakingAnyBatchesDao;
	
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
	
	public Integer getCountOfCandidatesAssessmentUpcomingForAMonth(String month) {
		return fAQQuestionCommonDao.getCountOfCandidatesAssessmentUpcomingForAMonth(month);
	}
	
	public String getNameOfAgencyToWhichABatchIsAssigned(Integer batchId)throws EmptyResultDataAccessException {
		return fAQQuestionCommonDao.getNameOfAgencyToWhichABatchIsAssigned(batchId);
	}
	
	public Integer getTotalCountOfBatchesAssignedToAAssessmentAgency(String agencyName)throws EmptyResultDataAccessException {
		return fAQQuestionCommonDao.getTotalCountOfBatchesAssignedToAAssessmentAgency(agencyName);
	}
	
	public Collection<FAQTotalNumberOfBatchesAndTotalEnrolledInAParticularStateDto> getCountOfTotalNumberOfBatchesAndTotalEnrolledInAParticularState(String state) {
		return fAQTotalNumberOfBatchesAndTotalEnrolledInAParticularStateDao.getCountOfTotalNumberOfBatchesAndTotalEnrolledInAParticularState(state);
	}
	
	public Collection<FAQTotalNumberOfBatchesAndTotalEnrolledInAParticularStateDto> getCountOfTotalNumberOfBatchesAndTotalEnrolledInAParticularStateSchemeWise(String batchType) {
		return fAQTotalNumberOfBatchesAndTotalEnrolledInAParticularStateDao.getCountOfTotalNumberOfBatchesAndTotalEnrolledInAParticularStateSchemeWise(batchType);
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
	
	public Collection<FAQCandidatesEnrolledAssessedCertifiedMonthWiseDto> getCountOfFAQCandidatesEnrolledMonthWise(int year) {
		return fAQCandidatesEnrolledAssessedCertifiedMonthWiseDao.getCountTotalCandidatesEnrolledMonthWise(year);
	}
	
	public Collection<FAQCandidatesEnrolledAssessedCertifiedMonthWiseDto> getCountOfFAQCandidatesAssessedMonthWise(int year) {
		return fAQCandidatesEnrolledAssessedCertifiedMonthWiseDao.getCountTotalCandidatesAssessedMonthWise(year);
	}
	
	public Collection<FAQCandidatesEnrolledAssessedCertifiedMonthWiseDto> getCountOfFAQCandidatesCertifiedMonthWise(int year) {
		return fAQCandidatesEnrolledAssessedCertifiedMonthWiseDao.getCountTotalCandidatesCertifiedMonthWise(year);
	}
	
	public Collection<FAQCandidatesEnrolledAssessedCertifiedMonthWiseDto> getCountOfFAQCandidatesEnrolledMonthAndSchemeWise(int year,String batchType) {
		return fAQCandidatesEnrolledAssessedCertifiedMonthWiseDao.getCountTotalCandidatesEnrolledMonthAndSchemeWise(year, batchType);
	}
	
	public Collection<FAQCandidatesEnrolledAssessedCertifiedMonthWiseDto> getCountOfFAQCandidatesAssessedMonthAndSchemeWise(int year,String batchType) {
		return fAQCandidatesEnrolledAssessedCertifiedMonthWiseDao.getCountTotalCandidatesAssessedMonthAndSchemeWise(year, batchType);
	}
	
	public Collection<FAQCandidatesEnrolledAssessedCertifiedMonthWiseDto> getCountOfFAQCandidatesCertifiedMonthAndSchemeWise(int year,String batchType) {
		return fAQCandidatesEnrolledAssessedCertifiedMonthWiseDao.getCountTotalCandidatesCertifiedMonthAndSchemeWise(year, batchType);
	}
	
	public Collection<FAQTrainingCentresNotTakingAnyBatchesDto> getTrainingCentresNotTakingAnyBatches() {
		return fAQTrainingCentresNotTakingAnyBatchesDao.getTotalTrainingCentresNotTakingAnyBatches();
	}
	
	public Collection<FAQTotalBatchesWithTotalCandidatesEnrolledMonthWiseDto> getTotalBatchesWithTotalCandidatesEnrolledYearWise(int year) {
		return fAQTotalBatchesWithTotalCandidatesEnrolledYearWiseDao.getTotalBatchesWithTotalCandidatesEnrolledYearWise(year);
	}
}
