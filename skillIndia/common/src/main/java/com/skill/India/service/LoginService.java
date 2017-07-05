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


	public int checkUser(LoginReceiveDataDto loginReceiveDataDto)
	{
		LOGGER.info(loginReceiveDataDto.getUserId(),loginReceiveDataDto.getPassword());
		
		Collection<LoginDto> loginDto = loginDao.getLoginRowMapper(loginReceiveDataDto.userId, loginReceiveDataDto.password);
		
	//collection object
		for(LoginDto a: loginDto)
		{
			if(a.getApplicationId()==0||a.getUserRole()==""||a.getUserStatus()=="")
			{
				return 0;
			}
			else if(a.getUserStatus()=="Draft")
			{
				if(a.getUserRole()=="TP")
				{
					return 1;
				}
				else
				{
					return 2;
				}
				
			}
			else
			{
				if(a.getUserRole()=="TP")
				{
					return 3;
					//HomePage Training Partner
				}
				else if(a.getUserRole()=="AB") 
				{
					return 4;
					//HomePage Assessment Body
				}
				else 
				{
					return 5;
					//DashBoard SCGJ;
				}
				
			}
		}
		return 0;
	}
}	
	
	





