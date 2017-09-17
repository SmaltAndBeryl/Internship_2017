package com.skill.India.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.ProfileCreationTrainingPartnerDeleteDataDao;
import com.skill.India.dao.ProfileCreationTrainingPartnerInsertDataDao;
import com.skill.India.dao.ProfileCreationTrainingPartnerUpdateDataDao;
import com.skill.India.dto.ProfileCreationTrainingPartnerInstituteGrantDto;

@Service
public class ProfileCreationTrainingPartnerInstituteGrantService {

	@Autowired
	private ProfileCreationTrainingPartnerDeleteDataDao profileCreationTrainingPartnerDeleteDataDao;
	
	@Autowired
	private ProfileCreationTrainingPartnerInsertDataDao profileCreationTrainingPartnerInsertDataDao;
	
	@Autowired
	private ProfileCreationTrainingPartnerUpdateDataDao profileCreationTrainingPartnerUpdateDataDao;
	
	public String setTrainingPartnerInstituteGrant(HashMap<String, HashMap<String, String>> trainingPartnerInstituteGrant,HashMap<String, HashMap<String, String>> trainingPartnerInstituteGrantDeletes)
	{
		try{
		/*
		 * ProfileCreationTrainingPartnerInstituteGrantDto Setting Starts
		 */
		
		ArrayList<ProfileCreationTrainingPartnerInstituteGrantDto> trainingPartnerInstituteGrantList = new ArrayList<ProfileCreationTrainingPartnerInstituteGrantDto>();
		
		for(Map.Entry<String, HashMap<String, String>> profileCreationTrainingPartnerInstituteGrantIterator : trainingPartnerInstituteGrant.entrySet())
		{
			/*
			 * Setting the incoming data in  respective DTO's ProfileCreationTrainingPartnerInstituteGrantDto
			 */
			HashMap<String, String> setProfileCreationTrainingPartnerInstituteGrantDto=new HashMap<String, String>();
			setProfileCreationTrainingPartnerInstituteGrantDto=profileCreationTrainingPartnerInstituteGrantIterator.getValue();
			trainingPartnerInstituteGrantList.add(new ProfileCreationTrainingPartnerInstituteGrantDto(
					setProfileCreationTrainingPartnerInstituteGrantDto.get("instituteGrantId"),
					setProfileCreationTrainingPartnerInstituteGrantDto.get("trainingPartnerRegistrationId"),
					setProfileCreationTrainingPartnerInstituteGrantDto.get("nameOfMinistry"),
					setProfileCreationTrainingPartnerInstituteGrantDto.get("natureOfWork"),
					setProfileCreationTrainingPartnerInstituteGrantDto.get("remarks")
					));	
		}
		
		/*
		 * Setting of ProfileCreationTrainingPartnerInstituteGrantDto ends
		 */
		
		/*
		 * No files are coming corresponding to Institute Grant table so only database will be populated 
		 */
		
		/*
		 * Deleting the records which are deleted by the user  
		 */
		
		for(Map.Entry<String, HashMap<String, String>> deleteTrainingPartnerInstituteGrant:trainingPartnerInstituteGrantDeletes.entrySet())
		{
			HashMap<String, String> deleteInstituteGrantRecord=new HashMap<String, String>();
			/*
			 * Getting value in deleteInstituteGrantRecord
			 */
			deleteInstituteGrantRecord=deleteTrainingPartnerInstituteGrant.getValue();
			
			/*
			 * Getting value of InstituteGrantId from Hashmap
			 */
			String instituteGrantId= deleteInstituteGrantRecord.get("instituteGrantId");
			
			/*
			 * Running delete queries 
			 */
			
			int deleteInstituteGrantRecordStatus=profileCreationTrainingPartnerDeleteDataDao.deletefromTrainingPartnerInstituteGrant(instituteGrantId);
			if(deleteInstituteGrantRecordStatus==-1)
			{
				/*
				 * An error occurred while deleting record 
				 */
				return null;
			}		
		}
		
		/*
		 * Deletion of record ends here
		 */
		
		/*
		 * Inserting or updating data in Database 
		 */
		
		for(int temp=0;temp<trainingPartnerInstituteGrantList.size();temp++)
		{
			/*
			 * If in each record instituteGrantId is present then run update 
			 * query else run insert query
			 */
			
			if(trainingPartnerInstituteGrantList.get(temp).getInstituteGrantId()==null)
			{
				/*
				 * Run insert query
				 */
				int insertDataInInstituteGrantStatus = profileCreationTrainingPartnerInsertDataDao.insertIntoTrainingPartnerInstituteGrant(trainingPartnerInstituteGrantList.get(temp));
				if(insertDataInInstituteGrantStatus==-1)
				{
					/*
					 * Error occurred while inserting data 
					 */
					return  null;
				}
			}
			else
			{
				/*
				 * Run update query
				 */
				int updateDataInInstituteGrantStatus = profileCreationTrainingPartnerUpdateDataDao.updateIntoTrainingPartnerInstituteGrant(trainingPartnerInstituteGrantList.get(temp));
				if(updateDataInInstituteGrantStatus==-1)
				{
					/*
					 * Error updating data in Institute Grant table
					 */
					return null;
				}
			}
			
		}
		
		/*
		 * Inserting and Updating database table for TrainingPartnerInstituteGrant ends
		 */
		
		return null;
		}
		catch(Exception e)
		{
			/*
			 * An error occurred while setting data for InstituteGrant table
			 */
			e.printStackTrace();
			return null;
		}
		
	}
}
