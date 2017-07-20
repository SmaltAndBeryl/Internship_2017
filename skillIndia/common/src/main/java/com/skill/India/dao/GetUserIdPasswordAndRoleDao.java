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
import com.skill.India.config.SessionManagementConfigSql;
import com.skill.India.dto.SessionManagementDto;

@Repository
public class GetUserIdPasswordAndRoleDao extends AbstractTransactionalDao {

	@Autowired
	private SessionManagementConfigSql sessionManagementConfigSql; 

	
	public Integer userExistence(String userId){
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("userId", userId);
		return getJdbcTemplate().queryForObject(sessionManagementConfigSql.getCheckUserSql(), parameters, Integer.class);
		
	}
	
	private static final SessionRowMapper sessionRowMapper = new SessionRowMapper();
	
	
	public  Collection<SessionManagementDto> getUserIdPasswordAndRole(String userId)
{
	Map<String,Object> parameters=new HashMap<String, Object>();
	parameters.put("userId",userId);
	return getJdbcTemplate().query(sessionManagementConfigSql.getGetUserIdPasswordRole(), parameters,sessionRowMapper);
}
	
	private static class SessionRowMapper implements RowMapper<SessionManagementDto> {

		@Override
		public SessionManagementDto mapRow(ResultSet rs, int rowNum) throws SQLException {			
			String userId=rs.getString("userId");
			String password=rs.getString("password");
			String userRole=rs.getString("userRole");
			return new SessionManagementDto(userId, password, userRole);
		}
		
		
	}
	
	
	
}
