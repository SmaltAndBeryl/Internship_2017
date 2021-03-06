package com.skill.India.service;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.DataImportFindBatchUsingBatchId;
import com.skill.India.dto.DataImportGetBatchInfoDto;

@Service
public class FindBatchUsingBatchIdService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FindBatchUsingBatchIdService.class);

	@Autowired
	private DataImportFindBatchUsingBatchId dataImportFindBatchUsingBatchId;
	
	public Collection<DataImportGetBatchInfoDto> findBatchUsingBatchId(String batchId){
		LOGGER.debug("Request Received from Controller");
		LOGGER.debug("In FindBatchUsingBatchIdService - findBatchUsingBatchId");
		LOGGER.debug("Parameters Received from front end are - 'batchId': "+batchId);
		LOGGER.debug("Making a Request to Dao to get data");
		return dataImportFindBatchUsingBatchId.getDataOfBatchUsingBatchId(batchId);
		
	}
}
