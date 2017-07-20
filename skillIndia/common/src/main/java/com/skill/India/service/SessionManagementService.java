package com.skill.India.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.skill.India.common.UserIdtoApplicationIdUtility;
import com.skill.India.dao.GetUserIdPasswordAndRoleDao;
import com.skill.India.dto.SessionManagementDto;

@Service
public class SessionManagementService implements UserDetailsService {

	@Autowired
	private GetUserIdPasswordAndRoleDao getUserIdPasswordAndRoleDao; 
	

	@Autowired
	private UserIdtoApplicationIdUtility userIdtoApplicationIdUtility;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		String userId="";
		String password="";
		String userRole="";
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		
		/*
		 * Check for user existence here
		 */
		
		int status=getUserIdPasswordAndRoleDao.userExistence(userId);
		if(status==0)
		{
			authorities.add(new SimpleGrantedAuthority(null));
			return new SessionManagementDto(null, null,authorities);
		}
		
		
		/*
		 * If user Id exists get the ID,password and userRole from DB
		 */
		
		
		Collection<SessionManagementDto> obj=getUserIdPasswordAndRoleDao.getUserIdPasswordAndRole(username);
		for(SessionManagementDto x:obj)
		{
			userId=x.getUsername();
			password=x.getPassword();
			userRole=x.getUserRole();
			break;
		}
		
		//String applicationId=userIdtoApplicationIdUtility.getApplicationId(userId);
		
		authorities.add(new SimpleGrantedAuthority(userRole));
		return new SessionManagementDto(userId, password, authorities);
	}

}
