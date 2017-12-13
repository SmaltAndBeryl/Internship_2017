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
		
		LOGGER.debug("Request Received to get application Id");
		LOGGER.debug("In UserIdtoApplicationIdService - getApplicationId");
		LOGGER.debug("Parameters Received from Controller are - 'userId': "+userId);
		LOGGER.debug("Getting Application id against received userId");
		return userIdtoApplicationIdDao.getApplicationId(userId);
	}

}
