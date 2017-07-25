package com.skill.India.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.skill.India.dto.SessionManagementDto;
import com.skill.India.service.UserIdtoApplicationIdService;

@Service
public class SessionUserUtility {
	
	@Autowired
	private UserIdtoApplicationIdService userIdtoApplicationIdService;

	 public int getApplicationId(String userId) 
		{	
			return userIdtoApplicationIdService.getApplicationId(userId);
		}	
	 
	 public SessionManagementDto getSessionMangementfromSession(){
		 return (SessionManagementDto)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 }
		

}
