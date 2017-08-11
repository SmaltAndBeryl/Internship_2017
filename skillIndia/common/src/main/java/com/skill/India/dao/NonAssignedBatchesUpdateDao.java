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

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("batchId", batchId);
        parameters.put("responseType",responseType);
        parameters.put("agencyId", agencyId);
        LOGGER.info("Parameters to be passed to update batch porposal batchId is -"+batchId+" type of acion is "+responseType);
        return getJdbcTemplate().update(batchesConfigSql.getUpdateSqlNonAssignedBatches(),parameters);
    }
    
    
    public Boolean checkIfProposedAlready(String batchId)
    {
    	Integer valueExists = 0;
    	Boolean alreadyProposed = false;
    	Map<String,Object> parameters = new HashMap<>();
    	parameters.put("batchId", batchId);
    	 valueExists = getJdbcTemplate().queryForObject(batchesConfigSql.getCheckBatchInBatchAssignment(), parameters, Integer.class);
    	 if(valueExists ==1)
    	 {
    		 alreadyProposed = true;
    	 }
    	 else
    	 {
    		 alreadyProposed = false;
    	 }
    	 return alreadyProposed;
    }
    
    public int insertProposedBatch(String agencyId, String batchId, String responseType)
    {
    	
    	Map<String, Object> parameters = new HashMap<>();
        parameters.put("batchId", batchId);
        parameters.put("agencyId",agencyId);
        parameters.put("responseType", responseType);
        return getJdbcTemplate().update(batchesConfigSql.getInsertSqlNonAssignedBatches(),parameters);
    }
}
