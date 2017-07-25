package com.skill.India.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.skill.India.common.SessionUserUtility;
import com.skill.India.dao.GetUserIdPasswordAndRoleDao;
import com.skill.India.dto.SessionManagementDto;

@Service
public class SessionManagementService implements UserDetailsService {

	@Autowired
	private GetUserIdPasswordAndRoleDao userIdPasswordAndRoleDao;

	@Autowired
	private SessionUserUtility userIdtoApplicationIdUtility;

	@Override
	public SessionManagementDto loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

		/*
		 * Check for user existence here
		 */

		int status = userIdPasswordAndRoleDao.userExistence(username);
		if (status == 0) {
			authorities.add(new SimpleGrantedAuthority(null));
			return new SessionManagementDto(null, null, null);
		}

		return userIdPasswordAndRoleDao.getUserIdPasswordAndRole(username);
	}

}
