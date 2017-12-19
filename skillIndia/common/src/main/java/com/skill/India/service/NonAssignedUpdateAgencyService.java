package com.skill.India.service;

import com.skill.India.dao.NonAssignedUpdateAgencyDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Alkesh srivastav on 7/17/2017.
 */
@Service
public class NonAssignedUpdateAgencyService {
    
	private static final Logger LOGGER = LoggerFactory.getLogger(NonAssignedUpdateAgencyService.class);
	
	@Autowired
    private NonAssignedUpdateAgencyDao nonAssignedUpdateAgencyDao;

    public int putAgencyId(String agencyId, String batchId, String responseType){
    	
    	LOGGER.debug("Request Received from Controller");
		LOGGER.debug("In NonAssignedUpdateAgencyService - putAgencyId");
		LOGGER.debug("Parameters Received from Controller are - 'agencyId': "+agencyId+" 'batchId': "+batchId+" 'responseType': "+responseType);
		LOGGER.debug("Making a Request to Dao");
		return nonAssignedUpdateAgencyDao.putAgencyId(agencyId, batchId, responseType);
    }
}
