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

import com.skill.India.dao.ProfileCreationAssessmentBodyDeleteDataDao;
import com.skill.India.dao.ProfileCreationAssessmentBodyInsertDataDao;
import com.skill.India.dao.ProfileCreationAssessmentBodyUpdateDataDao;
import com.skill.India.dto.ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto;

@Service
public class ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsService {

	@Autowired
	private ProfileCreationAssessmentBodyDeleteDataDao profileCreationAssessmentBodyDeleteDataDao;
	
	@Autowired
	private ProfileCreationAssessmentBodyUpdateDataDao profileCreationAssessmentBodyUpdateDataDao;
	
	@Autowired
	private ProfileCreationAssessmentBodyInsertDataDao profileCreationAssessmentBodyInsertDataDao;

	@Autowired
	private ProfileCreationSaveFile profileCreationSaveFile;
	
	public String setAssessmentBodyDirectorsAndManagementTeamDetails(HashMap<String, HashMap<String, String>> assessmentBodyDirectorsAndManagementTeamDetails,HashMap<String, HashMap<String, String>> assessmentBodyDirectorsAndManagementTeamDetailsDeletes,HashMap<String, HashMap<String, MultipartFile>> assessmentBodyDirectorsAndManagementTeamDetailsFiles,File createDirectorsAndManagementTeamMembersFolder)
	{

		try{
		/*
		 * ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto Setting Starts
		 */
		
		ArrayList<ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto> assessmentBodyDirectorsAndManagementTeamDetailsList = new ArrayList<ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto>();
		
		for(Map.Entry<String, HashMap<String, String>> profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsIterator : assessmentBodyDirectorsAndManagementTeamDetails.entrySet())
		{
		HashMap<String, String> setProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto = new HashMap<String, String>();
		setProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto=profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsIterator.getValue();
		assessmentBodyDirectorsAndManagementTeamDetailsList.add(new ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto(
				setProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto.get("directorsAndManagementId"),
				setProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto.get("assessmentBodyRegistrationId"),
				setProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto.get("name"),
				setProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto.get("designation"),
				setProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto.get("contactNumber"),
				setProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto.get("emailId"),
				setProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto.get("educationalQualification"),
				setProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto.get("experience"),
				setProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto.get("cVPath")
				));
		}
		
		/*
		 * Setting of ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto Ends Here
		 */
		
		
		/*
		 * Deleting the records which are deleted by the user  
		 */
		
		for(Map.Entry<String, HashMap<String, String>> deleteAssessmentBodyDirectorsAndManagementTeamDetails:assessmentBodyDirectorsAndManagementTeamDetailsDeletes.entrySet())
		{
			HashMap<String, String> deleteAssessmentBodyDirectorsAndManagementTeamDetailsRecord=new HashMap<String, String>();
			/*
			 * Getting value in deleteAssessmentBodyDirectorsAndManagementTeamDetailsRecord
			 */
			deleteAssessmentBodyDirectorsAndManagementTeamDetailsRecord=deleteAssessmentBodyDirectorsAndManagementTeamDetails.getValue();
			
			/*
			 * Getting value of directorsAndManagementId from Hashmap
			 */
			String directorsAndManagementId = deleteAssessmentBodyDirectorsAndManagementTeamDetailsRecord.get("directorsAndManagementId");
			
			/*
			 * Running delete queries 
			 */
			
			int deleteAssessmentBodyDirectorsAndManagementTeamDetailsRecordStatus=profileCreationAssessmentBodyDeleteDataDao.deleteFromAssessmentBodyDirectorsAndManagementTeamDetails(directorsAndManagementId);
			if(deleteAssessmentBodyDirectorsAndManagementTeamDetailsRecordStatus==-1)
			{
				/*
				 * An error occurred while deleting record 
				 */
				return null;
			}	
			
			
			/*
			 * Deleting files if exists  
			 */
			
			if(deleteAssessmentBodyDirectorsAndManagementTeamDetailsRecord.get("cVPath") !=null)
			{
				/*
				 * Delete CV on that path
				 */
				try{
				File deleteCv = new File(deleteAssessmentBodyDirectorsAndManagementTeamDetailsRecord.get("cVPath"));
				deleteCv.delete();
				}
				catch(Exception e)
				{
					/*
					 * Error occurred while deleting file
					 */
				}
				
			}
		}
		
		/*
		 * Deletion of record ends here
		 */
		
		
		/*
		 * Insert data in database & saving files 
		 */
		
		for(int temp=0;temp<assessmentBodyDirectorsAndManagementTeamDetailsList.size();temp++)
		{
			int directorsAndManagementId;
			/*
			 * If in each record directorsAndManagementId is present then run update 
			 * query else run insert query
			 */
			
			if(assessmentBodyDirectorsAndManagementTeamDetailsList.get(temp).getDirectorsAndManagementId()==null)
			{
				/*
				 * Run insert query
				 */
				directorsAndManagementId = profileCreationAssessmentBodyInsertDataDao.insertIntoAssessmentBodyDirectorsAndManagementTeamDetails(assessmentBodyDirectorsAndManagementTeamDetailsList.get(temp));
				if(directorsAndManagementId==-1)
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
				 * Set managaementAndStaffId variable to incoming managementAndStaffId
				 */
		
				directorsAndManagementId=Integer.parseInt(assessmentBodyDirectorsAndManagementTeamDetailsList.get(temp).getDirectorsAndManagementId());
				
				/*
				 * Run update query
				 */
				int updateDataInAssessmentBodyDirectorsAndManagementTeamDetailsStatus = profileCreationAssessmentBodyUpdateDataDao.updateIntoAssessmentBodyDirectorsAndManagementTeamDetails(assessmentBodyDirectorsAndManagementTeamDetailsList.get(temp));
				if(updateDataInAssessmentBodyDirectorsAndManagementTeamDetailsStatus==-1)
				{
					/*
					 * Error updating data in AssessmentBodyDirectorsAndManagementTeamDetails table
					 */
					return null;
				}
			}
			
				/*
				 * Save files at respective locations and save their paths 
				 */

				HashMap<String, MultipartFile> getAllFiles = new HashMap<String, MultipartFile>();
				getAllFiles = assessmentBodyDirectorsAndManagementTeamDetailsFiles.get("Record"+temp++);
			
				/*
				 * Declaring HashMap to set paths of various files to store in DB 
				 */
		
				HashMap<String, String> setPaths = new HashMap<String, String>();
		
					/*
					 * now checking if file corresponding to CV is present or not 
					 */
					
					if(getAllFiles.get("CV")==null)
					{
						/*
						 * No file is present 
						 */
						setPaths.put("cVPath",assessmentBodyDirectorsAndManagementTeamDetailsList.get(temp).getcVPath());
					}
					else
					{
						/*
						 * File is present
						 * Now storing the file first 
						 */
						String fullFileName= getAllFiles.get("CV").getOriginalFilename();
						int indexOfDot=fullFileName.indexOf(".");
						String firstFileName= fullFileName.substring(0, indexOfDot);
						String fileExtension= fullFileName.substring(indexOfDot);
						
						/*
						 * Setting path of format Folder//filename-directorsAndManagementId
						 */
						Path path=Paths.get(createDirectorsAndManagementTeamMembersFolder.getAbsolutePath()+"//"+firstFileName+"-"+directorsAndManagementId+fileExtension);
						
						/*
						 * Saving file at Desired Location
						 */
						
						String status = profileCreationSaveFile.saveFile(getAllFiles.get("CV"), path);
						if(status==null)
						{
							/*
							 * Error saving the file at desired location
							 */
							return null;
						}
						
						/*
						 * Setting path of saved file in HashMap 
						 */
						
						setPaths.put("cVPath",path.toString());	
					}
			
				/*
				 * Updating paths of Files saved on system in database 
				 */
				
				
				int statusOfUpdatePaths=profileCreationAssessmentBodyUpdateDataDao.updatePathsIntoAssessmentBodyDirectorsAndManagementTeamDetails(setPaths, directorsAndManagementId);
				
				if(statusOfUpdatePaths==-1)
				{
					/*
					 * An error occurred while updating paths 
					 */
					return null;
				}
				
		} // end of for loop
		
		return null;
		}
		catch(Exception e)
		{
			/*
			 * An error occurred while deleting ,saving files or inserting data in database 
			 */
			e.printStackTrace();
			return null;
		}
	}
}
