package com.skill.India.service;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.AssignedBatchesDao;

import com.skill.India.dto.AssignedBatchesDto;


@Service
public class AssignedBatchesService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AssignedBatchesService.class);
	
	@Autowired
	private AssignedBatchesDao updateDao;
	
	public Collection<AssignedBatchesDto> getUpdateRowMapper()
	{
		LOGGER.info("Request Received from Controller");
		LOGGER.info("In AssignedBatchesService - getUpdateRowMapper");
		LOGGER.info("Making a Request to Dao to get data");
		return updateDao.getupdateRowMapper();
	}
	
	
	
}



