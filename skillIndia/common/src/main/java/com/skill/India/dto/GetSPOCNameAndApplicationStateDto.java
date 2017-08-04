package com.skill.India.dto;

public class GetSPOCNameAndApplicationStateDto {

	private String sPocName;
	private String applicationState;
	/**
	 * @return the sPocName
	 */
	public String getsPocName() {
		return sPocName;
	}
	/**
	 * @param sPocName the sPocName to set
	 */
	public void setsPocName(String sPocName) {
		this.sPocName = sPocName;
	}
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
	 * @param sPocName
	 * @param applicationState
	 */
	public GetSPOCNameAndApplicationStateDto(String sPocName,
			String applicationState) {
		super();
		this.sPocName = sPocName;
		this.applicationState = applicationState;
	}
	
	
}
