package com.skill.India.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.ProfileCreationAssessmentBodyDeleteDataDao;
import com.skill.India.dao.ProfileCreationAssessmentBodyInsertDataDao;
import com.skill.India.dao.ProfileCreationAssessmentBodyUpdateDataDao;
import com.skill.India.dto.ProfileCreationAssessmentBodyRegionalOfficeDetailsDto;

@Service
public class ProfileCreationAssessmentBodyRegionalOfficeDetailsService {

	@Autowired
	private ProfileCreationAssessmentBodyDeleteDataDao profileCreationAssessmentBodyDeleteDataDao;
	
	@Autowired
	private ProfileCreationAssessmentBodyUpdateDataDao profileCreationAssessmentBodyUpdateDataDao;
	
	@Autowired
	private ProfileCreationAssessmentBodyInsertDataDao profileCreationAssessmentBodyInsertDataDao;
	
	
	public String setAssessmentBodyRegionalOfficeDetails(HashMap<String, HashMap<String, String>> assessmentBodyRegionalOfficeDetails,HashMap<String, HashMap<String, String>> assessmentBodyRegionalOfficeDetailsDeletes)
	{
		try{
		/*
		 * ProfileCreationAssessmentBodyRegionalOfficeDetailsDto Setting Starts
		 */
		
		ArrayList<ProfileCreationAssessmentBodyRegionalOfficeDetailsDto> assessmentBodyRegionalOfficeDetailsList = new ArrayList<ProfileCreationAssessmentBodyRegionalOfficeDetailsDto>();
		
		for(Map.Entry<String, HashMap<String, String>> profileCreationAssessmentBodyRegionalOfficeDetailsIterator : assessmentBodyRegionalOfficeDetails.entrySet())
		{
		HashMap<String, String> setProfileCreationAssessmentBodyRegionalOfficeDetailsDto = new HashMap<String, String>();
		setProfileCreationAssessmentBodyRegionalOfficeDetailsDto=profileCreationAssessmentBodyRegionalOfficeDetailsIterator.getValue();
		assessmentBodyRegionalOfficeDetailsList.add(new ProfileCreationAssessmentBodyRegionalOfficeDetailsDto(
				setProfileCreationAssessmentBodyRegionalOfficeDetailsDto.get("regionalOfficeId"),
				setProfileCreationAssessmentBodyRegionalOfficeDetailsDto.get("assessmentBodyRegistrationId"),
				setProfileCreationAssessmentBodyRegionalOfficeDetailsDto.get("address"),
				setProfileCreationAssessmentBodyRegionalOfficeDetailsDto.get("state"),
				setProfileCreationAssessmentBodyRegionalOfficeDetailsDto.get("pincode"),
				setProfileCreationAssessmentBodyRegionalOfficeDetailsDto.get("contactNumber"),
				setProfileCreationAssessmentBodyRegionalOfficeDetailsDto.get("alternateContactNumber")
				));
		}
		
		/*
		 * Setting of ProfileCreationAssessmentBodyRegionalOfficeDetailsDto Ends Here
		 */
		
		/*
		 * No files are coming corresponding to Institute Grant table so only database will be populated 
		 */
		
		/*
		 * Deleting the records which are deleted by the user  
		 */
		
		for(Map.Entry<String, HashMap<String, String>> deleteAssessmentBodyRegionalOfficeDetails:assessmentBodyRegionalOfficeDetailsDeletes.entrySet())
		{
			HashMap<String, String> deleteAssessmentBodyRegionalOfficeDetailsRecord=new HashMap<String, String>();
			
			/*
			 * Getting value in deleteAssessmentBodyRegionalOfficeDetailsRecord
			 */
			
			deleteAssessmentBodyRegionalOfficeDetailsRecord = deleteAssessmentBodyRegionalOfficeDetails.getValue();
		
			/*
			 * Getting value of regionalOfficeId
			 */
			
			String regionalOfficeId = deleteAssessmentBodyRegionalOfficeDetailsRecord.get("regionalOfficeId");
			
			/*
			 * Running delete queries 
			 */
			
			int deleteAssessmentBodyRegionalOfficeDetailsRecordStatus = profileCreationAssessmentBodyDeleteDataDao.deleteFromAssessmentBodyRegionalOfficeDetails(regionalOfficeId);
			if(deleteAssessmentBodyRegionalOfficeDetailsRecordStatus==-1)
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
		
		for(int temp=0;temp<assessmentBodyRegionalOfficeDetailsList.size();temp++)
		{
			if(assessmentBodyRegionalOfficeDetailsList.get(temp).getRegionalOfficeId()==null)
			{
				/*
				 * Run insert query
				 */
				int insertIntoAssessmentBodyRegionalOfficeDetailsStatus = profileCreationAssessmentBodyInsertDataDao.insertIntoAssessmentBodyRegionalOfficeDetails(assessmentBodyRegionalOfficeDetailsList.get(temp));
				if(insertIntoAssessmentBodyRegionalOfficeDetailsStatus==-1)
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
				
				int updateIntoAssessmentBodyRegionalOfficeDetailsStatus = profileCreationAssessmentBodyUpdateDataDao.updateIntoAssessmentBodyRegionalOfficeDetails(assessmentBodyRegionalOfficeDetailsList.get(temp));
				if(updateIntoAssessmentBodyRegionalOfficeDetailsStatus==-1)
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
			 * An error occurred while deleting or inserting data in database
			 */
			
			e.printStackTrace();
			return null;
		}
	}
}
