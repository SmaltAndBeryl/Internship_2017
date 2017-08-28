package com.skill.India.dao;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.UserIdtoApplicationIdConfigSql;


@Repository
public class UserIdtoApplicationIdDao extends AbstractTransactionalDao {
	
	@Autowired
	private UserIdtoApplicationIdConfigSql userIdtoApplicationIdConfigSql;
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(UserIdtoApplicationIdDao.class);

	public Integer getApplicationId(String userId){
		
		LOGGER.info("Request Received from Service");
		LOGGER.info("In UserIdtoApplicationIdDao - getApplicationId");
		LOGGER.info("Parameters Received from Service are - 'userId': " +userId);
		
		try
		{
			LOGGER.info("Inside TRY block");
			
			LOGGER.info("Getting Application Id from User Id");
			
			LOGGER.info("Creating HashMap object");
			Map<String, Object> parameters = new HashMap<>();
			LOGGER.info("object created successfully");
	
			LOGGER.info("Inserting parameters to HashMap object");
			parameters.put("userId", userId);
			LOGGER.info("Parameters inserted");
			
			LOGGER.info("Executing SQL query and returning response");
	        return getJdbcTemplate().queryForObject(userIdtoApplicationIdConfigSql.getSelectSql(), parameters, Integer.class);
		}
		catch(EmptyResultDataAccessException e)
		{
			/*
			 * Application id doesnt exist i.e. no app id is returned corresponding to userId
			 */
			LOGGER.info("Inside CATCH block");
			
			LOGGER.error("ERROR: Encountered Exception - "+e);
			
			LOGGER.info("No Application Id found corresponding to UserId sent");
			return -1;
		}
		catch (Exception e) {
			
			LOGGER.info("Inside CATCH block");
			
			LOGGER.error("ERROR: Encountered Exception - "+e);
			
			LOGGER.info("Exception occurs in getting applicationId");
			LOGGER.info("Returning NULL");
			return null;
			// TODO: handle exception
		}
	}
}
