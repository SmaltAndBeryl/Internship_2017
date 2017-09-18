package com.skill.India.dto;

import com.skill.India.common.BaseDto;

public class ApplicationDto  extends BaseDto{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String applicationState;
	private String applicationId;
	public ApplicationDto(String applicationState, String applicationId) {
		super();
		this.applicationState = applicationState;
		this.applicationId = applicationId;
	}
	/**
	 * @return the applicationState
	 */
	public String getApplicationState() {
		return applicationState;
	}
	/**
	 * @return the applicationId
	 */
	public String getApplicationId() {
		return applicationId;
	}
	
	

}
