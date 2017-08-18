package com.skill.India.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.common.SessionUserUtility;
import com.skill.India.config.ProfileCreationTPABCommonConfigSql;
import com.skill.India.dto.ProfileCreationGetDataFromUserDto;

@Repository
public class ProfileCreationTPABCommonDao extends AbstractTransactionalDao{
	
	@Autowired
	private ProfileCreationTPABCommonConfigSql profileCreationTPABCommonConfigSql;
	
	@Autowired
	private SessionUserUtility sessionUserUtility;

	/*
	 * Getting data from User table 
	 */
	
	
private static final ProfileCreationGetDataFromUserRowMapper ROW_MAPPER_USERDETAILS = new ProfileCreationGetDataFromUserRowMapper();
	
	public Collection<ProfileCreationGetDataFromUserDto> profileCreationGetDataFromUser()
	{
		try{
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("userId",sessionUserUtility.getSessionMangementfromSession().getUsername());
		return getJdbcTemplate().query(profileCreationTPABCommonConfigSql.getGetDataFromUser(),parameters,ROW_MAPPER_USERDETAILS);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
 	}
	
	public static class ProfileCreationGetDataFromUserRowMapper implements RowMapper<ProfileCreationGetDataFromUserDto> {

		@Override
		public ProfileCreationGetDataFromUserDto mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {

			String organizationName = resultSet.getString("organizationName");
			String sPOCName = resultSet.getString("sPOCName");
			String userId = resultSet.getString("userId");
			return new ProfileCreationGetDataFromUserDto(organizationName,sPOCName,
					userId);
		}

}

	
	/*
	 * Insert into Application table 
	 */

	public int insertIntoApplication(String type)
	{
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
		parameters.put("userId",sessionUserUtility.getSessionMangementfromSession().getUsername());
		parameters.put("activeFlag","1");
		parameters.put("dateOfSubmission",date);
		return getJdbcTemplate().update(profileCreationTPABCommonConfigSql.getInsertIntoApplication(), parameters);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
	}
	

	/*
	 * Update into Application table 
	 */

	public int updateIntoApplication(String type)
	{
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
		parameters.put("userId",sessionUserUtility.getSessionMangementfromSession().getUsername());
		parameters.put("activeFlag","1");
		parameters.put("dateOfSubmission",date);
		return getJdbcTemplate().update(profileCreationTPABCommonConfigSql.getUpdateIntoApplication(), parameters);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
	}
	
	
	
	
}
