package com.skill.India.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.ProfileCreationAssessmentBodyDeleteDataDao;
import com.skill.India.dao.ProfileCreationAssessmentBodyInsertDataDao;
import com.skill.India.dao.ProfileCreationAssessmentBodyUpdateDataDao;
import com.skill.India.dto.ProfileCreationAssessmentBodyAffiliationDetailsDto;

@Service
public class ProfileCreationAssessmentBodyAffiliationDetailsService {


	@Autowired
	private ProfileCreationAssessmentBodyDeleteDataDao profileCreationAssessmentBodyDeleteDataDao;
	
	@Autowired
	private ProfileCreationAssessmentBodyUpdateDataDao profileCreationAssessmentBodyUpdateDataDao;
	
	@Autowired
	private ProfileCreationAssessmentBodyInsertDataDao profileCreationAssessmentBodyInsertDataDao;
	
	
	public String setAssessmentBodyAffiliationDetails(HashMap<String, HashMap<String, String>> assessmentBodyAffiliationDetails,HashMap<String, HashMap<String, String>> assessmentBodyAffiliationDetailsDeletes)
	{
		try{
		/*
		 * ProfileCreationAssessmentBodyAffiliationDetailsDto Setting Starts
		 */
		
		ArrayList<ProfileCreationAssessmentBodyAffiliationDetailsDto> assessmentBodyAffiliationDetailsList = new ArrayList<ProfileCreationAssessmentBodyAffiliationDetailsDto>();
		
		for(Map.Entry<String, HashMap<String, String>> profileCreationAssessmentBodyAffiliationDetailsIterator : assessmentBodyAffiliationDetails.entrySet())
		{
		HashMap<String, String> setProfileCreationAssessmentBodyAffiliationDetailsDto = new HashMap<String, String>();
		setProfileCreationAssessmentBodyAffiliationDetailsDto=profileCreationAssessmentBodyAffiliationDetailsIterator.getValue();
		assessmentBodyAffiliationDetailsList.add(new ProfileCreationAssessmentBodyAffiliationDetailsDto(
				setProfileCreationAssessmentBodyAffiliationDetailsDto.get("affiliationId"),
				setProfileCreationAssessmentBodyAffiliationDetailsDto.get("assessmentBodyRegistrationId"),
				setProfileCreationAssessmentBodyAffiliationDetailsDto.get("nameOfSectorSkillCouncil")

				));
		}
		
		/*
		 * Setting of ProfileCreationAssessmentBodyAffiliationDetailsDto Ends Here
		 */
		
		/*
		 * Deleting the records which are deleted by the user  
		 */
		
		for(Map.Entry<String, HashMap<String, String>> deleteAssessmentBodyAffiliationDetails:assessmentBodyAffiliationDetailsDeletes.entrySet())
		{
			HashMap<String, String> deleteAssessmentBodyAffiliationDetailsRecord=new HashMap<String, String>();
			
			/*
			 * Getting value in deleteAssessmentBodyAffiliationDetailsRecord
			 */
			
			deleteAssessmentBodyAffiliationDetailsRecord = deleteAssessmentBodyAffiliationDetails.getValue();
		
			/*
			 * Getting value of affiliationId
			 */
			
			String affiliationId = deleteAssessmentBodyAffiliationDetailsRecord.get("affiliationId");
			
			/*
			 * Running delete queries 
			 */
			
			int deleteAssessmentBodyAffiliationDetailsRecordStatus = profileCreationAssessmentBodyDeleteDataDao.deleteFromAssessmentBodyAffiliationDetails(affiliationId);
			if(deleteAssessmentBodyAffiliationDetailsRecordStatus==-1)
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
		
		for(int temp=0;temp<assessmentBodyAffiliationDetailsList.size();temp++)
		{
			if(assessmentBodyAffiliationDetailsList.get(temp).getAffiliationId()==null)
			{
				/*
				 * Run insert query
				 */
				int insertIntoAssessmentBodyAffiliationDetailsStatus = profileCreationAssessmentBodyInsertDataDao.insertIntoAssessmentBodyAffiliationDetails(assessmentBodyAffiliationDetailsList.get(temp));
				if(insertIntoAssessmentBodyAffiliationDetailsStatus==-1)
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
				
				int updateIntoAssessmentBodyAffiliationDetailsStatus = profileCreationAssessmentBodyUpdateDataDao.updateIntoAssessmentBodyAffiliationDetails(assessmentBodyAffiliationDetailsList.get(temp));
				if(updateIntoAssessmentBodyAffiliationDetailsStatus==-1)
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
			 * An exception occurred while deleting or inserting data in database
			 */
			e.printStackTrace();
			return null;
		}
	}
}
