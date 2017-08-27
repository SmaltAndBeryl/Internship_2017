package com.skill.India.service;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.AssessmentBodyUpcomingBatchDao;
import com.skill.India.dto.AssessmentBodyUpcomingBatchDto;

@Service
public class AssessmentBodyUpcomingBatchService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AssessmentBodyUpcomingBatchService.class);
	
	
	@Autowired
	private AssessmentBodyUpcomingBatchDao updateDao;
	
	public Collection<AssessmentBodyUpcomingBatchDto> getUpdateRowMapper(){
		
		LOGGER.info("Request Received from controller");
		LOGGER.info("In AssessmentBodyUpcomingBatchService - getUpdateRowMapper");
		LOGGER.info("Making a Request to Dao to get data");
		return updateDao.getUpateRowMapper() ;
	}

}