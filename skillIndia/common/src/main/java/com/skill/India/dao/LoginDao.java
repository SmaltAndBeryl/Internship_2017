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
	
	public Collection<LoginDto> getLoginRowMapper(String userName, String passWord) {
		LOGGER.info("Code Reached");
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("userName", userName);
		parameters.put("passWord", passWord);
	
		return getJdbcTemplate().query(loginconfig.getSelectSql(), parameters,
				ROW_MAPPER); //query for multiple rows from database
	}
	
	
	private static class LoginRowSelectRowMapper implements RowMapper<LoginDto> {

		@Override
		public LoginDto mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {
			int applicationId = resultSet.getInt("applicationId");
//			String password = resultSet.getString("password");
			String user_role = resultSet.getString("user_role");
			String user_status = resultSet.getString("user_status");

			return new LoginDto(applicationId, user_role, user_status);
		}


	}
}
