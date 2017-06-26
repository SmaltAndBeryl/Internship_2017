package com.skill.India.dto;

import com.skill.India.common.BaseDto;

public class LoginDto extends BaseDto{
private static final long serialVersionUID = 1L;
	
	private final int applicationId; 
	private final String user_role;
	private final String user_status;
	
	

	
	public LoginDto(int applicationId, String user_role, String user_status) 
	{
		super();
		this.applicationId = applicationId;
		this.user_role = user_role;
		this.user_status = user_status;
		
		
	}








	public String getUser_role() {
		return user_role;
	}




	public String getUser_status() {
		return user_status;
	}








	public int getApplicationId() {
		return applicationId;
	}
	
	
}
