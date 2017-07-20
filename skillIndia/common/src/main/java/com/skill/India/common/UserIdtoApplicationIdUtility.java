package com.skill.India.common;

import org.springframework.beans.factory.annotation.Autowired;


import com.skill.India.service.UserIdtoApplicationIdService;

public class UserIdtoApplicationIdUtility {
	
	@Autowired
	private UserIdtoApplicationIdService userIdtoApplicationIdService;

	 public String getApplicationId(String userId) 
		{	
			return Integer.toString(userIdtoApplicationIdService.getApplicationId(userId));
		}	
		

}
