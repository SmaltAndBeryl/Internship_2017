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
		LOGGER.debug("Request Received from Controller");
		LOGGER.debug("In TrainingPartnerApplicationStatusService - getUpdateRowMapper");
		LOGGER.debug("Parameters Received from front end are - 'applicationId': "+applicationId);
		LOGGER.debug("Making a Request to Dao");
		return updateDao.getUpateRowMapper(applicationId) ;
	}
}
