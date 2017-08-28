package com.skill.India.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.skill.India.dao.NonAssignedBatchesDao;
import com.skill.India.dto.SessionManagementDto;
import com.skill.India.service.UserIdtoApplicationIdService;

@Service
public class SessionUserUtility {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SessionUserUtility.class);
	
	@Autowired
	private UserIdtoApplicationIdService userIdtoApplicationIdService;
	
	
	 public int getApplicationId(String userId) 
		{	LOGGER.info("Application Id is -" + userIdtoApplicationIdService.getApplicationId(userId));
		 	LOGGER.info("Request Received to get Application Id");
		 	LOGGER.info("In UserIdtoApplicationIdService - getApplicationId");
		 	LOGGER.info("Request Received are - 'userId': ",userId);
		 	LOGGER.info("Sending Request to service");
			return userIdtoApplicationIdService.getApplicationId(userId);
		}	
	 
	 public SessionManagementDto getSessionMangementfromSession(){
		 	LOGGER.info("Request Received to get Session");
		 	LOGGER.info("In UserIdtoApplicationIdService - getSessionMangementfromSession");
		 	LOGGER.info("Sending Request to get SessionManagementDto");
		 return (SessionManagementDto)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 }
		

}
