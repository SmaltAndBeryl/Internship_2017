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
import com.skill.India.config.FAQConfigSql;
import com.skill.India.dto.FAQCandidatesTrainedAssessedCertifiedDto;

@Repository
public class FAQCandidatesTrainedAssessedCertifiedDao extends AbstractTransactionalDao{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FAQCandidatesTrainedAssessedCertifiedDao.class);
	
	@Autowired
	private FAQConfigSql fAQConfigSql;
	
	private static final FAQRowMapper fAQRowMapper = new FAQRowMapper();
	
		public Collection<FAQCandidatesTrainedAssessedCertifiedDto> getTotalCandidatesTrainedAssessedCertified() {
			LOGGER.info("Request Received from Service");
			LOGGER.info("In FAQCandidatesTrainedAssessedCertifiedDao - getTotalCandidatesTrainedAssessedCertified");
					   	
			LOGGER.info("getting total candidates trained,assessed,certified");
			
			LOGGER.info("Creating HashMap object");
			Map<String, Object> parameters = new HashMap<> ();
			LOGGER.info("object created successfully");
			
			LOGGER.info("Executing SQL query and returning response");
			return getJdbcTemplate().query(fAQConfigSql.getSelectSqlCountTotalCandidatesTrainedAssessedCertified(), parameters, fAQRowMapper);
	}
	
	public Collection<FAQCandidatesTrainedAssessedCertifiedDto> getTotalCandidatesTrainedAssessedCertifiedSchemeWise(String batchType) {
		LOGGER.info("Request Received from Service");
		LOGGER.info("In FAQCandidatesTrainedAssessedCertifiedDao - getTotalCandidatesTrainedAssessedCertifiedSchemeWise");
		LOGGER.info("Parameters Received from Service are - 'batchType': " +batchType);
				   	
		LOGGER.info("getting total candidates trained,assessed,certified scheme wise");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameter = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Inserting parameters to HashMap object");
		parameter.put("batchType", batchType);
		LOGGER.info("Parameters inserted");
		
		LOGGER.info("Executing SQL query and returning response");
		return getJdbcTemplate().query(fAQConfigSql.getSelectSqlTotalCandidatesTrainedAssessedCertifiedSchemeWise(), parameter, fAQRowMapper);
	}
	
	
	private static class FAQRowMapper implements RowMapper<FAQCandidatesTrainedAssessedCertifiedDto> {

		@Override
		public FAQCandidatesTrainedAssessedCertifiedDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Integer totalNoOfCandidatesEnrolled = rs.getInt("candidatesEnrolled");
			Integer totalNoOfCandidatesAssessed = rs.getInt("candidatesAssessed");
			Integer totalNoOfCandidatesCertified = rs.getInt("candidatesCertified");
			
			if(totalNoOfCandidatesAssessed==null)
				totalNoOfCandidatesAssessed=0;
			if(totalNoOfCandidatesCertified==null)
				totalNoOfCandidatesCertified=0;
			if(totalNoOfCandidatesEnrolled==null)
				totalNoOfCandidatesEnrolled=0;
			
			return new FAQCandidatesTrainedAssessedCertifiedDto(totalNoOfCandidatesEnrolled, totalNoOfCandidatesAssessed, totalNoOfCandidatesCertified);
		}
		
		
	}
}
