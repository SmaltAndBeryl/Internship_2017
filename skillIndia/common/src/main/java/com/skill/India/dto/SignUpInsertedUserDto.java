package com.skill.India.dto;

import com.skill.India.common.BaseDto;

public class SignUpInsertedUserDto extends BaseDto{
	
	private static final long serialVersionUID = 1L;
	
	private String userId;
	private String organizationName;
	private String spocName;
	
	public SignUpInsertedUserDto(String userId, String organizationName,
			String spocName) {
		super();
		this.userId = userId;
		this.organizationName = organizationName;
		this.spocName = spocName;
		// TODO Auto-generated constructor stub
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
	public String getSpocName() {
		return spocName;
	}
	

}
