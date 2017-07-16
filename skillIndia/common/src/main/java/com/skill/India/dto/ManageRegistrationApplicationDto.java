package com.skill.India.dto;

public class ManageRegistrationApplicationDto {

	
	
	private String applicationState;
	private String userId;
	private Boolean activeFlag;	
	private Integer applicationId;
	/**
	 * @return the applicationState
	 */
	public String getApplicationState() {
		return applicationState;
	}
	/**
	 * @param applicationState the applicationState to set
	 */
	public void setApplicationState(String applicationState) {
		this.applicationState = applicationState;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the activeFlag
	 */
	public Boolean getActiveFlag() {
		return activeFlag;
	}
	/**
	 * @param activeFlag the activeFlag to set
	 */
	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
	/**
	 * @return the applicationId
	 */
	public Integer getApplicationId() {
		return applicationId;
	}
	/**
	 * @param applicationId the applicationId to set
	 */
	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}
	
	
}
