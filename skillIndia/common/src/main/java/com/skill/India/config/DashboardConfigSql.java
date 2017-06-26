package com.skill.India.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix="let",locations="classpath:sql/dashboard.yml")
public class DashboardConfigSql {
	
	private String selectSqlCandidatesEnrolled;
	private String selectSqlCandidatesAccessed;
	private String selectSqlCandidatesCertified;
	private String selectSqlTrainingPartners;
	private String selectSqlTrainingCenters;
//	private String selectSql6;
	/**
	 * @return the selectSqlCandidatesEnrolled
	 */
	public String getSelectSqlCandidatesEnrolled() {
		return selectSqlCandidatesEnrolled;
	}
	/**
	 * @param selectSqlCandidatesEnrolled the selectSqlCandidatesEnrolled to set
	 */
	public void setSelectSqlCandidatesEnrolled(String selectSqlCandidatesEnrolled) {
		this.selectSqlCandidatesEnrolled = selectSqlCandidatesEnrolled;
	}
	/**
	 * @return the selectSqlCandidatesAccessed
	 */
	public String getSelectSqlCandidatesAccessed() {
		return selectSqlCandidatesAccessed;
	}
	/**
	 * @param selectSqlCandidatesAccessed the selectSqlCandidatesAccessed to set
	 */
	public void setSelectSqlCandidatesAccessed(String selectSqlCandidatesAccessed) {
		this.selectSqlCandidatesAccessed = selectSqlCandidatesAccessed;
	}
	/**
	 * @return the selectSqlCandidatesCertified
	 */
	public String getSelectSqlCandidatesCertified() {
		return selectSqlCandidatesCertified;
	}
	/**
	 * @param selectSqlCandidatesCertified the selectSqlCandidatesCertified to set
	 */
	public void setSelectSqlCandidatesCertified(String selectSqlCandidatesCertified) {
		this.selectSqlCandidatesCertified = selectSqlCandidatesCertified;
	}
	/**
	 * @return the selectSqlTrainingPartners
	 */
	public String getSelectSqlTrainingPartners() {
		return selectSqlTrainingPartners;
	}
	/**
	 * @param selectSqlTrainingPartners the selectSqlTrainingPartners to set
	 */
	public void setSelectSqlTrainingPartners(String selectSqlTrainingPartners) {
		this.selectSqlTrainingPartners = selectSqlTrainingPartners;
	}
	/**
	 * @return the selectSqlTrainingCenters
	 */
	public String getSelectSqlTrainingCenters() {
		return selectSqlTrainingCenters;
	}
	/**
	 * @param selectSqlTrainingCenters the selectSqlTrainingCenters to set
	 */
	public void setSelectSqlTrainingCenters(String selectSqlTrainingCenters) {
		this.selectSqlTrainingCenters = selectSqlTrainingCenters;
	}
		
	
		
}
