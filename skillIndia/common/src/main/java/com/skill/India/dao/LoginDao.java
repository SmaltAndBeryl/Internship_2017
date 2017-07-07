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

import com.skill.India.common.AbstractDatasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class LoginDao extends AbstractTransactionalDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractDatasource.class);

	@Autowired
	public LoginConfig loginconfig;
	
	private static final LoginRowSelectRowMapper ROW_MAPPER = new LoginRowSelectRowMapper();
	
	
	public Integer userExistence(String userId, String password){
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("userId", userId);
		parameters.put("passWord", password);
		return getJdbcTemplate().queryForObject(loginconfig.getCheckUserSql(), parameters, Integer.class);
		
	}
	
	public LoginDto getLoginRowMapper(String userName, String password) {
		LOGGER.info("Code Reached");
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("userName", userName);
		parameters.put("password", password);
	
		return getJdbcTemplate().queryForObject(loginconfig.getSelectSql(), parameters, ROW_MAPPER); //query for multiple rows from database
	}
	
	
	private static class LoginRowSelectRowMapper implements RowMapper<LoginDto> {

		@Override
		public LoginDto mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {
					int applicationId = resultSet.getInt("applicationId");
					String userRole = resultSet.getString("userRole");
					String userStatus = resultSet.getString("userStatus");
					return new LoginDto(applicationId, userRole, userStatus);
			
			
			
		}
	
	
}
}
