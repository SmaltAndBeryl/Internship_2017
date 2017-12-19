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
import com.skill.India.config.AssessmentBodyHomepageConfigSql;
import com.skill.India.dto.AssessmentBodyHomepageDto;


@Repository
public class AssessmentBodyHomepageDao extends AbstractTransactionalDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AssessmentBodyHomepageDao.class);
	
	@Autowired
	public AssessmentBodyHomepageConfigSql assessmentBodyHomepageConfigSql;

	private static final AssessmentBodyHomepageSelectRowMapper ROW_MAPPER = new AssessmentBodyHomepageSelectRowMapper();
	private static final AssessmentBodyHomepageAgencyRowMapper ROW_MAPPER_AGENCY_ID = new AssessmentBodyHomepageAgencyRowMapper();
	
	public Collection<AssessmentBodyHomepageDto> getpastBatchesAssessmentBodyHomepageRowMapper(int applicationId) {
		Integer agencyId = getAgencyId(applicationId);
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In AssessmentBodyHomepageDao - getpastBatchesAssessmentBodyHomepageRowMapper");
		LOGGER.debug("Parameters Received from Service are - 'applicationId': " +applicationId);
		
		LOGGER.debug("Agency Id for application Id :"+ applicationId+"is :"+agencyId);
		LOGGER.debug("Getting details of past batches for agency");
		
		LOGGER.debug("Creating HashMap object");
		Map<String,Object> parameters = new HashMap<>();
		LOGGER.debug("Object created successfully");
		
		LOGGER.debug("Inserting parameters to HashMap object");
		parameters.put("agencyId",agencyId);
		LOGGER.debug("Parameters inserted");
		
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().query(assessmentBodyHomepageConfigSql.getSelectSqlpastBatchesAssessmentBodyHomepage(),parameters,
				ROW_MAPPER);
	}	
	
	public Collection<AssessmentBodyHomepageDto> getupcomingBatchesAssessmentBodyHomepageRowMapper(int applicationId) {
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In AssessmentBodyHomepageDao - getupcomingBatchesAssessmentBodyHomepageRowMapper");
		LOGGER.debug("Parameters Received from Service are - 'agencyId': " +applicationId);
				   	
		LOGGER.debug("Getting details of upcoming batches for agency");
		
		LOGGER.debug("Creating HashMap object");
		Map<String,Object> parameters = new HashMap<>();
		
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Inserting parameters to HashMap object");
		parameters.put("agencyId" ,getAgencyId(applicationId));
		LOGGER.debug("Parameters inserted are:"+parameters.toString());
		
		LOGGER.debug("Executing SQL query and returning response");
		LOGGER.debug("Query formed is:"+ assessmentBodyHomepageConfigSql.getSelectSqlupcomingBatchesAssessmentBodyHomepage().toString());
        return getJdbcTemplate().query(assessmentBodyHomepageConfigSql.getSelectSqlupcomingBatchesAssessmentBodyHomepage(),parameters,
				ROW_MAPPER);
	}
	private int getAgencyId(int applicationId)
	{
		int agencyId=0;
		LOGGER.debug("trying to get agency Id for application Id"+ applicationId);
		Map<String,Object> parameters = new HashMap<>();
		parameters.put("applicationId", applicationId);
		agencyId = getJdbcTemplate().queryForObject(assessmentBodyHomepageConfigSql.getGetAgencyId(), parameters,ROW_MAPPER_AGENCY_ID);
		LOGGER.debug("Agency Id for applicationId :"+applicationId+"is :"+agencyId);
		return agencyId;
	}
	public Collection<AssessmentBodyHomepageDto> getshownInterestAssessmentBodyHomepageRowMapper(int applicationId) {
		LOGGER.debug("Request Received from Service");
		Integer agencyId= getAgencyId(applicationId);
		LOGGER.debug("In AssessmentBodyHomepageDao - getshownInterestAssessmentBodyHomepageRowMapper");
		LOGGER.debug("Parameters Received from Service are - 'applicationId': " +applicationId);
				   	
		LOGGER.debug("Getting details of shown interest batches by agency");
		
		LOGGER.debug("Creating HashMap object");
		Map<String,Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Inserting parameters to HashMap object");
		parameters.put("agencyId",agencyId);
		LOGGER.debug("Parameters inserted");
		
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().query(assessmentBodyHomepageConfigSql.getSelectSqlShownInterestBatchesAssessmentBodyHomepage(),parameters,
				ROW_MAPPER);
	}
	public Collection<AssessmentBodyHomepageDto> getassignedBatchesAssessmentBodyHomepageRowMapper(int applicationId) {
		LOGGER.debug("Request Received from Service");
		Integer agencyId = getAgencyId(applicationId);
		LOGGER.debug("In AssessmentBodyHomepageDao - getassignedBatchesAssessmentBodyHomepageRowMapper");
		LOGGER.debug("Parameters Received from Service are - 'applicationId': " +applicationId);
				   	
		LOGGER.debug("Getting details of proposed batches to agency");
		
		LOGGER.debug("Creating HashMap object");
		Map<String,Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Inserting parameters to HashMap object");
		parameters.put("agencyId",agencyId);
		LOGGER.debug("Parameters inserted");
		
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().query(assessmentBodyHomepageConfigSql.getSelectSqlassignedBatchesAssessmentBodyHomepage(),parameters,
				ROW_MAPPER);
	}	
	public Collection<AssessmentBodyHomepageDto> getconfirmedBatchesAssessmentBodyHomepageRowMapper(int applicationId) {
		Integer agencyId = getAgencyId(applicationId);
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In AssessmentBodyHomepageDao - getconfirmedBatchesAssessmentBodyHomepageRowMapper");
		LOGGER.debug("Parameters Received from Service are - 'applicationId': " +applicationId);
				   	
		LOGGER.debug("Getting details of confirmed batches to agency");
		
		LOGGER.debug("Creating HashMap object");
		Map<String,Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Inserting parameters to HashMap object");
		parameters.put("agencyId",agencyId);
		LOGGER.debug("Parameters inserted");
		
		LOGGER.debug("Executing SQL query and returning response");
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
