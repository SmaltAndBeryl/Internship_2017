package com.skill.India.service;

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
		
	//	System.out.println(signUpReceiveDataDto.getOrganizationName()+ signUpReceiveDataDto);
		
		userExistStatus=signUpDao.checkUserExistence(signUpReceiveDataDto.userId,signUpReceiveDataDto.organizationName);
		if(userExistStatus==0)
		{
			id = signUpDao.insertSignUpData(signUpReceiveDataDto.organizationName,signUpReceiveDataDto.spocName,signUpReceiveDataDto.userId,signUpReceiveDataDto.password,signUpReceiveDataDto.userRole);
			
			return signUpDao.getUserData(id);
			
		}
		else
		{
			signUpInsertedUserDto= new SignUpInsertedUserDto(null, null, null);
			
		}
		
		
		return signUpInsertedUserDto;
		
	}
	
}
