package com.skill.India.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

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
	
	private String selectSqlCountTotalNumberOfBatchesInAParticularState;
	
	private String selectSqlCountTotalNumberOfBatchesInAParticularScheme;
	
	private String selectSqlCountTotalAssessorsOfAParticularAgencyInAParticularState;
	
	private String selectSqlStatusOfAParticularBatchWithId;
	
	private String selectSqlCountBatchesForWhichResultIsPending;
	
	private String selectSqlCountTotalNonAssignedBatches;
	
	private String selectSqlBatchWiseCandidatesDetails;
	
	private String selectSqlCountTotalTrainingCentresNotTakingAnyBatches;

	
	
	/**
	 * @return the selectSqlCountTotalTrainingCentresNotTakingAnyBatches
	 */
	public String getSelectSqlCountTotalTrainingCentresNotTakingAnyBatches() {
		return selectSqlCountTotalTrainingCentresNotTakingAnyBatches;
	}

	/**
	 * @param selectSqlCountTotalTrainingCentresNotTakingAnyBatches the selectSqlCountTotalTrainingCentresNotTakingAnyBatches to set
	 */
	public void setSelectSqlCountTotalTrainingCentresNotTakingAnyBatches(
			String selectSqlCountTotalTrainingCentresNotTakingAnyBatches) {
		this.selectSqlCountTotalTrainingCentresNotTakingAnyBatches = selectSqlCountTotalTrainingCentresNotTakingAnyBatches;
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
	 * @return the selectSqlCountTotalNumberOfBatchesInAParticularState
	 */
	public String getSelectSqlCountTotalNumberOfBatchesInAParticularState() {
		return selectSqlCountTotalNumberOfBatchesInAParticularState;
	}

	/**
	 * @param selectSqlCountTotalNumberOfBatchesInAParticularState the selectSqlCountTotalNumberOfBatchesInAParticularState to set
	 */
	public void setSelectSqlCountTotalNumberOfBatchesInAParticularState(
			String selectSqlCountTotalNumberOfBatchesInAParticularState) {
		this.selectSqlCountTotalNumberOfBatchesInAParticularState = selectSqlCountTotalNumberOfBatchesInAParticularState;
	}

	/**
	 * @return the selectSqlCountTotalNumberOfBatchesInAParticularScheme
	 */
	public String getSelectSqlCountTotalNumberOfBatchesInAParticularScheme() {
		return selectSqlCountTotalNumberOfBatchesInAParticularScheme;
	}

	/**
	 * @param selectSqlCountTotalNumberOfBatchesInAParticularScheme the selectSqlCountTotalNumberOfBatchesInAParticularScheme to set
	 */
	public void setSelectSqlCountTotalNumberOfBatchesInAParticularScheme(
			String selectSqlCountTotalNumberOfBatchesInAParticularScheme) {
		this.selectSqlCountTotalNumberOfBatchesInAParticularScheme = selectSqlCountTotalNumberOfBatchesInAParticularScheme;
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
