package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.NonAssignedBatchesConfigSql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    	
    	LOGGER.debug("Request Received from Service");
		LOGGER.debug("In NonAssignedBatchesUpdateDao - putUpdateBatches");
		LOGGER.debug("Parameters Received from Service are - 'batchId': " +batchId+" 'agencyId': "+agencyId+" 'responseType': "+responseType);
		   	
		LOGGER.debug("Update the response of Agency proposed corresponding to a batch ");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Inserting parameters to HashMap object");
		parameters.put("batchId", batchId);
        parameters.put("responseType",responseType);
        parameters.put("agencyId", agencyId);
        LOGGER.debug("Parameters inserted");
		
//		LOGGER.debug("Parameters to be passed to update batch porposal batchId is -"+batchId+" type of acion is "+responseType);
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().update(batchesConfigSql.getUpdateSqlNonAssignedBatches(),parameters);
    }
    
    
    public Boolean checkIfProposedAlready(String batchId)
    {
    	LOGGER.debug("Request Received from Service");
		LOGGER.debug("In NonAssignedBatchesUpdateDao - checkIfProposedAlready");
		LOGGER.debug("Parameters Received from Service are - 'batchId': " +batchId);
		   	
		LOGGER.debug("Checking if a Batch is already proposed to a Agency ");
		
    	Integer valueExists = 0;
    	Boolean alreadyProposed = false;
    	
    	LOGGER.debug("Creating HashMap object");
    	Map<String,Object> parameters = new HashMap<>();
    	LOGGER.debug("object created successfully");
    	
    	LOGGER.debug("Inserting parameters to HashMap object");
		parameters.put("batchId", batchId);
		LOGGER.debug("Parameters inserted");
		
		LOGGER.debug("Executing SQL query");
        valueExists = getJdbcTemplate().queryForObject(batchesConfigSql.getCheckBatchInBatchAssignment(), parameters, Integer.class);
    	LOGGER.debug("Query Executed"); 
        if(valueExists ==1)
    	 {
    		 alreadyProposed = true;
    	 }
    	 else
    	 {
    		 alreadyProposed = false;
    	 }
        LOGGER.debug("Returning response");
    	 return alreadyProposed;
    }
    
    public int insertProposedBatch(String agencyId, String batchId, String responseType)
    {
    	LOGGER.debug("Request Received from Service");
		LOGGER.debug("In NonAssignedBatchesUpdateDao - insertProposedBatch");
		LOGGER.debug("Parameters Received from Service are - 'agencyId': " +agencyId+" 'batchId': "+batchId+" 'responseType': "+responseType);
		   	
		LOGGER.debug("Proposing Agency corresponding to a batch ");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
    	
    	LOGGER.debug("Inserting parameters to HashMap object");
		parameters.put("batchId", batchId);
        parameters.put("agencyId",agencyId);
        parameters.put("responseType", responseType);
        LOGGER.debug("Parameters inserted");
		
//		  LOGGER.debug("Inserting value in batch assignment table is" + parameters.toString());
//        LOGGER.debug("The SQL formed is " + batchesConfigSql.getInsertSqlNonAssignedBatches());
        LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().update(batchesConfigSql.getInsertSqlNonAssignedBatches(),parameters);
    }
}
