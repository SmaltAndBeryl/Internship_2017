package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.NonAssignedBatchesConfigSql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alkesh srivastav on 7/12/2017.
 */
@Repository
public class NonAssignedBatchesUpdateDao extends AbstractTransactionalDao{
    @Autowired
    public NonAssignedBatchesConfigSql batchesConfigSql;
    //String from = "DAO";
    private static final Logger LOGGER = LoggerFactory.getLogger(NonAssignedBatchesUpdateDao.class);
    
    public int putUpdateBatches(String batchId, String agencyId,String responseType){
    	
    	LOGGER.info("Request Received from Service");
		LOGGER.info("In NonAssignedBatchesUpdateDao - putUpdateBatches");
		LOGGER.info("Parameters Received from Service are - 'batchId': " +batchId+" 'agencyId': "+agencyId+" 'responseType': "+responseType);
		   	
		LOGGER.info("Update the response of Agency proposed corresponding to a batch ");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Inserting parameters to HashMap object");
		parameters.put("batchId", batchId);
        parameters.put("responseType",responseType);
        parameters.put("agencyId", agencyId);
        LOGGER.info("Parameters inserted");
		
//		LOGGER.info("Parameters to be passed to update batch porposal batchId is -"+batchId+" type of acion is "+responseType);
		LOGGER.info("Executing SQL query and returning response");
        return getJdbcTemplate().update(batchesConfigSql.getUpdateSqlNonAssignedBatches(),parameters);
    }
    
    
    public Boolean checkIfProposedAlready(String batchId)
    {
    	LOGGER.info("Request Received from Service");
		LOGGER.info("In NonAssignedBatchesUpdateDao - checkIfProposedAlready");
		LOGGER.info("Parameters Received from Service are - 'batchId': " +batchId);
		   	
		LOGGER.info("Checking if a Batch is already proposed to a Agency ");
		
    	Integer valueExists = 0;
    	Boolean alreadyProposed = false;
    	
    	LOGGER.info("Creating HashMap object");
    	Map<String,Object> parameters = new HashMap<>();
    	LOGGER.info("object created successfully");
    	
    	LOGGER.info("Inserting parameters to HashMap object");
		parameters.put("batchId", batchId);
		LOGGER.info("Parameters inserted");
		
		LOGGER.info("Executing SQL query");
        valueExists = getJdbcTemplate().queryForObject(batchesConfigSql.getCheckBatchInBatchAssignment(), parameters, Integer.class);
    	LOGGER.info("Query Executed"); 
        if(valueExists ==1)
    	 {
    		 alreadyProposed = true;
    	 }
    	 else
    	 {
    		 alreadyProposed = false;
    	 }
        LOGGER.info("Returning response");
    	 return alreadyProposed;
    }
    
    public int insertProposedBatch(String agencyId, String batchId, String responseType)
    {
    	LOGGER.info("Request Received from Service");
		LOGGER.info("In NonAssignedBatchesUpdateDao - insertProposedBatch");
		LOGGER.info("Parameters Received from Service are - 'agencyId': " +agencyId+" 'batchId': "+batchId+" 'responseType': "+responseType);
		   	
		LOGGER.info("Proposing Agency corresponding to a batch ");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
    	
    	LOGGER.info("Inserting parameters to HashMap object");
		parameters.put("batchId", batchId);
        parameters.put("agencyId",agencyId);
        parameters.put("responseType", responseType);
        LOGGER.info("Parameters inserted");
		
//		  LOGGER.info("Inserting value in batch assignment table is" + parameters.toString());
//        LOGGER.info("The SQL formed is " + batchesConfigSql.getInsertSqlNonAssignedBatches());
        LOGGER.info("Executing SQL query and returning response");
        return getJdbcTemplate().update(batchesConfigSql.getInsertSqlNonAssignedBatches(),parameters);
    }
}
