package com.skill.India.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.skill.India.dao.UserIdtoApplicationIdDao;

@Service
public class UserIdtoApplicationIdService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserIdtoApplicationIdService.class);

	@Autowired
	private UserIdtoApplicationIdDao userIdtoApplicationIdDao;
	
	public int getApplicationId(String userId){
		
		LOGGER.info("Request Received to get application Id");
		LOGGER.info("In UserIdtoApplicationIdService - getApplicationId");
		LOGGER.info("Parameters Received from Controller are - 'userId': ",userId);
		LOGGER.info("Getting Application id against received userId");
		return userIdtoApplicationIdDao.getApplicationId(userId);
	}

}
