package com.skill.India.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.ProfileCreationTrainingPartnerDeleteDataDao;
import com.skill.India.dao.ProfileCreationTrainingPartnerInsertDataDao;
import com.skill.India.dao.ProfileCreationTrainingPartnerUpdateDataDao;
import com.skill.India.dto.ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto;

@Service
public class ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingService {

	@Autowired
	private ProfileCreationTrainingPartnerDeleteDataDao profileCreationTrainingPartnerDeleteDataDao;
	
	@Autowired
	private ProfileCreationTrainingPartnerInsertDataDao profileCreationTrainingPartnerInsertDataDao;
	
	@Autowired
	private ProfileCreationTrainingPartnerUpdateDataDao profileCreationTrainingPartnerUpdateDataDao;
	
	
	public String setTrainingPartnerPriorExperienceInSkillTraining(HashMap<String, HashMap<String, String>> trainingPartnerPriorExperienceInSkillTraining,HashMap<String, HashMap<String, String>> trainingPartnerPriorExperienceInSkillTrainingDeletes)
	{
		try{
		/*
		 * ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto Setting Starts
		 */
		
		ArrayList<ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto> trainingPartnerPriorExperienceInSkillTrainingList = new ArrayList<ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto>();
		
		for(Map.Entry<String, HashMap<String, String>> profileCreationTrainingPartnerPriorExperienceInSkillTrainingIterator : trainingPartnerPriorExperienceInSkillTraining.entrySet())
		{
		HashMap<String, String> setProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto = new HashMap<String, String>();
		setProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto=profileCreationTrainingPartnerPriorExperienceInSkillTrainingIterator.getValue();
		trainingPartnerPriorExperienceInSkillTrainingList.add(new ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto(
				setProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto.get("priorExperienceInSkillTrainingId"),
				setProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto.get("trainingPartnerRegistrationId"),
				setProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto.get("courseName"),
				setProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto.get("numberOfBatchesPerYear"),
				setProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto.get("numberOfStudentsInEachBatch")	
				));
		}
		
		/*
		 * Setting of ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto Ends
		 */
		
		/*
		 * No files are coming corresponding to PriorExperienceInSkillTraining table so only database will be populated 
		 */
		
		/*
		 * Deleting the records which are deleted by the user  
		 */
		
		for(Map.Entry<String, HashMap<String, String>> deleteTrainingPartnerPriorExperienceInSkillTraining:trainingPartnerPriorExperienceInSkillTrainingDeletes.entrySet())
		{
			HashMap<String, String> deletePriorExperienceInSkillTrainingRecord=new HashMap<String, String>();
			/*
			 * Getting value in deletePriorExperienceInSkillTrainingRecord
			 */
			deletePriorExperienceInSkillTrainingRecord=deleteTrainingPartnerPriorExperienceInSkillTraining.getValue();
			
			/*
			 * Getting value of PriorExperienceInSkillTrainingId from Hashmap
			 */
			String priorExperienceInSkillTrainingId= deletePriorExperienceInSkillTrainingRecord.get("priorExperienceInSkillTrainingId");
			
			/*
			 * Running delete queries 
			 */
			
			int deletePriorExperienceInSkillTrainingRecordStatus=profileCreationTrainingPartnerDeleteDataDao.deletefromTrainingPartnerPriorExperienceInSkillTraining(priorExperienceInSkillTrainingId);
			if(deletePriorExperienceInSkillTrainingRecordStatus==-1)
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
		
		for(int temp=0;temp<trainingPartnerPriorExperienceInSkillTrainingList.size();temp++)
		{
			/*
			 * If in each record priorExperienceInSkillTrainingId is present then run update 
			 * query else run insert query
			 */
			
			if(trainingPartnerPriorExperienceInSkillTrainingList.get(temp).getPriorExperienceInSkillTrainingId()==null)
			{
				/*
				 * Run insert query
				 */
				int insertDataInPriorExperienceInSkillTrainingStatus = profileCreationTrainingPartnerInsertDataDao.insertIntoTrainingPartnerPriorExperienceInSkillTraining(trainingPartnerPriorExperienceInSkillTrainingList.get(temp));
				if(insertDataInPriorExperienceInSkillTrainingStatus==-1)
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
				int updateDataInPriorExperienceInSkillTrainingStatus = profileCreationTrainingPartnerUpdateDataDao.updateIntoTrainingPartnerPriorExperienceInSkillTraining(trainingPartnerPriorExperienceInSkillTrainingList.get(temp));
				if(updateDataInPriorExperienceInSkillTrainingStatus==-1)
				{
					/*
					 * Error updating data in PriorExperienceInSkillTraining table
					 */
					return null;
				}
			}
			
		}
		
		/*
		 * Inserting and Updating database table for TrainingPartnerPriorExperienceInSkillTraining ends
		 */

		return null;
		}
		catch(Exception e)
		{
			/*
			 * An Exception occurred while setting data for TrainingPartnerPriorExperienceInSkillTraining table 
			 */
			e.printStackTrace();
			return null;
		}
	}
}
