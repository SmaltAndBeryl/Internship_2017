package com.skill.India.service;

import com.skill.India.dao.NonAssignedBatchesUpdateDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Alkesh on 7/12/2017.
 */
@Service
public class NonAssignedBatchesUpdateService {
    @Autowired
    private NonAssignedBatchesUpdateDao updateDao;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(NonAssignedBatchesUpdateDao.class);
    public int putUpdateBatches(String batchId, String agencyId,String responseType)
    {
    	try
    	{
        	LOGGER.info("Trying to check if agency for batch "+batchId+" is proposed already");
        	if(updateDao.checkIfProposedAlready(batchId))
        	{
        		LOGGER.info("Batch has been propsed any agency already, hence updating");
        		return updateDao.putUpdateBatches(batchId,agencyId,responseType);
        	}
        	else
        	{
        		LOGGER.info("Proposing agency "+agencyId+" to batch "+batchId+ " for the first time");
        		return updateDao.insertProposedBatch(agencyId, batchId, responseType);
        	}
    	}
    	catch(Exception e)
    	{
    		LOGGER.info("Exception occurred--- "+e);
    		return 1;
    	}        
    }
}
