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
import com.skill.India.config.ProfileCreationConfigSql;
import com.skill.India.dto.ProfileCreationTrainingPartnerDto;

@Repository
public class ProfileCreationTrainingPartnerDao extends AbstractTransactionalDao{

	@Autowired
	private ProfileCreationConfigSql profileCreationConfigSql;

	private static final ProfileCreationRowMapper ROW_MAPPER_TPREG = new ProfileCreationRowMapper();
	private static final ProfileCreationRowMapperUser ROW_MAPPER_USER = new ProfileCreationRowMapperUser();

	public int profileCreationCheckUserIdExistence(String userId)
	{
		try{
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("userId",userId);
			return getJdbcTemplate().queryForObject(profileCreationConfigSql.getCheckuserIdExistenceInTrainingPartnerRegistration(), parameters, Integer.class);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 2;
		}
	}


	public Collection<ProfileCreationTrainingPartnerDto> profileCreationGetDataFromTrainingPartnerRegistration(String userId)
	{
		try{
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("userId",userId);
		System.out.println("Herrrrrrrrrrree");
		return getJdbcTemplate().query(profileCreationConfigSql.getGetTrainingPartnerDataByUserId(),parameters,ROW_MAPPER_TPREG);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
 	}

	public static class ProfileCreationRowMapper implements RowMapper<ProfileCreationTrainingPartnerDto> {

		@Override
		public ProfileCreationTrainingPartnerDto mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {
			String organizationName = resultSet.getString("organizationName");
			String sPOCName = resultSet.getString("sPOCName");
			String address = resultSet.getString("address");
			String city = resultSet.getString("city");
			String state = resultSet.getString("state");
		    String pincode = resultSet.getString("pincode");
			String mobileNumber = resultSet.getString("mobileNumber");
			String alternateMobileNumber = resultSet.getString("alternateMobileNumber");
			String landlineNumber = resultSet.getString("landlineNumber");
			String alternateLandlineNumber = resultSet.getString("alternateLandlineNumber");
			String faxNumber = resultSet.getString("faxNumber");
			String websites = resultSet.getString("websites");
			String userId = resultSet.getString("userId");
			return new ProfileCreationTrainingPartnerDto(organizationName,sPOCName,userId,address,city,state,pincode,mobileNumber,alternateMobileNumber,landlineNumber,alternateLandlineNumber,faxNumber,websites);
		}

}

	public Collection<ProfileCreationTrainingPartnerDto> profileCreationGetDataFromUser(String userId)
	{
		try{
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("userId",userId);
		return getJdbcTemplate().query(profileCreationConfigSql.getGetTrainingPartnerDataByUserIdFronUser(),parameters,ROW_MAPPER_USER);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
 	}

	public static class ProfileCreationRowMapperUser implements RowMapper<ProfileCreationTrainingPartnerDto> {

		@Override
		public ProfileCreationTrainingPartnerDto mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {
			String organizationName = resultSet.getString("organizationName");
			String sPOCName = resultSet.getString("sPOCName");
			String userId = resultSet.getString("userId");
			return new ProfileCreationTrainingPartnerDto(organizationName,sPOCName,userId);
		}

}




}