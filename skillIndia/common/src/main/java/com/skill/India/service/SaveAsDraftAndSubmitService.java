package com.skill.India.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.common.SessionUserUtility;
import com.skill.India.common.UserIdCheckInTrainingPartnerRegistration;
import com.skill.India.dao.SaveAsDraftAndSubmitDao;
import com.skill.India.dto.ProfileCreationTrainingPartnerDto;

@Service
public class SaveAsDraftAndSubmitService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SaveAsDraftAndSubmitService.class);
	
	@Autowired
	private UserIdCheckInTrainingPartnerRegistration userIdCheckInTrainingPartnerRegistration;

	@Autowired
	private SaveAsDraftAndSubmitDao saveAsDraftAndSubmitDao;

	@Autowired
	private SessionUserUtility sessionUserUtility;

	public String saveAsDraftAndSubmit(ProfileCreationTrainingPartnerDto profileCreationTrainingPartnerDto,String type)
	{
		LOGGER.info("Request Received from Controller");
		LOGGER.info("In SaveAsDraftAndSubmitService - saveAsDraftAndSubmit");
		LOGGER.info("Parameters Received from front end are - 'type': "+type+" 'profileCreationTrainingPartnerDto':",profileCreationTrainingPartnerDto);
		try{
			LOGGER.info("Inside TRY block");
			
		if(type.equalsIgnoreCase("submit"))
		{
			throw new Exception();
		}
		LOGGER.info("Checking Existense of Training Partner");
		LOGGER.info("Making a Request to Dao to get data");
		int userIdExists=userIdCheckInTrainingPartnerRegistration.userIdCheckInTrainingPartnerRegistration(profileCreationTrainingPartnerDto.getUserId());
		LOGGER.info("Response received from Dao");
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
				LOGGER.info("Inserting data in Application Table");
				LOGGER.info("Making a Request to Dao");
				int statusOfInsertIntoApplication=saveAsDraftAndSubmitDao.insertIntoApplication(profileCreationTrainingPartnerDto.getUserId(),type);
				LOGGER.info("Response received from Dao");
				/*
				 *  -1 is returned if an exception occurs
				 */
				if(statusOfInsertIntoApplication>0)
				{
					/*
					 * Getting ApplicationId from Application Table
					 */
					try{
					//int applicationId=sessionUserUtility.getApplicationId(profileCreationTrainingPartnerDto.getUserId());
					}
					catch(Exception e)
					{
						e.printStackTrace();
						return null;
					}
					try{
						LOGGER.info("Inserting data in Training Partner Registration table");
						LOGGER.info("Making a Request to Dao");
					int statusOfInsertIntoTrainingPartnerRegistration=saveAsDraftAndSubmitDao.insertIntoTrainingPartnerRegistration(profileCreationTrainingPartnerDto);
					LOGGER.info("Response received from Dao");
					if(statusOfInsertIntoTrainingPartnerRegistration>0)
					{
						return "Success";
					}
					else
					{
						LOGGER.info("Data Not Inserted in TP REG");
						return null;
					}

					}
					catch(Exception e)
					{
						e.printStackTrace();
						return null;
					}

				}
				else
				{
					LOGGER.info("Data Not Inserted in Application");
					return null;
				}

			}
			catch(Exception e)
			{
				LOGGER.info("inside CATCH block");
				e.printStackTrace();
				return null;
			}

		}

		else if(userIdExists==1)
		{
			/*
			 * User is coming from sign In process and form is incomplete and run update query
			 */

			try{
				if(type.equalsIgnoreCase("Submit"))
				{
					LOGGER.info("Updating data in Application Table");
					LOGGER.info("Making a Request to Dao");
					int statusOfUpdateIntoApplication=saveAsDraftAndSubmitDao.updateIntoApplication(profileCreationTrainingPartnerDto,type);
					LOGGER.info("Response received from Dao");
					if(statusOfUpdateIntoApplication > 0)
					{
						try{
							LOGGER.info("Updating data in Application Table");
							LOGGER.info("Making a Request to Dao");
						int statusOfUpdateIntoTrainingPartnerRegistration=saveAsDraftAndSubmitDao.updateIntoTrainingPartnerRegistration(profileCreationTrainingPartnerDto);
						LOGGER.info("Response received from Dao");
						if(statusOfUpdateIntoTrainingPartnerRegistration>0)
						{
							return "Success";
						}
						else
						{
							LOGGER.info("Data Not Updated in TP REG");
							return null;
						}
						}
						catch(Exception e)
						{
							e.printStackTrace();
							return null;
						}
					}
					else
					{
						LOGGER.info("Data Not Updated in Application");
						return null;
					}
				}
				
				
				else
				{
					try{
						LOGGER.info("Updating data in Training Partner Registration table");
						LOGGER.info("Making a Request to Dao");
						int statusOfUpdateIntoTrainingPartnerRegistration=saveAsDraftAndSubmitDao.updateIntoTrainingPartnerRegistration(profileCreationTrainingPartnerDto);
						LOGGER.info("Response received from Dao");
						if(statusOfUpdateIntoTrainingPartnerRegistration>0)
						{
							LOGGER.info("IN UPDATE RETURNING SUCCESS");
							return "Success";
						}
						else
						{
							LOGGER.info("Data Not Updated in TP REG");
							return null;
						}
						}
						catch(Exception e)
						{
							e.printStackTrace();
							return null;
						}
				}
	
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return null;
			}

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
