package com.skill.India.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.ProfileCreationAssessmentBodyDeleteDataDao;
import com.skill.India.dao.ProfileCreationAssessmentBodyInsertDataDao;
import com.skill.India.dao.ProfileCreationAssessmentBodyUpdateDataDao;
import com.skill.India.dto.ProfileCreationAssessmentBodyRecognitionsDto;

@Service
public class ProfileCreationAssessmentBodyRecognitionsService {

	@Autowired
	private ProfileCreationAssessmentBodyDeleteDataDao profileCreationAssessmentBodyDeleteDataDao;
	
	@Autowired
	private ProfileCreationAssessmentBodyUpdateDataDao profileCreationAssessmentBodyUpdateDataDao;
	
	@Autowired
	private ProfileCreationAssessmentBodyInsertDataDao profileCreationAssessmentBodyInsertDataDao;
	
	
	public String setAssessmentBodyRecognitions(HashMap<String, HashMap<String, String>> assessmentBodyRecognitions,HashMap<String, HashMap<String, String>> assessmentBodyRecognitionsDeletes)
	{
		try{
		/*
		 * ProfileCreationAssessmentBodyRecognitionsDto Setting Starts
		 */
		
		ArrayList<ProfileCreationAssessmentBodyRecognitionsDto> assessmentBodyRecognitionsList = new ArrayList<ProfileCreationAssessmentBodyRecognitionsDto>();
		
		for(Map.Entry<String, HashMap<String, String>> profileCreationAssessmentBodyRecognitionsIterator : assessmentBodyRecognitions.entrySet())
		{
		HashMap<String, String> setProfileCreationAssessmentBodyRecognitionsDto = new HashMap<String, String>();
		setProfileCreationAssessmentBodyRecognitionsDto=profileCreationAssessmentBodyRecognitionsIterator.getValue();
		assessmentBodyRecognitionsList.add(new ProfileCreationAssessmentBodyRecognitionsDto(
				setProfileCreationAssessmentBodyRecognitionsDto.get("assessmentBodyRecognitionId"),
				setProfileCreationAssessmentBodyRecognitionsDto.get("assessmentBodyRegistrationId"),
				setProfileCreationAssessmentBodyRecognitionsDto.get("nameOfRecognitionBody"),
				setProfileCreationAssessmentBodyRecognitionsDto.get("recognitionNumber"),
				setProfileCreationAssessmentBodyRecognitionsDto.get("yearOfRecognition"),
				setProfileCreationAssessmentBodyRecognitionsDto.get("validityOfRecognition")
				));
		}
		
		/*
		 * Setting of ProfileCreationAssessmentBodyRecognitionsDto Ends Here
		 */
		
		/*
		 * No files are coming corresponding to Institute Grant table so only database will be populated 
		 */
		
		/*
		 * Deleting the records which are deleted by the user  
		 */
		
		for(Map.Entry<String, HashMap<String, String>> deleteAssessmentBodyRecognitions:assessmentBodyRecognitionsDeletes.entrySet())
		{
			HashMap<String, String> deleteAssessmentBodyRecognitionsRecord=new HashMap<String, String>();
			
			/*
			 * Getting value in deleteAssessmentBodyRecognitionsRecord
			 */
			
			deleteAssessmentBodyRecognitionsRecord = deleteAssessmentBodyRecognitions.getValue();
		
			/*
			 * Getting value of assessmentBodyRecognitionId
			 */
			
			String assessmentBodyRecognitionId = deleteAssessmentBodyRecognitionsRecord.get("assessmentBodyRecognitionId");
			
			/*
			 * Running delete queries 
			 */
			
			int deleteAssessmentBodyRecognitionsRecordStatus = profileCreationAssessmentBodyDeleteDataDao.deleteFromAssessmentBodyRecognitions(assessmentBodyRecognitionId);
			if(deleteAssessmentBodyRecognitionsRecordStatus==-1)
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
		
		for(int temp=0;temp<assessmentBodyRecognitionsList.size();temp++)
		{
			if(assessmentBodyRecognitionsList.get(temp).getAssessmentBodyRecognitionId()==null)
			{
				/*
				 * Run insert query
				 */
				int insertIntoAssessmentBodyRecognitionStatus = profileCreationAssessmentBodyInsertDataDao.insertIntoAssessmentBodyRecognitions(assessmentBodyRecognitionsList.get(temp));
				if(insertIntoAssessmentBodyRecognitionStatus==-1)
				{
					/*
					 * AN error occurred while inserting data in database 
					 */
					return null;
				}
			}
			else
			{
				/*
				 * Run update query
				 */
				
				int updateIntoAssessmentBodyRecognitionStatus = profileCreationAssessmentBodyUpdateDataDao.updateIntoAssessmentBodyRecognitions(assessmentBodyRecognitionsList.get(temp));
				if(updateIntoAssessmentBodyRecognitionStatus==-1)
				{
					/*
					 * An error occurred while updating data in database
					 */
					return null;
				}
			}
		}
		/*
		 * End of inserting data in database 
		 */
		
		
		return null;
		}
		catch(Exception e)
		{
			/*
			 * An exception occurred while deleting and setting data in database 
			 * for AssessmentBodyRecognitions
			 */
			
			e.printStackTrace();
			return null;
		}
	}
}
