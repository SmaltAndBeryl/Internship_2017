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
		LOGGER.info("Request Received from controller");
		LOGGER.info("In ShowInterestUpcomingBatchesService - putInsertRowMapper");
		LOGGER.info("Parameters Received from Controller are - 'id': "+id);
		
		LOGGER.info("Making a Request to Dao to get data");
		int i=insertDao.insertShowInterestUpcomingBatches(id);
		LOGGER.info("Response received from Dao");
		if(i>0)
			
			return ("Successfully record inserted");
		else 
			return "Record not inserted";
	}
}
