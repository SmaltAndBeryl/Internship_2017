package com.skill.India.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.ProfileCreationDao;
import com.skill.India.dto.ProfileCreationDataPopulateDto;

@Service
public class ProfileCreationDataPopulateService {
	
	@Autowired
	private ProfileCreationDao profileCreationDao;
	
	public ProfileCreationDataPopulateDto getDataToPopulate(String userId){
		
		return profileCreationDao.getUserData(userId);
	}

}
