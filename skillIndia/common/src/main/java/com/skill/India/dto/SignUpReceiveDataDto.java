package com.skill.India.dto;

import com.skill.India.common.BaseDto;

public class SignUpReceiveDataDto extends BaseDto {
	
	private static final long serialVersionUID = 1L;
	
	
	private String organizationName;
	private String sPOCName;
	private String userId;
	private String password;
	private String userRole;
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param sPOCName the sPOCName to set
	 */
	public void setsPOCName(String sPOCName) {
		this.sPOCName = sPOCName;
	}


	/**
	 * @param organizationName the organizationName to set
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	
	
}
