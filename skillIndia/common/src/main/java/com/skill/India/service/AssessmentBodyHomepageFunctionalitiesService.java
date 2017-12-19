package com.skill.India.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.AssessmentBodyHomepageFunctionalitiesDao;

@Service
public class AssessmentBodyHomepageFunctionalitiesService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AssessmentBodyHomepageFunctionalitiesService.class);
	
	@Autowired
	private AssessmentBodyHomepageFunctionalitiesDao assessmentBodyHomepageFunctionalitiesDao;
	
	public int putShowInterest(String batchId,int applicationId){
		LOGGER.debug("Request Received from Controller");
		LOGGER.debug("In AssessmentBodyHomepageFunctionalitiesService - putShowInterest");
		LOGGER.debug("Parameters Received from front end are - 'batchId': "+batchId+" 'application Id': "+applicationId);
		LOGGER.debug("Making a Request to Dao to get data");
		//		System.out.println("THIS IS THE BATCH id"+batchId+agencyId);
		return assessmentBodyHomepageFunctionalitiesDao.putShowInterest(batchId,applicationId);
	}
	
	public int putApproveBatch(String batchId,int applicationId){
//		System.out.println("THIS IS THE BATCH id"+batchId);
		LOGGER.debug("Request Received from Controller");
		LOGGER.debug("In AssessmentBodyHomepageFunctionalitiesService - putApproveBatch");
		LOGGER.debug("Parameters Received from front end are - 'batchId': "+batchId);
		LOGGER.debug("Making a Request to Dao to get data");
		return assessmentBodyHomepageFunctionalitiesDao.putApproveBatch(batchId, applicationId);
	}
	
	public int putRejectBatch(String batchId, int applicationId){
		LOGGER.debug("Request Received from Controller");
		LOGGER.debug("In AssessmentBodyHomepageFunctionalitiesService - putRejectBatch");
		LOGGER.debug("Parameters Received from front end are - 'batchId': "+batchId);
		LOGGER.debug("Making a Request to Dao to get data");
		return assessmentBodyHomepageFunctionalitiesDao.putRejectBatch(batchId,applicationId);
	}
}
