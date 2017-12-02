package com.skill.India.service;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.common.SessionUserUtility;
import com.skill.India.common.UserIdCheckInTrainingPartnerRegistration;
import com.skill.India.dao.ProfileCreationTrainingPartnerDao;
import com.skill.India.dto.ProfileCreationTrainingPartnerDto;

@Service
public class ProfileCreationTrainingPartnerService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProfileCreationTrainingPartnerService.class);
	
	@Autowired
	private ProfileCreationTrainingPartnerDao profileCreationTrainingPartnerDao;

	@Autowired
	private UserIdCheckInTrainingPartnerRegistration userIdCheckInTrainingPartnerRegistration;
	
	@Autowired
	private SessionUserUtility sessionUserUtility;

	public ProfileCreationTrainingPartnerDto profileCreationTrainingPartner()
	{
		LOGGER.debug("Request Received from Controller");
		LOGGER.debug("In ProfileCreationTrainingPartnerService - profileCreationTrainingPartner");
			
		try{
			LOGGER.debug("Trying to fetch userId from the session");
			
			String userId=sessionUserUtility.getSessionMangementfromSession().getUsername();
			LOGGER.debug("User logged in has userId-" + userId);
		/*
		 * First checking if userId exists in tpReg table or not then getting data from respective tables
		 */
		LOGGER.debug("Checking if user has logged in for the first time");
		
		int userIdExists=userIdCheckInTrainingPartnerRegistration.userIdCheckInTrainingPartnerRegistration(userId);
		
		if(userIdExists==1)
		{
			LOGGER.debug("User has logged in before");
			
			LOGGER.debug("Creating Collection to get data of Training Partner");
			LOGGER.debug("Making a Request to Dao to get data");
			Collection<ProfileCreationTrainingPartnerDto> records= profileCreationTrainingPartnerDao.profileCreationGetDataFromTrainingPartnerRegistration(userId);
			LOGGER.debug("Data Received Successfully in collection");
			LOGGER.debug("Iterating every field from the received data ");
			LOGGER.debug("Returning Every Field to Controller");
			for(ProfileCreationTrainingPartnerDto getRecord:records)
				return getRecord;
		}
		else if(userIdExists==0)
		{
			/*
			 * Get data from user table
			 */
			LOGGER.debug("User is logging in for the first time");
			
			LOGGER.debug("Creating Collection to get data of Training Partner");
			LOGGER.debug("Making a Request to Dao to get data");
			Collection<ProfileCreationTrainingPartnerDto> records= profileCreationTrainingPartnerDao.profileCreationGetDataFromUser(userId);
			LOGGER.debug("Data Received Successfully in collection");
			LOGGER.debug("Iterating every field from the received data ");
			for(ProfileCreationTrainingPartnerDto getRecord:records)
				return getRecord;
		}

		return null;
		}
		catch(Exception e)
		{
			LOGGER.debug("In CATCH Block");
			LOGGER.error("Error : Encountered an Exception - ",e);
			LOGGER.debug("Returning NULL");
			//e.printStackTrace();
			return null;
		}

	}
}
