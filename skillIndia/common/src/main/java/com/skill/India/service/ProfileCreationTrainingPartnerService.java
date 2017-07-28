package com.skill.India.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.common.UserIdCheckInTrainingPartnerRegistration;
import com.skill.India.dao.ProfileCreationTrainingPartnerDao;
import com.skill.India.dto.ProfileCreationTrainingPartnerDto;

@Service
public class ProfileCreationTrainingPartnerService {
	@Autowired
	private ProfileCreationTrainingPartnerDao profileCreationTrainingPartnerDao;
	
	@Autowired
	private UserIdCheckInTrainingPartnerRegistration userIdCheckInTrainingPartnerRegistration; 
	
	public ProfileCreationTrainingPartnerDto profileCreationTrainingPartner()
	{
		try{
		String userId="aurbind@tedconsult.com";
		/*
		 * First checking if userId exists in tpReg table or not then getting data from respective tables
		 */
		int userIdExists=userIdCheckInTrainingPartnerRegistration.userIdCheckInTrainingPartnerRegistration(userId);
		if(userIdExists==1)
		{
		Collection<ProfileCreationTrainingPartnerDto> records= profileCreationTrainingPartnerDao.profileCreationGetDataFromTrainingPartnerRegistration(userId);
		for(ProfileCreationTrainingPartnerDto getRecord:records)
			return getRecord;
		}
		else if(userIdExists==0)
		{
			/*
			 * Get data from user table 
			 */
			Collection<ProfileCreationTrainingPartnerDto> records= profileCreationTrainingPartnerDao.profileCreationGetDataFromUser(userId);
			for(ProfileCreationTrainingPartnerDto getRecord:records)
				return getRecord;
		}
		
		return null;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}
}
