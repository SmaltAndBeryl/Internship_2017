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
		LOGGER.info("Request Received from Controller");
		LOGGER.info("In BatchAssignmentService - getproposedBatchesBatchAssignmentRowMapper");
		LOGGER.info("Making a Request to Dao to get data");
		return batchAssignmentDao.getproposedBatchesBatchAssignmentRowMapper();
	}
	
	public Collection<BatchAssignmentDto> getapprovedBatchesBatchAssignmentRowMapper (){
		LOGGER.info("Request Received from Controller");
		LOGGER.info("In BatchAssignmentService - getapprovedBatchesBatchAssignmentRowMapper");
		LOGGER.info("Making a Request to Dao to get data");
		return batchAssignmentDao.getapprovedBatchesBatchAssignmentRowMapper();
	}
	
	public Collection<BatchAssignmentDto> getrejectedBatchesBatchAssignmentRowMapper(){
		LOGGER.info("Request Received from Controller");
		LOGGER.info("In BatchAssignmentService - getrejectedBatchesBatchAssignmentRowMapper");
		LOGGER.info("Making a Request to Dao to get data");
		return batchAssignmentDao.getrejectedBatchesBatchAssignmentRowMapper();
	}

	
}
