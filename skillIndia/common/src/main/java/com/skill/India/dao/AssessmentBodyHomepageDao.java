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
		LOGGER.info("Request Received from Service");
		LOGGER.info("In AssessmentBodyHomepageDao - getpastBatchesAssessmentBodyHomepageRowMapper");
		LOGGER.info("Parameters Received from Service are - 'applicationId': " +applicationId);
				   	
		LOGGER.info("Getting details of past batches for agency");
		
		LOGGER.info("Creating HashMap object");
		Map<String,Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Inserting parameters to HashMap object");
		parameters.put("applicationId",applicationId);
		LOGGER.info("Parameters inserted");
		
		LOGGER.info("Executing SQL query and returning response");
        return getJdbcTemplate().query(assessmentBodyHomepageConfigSql.getSelectSqlpastBatchesAssessmentBodyHomepage(),parameters,
				ROW_MAPPER);
	}	
	
	public Collection<AssessmentBodyHomepageDto> getupcomingBatchesAssessmentBodyHomepageRowMapper(int applicationId) {
		LOGGER.info("Request Received from Service");
		LOGGER.info("In AssessmentBodyHomepageDao - getupcomingBatchesAssessmentBodyHomepageRowMapper");
		LOGGER.info("Parameters Received from Service are - 'agencyId': " +applicationId);
				   	
		LOGGER.info("Getting details of upcoming batches for agency");
		
		LOGGER.info("Creating HashMap object");
		Map<String,Object> parameters = new HashMap<>();
		
		LOGGER.info("object created successfully");
		
		LOGGER.info("Inserting parameters to HashMap object");
		parameters.put("agencyId" ,getAgencyId(applicationId));
		LOGGER.info("Parameters inserted are:"+parameters.toString());
		
		LOGGER.info("Executing SQL query and returning response");
		LOGGER.info("Query formed is:"+ assessmentBodyHomepageConfigSql.getSelectSqlupcomingBatchesAssessmentBodyHomepage().toString());
        return getJdbcTemplate().query(assessmentBodyHomepageConfigSql.getSelectSqlupcomingBatchesAssessmentBodyHomepage(),parameters,
				ROW_MAPPER);
	}
	private int getAgencyId(int applicationId)
	{
		int agencyId=0;
		LOGGER.info("trying to get agency Id for application Id"+ applicationId);
		Map<String,Object> parameters = new HashMap<>();
		parameters.put("applicationId", applicationId);
		agencyId = getJdbcTemplate().queryForObject(assessmentBodyHomepageConfigSql.getGetAgencyId(), parameters,ROW_MAPPER_AGENCY_ID);
		LOGGER.info("Agency Id for applicationId :"+applicationId+"is :"+agencyId);
		return agencyId;
	}
	public Collection<AssessmentBodyHomepageDto> getshownInterestAssessmentBodyHomepageRowMapper(int applicationId) {
		LOGGER.info("Request Received from Service");
		LOGGER.info("In AssessmentBodyHomepageDao - getshownInterestAssessmentBodyHomepageRowMapper");
		LOGGER.info("Parameters Received from Service are - 'applicationId': " +applicationId);
				   	
		LOGGER.info("Getting details of shown interest batches by agency");
		
		LOGGER.info("Creating HashMap object");
		Map<String,Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Inserting parameters to HashMap object");
		parameters.put("applicationId",applicationId);
		LOGGER.info("Parameters inserted");
		
		LOGGER.info("Executing SQL query and returning response");
        return getJdbcTemplate().query(assessmentBodyHomepageConfigSql.getSelectSqlShownInterestBatchesAssessmentBodyHomepage(),parameters,
				ROW_MAPPER);
	}
	public Collection<AssessmentBodyHomepageDto> getassignedBatchesAssessmentBodyHomepageRowMapper(int applicationId) {
		LOGGER.info("Request Received from Service");
		LOGGER.info("In AssessmentBodyHomepageDao - getassignedBatchesAssessmentBodyHomepageRowMapper");
		LOGGER.info("Parameters Received from Service are - 'applicationId': " +applicationId);
				   	
		LOGGER.info("Getting details of proposed batches to agency");
		
		LOGGER.info("Creating HashMap object");
		Map<String,Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Inserting parameters to HashMap object");
		parameters.put("applicationId",applicationId);
		LOGGER.info("Parameters inserted");
		
		LOGGER.info("Executing SQL query and returning response");
        return getJdbcTemplate().query(assessmentBodyHomepageConfigSql.getSelectSqlassignedBatchesAssessmentBodyHomepage(),parameters,
				ROW_MAPPER);
	}	
	public Collection<AssessmentBodyHomepageDto> getconfirmedBatchesAssessmentBodyHomepageRowMapper(int applicationId) {
		LOGGER.info("Request Received from Service");
		LOGGER.info("In AssessmentBodyHomepageDao - getconfirmedBatchesAssessmentBodyHomepageRowMapper");
		LOGGER.info("Parameters Received from Service are - 'applicationId': " +applicationId);
				   	
		LOGGER.info("Getting details of confirmed batches to agency");
		
		LOGGER.info("Creating HashMap object");
		Map<String,Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Inserting parameters to HashMap object");
		parameters.put("applicationId",applicationId);
		LOGGER.info("Parameters inserted");
		
		LOGGER.info("Executing SQL query and returning response");
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
