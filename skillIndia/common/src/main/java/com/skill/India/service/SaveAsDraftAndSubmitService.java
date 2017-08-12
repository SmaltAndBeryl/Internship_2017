package com.skill.India.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.common.SessionUserUtility;
import com.skill.India.common.UserIdCheckInTrainingPartnerRegistration;
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

	public String saveAsDraftAndSubmit(ProfileCreationTrainingPartnerDto profileCreationTrainingPartnerDto,String type)
	{
		try{
			
		if(type.equalsIgnoreCase("submit"))
		{
			throw new Exception();
		}
		
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

				int statusOfInsertIntoApplication=saveAsDraftAndSubmitDao.insertIntoApplication(profileCreationTrainingPartnerDto.getUserId(),type);
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
					int statusOfInsertIntoTrainingPartnerRegistration=saveAsDraftAndSubmitDao.insertIntoTrainingPartnerRegistration(profileCreationTrainingPartnerDto);
					if(statusOfInsertIntoTrainingPartnerRegistration>0)
					{
						return "Success";
					}
					else
					{
						System.out.println("Data Not Inserted in TP REG");
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
					System.out.println("Data Not Inserted in Application");
					return null;
				}

			}
			catch(Exception e)
			{
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
					int statusOfUpdateIntoApplication=saveAsDraftAndSubmitDao.updateIntoApplication(profileCreationTrainingPartnerDto,type);
					if(statusOfUpdateIntoApplication > 0)
					{
						try{
						int statusOfUpdateIntoTrainingPartnerRegistration=saveAsDraftAndSubmitDao.updateIntoTrainingPartnerRegistration(profileCreationTrainingPartnerDto);
						if(statusOfUpdateIntoTrainingPartnerRegistration>0)
						{
							return "Success";
						}
						else
						{
							System.out.println("Data Not Updated in TP REG");
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
						System.out.println("Data Not Updated in Application");
						return null;
					}
				}
				
				
				else
				{
					try{
						int statusOfUpdateIntoTrainingPartnerRegistration=saveAsDraftAndSubmitDao.updateIntoTrainingPartnerRegistration(profileCreationTrainingPartnerDto);
						if(statusOfUpdateIntoTrainingPartnerRegistration>0)
						{
							System.out.println("IN UPDATE RETURNING SUCCESS");
							return "Success";
						}
						else
						{
							System.out.println("Data Not Updated in TP REG");
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
