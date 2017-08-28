package com.skill.India.dao;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.ManageRegistrationConfig;

@Repository
public class ManageRegistrationDao extends AbstractTransactionalDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(ManageRegistrationDao.class);
	
	@Autowired
	public ManageRegistrationConfig config;

		public int putUpdateRowMapper(int id) {
			LOGGER.info("Request Received from Service");
			LOGGER.info("In ManageRegistrationDao - putUpdateRowMapper");
			LOGGER.info("Parameters Received from Service are - 'id': " +id);
			   	
			LOGGER.info("Setting application state to draft corresponding to application Id");
			
			LOGGER.info("Creating HashMap object");
			Map<String, Object> parameters = new HashMap<>();
			LOGGER.info("object created successfully");
			
			LOGGER.info("Inserting parameters to HashMap object");
			parameters.put("app_state", "pending");
			LOGGER.info("Parameters inserted");
			
			LOGGER.info("Executing SQL query and returning response");
	        return getJdbcTemplate().update(config.getUpdateSql(), parameters);
			
		}	
}