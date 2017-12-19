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
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In FAQTotalNumberOfBatchesAndTotalEnrolledInAParticularStateDao - getCountOfTotalNumberOfBatchesAndTotalEnrolledInAParticularState");
		LOGGER.debug("Parameters Received from Service are - 'state': " +state);
				   	
		LOGGER.debug("getting Total Number of Batches and Total Enrolled in a State");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Inserting parameters to HashMap object");
		parameters.put("state", state);
		LOGGER.debug("Parameters inserted");
		
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().query(fAQConfigSql.getSelectSqlCountTotalNumberOfBatchesAndTotalEnrolledInAParticularState(), parameters, ROW_MAPPER);
	}
	
	public Collection<FAQTotalNumberOfBatchesAndTotalEnrolledInAParticularStateDto> getCountOfTotalNumberOfBatchesAndTotalEnrolledInAParticularStateSchemeWise(String batchType) {
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In FAQTotalNumberOfBatchesAndTotalEnrolledInAParticularStateDao - getCountOfTotalNumberOfBatchesAndTotalEnrolledInAParticularStateSchemeWise");
		LOGGER.debug("Parameters Received from Service are - 'batchType': " +batchType);
	   	
		LOGGER.debug("getting Total Number of Batches and Total Enrolled according to batch type");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Inserting parameters to HashMap object");
		parameters.put("batchType", batchType);
		LOGGER.debug("Parameters inserted");
		
		LOGGER.debug("Executing SQL query and returning response");
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
