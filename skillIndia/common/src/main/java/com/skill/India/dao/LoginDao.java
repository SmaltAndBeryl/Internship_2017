package com.skill.India.dao;
import com.skill.India.dto.LoginDto;
import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.LoginConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class LoginDao extends AbstractTransactionalDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginDao.class);

	@Autowired
	public LoginConfig loginconfig;
	
	private static final LoginRowSelectRowMapper ROW_MAPPER = new LoginRowSelectRowMapper();
	
	
	public Integer userExistence(String userId, String password){
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In LoginDao - userExistence");
		LOGGER.debug("Parameters Received from Service are - 'userId': " +userId+" 'password': ");
		   	
		LOGGER.debug("Checking Existense of User");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Inserting parameters to HashMap object");
		parameters.put("userId", userId);
		parameters.put("password", password);
		LOGGER.debug("Parameters inserted");
		
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().queryForObject(loginconfig.getCheckUserSql(), parameters, Integer.class);
		
	}
	
	public Collection<LoginDto> getValidateLoginUser(String userId, String password) {
//		LOGGER.debug("After successful existence, validate the user against entered credentials");
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In LoginDao - getValidateLoginUser");
		LOGGER.debug("Parameters Received from Service are - 'userId': " +userId+" 'password': ");
		   	
		LOGGER.debug("Getting UserRole,UserStatus of User ");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Inserting parameters to HashMap object");
		parameters.put("userId", userId);
		parameters.put("password", password);
		LOGGER.debug("Parameters inserted");
		
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().query(loginconfig.getSelectSql(),parameters, ROW_MAPPER);//query for multiple rows from database
	}
	
	
	private static class LoginRowSelectRowMapper implements RowMapper<LoginDto> {

		@Override
		public LoginDto mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {
			        String userId = resultSet.getString("userId");
					String userRole = resultSet.getString("userRole");
					String userStatus = resultSet.getString("userStatus");
					return new LoginDto(userId, userRole, userStatus);
		}
	
	
}
}
