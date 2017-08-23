package com.skill.India.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.GetApplicationStateDao;
import com.skill.India.dto.ApplicationDto;

@Service
public class GetApplicationStateService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GetApplicationStateService.class);

	@Autowired
	private GetApplicationStateDao getApplicationStateDao;
	
	public ApplicationDto getApplicationStateService(String userId)
	{
		LOGGER.info("Request Received from Controller");
		LOGGER.info("In GetApplicationStateService - getApplicationStateService");
		LOGGER.info("Parameters Received from front end are - 'userId': ",userId);
		try
		{
			LOGGER.info("In TRY block");
			LOGGER.info("Getting application state of the received userId");
			LOGGER.info("Sending request to Dao");
//			System.out.println(getApplicationStateDao.getApplicationState(userId));
			LOGGER.info("Sending response back to Controller");
			return getApplicationStateDao.getApplicationState(userId);
		}
		catch(Exception e)
		{
			LOGGER.info("In catch Block");
			LOGGER.info("ERROR: Encountered Exception - ",e);
			e.printStackTrace();
			LOGGER.info("Sending response back to Controller");
			return  null;
		}
	}
	
}
