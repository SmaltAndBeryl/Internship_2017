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
import com.skill.India.dto.FAQCandidatesEnrolledAssessedCertifiedMonthWiseDto;

/**
 * @author Aashish sharma
 *
 */
@Repository
public class FAQCandidatesEnrolledAssessedCertifiedMonthWiseDao extends AbstractTransactionalDao {

	@Autowired
	private FAQConfigSql fAQConfigSql;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FAQCandidatesEnrolledAssessedCertifiedMonthWiseDao.class);
	
	private static final FAQCandidatesEnrolledAssessedCertifiedMonthWiseRowMapper ROW_MAPPER = new FAQCandidatesEnrolledAssessedCertifiedMonthWiseRowMapper(); 
	
	public Collection<FAQCandidatesEnrolledAssessedCertifiedMonthWiseDto> getCountTotalCandidatesEnrolledMonthWise(int year){
		LOGGER.info("Request Received from Service");
		LOGGER.info("In FAQCandidatesEnrolledAssessedCertifiedMonthWiseDao - getCountTotalCandidatesEnrolledMonthWise");
		LOGGER.info("Parameters Received from Service are - 'year': " +year);
				   	
		LOGGER.info("getting total candidates enrolled month wise");
		
		try
		{
			LOGGER.info("Inside TRY block");
			
			LOGGER.info("Creating HashMap object");
			Map<String, Object> parameters = new HashMap<>();
			LOGGER.info("object created successfully");
			
			LOGGER.info("Inserting parameters to HashMap object");
			parameters.put("year", year);
			LOGGER.info("Parameters inserted");
			
			LOGGER.info("Executing SQL query and returning response");
	        return getJdbcTemplate().query(fAQConfigSql.getSelectSqlCountTotalCandidatesEnrolledMonthWise(), parameters, ROW_MAPPER);
		}
		catch(Exception ex)
		{
			LOGGER.info("Inside CATCH block");
			
			LOGGER.error("ERROR: Encountered Exception - "+ex);
			
			LOGGER.info("Returning NULL");
			return null;
		}
	}
	
	public Collection<FAQCandidatesEnrolledAssessedCertifiedMonthWiseDto> getCountTotalCandidatesCertifiedMonthWise(int year){
		LOGGER.info("Request Received from Service");
		LOGGER.info("In FAQCandidatesEnrolledAssessedCertifiedMonthWiseDao - getCountTotalCandidatesCertifiedMonthWise");
		LOGGER.info("Parameters Received from Service are - 'year': " +year);
				   	
		LOGGER.info("getting total candidates certified month wise");
		
		try
		{
			LOGGER.info("Inside TRY block");
			
			LOGGER.info("Creating HashMap object");
			Map<String, Object> parameters = new HashMap<>();
			LOGGER.info("object created successfully");
			
			LOGGER.info("Inserting parameters to HashMap object");
			parameters.put("year", year);
			LOGGER.info("Parameters inserted");
			
			LOGGER.info("Executing SQL query and returning response");
	        return getJdbcTemplate().query(fAQConfigSql.getSelectSqlCountTotalCandidatesCertifiedMonthWise(), parameters, ROW_MAPPER);
		}
		catch(Exception ex)
		{
			LOGGER.info("Inside CATCH block");
			
			LOGGER.error("ERROR: Encountered Exception - "+ex);
			
			LOGGER.info("Returning NULL");
			return null;
		}
		
	}
	
	public Collection<FAQCandidatesEnrolledAssessedCertifiedMonthWiseDto> getCountTotalCandidatesAssessedMonthWise(int year){
		LOGGER.info("Request Received from Service");
		LOGGER.info("In FAQCandidatesEnrolledAssessedCertifiedMonthWiseDao - getCountTotalCandidatesAssessedMonthWise");
		LOGGER.info("Parameters Received from Service are - 'year': " +year);
				   	
		LOGGER.info("getting total candidates assessed month wise");
		
		try
		{
			LOGGER.info("Inside TRY block");
			
			LOGGER.info("Creating HashMap object");
			Map<String, Object> parameters = new HashMap<>();
			LOGGER.info("object created successfully");
			
			LOGGER.info("Inserting parameters to HashMap object");
			parameters.put("year", year);
			LOGGER.info("Parameters inserted");
			
			LOGGER.info("Executing SQL query and returning response");
	        return getJdbcTemplate().query(fAQConfigSql.getSelectSqlCountTotalCandidatesAssessedMonthWise(), parameters, ROW_MAPPER);
		}
		catch(Exception e)
		{
			LOGGER.info("Inside CATCH block");
			
			LOGGER.error("ERROR: Encountered Exception - "+e);
			
			LOGGER.info("Returning NULL");
			return null;
			
		}
		
	}
	
	public Collection<FAQCandidatesEnrolledAssessedCertifiedMonthWiseDto> getCountTotalCandidatesEnrolledMonthAndSchemeWise(int year,String batchType) {
		LOGGER.info("Request Received from Service");
		LOGGER.info("In FAQCandidatesEnrolledAssessedCertifiedMonthWiseDao - getCountTotalCandidatesEnrolledMonthAndSchemeWise");
		LOGGER.info("Parameters Received from Service are - 'year': " +year+" 'batchType': "+batchType);
				   	
		LOGGER.info("getting total candidates enrolled month wise and scheme wise");
		
		try
		{
			LOGGER.info("Inside TRY block");
			
			LOGGER.info("Creating HashMap object");
			Map<String, Object> parameters = new HashMap<>();
			LOGGER.info("object created successfully");
			
			LOGGER.info("Inserting parameters to HashMap object");
			parameters.put("year", year);
			parameters.put("batchType", batchType);
			LOGGER.info("Parameters inserted");
			
			LOGGER.info("Executing SQL query and returning response");
	        return getJdbcTemplate().query(fAQConfigSql.getSelectSqlCountTotalCandidatesEnrolledMonthAndSchemeWise(), parameters, ROW_MAPPER);
		}
		catch(Exception ex)
		{
			LOGGER.info("Inside CATCH block");
			
			LOGGER.error("ERROR: Encountered Exception - "+ex);
			
			LOGGER.info("Returning NULL");
			return null;
		}
	}
	
	public Collection<FAQCandidatesEnrolledAssessedCertifiedMonthWiseDto> getCountTotalCandidatesAssessedMonthAndSchemeWise(int year,String batchType) {
		LOGGER.info("Request Received from Service");
		LOGGER.info("In FAQCandidatesEnrolledAssessedCertifiedMonthWiseDao - getCountTotalCandidatesAssessedMonthAndSchemeWise");
		LOGGER.info("Parameters Received from Service are - 'year': " +year+" 'batchType': "+batchType);
				   	
		LOGGER.info("getting total candidates assessed month wise and scheme wise");
		
		try
		{
			LOGGER.info("Inside TRY block");
			
			LOGGER.info("Creating HashMap object");
			Map<String, Object> parameters = new HashMap<>();
			LOGGER.info("object created successfully");
			
			LOGGER.info("Inserting parameters to HashMap object");
			parameters.put("year", year);
			parameters.put("batchType", batchType);
			LOGGER.info("Parameters inserted");
			
			LOGGER.info("Executing SQL query and returning response");
	        return getJdbcTemplate().query(fAQConfigSql.getSelectSqlCountTotalCandidatesAssessedMonthAndSchemeWise(), parameters, ROW_MAPPER);
		}
		catch(Exception ex)
		{
			LOGGER.info("Inside CATCH block");
			
			LOGGER.error("ERROR: Encountered Exception - "+ex);
			
			LOGGER.info("Returning NULL");
			return null;
		}
	}
	
	public Collection<FAQCandidatesEnrolledAssessedCertifiedMonthWiseDto> getCountTotalCandidatesCertifiedMonthAndSchemeWise(int year,String batchType) {
		LOGGER.info("Request Received from Service");
		LOGGER.info("In FAQCandidatesEnrolledAssessedCertifiedMonthWiseDao - getCountTotalCandidatesCertifiedMonthAndSchemeWise");
		LOGGER.info("Parameters Received from Service are - 'year': " +year+" 'batchType': "+batchType);
				   	
		LOGGER.info("getting total candidates certified month wise and scheme wise");
		
		try
		{
			LOGGER.info("Inside TRY block");
			
			LOGGER.info("Creating HashMap object");
			Map<String, Object> parameters = new HashMap<>();
			LOGGER.info("object created successfully");
			
			LOGGER.info("Inserting parameters to HashMap object");
			parameters.put("year", year);
			parameters.put("batchType", batchType);
			LOGGER.info("Parameters inserted");
			
			LOGGER.info("Executing SQL query and returning response");
	        return getJdbcTemplate().query(fAQConfigSql.getSelectSqlCountTotalCandidatesCertifiedMonthAndSchemeWise(), parameters, ROW_MAPPER);
		}
		catch(Exception ex)
		{
			LOGGER.info("Inside CATCH block");
			
			LOGGER.error("ERROR: Encountered Exception - "+ex);
			
			LOGGER.info("Returning NULL");
			return null;
		}
	}
	
	private static class FAQCandidatesEnrolledAssessedCertifiedMonthWiseRowMapper implements RowMapper<FAQCandidatesEnrolledAssessedCertifiedMonthWiseDto> {

		@Override
		public FAQCandidatesEnrolledAssessedCertifiedMonthWiseDto mapRow(
				ResultSet rs, int rowNum) throws SQLException {
			
			String month = rs.getString("MONTHS");
			Integer numberOfCandidates = rs.getInt("CANDIDATES");
			
			return new FAQCandidatesEnrolledAssessedCertifiedMonthWiseDto(month, numberOfCandidates);
		}
	}
}
