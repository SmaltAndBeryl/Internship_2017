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

import com.skill.India.common.AbstractDatasource;
import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.FAQConfigSql;
import com.skill.India.dto.FAQCandidatesTrainedAssessedCertifiedDto;

@Repository
public class FAQCandidatesTrainedAssessedCertifiedDao extends AbstractTransactionalDao{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractDatasource.class);
	
	
	@Autowired
	private FAQConfigSql fAQConfigSql;
	
	private static final FAQRowMapper fAQRowMapper = new FAQRowMapper();
	
		public Collection<FAQCandidatesTrainedAssessedCertifiedDto> getTotalCandidatesTrainedAssessedCertified() {
		Map<String, Object> parameters = new HashMap<> ();
		return getJdbcTemplate().query(fAQConfigSql.getSelectSqlTotalCandidatesTrainedAssessedCertified(), parameters, fAQRowMapper);
	}
	
	public Collection<FAQCandidatesTrainedAssessedCertifiedDto> getTotalCandidatesTrainedAssessedCertifiedSchemeWise(String batchType) {
		Map<String, Object> parameter = new HashMap<>();
		parameter.put("batchType", batchType);
		return getJdbcTemplate().query(fAQConfigSql.getSelectSqlTotalCandidatesTrainedAssessedCertifiedSchemeWise(), parameter, fAQRowMapper);
	}
	
	
	private static class FAQRowMapper implements RowMapper<FAQCandidatesTrainedAssessedCertifiedDto> {

		@Override
		public FAQCandidatesTrainedAssessedCertifiedDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Integer totalNoOfCandidatesEnrolled = rs.getInt("candidatesEnrolled");
			Integer totalNoOfCandidatesAssessed = rs.getInt("candidatesAssessed");
			Integer totalNoOfCandidatesCertified = rs.getInt("candidatesCertified");
			
			return new FAQCandidatesTrainedAssessedCertifiedDto(totalNoOfCandidatesEnrolled, totalNoOfCandidatesAssessed, totalNoOfCandidatesCertified);
		}
		
		
	}
}
