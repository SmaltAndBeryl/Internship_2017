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
 * Created by Alkesh srivastav on 7/17/2017.
 */
@Repository
public class NonAssignedUpdateAgencyDao extends AbstractTransactionalDao{
    @Autowired
    public NonAssignedBatchesConfigSql configSql;
    private static final Logger LOGGER = LoggerFactory.getLogger(NonAssignedUpdateAgencyDao.class);
    public int putAgencyId(String agencyId, String batchId, String responseType){
    	
    	LOGGER.debug("Request Received from Service");
    	LOGGER.debug("In NonAssignedUpdateAgencyDao - putAgencyId");
    	LOGGER.debug("Parameters Received from Service are - 'agencyId': " +agencyId+" 'batchId': "+batchId+" 'responseType': "+responseType);
		   	
    	LOGGER.debug("Update the Response and Agency for a particular Batch");
    	
    	LOGGER.debug("Creating HashMap object");
		Map<String,Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Inserting parameters to HashMap object");
		parameters.put("agencyId", agencyId);
        parameters.put("batchId", batchId);
        parameters.put("responseType", responseType);
        LOGGER.debug("Parameters inserted");
//        LOGGER.debug("Parameters used while assigning agency to batch are " + parameters.toString());
      
        LOGGER.debug("Executing SQL query and returning response");
        return getJdbcTemplate().update(configSql.getUpdateSqlProposeAgency(), parameters);
    }
}
