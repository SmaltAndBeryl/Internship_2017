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
import com.skill.India.config.AssessmentBodyHomepageConfigSql;
import com.skill.India.dto.AssessmentBodyHomepageDto;


@Repository
public class AssessmentBodyHomepageDao extends AbstractTransactionalDao {
	
	@Autowired
	public AssessmentBodyHomepageConfigSql assessmentBodyHomepageConfigSql;

	private static final AssessmentBodyHomepageSelectRowMapper ROW_MAPPER = new AssessmentBodyHomepageSelectRowMapper();
	
	public Collection<AssessmentBodyHomepageDto> getpastBatchesAssessmentBodyHomepageRowMapper() {
		Map<String,Object> parameters = new HashMap<>();
		return getJdbcTemplate().query(assessmentBodyHomepageConfigSql.getSelectSqlpastBatchesAssessmentBodyHomepage(),parameters,
				ROW_MAPPER);
	}	
	public Collection<AssessmentBodyHomepageDto> getupcomingBatchesAssessmentBodyHomepageRowMapper() {
		Map<String,Object> parameters = new HashMap<>();
		return getJdbcTemplate().query(assessmentBodyHomepageConfigSql.getSelectSqlupcomingBatchesAssessmentBodyHomepage(),parameters,
				ROW_MAPPER);
	}	
	public Collection<AssessmentBodyHomepageDto> getassignedBatchesAssessmentBodyHomepageRowMapper() {
		Map<String,Object> parameters = new HashMap<>();
		return getJdbcTemplate().query(assessmentBodyHomepageConfigSql.getSelectSqlassignedBatchesAssessmentBodyHomepage(),parameters,
				ROW_MAPPER);
	}	
	public Collection<AssessmentBodyHomepageDto> getconfirmedBatchesAssessmentBodyHomepageRowMapper() {
		Map<String,Object> parameters = new HashMap<>();
		return getJdbcTemplate().query(assessmentBodyHomepageConfigSql.getSelectSqlconfirmedBatchesAssessmentBodyHomepage(),parameters,
				ROW_MAPPER);
	}
	
	
	private static class AssessmentBodyHomepageSelectRowMapper implements RowMapper<AssessmentBodyHomepageDto> {
		
		@Override
		public AssessmentBodyHomepageDto mapRow(ResultSet rs, int rowNum)
		throws SQLException {
		Integer batchId = rs.getInt("batchId");
		String trainingPartnerDetails = rs.getString("trainingPartnerDetails");
		String assessmentDate = rs.getString("assessmentdate");
		String location = rs.getString("location");
		Integer totalCandidatesInBatch = rs.getInt("totalCandidatesInBatch");
		
		return new AssessmentBodyHomepageDto(batchId, trainingPartnerDetails, assessmentDate, location, totalCandidatesInBatch);
		}
	}
}
