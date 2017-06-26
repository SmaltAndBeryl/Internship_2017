package com.skill.India.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.LoginDao;
import com.skill.India.dto.LoginDto;

@Service
public class LoginService {

	@Autowired
	private LoginDao loginDao;
	
	public Collection<LoginDto> getusername(String userName, String passWord)
	{
		
		return loginDao.getLoginRowMapper(userName, passWord);
	}
	
	
	
}




