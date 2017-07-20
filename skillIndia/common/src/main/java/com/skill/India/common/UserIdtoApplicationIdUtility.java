package com.skill.India.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.service.UserIdtoApplicationIdService;

@Service
public class UserIdtoApplicationIdUtility {
	
	@Autowired
	private UserIdtoApplicationIdService userIdtoApplicationIdService;

	 public String getApplicationId(String userId) 
		{	
			return Integer.toString(userIdtoApplicationIdService.getApplicationId(userId));
		}	
		

}
