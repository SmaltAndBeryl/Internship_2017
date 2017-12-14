package com.skill.India.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.SaveAsDraftAndSubmitDao;
import com.skill.India.dao.SignUpDao;
import com.skill.India.dto.SignUpInsertedUserDto;
import com.skill.India.dto.SignUpReceiveDataDto;

@Service
public class SignUpService {
	
	@Autowired
	private SignUpDao signUpDao;
	private SignUpInsertedUserDto signUpInsertedUserDto;
	
	@Autowired
	private SaveAsDraftAndSubmitDao saveAsDraftAndSubmitDao;

	
	private static final Logger LOGGER = LoggerFactory.getLogger(SignUpService.class);

	
	
	private int userExistStatus;
	private int id;

	public int signUp(SignUpReceiveDataDto signUpReceiveDataDto)
	{
		int status = 10;
		
		try
		{
			LOGGER.debug("Trying to find out users existence ");
			
			userExistStatus=signUpDao.checkUserExistence(signUpReceiveDataDto.getUserId(),signUpReceiveDataDto.getOrganizationName());
			
			if(userExistStatus == 0)
			{
				LOGGER.debug("User is a new user. Trying to insert values in database");
				id = signUpDao.insertSignUpData(signUpReceiveDataDto.getOrganizationName(),signUpReceiveDataDto.getSPOCName(),signUpReceiveDataDto.getUserId(),signUpReceiveDataDto.getPassword(),signUpReceiveDataDto.getUserRole());

				 status = saveAsDraftAndSubmitDao.insertIntoApplication(signUpReceiveDataDto.getUserId(), "Draft");				
			}
			else if(userExistStatus == 1)
			{
				status = -1 ; 
				LOGGER.debug("User already exist in the record");
				
			}
		}
		catch(Exception e)
		{
			LOGGER.error("An exception occured while creating user " + e);
			status = -2;
		}
		
		return status;
		
	}
	
}
