package com.skill.India.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="assessmentBodyHomepage",locations="classpath:sql/assessmentBodyHomepage.yml")
public class AssessmentBodyHomepageConfigSql {
	
	
	private String selectSqlpastBatchesAssessmentBodyHomepage;
	
	private String selectSqlupcomingBatchesAssessmentBodyHomepage;
	
	private String selectSqlShownInterestBatchesAssessmentBodyHomepage;
	
	private String selectSqlassignedBatchesAssessmentBodyHomepage;
	
	private String selectSqlconfirmedBatchesAssessmentBodyHomepage;
	
	private String updateSqlShowInterest;
	
	private String updateSqlapproveBatchesAssessmentBody;
	
	private String updateSqlrejectBatchesAssessmentBody;
	
	private String getAgencyId;
	
	public String getGetAgencyId() {
		return getAgencyId;
	}

	public void setGetAgencyId(String getAgencyId) {
		this.getAgencyId = getAgencyId;
	}

	/**
	 * @return the selectSqlpastBatchesAssessmentBodyHomepage
	 */
	public String getSelectSqlpastBatchesAssessmentBodyHomepage() {
		return selectSqlpastBatchesAssessmentBodyHomepage;
	}

	/**
	 * @param selectSqlpastBatchesAssessmentBodyHomepage the selectSqlpastBatchesAssessmentBodyHomepage to set
	 */
	public void setSelectSqlpastBatchesAssessmentBodyHomepage(
			String selectSqlpastBatchesAssessmentBodyHomepage) {
		this.selectSqlpastBatchesAssessmentBodyHomepage = selectSqlpastBatchesAssessmentBodyHomepage;
	}

	/**
	 * @return the selectSqlupcomingBatchesAssessmentBodyHomepage
	 */
	public String getSelectSqlupcomingBatchesAssessmentBodyHomepage() {
		return selectSqlupcomingBatchesAssessmentBodyHomepage;
	}

	/**
	 * @param selectSqlupcomingBatchesAssessmentBodyHomepage the selectSqlupcomingBatchesAssessmentBodyHomepage to set
	 */
	public void setSelectSqlupcomingBatchesAssessmentBodyHomepage(
			String selectSqlupcomingBatchesAssessmentBodyHomepage) {
		this.selectSqlupcomingBatchesAssessmentBodyHomepage = selectSqlupcomingBatchesAssessmentBodyHomepage;
	}
	
	/**
	 * @return the selectSqlShownInterestBatchesAssessmentBodyHomepage
	 */
	public String getSelectSqlShownInterestBatchesAssessmentBodyHomepage() {
		return selectSqlShownInterestBatchesAssessmentBodyHomepage;
	}

	/**
	 * @param selectSqlShownInterestBatchesAssessmentBodyHomepage the selectSqlShownInterestBatchesAssessmentBodyHomepage to set
	 */
	public void setSelectSqlShownInterestBatchesAssessmentBodyHomepage(
			String selectSqlShownInterestBatchesAssessmentBodyHomepage) {
		this.selectSqlShownInterestBatchesAssessmentBodyHomepage = selectSqlShownInterestBatchesAssessmentBodyHomepage;
	}

	/**
	 * @return the selectSqlassignedBatchesAssessmentBodyHomepage
	 */
	public String getSelectSqlassignedBatchesAssessmentBodyHomepage() {
		return selectSqlassignedBatchesAssessmentBodyHomepage;
	}

	/**
	 * @param selectSqlassignedBatchesAssessmentBodyHomepage the selectSqlassignedBatchesAssessmentBodyHomepage to set
	 */
	public void setSelectSqlassignedBatchesAssessmentBodyHomepage(
			String selectSqlassignedBatchesAssessmentBodyHomepage) {
		this.selectSqlassignedBatchesAssessmentBodyHomepage = selectSqlassignedBatchesAssessmentBodyHomepage;
	}

	/**
	 * @return the selectSqlconfirmedBatchesAssessmentBodyHomepage
	 */
	public String getSelectSqlconfirmedBatchesAssessmentBodyHomepage() {
		return selectSqlconfirmedBatchesAssessmentBodyHomepage;
	}

	/**
	 * @param selectSqlconfirmedBatchesAssessmentBodyHomepage the selectSqlconfirmedBatchesAssessmentBodyHomepage to set
	 */
	public void setSelectSqlconfirmedBatchesAssessmentBodyHomepage(
			String selectSqlconfirmedBatchesAssessmentBodyHomepage) {
		this.selectSqlconfirmedBatchesAssessmentBodyHomepage = selectSqlconfirmedBatchesAssessmentBodyHomepage;
	}

	/**
	 * @return the updateSqlShowInterest
	 */
	public String getUpdateSqlShowInterest() {
		return updateSqlShowInterest;
	}

	/**
	 * @param updateSqlShowInterest the updateSqlShowInterest to set
	 */
	public void setUpdateSqlShowInterest(String updateSqlShowInterest) {
		this.updateSqlShowInterest = updateSqlShowInterest;
	}

	/**
	 * @return the updateSqlapproveBatchesAssessmentBody
	 */
	public String getUpdateSqlapproveBatchesAssessmentBody() {
		return updateSqlapproveBatchesAssessmentBody;
	}

	/**
	 * @param updateSqlapproveBatchesAssessmentBody the updateSqlapproveBatchesAssessmentBody to set
	 */
	public void setUpdateSqlapproveBatchesAssessmentBody(
			String updateSqlapproveBatchesAssessmentBody) {
		this.updateSqlapproveBatchesAssessmentBody = updateSqlapproveBatchesAssessmentBody;
	}

	/**
	 * @return the updateSqlrejectBatchesAssessmentBody
	 */
	public String getUpdateSqlrejectBatchesAssessmentBody() {
		return updateSqlrejectBatchesAssessmentBody;
	}

	/**
	 * @param updateSqlrejectBatchesAssessmentBody the updateSqlrejectBatchesAssessmentBody to set
	 */
	public void setUpdateSqlrejectBatchesAssessmentBody(
			String updateSqlrejectBatchesAssessmentBody) {
		this.updateSqlrejectBatchesAssessmentBody = updateSqlrejectBatchesAssessmentBody;
	}
	
	

}
