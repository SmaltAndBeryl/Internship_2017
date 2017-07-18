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
		LOGGER.info("Check the user existence against parameter- userId and organization name");
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("userId", userId);
		parameters.put("organizationName", organizationName);
		return getJdbcTemplate().queryForObject(signUpConfigSql.getCheckSql(), parameters, Integer.class);
		
	}
	
	
	
	public int insertSignUpData(String organizationName, String sPOCName, String userId, String password, String userRole) {
		LOGGER.info("Insert the record of new user-organization name, spoc name, user id, password");
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("organizationName",organizationName);
		parameters.put("sPOCName", sPOCName);
		parameters.put("userId", userId);
		parameters.put("password", password );
		parameters.put("userRole", userRole);
		return insert(signUpConfigSql.getInsertSql(), parameters, "Id");
	}
	
	
	public Collection<SignUpInsertedUserDto> getUserData(int Id){
		LOGGER.info("Fetch the record of new user");
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("Id",Id);
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
