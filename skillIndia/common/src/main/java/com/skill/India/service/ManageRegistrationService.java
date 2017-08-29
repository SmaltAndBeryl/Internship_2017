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
				LOGGER.info("Request Received from controller");
				LOGGER.info("In ManageRegistrationService - putUpdateRowMapper");
				LOGGER.info("Parameters Received from Controller are - 'id': "+id);
				
				 LOGGER.info("Making a Request to Dao to get data");
				 int i = updateDao.putUpdateRowMapper(id);
				 LOGGER.info("Response received from Dao");
				if(i>0)
					return "success";
				else
					return "fail";
			}
			
			}
