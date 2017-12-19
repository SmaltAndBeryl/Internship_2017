package com.skill.India.dao;

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

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.DashboardConfigSql;
import com.skill.India.dto.DashboardTopStatesWithMaxTrainingCentersDto;


@Repository
public class DashboardTopStatesWithMaxTrainingCentersDao extends AbstractTransactionalDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DashboardTotalBatchesAccordingToJobRoleDao.class);
	
	@Autowired
	public DashboardConfigSql config;

	private static final DashboardRowSelectRowMapper ROW_MAPPER = new DashboardRowSelectRowMapper();

	public Collection<DashboardTopStatesWithMaxTrainingCentersDto> getTopStatesWithMaxTrainingCenters() {
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DashboardTopStatesWithMaxTrainingCentersDao - getTopStatesWithMaxTrainingCenters");
				   	
		LOGGER.debug("Getting Top states on bases of training centers");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Executing SQL query and returning response");
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
