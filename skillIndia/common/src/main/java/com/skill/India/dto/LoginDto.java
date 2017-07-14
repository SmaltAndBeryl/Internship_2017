package com.skill.India.dto;

import com.skill.India.common.BaseDto;

public class LoginDto extends BaseDto{
private static final long serialVersionUID = 1L;
	
	private final String userId; 
	private final String userRole;
	private final String userStatus;

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
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
	 * @param userId
	 * @param userRole
	 * @param userStatus
	 */
	public LoginDto(String userId, String userRole, String userStatus) {
		super();
		this.userId = userId;
		this.userRole = userRole;
		this.userStatus = userStatus;
	}
	
	
	
	
	
	
}
