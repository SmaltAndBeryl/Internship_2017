package com.skill.India.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.SignUpDao;
import com.skill.India.dto.SignUpInsertedUserDto;
import com.skill.India.dto.SignUpReceiveDataDto;

@Service
public class SignUpService {
	
	@Autowired
	private SignUpDao signUpDao;
	private SignUpInsertedUserDto signUpInsertedUserDto;
	
	
	
	
	private int userExistStatus;
	private int id;

	public SignUpInsertedUserDto signUp(SignUpReceiveDataDto signUpReceiveDataDto){
				
		userExistStatus=signUpDao.checkUserExistence(signUpReceiveDataDto.userId,signUpReceiveDataDto.organizationName);
		if(userExistStatus==0)
		{
			id = signUpDao.insertSignUpData(signUpReceiveDataDto.organizationName,signUpReceiveDataDto.sPOCName,signUpReceiveDataDto.userId,signUpReceiveDataDto.mypassword,signUpReceiveDataDto.userRole);
			
			Collection<SignUpInsertedUserDto> signUp= signUpDao.getUserData(id);
			
			for(SignUpInsertedUserDto s: signUp)
			{
				return s;
			}
			
		}
		else
		{
			signUpInsertedUserDto= new SignUpInsertedUserDto(null, null, null);
			
		}
		
		
		return signUpInsertedUserDto;
		
	}
	
}
