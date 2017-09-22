package com.skill.India.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.ProfileCreationAssessmentBodyDeleteDataDao;
import com.skill.India.dao.ProfileCreationAssessmentBodyInsertDataDao;
import com.skill.India.dao.ProfileCreationAssessmentBodyUpdateDataDao;
import com.skill.India.dto.ProfileCreationAssessmentsExperienceInTechnicalDomainDto;

@Service
public class ProfileCreationAssessmentsExperienceInTechnicalDomainService {

	@Autowired
	private ProfileCreationAssessmentBodyDeleteDataDao profileCreationAssessmentBodyDeleteDataDao;
	
	@Autowired
	private ProfileCreationAssessmentBodyUpdateDataDao profileCreationAssessmentBodyUpdateDataDao;
	
	@Autowired
	private ProfileCreationAssessmentBodyInsertDataDao profileCreationAssessmentBodyInsertDataDao;
	
	
	public String setAssessmentsExperienceInTechnicalDomain(HashMap<String, HashMap<String, String>> assessmentsExperienceInTechnicalDomain,HashMap<String, HashMap<String, String>> assessmentsExperienceInTechnicalDomainDeletes)
	{
		try{
		/*
		 * ProfileCreationAssessmentsExperienceInTechnicalDomainDto Setting Starts
		 */
		
		ArrayList<ProfileCreationAssessmentsExperienceInTechnicalDomainDto> assessmentsExperienceInTechnicalDomainList = new ArrayList<ProfileCreationAssessmentsExperienceInTechnicalDomainDto>();
		
		for(Map.Entry<String, HashMap<String, String>> profileCreationAssessmentsExperienceInTechnicalDomainIterator : assessmentsExperienceInTechnicalDomain.entrySet())
		{
		HashMap<String, String> setProfileCreationAssessmentsExperienceInTechnicalDomainDto = new HashMap<String, String>();
		setProfileCreationAssessmentsExperienceInTechnicalDomainDto=profileCreationAssessmentsExperienceInTechnicalDomainIterator.getValue();
		assessmentsExperienceInTechnicalDomainList.add(new ProfileCreationAssessmentsExperienceInTechnicalDomainDto(
				setProfileCreationAssessmentsExperienceInTechnicalDomainDto.get("assessmentExperienceId"),
				setProfileCreationAssessmentsExperienceInTechnicalDomainDto.get("assessmentBodyRegistrationId"),
				setProfileCreationAssessmentsExperienceInTechnicalDomainDto.get("domain"),
				setProfileCreationAssessmentsExperienceInTechnicalDomainDto.get("numberOfAssessmentsDone")
				));
		}
		
		/*
		 * Setting of ProfileCreationAssessmentsExperienceInTechnicalDomainDto Ends Here
		 */
		/*
		 * No files are coming corresponding to Institute Grant table so only database will be populated 
		 */
		
		/*
		 * Deleting the records which are deleted by the user  
		 */
		
		for(Map.Entry<String, HashMap<String, String>> deleteAssessmentsExperienceInTechnicalDomain:assessmentsExperienceInTechnicalDomainDeletes.entrySet())
		{
			HashMap<String, String> deleteAssessmentsExperienceInTechnicalDomainRecord=new HashMap<String, String>();
			
			/*
			 * Getting value in deleteAssessmentsExperienceInTechnicalDomainRecord
			 */
			
			deleteAssessmentsExperienceInTechnicalDomainRecord = deleteAssessmentsExperienceInTechnicalDomain.getValue();
		
			/*
			 * Getting value of assessmentBodyRecognitionId
			 */
			
			String assessmentExperienceId = deleteAssessmentsExperienceInTechnicalDomainRecord.get("assessmentExperienceId");
			
			/*
			 * Running delete queries 
			 */
			
			int deleteAssessmentsExperienceInTechnicalDomainRecordStatus = profileCreationAssessmentBodyDeleteDataDao.deleteFromAssessmentsExperienceInTechnicalDomain(assessmentExperienceId);
			if(deleteAssessmentsExperienceInTechnicalDomainRecordStatus==-1)
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
		
		for(int temp=0;temp<assessmentsExperienceInTechnicalDomain.size();temp++)
		{
			if(assessmentsExperienceInTechnicalDomainList.get(temp).getAssessmentExperienceId()==null)
			{
				/*
				 * Run insert query
				 */
				int insertIntoAssessmentsExperienceInTechnicalDomainStatus = profileCreationAssessmentBodyInsertDataDao.insertIntoAssessmentsExperienceInTechnicalDomain(assessmentsExperienceInTechnicalDomainList.get(temp));
				if(insertIntoAssessmentsExperienceInTechnicalDomainStatus==-1)
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
				
				int updateIntoAssessmentsExperienceInTechnicalDomainStatus = profileCreationAssessmentBodyUpdateDataDao.updateIntoAssessmentsExperienceInTechnicalDomain(assessmentsExperienceInTechnicalDomainList.get(temp));
				if(updateIntoAssessmentsExperienceInTechnicalDomainStatus==-1)
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
			 * for AssessmentsExperienceInTechnicalDomain
			 */
			e.printStackTrace();
			return null;
		}
	}
}
