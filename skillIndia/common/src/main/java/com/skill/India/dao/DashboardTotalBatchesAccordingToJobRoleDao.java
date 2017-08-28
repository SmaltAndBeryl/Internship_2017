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
import com.skill.India.dto.DashboardTotalBatchesAccordingToJobRoleDto;

@Repository
public class DashboardTotalBatchesAccordingToJobRoleDao extends AbstractTransactionalDao{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DashboardTotalBatchesAccordingToJobRoleDao.class);
	
	@Autowired
	public DashboardConfigSql config;

	private static final DashboardRowSelectRowMapper ROW_MAPPER = new DashboardRowSelectRowMapper();

	public Collection<DashboardTotalBatchesAccordingToJobRoleDto> getTotalBatchesAccordingToJobRole() {
		LOGGER.info("Request Received from Service");
		LOGGER.info("In DashboardTotalBatchesAccordingToJobRoleDao - getTotalBatchesAccordingToJobRole");
				   	
		LOGGER.info("Getting total batches according to batch role");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Executing SQL query and returning response");
        return getJdbcTemplate().query(config.getSelectSqlTotalBatchesAccordingToJobRole(), parameters,ROW_MAPPER);
	}

		
	private static class DashboardRowSelectRowMapper implements RowMapper<DashboardTotalBatchesAccordingToJobRoleDto> {

		@Override
		public DashboardTotalBatchesAccordingToJobRoleDto mapRow(ResultSet resultSet, int rowNum)throws SQLException {
			Integer batches = resultSet.getInt("BATCHES");
			String jobRole = resultSet.getString("jobRole");
			String jobRoleCode = resultSet.getString("jobRoleCode");
			
			return new DashboardTotalBatchesAccordingToJobRoleDto(batches, jobRole, jobRoleCode);
		}

	}


}
