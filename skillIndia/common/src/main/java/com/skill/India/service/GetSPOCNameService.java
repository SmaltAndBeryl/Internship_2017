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
		LOGGER.info("Request Received from Controller");
		LOGGER.info("In GetSPOCNameService - getSPOCNameService");
		LOGGER.info("Parameters Received from front end are - 'userId': "+userId);
		
		try
		{
			LOGGER.info("In TRY block");
			LOGGER.info("Getting SPOCName from the received userId");
			LOGGER.info("Sending request to Dao");
			return getSPOCNameDao.getSPOCName(userId);
		}
		catch(Exception e)
		{
			LOGGER.info("In catch Block");
			LOGGER.info("ERROR: Encountered Exception - "+e);
			e.printStackTrace();
			LOGGER.info("Sending response back to Controller");
			return  null;
		}
	}
	
}
