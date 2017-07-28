package com.skill.India.dao;

import java.util.HashMap;
import java.util.Map;

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
	
	public int insertIntoApplication(ProfileCreationTrainingPartnerDto profileCreationTrainingPartnerDto)
	{
		try{
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);  
		Map<String, Object> parameters=new HashMap<String, Object>();
		parameters.put("applicationState","draft");
		parameters.put("userId",profileCreationTrainingPartnerDto.getUserId());
		parameters.put("activeFlag","0");
		parameters.put("date",date);
		
		return getJdbcTemplate().update(profileCreationConfigSql.getInsertDataInApplication(), parameters);
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
			parameters.put("organizationName",profileCreationTrainingPartnerDto.getOrganizationName());
			parameters.put("SPOCName",profileCreationTrainingPartnerDto.getSPOCName());
			parameters.put("address",profileCreationTrainingPartnerDto.getAddress());
			parameters.put("city",profileCreationTrainingPartnerDto.getCity());
			parameters.put("state",profileCreationTrainingPartnerDto.getState());
			parameters.put("pincode",profileCreationTrainingPartnerDto.getPincode());
			System.out.println(profileCreationTrainingPartnerDto.getPincode());
			parameters.put("mobileNumber",profileCreationTrainingPartnerDto.getMobileNumber());
			parameters.put("landlineNumber",profileCreationTrainingPartnerDto.getLandlineNumber());
			parameters.put("faxNumber",profileCreationTrainingPartnerDto.getFaxNumber());
			parameters.put("website",profileCreationTrainingPartnerDto.getWebsite());
			parameters.put("userId",profileCreationTrainingPartnerDto.getUserId());
			
			return getJdbcTemplate().update(profileCreationConfigSql.getInsertDataInTrainingPartnerRegistration(),parameters);
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateIntoTrainingPartnerRegistration(ProfileCreationTrainingPartnerDto profileCreationTrainingPartnerDto)
	{
		try{
			Map<String, Object> parameters=new HashMap<String, Object>();
			parameters.put("organizationName",profileCreationTrainingPartnerDto.getOrganizationName());
			parameters.put("SPOCName",profileCreationTrainingPartnerDto.getSPOCName());
			parameters.put("address",profileCreationTrainingPartnerDto.getAddress());
			parameters.put("city",profileCreationTrainingPartnerDto.getCity());
			parameters.put("state",profileCreationTrainingPartnerDto.getState());
			parameters.put("pincode",profileCreationTrainingPartnerDto.getPincode());
			parameters.put("mobileNumber",profileCreationTrainingPartnerDto.getMobileNumber());
			parameters.put("landlineNumber",profileCreationTrainingPartnerDto.getLandlineNumber());
			parameters.put("faxNumber",profileCreationTrainingPartnerDto.getFaxNumber());
			parameters.put("website",profileCreationTrainingPartnerDto.getWebsite());
			parameters.put("userId",profileCreationTrainingPartnerDto.getUserId());
			
			return getJdbcTemplate().update(profileCreationConfigSql.getUpdateDataInTrainingPartnerRegistration(),parameters);
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	
	
}
