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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FAQCandidatesEnrolledAssessedCertifiedMonthWiseDto.class);
	
	private static final FAQCandidatesEnrolledAssessedCertifiedMonthWiseRowMapper ROW_MAPPER = new FAQCandidatesEnrolledAssessedCertifiedMonthWiseRowMapper(); 
	
	public Collection<FAQCandidatesEnrolledAssessedCertifiedMonthWiseDto> getCountTotalCandidatesEnrolledMonthWise(int year){
		try
		{
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("year", year);
			return getJdbcTemplate().query(fAQConfigSql.getSelectSqlCountTotalCandidatesEnrolledMonthWise(), parameters, ROW_MAPPER);
		}
		catch(Exception ex)
		{
			LOGGER.error("ERROR: While getting Data from DataBase.");
			LOGGER.error("Exception is:"+ex);
			return null;
		}
	}
	
	public Collection<FAQCandidatesEnrolledAssessedCertifiedMonthWiseDto> getCountTotalCandidatesCertifiedMonthWise(int year){
		try
		{
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("year", year);
			return getJdbcTemplate().query(fAQConfigSql.getSelectSqlCountTotalCandidatesCertifiedMonthWise(), parameters, ROW_MAPPER);
		}
		catch(Exception ex)
		{
			LOGGER.error("ERROR: While getting Data from DataBase.");
			LOGGER.error("Exception is:"+ex);
			return null;
		}
		
	}
	
	public Collection<FAQCandidatesEnrolledAssessedCertifiedMonthWiseDto> getCountTotalCandidatesAssessedMonthWise(int year){
		try
		{
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("year", year);
			return getJdbcTemplate().query(fAQConfigSql.getSelectSqlCountTotalCandidatesAssessedMonthWise(), parameters, ROW_MAPPER);
		}
		catch(Exception e)
		{
			LOGGER.error("ERROR: While getting Data from DataBase.");
			LOGGER.error("Exception is:"+e);
			return null;
			
		}
		
	}
	
	public Collection<FAQCandidatesEnrolledAssessedCertifiedMonthWiseDto> getCountTotalCandidatesEnrolledMonthAndSchemeWise(int year,String batchType) {
		try
		{
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("year", year);
			parameters.put("batchType", batchType);
			return getJdbcTemplate().query(fAQConfigSql.getSelectSqlCountTotalCandidatesEnrolledMonthAndSchemeWise(), parameters, ROW_MAPPER);
		}
		catch(Exception ex)
		{
			LOGGER.error("ERROR: While getting Data from DataBase.");
			LOGGER.error("Exception is:"+ex);
			return null;
		}
	}
	
	public Collection<FAQCandidatesEnrolledAssessedCertifiedMonthWiseDto> getCountTotalCandidatesAssessedMonthAndSchemeWise(int year,String batchType) {
		try
		{
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("year", year);
			parameters.put("batchType", batchType);
			return getJdbcTemplate().query(fAQConfigSql.getSelectSqlCountTotalCandidatesAssessedMonthAndSchemeWise(), parameters, ROW_MAPPER);
		}
		catch(Exception ex)
		{
			LOGGER.error("ERROR: While getting Data from DataBase.");
			LOGGER.error("Exception is:"+ex);
			return null;
		}
	}
	
	public Collection<FAQCandidatesEnrolledAssessedCertifiedMonthWiseDto> getCountTotalCandidatesCertifiedMonthAndSchemeWise(int year,String batchType) {
		try
		{
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("year", year);
			parameters.put("batchType", batchType);
			return getJdbcTemplate().query(fAQConfigSql.getSelectSqlCountTotalCandidatesCertifiedMonthAndSchemeWise(), parameters, ROW_MAPPER);
		}
		catch(Exception ex)
		{
			LOGGER.error("ERROR: While getting Data from DataBase.");
			LOGGER.error("Exception is:"+ex);
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
