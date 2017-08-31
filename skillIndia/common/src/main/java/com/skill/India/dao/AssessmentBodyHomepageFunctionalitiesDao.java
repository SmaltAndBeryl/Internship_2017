package com.skill.India.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.AssessmentBodyHomepageConfigSql;



@Repository
public class AssessmentBodyHomepageFunctionalitiesDao extends AbstractTransactionalDao{

	private static final Logger LOGGER = LoggerFactory.getLogger(AssessmentBodyHomepageFunctionalitiesDao.class);
	private static final AssessmentBodyHomepageAgencyRowMapper ROW_MAPPER_AGENCY_ID = new AssessmentBodyHomepageAgencyRowMapper();
	@Autowired
	public AssessmentBodyHomepageConfigSql assessmentBodyHomepageConfigSql;
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
	
	public int putShowInterest(String batchId,int applicationId){
		Integer agencyId =getAgencyId(applicationId);
		LOGGER.info("Request Received from Service");
		LOGGER.info("In AssessmentBodyHomepageFunctionalitiesDao - putShowInterest");
		LOGGER.info("Parameters Received from Service are - 'batchId': " +batchId+" 'agencyId': "+applicationId);
				   	
		LOGGER.info("Capturing show interest of a agency to a batch");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Inserting parameters to HashMap object");
		parameters.put("batchId",batchId);
		parameters.put("agencyId",agencyId);
		LOGGER.info("Parameters inserted");
		
		LOGGER.info("Executing SQL query and returning response");
        return getJdbcTemplate().update(assessmentBodyHomepageConfigSql.getUpdateSqlShowInterest(), parameters);
	}
	
	public int putApproveBatch(String from, int applicationId){
		Integer agencyId = getAgencyId(applicationId);
		LOGGER.info("Request Received from Service");
		LOGGER.info("In AssessmentBodyHomepageFunctionalitiesDao - putApproveBatch");
		LOGGER.info("Parameters Received from Service are - 'from': " +from);
		
		LOGGER.info("Accepting batch by agency");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Inserting parameters to HashMap object");
		parameters.put("batchId",from);
		parameters.put("agencyId", agencyId);
		LOGGER.info("Parameters inserted");
		
		LOGGER.info("Executing SQL query and returning response");
        return getJdbcTemplate().update(assessmentBodyHomepageConfigSql.getUpdateSqlapproveBatchesAssessmentBody(), parameters);
	}
	public int putRejectBatch(String from, int applicationId){
		Integer agencyId = getAgencyId(applicationId);
		LOGGER.info("Request Received from Service");
		LOGGER.info("In AssessmentBodyHomepageFunctionalitiesDao - putRejectBatch");
		LOGGER.info("Parameters Received from Service are - 'from': " +from+"agency Id is "+agencyId);
		
		LOGGER.info("Rejecting batch by agency");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Inserting parameters to HashMap object");
		parameters.put("batchId",from);
		parameters.put("agencyId",agencyId);
		LOGGER.info("Parameters inserted"+ parameters.toString());
		
		LOGGER.info("Executing SQL query and returning response");
        return getJdbcTemplate().update(assessmentBodyHomepageConfigSql.getUpdateSqlrejectBatchesAssessmentBody(), parameters);
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
