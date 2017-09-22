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
import com.skill.India.dto.ProfileCreationAssessmentStaffDetailsDto;

@Service
public class ProfileCreationAssessmentStaffDetailsService {

	@Autowired
	private ProfileCreationAssessmentBodyDeleteDataDao profileCreationAssessmentBodyDeleteDataDao;
	
	@Autowired
	private ProfileCreationAssessmentBodyUpdateDataDao profileCreationAssessmentBodyUpdateDataDao;
	
	@Autowired
	private ProfileCreationAssessmentBodyInsertDataDao profileCreationAssessmentBodyInsertDataDao;

	@Autowired
	private ProfileCreationSaveFile profileCreationSaveFile;

	
	public String setAssessmentStaffDetails(HashMap<String, HashMap<String, String>> assessmentStaffDetails,HashMap<String, HashMap<String, String>> assessmentStaffDetailsDeletes,HashMap<String, HashMap<String, MultipartFile>> assessmentStaffDetailsFiles,File createAssessmentStaffCVFolder,File createAssessmentStaffCertificateFolder)
	{
		try{
		/*
		 * ProfileCreationAssessmentStaffDetailsDto Setting Starts
		 */
		
		ArrayList<ProfileCreationAssessmentStaffDetailsDto> assessmentStaffDetailsList = new ArrayList<ProfileCreationAssessmentStaffDetailsDto>();
		
		for(Map.Entry<String, HashMap<String, String>> profileCreationAssessmentStaffDetailsIterator : assessmentStaffDetails.entrySet())
		{
		HashMap<String, String> setProfileCreationAssessmentStaffDetailsDto = new HashMap<String, String>();
		setProfileCreationAssessmentStaffDetailsDto=profileCreationAssessmentStaffDetailsIterator.getValue();
		assessmentStaffDetailsList.add(new ProfileCreationAssessmentStaffDetailsDto(
				setProfileCreationAssessmentStaffDetailsDto.get("assessmentStaffId"),
				setProfileCreationAssessmentStaffDetailsDto.get("assessmentBodyRegistrationId"),
				setProfileCreationAssessmentStaffDetailsDto.get("name"),
				setProfileCreationAssessmentStaffDetailsDto.get("jobRoleCode"),
				setProfileCreationAssessmentStaffDetailsDto.get("designation"),
				setProfileCreationAssessmentStaffDetailsDto.get("contactNumber"),
				setProfileCreationAssessmentStaffDetailsDto.get("emailId"),
				setProfileCreationAssessmentStaffDetailsDto.get("state"),
				setProfileCreationAssessmentStaffDetailsDto.get("city"),
				setProfileCreationAssessmentStaffDetailsDto.get("educationalQualification"),
				setProfileCreationAssessmentStaffDetailsDto.get("experience"),
				setProfileCreationAssessmentStaffDetailsDto.get("cVPath"),
				setProfileCreationAssessmentStaffDetailsDto.get("certificatePath")
				));
		}
		
		/*
		 * Setting of ProfileCreationAssessmentStaffDetailsDto Ends Here
		 */
		
		
		/*
		 * Deleting the records which are deleted by the user  
		 */
		
		for(Map.Entry<String, HashMap<String, String>> deleteAssessmentStaffDetails:assessmentStaffDetailsDeletes.entrySet())
		{
			HashMap<String, String> deleteAssessmentStaffDetailsRecord=new HashMap<String, String>();
			/*
			 * Getting value in deleteAssessmentStaffDetailsRecord
			 */
			deleteAssessmentStaffDetailsRecord=deleteAssessmentStaffDetails.getValue();
			
			/*
			 * Getting value of assessmentStaffId from Hashmap
			 */
			String assessmentStaffId = deleteAssessmentStaffDetailsRecord.get("assessmentStaffId");
			
			/*
			 * Running delete queries 
			 */
			
			int deleteAssessmentStaffDetailsRecordStatus=profileCreationAssessmentBodyDeleteDataDao.deleteFromAssessmentStaffDetails(assessmentStaffId);
			if(deleteAssessmentStaffDetailsRecordStatus==-1)
			{
				/*
				 * An error occurred while deleting record 
				 */
				return null;
			}	
			
			
			/*
			 * Deleting files if exists  
			 */
			
			if(deleteAssessmentStaffDetailsRecord.get("cVPath") !=null)
			{
				/*
				 * Delete CV on that path
				 */
				try{
				File deleteCv = new File(deleteAssessmentStaffDetailsRecord.get("cVPath"));
				deleteCv.delete();
				}
				catch(Exception e)
				{
					/*
					 * Error occurred while deleting file
					 */
				}
				
			}
			
			if(deleteAssessmentStaffDetailsRecord.get("certificatePath") !=null)
			{
				/*
				 * Delete Certificate on that path
				 */
				try{
				File deleteCv = new File(deleteAssessmentStaffDetailsRecord.get("certificatePath"));
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
		
		for(int temp=0;temp<assessmentStaffDetailsList.size();temp++)
		{
			int assessmentStaffId;
			/*
			 * If in each record assessmentStaffId is present then run update 
			 * query else run insert query
			 */
			
			if(assessmentStaffDetailsList.get(temp).getAssessmentStaffId()==null)
			{
				/*
				 * Run insert query
				 */
				assessmentStaffId = profileCreationAssessmentBodyInsertDataDao.insertIntoAssessmentStaffDetails(assessmentStaffDetailsList.get(temp));
				if(assessmentStaffId==-1)
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
		
				assessmentStaffId=Integer.parseInt(assessmentStaffDetailsList.get(temp).getAssessmentStaffId());
				
				/*
				 * Run update query
				 */
				int updateDataInAssessmentStaffDetailsStatus = profileCreationAssessmentBodyUpdateDataDao.updateIntoAssessmentStaffDetails(assessmentStaffDetailsList.get(temp));
				if(updateDataInAssessmentStaffDetailsStatus==-1)
				{
					/*
					 * Error updating data in AssessmentStaffDetails table
					 */
					return null;
				}
			}
			
				/*
				 * Save files at respective locations and save their paths 
				 */

				HashMap<String, MultipartFile> getAllFiles = new HashMap<String, MultipartFile>();
				getAllFiles = assessmentStaffDetailsFiles.get("Record"+temp++);
			
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
						setPaths.put("cVPath",assessmentStaffDetailsList.get(temp).getcVPath());
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
						 * Setting path of format Folder//filename-assessmentStaffId
						 */
						Path path=Paths.get(createAssessmentStaffCVFolder.getAbsolutePath()+"//"+firstFileName+"-"+assessmentStaffId+fileExtension);
						
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
					 * now checking if file corresponding to Certificate is present or not 
					 */
					
					if(getAllFiles.get("Certificate")==null)
					{
						/*
						 * No file is present 
						 */
						setPaths.put("certificatePath",assessmentStaffDetailsList.get(temp).getCertificatePath());
					}
					else
					{
						/*
						 * File is present
						 * Now storing the file first 
						 */
						String fullFileName= getAllFiles.get("Certificate").getOriginalFilename();
						int indexOfDot=fullFileName.indexOf(".");
						String firstFileName= fullFileName.substring(0, indexOfDot);
						String fileExtension= fullFileName.substring(indexOfDot);
						
						/*
						 * Setting path of format Folder//filename-assessmentStaffId
						 */
						Path path=Paths.get(createAssessmentStaffCertificateFolder.getAbsolutePath()+"//"+firstFileName+"-"+assessmentStaffId+fileExtension);
						
						/*
						 * Saving file at Desired Location
						 */
						
						String status = profileCreationSaveFile.saveFile(getAllFiles.get("Certificate"), path);
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
						
						setPaths.put("certificatePath",path.toString());	
					}
					
					
				/*
				 * Updating paths of Files saved on system in database 
				 */
				
				
				int statusOfUpdatePaths=profileCreationAssessmentBodyUpdateDataDao.updatePathsIntoAssessmentStaffDetails(setPaths, assessmentStaffId);
				
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
			 * An exception occurred while deleting,saving files or inserting
			 * data in database 
			 */
			e.printStackTrace();
			return null;
		}
	}
}
