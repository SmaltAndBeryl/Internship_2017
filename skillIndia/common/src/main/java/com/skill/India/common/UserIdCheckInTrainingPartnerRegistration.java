package com.skill.India.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.ProfileCreationTrainingPartnerDao;

@Service
public class UserIdCheckInTrainingPartnerRegistration {

	@Autowired
	private ProfileCreationTrainingPartnerDao profileCreationTrainingPartnerDao;

	public int userIdCheckInTrainingPartnerRegistration(String userId)
	{
		try{
		return profileCreationTrainingPartnerDao.profileCreationCheckUserIdExistence(userId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return -2;
		}
	}
}
