package com.skill.India.service;

import com.skill.India.dao.BatchAssignmentWithdrawDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Priyanshu Pandey on 7/13/2017.
 */
@Service
public class BatchAssignmentWithdrawService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BatchAssignmentWithdrawService.class);
	
    @Autowired
    private BatchAssignmentWithdrawDao batchAssignmentWithdrawDao;

    public int putUpdateBatches(String batchId){
    	LOGGER.debug("Request Received from Controller");
		LOGGER.debug("In BatchAssignmentWithdrawService - putUpdateBatches");
		LOGGER.debug("Parameters Received from front end are - 'batchId': "+batchId);
		LOGGER.debug("Making a Request to Dao to get data");
		return batchAssignmentWithdrawDao.putUpdateBatches(batchId);
    }
}
