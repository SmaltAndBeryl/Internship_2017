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
		LOGGER.info("Request Received from Service");
		LOGGER.info("In GetSPOCNameDao - getSPOCName");
		LOGGER.info("Parameters Received from Service are - 'userId': " +userId);
	   	
		try
		{
			LOGGER.info("Inside TRY block");
			LOGGER.info("getting SPOC name for User");
		
			LOGGER.info("Creating HashMap object");
			Map<String, Object> parameters = new HashMap<String, Object>();
			LOGGER.info("object created successfully");
			
			LOGGER.info("Inserting parameters to HashMap object");
			parameters.put("userId",userId);
			LOGGER.info("Parameters inserted");
			
			LOGGER.info("Executing SQL query and returning response");
	        return getJdbcTemplate().queryForObject(loginConfig.getGetSPOCName(), parameters, String.class);
		}
		catch(Exception e)
		{
			LOGGER.info("Inside CATCH block");
			
			LOGGER.error("ERROR: Encountered Exception - "+e);
			
			LOGGER.info("Returning NULL");
//			e.printStackTrace();
			return null;
		}
	}	
}
