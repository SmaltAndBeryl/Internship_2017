package com.skill.India.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.LoginConfig;
import com.skill.India.dto.ApplicationDto;

@Repository
public class GetApplicationStateDao extends AbstractTransactionalDao {

	@Autowired
	private LoginConfig loginConfig;
	private static final ApplicationRowMapper ROW_MAPPER = new ApplicationRowMapper();

	public ApplicationDto getApplicationState(String userId) {
		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("userId", userId);

			return getJdbcTemplate().queryForObject(
					loginConfig.getGetApplicationState(), parameters,
					ROW_MAPPER);// query for multiple rows from database
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private static class ApplicationRowMapper implements
			RowMapper<ApplicationDto> {

		@Override
		public ApplicationDto mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {
			String applicationId = resultSet.getString("applicationId");
			String applicationState = resultSet.getString("applicationState");
					
			return new ApplicationDto(applicationState, applicationId);

		}

	}

}
