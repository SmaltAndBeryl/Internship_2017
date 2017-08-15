package com.skill.India.service;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.TrainingPartnerApplicationStatusDao;
import com.skill.India.dto.TrainingPartnerApplicationStatusDto;

@Service
public class TrainingPartnerApplicationStatusService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TrainingPartnerApplicationStatusService.class);
	
	@Autowired
	private TrainingPartnerApplicationStatusDao updateDao;
	
	public Collection<TrainingPartnerApplicationStatusDto> getUpdateRowMapper(int applicationId){
		LOGGER.info("Request Received from Controller");
		LOGGER.info("In TrainingPartnerApplicationStatusService - getUpdateRowMapper");
		LOGGER.info("Parameters Received from front end are - 'applicationId': ",applicationId);
		LOGGER.info("Making a Request to Dao");
		return updateDao.getUpateRowMapper(applicationId) ;
	}
}
