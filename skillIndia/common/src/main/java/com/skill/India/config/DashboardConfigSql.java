package com.skill.India.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix="dashboard",locations="classpath:sql/dashboard.yml")
public class DashboardConfigSql {
	
	private String	selectSqlTotalCandidatesEnrolled;
	
	private String	selectSqlTotalCandidatesAccessed;
	
	private String	selectSqlTotalCandidatesCertified;
	
	private String	selectSqlTotalTrainingPartners;
	
	private String	selectSqlTotalTrainingCentersInIndia;
	
	private String	selectSqlTotalBatchesAccordingToJobRole;
	
	private String	selectSqlTopStatesWithMaxTrainingCenters;
	
	private String	selectSqlTotalCandidatesTrainedWithModeInLastThreeYears;
	
	private String	selectSqlTotalCandidatesTrainedWithBatchTypeInLastThreeYears;

	/**
	 * @return the selectSqlTotalCandidatesEnrolled
	 */
	public String getSelectSqlTotalCandidatesEnrolled() {
		return selectSqlTotalCandidatesEnrolled;
	}

	/**
	 * @param selectSqlTotalCandidatesEnrolled the selectSqlTotalCandidatesEnrolled to set
	 */
	public void setSelectSqlTotalCandidatesEnrolled(String selectSqlTotalCandidatesEnrolled) {
		this.selectSqlTotalCandidatesEnrolled = selectSqlTotalCandidatesEnrolled;
	}

	/**
	 * @return the selectSqlTotalCandidatesAccessed
	 */
	public String getSelectSqlTotalCandidatesAccessed() {
		return selectSqlTotalCandidatesAccessed;
	}

	/**
	 * @param selectSqlTotalCandidatesAccessed the selectSqlTotalCandidatesAccessed to set
	 */
	public void setSelectSqlTotalCandidatesAccessed(String selectSqlTotalCandidatesAccessed) {
		this.selectSqlTotalCandidatesAccessed = selectSqlTotalCandidatesAccessed;
	}

	/**
	 * @return the selectSqlTotalCandidatesCertified
	 */
	public String getSelectSqlTotalCandidatesCertified() {
		return selectSqlTotalCandidatesCertified;
	}

	/**
	 * @param selectSqlTotalCandidatesCertified the selectSqlTotalCandidatesCertified to set
	 */
	public void setSelectSqlTotalCandidatesCertified(String selectSqlTotalCandidatesCertified) {
		this.selectSqlTotalCandidatesCertified = selectSqlTotalCandidatesCertified;
	}

	/**
	 * @return the selectSqlTotalTrainingPartners
	 */
	public String getSelectSqlTotalTrainingPartners() {
		return selectSqlTotalTrainingPartners;
	}

	/**
	 * @param selectSqlTotalTrainingPartners the selectSqlTotalTrainingPartners to set
	 */
	public void setSelectSqlTotalTrainingPartners(String selectSqlTotalTrainingPartners) {
		this.selectSqlTotalTrainingPartners = selectSqlTotalTrainingPartners;
	}

	/**
	 * @return the selectSqlTotalTrainingCentersInIndia
	 */
	public String getSelectSqlTotalTrainingCentersInIndia() {
		return selectSqlTotalTrainingCentersInIndia;
	}

	/**
	 * @param selectSqlTotalTrainingCentersInIndia the selectSqlTotalTrainingCentersInIndia to set
	 */
	public void setSelectSqlTotalTrainingCentersInIndia(String selectSqlTotalTrainingCentersInIndia) {
		this.selectSqlTotalTrainingCentersInIndia = selectSqlTotalTrainingCentersInIndia;
	}

	/**
	 * @return the selectSqlTotalBatchesAccordingToJobRole
	 */
	public String getSelectSqlTotalBatchesAccordingToJobRole() {
		return selectSqlTotalBatchesAccordingToJobRole;
	}

	/**
	 * @param selectSqlTotalBatchesAccordingToJobRole the selectSqlTotalBatchesAccordingToJobRole to set
	 */
	public void setSelectSqlTotalBatchesAccordingToJobRole(String selectSqlTotalBatchesAccordingToJobRole) {
		this.selectSqlTotalBatchesAccordingToJobRole = selectSqlTotalBatchesAccordingToJobRole;
	}

	/**
	 * @return the selectSqlTopStatesWithMaxTrainingCenters
	 */
	public String getSelectSqlTopStatesWithMaxTrainingCenters() {
		return selectSqlTopStatesWithMaxTrainingCenters;
	}

	/**
	 * @param selectSqlTopStatesWithMaxTrainingCenters the selectSqlTopStatesWithMaxTrainingCenters to set
	 */
	public void setSelectSqlTopStatesWithMaxTrainingCenters(String selectSqlTopStatesWithMaxTrainingCenters) {
		this.selectSqlTopStatesWithMaxTrainingCenters = selectSqlTopStatesWithMaxTrainingCenters;
	}

	/**
	 * @return the selectSqlTotalCandidatesTrainedWithModeInLastThreeYears
	 */
	public String getSelectSqlTotalCandidatesTrainedWithModeInLastThreeYears() {
		return selectSqlTotalCandidatesTrainedWithModeInLastThreeYears;
	}

	/**
	 * @param selectSqlTotalCandidatesTrainedWithModeInLastThreeYears the selectSqlTotalCandidatesTrainedWithModeInLastThreeYears to set
	 */
	public void setSelectSqlTotalCandidatesTrainedWithModeInLastThreeYears(
			String selectSqlTotalCandidatesTrainedWithModeInLastThreeYears) {
		this.selectSqlTotalCandidatesTrainedWithModeInLastThreeYears = selectSqlTotalCandidatesTrainedWithModeInLastThreeYears;
	}

	/**
	 * @return the selectSqlTotalCandidatesTrainedWithBatchTypeInLastThreeYears
	 */
	public String getSelectSqlTotalCandidatesTrainedWithBatchTypeInLastThreeYears() {
		return selectSqlTotalCandidatesTrainedWithBatchTypeInLastThreeYears;
	}

	/**
	 * @param selectSqlTotalCandidatesTrainedWithBatchTypeInLastThreeYears the selectSqlTotalCandidatesTrainedWithBatchTypeInLastThreeYears to set
	 */
	public void setSelectSqlTotalCandidatesTrainedWithBatchTypeInLastThreeYears(
			String selectSqlTotalCandidatesTrainedWithBatchTypeInLastThreeYears) {
		this.selectSqlTotalCandidatesTrainedWithBatchTypeInLastThreeYears = selectSqlTotalCandidatesTrainedWithBatchTypeInLastThreeYears;
	}
	
	
}
