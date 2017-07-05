package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.skill.India.common.AbstractDatasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.skill.India.config.SignUpConfigSql;

import com.skill.India.dto.SignUpInsertedUserDto;

@Repository
public class SignUpDao extends AbstractTransactionalDao {
	@Autowired
	private SignUpConfigSql signUpConfigSql;
	
	
	private static final SignUpRowSelectRowMapper ROW_MAPPER = new SignUpRowSelectRowMapper();
	
	public Integer checkUserExistence(String userId, String organizationName){
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("userId", userId);
		parameters.put("organizationName", organizationName);
		return getJdbcTemplate().queryForObject(signUpConfigSql.getCheckSql(), parameters, Integer.class);
		
	}
	
	
	
	public int insertSignUpData(String organizationName, String spocName, String userId, String password, String userRole) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("organizationName",organizationName);
		parameters.put("spocName", spocName);
		parameters.put("userId", userId);
		parameters.put("password", password );
		parameters.put("userRole", userRole);
		return insert(signUpConfigSql.getInsertSql(), parameters, "id");
	}
	
	
	public SignUpInsertedUserDto getUserData(int id){
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("id",id);
		return getJdbcTemplate().queryForObject(signUpConfigSql.getGetSql(), parameters, ROW_MAPPER);
	}

	
	private static class SignUpRowSelectRowMapper implements RowMapper<SignUpInsertedUserDto> {
		
		@Override
		public SignUpInsertedUserDto mapRow(ResultSet resultSet, int rowNum)throws SQLException 
		{			String userId = resultSet.getString("userId");
					String organizationName = resultSet.getString("organizationName");
					String spocName = resultSet.getString("spocName");
					return new SignUpInsertedUserDto(userId,organizationName,spocName);
					
		}
	
	
	}
}
