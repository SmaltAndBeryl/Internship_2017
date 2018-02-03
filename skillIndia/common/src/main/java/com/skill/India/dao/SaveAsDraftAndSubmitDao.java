package com.skill.India.dao;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.common.SessionUserUtility;
import com.skill.India.config.ProfileCreationConfigSql;
import com.skill.India.dto.ProfileCreationTrainingPartnerDto;

@Repository
public class SaveAsDraftAndSubmitDao extends AbstractTransactionalDao {

	@Autowired
	private SessionUserUtility sessionUserUtility;

	@Autowired
	private ProfileCreationConfigSql profileCreationConfigSql;
	private static final Logger LOGGER = LoggerFactory.getLogger(SaveAsDraftAndSubmitDao.class);
	
	/**
	 * Method to insert data into application table
	 * @param userId
	 * @param type
	 * @return and integer value of status
	 */
	public int insertIntoApplication(String userId, String type, String userRole, String organisationName, String spocName )
	{
		int status =0, statusApplication =0, statusTpInsertion = 0, statusAbInsertion = 0;
		try{
		long millis=System.currentTimeMillis();
		java.sql.Date date=new java.sql.Date(millis);
		Map<String, Object> parameters=new HashMap<String, Object>();
		Map<String,Object> profilecreationParameters = new HashMap<String,Object>();
		
		if(type.equalsIgnoreCase("Draft"))
		{
			parameters.put("applicationState","Draft");
		}
		else if(type.equalsIgnoreCase("Submit"))
		{
		parameters.put("applicationState","Submit");
		}
		else
		{
			parameters.put("applicationState", "Draft");
		}
		parameters.put("userId",userId);
		parameters.put("activeFlag","1");
		parameters.put("dateOfSubmission",date);	
		statusApplication = getJdbcTemplate().update(profileCreationConfigSql.getInsertDataInApplication(), parameters);
		if(userRole.equalsIgnoreCase("TP"))
		{
			statusTpInsertion = insertIntoTrainingPartnerRegistration(userId, organisationName, spocName);
		}
		else if (userRole.equalsIgnoreCase("AB"))
		{
			statusAbInsertion = insertIntoAssessmentBodyOrganisation(userId, organisationName, spocName);
		}
		}
		catch(Exception e)
		{
			LOGGER.error("An exception occured while creating an application "  + e);
			//e.printStackTrace();
			status = -1;
		}
		
		if(statusAbInsertion == 1 && statusApplication == 1 && statusTpInsertion == 1)
		{
			status = 1;
		}
		else
		{
			status =0;
			
		}
		return status;
	}

	/**
	 * Update into application
	 * @param profileCreationTrainingPartnerDto
	 * @param type
	 * @return
	 */
	public int updateIntoApplication(ProfileCreationTrainingPartnerDto profileCreationTrainingPartnerDto,String type)
	{
		try{
		long millis=System.currentTimeMillis();
		java.sql.Date date=new java.sql.Date(millis);
		Map<String, Object> parameters=new HashMap<String, Object>();
		parameters.put("applicationState","Submit");
		parameters.put("userId",profileCreationTrainingPartnerDto.getUserId());
		parameters.put("activeFlag","1");
		parameters.put("dateOfSubmission",date);
		return getJdbcTemplate().update(profileCreationConfigSql.getUpdateDataInApplication(), parameters);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
	}
	
	/**
	 * Method to insert details into training partner
	 * @param profileCreationTrainingPartnerDto
	 * @return
	 */
	private int insertIntoTrainingPartnerRegistration(String userId, String organisationName, String spocName)
	{
		try{
			LOGGER.debug("Trying to insert value in training partner registartion details while sign up");
			Map<String, Object> parameters=new HashMap<String, Object>();
			parameters.put("applicationId",sessionUserUtility.getApplicationId(userId));
			parameters.put("organizationName",organisationName);
			parameters.put("sPOCName",spocName);

			return getJdbcTemplate().update(profileCreationConfigSql.getInsertDataInTrainingPartnerRegistration(),parameters);

		}
		catch(Exception e)
		{
			
			LOGGER.debug("An exception has occurred while inserting data into training partner organisation details" + e);
			//e.printStackTrace();
			return -1;
		}
		
	}
	
	/**
	 * Method to insert data into assessment body during sign up
	 * @param userId
	 * @param organisationName
	 * @param spocName
	 * @return integer value of status
	 */
	private int insertIntoAssessmentBodyOrganisation(String userId, String organisationName, String spocName)
	{
		try
		{
			LOGGER.debug("Trying to insert values into assessment body while sign up");
			Map<String, Object> parameters=new HashMap<String, Object>();
			parameters.put("applicationId",sessionUserUtility.getApplicationId(userId));
			parameters.put("organizationName",organisationName);
			parameters.put("sPOCName",spocName);

			return getJdbcTemplate().update(profileCreationConfigSql.getInsertDataInAssessmentBodyRegistration(),parameters);

		}
		catch(Exception e)
		{
			LOGGER.error("An exception occured while inserting values into assessment body organisation details");
			return -1;
		}
	}

	/**
	 * 
	 * @param profileCreationTrainingPartnerDto
	 * @return
	 */
	public int updateIntoTrainingPartnerRegistration(ProfileCreationTrainingPartnerDto profileCreationTrainingPartnerDto)
	{
		try{
			Map<String, Object> parameters=new HashMap<String, Object>();
			parameters.put("organizationName",profileCreationTrainingPartnerDto.getOrganizationName());
			parameters.put("sPOCName",profileCreationTrainingPartnerDto.getsPOCName());
			parameters.put("address",profileCreationTrainingPartnerDto.getAddress());
			parameters.put("city",profileCreationTrainingPartnerDto.getCity());
			parameters.put("state",profileCreationTrainingPartnerDto.getState());
			parameters.put("pincode",profileCreationTrainingPartnerDto.getPincode());
			//System.out.println(profileCreationTrainingPartnerDto.getPincode());
			parameters.put("mobileNumber",profileCreationTrainingPartnerDto.getMobileNumber());
			parameters.put("alternateMobileNumber",profileCreationTrainingPartnerDto.getAlternateMobileNumber());
			parameters.put("landlineNumber",profileCreationTrainingPartnerDto.getLandlineNumber());
			parameters.put("alternateLandlineNumber",profileCreationTrainingPartnerDto.getAlternateLandlineNumber());
			parameters.put("faxNumber",profileCreationTrainingPartnerDto.getFaxNumber());
			parameters.put("websites",profileCreationTrainingPartnerDto.getWebsites());
			parameters.put("userId",profileCreationTrainingPartnerDto.getUserId());

			return getJdbcTemplate().update(profileCreationConfigSql.getUpdateDataInTrainingPartnerRegistration(),parameters);

		}
		catch(Exception e)
		{
			LOGGER.error("An exception has occured while updating into training partner organisation details");
			//e.printStackTrace();
			return -1;
		}
		
	}


}
