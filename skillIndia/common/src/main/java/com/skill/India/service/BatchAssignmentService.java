package com.skill.India.service;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.BatchAssignmentDao;
import com.skill.India.dto.BatchAssignmentDto;


@Service
public class BatchAssignmentService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BatchAssignmentService.class);
	
	@Autowired
	private BatchAssignmentDao batchAssignmentDao;
	
	public Collection<BatchAssignmentDto> getproposedBatchesBatchAssignmentRowMapper(){
		LOGGER.debug("Request Received from Controller");
		LOGGER.debug("In BatchAssignmentService - getproposedBatchesBatchAssignmentRowMapper");
		LOGGER.debug("Making a Request to Dao to get data");
		return batchAssignmentDao.getproposedBatchesBatchAssignmentRowMapper();
	}
	
	public Collection<BatchAssignmentDto> getapprovedBatchesBatchAssignmentRowMapper (){
		LOGGER.debug("Request Received from Controller");
		LOGGER.debug("In BatchAssignmentService - getapprovedBatchesBatchAssignmentRowMapper");
		LOGGER.debug("Making a Request to Dao to get data");
		return batchAssignmentDao.getapprovedBatchesBatchAssignmentRowMapper();
	}
	
	public Collection<BatchAssignmentDto> getrejectedBatchesBatchAssignmentRowMapper(){
		LOGGER.debug("Request Received from Controller");
		LOGGER.debug("In BatchAssignmentService - getrejectedBatchesBatchAssignmentRowMapper");
		LOGGER.debug("Making a Request to Dao to get data");
		return batchAssignmentDao.getrejectedBatchesBatchAssignmentRowMapper();
	}

	
}
