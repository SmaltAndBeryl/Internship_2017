package com.skill.India.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.ProfileCreationTpDao;
import com.skill.India.dto.ProfileCreationTpDto;


@Service
public class ProfileCreationTpService
{

	
	@Autowired
	private ProfileCreationTpDao profileCreationTpDao;
	
	public Boolean set(ProfileCreationTpDto profileCreationTpDto)
	{
		
	int status;
	status= profileCreationTpDao.insert(profileCreationTpDto);
	if(status == 0)
		return false;
	else
		return true;
	
    }
}