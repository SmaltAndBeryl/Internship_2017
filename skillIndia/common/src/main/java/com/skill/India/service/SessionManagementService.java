package com.skill.India.service;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.skill.India.common.SessionUserUtility;
import com.skill.India.dao.GetUserIdPasswordAndRoleDao;
import com.skill.India.dto.SessionManagementDto;

@Service
public class SessionManagementService implements UserDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SessionManagementService.class);
	
	@Autowired
	private GetUserIdPasswordAndRoleDao userIdPasswordAndRoleDao;

	@Autowired
	private SessionUserUtility userIdtoApplicationIdUtility;

	@Override
	public SessionManagementDto loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		LOGGER.info("Request Received from controller");
		LOGGER.info("In SessionManagementService - loadUserByUsername");
		LOGGER.info("Parameters Received from Controller are - 'username': "+username);
		
		LOGGER.info("Creating Collection object");
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		LOGGER.info("Successfully initialized");
		
		/*
		 * Check for user existence here
		 */
		
		LOGGER.info("Making a Request to Dao to get data");
		int status = userIdPasswordAndRoleDao.userExistence(username);
		LOGGER.info("Response received from Dao");
		if (status == 0) {
			authorities.add(new SimpleGrantedAuthority(null));
			return new SessionManagementDto(null, null, null);
		}

		return userIdPasswordAndRoleDao.getUserIdPasswordAndRole(username);
	}

}
