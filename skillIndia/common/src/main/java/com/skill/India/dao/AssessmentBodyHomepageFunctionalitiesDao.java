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
		LOGGER.debug("trying to get agency Id for application Id"+ applicationId);
		Map<String,Object> parameters = new HashMap<>();
		parameters.put("applicationId", applicationId);
		agencyId = getJdbcTemplate().queryForObject(assessmentBodyHomepageConfigSql.getGetAgencyId(), parameters,ROW_MAPPER_AGENCY_ID);
		LOGGER.debug("Agency Id for applicationId :"+applicationId+"is :"+agencyId);
		return agencyId;
	}
	
	public int putShowInterest(String batchId,int applicationId){
		Integer agencyId =getAgencyId(applicationId);
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In AssessmentBodyHomepageFunctionalitiesDao - putShowInterest");
		LOGGER.debug("Parameters Received from Service are - 'batchId': " +batchId+" 'agencyId': "+applicationId);
				   	
		LOGGER.debug("Capturing show interest of a agency to a batch");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Inserting parameters to HashMap object");
		parameters.put("batchId",batchId);
		parameters.put("agencyId",agencyId);
		LOGGER.debug("Parameters inserted");
		
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().update(assessmentBodyHomepageConfigSql.getUpdateSqlShowInterest(), parameters);
	}
	
	public int putApproveBatch(String from, int applicationId){
		Integer agencyId = getAgencyId(applicationId);
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In AssessmentBodyHomepageFunctionalitiesDao - putApproveBatch");
		LOGGER.debug("Parameters Received from Service are - 'from': " +from);
		
		LOGGER.debug("Accepting batch by agency");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Inserting parameters to HashMap object");
		parameters.put("batchId",from);
		parameters.put("agencyId", agencyId);
		LOGGER.debug("Parameters inserted");
		
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().update(assessmentBodyHomepageConfigSql.getUpdateSqlapproveBatchesAssessmentBody(), parameters);
	}
	public int putRejectBatch(String from, int applicationId){
		Integer agencyId = getAgencyId(applicationId);
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In AssessmentBodyHomepageFunctionalitiesDao - putRejectBatch");
		LOGGER.debug("Parameters Received from Service are - 'from': " +from+"agency Id is "+agencyId);
		
		LOGGER.debug("Rejecting batch by agency");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Inserting parameters to HashMap object");
		parameters.put("batchId",from);
		parameters.put("agencyId",agencyId);
		LOGGER.debug("Parameters inserted"+ parameters.toString());
		
		LOGGER.debug("Executing SQL query and returning response");
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
