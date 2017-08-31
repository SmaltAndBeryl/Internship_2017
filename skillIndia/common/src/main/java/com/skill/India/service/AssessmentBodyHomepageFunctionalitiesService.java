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
		LOGGER.info("Request Received from Controller");
		LOGGER.info("In AssessmentBodyHomepageFunctionalitiesService - putShowInterest");
		LOGGER.info("Parameters Received from front end are - 'batchId': "+batchId+" 'application Id': "+applicationId);
		LOGGER.info("Making a Request to Dao to get data");
		//		System.out.println("THIS IS THE BATCH id"+batchId+agencyId);
		return assessmentBodyHomepageFunctionalitiesDao.putShowInterest(batchId,applicationId);
	}
	
	public int putApproveBatch(String batchId,int applicationId){
//		System.out.println("THIS IS THE BATCH id"+batchId);
		LOGGER.info("Request Received from Controller");
		LOGGER.info("In AssessmentBodyHomepageFunctionalitiesService - putApproveBatch");
		LOGGER.info("Parameters Received from front end are - 'batchId': "+batchId);
		LOGGER.info("Making a Request to Dao to get data");
		return assessmentBodyHomepageFunctionalitiesDao.putApproveBatch(batchId, applicationId);
	}
	
	public int putRejectBatch(String batchId, int applicationId){
		LOGGER.info("Request Received from Controller");
		LOGGER.info("In AssessmentBodyHomepageFunctionalitiesService - putRejectBatch");
		LOGGER.info("Parameters Received from front end are - 'batchId': "+batchId);
		LOGGER.info("Making a Request to Dao to get data");
		return assessmentBodyHomepageFunctionalitiesDao.putRejectBatch(batchId,applicationId);
	}
}
