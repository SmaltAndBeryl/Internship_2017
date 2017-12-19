package com.skill.India.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.ShowInterestUpcomingBatchesDao;

@Service
public class ShowInterestUpcomingBatchesService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ShowInterestUpcomingBatchesService.class);
	
	@Autowired
	private ShowInterestUpcomingBatchesDao insertDao;
	
	public String putInsertRowMapper(int id){
		LOGGER.debug("Request Received from controller");
		LOGGER.debug("In ShowInterestUpcomingBatchesService - putInsertRowMapper");
		LOGGER.debug("Parameters Received from Controller are - 'id': "+id);
		
		LOGGER.debug("Making a Request to Dao to get data");
		int i=insertDao.insertShowInterestUpcomingBatches(id);
		LOGGER.debug("Response received from Dao");
		if(i>0)
			
			return ("Successfully record inserted");
		else 
			return "Record not inserted";
	}
}
