package com.skill.India.service;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.skill.India.common.ReadApplicationConstants;
import com.skill.India.common.SessionUserUtility;
import com.skill.India.dao.GetUserRoleDao;
import com.skill.India.dao.ProfileCreationTPABCommonDao;
import com.skill.India.dao.ProfileCreationTrainingPartnerInsertDataDao;
import com.skill.India.dao.ProfileCreationTrainingPartnerUpdateDataDao;
import com.skill.India.dto.ProfileCreationAssessmentBodyAffiliationDetailsDto;
import com.skill.India.dto.ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto;
import com.skill.India.dto.ProfileCreationAssessmentBodyRecognitionsDto;
import com.skill.India.dto.ProfileCreationAssessmentBodyRegionalOfficeDetailsDto;
import com.skill.India.dto.ProfileCreationAssessmentBodyRegistrationDetailsDto;
import com.skill.India.dto.ProfileCreationAssessmentStaffDetailsDto;
import com.skill.India.dto.ProfileCreationAssessmentsExperienceInTechnicalDomainDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerCenterDetailsDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerInstituteGrantDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerInstituteRecognitionDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerOrganizationDetailsDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto;

@Service
public class ProfileCreationSaveAsDraftAndSubmitService {

	@Autowired
	private SessionUserUtility sessionUserUtility;
	
	@Autowired
	private ProfileCreationTPABCommonDao profileCreationTPABCommonDao;
	
	@Autowired
	private GetUserRoleDao getUserRoleDao;
	
	@Autowired
	private ReadApplicationConstants readApplicationConstants;
	
	@Autowired
	private ProfileCreationTrainingPartnerOrganizationDetailsService profileCreationTrainingPartnerOrganizationDetailsService;
	
	@Autowired
	private ProfileCreationTrainingPartnerInstituteGrantService profileCreationTrainingPartnerInstituteGrantService;
	
	@Autowired
	private ProfileCreationTrainingPartnerInstituteRecognitionService profileCreationTrainingPartnerInstituteRecognitionService;
	
	@Autowired
	private ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingService profileCreationTrainingPartnerPriorExperienceInSkillTrainingService;
	
	@Autowired
	private ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsService profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsService;
	
	@Autowired
	private ProfileCreationTrainingPartnerCenterDetailsService profileCreationTrainingPartnerCenterDetailsService;
	
	public String profileCreationSaveAsDraftAndSubmit(String type,HashMap<String, HashMap<String, HashMap<String, String>>> userData,HashMap<String, HashMap<String, HashMap<String, MultipartFile>>> userUploads,HashMap<String, HashMap<String, HashMap<String, String>>> userDeletes)
	{
		try{
			/*
			 * Inserting or updating Application Table
			 */
			
		int userExists=sessionUserUtility.getApplicationId(sessionUserUtility.getSessionMangementfromSession().getUsername());
		
		if(userExists==-1)
		{
			/*
			 * User is logged in the system for first time
			 */ 
			int applicationTableStatus=profileCreationTPABCommonDao.insertIntoApplication(type);
			
			if(applicationTableStatus ==-1)
			{
				/*
				 * Error in inserting record in ApplicationTable
				 */
				return null;
			}
		}
		else if(userExists==-2)
		{
			/*
			 * An error occurred while getting applicationId 
			 */
			return null;
		}
		else
		{
			/*
			 * User already visited profile creation page once
			 */
			int applicationTableStatus=profileCreationTPABCommonDao.updateIntoApplication(type);
			if(applicationTableStatus ==-1)
			{
				/*
				 * Error in updating record in ApplicationTable
				 */
				return null;
			}
		}
		
		
		/*
		 * Application Table operation Ends here
		 */
		
		/*
		 * Getting applicationId 
		 */
		
		int applicationId = sessionUserUtility.getApplicationId(sessionUserUtility.getSessionMangementfromSession().getUsername());
		
		if(applicationId==-1)
		{
			/*
			 * ApplicationId corresponding userId doesn't exists
			 * (this case must not arise)
			 */
			return null;
		}
		else if(applicationId==-2)
		{
			/*
			 * Error in fetching ApplicationId  
			 */
			return null;
		}
		
		/*
		 * End of getting ApplicationId
		 */
		
		/*
		 * Getting UserRole
		 */
		
		String userRole=getUserRoleDao.getUserRole();
		if(userRole.equalsIgnoreCase("TP"))
		{
			/*
			 * Iterating HashMap to set TP different dto's 
			 */
			
			HashMap<String, HashMap<String, String>> trainingPartnerOrganizationDetails=userData.get("TrainingPartnerOrganizationDetails");
			HashMap<String, HashMap<String, MultipartFile>> trainingPartnerOrganizationDetailsFiles=userUploads.get("TrainingPartnerOrganizationDetails");
			
			HashMap<String, HashMap<String, String>> trainingPartnerCenterLevelDetails=userData.get("TrainingPartnerCenterLevelDetails");
			HashMap<String, HashMap<String, MultipartFile>> trainingPartnerCenterLevelDetailsFiles=userUploads.get("TrainingPartnerCenterLevelDetails");
			HashMap<String, HashMap<String, String>> trainingPartnerCenterLevelDetailsDeletes=userDeletes.get("TrainingPartnerCenterLevelDetails");
			
			HashMap<String, HashMap<String, String>> trainingPartnerCenterLevelAHOCSPOCDetails = userData.get("TrainingPartnerCenterLevelAHOCSPOCDetails");
			HashMap<String, HashMap<String, MultipartFile>> trainingPartnerCenterLevelAHOCSPOCDetailsFiles = userUploads.get("TrainingPartnerCenterLevelAHOCSPOCDetails");
			
			
			HashMap<String, HashMap<String, String>> trainingPartnerInstituteGrant=userData.get("TrainingPartnerInstituteGrant");
			HashMap<String, HashMap<String, String>> trainingPartnerInstituteGrantDeletes=userDeletes.get("TrainingPartnerInstituteGrant");
			
			HashMap<String, HashMap<String, String>> trainingPartnerInstituteRecognition=userData.get("TrainingPartnerInstituteRecognition");
			HashMap<String, HashMap<String, String>> trainingPartnerInstituteRecognitionDeletes=userDeletes.get("TrainingPartnerInstituteRecognition");
			
			HashMap<String, HashMap<String, String>> trainingPartnerPriorExperienceInSkillTraining=userData.get("TrainingPartnerPriorExperienceInSkillTraining");
			HashMap<String, HashMap<String, String>> trainingPartnerPriorExperienceInSkillTrainingDeletes=userDeletes.get("TrainingPartnerPriorExperienceInSkillTraining");
			 
			HashMap<String, HashMap<String, String>> trainingPartnerManagementAndStaffAndOfficialsDetails=userData.get("TrainingPartnerManagementAndStaffAndOfficialsDetails");
			HashMap<String, HashMap<String, MultipartFile>> trainingPartnerManagementAndStaffAndOfficialsDetailsFiles=userUploads.get("TrainingPartnerManagementAndStaffAndOfficialsDetails");
			HashMap<String, HashMap<String, String>> trainingPartnerManagementAndStaffAndOfficialsDetailsDeletes=userDeletes.get("TrainingPartnerManagementAndStaffAndOfficialsDetails");
			
			/*
			 * Setting different Dto's
			 */
			
			
			/*
			 * Setting of Dto's Ends here
			 */
			
			
			if(userRole.equalsIgnoreCase("TP"))
			{
				/*
				 * Creating folder Structure for Training Partner(Not of Centers)
				 */
				
				File createTrainingPartnerFolder = new File(readApplicationConstants.getProfileCreationTrainingPartnerFolder()+"//"+ applicationId);
				File createInstituteGrantFolder = new File(createTrainingPartnerFolder.getAbsolutePath()+"//InstituteGrant");
				File createDirectorsAndManagementTeamMembersFolder = new File(createTrainingPartnerFolder.getAbsolutePath()+"//DirectorsAndManagementTeamMembers");
				File createTrainingStaffFolder = new File(createTrainingPartnerFolder.getAbsolutePath()+"//TrainingStaff");
				File createAnnexuresFolder = new File(createTrainingPartnerFolder.getAbsolutePath()+"//Annexures");
				File createTrainingStaffCVFolder = new File(createTrainingStaffFolder.getAbsolutePath()+"//CV");
				File createTrainingStaffCertificateFolder = new File(createTrainingStaffFolder.getAbsolutePath()+"//Certificate");
				File createCentersFolder = new File(createTrainingPartnerFolder.getAbsolutePath()+"//Centers");
				
				
				if(!createTrainingPartnerFolder.exists())
				{
					try{
					if(!createTrainingPartnerFolder.mkdirs())
					{
					// directory creation failed 
					}
					if(!createInstituteGrantFolder.mkdir())
					{
					// directory creation failed
					}
					if(!createDirectorsAndManagementTeamMembersFolder.mkdir())
					{
					// directory creation failed
					}		
					if(!createTrainingStaffFolder.mkdir())
					{
					// directory creation failed
					}
					if(!createAnnexuresFolder.mkdir())
					{
					// directory creation failed
					}
					if(!createTrainingStaffCVFolder.mkdir())
					{
					// directory creation failed
					}
					if(!createTrainingStaffCertificateFolder.mkdir())
					{
					// directory creation failed	
					}
					if(!createCentersFolder.mkdir())
					{
					// directory creation failed	
					}
				}
				catch(Exception e)
				{
					/*
					 * Exception occurs while creating folder Structure
					 * Hence deleting the created folder Structure 
					 */
					e.printStackTrace();
					FileUtils.deleteDirectory(createTrainingPartnerFolder);
					return null;
				}
				}
				
				else
				{
					// Do whatever is required Folder with name of applicationId is present 
				}
				
				/*
				 * End of Creating Folder Structure for Organization level details for saving files 
				 */
	
				/*
				 * Start calling Services of various tables to store data in DB & save files 
				 */
				
				/*
				 * Calling service of TrainingPartnerOrganizationDetails
				 */
				
				String statusOfTrainingPartnerOrganizationDetails = profileCreationTrainingPartnerOrganizationDetailsService.setTrainingPartnerOrganizationDetails(trainingPartnerOrganizationDetails, trainingPartnerOrganizationDetailsFiles, createTrainingPartnerFolder, createAnnexuresFolder, userExists);
				
				if(statusOfTrainingPartnerOrganizationDetails==null)
				{
					/*
					 * An error occurred while saving files and inserting data in database 
					 */
					return null;
				}
				
				/*
				 * Calling service of TrainingPartnerInstituteGrant 
				 */
				
				String statusOfTrainingPartnerInstituteGrant = profileCreationTrainingPartnerInstituteGrantService.setTrainingPartnerInstituteGrant(trainingPartnerInstituteGrant,trainingPartnerInstituteGrantDeletes);
				if(statusOfTrainingPartnerInstituteGrant==null)
				{
					
					/*
					 * An error occurred while saving files and inserting data in database
					 */
					return null;
				}
				
				/*
				 * Calling service of TrainingPartnerInstituteRecognition 
				 */
				
				String statusOfTrainingPartnerInstituteRecognition = profileCreationTrainingPartnerInstituteRecognitionService.setTrainingPartnerInstituteRecognition(trainingPartnerInstituteRecognition, trainingPartnerInstituteRecognitionDeletes);
				if(statusOfTrainingPartnerInstituteRecognition==null)
				{
					
					/*
					 * An error occurred while saving files and inserting data in database
					 */
					return null;
				}
				
				/*
				 * Calling service of TrainingPartnerPriorExperienceInSkillTraining 
				 */
				
				String statusOfTrainingPartnerPriorExperienceInSkillTraining = profileCreationTrainingPartnerPriorExperienceInSkillTrainingService.setTrainingPartnerPriorExperienceInSkillTraining(trainingPartnerPriorExperienceInSkillTraining, trainingPartnerPriorExperienceInSkillTrainingDeletes);
				if(statusOfTrainingPartnerPriorExperienceInSkillTraining==null)
				{
					
					/*
					 * An error occurred while saving files and inserting data in database
					 */
					return null;
				}
				
				
				/*
				 * Calling service of TrainingPartnerManagementAndStaffAndOfficialsDetails 
				 */
				
				String statusOfTrainingPartnerManagementAndStaffAndOfficialsDetails = profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsService.setTrainingPartnerManagementAndStaffAndOfficialsDetails(trainingPartnerManagementAndStaffAndOfficialsDetails, trainingPartnerManagementAndStaffAndOfficialsDetailsDeletes, trainingPartnerManagementAndStaffAndOfficialsDetailsFiles, createDirectorsAndManagementTeamMembersFolder, createTrainingStaffCVFolder, createTrainingStaffCertificateFolder);
				if(statusOfTrainingPartnerManagementAndStaffAndOfficialsDetails==null)
				{
					
					/*
					 * An error occurred while saving files and inserting data in database
					 */
					return null;
				}

				/*
				 * Calling service of TrainingPartnerCenterLevelDetails 
				 */
				
				String statusOfTrainingPartnerCenterLevelDetails = profileCreationTrainingPartnerCenterDetailsService.setTrainingPartnerCenterDetails(trainingPartnerCenterLevelDetails, trainingPartnerCenterLevelDetailsDeletes, trainingPartnerCenterLevelDetailsFiles, createCentersFolder, trainingPartnerCenterLevelAHOCSPOCDetails, trainingPartnerCenterLevelAHOCSPOCDetailsFiles);
				if(statusOfTrainingPartnerCenterLevelDetails==null)
				{
					
					/*
					 * An error occurred while saving files and inserting data in database
					 */
					return null;
				}
				
				
				
			}

			
		}
		else if(userRole.equalsIgnoreCase("AB"))
		{
			/*
			 * Iterating HashMap to set AB different dto's 
			 */
			
			HashMap<String, HashMap<String, String>> assessmentBodyRegistrationDetails=userData.get("AssessmentBodyRegistrationDetails");
			HashMap<String, HashMap<String, String>> assessmentBodyRecognitions=userData.get("AssessmentBodyRecognitions");
			HashMap<String, HashMap<String, String>> assessmentsExperienceInTechnicalDomain=userData.get("AssessmentsExperienceInTechnicalDomain");
			HashMap<String, HashMap<String, String>> assessmentBodyDirectorsAndManagementTeamDetail=userData.get("AssessmentBodyDirectorsAndManagementTeamDetails"); 
			HashMap<String, HashMap<String, String>> assessmentStaffDetails=userData.get("AssessmentStaffDetails");
			HashMap<String, HashMap<String, String>> assessmentBodyRegionalOfficeDetails=userData.get("AssessmentBodyRegionalOfficeDetails");
			HashMap<String, HashMap<String, String>> assessmentBodyAffiliationDetails=userData.get("AssessmentBodyAffiliationDetails"); 
			
			/*
			 * Setting different Dto's
			 */
			

			/*
			 * Creating Folder Structure for Organization level details for saving files 
			 */
			

			
		}
		else 
		{
			/*
			 * Error in getting the User Role 
			 */
		}
		
		
		return null;
		}
		catch(Exception e)
		
		{
			e.printStackTrace();
			return null;
		}
	}
}
