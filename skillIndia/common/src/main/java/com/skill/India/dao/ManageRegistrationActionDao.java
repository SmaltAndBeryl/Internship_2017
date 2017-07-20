package com.skill.India.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.ApproveRejectTableConfigSql;
import com.skill.India.dto.ManageRegistrationApplicationDto;

@Repository
public class ManageRegistrationActionDao extends AbstractTransactionalDao {

	@Autowired
	public ApproveRejectTableConfigSql config;
	
		
	/* Method to check if comments for an application Id already exists*/
	public Integer checkCommentExistence(int applicationId)
	{
		
		Map<String, Object> commentExistenceParameter = new HashMap<>();
		commentExistenceParameter.put("applicationId", applicationId);
		return getJdbcTemplate().queryForObject(config.getCommentExistSql(), commentExistenceParameter, Integer.class);
	}
	

	/* Method to update column active flag of Application Comments table*/
	 
	public int updateCommentsOnAction(int applicationId)
	{
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("applicationId", applicationId);
		System.out.println("In the updateComments");
		return getJdbcTemplate().update(config.getUpdateSQLComment(), parameters);
	}
		
	/* Method to insert comments in applicationComments Table*/
	public int insertCommentsOnAction(int applicationId, String comment)
	{
		Map<String, Object> insertCommentsOnEditMap = new HashMap<>();
		insertCommentsOnEditMap.put("applicationId", applicationId);
		insertCommentsOnEditMap.put("comment", comment);
		return insert(config.getInsertSql(),insertCommentsOnEditMap, "commentId");
	}
	
	/*Method to update applicationState Column of an Application */
	public int updateApplicationStateonAction(Integer applicationId, String applicationState)
	{
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("applicationId", applicationId);
		parameters.put("applicationState", applicationState);
		return getJdbcTemplate().update(config.getUpdateSqlApplication(), parameters);
	}
	
	/**/
	public Integer updateAffilationOfAApplicant(ManageRegistrationApplicationDto manageRegistrationApplicationDto)
	{
		try
		{
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("applicationState",manageRegistrationApplicationDto.getApplicationState() );
			parameters.put("activeFlag", manageRegistrationApplicationDto.getActiveFlag());
			//parameters.put("userId",manageRegistrationApplicationDto.getUserId());
			parameters.put("applicationId",manageRegistrationApplicationDto.getApplicationId());
			int i= getJdbcTemplate().update(config.getUpdateSqlAction(), parameters);
			System.out.println("I is :"+i);
			return i;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception e:"+e);
			return 0;
		}
		
	}
}

