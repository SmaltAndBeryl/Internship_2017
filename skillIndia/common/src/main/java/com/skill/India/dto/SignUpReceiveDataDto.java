package com.skill.India.dto;

import com.skill.India.common.BaseDto;

public class SignUpReceiveDataDto extends BaseDto {
	
	private static final long serialVersionUID = 1L;
	
	
	public String organizationName;
	public String spocName;
	public String userId;
	public String password;
	public String userRole;
	/**
	 * @return the organizationName
	 */
	public String getOrganizationName() {
		return organizationName;
	}
	
	/**
	 * @return the spocName
	 */
	public String getSpocName() {
		return spocName;
	}
	
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	
	
	public String getUserRole() {
		return userRole;
	}
	
	/**
	 * @param organizationName
	 * @param spocName
	 * @param userId
	 * @param password
	 * @param userRole
	 */
	public SignUpReceiveDataDto(String organizationName, String spocName,
			String userId, String password, String userRole) {
		super();
		this.organizationName = organizationName;
		this.spocName = spocName;
		this.userId = userId;
		this.password = password;
		this.userRole = userRole;
	}
	/**
	 * 
	 */
	public SignUpReceiveDataDto() {
		super();
	}
	
	
	
}
