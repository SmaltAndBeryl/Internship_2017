package com.skill.India.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.AssessmentBodyHomepageConfigSql;
import com.skill.India.dto.AssessmentBodyHomepageDto;


@Repository
public class AssessmentBodyHomepageDao extends AbstractTransactionalDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AssessmentBodyHomepageDao.class);
	
	@Autowired
	public AssessmentBodyHomepageConfigSql assessmentBodyHomepageConfigSql;

	private static final AssessmentBodyHomepageSelectRowMapper ROW_MAPPER = new AssessmentBodyHomepageSelectRowMapper();
	private static final AssessmentBodyHomepageAgencyRowMapper ROW_MAPPER_AGENCY_ID = new AssessmentBodyHomepageAgencyRowMapper();
	
	/**
	 * 
	 * @param applicationId
	 * @return
	 */
	public Collection<AssessmentBodyHomepageDto> getpastBatchesAssessmentBodyHomepageRowMapper(int applicationId) {
		Integer agencyId = getAgencyId(applicationId);
		try
		{
			LOGGER.debug("Trying to get details of past batches for agency");
			
			Map<String,Object> parameters = new HashMap<>();

			parameters.put("agencyId",agencyId);
			
			LOGGER.debug("Trying to execute SQL query and returning response");
	        return getJdbcTemplate().query(assessmentBodyHomepageConfigSql.getSelectSqlpastBatchesAssessmentBodyHomepage(),parameters,
					ROW_MAPPER);
		}
		catch(EmptyResultDataAccessException e)
		{
			LOGGER.debug("No past batches found");
			return null;
		}
		catch(Exception e)
		{
			LOGGER.error("An exception occured while finding past batches " + e);
			return null;
		}
		
	}	
	
	/**
	 * 
	 * @param applicationId
	 * @return
	 */
	public Collection<AssessmentBodyHomepageDto> getupcomingBatchesAssessmentBodyHomepageRowMapper(int applicationId) {
		try
		{
			LOGGER.debug("trying to get data of upcoming batches");
			Map<String,Object> parameters = new HashMap<>();
			
			parameters.put("agencyId" ,getAgencyId(applicationId));		
			LOGGER.debug("Executing SQL to fetch past batches of assessment body and trying to returning response");
			
	        return getJdbcTemplate().query(assessmentBodyHomepageConfigSql.getSelectSqlupcomingBatchesAssessmentBodyHomepage(),parameters,
					ROW_MAPPER);
		}
		catch(EmptyResultDataAccessException e)
		{
			LOGGER.debug("No upcoming batches found to show");
			return null;
		}
		catch(Exception e)
		{
			LOGGER.error("An exception occured while finding upcoming batches");
			return null;
		}
				
		
		
	}
	
	/**
	 * Method to get Assessmentbody Id given Application id
	 * @param applicationId
	 * @return assessmentbody id
	 */
	private int getAgencyId(int applicationId)
	{
		try
		{
			int agencyId=0;
			LOGGER.debug("trying to get agency Id for application Id"+ applicationId);
			Map<String,Object> parameters = new HashMap<>();
			parameters.put("applicationId", applicationId);
			agencyId = getJdbcTemplate().queryForObject(assessmentBodyHomepageConfigSql.getGetAgencyId(), parameters,ROW_MAPPER_AGENCY_ID);
			LOGGER.debug("Agency Id for applicationId :"+applicationId+"is :"+agencyId);
			return agencyId;
		}
		catch(EmptyResultDataAccessException e)
		{
			LOGGER.debug("Could not find any agency Id");
			return -1;
		}
		catch(Exception e)
		{
			LOGGER.error("An exception occured while finding agency Id");
			return -2;
		}
		
	}
	
	
	/**
	 * Method to get batches where assessmnet body has shown interest
	 * @param applicationId
	 * @return details of batches 
	 */
	public Collection<AssessmentBodyHomepageDto> getshownInterestAssessmentBodyHomepageRowMapper(int applicationId) {
		try
		{
			Integer agencyId= getAgencyId(applicationId);
		   	
			LOGGER.debug("Trying to get details of shown interest batches by agency");
			
			Map<String,Object> parameters = new HashMap<>();
			
			parameters.put("agencyId",agencyId);
			LOGGER.debug("Parameters inserted");
			
			LOGGER.debug("Trying to execute SQL query and returning response");
	        return getJdbcTemplate().query(assessmentBodyHomepageConfigSql.getSelectSqlShownInterestBatchesAssessmentBodyHomepage(),parameters,
					ROW_MAPPER);
		}
		catch(EmptyResultDataAccessException e)
		{
			LOGGER.debug("No shown interest batches found");
			return null;
		}
		catch(Exception e)
		{
			LOGGER.debug("An exception occured while finding bathces in which interest has been showed by this assessment body");
			return null;
		}	
		
		
	}
	
	/**
	 * Method to find assigned batches of assessment body
	 * @param applicationId
	 * @return collection of all the assigned batches of assessment body
	 */
	public Collection<AssessmentBodyHomepageDto> getassignedBatchesAssessmentBodyHomepageRowMapper(int applicationId) {
		try
		{
			Integer agencyId = getAgencyId(applicationId);
					   	
			LOGGER.debug("Trying to get details of assigned batches to agency");
			
			Map<String,Object> parameters = new HashMap<>();

			parameters.put("agencyId",agencyId);
			
			LOGGER.debug("Trying to execute SQL query and returning response");
	        return getJdbcTemplate().query(assessmentBodyHomepageConfigSql.getSelectSqlassignedBatchesAssessmentBodyHomepage(),parameters,
					ROW_MAPPER);
		}
		catch(EmptyResultDataAccessException e)
		{
			LOGGER.debug("No assigned bathces found for this assessment body");
			return null;
		}
		catch(Exception e)
		{
			LOGGER.error("An exception occured while finding assigned batches");
			return null;
			
		}

	}	
	
	/**
	 * Method to find confirmed bathces of assessment body
	 * @param applicationId
	 * @return Collection of confirmed batches by assessment body
	 */
	public Collection<AssessmentBodyHomepageDto> getconfirmedBatchesAssessmentBodyHomepageRowMapper(int applicationId) {
		try
		{
			Integer agencyId = getAgencyId(applicationId);
				   	
			LOGGER.debug("Trying to get details of confirmed batches to agency");
			
			Map<String,Object> parameters = new HashMap<>();

			parameters.put("agencyId",agencyId);

			LOGGER.debug("Trying to execute SQL query and returning response");
	        return getJdbcTemplate().query(assessmentBodyHomepageConfigSql.getSelectSqlconfirmedBatchesAssessmentBodyHomepage(),parameters,
					ROW_MAPPER);
		}
		catch(EmptyResultDataAccessException e)
		{
			LOGGER.debug("Could not find batches confirmed by this assessment body");
			return null;
			
		}
		catch(Exception e)
		{
			LOGGER.error("An exception occured while finding batches confirmed by assessment body");
			return null;
		}

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
	
private static class AssessmentBodyHomepageAgencyRowMapper implements RowMapper<Integer> {
		
		@Override
		public Integer mapRow(ResultSet rs, int rowNum)
		throws SQLException {
		Integer agencyId = rs.getInt("agencyId");
		return agencyId;
		//return new AssessmentBodyHomepageDto(batchId, trainingPartnerDetails, assessmentDate, location, totalCandidatesInBatch);
		}
	}
}
