package com.skill.India.service;

import com.skill.India.dao.NonAssignedBatchesDao;
import com.skill.India.dto.NonAssignedBatchesDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Alkesh on 7/12/2017.
 */
@Service
public class NonAssignedBatchesService {

    @Autowired
    private NonAssignedBatchesDao updateDao;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(NonAssignedBatchesService.class);
    
    public Collection<NonAssignedBatchesDto> getCollection(){
    	LOGGER.info("Request Received from Controller");
		LOGGER.info("In NonAssignedBatchesService - getCollection");
		LOGGER.info("Making a Request to Dao to get data for Non assigned batches");
        return updateDao.getCollection();
    }
}
