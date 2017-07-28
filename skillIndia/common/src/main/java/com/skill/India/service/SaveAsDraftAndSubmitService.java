package com.skill.India.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.common.SessionUserUtility;
import com.skill.India.common.UserIdCheckInTrainingPartnerRegistration;
import com.skill.India.dao.ProfileCreationTrainingPartnerDao;
import com.skill.India.dao.SaveAsDraftAndSubmitDao;
import com.skill.India.dto.ProfileCreationTrainingPartnerDto;

@Service
public class SaveAsDraftAndSubmitService {
	
	@Autowired
	private UserIdCheckInTrainingPartnerRegistration userIdCheckInTrainingPartnerRegistration; 

	@Autowired
	private SaveAsDraftAndSubmitDao saveAsDraftAndSubmitDao;
	
	@Autowired
	private SessionUserUtility sessionUserUtility;
	
	public String saveAsDraftAndSubmit(ProfileCreationTrainingPartnerDto profileCreationTrainingPartnerDto)
	{
		int userIdExists=userIdCheckInTrainingPartnerRegistration.userIdCheckInTrainingPartnerRegistration(profileCreationTrainingPartnerDto.getUserId());
		System.out.println("UserId status : "+userIdExists);
		if(userIdExists==0)
		{
			/*
			 * i.e. userId doesnt exist in record and user is directly coming from signup process
			 * Things need to be done here : 
			 *  1) Set data in Application table 
			 *  2) Get ApplicationId from there 
			 *  3) Set data in TPREG table(insert query) 
			 */
			try{
				
				int statusOfInsertIntoApplication=saveAsDraftAndSubmitDao.insertIntoApplication(profileCreationTrainingPartnerDto);
				if(statusOfInsertIntoApplication>0)
				{
					/*
					 * Getting ApplicationId from Application Table 
					 */
					try{
					int applicationId=sessionUserUtility.getApplicationId(profileCreationTrainingPartnerDto.getUserId());
					}
					catch(Exception e)
					{	
						e.printStackTrace();
						return "Error Occurred";
						
					}
					try{
					int statusOfInsertIntoTrainingPartnerRegistration=saveAsDraftAndSubmitDao.insertIntoTrainingPartnerRegistration(profileCreationTrainingPartnerDto);
					if(statusOfInsertIntoTrainingPartnerRegistration>0)
					{
						return "Success";
					}
					else
					{
						return "Error Occurred";
					}
					
					}
					catch(Exception e)
					{
						e.printStackTrace();
						return "Error Occurred";
					}
					
				}
				else
				{
					return "Error Occurred";	
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return "Error";
			}
	
		}
		
		else if(userIdExists==1)
		{
			/*
			 * User is coming from sign In process and form is incomplete and run update query
			 */
			
			try{
				saveAsDraftAndSubmitDao.updateIntoTrainingPartnerRegistration(profileCreationTrainingPartnerDto);
			}
			catch(Exception e)
			{
				
			}
			
		}
		return null;
	}
}
