package com.skill.India.dto;

import com.skill.India.common.BaseDto;

public class LoginDto extends BaseDto{
private static final long serialVersionUID = 1L;
	
	private final int applicationId; 
	private final String userRole;
	private final String userStatus;

	
	/**
	 * @return the applicationId
	 */
	public int getApplicationId() {
		return applicationId;
	}
	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}
	/**
	 * @return the userStatus
	 */
	public String getUserStatus() {
		return userStatus;
	}
	/**
	 * @param applicationId
	 * @param userRole
	 * @param userStatus
	 */
	public LoginDto(int applicationId, String userRole, String userStatus) {
		super();
		this.applicationId = applicationId;
		this.userRole = userRole;
		this.userStatus = userStatus;
	}
	
	
	
	
	
}
