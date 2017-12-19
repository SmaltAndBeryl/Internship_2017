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
		LOGGER.debug("Request Received from Controller");
		LOGGER.debug("In LoginService - checkUser");
		//LOGGER.debug(loginReceiveDataDto.getUserId(),loginReceiveDataDto.getPassword());
		LOGGER.debug("Application have to verify the user existence");
		LOGGER.debug("Parameters Received from front end are - 'loginReceiveDataDto': "+loginReceiveDataDto);
		LOGGER.debug("Making a Request to Dao to check if user exists or not");
		userExistenceValidation=loginDao.userExistence(loginReceiveDataDto.getUserId(),loginReceiveDataDto.getPassword());
		LOGGER.debug("Response received from Dao");
		if(userExistenceValidation==1){
			LOGGER.debug("User exist in the Record");
			LOGGER.debug("Making a Request to Dao to verify credentials");
			Collection<LoginDto> login=loginDao.getValidateLoginUser(loginReceiveDataDto.getUserId(), loginReceiveDataDto.getPassword());
			LOGGER.debug("Response received from Dao");
			LOGGER.debug("Data Captured in LoginDto");
			for(LoginDto l:login)
			{
				return l;
			}
		}
	
		else{
			LOGGER.debug("Wrong credentials");
			LOGGER.debug("Initializing Blank LoginDto");
					loginDto = new LoginDto(null, null, null);
			}
		LOGGER.debug("Sending the response back to Controller");
		return loginDto;
	}
	
}