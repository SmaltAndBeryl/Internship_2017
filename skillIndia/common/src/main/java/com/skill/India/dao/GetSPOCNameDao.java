package com.skill.India.dao;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.LoginConfig;

@Repository
public class GetSPOCNameDao extends AbstractTransactionalDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(GetSPOCNameDao.class);
	
	@Autowired
	private LoginConfig loginConfig;
	
	
	public String getSPOCName(String userId)
	{
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In GetSPOCNameDao - getSPOCName");
		LOGGER.debug("Parameters Received from Service are - 'userId': " +userId);
	   	
		try
		{
			LOGGER.debug("Inside TRY block");
			LOGGER.debug("getting SPOC name for User");
		
			LOGGER.debug("Creating HashMap object");
			Map<String, Object> parameters = new HashMap<String, Object>();
			LOGGER.debug("object created successfully");
			
			LOGGER.debug("Inserting parameters to HashMap object");
			parameters.put("userId",userId);
			LOGGER.debug("Parameters inserted");
			
			LOGGER.debug("Executing SQL query and returning response");
	        return getJdbcTemplate().queryForObject(loginConfig.getGetSPOCName(), parameters, String.class);
		}
		catch(Exception e)
		{
			LOGGER.debug("Inside CATCH block");
			
			LOGGER.error("ERROR: Encountered Exception - "+e);
			
			LOGGER.debug("Returning NULL");
//			e.printStackTrace();
			return null;
		}
	}	
}
