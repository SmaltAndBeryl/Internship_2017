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
		
		LOGGER.debug("Request Received from controller");
		LOGGER.debug("In AssessmentBodyUpcomingBatchService - getUpdateRowMapper");
		LOGGER.debug("Making a Request to Dao to get data");
		return updateDao.getUpateRowMapper() ;
	}

}