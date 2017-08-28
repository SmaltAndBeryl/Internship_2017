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
import com.skill.India.dto.FAQTotalNumberOfBatchesAndTotalEnrolledInAParticularStateDto;

/**
 * @author Aashish sharma
 *
 */
@Repository
public class FAQTotalNumberOfBatchesAndTotalEnrolledInAParticularStateDao extends AbstractTransactionalDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(FAQTotalNumberOfBatchesAndTotalEnrolledInAParticularStateDao.class);
	
	@Autowired
	private FAQConfigSql fAQConfigSql;
	
	private static final FAQTotalNumberOfBatchesAndTotalEnrolledRowMapper ROW_MAPPER = new FAQTotalNumberOfBatchesAndTotalEnrolledRowMapper();
	
	public Collection<FAQTotalNumberOfBatchesAndTotalEnrolledInAParticularStateDto> getCountOfTotalNumberOfBatchesAndTotalEnrolledInAParticularState(String state) {
		LOGGER.info("Request Received from Service");
		LOGGER.info("In FAQTotalNumberOfBatchesAndTotalEnrolledInAParticularStateDao - getCountOfTotalNumberOfBatchesAndTotalEnrolledInAParticularState");
		LOGGER.info("Parameters Received from Service are - 'state': " +state);
				   	
		LOGGER.info("getting Total Number of Batches and Total Enrolled in a State");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Inserting parameters to HashMap object");
		parameters.put("state", state);
		LOGGER.info("Parameters inserted");
		
		LOGGER.info("Executing SQL query and returning response");
        return getJdbcTemplate().query(fAQConfigSql.getSelectSqlCountTotalNumberOfBatchesAndTotalEnrolledInAParticularState(), parameters, ROW_MAPPER);
	}
	
	public Collection<FAQTotalNumberOfBatchesAndTotalEnrolledInAParticularStateDto> getCountOfTotalNumberOfBatchesAndTotalEnrolledInAParticularStateSchemeWise(String batchType) {
		LOGGER.info("Request Received from Service");
		LOGGER.info("In FAQTotalNumberOfBatchesAndTotalEnrolledInAParticularStateDao - getCountOfTotalNumberOfBatchesAndTotalEnrolledInAParticularStateSchemeWise");
		LOGGER.info("Parameters Received from Service are - 'batchType': " +batchType);
	   	
		LOGGER.info("getting Total Number of Batches and Total Enrolled according to batch type");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Inserting parameters to HashMap object");
		parameters.put("batchType", batchType);
		LOGGER.info("Parameters inserted");
		
		LOGGER.info("Executing SQL query and returning response");
        return getJdbcTemplate().query(fAQConfigSql.getSelectSqlCountTotalNumberOfBatchesAndTotalEnrolledInAParticularStateSchemeWise(), parameters, ROW_MAPPER);
	}
	
	private static class FAQTotalNumberOfBatchesAndTotalEnrolledRowMapper implements RowMapper<FAQTotalNumberOfBatchesAndTotalEnrolledInAParticularStateDto> {

		@Override
		public FAQTotalNumberOfBatchesAndTotalEnrolledInAParticularStateDto mapRow(
				ResultSet rs, int rowNum) throws SQLException {
			
			Integer batches = rs.getInt("BATCHES");
			Integer totalCandidates = rs.getInt("TOTALCANDIDATES");
			
			if(totalCandidates==null)
				totalCandidates=0;
			
			return new FAQTotalNumberOfBatchesAndTotalEnrolledInAParticularStateDto(batches, totalCandidates);
		}		
	}
}
