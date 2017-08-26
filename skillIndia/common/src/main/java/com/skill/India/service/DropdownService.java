package com.skill.India.service;

import com.skill.India.dao.DropdownDao;
import com.skill.India.dto.DropdownDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Alkesh srivastav on 7/17/2017.
 */
@Service
public class DropdownService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DropdownService.class);
	
    @Autowired
    private DropdownDao dropdownDao;

    public Collection<DropdownDto> getCollection(){
    	LOGGER.info("Request Received from Controller");
		LOGGER.info("In DropdownService - getCollection");
		LOGGER.info("Making a Request to Dao to get data");
		return dropdownDao.getCollection();
    }
}
