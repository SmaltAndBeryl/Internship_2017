package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.skill.India.config.SignUpConfigSql;
import com.skill.India.dto.SignUpInsertedUserDto;

@Repository
public class SignUpDao extends AbstractTransactionalDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SignUpDao.class);
	
	@Autowired
	private SignUpConfigSql signUpConfigSql;

	private static final SignUpRowSelectRowMapper ROW_MAPPER = new SignUpRowSelectRowMapper();
	
	public Integer checkUserExistence(String userId, String organizationName){
		
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In SignUpDao - checkUserExistence");
		LOGGER.debug("Parameters Received from Service are - 'userId': " +userId+" 'organizationName': "+organizationName);
		   	
		LOGGER.debug("Checking the user existence ");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Inserting parameters to HashMap object");
		parameters.put("userId", userId);
		parameters.put("organizationName", organizationName);
		LOGGER.debug("Parameters inserted");
		
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().queryForObject(signUpConfigSql.getCheckSql(), parameters, Integer.class);
		
	}
		
	public int insertSignUpData(String organizationName, String sPOCName, String userId, String password, String userRole) {
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In SignUpDao - insertSignUpData");
		LOGGER.debug("Parameters Received from Service are - 'organizationName': " +organizationName+" 'sPOCName': "+sPOCName+" 'userId': "+userId+" 'password':   "+" 'userRole': "+userRole);
		
		LOGGER.debug("Insert the record of new user-organization name, spoc name, user id, password");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Inserting parameters to HashMap object");
		parameters.put("organizationName",organizationName);
		parameters.put("sPOCName", sPOCName);
		parameters.put("userId", userId);
		parameters.put("password", password );
		parameters.put("userRole", userRole);
		LOGGER.debug("Parameters inserted");
		
		LOGGER.debug("Executing SQL query and returning response");
        return insert(signUpConfigSql.getInsertSql(), parameters, "Id");
	}
	
	
	public Collection<SignUpInsertedUserDto> getUserData(int Id){
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In SignUpDao - getUserData");
		LOGGER.debug("Parameters Received from Service are - 'Id': " +Id);
		
		LOGGER.debug("Fetch the record of new user");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Inserting parameters to HashMap object");
		parameters.put("Id",Id);
		LOGGER.debug("Parameters inserted");
		
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().query(signUpConfigSql.getGetSql(), parameters, ROW_MAPPER);
	}

	
	private static class SignUpRowSelectRowMapper implements RowMapper<SignUpInsertedUserDto> {
		
		@Override
		public SignUpInsertedUserDto mapRow(ResultSet resultSet, int rowNum)throws SQLException 
		{			String userId = resultSet.getString("userId");
					String organizationName = resultSet.getString("organizationName");
					String sPOCName = resultSet.getString("sPOCName");
					return new SignUpInsertedUserDto(userId,organizationName,sPOCName);
					
		}
	
	
	}
}
