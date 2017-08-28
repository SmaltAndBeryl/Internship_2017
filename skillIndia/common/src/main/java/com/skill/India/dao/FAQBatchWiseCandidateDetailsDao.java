/**
 * 
 */
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
import com.skill.India.dto.FAQBatchWiseCandidateDetailsDto;

/**
 * @author Aashish sharma
 *
 */
@Repository
public class FAQBatchWiseCandidateDetailsDao extends AbstractTransactionalDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FAQBatchWiseCandidateDetailsDao.class);
	
	@Autowired
	private FAQConfigSql fAQConfigSql;
	
	private static BatchWiseCandidateDetailsDaoRowMapper ROW_MAPPER = new BatchWiseCandidateDetailsDaoRowMapper(); 
	
	public Collection<FAQBatchWiseCandidateDetailsDto> getBatchWiseCandidatesDetails(Integer batchId) {
		LOGGER.info("Request Received from Service");
		LOGGER.info("In FAQBatchWiseCandidateDetailsDao - getBatchWiseCandidatesDetails");
		LOGGER.info("Parameters Received from Service are - 'batchId': " +batchId);
				   	
		LOGGER.info("getting candidate details of a particular batch");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Inserting parameters to HashMap object");
		parameters.put("batchId", batchId);
		LOGGER.info("Parameters inserted");
		
		LOGGER.info("Executing SQL query and returning response");
		return getJdbcTemplate().query(fAQConfigSql.getSelectSqlBatchWiseCandidatesDetails(), parameters,ROW_MAPPER);
	}

	private static class BatchWiseCandidateDetailsDaoRowMapper implements RowMapper<FAQBatchWiseCandidateDetailsDto> {

		@Override
		public FAQBatchWiseCandidateDetailsDto mapRow(ResultSet rs, int rowNum)
				throws SQLException {

			String candidateName = rs.getString("candidateName");
			String mobileNumber =rs.getString("mobileNumber");
			String eMailId = rs.getString("emailId");
			String traineeAddress = rs.getString("traineeAddress");
			String trainingPartnerName = rs.getString("trainingPartnerName");
			Integer batchId = rs.getInt("batchId");
			String batchStartDate = rs.getString("batchStartDate");
			String batchEndDate = rs.getString("batchEndDate");

			return new FAQBatchWiseCandidateDetailsDto(candidateName, mobileNumber, eMailId, traineeAddress, trainingPartnerName, batchId, batchStartDate, batchEndDate);
		}
		
		
	}
}
