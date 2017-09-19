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
import com.skill.India.dto.ProfileCreationTrainingPartnerCenterDetailsDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto;

@Service
public class ProfileCreationTrainingPartnerCenterDetailsService {
	
	@Autowired
	private ProfileCreationTrainingPartnerDeleteDataDao profileCreationTrainingPartnerDeleteDataDao;
	
	@Autowired
	private ProfileCreationTrainingPartnerInsertDataDao profileCreationTrainingPartnerInsertDataDao;
	
	@Autowired
	private ProfileCreationTrainingPartnerUpdateDataDao profileCreationTrainingPartnerUpdateDataDao;
	
	@Autowired
	private ProfileCreationSaveFile profileCreationSaveFile;
	
	
	public String setTrainingPartnerCenterDetails(HashMap<String, HashMap<String, String>> trainingPartnerCenterLevelDetails,HashMap<String, HashMap<String, String>> trainingPartnerCenterLevelDetailsDeletes, HashMap<String,HashMap<String, MultipartFile>> trainingPartnerCenterLevelDetailsFiles,File createCentersFolder,HashMap<String, HashMap<String, String>> trainingPartnerCenterLevelAHOCSPOCDetails,HashMap<String, HashMap<String, MultipartFile>> trainingPartnerCenterLevelAHOCSPOCDetailsFiles)
	{
		try{
		
		/*
		 * ProfileCreationTrainingPartnerCenterLevelDetailsDto Setting starts 
		 */
		
		ArrayList<ProfileCreationTrainingPartnerCenterDetailsDto> trainingPartnerCenterDetailsList = new ArrayList<ProfileCreationTrainingPartnerCenterDetailsDto>();
		
		for(Map.Entry<String, HashMap<String, String>> profileCreationTrainingPartnerCenterDetailsIterator : trainingPartnerCenterLevelDetails.entrySet())
		{
			/*
			 * Setting the incoming data in  respective DTO's ProfileCreationTrainingPartnerCenterDetailsDto
			 */
			HashMap<String, String> setProfileCreationTrainingPartnerCenterDetailsDto=new HashMap<String, String>();
			setProfileCreationTrainingPartnerCenterDetailsDto=profileCreationTrainingPartnerCenterDetailsIterator.getValue();
			trainingPartnerCenterDetailsList.add(new ProfileCreationTrainingPartnerCenterDetailsDto(
					setProfileCreationTrainingPartnerCenterDetailsDto.get("trainingPartnerCenterId"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("trainingPartnerRegistrationId"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("nameOfCenter"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("numberOfPermanentOfficeManager"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("numberOftemporaryOfficeManager"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("numberOfPermanentOfficeStaff"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("numberOfTemporaryOfficeStaff"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("numberOfPermanentLabAssistants"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("numberOfTemporaryLabAssistants"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("numberOfPermanentAccountants"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("numberOfTemporaryAccountants"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("numberOfPermanentSupportStaff"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("numberOfTemporarySupportStaff"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("numberOfPermanentOtherEmployees"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("numberOfTemporaryOtherEmployees"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("areaOfInstitute"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("buildingType"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("sizeOfClassrooms"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("classroomPicsPath"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("numberOfClassrooms"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("sizeOfLabs"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("labPicsPath"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("numberOfLabs"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("sizeOfWorkshops"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("workshopPicsPath"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("numberOfWorkshops"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("mandatoryToolKitpresent"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("mandatoryToolKitAnnexurePath"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("mandatoryToolKitPicsPath"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("safeDrinkingWater"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("powerBackup"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("separateToilets"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("transportFacility"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("presenceOfLibrary"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("numberOfTechnicalBooks"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("numberOfNonTechnicalBooks"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("numberOfMagazines"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("numberOfDailies"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("remarksOnInfrastructureDetails"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("sufficientClassroomIlluminationLevel"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("sufficientClassroomVentilationLevel"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("sufficientCenterCleanliness"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("centerWeatherProtected"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("remarksOnLearningEnviornment"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("printedBrochureOrProspectus"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("documentedPolicyAndProcedures"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("concessionPolicy"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("safeCustodyOfStudentDocuments"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("studentAgreementWithInstitution"),		
					setProfileCreationTrainingPartnerCenterDetailsDto.get("remarksOnStudentAdmissionDetails")
					));
		}
		
		/*
		 * End of Setting of ProfileCreationTrainingPartnerCenterDetailsDto
		 */
		
		
		
		/*
		 * ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto Setting Starts
		 */
		
		ArrayList<ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto> trainingPartnerManagementAndStaffAndOfficialsDetailsList = new ArrayList<ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto>();
		
		for(Map.Entry<String, HashMap<String, String>> profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsIterator : trainingPartnerCenterLevelAHOCSPOCDetails.entrySet())
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
		
		for(Map.Entry<String, HashMap<String, String>> deleteTrainingPartnerCenterDetails:trainingPartnerCenterLevelDetailsDeletes.entrySet())
		{
			HashMap<String, String> deleteCenterDetailsRecord=new HashMap<String, String>();
			/*
			 * Getting value in deleteCenterDetailsRecord
			 */
			deleteCenterDetailsRecord=deleteTrainingPartnerCenterDetails.getValue();
			
			/*
			 * Getting value of trainingPartnerCenterId from Hashmap
			 */
			String trainingPartnerCenterId = deleteCenterDetailsRecord.get("trainingPartnerCenterId");
			
			/*
			 * Running delete queries 
			 */
			
			int deleteCenterDetailsRecordStatus=profileCreationTrainingPartnerDeleteDataDao.deletefromTrainingPartnerCenterLevelDetails(trainingPartnerCenterId);
			if(deleteCenterDetailsRecordStatus==-1)
			{
				/*
				 * An error occurred while deleting record 
				 */
				return null;
			}	
			
			
			/*
			 * Deleting files if exists  
			 */
			
			if(deleteCenterDetailsRecord.get("classroomPicsPath") !=null)
			{
				/*
				 * Delete Classroom pics on that path
				 */
				try{
				File deleteClassroomPics = new File(deleteCenterDetailsRecord.get("classroomPicsPath"));
				deleteClassroomPics.delete();
				}
				catch(Exception e)
				{
					/*
					 * Error occurred while deleting file
					 */
				}
				
			}
			
			if(deleteCenterDetailsRecord.get("labPicsPath")!=null)
			{
				/*
				 * Delete labs pics on that path
				 */
				try{
				File deleteLabPics = new File(deleteCenterDetailsRecord.get("labPicsPath"));
				deleteLabPics.delete();
				}
				catch(Exception e)
				{
					/*
					 * Error occurred while deleting file
					 */ 
				}
			}
			
			if(deleteCenterDetailsRecord.get("workshopPicsPath")!=null)
			{
				/*
				 * Delete workshop pics on that path
				 */
				try{
				File deleteWorkshopPics = new File(deleteCenterDetailsRecord.get("workshopPicsPath"));
				deleteWorkshopPics.delete();
				}
				catch(Exception e)
				{
					/*
					 * Error occurred while deleting file
					 */ 
				}
			}
			
			if(deleteCenterDetailsRecord.get("mandatoryToolKitAnnexurePath")!=null)
			{
				/*
				 * Delete mandatory toolkit annexure on that path
				 */
				try{
				File deleteMandatoryToolKitAnnexure = new File(deleteCenterDetailsRecord.get("mandatoryToolKitAnnexurePath"));
				deleteMandatoryToolKitAnnexure.delete();
				}
				catch(Exception e)
				{
					/*
					 * Error occurred while deleting file
					 */ 
				}
			}
			
			if(deleteCenterDetailsRecord.get("mandatoryToolKitPicsPath")!=null)
			{
				/*
				 * Delete certificate on that path
				 */
				try{
				File deleteMandatoryToolKitPics = new File(deleteCenterDetailsRecord.get("mandatoryToolKitPicsPath"));
				deleteMandatoryToolKitPics.delete();
				}
				catch(Exception e)
				{
					/*
					 * Error occurred while deleting file
					 */ 
				}
			}
			
			/*
			 * Deletion of files ends 
			 */
			
		}
		
		/*
		 * Deletion of record ends here
		 */

		/*DOING OPERATION ONLY ON TPCENTERDETAILS 
		 * Inserting data in database and getting back centerId 
		 * then creating folders as per requirement for each center 
		 * then saving files in desired folders
		 * then updating their paths in database 
		 */
		
		/*
		 * Iterate the List of TPcenterDetails
		 */
		for(int temp=0;temp<trainingPartnerCenterDetailsList.size();temp++)
		{
			int trainingPartnerCenterId;
			/*
			 * If for each record TPcenterId is null then run insert Query
			 * else run update query
			 */
			
			if(trainingPartnerCenterDetailsList.get(temp).getTrainingPartnerCenterId()==null)
			{
				/*
				 * Run insert Query
				 */
				trainingPartnerCenterId = profileCreationTrainingPartnerInsertDataDao.insertIntoTrainingPartnerCenterLevelDetails(trainingPartnerCenterDetailsList.get(temp));
				if(trainingPartnerCenterId==-1)
				{
					/*
					 * An error occurred while inserting data and fetching centerId from database
					 */
					return null;
				}
			}
			else
			{
				/*
				 * get trainingPartnerCenterId from trainingPartnerCenterDetailsList
				 */
				trainingPartnerCenterId=Integer.parseInt(trainingPartnerCenterDetailsList.get(temp).getTrainingPartnerCenterId());
				
				/*
				 * Run update query
				 */
				
				int updateCenterDetailsStatus = profileCreationTrainingPartnerUpdateDataDao.updateIntoTrainingPartnerCenterLevelDetails(trainingPartnerCenterDetailsList.get(temp));
				if(updateCenterDetailsStatus==-1)
				{
					/*
					 * Error updating data in TPcenterDetails table 
					 */
					return null;
				}	
			}
			
			/*
			 * Creating folder for received centerId
			 */
			
			File createCenterIdFolder = new File(createCentersFolder.getAbsolutePath()+"//"+trainingPartnerCenterId);
			if(!createCenterIdFolder.mkdir())
			{
				/*
				 * An error occurred while creating folder for name of centerId in centers folder
				 */
				return null;
			}
			
			/*
			 * Creation of folder in name of centerId ends 
			 */
			
			/*
			 * Saving files in it and setting paths for them to be updated in database
			 */
			HashMap<String, MultipartFile> getAllFiles = new HashMap<String, MultipartFile>();
			getAllFiles = trainingPartnerCenterLevelDetailsFiles.get("Record"+temp++);
		
			/*
			 * Declaring HashMap to set paths of various files to store in DB 
			 */
	
			HashMap<String, String> setPaths = new HashMap<String, String>();
			
			/*
			 * Checking for file corresponding to ClassroomPics and saving and setting its path
			 */

			if(getAllFiles.get("ClassroomPics")==null)
			{
				/*
				 * No file is present 
				 */
				setPaths.put("classroomPicsPath",trainingPartnerCenterDetailsList.get(temp).getClassroomPicsPath());
			}
			else
			{
				/*
				 * Saving file at desired location & setting its path in HashMap
				 */
				String fullFileName= getAllFiles.get("ClassroomPics").getOriginalFilename();
				int indexOfDot=fullFileName.indexOf(".");
				String fileExtension= fullFileName.substring(indexOfDot);
				
				/*
				 * Setting path of format centerId->ClassroomPicsFileExtension
				 */
				Path path = Paths.get(createCenterIdFolder.getAbsolutePath()+"//ClassroomPics"+fileExtension);
				
				/*
				 * Saving file at desired location
				 */
				
				String status=profileCreationSaveFile.saveFile(getAllFiles.get("ClassroomPics"), path);
				if(status==null)
				{
					/*
					 * Error saving the file at desired location
					 */
					return null;
				}
				
				/*
				 * Setting path of file in hashmap to save in database
				 */
				
				setPaths.put("classroomPicsPath", path.toString());
			}
	
			/*
			 * End of Classroompics path storing and setting path
			 */
		
			
			/*
			 * Checking for file corresponding to workshopPics and saving and setting its path
			 */

			if(getAllFiles.get("WorkshopPics")==null)
			{
				/*
				 * No file is present 
				 */
				setPaths.put("workshopPicsPath",trainingPartnerCenterDetailsList.get(temp).getWorkshopPicsPath());
			}
			else
			{
				/*
				 * Saving file at desired location & setting its path in HashMap
				 */
				String fullFileName= getAllFiles.get("WorkshopPics").getOriginalFilename();
				int indexOfDot=fullFileName.indexOf(".");
				String fileExtension= fullFileName.substring(indexOfDot);
				
				/*
				 * Setting path of format centerId->WorkshopPicsFileExtension
				 */
				Path path = Paths.get(createCenterIdFolder.getAbsolutePath()+"//WorkshopPics"+fileExtension);
				
				/*
				 * Saving file at desired location
				 */
				
				String status=profileCreationSaveFile.saveFile(getAllFiles.get("WorkshopPics"), path);
				if(status==null)
				{
					/*
					 * Error saving the file at desired location
					 */
					return null;
				}
				
				/*
				 * Setting path of file in hashmap to save in database
				 */
				
				setPaths.put("workshopPicsPath", path.toString());
			}
	
			/*
			 * End of WorkshopPics path storing and setting path
			 */
			
			
			/*
			 * Checking for file corresponding to labPics and saving and setting its path
			 */

			if(getAllFiles.get("LabPics")==null)
			{
				/*
				 * No file is present 
				 */
				setPaths.put("labPicsPath",trainingPartnerCenterDetailsList.get(temp).getLabPicsPath());
			}
			else
			{
				/*
				 * Saving file at desired location & setting its path in HashMap
				 */
				String fullFileName= getAllFiles.get("LabPics").getOriginalFilename();
				int indexOfDot=fullFileName.indexOf(".");
				String fileExtension= fullFileName.substring(indexOfDot);
				
				/*
				 * Setting path of format centerId->LabPicsFileExtension
				 */
				Path path = Paths.get(createCenterIdFolder.getAbsolutePath()+"//LabPics"+fileExtension);
				
				/*
				 * Saving file at desired location
				 */
				
				String status=profileCreationSaveFile.saveFile(getAllFiles.get("LabPics"), path);
				if(status==null)
				{
					/*
					 * Error saving the file at desired location
					 */
					return null;
				}
				
				/*
				 * Setting path of file in hashmap to save in database
				 */
				
				setPaths.put("labPicsPath", path.toString());
			}
	
			/*
			 * End of LabPics path storing and setting path
			 */
			
			
			/*
			 * Checking for file corresponding to mandatoryToolKitPics and saving and setting its path
			 */

			if(getAllFiles.get("MandatoryToolKitPics")==null)
			{
				/*
				 * No file is present 
				 */
				setPaths.put("mandatoryToolKitPicsPath",trainingPartnerCenterDetailsList.get(temp).getMandatoryToolKitPicsPath());
			}
			else
			{
				/*
				 * Saving file at desired location & setting its path in HashMap
				 */
				String fullFileName= getAllFiles.get("MandatoryToolKitPics").getOriginalFilename();
				int indexOfDot=fullFileName.indexOf(".");
				String fileExtension= fullFileName.substring(indexOfDot);
				
				/*
				 * Setting path of format centerId->MandatoryToolKitPicsFileExtension
				 */
				Path path = Paths.get(createCenterIdFolder.getAbsolutePath()+"//MandatoryToolKitPics"+fileExtension);
				
				/*
				 * Saving file at desired location
				 */
				
				String status=profileCreationSaveFile.saveFile(getAllFiles.get("MandatoryToolKitPics"), path);
				if(status==null)
				{
					/*
					 * Error saving the file at desired location
					 */
					return null;
				}
				
				/*
				 * Setting path of file in hashmap to save in database
				 */
				
				setPaths.put("mandatoryToolKitPicsPath", path.toString());
			}
	
			/*
			 * End of MandatoryToolKitPics path storing and setting path
			 */
			
			/*
			 * Checking for file corresponding to mandatoryToolKitAnnexure and saving and setting its path
			 */

			if(getAllFiles.get("MandatoryToolKitAnnexure")==null)
			{
				/*
				 * No file is present 
				 */
				setPaths.put("mandatoryToolKitAnnexurePath",trainingPartnerCenterDetailsList.get(temp).getMandatoryToolKitAnnexurePath());
			}
			else
			{
				/*
				 * Saving file at desired location & setting its path in HashMap
				 */
				String fullFileName= getAllFiles.get("MandatoryToolKitAnnexure").getOriginalFilename();
				int indexOfDot=fullFileName.indexOf(".");
				String fileExtension= fullFileName.substring(indexOfDot);
				
				/*
				 * Setting path of format centerId->MandatoryToolKitPicsFileExtension
				 */
				Path path = Paths.get(createCenterIdFolder.getAbsolutePath()+"//MandatoryToolKitAnnexure"+fileExtension);
				
				/*
				 * Saving file at desired location
				 */
				
				String status=profileCreationSaveFile.saveFile(getAllFiles.get("MandatoryToolKitAnnexure"), path);
				if(status==null)
				{
					/*
					 * Error saving the file at desired location
					 */
					return null;
				}
				
				/*
				 * Setting path of file in hashmap to save in database
				 */
				
				setPaths.put("mandatoryToolKitAnnexurePath", path.toString());
			}
	
			/*
			 * End of MandatoryToolKitAnnexure path storing and setting path
			 */
			
			/*
			 * After setting the paths it hashmap ,we will not update the paths in database
			 */
			
			int statusOfUpdatePaths=profileCreationTrainingPartnerUpdateDataDao.updatePathsIntoTrainingPartnerCenterLevelDetails(setPaths, trainingPartnerCenterId);
			
			if(statusOfUpdatePaths==-1)
			{
				/*
				 * An error occurred while updating paths 
				 */
				return null;
			}
			
			
			/*
			 * Setting and saving details of Operation head ,Affiliation Coordinator ,SPOC 
			 */
			
			

			if(trainingPartnerManagementAndStaffAndOfficialsDetailsList.get(temp).getType().equalsIgnoreCase("OH") ||
					trainingPartnerManagementAndStaffAndOfficialsDetailsList.get(temp).getType().equalsIgnoreCase("AC")||
					trainingPartnerManagementAndStaffAndOfficialsDetailsList.get(temp).getType().equalsIgnoreCase("SPOC"))
			{
				int managementAndStaffId;
				/*
				 * Check if centerId is present or not 
				 * if present then update query
				 * else insert query
				 */
				
				if(trainingPartnerManagementAndStaffAndOfficialsDetailsList.get(temp).getManagementAndStaffId()==null)
				{
					/*
					 * Run insert query
					 */
					
					managementAndStaffId=profileCreationTrainingPartnerInsertDataDao.insertIntoTrainingPartnerManagementAndStaffAndOfficialsDetails(trainingPartnerManagementAndStaffAndOfficialsDetailsList.get(temp));
					if(managementAndStaffId==-1)
					{
						/*
						 * Error occurred while inserting data in database 
						 */
						return null;
					}
				}
				else
				{
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
				 * Set paths for CV'S  depending upon the type of user 
				 */
		
				HashMap<String, MultipartFile> getCVFiles = new HashMap<String, MultipartFile>();
				getCVFiles = trainingPartnerCenterLevelAHOCSPOCDetailsFiles.get("Record"+temp++);
			
				/*
				 * Declaring HashMap to set paths of various files to store in DB 
				 */
		
				HashMap<String, String> setCVPaths = new HashMap<String, String>();
		
					/*
					 * If DirectorsAndManagementTeamMembers 
					 * now checking if file corresponding to CV is present or not 
					 */
					
					if(getCVFiles.get("CV")==null)
					{
						/*
						 * No file is present 
						 */
						setCVPaths.put("cVPath",trainingPartnerManagementAndStaffAndOfficialsDetailsList.get(temp).getcVPath());
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
						Path path=Paths.get(createCenterIdFolder.getAbsolutePath()+"//"+firstFileName+"-"+managementAndStaffId+fileExtension);
						
						/*
						 * Saving file at Desired Location
						 */
						
						String status = profileCreationSaveFile.saveFile(getCVFiles.get("CV"), path);
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
						
						setCVPaths.put("cVPath",path.toString());	
					}
					
					setCVPaths.put("certificatePath", null);
				
				/*
				 * Running update query for setting the cv and certificate paths
				 */
				
					int statusOfUpdatePathsOfCV=profileCreationTrainingPartnerUpdateDataDao.updatePathsIntoTrainingPartnerManagementAndStaffAndOfficialsDetails(setPaths, managementAndStaffId,String.valueOf(trainingPartnerCenterId));
					
					if(statusOfUpdatePathsOfCV==-1)
					{
						/*
						 * An error occurred while updating  CV paths 
						 */
						return null;
					}
				
				
			}

		} //END of For Loop
	
		return null;
	}
		catch(Exception e)
		{
			/*
			 * An exception occured while setting data and saving files for Center details Table
			 */
			e.printStackTrace();
			return null;
		}
		}

}
