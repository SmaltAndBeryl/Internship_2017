package com.skill.India.service;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.AssessmentBodyHomepageDao;
import com.skill.India.dto.AssessmentBodyHomepageDto;


@Service
public class AssessmentBodyHomepageService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AssessmentBodyHomepageService.class);
	
	@Autowired
	private AssessmentBodyHomepageDao assessmentBodyHomepageDao;
	
	public Collection<AssessmentBodyHomepageDto> getpastBatchesAssessmentBodyHomepageRowMapper(int applicationId){
		LOGGER.debug("Request Received from Controller");
		LOGGER.debug("In AssessmentBodyHomepageService - getpastBatchesAssessmentBodyHomepageRowMapper");
		LOGGER.debug("Parameters Received from front end are - 'applicationId': "+applicationId);
		LOGGER.debug("Making a Request to Dao to get data");
		return assessmentBodyHomepageDao.getpastBatchesAssessmentBodyHomepageRowMapper(applicationId);
	}
	
	public Collection<AssessmentBodyHomepageDto> getupcomingBatchesAssessmentBodyHomepageRowMapper(int applicationId){
		LOGGER.debug("Request Received from Controller");
		LOGGER.debug("In AssessmentBodyHomepageService - getupcomingBatchesAssessmentBodyHomepageRowMapper");
		LOGGER.debug("Parameters Received from front end are - 'applicationId': "+applicationId);
		LOGGER.debug("Making a Request to Dao to get data");
		return assessmentBodyHomepageDao.getupcomingBatchesAssessmentBodyHomepageRowMapper(applicationId);
	}
	
	public Collection<AssessmentBodyHomepageDto> getshownInterestAssessmentBodyHomepageRowMapper(int applicationId){
		LOGGER.debug("Request Received from Controller");
		LOGGER.debug("In AssessmentBodyHomepageService - getshownInterestAssessmentBodyHomepageRowMapper");
		LOGGER.debug("Parameters Received from front end are - 'applicationId': "+applicationId);
		LOGGER.debug("Making a Request to Dao to get data");
		return assessmentBodyHomepageDao.getshownInterestAssessmentBodyHomepageRowMapper(applicationId);
	}
	
	public Collection<AssessmentBodyHomepageDto> getassignedBatchesAssessmentBodyHomepageRowMapper(int applicationId){
		LOGGER.debug("Request Received from Controller");
		LOGGER.debug("In AssessmentBodyHomepageService - getassignedBatchesAssessmentBodyHomepageRowMapper");
		LOGGER.debug("Parameters Received from front end are - 'applicationId': "+applicationId);
		LOGGER.debug("Making a Request to Dao to get data");
		return assessmentBodyHomepageDao.getassignedBatchesAssessmentBodyHomepageRowMapper(applicationId);
	}
	
	public Collection<AssessmentBodyHomepageDto> getconfirmedBatchesAssessmentBodyHomepageRowMapper(int applicationId){
		LOGGER.debug("Request Received from Controller");
		LOGGER.debug("In AssessmentBodyHomepageService - getconfirmedBatchesAssessmentBodyHomepageRowMapper");
		LOGGER.debug("Parameters Received from front end are - 'applicationId': "+applicationId);
		LOGGER.debug("Making a Request to Dao to get data");
		return assessmentBodyHomepageDao.getconfirmedBatchesAssessmentBodyHomepageRowMapper(applicationId);
	}
	
	
}
