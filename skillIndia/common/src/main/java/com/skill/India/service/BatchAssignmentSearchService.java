package com.skill.India.service;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.skill.India.dao.BatchAssignmentSearchDao;
import com.skill.India.dto.BatchAssignmentSearchDto;



@Service
public class BatchAssignmentSearchService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BatchAssignmentSearchService.class);
	
	@Autowired
	private BatchAssignmentSearchDao updateDao;
	
	public Collection<BatchAssignmentSearchDto> getBatchDataForAssignmentService(int batchId){
		LOGGER.info("Request Received from Controller");
		LOGGER.info("In BatchAssignmentSearchService - getBatchDataForAssignmentService");
		LOGGER.info("Parameters Received from front end are - 'batchId': ",batchId);
		LOGGER.info("Making a Request to Dao to get data");
		return updateDao.executeSearch(batchId);
	}

}


