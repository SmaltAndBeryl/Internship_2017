package com.skill.India.dto;

import com.skill.India.common.BaseDto;

public class LoginReceiveDataDto extends BaseDto {

	
	private static final long serialVersionUID = 1L;
	public String userId;
	public String password;

public String getUserId() {
	return userId;
}

public String getPassword() {
	return password;
}

/**
 * @param userId
 * @param password
 */
public LoginReceiveDataDto(String userId, String password) {
	super();
	this.userId = userId;
	this.password = password;
}

/**
 * 
 */
public LoginReceiveDataDto() {
	super();
}




}
