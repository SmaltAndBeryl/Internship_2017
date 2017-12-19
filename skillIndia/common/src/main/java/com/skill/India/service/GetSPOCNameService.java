package com.skill.India.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.GetSPOCNameDao;

@Service
public class GetSPOCNameService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GetSPOCNameService.class);

	@Autowired
	private GetSPOCNameDao getSPOCNameDao;
	
	public String getSPOCNameService(String userId){
		LOGGER.debug("Request Received from Controller");
		LOGGER.debug("In GetSPOCNameService - getSPOCNameService");
		LOGGER.debug("Parameters Received from front end are - 'userId': "+userId);
		
		try
		{
			LOGGER.debug("In TRY block");
			LOGGER.debug("Getting SPOCName from the received userId");
			LOGGER.debug("Sending request to Dao");
			return getSPOCNameDao.getSPOCName(userId);
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
