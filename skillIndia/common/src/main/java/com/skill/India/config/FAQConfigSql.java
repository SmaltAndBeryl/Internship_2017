package com.skill.India.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
 * @author Aashish sharma
 *
 */

@Component
@ConfigurationProperties(prefix="faq",locations="classpath:sql/fAQ.yml")
public class FAQConfigSql {
	
	private String selectSqlCountTotalCandidatesTrainedAssessedCertified;
	
	private String selectSqlTotalCandidatesTrainedAssessedCertifiedSchemeWise;
	
	private String selectSqlCountTotalTrainingCentresInAState;
	
	private String selectSqlCountTrainingCentresConductingTraining;
	
	private String selectSqlCountOfCandidatesAssessmentUpcomingForAMonth;
	
	private String selectSqlNameOfAgencyToWhichABatchIsAssigned;
	
	private String selectSqlCountTotalOfBatchesAssignedToAAssessmentAgency;
	
	private String selectSqlCountTotalNumberOfBatchesAndTotalEnrolledInAParticularState;
	
	private String selectSqlCountTotalNumberOfBatchesAndTotalEnrolledInAParticularStateSchemeWise;
	
	private String selectSqlCountTotalAssessorsOfAParticularAgencyInAParticularState;
	
	private String selectSqlStatusOfAParticularBatchWithId;
	
	private String selectSqlCountBatchesForWhichResultIsPending;
	
	private String selectSqlCountTotalNonAssignedBatches;
	
	private String selectSqlBatchWiseCandidatesDetails;
	
	private String selectSqTrainingCentresNotTakingAnyBatches;

	private String selectSqlCountTotalCandidatesEnrolledMonthWise;
	
	private String selectSqlCountTotalCandidatesCertifiedMonthWise;
	
	private String selectSqlCountTotalCandidatesAssessedMonthWise;
	
	private String selectSqlCountTotalCandidatesEnrolledMonthAndSchemeWise;
	
	private String selectSqlCountTotalCandidatesAssessedMonthAndSchemeWise;
	
	private String selectSqlCountTotalCandidatesCertifiedMonthAndSchemeWise;
	
	private String selectSqlTotalBatchesWithTotalCandidatesEnrolledYearWise;
	
	/**
	 * @return the selectSqlTotalBatchesWithTotalCandidatesEnrolledYearWise
	 */
	public String getSelectSqlTotalBatchesWithTotalCandidatesEnrolledYearWise() {
		return selectSqlTotalBatchesWithTotalCandidatesEnrolledYearWise;
	}

	/**
	 * @param selectSqlTotalBatchesWithTotalCandidatesEnrolledYearWise the selectSqlTotalBatchesWithTotalCandidatesEnrolledYearWise to set
	 */
	public void setSelectSqlTotalBatchesWithTotalCandidatesEnrolledYearWise(
			String selectSqlTotalBatchesWithTotalCandidatesEnrolledYearWise) {
		this.selectSqlTotalBatchesWithTotalCandidatesEnrolledYearWise = selectSqlTotalBatchesWithTotalCandidatesEnrolledYearWise;
	}

	/**
	 * @return the selectSqlCountTotalCandidatesEnrolledMonthAndSchemeWise
	 */
	public String getSelectSqlCountTotalCandidatesEnrolledMonthAndSchemeWise() {
		return selectSqlCountTotalCandidatesEnrolledMonthAndSchemeWise;
	}

	/**
	 * @param selectSqlCountTotalCandidatesEnrolledMonthAndSchemeWise the selectSqlCountTotalCandidatesEnrolledMonthAndSchemeWise to set
	 */
	public void setSelectSqlCountTotalCandidatesEnrolledMonthAndSchemeWise(
			String selectSqlCountTotalCandidatesEnrolledMonthAndSchemeWise) {
		this.selectSqlCountTotalCandidatesEnrolledMonthAndSchemeWise = selectSqlCountTotalCandidatesEnrolledMonthAndSchemeWise;
	}

	/**
	 * @return the selectSqlCountTotalCandidatesAssessedMonthAndSchemeWise
	 */
	public String getSelectSqlCountTotalCandidatesAssessedMonthAndSchemeWise() {
		return selectSqlCountTotalCandidatesAssessedMonthAndSchemeWise;
	}

	/**
	 * @param selectSqlCountTotalCandidatesAssessedMonthAndSchemeWise the selectSqlCountTotalCandidatesAssessedMonthAndSchemeWise to set
	 */
	public void setSelectSqlCountTotalCandidatesAssessedMonthAndSchemeWise(
			String selectSqlCountTotalCandidatesAssessedMonthAndSchemeWise) {
		this.selectSqlCountTotalCandidatesAssessedMonthAndSchemeWise = selectSqlCountTotalCandidatesAssessedMonthAndSchemeWise;
	}

	/**
	 * @return the selectSqlCountTotalCandidatesCertifiedMonthAndSchemeWise
	 */
	public String getSelectSqlCountTotalCandidatesCertifiedMonthAndSchemeWise() {
		return selectSqlCountTotalCandidatesCertifiedMonthAndSchemeWise;
	}

	/**
	 * @param selectSqlCountTotalCandidatesCertifiedMonthAndSchemeWise the selectSqlCountTotalCandidatesCertifiedMonthAndSchemeWise to set
	 */
	public void setSelectSqlCountTotalCandidatesCertifiedMonthAndSchemeWise(
			String selectSqlCountTotalCandidatesCertifiedMonthAndSchemeWise) {
		this.selectSqlCountTotalCandidatesCertifiedMonthAndSchemeWise = selectSqlCountTotalCandidatesCertifiedMonthAndSchemeWise;
	}

	/**
	 * @return the selectSqlCountTotalCandidatesAssessedMonthWise
	 */
	public String getSelectSqlCountTotalCandidatesAssessedMonthWise() {
		return selectSqlCountTotalCandidatesAssessedMonthWise;
	}

	/**
	 * @param selectSqlCountTotalCandidatesAssessedMonthWise the selectSqlCountTotalCandidatesAssessedMonthWise to set
	 */
	public void setSelectSqlCountTotalCandidatesAssessedMonthWise(
			String selectSqlCountTotalCandidatesAssessedMonthWise) {
		this.selectSqlCountTotalCandidatesAssessedMonthWise = selectSqlCountTotalCandidatesAssessedMonthWise;
	}

	/**
	 * @return the selectSqlCountTotalCandidatesCertifiedMonthWise
	 */
	public String getSelectSqlCountTotalCandidatesCertifiedMonthWise() {
		return selectSqlCountTotalCandidatesCertifiedMonthWise;
	}

	/**
	 * @param selectSqlCountTotalCandidatesCertifiedMonthWise the selectSqlCountTotalCandidatesCertifiedMonthWise to set
	 */
	public void setSelectSqlCountTotalCandidatesCertifiedMonthWise(
			String selectSqlCountTotalCandidatesCertifiedMonthWise) {
		this.selectSqlCountTotalCandidatesCertifiedMonthWise = selectSqlCountTotalCandidatesCertifiedMonthWise;
	}

	/**
	 * @return the selectSqlCountTotalCandidatesEnrolledMonthWise
	 */
	public String getSelectSqlCountTotalCandidatesEnrolledMonthWise() {
		return selectSqlCountTotalCandidatesEnrolledMonthWise;
	}

	/**
	 * @param selectSqlCountTotalCandidatesEnrolledMonthWise the selectSqlCountTotalCandidatesEnrolledMonthWise to set
	 */
	public void setSelectSqlCountTotalCandidatesEnrolledMonthWise(
			String selectSqlCountTotalCandidatesEnrolledMonthWise) {
		this.selectSqlCountTotalCandidatesEnrolledMonthWise = selectSqlCountTotalCandidatesEnrolledMonthWise;
	}


	/**
	 * @return the selectSqTrainingCentresNotTakingAnyBatches
	 */
	public String getSelectSqTrainingCentresNotTakingAnyBatches() {
		return selectSqTrainingCentresNotTakingAnyBatches;
	}

	/**
	 * @param selectSqTrainingCentresNotTakingAnyBatches the selectSqTrainingCentresNotTakingAnyBatches to set
	 */
	public void setSelectSqTrainingCentresNotTakingAnyBatches(
			String selectSqTrainingCentresNotTakingAnyBatches) {
		this.selectSqTrainingCentresNotTakingAnyBatches = selectSqTrainingCentresNotTakingAnyBatches;
	}

	/**
	 * @return the selectSqlCountTotalCandidatesTrainedAssessedCertified
	 */
	public String getSelectSqlCountTotalCandidatesTrainedAssessedCertified() {
		return selectSqlCountTotalCandidatesTrainedAssessedCertified;
	}

	/**
	 * @param selectSqlCountTotalCandidatesTrainedAssessedCertified the selectSqlCountTotalCandidatesTrainedAssessedCertified to set
	 */
	public void setSelectSqlCountTotalCandidatesTrainedAssessedCertified(
			String selectSqlCountTotalCandidatesTrainedAssessedCertified) {
		this.selectSqlCountTotalCandidatesTrainedAssessedCertified = selectSqlCountTotalCandidatesTrainedAssessedCertified;
	}

	/**
	 * @return the selectSqlTotalCandidatesTrainedAssessedCertifiedSchemeWise
	 */
	public String getSelectSqlTotalCandidatesTrainedAssessedCertifiedSchemeWise() {
		return selectSqlTotalCandidatesTrainedAssessedCertifiedSchemeWise;
	}

	/**
	 * @param selectSqlTotalCandidatesTrainedAssessedCertifiedSchemeWise the selectSqlTotalCandidatesTrainedAssessedCertifiedSchemeWise to set
	 */
	public void setSelectSqlTotalCandidatesTrainedAssessedCertifiedSchemeWise(
			String selectSqlTotalCandidatesTrainedAssessedCertifiedSchemeWise) {
		this.selectSqlTotalCandidatesTrainedAssessedCertifiedSchemeWise = selectSqlTotalCandidatesTrainedAssessedCertifiedSchemeWise;
	}

	/**
	 * @return the selectSqlCountTotalTrainingCentresInAState
	 */
	public String getSelectSqlCountTotalTrainingCentresInAState() {
		return selectSqlCountTotalTrainingCentresInAState;
	}

	/**
	 * @param selectSqlCountTotalTrainingCentresInAState the selectSqlCountTotalTrainingCentresInAState to set
	 */
	public void setSelectSqlCountTotalTrainingCentresInAState(
			String selectSqlCountTotalTrainingCentresInAState) {
		this.selectSqlCountTotalTrainingCentresInAState = selectSqlCountTotalTrainingCentresInAState;
	}

	/**
	 * @return the selectSqlCountTrainingCentresConductingTraining
	 */
	public String getSelectSqlCountTrainingCentresConductingTraining() {
		return selectSqlCountTrainingCentresConductingTraining;
	}

	/**
	 * @param selectSqlCountTrainingCentresConductingTraining the selectSqlCountTrainingCentresConductingTraining to set
	 */
	public void setSelectSqlCountTrainingCentresConductingTraining(
			String selectSqlCountTrainingCentresConductingTraining) {
		this.selectSqlCountTrainingCentresConductingTraining = selectSqlCountTrainingCentresConductingTraining;
	}

	/**
	 * @return the selectSqlCountOfCandidatesAssessmentForAMonth
	 */
	
	/**
	 * @return the selectSqlNameOfAgencyToWhichABatchIsAssigned
	 */
	public String getSelectSqlNameOfAgencyToWhichABatchIsAssigned() {
		return selectSqlNameOfAgencyToWhichABatchIsAssigned;
	}

	/**
	 * @return the selectSqlCountOfCandidatesAssessmentUpcomingForAMonth
	 */
	public String getSelectSqlCountOfCandidatesAssessmentUpcomingForAMonth() {
		return selectSqlCountOfCandidatesAssessmentUpcomingForAMonth;
	}

	/**
	 * @param selectSqlCountOfCandidatesAssessmentUpcomingForAMonth the selectSqlCountOfCandidatesAssessmentUpcomingForAMonth to set
	 */
	public void setSelectSqlCountOfCandidatesAssessmentUpcomingForAMonth(
			String selectSqlCountOfCandidatesAssessmentUpcomingForAMonth) {
		this.selectSqlCountOfCandidatesAssessmentUpcomingForAMonth = selectSqlCountOfCandidatesAssessmentUpcomingForAMonth;
	}

	/**
	 * @param selectSqlNameOfAgencyToWhichABatchIsAssigned the selectSqlNameOfAgencyToWhichABatchIsAssigned to set
	 */
	public void setSelectSqlNameOfAgencyToWhichABatchIsAssigned(
			String selectSqlNameOfAgencyToWhichABatchIsAssigned) {
		this.selectSqlNameOfAgencyToWhichABatchIsAssigned = selectSqlNameOfAgencyToWhichABatchIsAssigned;
	}

	/**
	 * @return the selectSqlCountTotalOfBatchesAssignedToAAssessmentAgency
	 */
	public String getSelectSqlCountTotalOfBatchesAssignedToAAssessmentAgency() {
		return selectSqlCountTotalOfBatchesAssignedToAAssessmentAgency;
	}

	/**
	 * @param selectSqlCountTotalOfBatchesAssignedToAAssessmentAgency the selectSqlCountTotalOfBatchesAssignedToAAssessmentAgency to set
	 */
	public void setSelectSqlCountTotalOfBatchesAssignedToAAssessmentAgency(
			String selectSqlCountTotalOfBatchesAssignedToAAssessmentAgency) {
		this.selectSqlCountTotalOfBatchesAssignedToAAssessmentAgency = selectSqlCountTotalOfBatchesAssignedToAAssessmentAgency;
	}


	/**
	 * @return the selectSqlCountTotalNumberOfBatchesAndTotalEnrolledInAParticularState
	 */
	public String getSelectSqlCountTotalNumberOfBatchesAndTotalEnrolledInAParticularState() {
		return selectSqlCountTotalNumberOfBatchesAndTotalEnrolledInAParticularState;
	}

	/**
	 * @param selectSqlCountTotalNumberOfBatchesAndTotalEnrolledInAParticularState the selectSqlCountTotalNumberOfBatchesAndTotalEnrolledInAParticularState to set
	 */
	public void setSelectSqlCountTotalNumberOfBatchesAndTotalEnrolledInAParticularState(
			String selectSqlCountTotalNumberOfBatchesAndTotalEnrolledInAParticularState) {
		this.selectSqlCountTotalNumberOfBatchesAndTotalEnrolledInAParticularState = selectSqlCountTotalNumberOfBatchesAndTotalEnrolledInAParticularState;
	}

	
	/**
	 * @return the selectSqlCountTotalNumberOfBatchesAndTotalEnrolledInAParticularStateSchemeWise
	 */
	public String getSelectSqlCountTotalNumberOfBatchesAndTotalEnrolledInAParticularStateSchemeWise() {
		return selectSqlCountTotalNumberOfBatchesAndTotalEnrolledInAParticularStateSchemeWise;
	}

	/**
	 * @param selectSqlCountTotalNumberOfBatchesAndTotalEnrolledInAParticularStateSchemeWise the selectSqlCountTotalNumberOfBatchesAndTotalEnrolledInAParticularStateSchemeWise to set
	 */
	public void setSelectSqlCountTotalNumberOfBatchesAndTotalEnrolledInAParticularStateSchemeWise(
			String selectSqlCountTotalNumberOfBatchesAndTotalEnrolledInAParticularStateSchemeWise) {
		this.selectSqlCountTotalNumberOfBatchesAndTotalEnrolledInAParticularStateSchemeWise = selectSqlCountTotalNumberOfBatchesAndTotalEnrolledInAParticularStateSchemeWise;
	}

	/**
	 * @return the selectSqlCountTotalAssessorsOfAParticularAgencyInAParticularState
	 */
	public String getSelectSqlCountTotalAssessorsOfAParticularAgencyInAParticularState() {
		return selectSqlCountTotalAssessorsOfAParticularAgencyInAParticularState;
	}

	/**
	 * @param selectSqlCountTotalAssessorsOfAParticularAgencyInAParticularState the selectSqlCountTotalAssessorsOfAParticularAgencyInAParticularState to set
	 */
	public void setSelectSqlCountTotalAssessorsOfAParticularAgencyInAParticularState(
			String selectSqlCountTotalAssessorsOfAParticularAgencyInAParticularState) {
		this.selectSqlCountTotalAssessorsOfAParticularAgencyInAParticularState = selectSqlCountTotalAssessorsOfAParticularAgencyInAParticularState;
	}

	/**
	 * @return the selectSqlStatusOfAParticularBatchWithId
	 */
	public String getSelectSqlStatusOfAParticularBatchWithId() {
		return selectSqlStatusOfAParticularBatchWithId;
	}

	/**
	 * @param selectSqlStatusOfAParticularBatchWithId the selectSqlStatusOfAParticularBatchWithId to set
	 */
	public void setSelectSqlStatusOfAParticularBatchWithId(
			String selectSqlStatusOfAParticularBatchWithId) {
		this.selectSqlStatusOfAParticularBatchWithId = selectSqlStatusOfAParticularBatchWithId;
	}

	/**
	 * @return the selectSqlCountBatchesForWhichResultIsPending
	 */
	public String getSelectSqlCountBatchesForWhichResultIsPending() {
		return selectSqlCountBatchesForWhichResultIsPending;
	}

	/**
	 * @param selectSqlCountBatchesForWhichResultIsPending the selectSqlCountBatchesForWhichResultIsPending to set
	 */
	public void setSelectSqlCountBatchesForWhichResultIsPending(
			String selectSqlCountBatchesForWhichResultIsPending) {
		this.selectSqlCountBatchesForWhichResultIsPending = selectSqlCountBatchesForWhichResultIsPending;
	}

	/**
	 * @return the selectSqlCountTotalNonAssignedBatches
	 */
	public String getSelectSqlCountTotalNonAssignedBatches() {
		return selectSqlCountTotalNonAssignedBatches;
	}

	/**
	 * @param selectSqlCountTotalNonAssignedBatches the selectSqlCountTotalNonAssignedBatches to set
	 */
	public void setSelectSqlCountTotalNonAssignedBatches(
			String selectSqlCountTotalNonAssignedBatches) {
		this.selectSqlCountTotalNonAssignedBatches = selectSqlCountTotalNonAssignedBatches;
	}

	
	/**
	 * @return the selectSqlBatchWiseCandidatesDetails
	 */
	public String getSelectSqlBatchWiseCandidatesDetails() {
		return selectSqlBatchWiseCandidatesDetails;
	}

	/**
	 * @param selectSqlBatchWiseCandidatesDetails the selectSqlBatchWiseCandidatesDetails to set
	 */
	public void setSelectSqlBatchWiseCandidatesDetails(
			String selectSqlBatchWiseCandidatesDetails) {
		this.selectSqlBatchWiseCandidatesDetails = selectSqlBatchWiseCandidatesDetails;
	}
	
	
}
