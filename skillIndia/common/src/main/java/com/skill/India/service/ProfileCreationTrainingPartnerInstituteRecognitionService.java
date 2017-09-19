package com.skill.India.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.ProfileCreationTrainingPartnerDeleteDataDao;
import com.skill.India.dao.ProfileCreationTrainingPartnerInsertDataDao;
import com.skill.India.dao.ProfileCreationTrainingPartnerUpdateDataDao;
import com.skill.India.dto.ProfileCreationTrainingPartnerInstituteRecognitionDto;

@Service
public class ProfileCreationTrainingPartnerInstituteRecognitionService {

	@Autowired
	private ProfileCreationTrainingPartnerDeleteDataDao profileCreationTrainingPartnerDeleteDataDao;
	
	@Autowired
	private ProfileCreationTrainingPartnerInsertDataDao profileCreationTrainingPartnerInsertDataDao;
	
	@Autowired
	private ProfileCreationTrainingPartnerUpdateDataDao profileCreationTrainingPartnerUpdateDataDao;
	
	public String setTrainingPartnerInstituteRecognition(HashMap<String, HashMap<String, String>> trainingPartnerInstituteRecognition,HashMap<String, HashMap<String, String>> trainingPartnerInstituteRecognitionDeletes)
	{
		try{
		/*
		 *ProfileCreationTrainingPartnerInstituteRecognitionDto Setting Starts 
		 */
		
		ArrayList<ProfileCreationTrainingPartnerInstituteRecognitionDto> trainingPartnerInstituteRecognitionList=new ArrayList<ProfileCreationTrainingPartnerInstituteRecognitionDto>();
		
		for(Map.Entry<String, HashMap<String, String>> profileCreationTrainingPartnerInstituteRecognitionIterator : trainingPartnerInstituteRecognition.entrySet())
		{
			HashMap<String, String> setProfileCreationTrainingPartnerInstituteRecognitionDto = new HashMap<String, String>();
			setProfileCreationTrainingPartnerInstituteRecognitionDto=profileCreationTrainingPartnerInstituteRecognitionIterator.getValue();
			trainingPartnerInstituteRecognitionList.add(new ProfileCreationTrainingPartnerInstituteRecognitionDto(
					setProfileCreationTrainingPartnerInstituteRecognitionDto.get("instituteRecognitionId"),
					setProfileCreationTrainingPartnerInstituteRecognitionDto.get("trainingPartnerRegistrationId"),
					setProfileCreationTrainingPartnerInstituteRecognitionDto.get("nameOfRecognizingBody"),
					setProfileCreationTrainingPartnerInstituteRecognitionDto.get("recognitionNumber"),
					setProfileCreationTrainingPartnerInstituteRecognitionDto.get("yearOfRecognition"),
					setProfileCreationTrainingPartnerInstituteRecognitionDto.get("validityOfRecognition")
					));
		}
		
		/*
		 * Setting of ProfileCreationTrainingPartnerInstituteRecognitionDto ends 
		 */
		
		/*
		 * No files are coming corresponding to Institute Recognition table so only database will be populated 
		 */
		
		/*
		 * Deleting the records which are deleted by the user  
		 */
		
		for(Map.Entry<String, HashMap<String, String>> deleteTrainingPartnerInstituteRecognition:trainingPartnerInstituteRecognitionDeletes.entrySet())
		{
			HashMap<String, String> deleteInstituteRecognitionRecord=new HashMap<String, String>();
			/*
			 * Getting value in deleteInstituteRecognitionRecord
			 */
			deleteInstituteRecognitionRecord=deleteTrainingPartnerInstituteRecognition.getValue();
			
			/*
			 * Getting value of InstituteRecognitionId from Hashmap
			 */
			String instituteRecognitionId= deleteInstituteRecognitionRecord.get("instituteRecognitionId");
			
			/*
			 * Running delete queries 
			 */
			
			int deleteInstituteRecognitionRecordStatus=profileCreationTrainingPartnerDeleteDataDao.deletefromTrainingPartnerInstituteRecognition(instituteRecognitionId);
			if(deleteInstituteRecognitionRecordStatus==-1)
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
		
		for(int temp=0;temp<trainingPartnerInstituteRecognitionList.size();temp++)
		{
			/*
			 * If in each record instituteRecognitionId is present then run update 
			 * query else run insert query
			 */
			
			if(trainingPartnerInstituteRecognitionList.get(temp).getInstituteRecognitionId()==null)
			{
				/*
				 * Run insert query
				 */
				int insertDataInInstituteRecognitionStatus = profileCreationTrainingPartnerInsertDataDao.insertIntoTrainingPartnerInstituteRecognition(trainingPartnerInstituteRecognitionList.get(temp));
				if(insertDataInInstituteRecognitionStatus==-1)
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
				int updateDataInInstituteRecognitionStatus = profileCreationTrainingPartnerUpdateDataDao.updateIntoTrainingPartnerInstituteRecognition(trainingPartnerInstituteRecognitionList.get(temp));
				if(updateDataInInstituteRecognitionStatus==-1)
				{
					/*
					 * Error updating data in Institute Recognition table
					 */
					return null;
				}
			}
			
		}
		
		/*
		 * Inserting and Updating database table for TrainingPartnerInstituteRecognition ends
		 */
		return null;
		
		}
		catch(Exception e)
		{
			/*
			 * An error occurred while setting data of TrainingPartnerInstituteRecognitionTable
			 */
			e.printStackTrace();
			return null;
		}

	}
}
