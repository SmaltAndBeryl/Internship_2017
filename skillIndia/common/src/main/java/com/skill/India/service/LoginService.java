package com.skill.India.service;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.LoginDao;
import com.skill.India.dto.LoginDto;
import com.skill.India.dto.LoginReceiveDataDto;

@Service
public class LoginService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginService.class);
	@Autowired
	private LoginDao loginDao;

	public Collection<LoginDto> checkUser(LoginReceiveDataDto loginReceiveDataDTO)
	{
		LOGGER.info(loginReceiveDataDTO.getUserName(),loginReceiveDataDTO.getPassword());
		return loginDao.getLoginRowMapper(loginReceiveDataDTO.userName, loginReceiveDataDTO.password);
		
		//return new Collection<LoginDto>();
	}
	
	
	
}




