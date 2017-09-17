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

import com.skill.India.dao.ProfileCreationTrainingPartnerInsertDataDao;
import com.skill.India.dao.ProfileCreationTrainingPartnerUpdateDataDao;
import com.skill.India.dto.ProfileCreationTrainingPartnerOrganizationDetailsDto;

@Service
public class ProfileCreationTrainingPartnerOrganizationDetailsService {

	@Autowired
	private ProfileCreationSaveFile profileCreationSaveFile;
	
	@Autowired
	private ProfileCreationTrainingPartnerInsertDataDao profileCreationTrainingPartnerInsertDataDao;
	
	@Autowired
	private ProfileCreationTrainingPartnerUpdateDataDao profileCreationTrainingPartnerUpdateDataDao;
	
	
	public String setTrainingPartnerOrganizationDetails(HashMap<String, HashMap<String, String>> trainingPartnerOrganizationDetails,HashMap<String, HashMap<String, MultipartFile>> trainingPartnerOrganizationDetailsFiles,File createTrainingPartnerFolder,File createAnnexuresFolder,int userExists)
	{
		try{
			
		/*
		 * ProfileCreationTrainingPartnerOrganizationDetailsDto Setting starts
		 */
		
		ArrayList<ProfileCreationTrainingPartnerOrganizationDetailsDto> trainingPartnerOrganizationDetailsList = new ArrayList<ProfileCreationTrainingPartnerOrganizationDetailsDto>();
		
		for(Map.Entry<String, HashMap<String, String>> trainingPartnerOrganizationDetailsIterator:trainingPartnerOrganizationDetails.entrySet())
		{
			/*
			 * Setting the incoming data in  respective DTO's ProfileCreationTrainingPartnerOrganizationDetailsDto
			 */
			HashMap<String, String> setProfileCreationTrainingPartnerOrganizationDetailsDto= new HashMap<String, String>();
			setProfileCreationTrainingPartnerOrganizationDetailsDto=trainingPartnerOrganizationDetailsIterator.getValue();
			trainingPartnerOrganizationDetailsList.add(new ProfileCreationTrainingPartnerOrganizationDetailsDto(
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("trainingPartnerRegistrationId"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("applicationId"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("organizationName"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("sPOCName"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("address"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("city"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("state"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("pincode"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("mobileNumber"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("alternateMobileNumber"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("landlineNumber"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("alternateLandlineNumber"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("faxNumber"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("websites"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("yearOfEstablishment"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("qualificationPacks"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("qualificationPacksAnnexurePath"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("nSDCFunded"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("nSDCFundedCertificatePath"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("mediumOfInstructions"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("selfOwnedInstitution"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("selfOwnedInstitutionAnnexurePath"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("franchiseOwnedInstitution"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("franchiseOwnedInstitutionAnnexurePath"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("mobileTrainingInstitution"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("mobileTrainingInstitutionAnnexurePath"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("panNumber"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("panNumberPath"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("tanNumber"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("tanNumberPath"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("turnOverOfInstitution"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("turnOverOfInstitutionBalanceSheetPath"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("instituteReceivedAnyGrant"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("instituteReceivedAnyRecognition"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("priorExperienceOfInstitutionInSkillDevelopment"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("anyPriorExperienceOfInstitutionInSkillTraining"),
					setProfileCreationTrainingPartnerOrganizationDetailsDto.get("trainingStaffDetailsAnnexurePath")
					));
		}
		
		/*
		 * End of setting of ProfileCreationTrainingPartnerOrganizationDetailsDto Setting
		 */
		

		/*
		 * Iterating Arraylist trainingPartnerOrganizationDetailsList  
		 */
		
		for(int temp=0;temp<trainingPartnerOrganizationDetailsList.size();temp++)
		{
			/*
			 * Set paths of qualificationPacksAnnexurePath,nSDCFundedCertificatePath
			 * selfOwnedInstitutionAnnexurePath, franchiseOwnedInstitutionAnnexurePath
			 * mobileTrainingInstitutionAnnexurePath, panNumberPath, tanNumberPath
			 * turnOverOfInstitutionBalanceSheetPath
			 * 
			 * Iterate trainingPartnerOrganizationDetailsFiles and save files
			 */
			
			HashMap<String, MultipartFile> getAllFiles = new HashMap<String, MultipartFile>();
			getAllFiles = trainingPartnerOrganizationDetailsFiles.get("Record"+temp++);
			
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
				
				setPaths.put("panNumberPath",trainingPartnerOrganizationDetailsList.get(temp).getPanNumberPath());
			}
			else
			{
				/*
				 * Setting path where to save Pan number file 
				 */
				
				Path path=Paths.get(createTrainingPartnerFolder.getAbsolutePath()+"//PanNumber.pdf");
				
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
				
				setPaths.put("tanNumberPath",trainingPartnerOrganizationDetailsList.get(temp).getTanNumberPath());
			}
			else
			{
				/*
				 * Setting path where to save Tan number file 
				 */
				
				Path path=Paths.get(createTrainingPartnerFolder.getAbsolutePath()+"//TanNumber.pdf");
				
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
			 * Now start extracting Turn Over from getAllFiles hashmap
			 */
			
			if(getAllFiles.get("TurnOver")==null)
			{
				/*
				 * No file is coming for TurnOver
				 */
				
				setPaths.put("turnOverOfInstitutionBalanceSheetPath",trainingPartnerOrganizationDetailsList.get(temp).getTurnOverOfInstitutionBalanceSheetPath());
			}
			else
			{
				/*
				 * Setting path where to save TurnOver file 
				 */
				
				Path path=Paths.get(createTrainingPartnerFolder.getAbsolutePath()+"//TurnOver.pdf");
				
				/*
				 * Call ProfileCreationSaveFile with actual parameters to save file 
				 */
				
				String status=profileCreationSaveFile.saveFile(getAllFiles.get("TurnOver"), path);
				
				if(status==null)
				{
					/*
					 * Error Saving file on system
					 */
				}
				
				
				/*
				 * Set turnOverOfInstitutionBalanceSheetPath accordingly 
				 */
				
				setPaths.put("turnOverOfInstitutionBalanceSheetPath", path.toString());
			}
			
			/*
			 * Extracting of TurnOver Ends 
			 */
			
			
			/*
			 * Now start extracting QualificationPackAnnexure from getAllFiles hashmap
			 */
			
			if(getAllFiles.get("QualificationPacksAnnexure")==null)
			{
				/*
				 * No file is coming for QualificationPackAnnexure
				 */
				
				setPaths.put("qualificationPacksAnnexurePath",trainingPartnerOrganizationDetailsList.get(temp).getQualificationPacksAnnexurePath());
			}
			else
			{
				/*
				 * Setting path where to save QualificationPacksAnnexure file 
				 */
				
				Path path=Paths.get(createAnnexuresFolder.getAbsolutePath()+"//QualificationPacksAnnexure.pdf");
				
				/*
				 * Call ProfileCreationSaveFile with actual parameters to save file 
				 */
				String status=profileCreationSaveFile.saveFile(getAllFiles.get("QualificationPacksAnnexure"), path);
				
				if(status==null)
				{
					/*
					 * Error Saving file on system
					 */
				}
				
				/*
				 * Set qualificationPacksAnnexurePath accordingly 
				 */
				
				setPaths.put("qualificationPacksAnnexurePath", path.toString() );
			}
			
			/*
			 * Extracting of QualificationPackAnnexure Ends 
			 */
			
			
			/*
			 * Now start extracting NSDCFundedCertificate from getAllFiles hashmap
			 */
			
			if(getAllFiles.get("NSDCFundedCertificate")==null)
			{
				/*
				 * No file is coming for Tan Number
				 */
				
				setPaths.put("nSDCFundedCertificatePath",trainingPartnerOrganizationDetailsList.get(temp).getnSDCFundedCertificatePath());
			}
			else
			{
				/*
				 * Setting path where to save NSDCFundedCertificate file 
				 */
				
				Path path=Paths.get(createTrainingPartnerFolder.getAbsolutePath()+"//NSDCFundedCertificate.pdf");
				
				/*
				 * Call ProfileCreationSaveFile with actual parameters to save file 
				 */
				
				String status=profileCreationSaveFile.saveFile(getAllFiles.get("NSDCFundedCertificate"), path);
				
				if(status==null)
				{
					/*
					 * Error Saving file on system
					 */
				}
				
				/*
				 * Set nSDCFundedCertificatePath accordingly 
				 */
				
				setPaths.put("nSDCFundedCertificatePath", path.toString());
			}
			
			/*
			 * Extracting of NSDCFundedCertificate Ends 
			 */
			
			/*
			 * Now start extracting SelfOwnedInstitutionAnnexure from getAllFiles hashmap
			 */
			
			if(getAllFiles.get("SelfOwnedInstitutionAnnexure")==null)
			{
				/*
				 * No file is coming for SelfOwnedInstitutionAnnexure
				 */
				
				setPaths.put("selfOwnedInstitutionAnnexurePath",trainingPartnerOrganizationDetailsList.get(temp).getSelfOwnedInstitutionAnnexurePath());
			}
			else
			{
				/*
				 * Setting path where to save SelfOwnedInstitutionAnnexure file 
				 */
				
				Path path=Paths.get(createAnnexuresFolder.getAbsolutePath()+"//SelfOwnedInstitutionAnnexure.pdf");
				
				/*
				 * Call ProfileCreationSaveFile with actual parameters to save file 
				 */
				
				String status=profileCreationSaveFile.saveFile(getAllFiles.get("SelfOwnedInstitutionAnnexure"), path);
				
				if(status==null)
				{
					/*
					 * Error Saving file on system
					 */
				}
				
				/*
				 * Set selfOwnedInstitutionAnnexurePath accordingly 
				 */
				
				setPaths.put("selfOwnedInstitutionAnnexurePath", path.toString());
			}
			
			/*
			 * Extracting of SelfOwnedInstitutionAnnexure Ends 
			 */
			
			/*
			 * Now start extracting FranchiseOwnedInstitutionAnnexure from getAllFiles hashmap
			 */
			
			if(getAllFiles.get("FranchiseOwnedInstitutionAnnexure")==null)
			{
				/*
				 * No file is coming for FranchiseOwnedInstitutionAnnexure
				 */
				
				setPaths.put("franchiseOwnedInstitutionAnnexurePath",trainingPartnerOrganizationDetailsList.get(temp).getFranchiseOwnedInstitutionAnnexurePath());
			}
			else
			{
				/*
				 * Setting path where to save FranchiseOwnedInstitutionAnnexure file 
				 */
				
				Path path=Paths.get(createAnnexuresFolder.getAbsolutePath()+"//FranchiseOwnedInstitutionAnnexure.pdf");
				
				/*
				 * Call ProfileCreationSaveFile with actual parameters to save file 
				 */
				String status=profileCreationSaveFile.saveFile(getAllFiles.get("FranchiseOwnedInstitutionAnnexure"), path);
				
				if(status==null)
				{
					/*
					 * Error Saving file on system
					 */
				}
				/*
				 * Set franchiseOwnedInstitutionAnnexurePath accordingly 
				 */
				
				setPaths.put("franchiseOwnedInstitutionAnnexurePath", path.toString());
			}
			
			/*
			 * Extracting of FranchiseOwnedInstitutionAnnexure Ends 
			 */
			
			/*
			 * Now start extracting MobileTrainingInstitutionAnnexure from getAllFiles hashmap
			 */
			
			if(getAllFiles.get("MobileTrainingInstitutionAnnexure")==null)
			{
				/*
				 * No file is coming for MobileTrainingInstitutionAnnexure
				 */
				
				setPaths.put("mobileTrainingInstitutionAnnexurePath",trainingPartnerOrganizationDetailsList.get(temp).getMobileTrainingInstitutionAnnexurePath());
			}
			else
			{
				/*
				 * Setting path where to save MobileTrainingInstitutionAnnexure file 
				 */
				
				Path path=Paths.get(createAnnexuresFolder.getAbsolutePath()+"//MobileTrainingInstitutionAnnexure.pdf");
				
				/*
				 * Call ProfileCreationSaveFile with actual parameters to save file 
				 */
				String status=profileCreationSaveFile.saveFile(getAllFiles.get("MobileTrainingInstitutionAnnexure"), path);
				
				if(status==null)
				{
					/*
					 * Error Saving file on system
					 */
				}
				/*
				 * Set mobileTrainingInstitutionAnnexurePath accordingly 
				 */
				setPaths.put("mobileTrainingInstitutionAnnexurePath", path.toString());
			}
			
			/*
			 * Extracting of MobileTrainingInstitutionAnnexure Ends 
			 */
			
			
			/*
			 * Now start extracting trainingStaffDetailsAnnexure from getAllFiles hashmap
			 */
			
			if(getAllFiles.get("TrainingStaffDetailsAnnexure")==null)
			{
				/*
				 * No file is coming for MobileTrainingInstitutionAnnexure
				 */
				
				setPaths.put("trainingStaffDetailsAnnexurePath",trainingPartnerOrganizationDetailsList.get(temp).getTrainingStaffDetailsAnnexurePath());
			}
			else
			{
				/*
				 * Setting path where to save trainingStaffDetailsAnnexure file 
				 */
				
				Path path=Paths.get(createAnnexuresFolder.getAbsolutePath()+"//TrainingStaffDetailsAnnexure.pdf");
				
				/*
				 * Call ProfileCreationSaveFile with actual parameters to save file 
				 */
				String status=profileCreationSaveFile.saveFile(getAllFiles.get("TrainingStaffDetailsAnnexure"), path);
				
				if(status==null)
				{
					/*
					 * Error Saving file on system
					 */
				}
				/*
				 * Set trainingStaffDetailsAnnexurePath accordingly 
				 */
				setPaths.put("trainingStaffDetailsAnnexurePath", path.toString());
			}
			
			/*
			 * Extracting of TrainingStaffDetailsAnnexure Ends 
			 */
			

			/*
			 * Setting Database of TrainingPartnerOrganizationDetails
			 */
			
			
			if(userExists==-1)
			{
				/*
				 * Insert into database
				 */
				
				int status=profileCreationTrainingPartnerInsertDataDao.insertIntoTrainingPartnerOrganizationDetails(trainingPartnerOrganizationDetailsList.get(temp),setPaths);
				
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
				
				int status = profileCreationTrainingPartnerUpdateDataDao.updateIntoTrainingPartnerOrganizationDetails(trainingPartnerOrganizationDetailsList.get(temp),setPaths);
			
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
			
		}
	
		return null;
		}
		catch(Exception e)
		{
			/*
			 * Error occurs while saving file and inserting data in Database
			 */
			e.printStackTrace();
			
			return null;
		}
		
	}
}
