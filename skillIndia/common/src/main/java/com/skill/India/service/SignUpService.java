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

	public SignUpInsertedUserDto signUp(SignUpReceiveDataDto signUpReceiveDataDto){
		
		LOGGER.info("Request Received from Controller");
		LOGGER.info("In SignUpService - signUp");
		LOGGER.info("Parameters Received from front end are - 'SignUpReceiveDataDto': ",signUpReceiveDataDto);
		LOGGER.info("Check the existence of new user in the record");
		LOGGER.info("Making a Request to Dao");
		userExistStatus=signUpDao.checkUserExistence(signUpReceiveDataDto.getUserId(),signUpReceiveDataDto.getOrganizationName());
		LOGGER.info("Response received from Dao");
		if(userExistStatus==0)
		{
			LOGGER.info("User does not exist in the record");
			LOGGER.info("Inserting user details - SignUp process");
			LOGGER.info("Making a Request to Dao");
			id = signUpDao.insertSignUpData(signUpReceiveDataDto.getOrganizationName(),signUpReceiveDataDto.getSPOCName(),signUpReceiveDataDto.getUserId(),signUpReceiveDataDto.getPassword(),signUpReceiveDataDto.getUserRole());
			LOGGER.info("Response received from Dao");
			if(id >-1)
			{
			 LOGGER.info("Saving the details of user");
			 LOGGER.info("Inserting data into application table");
			 LOGGER.info("Making a Request to Dao");
			 saveAsDraftAndSubmitDao.insertIntoApplication(signUpReceiveDataDto.getUserId(), "Draft");
			}
					
		}
		else
		{
			LOGGER.info("User already exist in the record");
			LOGGER.info("Initializing blank Dto to return to controller");
			signUpInsertedUserDto= new SignUpInsertedUserDto(null, null, null);
			LOGGER.info("Successfully Initialized");
		}
		
		LOGGER.info("Returning response to Controller");
		return signUpInsertedUserDto;
		
	}
	
}
