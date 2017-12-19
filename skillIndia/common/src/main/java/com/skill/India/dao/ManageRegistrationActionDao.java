package com.skill.India.dao;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.ApproveRejectTableConfigSql;
import com.skill.India.dto.ManageRegistrationApplicationDto;

@Repository
public class ManageRegistrationActionDao extends AbstractTransactionalDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(ManageRegistrationActionDao.class);
	
	@Autowired
	public ApproveRejectTableConfigSql config;
	
		
	/* Method to check if comments for an application Id already exists*/
	public Integer checkCommentExistence(int applicationId)
	{
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In ManageRegistrationActionDao - checkCommentExistence");
		LOGGER.debug("Parameters Received from Service are - 'applicationId': " +applicationId);
		   	
		LOGGER.debug("Checking if comment exists or not corresponding to Application Id");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> commentExistenceParameter = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Inserting parameters to HashMap object");
		commentExistenceParameter.put("applicationId", applicationId);
		LOGGER.debug("Parameters inserted");
		
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().queryForObject(config.getCommentExistSql(), commentExistenceParameter, Integer.class);
	}
	

	/* Method to update column active flag of Application Comments table*/
	 
	public int updateCommentsOnAction(int applicationId)
	{
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In ManageRegistrationActionDao - updateCommentsOnAction");
		LOGGER.debug("Parameters Received from Service are - 'applicationId': " +applicationId);
		   	
		LOGGER.debug("Setting Active Flag of previous comment to false");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Inserting parameters to HashMap object");
		parameters.put("applicationId", applicationId);
		LOGGER.debug("Parameters inserted");
		
//      System.out.println("In the updateComments");
		LOGGER.debug("Executing SQL query and returning response");
		return getJdbcTemplate().update(config.getUpdateSQLComment(), parameters);
	}
		
	/* Method to insert comments in applicationComments Table*/
	public int insertCommentsOnAction(int applicationId, String comment)
	{
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In ManageRegistrationActionDao - insertCommentsOnAction");
		LOGGER.debug("Parameters Received from Service are - 'applicationId': " +applicationId+" 'comment': "+comment);
		   	
		LOGGER.debug("Set/Updating Comment and Active Flag of comment to True");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> insertCommentsOnEditMap = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Inserting parameters to HashMap object");
		insertCommentsOnEditMap.put("applicationId", applicationId);
		insertCommentsOnEditMap.put("comment", comment);
		LOGGER.debug("Parameters inserted");
		
		LOGGER.debug("Executing SQL query and returning response");
		return insert(config.getInsertSql(),insertCommentsOnEditMap, "commentId");
	}
	
	/*Method to update applicationState Column of an Application */
	public int updateApplicationStateonAction(Integer applicationId, String applicationState)
	{
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In ManageRegistrationActionDao - updateApplicationStateonAction");
		LOGGER.debug("Parameters Received from Service are - 'applicationId': " +applicationId+" 'applicationState': "+applicationState);
		   	
		LOGGER.debug("Updating Application state of a Application Id");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Inserting parameters to HashMap object");
		parameters.put("applicationId", applicationId);
		parameters.put("applicationState", applicationState);
		LOGGER.debug("Parameters inserted");
		
		LOGGER.debug("Executing SQL query and returning response");
		return getJdbcTemplate().update(config.getUpdateSqlApplication(), parameters);
	}
	
	/**/
	public Integer updateAffilationOfAApplicant(ManageRegistrationApplicationDto manageRegistrationApplicationDto)
	{
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In ManageRegistrationActionDao - updateAffilationOfAApplicant");
		LOGGER.debug("Parameters Received from Service are - 'ManageRegistrationApplicationDto': " +manageRegistrationApplicationDto);
		
		LOGGER.debug("Updating Applcation State and Active Flag for Application Id");
		
		try
		{
			LOGGER.debug("Inside TRY block");
			
			LOGGER.debug("Creating HashMap object");
			Map<String, Object> parameters = new HashMap<>();
			LOGGER.debug("object created successfully");
			
			LOGGER.debug("Inserting parameters to HashMap object");
			parameters.put("applicationState",manageRegistrationApplicationDto.getApplicationState() );
			parameters.put("activeFlag", manageRegistrationApplicationDto.getActiveFlag());
			//parameters.put("userId",manageRegistrationApplicationDto.getUserId());
			parameters.put("applicationId",manageRegistrationApplicationDto.getApplicationId());
			LOGGER.debug("Parameters inserted");
			
			LOGGER.debug("Executing SQL query");
			int i= getJdbcTemplate().update(config.getUpdateSqlAction(), parameters);
			LOGGER.debug("Successfully executed");
//			System.out.println("I is :"+i);
			LOGGER.debug("Returning response");
			return i;
		}
		catch(Exception e)
		{
			LOGGER.debug("Inside CATCH block");
			
			LOGGER.error("ERROR: Encountered Exception - "+e);
			
			LOGGER.debug("Returning 0");
//			e.printStackTrace();
//			System.out.println("Exception e:"+e);
			return 0;
		}
		
	}
}

