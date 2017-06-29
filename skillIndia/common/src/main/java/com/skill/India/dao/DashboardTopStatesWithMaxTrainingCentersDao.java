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
import com.skill.India.config.DashboardConfigSql;
import com.skill.India.dto.DashboardTopStatesWithMaxTrainingCentersDto;


@Repository
public class DashboardTopStatesWithMaxTrainingCentersDao extends AbstractTransactionalDao {
	
	@Autowired
	public DashboardConfigSql config;

	private static final DashboardRowSelectRowMapper ROW_MAPPER = new DashboardRowSelectRowMapper();

	public Collection<DashboardTopStatesWithMaxTrainingCentersDto> getTopStatesWithMaxTrainingCenters() {
		Map<String, Object> parameters = new HashMap<>();
		return getJdbcTemplate().query(config.getSelectSqlTopStatesWithMaxTrainingCenters(), parameters,
				ROW_MAPPER);
	}

		
	private static class DashboardRowSelectRowMapper implements RowMapper<DashboardTopStatesWithMaxTrainingCentersDto> {

		@Override
		public DashboardTopStatesWithMaxTrainingCentersDto mapRow(ResultSet resultSet, int rowNum)throws SQLException {
			String states = resultSet.getString("State");
			Integer trainingCenters = resultSet.getInt("TrainingCentres");
			
			return new DashboardTopStatesWithMaxTrainingCentersDto(states, trainingCenters);
			}

	}



}
