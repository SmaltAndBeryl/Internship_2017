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

//	public String saveAsDraftAndSubmit(ProfileCreationTrainingPartnerDto profileCreationTrainingPartnerDto,String type)
//	{
//		LOGGER.debug("Request Received from Controller");
//		LOGGER.debug("In SaveAsDraftAndSubmitService - saveAsDraftAndSubmit");
//		LOGGER.debug("Parameters Received from front end are - 'type': "+type+" 'profileCreationTrainingPartnerDto':",profileCreationTrainingPartnerDto);
//		try{
//			LOGGER.debug("Inside TRY block");
//			
//		if(type.equalsIgnoreCase("submit"))
//		{
//			throw new Exception();
//		}
//		LOGGER.debug("Checking Existense of Training Partner");
//		LOGGER.debug("Making a Request to Dao to get data");
//		int userIdExists=userIdCheckInTrainingPartnerRegistration.userIdCheckInTrainingPartnerRegistration(profileCreationTrainingPartnerDto.getUserId());
//		LOGGER.debug("Response received from Dao");
//		//System.out.println("UserId status : "+userIdExists);
//		if(userIdExists==0)
//		{
//			/*
//			 * i.e. userId doesnt exist in record and user is directly coming from signup process
//			 * Things need to be done here :
//			 *  1) Set data in Application table
//			 *  2) Get ApplicationId from there
//			 *  3) Set data in TPREG table(insert query)
//			 */
//			try{
//				LOGGER.debug("Inserting data in Application Table");
//				LOGGER.debug("Making a Request to Dao");
//				int statusOfInsertIntoApplication=saveAsDraftAndSubmitDao.insertIntoApplication(profileCreationTrainingPartnerDto.getUserId(),type);
//				LOGGER.debug("Response received from Dao");
//				/*
//				 *  -1 is returned if an exception occurs
//				 */
//				if(statusOfInsertIntoApplication>0)
//				{
//					/*
//					 * Getting ApplicationId from Application Table
//					 */
//					try{
//					//int applicationId=sessionUserUtility.getApplicationId(profileCreationTrainingPartnerDto.getUserId());
//					}
//					catch(Exception e)
//					{
//
//						LOGGER.debug("Inside CATCH block");
//						LOGGER.error("ERROR: Exception is - ",e);
//						LOGGER.debug("Returning NULL");
////						e.printStackTrace();
//						return null;
//					}
//					try{
//						LOGGER.debug("Inserting data in Training Partner Registration table");
//						LOGGER.debug("Making a Request to Dao");
//					//int statusOfInsertIntoTrainingPartnerRegistration=saveAsDraftAndSubmitDao.insertIntoTrainingPartnerRegistration(profileCreationTrainingPartnerDto);
//					LOGGER.debug("Response received from Dao");
//					if(statusOfInsertIntoTrainingPartnerRegistration>0)
//					{
//						return "Success";
//					}
//					else
//					{
//						LOGGER.debug("Data Not Inserted in TP REG");
//						return null;
//					}
//
//					}
//					catch(Exception e)
//					{
//
//						LOGGER.debug("Inside CATCH block");
//						LOGGER.error("ERROR: Exception is - ",e);
//						LOGGER.debug("Returning NULL");
////						e.printStackTrace();
//						return null;
//					}
//
//				}
//				else
//				{
//					LOGGER.debug("Data Not Inserted in Application");
//					return null;
//				}
//
//			}
//			catch(Exception e)
//			{
////				LOGGER.debug("inside CATCH block");
//
//				LOGGER.debug("Inside CATCH block");
//				LOGGER.error("ERROR: Exception is - ",e);
//				LOGGER.debug("Returning NULL");
////				e.printStackTrace();
//				return null;
//			}
//
//		}
//
//		else if(userIdExists==1)
//		{
//			/*
//			 * User is coming from sign In process and form is incomplete and run update query
//			 */
//
//			try{
//				if(type.equalsIgnoreCase("Submit"))
//				{
//					LOGGER.debug("Updating data in Application Table");
//					LOGGER.debug("Making a Request to Dao");
//					int statusOfUpdateIntoApplication=saveAsDraftAndSubmitDao.updateIntoApplication(profileCreationTrainingPartnerDto,type);
//					LOGGER.debug("Response received from Dao");
//					if(statusOfUpdateIntoApplication > 0)
//					{
//						try{
//							LOGGER.debug("Updating data in Application Table");
//							LOGGER.debug("Making a Request to Dao");
//						int statusOfUpdateIntoTrainingPartnerRegistration=saveAsDraftAndSubmitDao.updateIntoTrainingPartnerRegistration(profileCreationTrainingPartnerDto);
//						LOGGER.debug("Response received from Dao");
//						if(statusOfUpdateIntoTrainingPartnerRegistration>0)
//						{
//							return "Success";
//						}
//						else
//						{
//							LOGGER.debug("Data Not Updated in TP REG");
//							return null;
//						}
//						}
//						catch(Exception e)
//						{
//							e.printStackTrace();
//							return null;
//						}
//					}
//					else
//					{
//						LOGGER.debug("Data Not Updated in Application");
//						return null;
//					}
//				}
//				
//				
//				else
//				{
//					try{
//						LOGGER.debug("Updating data in Training Partner Registration table");
//						LOGGER.debug("Making a Request to Dao");
//						int statusOfUpdateIntoTrainingPartnerRegistration=saveAsDraftAndSubmitDao.updateIntoTrainingPartnerRegistration(profileCreationTrainingPartnerDto);
//						LOGGER.debug("Response received from Dao");
//						if(statusOfUpdateIntoTrainingPartnerRegistration>0)
//						{
//							LOGGER.debug("IN UPDATE RETURNING SUCCESS");
//							return "Success";
//						}
//						else
//						{
//							LOGGER.debug("Data Not Updated in TP REG");
//							return null;
//						}
//						}
//						catch(Exception e)
//						{
//
//							LOGGER.debug("Inside CATCH block");
//							LOGGER.error("ERROR: Exception is - ",e);
//							LOGGER.debug("Returning NULL");
//							
////							e.printStackTrace();
//							return null;
//						}
//				}
//	
//			}
//			catch(Exception e)
//			{
//
//				LOGGER.debug("Inside CATCH block");
//				LOGGER.error("ERROR: Exception is - ",e);
//				LOGGER.debug("Returning NULL");
////				e.printStackTrace();
//				return null;
//			}
//
//		}
//		return null;
//	}
//		catch(Exception e)
//		{
//			LOGGER.debug("Inside CATCH block");
//			LOGGER.error("ERROR: Exception is - ",e);
//			LOGGER.debug("Returning NULL");
//			e.printStackTrace();
//			return null;
//		}
	//}
	
}
