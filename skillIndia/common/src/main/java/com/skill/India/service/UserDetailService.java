package com.skill.India.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.UserDetailsDao;
import com.skill.India.dto.UserDetailsDto;

@Service
public class UserDetailService {
	
	
	@Autowired
	private UserDetailsDao userDetailsDao;
	
	public UserDetailsDto getUser(String userName){
		return userDetailsDao.loadUserByUsername(userName);
	}
	

}
