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
		
		LOGGER.info("Request Received from Service");
		LOGGER.info("In SignUpDao - checkUserExistence");
		LOGGER.info("Parameters Received from Service are - 'userId': " +userId+" 'organizationName': "+organizationName);
		   	
		LOGGER.info("Checking the user existence ");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Inserting parameters to HashMap object");
		parameters.put("userId", userId);
		parameters.put("organizationName", organizationName);
		LOGGER.info("Parameters inserted");
		
		LOGGER.info("Executing SQL query and returning response");
        return getJdbcTemplate().queryForObject(signUpConfigSql.getCheckSql(), parameters, Integer.class);
		
	}
		
	public int insertSignUpData(String organizationName, String sPOCName, String userId, String password, String userRole) {
		LOGGER.info("Request Received from Service");
		LOGGER.info("In SignUpDao - insertSignUpData");
		LOGGER.info("Parameters Received from Service are - 'organizationName': " +organizationName+" 'sPOCName': "+sPOCName+" 'userId': "+userId+" 'password':   "+" 'userRole': "+userRole);
		
		LOGGER.info("Insert the record of new user-organization name, spoc name, user id, password");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Inserting parameters to HashMap object");
		parameters.put("organizationName",organizationName);
		parameters.put("sPOCName", sPOCName);
		parameters.put("userId", userId);
		parameters.put("password", password );
		parameters.put("userRole", userRole);
		LOGGER.info("Parameters inserted");
		
		LOGGER.info("Executing SQL query and returning response");
        return insert(signUpConfigSql.getInsertSql(), parameters, "Id");
	}
	
	
	public Collection<SignUpInsertedUserDto> getUserData(int Id){
		LOGGER.info("Request Received from Service");
		LOGGER.info("In SignUpDao - getUserData");
		LOGGER.info("Parameters Received from Service are - 'Id': " +Id);
		
		LOGGER.info("Fetch the record of new user");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Inserting parameters to HashMap object");
		parameters.put("Id",Id);
		LOGGER.info("Parameters inserted");
		
		LOGGER.info("Executing SQL query and returning response");
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
