package com.skill.India.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.skill.India.dto.SessionManagementDto;
import com.skill.India.service.UserIdtoApplicationIdService;

@Service
public class SessionUserUtility {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SessionUserUtility.class);
	
	@Autowired
	private UserIdtoApplicationIdService userIdtoApplicationIdService;
	
	
	 public int getApplicationId(String userId) 
		{	LOGGER.debug("Application Id is -" + userIdtoApplicationIdService.getApplicationId(userId));
		 	LOGGER.debug("Request Received to get Application Id");
		 	LOGGER.debug("In UserIdtoApplicationIdService - getApplicationId");
		 	LOGGER.debug("Request Received are - 'userId': ",userId);
		 	LOGGER.debug("Sending Request to service");
			return userIdtoApplicationIdService.getApplicationId(userId);
		}	
	 
	 public SessionManagementDto getSessionMangementfromSession(){
		 	LOGGER.debug("Request Received to get Session");
		 	
		 	LOGGER.debug("Sending Request to get SessionManagementDto");
		 return (SessionManagementDto)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 }
		

}
