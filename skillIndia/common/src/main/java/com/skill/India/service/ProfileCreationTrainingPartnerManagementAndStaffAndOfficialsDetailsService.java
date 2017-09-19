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

import com.skill.India.dao.ProfileCreationTrainingPartnerDeleteDataDao;
import com.skill.India.dao.ProfileCreationTrainingPartnerInsertDataDao;
import com.skill.India.dao.ProfileCreationTrainingPartnerUpdateDataDao;
import com.skill.India.dto.ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto;

@Service
public class ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsService {

	@Autowired
	private ProfileCreationTrainingPartnerDeleteDataDao profileCreationTrainingPartnerDeleteDataDao;
	
	@Autowired
	private ProfileCreationTrainingPartnerInsertDataDao profileCreationTrainingPartnerInsertDataDao;
	
	@Autowired
	private ProfileCreationTrainingPartnerUpdateDataDao profileCreationTrainingPartnerUpdateDataDao;
	
	@Autowired
	private ProfileCreationSaveFile profileCreationSaveFile;
	
	public String setTrainingPartnerManagementAndStaffAndOfficialsDetails(HashMap<String, HashMap<String, String>> trainingPartnerManagementAndStaffAndOfficialsDetails,HashMap<String, HashMap<String, String>> trainingPartnerManagementAndStaffAndOfficialsDetailsDeletes, HashMap<String,HashMap<String, MultipartFile>> trainingPartnerManagementAndStaffAndOfficialsDetailsFiles,File createDirectorsAndManagementTeamMembersFolder,File createTrainingStaffCVFolder,File createTrainingStaffCertificateFolder,int userExists)
	{
		try{

		/*
		 * ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto Setting Starts
		 */
		
		ArrayList<ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto> trainingPartnerManagementAndStaffAndOfficialsDetailsList = new ArrayList<ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto>();
		
		for(Map.Entry<String, HashMap<String, String>> profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsIterator : trainingPartnerManagementAndStaffAndOfficialsDetails.entrySet())
		{
		HashMap<String, String> setProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto = new HashMap<String, String>();
		setProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto=profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsIterator.getValue();
		trainingPartnerManagementAndStaffAndOfficialsDetailsList.add(new ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto(
				setProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.get("managementAndStaffId"),
				setProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.get("trainingPartnerRegistrationId"),
				setProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.get("trainingPartnerCenterId"),
				setProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.get("type"),
				setProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.get("name"),
				setProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.get("designation"),
				setProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.get("emailId"),
				setProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.get("contactNumber"),
				setProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.get("educationalQualification"),
				setProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.get("regularOrVisiting"),
				setProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.get("experience"),
				setProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.get("cVPath"),
				setProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.get("certificatePath")					
				));
		}
		
		/*
		 * Setting of ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto Ends
		 */

		/*
		 * Deleting the records which are deleted by the user  
		 */
		
		for(Map.Entry<String, HashMap<String, String>> deleteTrainingPartnerManagementAndStaffAndOfficialsDetails:trainingPartnerManagementAndStaffAndOfficialsDetailsDeletes.entrySet())
		{
			HashMap<String, String> deleteManagementAndStaffAndOfficialsDetailsRecord=new HashMap<String, String>();
			/*
			 * Getting value in deleteManagementAndStaffAndOfficialsDetailsRecord
			 */
			deleteManagementAndStaffAndOfficialsDetailsRecord=deleteTrainingPartnerManagementAndStaffAndOfficialsDetails.getValue();
			
			/*
			 * Getting value of managementAndStaffAndOfficialsDetailsId from Hashmap
			 */
			String managementAndStaffId = deleteManagementAndStaffAndOfficialsDetailsRecord.get("managementAndStaffId");
			
			/*
			 * Running delete queries 
			 */
			
			int deleteManagementAndStaffAndOfficialsDetailsRecordStatus=profileCreationTrainingPartnerDeleteDataDao.deletefromTrainingPartnerManagementAndStaffAndOfficialsDetails(managementAndStaffId);
			if(deleteManagementAndStaffAndOfficialsDetailsRecordStatus==-1)
			{
				/*
				 * An error occurred while deleting record 
				 */
				return null;
			}	
			
			
			/*
			 * Deleting files if exists  
			 */
			
			if(deleteManagementAndStaffAndOfficialsDetailsRecord.get("cVPath") !=null)
			{
				/*
				 * Delete CV on that path
				 */
				try{
				File deleteCv = new File(deleteManagementAndStaffAndOfficialsDetailsRecord.get("cVPath"));
				deleteCv.delete();
				}
				catch(Exception e)
				{
					/*
					 * Error occurred while deleting file
					 */
				}
				
			}
			if(trainingPartnerManagementAndStaffAndOfficialsDetails.get("certificatePath")!=null)
			{
				/*
				 * Delete certificate on that path
				 */
				try{
				File deleteCertficate = new File(deleteManagementAndStaffAndOfficialsDetailsRecord.get("certificatePath"));
				deleteCertficate.delete();
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
		 * Insert data in database
		 */
		
		for(int temp=0;temp<trainingPartnerManagementAndStaffAndOfficialsDetailsList.size();temp++)
		{
			int managementAndStaffId;
			/*
			 * If in each record managementAndStaffId is present then run update 
			 * query else run insert query
			 */
			
			if(trainingPartnerManagementAndStaffAndOfficialsDetailsList.get(temp).getManagementAndStaffId()==null)
			{
				/*
				 * Run insert query
				 */
				managementAndStaffId = profileCreationTrainingPartnerInsertDataDao.insertIntoTrainingPartnerManagementAndStaffAndOfficialsDetails(trainingPartnerManagementAndStaffAndOfficialsDetailsList.get(temp));
				if(managementAndStaffId==-1)
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
		
				managementAndStaffId=Integer.parseInt(trainingPartnerManagementAndStaffAndOfficialsDetailsList.get(temp).getManagementAndStaffId());
				
				/*
				 * Run update query
				 */
				int updateDataInManagementAndStaffAndOfficialsDetailsStatus = profileCreationTrainingPartnerUpdateDataDao.updateIntoTrainingPartnerManagementAndStaffAndOfficialsDetails(trainingPartnerManagementAndStaffAndOfficialsDetailsList.get(temp));
				if(updateDataInManagementAndStaffAndOfficialsDetailsStatus==-1)
				{
					/*
					 * Error updating data in ManagementAndStaffAndOfficialsDetails table
					 */
					return null;
				}
			}
			
				/*
				 * Saving files at desired location 
				 */
			
		
				/*
				 * Save files at respective locations and save their paths 
				 */
		 
				/*
				 * Set paths for CV'S & Certificates depending upon the type of user 
				 */
		
				HashMap<String, MultipartFile> getAllFiles = new HashMap<String, MultipartFile>();
				getAllFiles = trainingPartnerManagementAndStaffAndOfficialsDetailsFiles.get("Record"+temp++);
			
				/*
				 * Declaring HashMap to set paths of various files to store in DB 
				 */
		
				HashMap<String, String> setPaths = new HashMap<String, String>();
		
				/*
				 * Checking the type of user for DirectorAndTeamManagement or Staff
				 */
				if(trainingPartnerManagementAndStaffAndOfficialsDetailsList.get(temp).getType().equalsIgnoreCase("DirectorsAndManagementTeamMembers"))
				{
					/*
					 * If DirectorsAndManagementTeamMembers 
					 * now checking if file corresponding to CV is present or not 
					 */
					
					if(getAllFiles.get("CV")==null)
					{
						/*
						 * No file is present 
						 */
						setPaths.put("cVPath",trainingPartnerManagementAndStaffAndOfficialsDetailsList.get(temp).getcVPath());
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
						 * Setting path of format Folder//filename-MnagaementAndStafffIdExtension
						 */
						Path path=Paths.get(createDirectorsAndManagementTeamMembersFolder.getAbsolutePath()+"//"+firstFileName+"-"+managementAndStaffId+fileExtension);
						
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
					 * Setting path of certificate to null (though we will not be receiving it )
					 */
					
					setPaths.put("certificatePath", null);
		
				}
				else if(trainingPartnerManagementAndStaffAndOfficialsDetailsList.get(temp).getType().equalsIgnoreCase("TrainingStaff"))
				{
					/*
					 * If training Staff
					 * Now checking for cv & certificates
					 */
					if(getAllFiles.get("CV")==null)
					{
						/*
						 * No file is present 
						 */
						setPaths.put("cVPath",trainingPartnerManagementAndStaffAndOfficialsDetailsList.get(temp).getcVPath());
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
						 * Setting path of format Folder//filename-MnagaementAndStafffIdExtension
						 */
						Path path=Paths.get(createTrainingStaffCertificateFolder.getAbsolutePath()+"//"+firstFileName+"-"+managementAndStaffId+fileExtension);
						
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
					 * Checking for Certificate
					 */
					
					if(getAllFiles.get("Certificate")==null)
					{
						/*
						 * No file is present 
						 */
						setPaths.put("certificatePath",trainingPartnerManagementAndStaffAndOfficialsDetailsList.get(temp).getCertificatePath());
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
						 * Setting path of format Folder//filename-MnagaementAndStafffIdExtension
						 */
						Path path=Paths.get(createTrainingStaffCertificateFolder.getAbsolutePath()+"//"+firstFileName+"-"+managementAndStaffId+fileExtension);
						
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
					
				}
				else
				{
					/*
					 * type Not recognized 
					 */
					return  null;
				}
			
				/*
				 * Updating paths of Files saved on system in database 
				 */
				
				int statusOfUpdatePaths=profileCreationTrainingPartnerUpdateDataDao.updatePathsIntoTrainingPartnerManagementAndStaffAndOfficialsDetails(setPaths, managementAndStaffId);
				
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
			 * An exception occurred while saving files or inserting data corresponding to ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetails table
			 * 
			 */
			e.printStackTrace();
			return null;
		}
	}
}
