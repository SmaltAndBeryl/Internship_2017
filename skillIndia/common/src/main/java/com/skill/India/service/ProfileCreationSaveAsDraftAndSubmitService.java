package com.skill.India.service;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProfileCreationSaveAsDraftAndSubmitService.class);

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
	
	@Autowired
	private ProfileCreationAssessmentBodyRegistrationDetailsService profileCreationAssessmentBodyRegistrationDetailsService;
	
	@Autowired
	private ProfileCreationAssessmentBodyRecognitionsService profileCreationAssessmentBodyRecognitionsService;
	
	@Autowired
	private ProfileCreationAssessmentsExperienceInTechnicalDomainService profileCreationAssessmentsExperienceInTechnicalDomainService;
	
	@Autowired
	private ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsService profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsService;
	
	@Autowired
	private ProfileCreationAssessmentBodyRegionalOfficeDetailsService profileCreationAssessmentBodyRegionalOfficeDetailsService;
	
	@Autowired
	private ProfileCreationAssessmentStaffDetailsService profileCreationAssessmentStaffDetailsService;
	
	@Autowired
	private ProfileCreationAssessmentBodyAffiliationDetailsService profileCreationAssessmentBodyAffiliationDetailsService;
	
	
	
	public String profileCreationSaveAsDraftAndSubmit(String type,HashMap<String, HashMap<String, HashMap<String, String>>> userData,HashMap<String, HashMap<String, HashMap<String, MultipartFile>>> userUploads,HashMap<String, HashMap<String, HashMap<String, String>>> userDeletes)
	{
		try{
			/*
			 * Inserting or updating Application Table
			 */
			LOGGER.info("Trying to get application Id of the user from the session");
		int userExists=sessionUserUtility.getApplicationId(sessionUserUtility.getSessionMangementfromSession().getUsername());
		
		if(userExists==-1)
		{
			/*
			 * User is logged in the system for first time
			 */ 
			LOGGER.info("User has logged in for the first time ");
			LOGGER.info("Trying to create new application for the logged in user");
			int applicationTableStatus=profileCreationTPABCommonDao.insertIntoApplication(type);
			
			if(applicationTableStatus ==-1)
			{
				/*
				 * Error in inserting record in ApplicationTable
				 */
				LOGGER.info("Could not create application for user.Error occuerd in creation of application");
				return null;
			}
		}
		else if(userExists==-2)
		{
			/*
			 * An error occurred while getting applicationId 
			 */
			LOGGER.info("Could not find if user has logged in before. Error occured");
			return null;
		}
		else
		{
			/*
			 * User already visited profile creation page once
			 */
			
			LOGGER.info("Logged in user has already created an application.");
			LOGGER.info("Trying to update the already creadted application");
			int applicationTableStatus=profileCreationTPABCommonDao.updateIntoApplication(type);
			if(applicationTableStatus ==-1)
			{
				/*
				 * Error in updating record in ApplicationTable
				 */
				LOGGER.info("Could not update existing application of user. An error occured");
				return null;
			}
		}
		
		
		/*
		 * Application Table operation Ends here
		 */
		
		/*
		 * Getting applicationId 
		 */
		LOGGER.info("Trying to get application Id created for user");
		int applicationId = sessionUserUtility.getApplicationId(sessionUserUtility.getSessionMangementfromSession().getUsername());
		
		if(applicationId==-1)
		{
			/*
			 * ApplicationId corresponding userId doesn't exists
			 * (this case must not arise)
			 */
			LOGGER.info("There is no application created for the logged in user");
			return null;
		}
		else if(applicationId==-2)
		{
			/*
			 * Error in fetching ApplicationId  
			 */
			LOGGER.info("Could not fetch application details for the logged in user");
			return null;
		}
		
		/*
		 * End of getting ApplicationId
		 */
		
		/*
		 * Getting UserRole
		 */
		LOGGER.info("Trying to find the role type of the user TP/AB");		
		String userRole=getUserRoleDao.getUserRole(sessionUserUtility.getSessionMangementfromSession().getUsername());
		if(userRole.equalsIgnoreCase("TP"))
		{
			/*
			 * Iterating HashMap to set TP different dto's 
			 */
			LOGGER.info("User role for logged in user is TP");
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
				 * Creating folder Structure paths for Training Partner(Not of Centers)
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
					/*
					 * Creating folder Structure for Training Partner(Not of Centers)
					 */
					LOGGER.info("Trying to create folder for user to upload files and save");
						try
						{
							
							LOGGER.info("Trying to create folder for user to save training partner details like PAN TAN");	
							if(!createTrainingPartnerFolder.mkdirs())					
							{
								// directory creation failed 
							}
							LOGGER.info("Trying to create folder for user to save details regarding institution grants");
							if(!createInstituteGrantFolder.mkdir())
							{
								LOGGER.info("Could not create folder for user to save details regarding institution grants. Some error occured");
							// directory creation failed
							}
							LOGGER.info("Trying to create folder for user to save details of Director and other management staff");
							if(!createDirectorsAndManagementTeamMembersFolder.mkdir())
							{
								LOGGER.info("Could not create folder for user to save details of Director and other management staff. An error occured");
							// directory creation failed
							}		
							LOGGER.info("Trying to create folder for user to save details of Training staff");
							if(!createTrainingStaffFolder.mkdir())
							{
								LOGGER.info("Colud not create folder for user to save details of Training staff. An error occured");
							// directory creation failed
							}
							LOGGER.info("Trying to create folder for user to save Annexures");
							if(!createAnnexuresFolder.mkdir())
							{
								LOGGER.info("Colud not create folder for user to save Annexures. An error occured");
								// directory creation failed
							}
							
							LOGGER.info("Trying to create folder for user to save training staff's CV");
							if(!createTrainingStaffCVFolder.mkdir())
							{
								LOGGER.info("Trying to create folder for user to save training staff's CV");
								// 	directory creation failed
							}
							
							LOGGER.info("Trying to create folder for user to save details of Training staff certificates");
							if(!createTrainingStaffCertificateFolder.mkdir())
							{
								LOGGER.info("Could not create foled for user to save details of Training staff certificates. An error occured");
							// directory creation failed	
							}
							LOGGER.info("Trying to create folder for user to save details of centers");
							if(!createCentersFolder.mkdir())
							{
								LOGGER.info("Could not create center folders. An error occured");
								// directory creation failed	
							}
				}
				catch(Exception e)
				{
					/*
					 * Exception occurs while creating folder Structure
					 * Hence deleting the created folder Structure 
					 */
					LOGGER.error("Exception in creating folders. The exception is -" + e);	
					//e.printStackTrace();
					FileUtils.deleteDirectory(createTrainingPartnerFolder);
					return null;
				}
				}
				
				else
				{
					LOGGER.info("Not creating folder strauctures as they already exists for logged in User.User can use the same");
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
			HashMap<String, HashMap<String, MultipartFile>> assessmentBodyRegistrationDetailsFiles=userUploads.get("AssessmentBodyRegistrationDetails");
			
			HashMap<String, HashMap<String, String>> assessmentBodyRecognitions=userData.get("AssessmentBodyRecognitions");
			HashMap<String, HashMap<String, String>> assessmentBodyRecognitionsDeletes=userDeletes.get("AssessmentBodyRecognitions");
			
			HashMap<String, HashMap<String, String>> assessmentsExperienceInTechnicalDomain=userData.get("AssessmentsExperienceInTechnicalDomain");
			HashMap<String, HashMap<String, String>> assessmentsExperienceInTechnicalDomainDeletes=userDeletes.get("AssessmentsExperienceInTechnicalDomain");
			
			HashMap<String, HashMap<String, String>> assessmentBodyDirectorsAndManagementTeamDetails=userData.get("AssessmentBodyDirectorsAndManagementTeamDetails"); 
			HashMap<String, HashMap<String, String>> assessmentBodyDirectorsAndManagementTeamDetailsDeletes=userDeletes.get("AssessmentBodyDirectorsAndManagementTeamDetails");
			HashMap<String, HashMap<String, MultipartFile>> assessmentBodyDirectorsAndManagementTeamDetailsFiles=userUploads.get("AssessmentBodyDirectorsAndManagementTeamDetails");
			
			HashMap<String, HashMap<String, String>> assessmentStaffDetails=userData.get("AssessmentStaffDetails");
			HashMap<String, HashMap<String, String>> assessmentStaffDetailsDeletes=userDeletes.get("AssessmentStaffDetails");
			HashMap<String, HashMap<String, MultipartFile>> assessmentStaffDetailsFiles=userUploads.get("AssessmentStaffDetails");
			
			HashMap<String, HashMap<String, String>> assessmentBodyRegionalOfficeDetails=userData.get("AssessmentBodyRegionalOfficeDetails");
			HashMap<String, HashMap<String, String>> assessmentBodyRegionalOfficeDetailsDeletes=userDeletes.get("AssessmentBodyRegionalOfficeDetails");
			
			HashMap<String, HashMap<String, String>> assessmentBodyAffiliationDetails=userData.get("AssessmentBodyAffiliationDetails"); 
			HashMap<String, HashMap<String, String>> assessmentBodyAffiliationDetailsDeletes=userDeletes.get("AssessmentBodyAffiliationDetails");
			
			/*
			 * Setting different Dto's
			 */
			

			/*
			 * Creating Folder Structure for Assessment Body  
			 */
			
			File createAssessmentBodyFolder = new File(readApplicationConstants.getProfileCreationAssessmentBodyFolder()+"//"+ applicationId);	
			File createDirectorsAndManagementTeamMembersFolder = new File(createAssessmentBodyFolder.getAbsolutePath()+"//DirectorsAndManagementTeamMembers");
			File createAssessmentStaffFolder = new File(createAssessmentBodyFolder.getAbsolutePath()+"//AssessmentStaff");
			File createAssessmentStaffCVFolder = new File(createAssessmentStaffFolder.getAbsolutePath()+"//CV");
			File createAssessmentStaffCertificateFolder = new File(createAssessmentStaffFolder.getAbsolutePath()+"//Certificate");
			
			
			if(!createAssessmentBodyFolder.exists())
			{
				try{
				if(!createAssessmentBodyFolder.mkdirs())
				{
				// directory creation failed 
				}
				if(!createDirectorsAndManagementTeamMembersFolder.mkdir())
				{
				// directory creation failed
				}
				if(!createAssessmentStaffFolder.mkdir())
				{
				// directory creation failed
				}		
				if(!createAssessmentStaffCVFolder.mkdir())
				{
				// directory creation failed
				}
				if(!createAssessmentStaffCertificateFolder.mkdir())
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
				FileUtils.deleteDirectory(createAssessmentBodyFolder);
				return null;
			}
			}
			else
			{
				/*
				 * Folder with same name already  exists
				 */
			}
			
			
			/*
			 * End of Creating Folder Structure  
			 */

			/*
			 * Start calling Services of various tables to store data in DB & save files 
			 */
			
			/*
			 * Calling service of AssessmentBodyRegistrationDetails
			 */
			
			String statusOfAssessmentBodyRegistrationDetails= profileCreationAssessmentBodyRegistrationDetailsService.setAssessmentBodyRegistrationDetails(assessmentBodyRegistrationDetails, assessmentBodyRegistrationDetailsFiles, createAssessmentBodyFolder, userExists);
			
			if(statusOfAssessmentBodyRegistrationDetails==null)
			{
				/*
				 * An error occurred while saving files and inserting data in database 
				 */
				return null;
			}
			
			
			/*
			 * Calling service of AssessmentBodyRecognitions
			 */
			
			String statusOfAssessmentBodyRecognitions= profileCreationAssessmentBodyRecognitionsService.setAssessmentBodyRecognitions(assessmentBodyRecognitions, assessmentBodyRecognitionsDeletes);
			
			if(statusOfAssessmentBodyRecognitions==null)
			{
				/*
				 * An error occurred while saving files and inserting data in database 
				 */
				return null;
			}
			
			/*
			 * Calling service of AssessmentsExperienceInTechnicalDomain
			 */
			
			String statusOfAssessmentsExperienceInTechnicalDomain= profileCreationAssessmentsExperienceInTechnicalDomainService.setAssessmentsExperienceInTechnicalDomain(assessmentsExperienceInTechnicalDomain, assessmentsExperienceInTechnicalDomainDeletes);
			
			if(statusOfAssessmentsExperienceInTechnicalDomain==null)
			{
				/*
				 * An error occurred while saving files and inserting data in database 
				 */
				return null;
			}
			
			
			/*
			 * Calling service of AssessmentBodyDirectorsAndManagementTeamDetails
			 */
			
			String statusOfAssessmentBodyDirectorsAndManagementTeamDetails= profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsService.setAssessmentBodyDirectorsAndManagementTeamDetails(assessmentBodyDirectorsAndManagementTeamDetails, assessmentBodyDirectorsAndManagementTeamDetailsDeletes, assessmentBodyDirectorsAndManagementTeamDetailsFiles, createDirectorsAndManagementTeamMembersFolder);
			
			if(statusOfAssessmentBodyDirectorsAndManagementTeamDetails==null)
			{
				/*
				 * An error occurred while saving files and inserting data in database 
				 */
				return null;
			}
			
			/*
			 * Calling service of AssessmentStaffDetails
			 */
			
			String statusOfAssessmentStaffDetails= profileCreationAssessmentStaffDetailsService.setAssessmentStaffDetails(assessmentStaffDetails, assessmentStaffDetailsDeletes, assessmentStaffDetailsFiles, createAssessmentStaffCVFolder, createAssessmentStaffCertificateFolder);
			
			if(statusOfAssessmentStaffDetails==null)
			{
				/*
				 * An error occurred while saving files and inserting data in database 
				 */
				return null;
			}
			
			/*
			 * Calling service of AssessmentBodyRegionalOfficeDetails
			 */
			
			String statusOfAssessmentBodyRegionalOfficeDetails= profileCreationAssessmentBodyRegionalOfficeDetailsService.setAssessmentBodyRegionalOfficeDetails(assessmentBodyRegionalOfficeDetails, assessmentBodyRegionalOfficeDetailsDeletes);
			
			if(statusOfAssessmentBodyRegionalOfficeDetails==null)
			{
				/*
				 * An error occurred while saving files and inserting data in database 
				 */
				return null;
			}
			
			
			/*
			 * Calling service of AssessmentsExperienceInTechnicalDomain
			 */
			
			String statusOfAssessmentBodyAffiliationDetails= profileCreationAssessmentBodyAffiliationDetailsService.setAssessmentBodyAffiliationDetails(assessmentBodyAffiliationDetails, assessmentBodyAffiliationDetailsDeletes);
			
			if(statusOfAssessmentBodyAffiliationDetails==null)
			{
				/*
				 * An error occurred while saving files and inserting data in database 
				 */
				return null;
			}
	
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
