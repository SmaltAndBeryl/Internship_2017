package com.skill.India.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.skill.India.dao.ManageRegistrationDao;

@Service
	public class ManageRegistrationService {
			
	private static final Logger LOGGER = LoggerFactory.getLogger(ManageRegistrationService.class);
	
			@Autowired
			private ManageRegistrationDao updateDao;
			
			public String putUpdateRowMapper(int id)
			{	
				LOGGER.debug("Request Received from controller");
				LOGGER.debug("In ManageRegistrationService - putUpdateRowMapper");
				LOGGER.debug("Parameters Received from Controller are - 'id': "+id);
				
				 LOGGER.debug("Making a Request to Dao to get data");
				 int i = updateDao.putUpdateRowMapper(id);
				 LOGGER.debug("Response received from Dao");
				if(i>0)
					return "success";
				else
					return "fail";
			}
			
			}
