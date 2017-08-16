package com.skill.India.service;

import java.util.Collection;

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
		
		LOGGER.info("Check the existence of new user in the record");
		
		userExistStatus=signUpDao.checkUserExistence(signUpReceiveDataDto.getUserId(),signUpReceiveDataDto.getOrganizationName());
		if(userExistStatus==0)
		{
			LOGGER.info("User existence status is-"+userExistStatus);
			LOGGER.info("User does not exist in the record");
			id = signUpDao.insertSignUpData(signUpReceiveDataDto.getOrganizationName(),signUpReceiveDataDto.getSPOCName(),signUpReceiveDataDto.getUserId(),signUpReceiveDataDto.getPassword(),signUpReceiveDataDto.getUserRole());
		 if(id >-1){
			 saveAsDraftAndSubmitDao.insertIntoApplication(signUpReceiveDataDto.getUserId(), "Draft");
		 }
					
		}
		else
		{
			LOGGER.info("User already exist in the record");
			signUpInsertedUserDto= new SignUpInsertedUserDto(null, null, null);
		}
		
		
		return signUpInsertedUserDto;
		
	}
	
}
