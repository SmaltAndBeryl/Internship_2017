package com.skill.India.service;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.skill.India.dao.ProfileCreationAssessmentBodyInsertDataDao;
import com.skill.India.dao.ProfileCreationAssessmentBodyUpdateDataDao;
import com.skill.India.dto.ProfileCreationAssessmentBodyRegistrationDetailsDto;

@Service
public class ProfileCreationAssessmentBodyRegistrationDetailsService {

	@Autowired
	private ProfileCreationSaveFile profileCreationSaveFile;
	
	@Autowired
	private ProfileCreationAssessmentBodyInsertDataDao profileCreationAssessmentBodyInsertDataDao;
	
	@Autowired
	private ProfileCreationAssessmentBodyUpdateDataDao profileCreationAssessmentBodyUpdateDataDao; 
	
	public String setAssessmentBodyRegistrationDetails(HashMap<String, HashMap<String, String>> assessmentBodyRegistrationDetails,HashMap<String, HashMap<String, MultipartFile>> assessmentBodyRegistrationDetailsFiles,File createAssessmentBodyFolder,int userExists)
	{
		try{

		/*
		 * ProfileCreationAssessmentBodyRegistrationDetailsDto Setting Starts
		 */
		
		ArrayList<ProfileCreationAssessmentBodyRegistrationDetailsDto> assessmentBodyRegistrationDetailsList = new ArrayList<ProfileCreationAssessmentBodyRegistrationDetailsDto>();
		
		for(Map.Entry<String, HashMap<String, String>> profileCreationAssessmentBodyRegistrationDetailsIterator : assessmentBodyRegistrationDetails.entrySet())
		{
		HashMap<String, String> setProfileCreationAssessmentBodyRegistrationDetailsDto = new HashMap<String, String>();
		setProfileCreationAssessmentBodyRegistrationDetailsDto=profileCreationAssessmentBodyRegistrationDetailsIterator.getValue();
		assessmentBodyRegistrationDetailsList.add(new ProfileCreationAssessmentBodyRegistrationDetailsDto(
				setProfileCreationAssessmentBodyRegistrationDetailsDto.get("assessmentBodyRegistrationId"),
				setProfileCreationAssessmentBodyRegistrationDetailsDto.get("applicationId"),
				setProfileCreationAssessmentBodyRegistrationDetailsDto.get("organizationName"),
				setProfileCreationAssessmentBodyRegistrationDetailsDto.get("sPOCName"),
				setProfileCreationAssessmentBodyRegistrationDetailsDto.get("address"),
				setProfileCreationAssessmentBodyRegistrationDetailsDto.get("city"),
				setProfileCreationAssessmentBodyRegistrationDetailsDto.get("state"),
				setProfileCreationAssessmentBodyRegistrationDetailsDto.get("pincode"),
				setProfileCreationAssessmentBodyRegistrationDetailsDto.get("mobileNumber"),
				setProfileCreationAssessmentBodyRegistrationDetailsDto.get("alternateMobileNumber"),
				setProfileCreationAssessmentBodyRegistrationDetailsDto.get("landlineNumber"),
				setProfileCreationAssessmentBodyRegistrationDetailsDto.get("alternateLandlineNumber"),
				setProfileCreationAssessmentBodyRegistrationDetailsDto.get("faxNumber"),
				setProfileCreationAssessmentBodyRegistrationDetailsDto.get("websites"),
				setProfileCreationAssessmentBodyRegistrationDetailsDto.get("yearOfEstablishment"),
				setProfileCreationAssessmentBodyRegistrationDetailsDto.get("priorAssessmentExperience"),
				setProfileCreationAssessmentBodyRegistrationDetailsDto.get("panNumber"),
				setProfileCreationAssessmentBodyRegistrationDetailsDto.get("panNumberPath"),
				setProfileCreationAssessmentBodyRegistrationDetailsDto.get("tanNumber"),
				setProfileCreationAssessmentBodyRegistrationDetailsDto.get("tanNumberPath"),
				setProfileCreationAssessmentBodyRegistrationDetailsDto.get("insituteReceivedAnyRecognition"),
				setProfileCreationAssessmentBodyRegistrationDetailsDto.get("numberOfTechnicalAssessors"),
				setProfileCreationAssessmentBodyRegistrationDetailsDto.get("numberOfNonTechnicalAssessors"),
				setProfileCreationAssessmentBodyRegistrationDetailsDto.get("affiliatedToAnySectorSkillCouncil")
				));
		}
		
		/*
		 * Setting of ProfileCreationAssessmentBodyRegistrationDetailsDto Ends Here
		 */

		/*
		 * Iterating Arraylist assessmentBodyRegistrationDetailsList
		 */
		
		for(int temp=0;temp<assessmentBodyRegistrationDetailsList.size();temp++)
		{
			/*
			 * Setting paths for PAN number path & TAN Number Path &saving them
			 */
			HashMap<String, MultipartFile> getAllFiles = new HashMap<String, MultipartFile>();
			getAllFiles = assessmentBodyRegistrationDetailsFiles.get("Record"+temp++);
			
			/*
			 * Declaring HashMap to set paths of various files to store in DB 
			 */
			
			HashMap<String, String> setPaths = new HashMap<String, String>();
			/*
			 * Now start extracting Pan Number from getAllFiles hashmap
			 */
			
			if(getAllFiles.get("PanNumber")==null)
			{
				/*
				 * No file is coming for Pan Number
				 */
				
				setPaths.put("panNumberPath",assessmentBodyRegistrationDetailsList.get(temp).getPanNumberPath());
			}
			else
			{
				/*
				 * Setting path where to save Pan number file 
				 */
				
				Path path=Paths.get(createAssessmentBodyFolder.getAbsolutePath()+"//PanNumber.pdf");
				
				/*
				 * Call ProfileCreationSaveFile with actual parameters to save file 
				 */
				
				String status=profileCreationSaveFile.saveFile(getAllFiles.get("PanNumber"), path);
				
				if(status==null)
				{
					/*
					 * Error Saving file on system
					 */
				}
				
				/*
				 * Setting panNumberPath 
				 */
				
				setPaths.put("panNumberPath",path.toString());
				
			}
			
			/*
			 * Extracting of Pan Number Ends 
			 */
		
			/*
			 * Now start extracting Tan Number from getAllFiles hashmap
			 */
			
			if(getAllFiles.get("TanNumber")==null)
			{
				/*
				 * No file is coming for Tan Number
				 */
				
				setPaths.put("tanNumberPath",assessmentBodyRegistrationDetailsList.get(temp).getTanNumberPath());
			}
			else
			{
				/*
				 * Setting path where to save Tan number file 
				 */
				
				Path path=Paths.get(createAssessmentBodyFolder.getAbsolutePath()+"//TanNumber.pdf");
				
				/*
				 * Call ProfileCreationSaveFile with actual parameters to save file 
				 */
				
				String status=profileCreationSaveFile.saveFile(getAllFiles.get("TanNumber"), path);
				
				if(status==null)
				{
					/*
					 * Error Saving file on system
					 */
				}
				
				/*
				 * Set tanNumberPath accordingly 
				 */
				
				setPaths.put("tanNumberPath",path.toString());
			}
			
			/*
			 * Extracting of Tan Number Ends 
			 */
			
			
			/*
			 * Setting Database of AssessmentBodyRegistrationDetails
			 */
			
			
			if(userExists==-1)
			{
				/*
				 * Insert into database
				 */
				
				int status=profileCreationAssessmentBodyInsertDataDao.insertIntoAssessmentBodyRegistrationDetails(assessmentBodyRegistrationDetailsList.get(temp),setPaths);
				
				if(status>0)
				{
					/*
					 * Successfully inserted into database 
					 */
				}
				else if(status==-1)
				{
					/*
					 * An exception Occurred while inserting data in database
					 */
				}
				
			}
			else if(userExists==-2)
			{
				/*
				 * Error Occurred while getting ApplicationId
				 */
			}
			else
			{
				/*
				 * Run update query
				 */
				
				int status = profileCreationAssessmentBodyUpdateDataDao.updateIntoAssessmentBodyRegistrationDetails(assessmentBodyRegistrationDetailsList.get(temp),setPaths);
			
				if(status>0)
				{
					/*
					 * Successfully inserted into database 
					 */
				}
				else if(status==-1)
				{
					/*
					 * An exception Occurred while inserting data in database
					 */
				}
			}
			

		}  // end of for loop
		
		return null;
	}
		catch(Exception e)
		{
			/*
			 * An error occurred while saving files and setting database
			 *  for Registration details
			 */
			e.printStackTrace();
			return null;
		}
	}
}
