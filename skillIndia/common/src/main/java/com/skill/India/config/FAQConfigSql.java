package com.skill.India.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="faq",locations="classpath:sql/fAQ.yml")
public class FAQConfigSql {
	
	private String selectSqlTotalCandidatesTrainedAssessedCertified;
	
	private String selectSqlTotalCandidatesTrainedAssessedCertifiedSchemeWise;
	
	private String selectSqlTotalTrainingCentresInAState;
	
	private String selectSqlCountTrainingCentresConductingTraining;
	

	
	
	public String getSelectSqlCountTrainingCentresConductingTraining() {
		return selectSqlCountTrainingCentresConductingTraining;
	}

	public void setSelectSqlCountTrainingCentresConductingTraining(String selectSqlCountTrainingCentresConductingTraining) {
		this.selectSqlCountTrainingCentresConductingTraining = selectSqlCountTrainingCentresConductingTraining;
	}

	/**
	 * @return the selectSqlTotalTrainingCentresInAState
	 */
	public String getSelectSqlTotalTrainingCentresInAState() {
		return selectSqlTotalTrainingCentresInAState;
	}

	/**
	 * @param selectSqlTotalTrainingCentresInAState the selectSqlTotalTrainingCentresInAState to set
	 */
	public void setSelectSqlTotalTrainingCentresInAState(String selectSqlTotalTrainingCentresInAState) {
		this.selectSqlTotalTrainingCentresInAState = selectSqlTotalTrainingCentresInAState;
	}

	/**
	 * @return the selectSqlTotalCandidatesTrainedAssessedCertified
	 */
	public String getSelectSqlTotalCandidatesTrainedAssessedCertified() {
		return selectSqlTotalCandidatesTrainedAssessedCertified;
	}

	/**
	 * @param selectSqlTotalCandidatesTrainedAssessedCertified the selectSqlTotalCandidatesTrainedAssessedCertified to set
	 */
	public void setSelectSqlTotalCandidatesTrainedAssessedCertified(
			String selectSqlTotalCandidatesTrainedAssessedCertified) {
		this.selectSqlTotalCandidatesTrainedAssessedCertified = selectSqlTotalCandidatesTrainedAssessedCertified;
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
	
	

		

}
