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
	
	public int insertIntoApplication(String userId,String type)
	{
		int status =0;
		try{
		long millis=System.currentTimeMillis();
		java.sql.Date date=new java.sql.Date(millis);
		Map<String, Object> parameters=new HashMap<String, Object>();
		
		if(type.equalsIgnoreCase("SaveAsDraft"))
		{
			parameters.put("applicationState","Draft");
		}
		else if(type.equalsIgnoreCase("Submit"))
		{
		parameters.put("applicationState","Submit");
		}
		parameters.put("userId",userId);
		parameters.put("activeFlag","1");
		parameters.put("dateOfSubmission",date);
		status = getJdbcTemplate().update(profileCreationConfigSql.getInsertDataInApplication(), parameters);
		}
		catch(Exception e)
		{
			LOGGER.error("An exception occured while creating an application "  + e);
			//e.printStackTrace();
			status = -1;
		}
		return status;
	}

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
	
	public int insertIntoTrainingPartnerRegistration(ProfileCreationTrainingPartnerDto profileCreationTrainingPartnerDto)
	{
		try{
			Map<String, Object> parameters=new HashMap<String, Object>();
			parameters.put("applicationId",sessionUserUtility.getApplicationId(profileCreationTrainingPartnerDto.getUserId()));
			parameters.put("organizationName",profileCreationTrainingPartnerDto.getOrganizationName());
			parameters.put("sPOCName",profileCreationTrainingPartnerDto.getsPOCName());
			parameters.put("address",profileCreationTrainingPartnerDto.getAddress());
			parameters.put("city",profileCreationTrainingPartnerDto.getCity());
			parameters.put("state",profileCreationTrainingPartnerDto.getState());
			parameters.put("pincode",profileCreationTrainingPartnerDto.getPincode());
			System.out.println(profileCreationTrainingPartnerDto.getPincode());
			parameters.put("mobileNumber",profileCreationTrainingPartnerDto.getMobileNumber());
			parameters.put("alternateMobileNumber",profileCreationTrainingPartnerDto.getAlternateMobileNumber());
			parameters.put("landlineNumber",profileCreationTrainingPartnerDto.getLandlineNumber());
			parameters.put("alternateLandlineNumber",profileCreationTrainingPartnerDto.getAlternateLandlineNumber());
			parameters.put("faxNumber",profileCreationTrainingPartnerDto.getFaxNumber());
			parameters.put("websites",profileCreationTrainingPartnerDto.getWebsites());
			parameters.put("userId",profileCreationTrainingPartnerDto.getUserId());

			return getJdbcTemplate().update(profileCreationConfigSql.getInsertDataInTrainingPartnerRegistration(),parameters);

		}catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
		
	}

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
			System.out.println(profileCreationTrainingPartnerDto.getPincode());
			parameters.put("mobileNumber",profileCreationTrainingPartnerDto.getMobileNumber());
			parameters.put("alternateMobileNumber",profileCreationTrainingPartnerDto.getAlternateMobileNumber());
			parameters.put("landlineNumber",profileCreationTrainingPartnerDto.getLandlineNumber());
			parameters.put("alternateLandlineNumber",profileCreationTrainingPartnerDto.getAlternateLandlineNumber());
			parameters.put("faxNumber",profileCreationTrainingPartnerDto.getFaxNumber());
			parameters.put("websites",profileCreationTrainingPartnerDto.getWebsites());
			parameters.put("userId",profileCreationTrainingPartnerDto.getUserId());

			return getJdbcTemplate().update(profileCreationConfigSql.getUpdateDataInTrainingPartnerRegistration(),parameters);

		}catch(Exception e)
		{
			
			e.printStackTrace();
			return -1;
		}
		
	}


}
