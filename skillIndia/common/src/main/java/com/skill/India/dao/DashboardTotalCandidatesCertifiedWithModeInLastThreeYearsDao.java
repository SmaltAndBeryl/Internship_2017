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
import com.skill.India.dto.DashboardTotalCandidatesCertifiedWithModeInLastThreeYearsDto;

@Repository
public class DashboardTotalCandidatesCertifiedWithModeInLastThreeYearsDao extends AbstractTransactionalDao{
	
	@Autowired
	public DashboardConfigSql config;

	private static final DashboardRowSelectRowMapper ROW_MAPPER = new DashboardRowSelectRowMapper();

	public Collection<DashboardTotalCandidatesCertifiedWithModeInLastThreeYearsDto> getTotalCandidatesCertifiedWithModeInLastThreeYears() {
		Map<String, Object> parameters = new HashMap<>();
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
