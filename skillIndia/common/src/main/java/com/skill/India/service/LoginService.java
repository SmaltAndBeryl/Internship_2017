package com.skill.India.service;

import java.util.Collection;

import org.codehaus.groovy.classgen.ReturnAdder;
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
	private int userExistenceValidation;
	private int response;
	private LoginDto loginDto;


	public int checkUser(LoginReceiveDataDto loginReceiveDataDto)
	{
		System.out.println(loginReceiveDataDto.password+loginReceiveDataDto.userId);
		LOGGER.info(loginReceiveDataDto.getUserId(),loginReceiveDataDto.getPassword());
		
		userExistenceValidation=loginDao.userExistence(loginReceiveDataDto.getUserId(),loginReceiveDataDto.getPassword());
		
		if(userExistenceValidation==1){
			System.out.println(userExistenceValidation);
			Collection<LoginDto> login=loginDao.getLoginRowMapper(loginReceiveDataDto.getUserId(), loginReceiveDataDto.getPassword());
			System.out.println(login);
			for(LoginDto l:login)
			{
				//System.out.println(l.getApplicationId()+ l.getUserRole() + l.getUserStatus());
				
				response=1;
			}
		}
	
		else{
			System.out.println(userExistenceValidation);
			loginDto= new LoginDto(0, null, null);
			response=0;
		}
		return response;
	}
	
}	
	
	





