package com.skill.India.dto;

import com.skill.India.common.BaseDto;

public class SignUpReceiveDataDto extends BaseDto {
	
	private static final long serialVersionUID = 1L;
	
	
	public String organizationName;
	public String sPOCName;
	public String userId;
	public String mypassword;
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
	public String getSPOCName() {
		return sPOCName;
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
	 * @param sPOCName
	 * @param userId
	 * @param password
	 * @param userRole
	 */
	public SignUpReceiveDataDto(String organizationName, String sPOCName,
			String userId, String password, String userRole) {
		super();
		this.organizationName = organizationName;
		this.sPOCName = sPOCName;
		this.userId = userId;
		this.mypassword = password;
		this.userRole = userRole;
	}
	/**
	 * 
	 */
	public SignUpReceiveDataDto() {
		super();
	}
	
	
	
}
