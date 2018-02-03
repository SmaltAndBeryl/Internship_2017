package com.skill.India.dto;

import com.skill.India.common.BaseDto;

public class SignUpInsertedUserDto extends BaseDto{
	
	private static final long serialVersionUID = 1L;
	
	private String userId;
	private String organizationName;
	private String sPOCName;
	
	public SignUpInsertedUserDto(String userId, String organizationName,
			String sPOCName) {
		super();
		this.userId = userId;
		this.organizationName = organizationName;
		this.sPOCName = sPOCName;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
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
	

}
