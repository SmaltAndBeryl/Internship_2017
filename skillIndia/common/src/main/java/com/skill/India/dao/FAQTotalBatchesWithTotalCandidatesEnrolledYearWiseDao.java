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
import com.skill.India.dto.FAQTotalBatchesWithTotalCandidatesEnrolledMonthWiseDto;

/**
 * @author Aashish sharma
 *
 */
@Repository
public class FAQTotalBatchesWithTotalCandidatesEnrolledYearWiseDao extends AbstractTransactionalDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FAQTotalBatchesWithTotalCandidatesEnrolledYearWiseDao.class);
	
	@Autowired
	private FAQConfigSql fAQConfigSql;
	
	private static TotalBatchesWithTotalCandidatesEnrolledRowMapper ROW_MAPPER = new TotalBatchesWithTotalCandidatesEnrolledRowMapper();
	
	public Collection<FAQTotalBatchesWithTotalCandidatesEnrolledMonthWiseDto> getTotalBatchesWithTotalCandidatesEnrolledYearWise(int year) {
		LOGGER.info("Request Received from Service");
		LOGGER.info("In FAQTotalBatchesWithTotalCandidatesEnrolledYearWiseDao - getTotalBatchesWithTotalCandidatesEnrolledYearWise");
		LOGGER.info("Parameters Received from Service are - 'year': " +year);
				   	
		LOGGER.info("getting total batches with Total candidates enrolled in a year");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Inserting parameters to HashMap object");
		parameters.put("year", year);
		LOGGER.info("Parameters inserted");
		
		LOGGER.info("Executing SQL query and returning response");
		return getJdbcTemplate().query(fAQConfigSql.getSelectSqlTotalBatchesWithTotalCandidatesEnrolledYearWise(), parameters, ROW_MAPPER);	
	}
	
	private static class TotalBatchesWithTotalCandidatesEnrolledRowMapper implements RowMapper<FAQTotalBatchesWithTotalCandidatesEnrolledMonthWiseDto> {

		@Override
		public FAQTotalBatchesWithTotalCandidatesEnrolledMonthWiseDto mapRow(
				ResultSet rs, int rowNum) throws SQLException {
			
			String month = rs.getString("MONTH");
			Integer totalBatches = rs.getInt("TOTALBATCHES");
			Integer candidatesEnrolled = rs.getInt("CANDIDATESENROLLED");
			
			return new FAQTotalBatchesWithTotalCandidatesEnrolledMonthWiseDto(month, totalBatches, candidatesEnrolled);
		}
		
	}

}
