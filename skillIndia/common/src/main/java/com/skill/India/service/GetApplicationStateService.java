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
		LOGGER.debug("Request Received from Controller");
		LOGGER.debug("In GetApplicationStateService - getApplicationStateService");
		LOGGER.debug("Parameters Received from front end are - 'userId': "+userId);
		try
		{
			LOGGER.debug("In TRY block");
			LOGGER.debug("Getting application state of the received userId");
			LOGGER.debug("Sending request to Dao");
//			System.out.println(getApplicationStateDao.getApplicationState(userId));
			LOGGER.debug("Sending response back to Controller");
			return getApplicationStateDao.getApplicationState(userId);
		}
		catch(Exception e)
		{
			LOGGER.debug("In catch Block");
			LOGGER.debug("ERROR: Encountered Exception - "+e);
			e.printStackTrace();
			LOGGER.debug("Sending response back to Controller");
			return  null;
		}
	}
	
}
