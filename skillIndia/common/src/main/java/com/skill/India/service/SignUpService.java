package com.skill.India.service;

import com.skill.India.dao.SignUpDao;
import com.skill.India.dto.SignUpInsertedUserDto;
import com.skill.India.dto.SignUpReceiveDataDto;

public class SignUpService {
	
	private SignUpDao signUpDao;
	private int userExistStatus;
	private int id;
	public SignUpInsertedUserDto signUpInsertedUserDto;

	public SignUpInsertedUserDto signUp(SignUpReceiveDataDto signUpReceiveDataDto){
		
		
		userExistStatus=signUpDao.checkUserExistence(signUpReceiveDataDto.userId,signUpReceiveDataDto.organizationName);
		
		if(userExistStatus==1)
		{
			id = signUpDao.insertSignUpData(signUpReceiveDataDto.organizationName,signUpReceiveDataDto.spocName,signUpReceiveDataDto.userId,signUpReceiveDataDto.password,signUpReceiveDataDto.userRole);
			signUpInsertedUserDto=signUpDao.getUserData(id);
			
		}
		else
		{
			signUpInsertedUserDto= new SignUpInsertedUserDto(null, null, null);
		}
		return signUpInsertedUserDto;
	}
	
}
