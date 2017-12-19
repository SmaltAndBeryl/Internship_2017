package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.BatchAssignmentConfigSql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Priyanshu Pandey on 7/15/2017.
 */
@Repository
public class BatchAssignmentWithdrawDao extends AbstractTransactionalDao{
    
	private static final Logger LOGGER = LoggerFactory.getLogger(BatchAssignmentWithdrawDao.class);
	
	@Autowired
    public BatchAssignmentConfigSql batchAssignmentConfigSql;

    public int putUpdateBatches(String from){
    	LOGGER.debug("Request Received from Service");
		LOGGER.debug("In BatchAssignmentWithdrawDao - putUpdateBatches");
				   	
		LOGGER.debug("Withdrawing Batch with batch Id");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Inserting parameters to HashMap object");
		parameters.put("batchId",from);
		LOGGER.debug("Parameters inserted");
		
		LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().update(batchAssignmentConfigSql.getUpdateSqlBatchAssignment(),parameters);
    }
}