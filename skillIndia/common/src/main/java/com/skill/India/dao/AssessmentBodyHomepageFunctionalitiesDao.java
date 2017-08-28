package com.skill.India.dao;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.AssessmentBodyHomepageConfigSql;


@Repository
public class AssessmentBodyHomepageFunctionalitiesDao extends AbstractTransactionalDao{

	private static final Logger LOGGER = LoggerFactory.getLogger(AssessmentBodyHomepageFunctionalitiesDao.class);
	
	@Autowired
	public AssessmentBodyHomepageConfigSql assessmentBodyHomepageConfigSql;
	
	public int putShowInterest(String batchId,String agencyId){
		LOGGER.info("Request Received from Service");
		LOGGER.info("In AssessmentBodyHomepageFunctionalitiesDao - putShowInterest");
		LOGGER.info("Parameters Received from Service are - 'batchId': " +batchId+" 'agencyId': "+agencyId);
				   	
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
	
	public int putApproveBatch(String from){
		LOGGER.info("Request Received from Service");
		LOGGER.info("In AssessmentBodyHomepageFunctionalitiesDao - putApproveBatch");
		LOGGER.info("Parameters Received from Service are - 'from': " +from);
		
		LOGGER.info("Accepting batch by agency");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Inserting parameters to HashMap object");
		parameters.put("batchId",from);
		LOGGER.info("Parameters inserted");
		
		LOGGER.info("Executing SQL query and returning response");
        return getJdbcTemplate().update(assessmentBodyHomepageConfigSql.getUpdateSqlapproveBatchesAssessmentBody(), parameters);
	}
	public int putRejectBatch(String from){
		LOGGER.info("Request Received from Service");
		LOGGER.info("In AssessmentBodyHomepageFunctionalitiesDao - putRejectBatch");
		LOGGER.info("Parameters Received from Service are - 'from': " +from);
		
		LOGGER.info("Rejecting batch by agency");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Inserting parameters to HashMap object");
		parameters.put("batchId",from);
		LOGGER.info("Parameters inserted");
		
		LOGGER.info("Executing SQL query and returning response");
        return getJdbcTemplate().update(assessmentBodyHomepageConfigSql.getUpdateSqlrejectBatchesAssessmentBody(), parameters);
	}
	
}
