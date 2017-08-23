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
	private int userExistenceValidation;
	
	private LoginDto loginDto;


	public LoginDto checkUser(LoginReceiveDataDto loginReceiveDataDto)
	{
		LOGGER.info("Request Received from Controller");
		LOGGER.info("In LoginService - checkUser");
		//LOGGER.info(loginReceiveDataDto.getUserId(),loginReceiveDataDto.getPassword());
		LOGGER.info("Application have to verify the user existence");
		LOGGER.info("Parameters Received from front end are - 'loginReceiveDataDto': ",loginReceiveDataDto);
		LOGGER.info("Making a Request to Dao to check if user exists or not");
		userExistenceValidation=loginDao.userExistence(loginReceiveDataDto.getUserId(),loginReceiveDataDto.getPassword());
		LOGGER.info("Response received from Dao");
		if(userExistenceValidation==1){
			LOGGER.info("User exist in the Record");
			LOGGER.info("Making a Request to Dao to verify credentials");
			Collection<LoginDto> login=loginDao.getValidateLoginUser(loginReceiveDataDto.getUserId(), loginReceiveDataDto.getPassword());
			LOGGER.info("Response received from Dao");
			LOGGER.info("Data Captured in LoginDto");
			for(LoginDto l:login)
			{
				return l;
			}
		}
	
		else{
			LOGGER.info("Wrong credentials");
			LOGGER.info("Initializing Blank LoginDto");
					loginDto = new LoginDto(null, null, null);
			}
		LOGGER.info("Sending the response back to Controller");
		return loginDto;
	}
	
}