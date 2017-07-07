package com.skill.India.dto;

/*
 * Author 		: Ruchit Jain
 * Description  : DTO for agency 
 */

public class ValidateAssessmentAgencyCSVDto {

	private String agencyId;
	private String agencyName;
	private String applicationId;
	/**
	 * @return the applicationId
	 */
	public String getApplicationId() {
		return applicationId;
	}
	/**
	 * @param applicationId the applicationId to set
	 */
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	/**
	 * @return the agencyId
	 */
	public String getAgencyId() {
		return agencyId;
	}
	/**
	 * @param agencyId the agencyId to set
	 */
	public void setAgencyId(String agencyId) {
		this.agencyId = agencyId;
	}
	/**
	 * @return the agencyName
	 */
	public String getAgencyName() {
		return agencyName;
	}
	/**
	 * @param agencyName the agencyName to set
	 */
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	
	

}
