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
import com.skill.India.dto.DashboardTotalCandidatesCertifiedWithModeInLastThreeYearsDto;

@Repository
public class DashboardTotalCandidatesCertifiedWithModeInLastThreeYearsDao extends AbstractTransactionalDao{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DashboardTotalCandidatesCertifiedWithModeInLastThreeYearsDao.class);
	
	@Autowired
	public DashboardConfigSql config;

	private static final DashboardRowSelectRowMapper ROW_MAPPER = new DashboardRowSelectRowMapper();

	public Collection<DashboardTotalCandidatesCertifiedWithModeInLastThreeYearsDto> getTotalCandidatesCertifiedWithModeInLastThreeYears() {
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DashboardTotalCandidatesCertifiedWithModeInLastThreeYearsDao - getTotalCandidatesCertifiedWithModeInLastThreeYears");
				   	
		LOGGER.debug("getting total candidates certified with mode in last three years");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().query(config.getSelectSqlTotalCandidatesTrainedWithModeInLastThreeYears(), parameters,
				ROW_MAPPER);
	}

 
	
	private static class DashboardRowSelectRowMapper implements RowMapper<DashboardTotalCandidatesCertifiedWithModeInLastThreeYearsDto> {

		@Override
		public DashboardTotalCandidatesCertifiedWithModeInLastThreeYearsDto mapRow(ResultSet resultSet, int rowNum)throws SQLException {
			Integer year = resultSet.getInt("YEARS");
			Integer totalCertified = resultSet.getInt("totalCertified");
			String mode = resultSet.getString("modes");
			
			return new DashboardTotalCandidatesCertifiedWithModeInLastThreeYearsDto(year, totalCertified, mode);
			}

	}



}
