package com.skill.India.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.skill.India.common.ReadApplicationConstants;
import com.skill.India.common.SessionUserUtility;
import com.skill.India.dao.GetUserRoleDao;
import com.skill.India.dao.ProfileCreationAssessmentBodyGetDataDao;
import com.skill.India.dao.ProfileCreationAssessmentBodyInsertDataDao;
import com.skill.India.dao.ProfileCreationAssessmentBodyUpdateDataDao;
import com.skill.India.dao.ProfileCreationTPABCommonDao;
import com.skill.India.dao.ProfileCreationTrainingPartnerGetDataDao;
import com.skill.India.dao.ProfileCreationTrainingPartnerInsertDataDao;
import com.skill.India.dao.ProfileCreationTrainingPartnerUpdateDataDao;
import com.skill.India.dto.ProfileCreationAssessmentBodyAffiliationDetailsDto;
import com.skill.India.dto.ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto;
import com.skill.India.dto.ProfileCreationAssessmentBodyRecognitionsDto;
import com.skill.India.dto.ProfileCreationAssessmentBodyRegionalOfficeDetailsDto;
import com.skill.India.dto.ProfileCreationAssessmentBodyRegistrationDetailsDto;
import com.skill.India.dto.ProfileCreationAssessmentBodyWrapperDto;
import com.skill.India.dto.ProfileCreationAssessmentStaffDetailsDto;
import com.skill.India.dto.ProfileCreationAssessmentsExperienceInTechnicalDomainDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerCenterDetailsDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerInstituteGrantDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerInstituteRecognitionDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerOrganizationDetailsDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerTrainingStaffDetailsDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerWrapperDto;

@Service
public class ProfileCreationSaveAsDraftAndSubmitService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProfileCreationSaveAsDraftAndSubmitService.class);

	@Autowired
	private SessionUserUtility sessionUserUtility;
	
	@Autowired
	private ProfileCreationTPABCommonDao profileCreationTPABCommonDao;
	
	@Autowired
	private ProfileCreationAssessmentBodyGetDataDao profileCreationAssessmentBodyGetDataDao;
	
	@Autowired
	private GetUserRoleDao getUserRoleDao;
	
	@Autowired
	private ReadApplicationConstants readApplicationConstants;
	
	@Autowired
	private ProfileCreationAssessmentBodyInsertDataDao profileCreationAssessmentBodyInsertDataDao;
	
	@Autowired
	private ProfileCreationAssessmentBodyUpdateDataDao profileCreationAssessmentBodyUpdateDataDao;
	
	@Autowired
	private ProfileCreationTrainingPartnerInsertDataDao profileCreationTrainingPartnerInsertDataDao;
	
	@Autowired
	private ProfileCreationTrainingPartnerUpdateDataDao profileCreationTrainingPartnerUpdateDataDao;
	
	@Autowired
	private ProfileCreationTrainingPartnerGetDataDao profileCreationTrainingPartnerGetDataDao;
	
	@Autowired
	private ProfileCreationAssessmentBodyUpdateDataDao ProfileCreationAssessmentBodyUpdateDataDao;
	
	//To save the complete object to database
	public int SaveAssessmentBody(ProfileCreationAssessmentBodyWrapperDto profileCreationAssessmentBodyWrapperDto)
	{
		int returnStatus = 0, applicationTableStatus =0 , status =0, affiliationInsertionStatus =0, directorsAndManagementId = 0, assessmentBodyRecognition = 0, assessmentBodyRegionalOffice =0, assessmentBodyExperienceinTechnical =0, assessmentStaff =0;
		String applicationIdAfterInsertion =null;
		int userExists = getApplicationId();
		//New user
		if (userExists == -1)
		{
			applicationTableStatus = profileCreationTPABCommonDao.insertIntoApplication(profileCreationAssessmentBodyWrapperDto.getType());
			
			status=profileCreationAssessmentBodyInsertDataDao.insertIntoAssessmentBodyRegistrationDetails(profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentBodyRegistrationDetailsDto());

			//Once applicationId has been created
			
			applicationIdAfterInsertion = getAssessmentBodyRegistrationId(getApplicationId());
			
			if(!profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentBodyAffiliationDetailsDto().isEmpty())
			{
				for (ProfileCreationAssessmentBodyAffiliationDetailsDto profileCreationAssessmentBodyAffiliationDetailsDto:profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentBodyAffiliationDetailsDto())
				affiliationInsertionStatus = profileCreationAssessmentBodyInsertDataDao.insertIntoAssessmentBodyAffiliationDetails(profileCreationAssessmentBodyAffiliationDetailsDto, applicationIdAfterInsertion);
			}
			if (! profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto().isEmpty())
			{
				for (ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto item : profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto())
				{
					directorsAndManagementId = profileCreationAssessmentBodyInsertDataDao.insertIntoAssessmentBodyDirectorsAndManagementTeamDetails(item, applicationIdAfterInsertion);
				}
			}
			if(!profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentBodyRecognitionsDto().isEmpty())
			{
				for(ProfileCreationAssessmentBodyRecognitionsDto item : profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentBodyRecognitionsDto())
				{
					assessmentBodyRecognition = profileCreationAssessmentBodyInsertDataDao.insertIntoAssessmentBodyRecognitions(item, applicationIdAfterInsertion);
				}
				
			}
			if(!profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentBodyRegionalOfficeDetailsDto().isEmpty())
			{
				for (ProfileCreationAssessmentBodyRegionalOfficeDetailsDto item : profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentBodyRegionalOfficeDetailsDto())
				{
					assessmentBodyRegionalOffice = profileCreationAssessmentBodyInsertDataDao.insertIntoAssessmentBodyRegionalOfficeDetails(item, applicationIdAfterInsertion);
				}
			}
			if(!profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentsExperienceInTechnicalDomainDto().isEmpty())
			{
				for(ProfileCreationAssessmentsExperienceInTechnicalDomainDto item : profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentsExperienceInTechnicalDomainDto())
				{
					assessmentBodyExperienceinTechnical =profileCreationAssessmentBodyInsertDataDao.insertIntoAssessmentsExperienceInTechnicalDomain(item, applicationIdAfterInsertion);
				}
				
			}
			
			if(!profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentStaffDetailsDto().isEmpty())
			{
				for(ProfileCreationAssessmentStaffDetailsDto item : profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentStaffDetailsDto())
				{
					assessmentStaff = profileCreationAssessmentBodyInsertDataDao.insertIntoAssessmentStaffDetails(item , applicationIdAfterInsertion);
				}
			}
			
			if (status == -1 || applicationTableStatus == -1 || affiliationInsertionStatus == -1 || directorsAndManagementId == -1 || assessmentBodyRecognition ==-1 || assessmentBodyRegionalOffice ==-1)
			{
				returnStatus = -1;
			}
		}
		//An error occurred while checking if user is new or already registered
		else if(userExists == -2)
		{
			/*Exception occurred*/
		}
		//User is old
		else
		{
			applicationTableStatus=profileCreationTPABCommonDao.updateIntoApplication(profileCreationAssessmentBodyWrapperDto.getType());
			applicationIdAfterInsertion = getAssessmentBodyRegistrationId(getApplicationId());
			int getIfApplicationIdIsPresentInAssessmentBody = profileCreationAssessmentBodyGetDataDao.isApplicationIdPresentInAssessmentBody(userExists);
			
			ProfileCreationAssessmentBodyRegistrationDetailsDto profileCreationAssessmentBodyRegistrationDetailsDto = profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentBodyRegistrationDetailsDto();
			profileCreationAssessmentBodyRegistrationDetailsDto.setApplicationId(userExists);
			
			//LOGGER.debug("Value of assessment body registration is " +applicationIdAfterInsertion );
			if(getIfApplicationIdIsPresentInAssessmentBody == 0)
			{
				LOGGER.debug("Assessment Body registration Id is empty");
				
				
				status=profileCreationAssessmentBodyInsertDataDao.insertIntoAssessmentBodyRegistrationDetails(profileCreationAssessmentBodyRegistrationDetailsDto);
			}
			else if(getIfApplicationIdIsPresentInAssessmentBody == -2 || getIfApplicationIdIsPresentInAssessmentBody == -1)
			{
				LOGGER.debug("An exception occured while finding if assessment body is present or not");
			}
			else if(getIfApplicationIdIsPresentInAssessmentBody == 1)
			{
				LOGGER.debug("Assessment Body registartion Id is " + applicationIdAfterInsertion);
				status = profileCreationAssessmentBodyUpdateDataDao.updateIntoAssessmentBodyRegistrationDetails(profileCreationAssessmentBodyRegistrationDetailsDto);
			}
			
			applicationIdAfterInsertion = getAssessmentBodyRegistrationId(getApplicationId());
			/* Assessment Body Affiliation Details */
			if(!profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentBodyAffiliationDetailsDto().isEmpty())
			{
				for(ProfileCreationAssessmentBodyAffiliationDetailsDto item : profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentBodyAffiliationDetailsDto())
				{
					 int affiliationPresent = profileCreationAssessmentBodyGetDataDao.isAffiliationPresent(item.getAssessmentBodyRegistrationId(), item.getNameOfSectorSkillCouncil());
					if(affiliationPresent == 0)
					{
						
						profileCreationAssessmentBodyInsertDataDao.insertIntoAssessmentBodyAffiliationDetails(item, applicationIdAfterInsertion);
					}
					else if (affiliationPresent == 1)
					{
						profileCreationAssessmentBodyUpdateDataDao.updateIntoAssessmentBodyAffiliationDetails(item);
					}
					else 
					{
						LOGGER.debug("Could not update details of Assessment body affiliation due to some exception");
					}
					
				}
			}
			
			/*Assessment Body Directors and Management Details */
			if (! profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto().isEmpty())
			{
				for (ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto item : profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto())
				{
						int managmentStatus = profileCreationAssessmentBodyGetDataDao.isManagementPresent(item.getAssessmentBodyRegistrationId(), item.getEmailId());	
						if(managmentStatus == 0)
						{
							profileCreationAssessmentBodyInsertDataDao.insertIntoAssessmentBodyDirectorsAndManagementTeamDetails(item , applicationIdAfterInsertion);
						}
						else if (managmentStatus == 1)
						{
							profileCreationAssessmentBodyUpdateDataDao.updateIntoAssessmentBodyDirectorsAndManagementTeamDetails(item);
						}
						else 
						{
							LOGGER.debug("Could not update details of Assessment body Management due to some exception");
						}
				}
				
			}
			/*Assessment Body Recognition details*/
			if(!profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentBodyRecognitionsDto().isEmpty())
			{
				for(ProfileCreationAssessmentBodyRecognitionsDto item : profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentBodyRecognitionsDto())
				{
					
					int recognitionABStatus = profileCreationAssessmentBodyGetDataDao.isRecognitionPresent(item.getAssessmentBodyRegistrationId(), item.getNameOfRecognitionBody());
					if(recognitionABStatus == 0)
					{
						assessmentBodyRecognition = profileCreationAssessmentBodyInsertDataDao.insertIntoAssessmentBodyRecognitions(item, applicationIdAfterInsertion);
					}
					else if(recognitionABStatus == 1)
					{
						assessmentBodyRecognition = profileCreationAssessmentBodyUpdateDataDao.updateIntoAssessmentBodyRecognitions(item);
					}
				}
				
			}
			
			/*Assessment Body regional office details*/
			if(!profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentBodyRegionalOfficeDetailsDto().isEmpty())
			{
				for (ProfileCreationAssessmentBodyRegionalOfficeDetailsDto item : profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentBodyRegionalOfficeDetailsDto())
				{
					int regionalOfficeStatus = profileCreationAssessmentBodyGetDataDao.isRegionalOfficePresent(item.getAssessmentBodyRegistrationId(), item.getPincode());
					LOGGER.debug("Regional office check value is " +regionalOfficeStatus);
					if(regionalOfficeStatus == 0)
					{
						assessmentBodyRegionalOffice = profileCreationAssessmentBodyInsertDataDao.insertIntoAssessmentBodyRegionalOfficeDetails(item , applicationIdAfterInsertion);
					}
					else if (regionalOfficeStatus == 1)
					{
						LOGGER.debug("This is item" + item);
						assessmentBodyRegionalOffice = profileCreationAssessmentBodyUpdateDataDao.updateIntoAssessmentBodyRegionalOfficeDetails(item);
					}
				}
				
			}
			
			/*Assessment Body Experience in technical domain details*/
			
			if(!profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentsExperienceInTechnicalDomainDto().isEmpty())
			{
				
				for(ProfileCreationAssessmentsExperienceInTechnicalDomainDto item : profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentsExperienceInTechnicalDomainDto())
				{
					int experienceinTechnical = profileCreationAssessmentBodyGetDataDao.isExperiencePresent(item.getAssessmentBodyRegistrationId(), item.getDomain());
					if(experienceinTechnical == 0)
					{
						LOGGER.debug("Experience does not exist, need to create new entry in database");
						assessmentBodyExperienceinTechnical =profileCreationAssessmentBodyInsertDataDao.insertIntoAssessmentsExperienceInTechnicalDomain(item , applicationIdAfterInsertion);
						
					}
					else if(experienceinTechnical == 1)
					{
						LOGGER.debug("Experience exists, need to update in database");
						assessmentBodyExperienceinTechnical = profileCreationAssessmentBodyUpdateDataDao.updateIntoAssessmentsExperienceInTechnicalDomain(item);
					}
					else
					{
						LOGGER.error("An error occured while finding if experience of assement already exists in database");
					}
					
				}
				
			}
			
			/* Assessment Staff*/
			if(!profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentStaffDetailsDto().isEmpty())
			{
				for(ProfileCreationAssessmentStaffDetailsDto item : profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentStaffDetailsDto())
				{
					int assessmentStaffPresent = profileCreationAssessmentBodyGetDataDao.isStaffPresent(item.getAssessmentBodyRegistrationId(), item.getEmailId());
					if(assessmentStaffPresent == 0)
					{
						assessmentStaff = profileCreationAssessmentBodyInsertDataDao.insertIntoAssessmentStaffDetails(item , applicationIdAfterInsertion);
					}
					else if(assessmentStaffPresent == 1)
					{
						assessmentStaff = profileCreationAssessmentBodyUpdateDataDao.updateIntoAssessmentStaffDetails(item);
					}
							
				}
			}
			
			
			/* Return status as -1 */
			if (applicationTableStatus == -1 || status == -1 || assessmentBodyRegionalOffice == -1)
			{
				returnStatus = -1;
			}
		}
		
		return returnStatus;
	}
	/*
	 * Method to save data of Training Partner*/
	public int saveTrainingPartner(ProfileCreationTrainingPartnerWrapperDto profileCreationTrainingPartnerWrapperDto)
	{
		int status =0 , applicationTableStatus =0, trainingPartnerCenterDetails = 0, trainingPartnerInstituteGrant =0,trainingPartnerRecognition =0, managementStaff =0, experienceInTraining =0, trainer = 0;
		int userExists = getApplicationId();
		
		String applicationIdAfterCreation = null;
		//New User
		if(userExists == -1)
		{
			applicationTableStatus = profileCreationTPABCommonDao.insertIntoApplication(profileCreationTrainingPartnerWrapperDto.getType());
			LOGGER.debug("I am inside user exists = -1 in training partner service");
			ProfileCreationTrainingPartnerOrganizationDetailsDto profileCreationTrainingPartnerOrganitzationDetailsDto = profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerOrganizationDetailsDto();
			profileCreationTrainingPartnerOrganitzationDetailsDto.setApplicationId(userExists);
			status = profileCreationTrainingPartnerInsertDataDao.insertIntoTrainingPartnerOrganizationDetails(profileCreationTrainingPartnerOrganitzationDetailsDto);
			
			//get applicationId once it is created
			applicationIdAfterCreation = getTrainingPartnerRegistrationId(getApplicationId());
			LOGGER.debug("Training Parter RegistrationId in if part " + applicationIdAfterCreation);
			if(!profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerCenterDetailsDto().isEmpty())
			{
			
				for(ProfileCreationTrainingPartnerCenterDetailsDto item : profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerCenterDetailsDto())
				{
					trainingPartnerCenterDetails = profileCreationTrainingPartnerInsertDataDao.insertIntoTrainingPartnerCenterLevelDetails(item, applicationIdAfterCreation);
				}
			}
			
			if(! profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerInstituteGrantDto().isEmpty())
			{
				
				for(ProfileCreationTrainingPartnerInstituteGrantDto item :profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerInstituteGrantDto())
				{
					trainingPartnerInstituteGrant = profileCreationTrainingPartnerInsertDataDao.insertIntoTrainingPartnerInstituteGrant(item, applicationIdAfterCreation);					
				}
			}
			if(!profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerInstituteRecognitionDto().isEmpty())
			{
				for(ProfileCreationTrainingPartnerInstituteRecognitionDto item :profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerInstituteRecognitionDto())
				{
					trainingPartnerRecognition = profileCreationTrainingPartnerInsertDataDao.insertIntoTrainingPartnerInstituteRecognition(item , applicationIdAfterCreation);
				}
				
			}
			if(!profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto().isEmpty())
			{
				for(ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto item : profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto())
				{
					managementStaff = profileCreationTrainingPartnerInsertDataDao.insertIntoTrainingPartnerManagementAndStaffAndOfficialsDetails(item , applicationIdAfterCreation);
				}
			}
			
			if(!profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto().isEmpty())
			{
				for(ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto item :profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto())
				{
					experienceInTraining = profileCreationTrainingPartnerInsertDataDao.insertIntoTrainingPartnerPriorExperienceInSkillTraining(item , applicationIdAfterCreation);
				}
			}
			
			if(!profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerTrainingStaffDetailsDto().isEmpty())
			{
				for(ProfileCreationTrainingPartnerTrainingStaffDetailsDto item : profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerTrainingStaffDetailsDto())
				{
					trainer = profileCreationTrainingPartnerInsertDataDao.insertIntoTrainingPartnerTrainingStaff(item , applicationIdAfterCreation);
				}
			}
			if(applicationTableStatus == -1 || status == -1 || trainingPartnerCenterDetails == -1 || trainingPartnerInstituteGrant == -1)
			{
				LOGGER.error("Could not insert details of Training partner in the databse. An exception occured");
			}
		}
		//Error in finding application Id
		else if(userExists == -2)
		{
			LOGGER.error("Error occured while finding application Id of logged in user");
		}
		
		/*Old User*/
		else 
		{
			LOGGER.debug("I am inside user exists = other than -1 and -2 in training partner service");
			
			
			int applicationIdInTrainingPartnerOrganisationDetails = profileCreationTrainingPartnerGetDataDao.isApplicationIdPresentinTrainingPartner(getApplicationId());
			LOGGER.debug("The result of if application id is present in training partner organisation detials is:" + applicationIdInTrainingPartnerOrganisationDetails);
			applicationTableStatus = profileCreationTPABCommonDao.updateIntoApplication(profileCreationTrainingPartnerWrapperDto.getType());
			ProfileCreationTrainingPartnerOrganizationDetailsDto profileCreationTrainingPartnerOrganitzationDetailsDto = profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerOrganizationDetailsDto();
			profileCreationTrainingPartnerOrganitzationDetailsDto.setApplicationId(userExists);
			if(applicationIdInTrainingPartnerOrganisationDetails == 0)
			{
				
				LOGGER.debug("Organisation details" + profileCreationTrainingPartnerOrganitzationDetailsDto.getApplicationId());
				status = profileCreationTrainingPartnerInsertDataDao.insertIntoTrainingPartnerOrganizationDetails(profileCreationTrainingPartnerOrganitzationDetailsDto);
			}
			else if (applicationIdInTrainingPartnerOrganisationDetails == -2)
			{
				LOGGER.debug("Some exception occured while finding if training partner registartion id is present or not");
			}
			else if (applicationIdInTrainingPartnerOrganisationDetails == 1)
			{
				applicationIdAfterCreation = getTrainingPartnerRegistrationId(getApplicationId());
				LOGGER.debug("Training Partner RegistrationId is "+ applicationIdAfterCreation);
				status = profileCreationTrainingPartnerUpdateDataDao.updateIntoTrainingPartnerOrganizationDetails(profileCreationTrainingPartnerOrganitzationDetailsDto);
			}
			
			/*
			 * Training Center Details*/
			if(!profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerCenterDetailsDto().isEmpty())
			{
				int doesTrainingCenterExists = 10;
				for(ProfileCreationTrainingPartnerCenterDetailsDto item : profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerCenterDetailsDto())
				{
					doesTrainingCenterExists = profileCreationTrainingPartnerGetDataDao.isTrainingCenterPresent(item.getTrainingPartnerRegistrationId(), item.getNameOfCenter());
					if(doesTrainingCenterExists == 0)
					{
						trainingPartnerCenterDetails = profileCreationTrainingPartnerInsertDataDao.insertIntoTrainingPartnerCenterLevelDetails(item ,applicationIdAfterCreation);
					}
					else if(doesTrainingCenterExists == 1)
					{
						trainingPartnerCenterDetails = profileCreationTrainingPartnerUpdateDataDao.updateIntoTrainingPartnerCenterLevelDetails(item);
					}
					else
					{
						LOGGER.error("Could not save data for training partner center level details");
					}
				}
			}
			
			/*Training Partner Institute Grant*/
			
			if(! profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerInstituteGrantDto().isEmpty())
			{
				int doesInstitueGrantExists = 10;
				
				for(ProfileCreationTrainingPartnerInstituteGrantDto item :profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerInstituteGrantDto())
				{
					doesInstitueGrantExists = profileCreationTrainingPartnerGetDataDao.isInstituteGrantPresent(item.getTrainingPartnerRegistrationId(), item.getNameOfMinistry());
					if(doesInstitueGrantExists == 0)
					{
						trainingPartnerInstituteGrant = profileCreationTrainingPartnerInsertDataDao.insertIntoTrainingPartnerInstituteGrant(item , applicationIdAfterCreation);
					}
					else if (doesInstitueGrantExists == 1)
					{
						trainingPartnerInstituteGrant = profileCreationTrainingPartnerUpdateDataDao.updateIntoTrainingPartnerInstituteGrant(item);
					}
					else if(doesInstitueGrantExists == -1)
					{
						LOGGER.debug("Could not insert value of institute grant into database due to some error");
					}
					else
					{
						LOGGER.debug("Some error has occured");
					}
										
				}
			}
			/*Training Partner Institute recognitions details*/
			if(!profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerInstituteRecognitionDto().isEmpty())
			{
				int doesRecognitionExists = 0; 
				for(ProfileCreationTrainingPartnerInstituteRecognitionDto item :profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerInstituteRecognitionDto())
				{
					doesRecognitionExists = profileCreationTrainingPartnerGetDataDao.isInstituteRecognitionPresent(item.getTrainingPartnerRegistrationId(),item.getNameOfRecognizingBody());
					if(doesRecognitionExists ==0)
					{
						
						trainingPartnerRecognition = profileCreationTrainingPartnerInsertDataDao.insertIntoTrainingPartnerInstituteRecognition(item , applicationIdAfterCreation);
					}
					else if (doesRecognitionExists == 1)
					{
						trainingPartnerRecognition = profileCreationTrainingPartnerUpdateDataDao.updateIntoTrainingPartnerInstituteRecognition(item);
					}
					else
					{
						LOGGER.error("Could not update recognition in the database");
					}
				}
				
			}
			
			/*Training Partner MAnagement details*/
			if(!profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto().isEmpty())
			{
				int doesManagementPresent =10;
				for(ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto item : profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto())
				{
					doesManagementPresent = profileCreationTrainingPartnerGetDataDao.isTrainingPartnerManagementStaffPresent(item.getTrainingPartnerRegistrationId(), item.getEmailId());
					LOGGER.debug("Value of ispresent is" + doesManagementPresent);
					if(doesManagementPresent == 0)
					{
						managementStaff = profileCreationTrainingPartnerInsertDataDao.insertIntoTrainingPartnerManagementAndStaffAndOfficialsDetails(item , applicationIdAfterCreation);
					}
					else if(doesManagementPresent == 1)
					{
						managementStaff = profileCreationTrainingPartnerUpdateDataDao.updateIntoTrainingPartnerManagementAndStaffAndOfficialsDetails(item);
					}
					else
					{
						LOGGER.debug("Could not insert Traing Partner Management and staff details in databse");
					}
					
				}
			}
			/*
			 * Training Partner Experience in prior training */
			if(!profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto().isEmpty())
			{
				int doesExperienceExists = 10;
				for(ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto item :profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto())
				{
					doesExperienceExists = profileCreationTrainingPartnerGetDataDao.isTrainingExperiencePresent(item.getTrainingPartnerRegistrationId(), item.getCourseName());
					if(doesExperienceExists == 0)
					{
						experienceInTraining = profileCreationTrainingPartnerInsertDataDao.insertIntoTrainingPartnerPriorExperienceInSkillTraining(item , applicationIdAfterCreation);
					}
					else if(doesExperienceExists == 1)
					{
						experienceInTraining = profileCreationTrainingPartnerUpdateDataDao.updateIntoTrainingPartnerPriorExperienceInSkillTraining(item);
					}
					else
					{
						LOGGER.error("Could not add experience in database");
					}
				}
			}
			/*Training Partner's Trainers*/
			if(!profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerTrainingStaffDetailsDto().isEmpty())
			{
				int doesTrainingPartnerTrainerExists = 10;
				
				for(ProfileCreationTrainingPartnerTrainingStaffDetailsDto item : profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerTrainingStaffDetailsDto())
				{
					doesTrainingPartnerTrainerExists = profileCreationTrainingPartnerGetDataDao.isTrainerPresent(item.getTrainingPartnerRegistrationId(), item.getEmailId());
					LOGGER.debug("Value of trainer exists" + doesTrainingPartnerTrainerExists);
					if(doesTrainingPartnerTrainerExists == 0)
					{
						trainer = profileCreationTrainingPartnerInsertDataDao.insertIntoTrainingPartnerTrainingStaff(item , applicationIdAfterCreation);
					}
					else if(doesTrainingPartnerTrainerExists == 1)
					{
						trainer = profileCreationTrainingPartnerUpdateDataDao.updateIntoTrainingPartnerTrainingStaff(item);
					}
					
				}
			}
			
		}
		return status;
	}
	
	/*Method to save TAN of Training Partner*/
	public int saveTPTAN(MultipartFile TrainingPartnerTan, String key)
	{
		int tanPathUpdated = 0, status =0;
		int applicationId = getApplicationId();
		
		if(applicationId > 0)
		{
			String tpTanPath = saveFile(key, applicationId, TrainingPartnerTan, readApplicationConstants.getProfileCreationTrainingPartnerFolder());
			tanPathUpdated = profileCreationTrainingPartnerUpdateDataDao.updateTanPath(tpTanPath,applicationId);
		}
		return tanPathUpdated;
	}
	
	/*Method to save PAN of Training Partner*/
	public int saveTPPAN(MultipartFile TrainingPartnerPan, String key)
	{
		int panPathUpdated = 0;
		int applicationId = getApplicationId();
		String panPath = "";

		try
		{
			panPath = saveFile(key, applicationId, TrainingPartnerPan , readApplicationConstants.getProfileCreationTrainingPartnerFolder());
			LOGGER.debug("Pan path is " + panPath);
		}
		catch(Exception e)
		{
			LOGGER.error("An exception occured while saving file " + e);
		}
		
		panPathUpdated = profileCreationTrainingPartnerUpdateDataDao.updatePanPath(panPath, applicationId);
		return panPathUpdated;
	}	
	
	/*Method to save NSDC Certificate*/
	public int saveTPNSDCCertificate(MultipartFile nsdcCertificate, String key)
	{
		int nsdcCertifiacte = 0;
		int applicationId = getApplicationId();
		String certificatePath = "";

		try
		{
			certificatePath = saveFile(key, applicationId, nsdcCertificate , readApplicationConstants.getProfileCreationTrainingPartnerFolder());
			LOGGER.debug("nsdc certificate path is " + certificatePath);
			nsdcCertifiacte = profileCreationTrainingPartnerUpdateDataDao.updateNsdcCertificatePath(certificatePath, applicationId);
		}
		catch(Exception e)
		{
			LOGGER.error("An exception occured while saving file " + e);
		}
		
		
		return nsdcCertifiacte;
	}
	
	/*
	 * Method to save self owned Institution Annexure to disk*/
	public int saveSelfOwnedAnnexure(MultipartFile selfOwnedAnnexure, String key)
	{
		int statusSelfOwnedAnnexureUpload = 0;
		int applicationId = getApplicationId();
		String selfOwnedAnnexurePath = "";

		try
		{
			selfOwnedAnnexurePath = saveFile(key, applicationId,selfOwnedAnnexure, readApplicationConstants.getProfileCreationTrainingPartnerFolder());
			statusSelfOwnedAnnexureUpload = profileCreationTrainingPartnerUpdateDataDao.updateSelfOwnedAnnexure(selfOwnedAnnexurePath, applicationId);
		}
		catch(Exception e)
		{
			statusSelfOwnedAnnexureUpload = -2;
			LOGGER.error("An error occured while upload self owned institution annexure path");
		}
		return statusSelfOwnedAnnexureUpload;
	}
	
	/*
	 * Method to save franchisee model annexure*/
	public int saveFranchiseeAnnexure(MultipartFile franchiseeAnnexure, String key)
	{
		int statusFranchiseeAnnexure = 0;
		int applicationId = getApplicationId();
		String franchiseAnnexurePath = "";
		try
		{
			franchiseAnnexurePath = saveFile(key, applicationId, franchiseeAnnexure , readApplicationConstants.getProfileCreationTrainingPartnerFolder());
			statusFranchiseeAnnexure = profileCreationTrainingPartnerUpdateDataDao.updateFrnachiseeAnnexurePath(franchiseAnnexurePath, applicationId);
		}
		catch(Exception e)
		{
			statusFranchiseeAnnexure = -2;
			LOGGER.error("An error occured while upload self owned institution annexure path");
		}
		return statusFranchiseeAnnexure;
	}
	
	/*
	 * Method to save Mobile annexure*/
	public int saveMobileAnnexure(MultipartFile mobileAnnexure, String key)
	{
		int statusMobileAnnexure = 0;
		int applicationId = getApplicationId();
		String mobileAnnexurePath = "";
		try
		{
			mobileAnnexurePath = saveFile(key, applicationId, mobileAnnexure, readApplicationConstants.getProfileCreationTrainingPartnerFolder());
			statusMobileAnnexure = profileCreationTrainingPartnerUpdateDataDao.updateMobileAnnexurePath(mobileAnnexurePath, applicationId);
		}
		catch(Exception e)
		{
			statusMobileAnnexure = -2;
			LOGGER.error("An error occured while upload self owned institution annexure path");
		}
		return statusMobileAnnexure;
	}
	
	/*
	 * Method to save cv of training Staff*/
	public int saveTrainingStaffCv(MultipartFile trainingStaffCv, String key)
	{
		int trainingStaffPathUpdated =  0;
		int applicationId = getApplicationId();
		String trainingPartnerRegistartionId = getTrainingPartnerRegistrationId(applicationId);
		String trainingStaffCvPath = "";
		try
		{
			trainingStaffCvPath = saveFile(key, applicationId, trainingStaffCv, readApplicationConstants.getProfileCreationTrainingPartnerFolder());
			trainingStaffPathUpdated = profileCreationTrainingPartnerUpdateDataDao.updateTrainingStaffCvPath(trainingStaffCvPath, trainingPartnerRegistartionId);
		}
		catch(Exception e)
		{
			trainingStaffPathUpdated = -2;
			LOGGER.error("An error occured while uploading training staff cv path");
		}
		return trainingStaffPathUpdated;
	}
	
	/*Method to save education certificate of training staff*/
	public int saveTrainingStaffEducationCertificate(MultipartFile trainingStaffEducationCertificate, String key)
	{
	
		int trainingStaffEducationCertificatePathUpdated =  0;
		int applicationId = getApplicationId();
		String trainingPartnerRegistartionId = getTrainingPartnerRegistrationId(applicationId);
		String trainingStaffEducationCertificatePath = "";
		try
		{
			trainingStaffEducationCertificatePath = saveFile(key, applicationId,trainingStaffEducationCertificate ,readApplicationConstants.getProfileCreationTrainingPartnerFolder());
			trainingStaffEducationCertificatePathUpdated = profileCreationTrainingPartnerUpdateDataDao.updateTrainingStaffEducationCertificatePath(trainingStaffEducationCertificatePath, trainingPartnerRegistartionId);
					
		}
		catch(Exception e)
		{
			LOGGER.error("An exception occured while updating training staff education certificate " + e);
		}
		
		return trainingStaffEducationCertificatePathUpdated;
	}
	
	
	/*
	 * Method to save Cv of Training Partner Management Staff
	 */
	public int saveTrainingPartnerManagementStaff(MultipartFile managementCv, String key)
	{
		int trainingPartnerManagementStaffCvPath =  0;
		int applicationId = getApplicationId();
		String trainingPartnerRegistartionId = getTrainingPartnerRegistrationId(applicationId);
		String ManagementCvPath = "";
		try
		{
			ManagementCvPath = saveFile(key, applicationId,managementCv, readApplicationConstants.getProfileCreationTrainingPartnerFolder());
			trainingPartnerManagementStaffCvPath = profileCreationTrainingPartnerUpdateDataDao.updateTrainingPartnerManagementCvPath(ManagementCvPath, trainingPartnerRegistartionId);
		}
		catch(Exception e)
		{
			LOGGER.error("An exception occurred while updating tarining partner management cv path in database " + e);
		}
		return trainingPartnerManagementStaffCvPath;
	}
	
	
	/**
	 * 
	 * @param key
	 * @param classRoomImages
	 * @param nameOfCenter
	 * @return
	 */
	public int saveClassRoomImagesTP(String key , MultipartFile classRoomImages, String nameOfCenter)
	{
		int classroomImagePathUpdated = 0;
		String classRoomImagePath ="";
		String[] insideFolders = {nameOfCenter};
		int applicationId = getApplicationId();
		String TrainingPartnerRegistrationId = getTrainingPartnerRegistrationId(applicationId);
		try
		{
			classRoomImagePath = saveFile(key,applicationId, classRoomImages,readApplicationConstants.getProfileCreationTrainingPartnerFolder(),insideFolders);
			LOGGER.debug("Classroom images path "+ classRoomImagePath);
			classroomImagePathUpdated = profileCreationTrainingPartnerUpdateDataDao.updatePathsClassroomImage(TrainingPartnerRegistrationId, classRoomImagePath);
		}
		catch(Exception e)
		{
			classroomImagePathUpdated =-2;
			LOGGER.error("An exception occured while saving classroom images for center " + nameOfCenter+" "+ e);
		}
		
		return classroomImagePathUpdated;
	}
	
	/**
	 * Method to save Operation head cv and update path in database
	 * @param key
	 * @param file
	 * @param nameOfCenter
	 * @return
	 */
	public int saveOperationHeadCv(String key, MultipartFile file, String nameOfCenter)
	{
		int operationHeadCvPathUpdated = 0;
		int applicationId = getApplicationId();
		String trainingPartnerRegistrationId = getTrainingPartnerRegistrationId(applicationId);
		String operationHeadCvPath ="";
		String[] insideFolders = {nameOfCenter}; 
		try
		{
			operationHeadCvPath = saveFile(key,applicationId, file,readApplicationConstants.getProfileCreationTrainingPartnerFolder(),insideFolders);
			operationHeadCvPathUpdated = profileCreationTrainingPartnerUpdateDataDao.updateOperationHeadCvPath(trainingPartnerRegistrationId, operationHeadCvPath);
		}
		catch(Exception e)
		{
			LOGGER.error("An exception occured while saving operation head cv file " + e);
			operationHeadCvPathUpdated =-2;
		}
		return operationHeadCvPathUpdated;
	}
	
	/**
	 * Method to save affiliation coordinator cv file and update path in database
	 * @param key
	 * @param file
	 * @param nameofCenter
	 * @return
	 */
	public int saveAffiliationCoordinatorCv(String key, MultipartFile file, String nameOfCenter)
	{
		int affiliationCoordinatorCvUpdated =0;
		int applicationId = getApplicationId();
		String trainingPartnerRegistrationId = getTrainingPartnerRegistrationId(applicationId);
		String affiliationCoordinatorCvPath ="";
		String[] insideFolders = {nameOfCenter};
		try
		{
			affiliationCoordinatorCvPath = saveFile(key,applicationId, file,readApplicationConstants.getProfileCreationTrainingPartnerFolder(),insideFolders);
			affiliationCoordinatorCvUpdated = profileCreationTrainingPartnerUpdateDataDao.updateOperationHeadCvPath(trainingPartnerRegistrationId, affiliationCoordinatorCvPath);
		}
		catch(Exception e)
		{
			affiliationCoordinatorCvUpdated = -2;
			LOGGER.error("An exception occured while updating path of affiliation co ordinator " + e);
		}
		return affiliationCoordinatorCvUpdated;
	}
	
	/**
	 * Method to save spoc cv file and update path in database
	 * @param key
	 * @param file
	 * @param nameOfCenter
	 * @return
	 */
	public int saveSPOCCv(String key, MultipartFile file, String nameOfCenter)
	{
		int spocCvPathUpdated = 0;
		int applicationId = getApplicationId();
		String trainingPartnerRegistrationId = getTrainingPartnerRegistrationId(applicationId);
		String spocCvPath ="";
		String[] insideFolders = {nameOfCenter};
		try
		{
			spocCvPath = saveFile(key,applicationId, file,readApplicationConstants.getProfileCreationTrainingPartnerFolder(),insideFolders);
			spocCvPathUpdated = profileCreationTrainingPartnerUpdateDataDao.updateOperationHeadCvPath(trainingPartnerRegistrationId, spocCvPath);
		}
		catch(Exception e)
		{
			spocCvPathUpdated = -2;
			LOGGER.error("An exception occured while updating spoc cv path " +e);
		}
		return spocCvPathUpdated; 
	}
	
	/**
	 * 
	 * @param key
	 * @param file
	 * @param nameOfCenter
	 * @return
	 */
	public int saveLabImages(String key, MultipartFile file, String nameOfCenter)
	{
		int labImagesUpdated = 0;
		int applicationId = getApplicationId();
		String trainingPartnerRegistrationId = getTrainingPartnerRegistrationId(applicationId);
		String labImagePath ="";
		String[] insideFolders = {nameOfCenter};
		try
		{
			labImagePath = saveFile(key,applicationId, file,readApplicationConstants.getProfileCreationTrainingPartnerFolder(),insideFolders);
			labImagesUpdated = profileCreationTrainingPartnerUpdateDataDao.updateLabsImagePath(trainingPartnerRegistrationId, labImagePath);
		}
		catch(Exception e)
		{
			labImagesUpdated = -2;
			LOGGER.error("An exception occured while saving lab images " +e);
		}
		return labImagesUpdated;
	}
	
	/**
	 * 
	 * @param key
	 * @param file
	 * @param nameOfCenter
	 * @return
	 */
	public int saveWorkshopImages(String key, MultipartFile file, String nameOfCenter)
	{
		int workshopImages = 0;
		int applicationId = getApplicationId();
		String trainingPartnerRegistrationId = getTrainingPartnerRegistrationId(applicationId);
		String workshopImagePath ="";
		String[] insideFolders = {nameOfCenter};
		try
		{
			workshopImagePath = saveFile(key,applicationId, file,readApplicationConstants.getProfileCreationTrainingPartnerFolder(),insideFolders);
			workshopImages = profileCreationTrainingPartnerUpdateDataDao.updateWorkshopImagePath(trainingPartnerRegistrationId, workshopImagePath);
		}
		catch(Exception e)
		{
			workshopImages = -2;
			LOGGER.error("An exception occured while saving workshop images " +e);
		}
		return workshopImages;
	}
	
	/**
	 * 
	 * @param key
	 * @param file
	 * @param nameOfCenter
	 * @return
	 */
	public int saveMandatoryToolkitImages(String key, MultipartFile file, String nameOfCenter)
	{
		int mandatoryToolkitImage = 0;
		int applicationId = getApplicationId();
		String trainingPartnerRegistrationId = getTrainingPartnerRegistrationId(applicationId);
		String mandatoryToolkitImagePath ="";
		String[] insideFolders = {nameOfCenter};
		try
		{
			mandatoryToolkitImagePath = saveFile(key,applicationId, file,readApplicationConstants.getProfileCreationTrainingPartnerFolder(),insideFolders);
			mandatoryToolkitImage = profileCreationTrainingPartnerUpdateDataDao.updateMandatoryToolkitImagePath(trainingPartnerRegistrationId, mandatoryToolkitImagePath);
		}
		catch(Exception e)
		{
			mandatoryToolkitImage = -2;
			LOGGER.error("An exception occured while saving mandatory toolkit images " +e);
		}
		return mandatoryToolkitImage;
	}
	
	/**
	 * 
	 * @param key
	 * @param file
	 * @param nameOfCenter
	 * @return
	 */
	public int saveMandatoryToolkitAnnexurePath(String key, MultipartFile file, String nameOfCenter)
	{
		int mandatoryToolkitannexurePath = 0;
		int applicationId = getApplicationId();
		String trainingPartnerRegistrationId = getTrainingPartnerRegistrationId(applicationId);
		String mandatoryToolkitAnnexurePath ="";
		String[] insideFolders = {nameOfCenter};
		try
		{
			mandatoryToolkitAnnexurePath = saveFile(key,applicationId, file,readApplicationConstants.getProfileCreationTrainingPartnerFolder(),insideFolders);
			mandatoryToolkitannexurePath = profileCreationTrainingPartnerUpdateDataDao.updateMandatoryToolkitAnnexurePath(trainingPartnerRegistrationId, mandatoryToolkitAnnexurePath);
		}
		catch(Exception e)
		{
			mandatoryToolkitannexurePath = -2;
			LOGGER.error("An exception occured while saving Mandatory Toolkit Annexure " +e);
		}
		return mandatoryToolkitannexurePath;
	}
	/*Method to save PAN of Assessment Body*/
	public int saveABPAN(MultipartFile assessmentBodyPan, String key)
	{
		int panPathUpdated = 0;
		int applicationId = getApplicationId();
		String panPath = "";

		try
		{
			panPath = saveFile(key, applicationId, assessmentBodyPan, readApplicationConstants.getProfileCreationAssessmentBodyFolder());
			LOGGER.debug("Pan path is " + panPath);
		}
		catch(Exception e)
		{
			LOGGER.error("An exception occured while saving file " + e);
		}
		
		panPathUpdated = profileCreationAssessmentBodyUpdateDataDao.updatePanPath(panPath, applicationId );
		return panPathUpdated;
	}
	/*
	 * Method to save tan number of assessment body*/
	public int saveABTan(MultipartFile assessmentBodyTan , String key)
	{
		int tanPathUpdated = 0, status =0;
		int applicationId = getApplicationId();
		if(applicationId > 0)
		{
			String abTanPath = saveFile(key, applicationId, assessmentBodyTan, readApplicationConstants.getProfileCreationAssessmentBodyFolder());
			tanPathUpdated = profileCreationAssessmentBodyUpdateDataDao.updateTanPath(abTanPath,applicationId);
		}
		return tanPathUpdated;
	}
	
	/*
	 * Method to save Assessment body management Cv */
	public int saveAbManagementCv(MultipartFile assessmentBodyManagementCv , String key)
	{
		int abManagementCvUpdated = 0, status =0;
		int applicationId = getApplicationId();
		try
		{
			String assessmentBodyRegisterId = getAssessmentBodyRegistrationId(applicationId);
			String abManagementCvPath = saveFile(key, applicationId, assessmentBodyManagementCv, readApplicationConstants.getProfileCreationAssessmentBodyFolder());
			abManagementCvUpdated = profileCreationAssessmentBodyUpdateDataDao.updatePathAssessmentManagementCv(abManagementCvPath,assessmentBodyRegisterId);
		}
		catch(Exception e)
		{
			LOGGER.error("An exception occured while saving cv of management staff of assessment body " + e);
		}
		
		
		return abManagementCvUpdated;
	}
	
	/*
	 * Method to save Assessment body Assessment Staff Cv */
	public int saveAbAssessmentStaffCv(MultipartFile assessmentBodyAssessmentStaffCv , String key)
	{
		int abAssessmnetStaffCv = 0, status =0;
		int applicationId = getApplicationId();
		String assessmentBodyRegisterId = getAssessmentBodyRegistrationId(applicationId);
		
			String abAssessmentStaffPath = saveFile(key, applicationId, assessmentBodyAssessmentStaffCv, readApplicationConstants.getProfileCreationAssessmentBodyFolder());
			abAssessmnetStaffCv = profileCreationAssessmentBodyUpdateDataDao.updatePathAssessmentStaffCv(abAssessmentStaffPath,assessmentBodyRegisterId);
		
		return abAssessmnetStaffCv;
	}
	
	/**
	 * 
	 * @param assessmentBodyAssessmentStaffCertificates
	 * @param key
	 * @return
	 */
	public int saveAbAssessmentStaffEducationCertificates(MultipartFile assessmentBodyAssessmentStaffCertificates , String key)
	{
		int abAssessmentStaffEducationCertificate = 0, status =0;
		int applicationId = getApplicationId();
		String assessmentBodyRegisterId = getAssessmentBodyRegistrationId(applicationId);
		
			String abAssessmentStaffEducationCertificatePath = saveFile(key, applicationId, assessmentBodyAssessmentStaffCertificates, readApplicationConstants.getProfileCreationAssessmentBodyFolder());
			abAssessmentStaffEducationCertificate = profileCreationAssessmentBodyUpdateDataDao.updatePathAssessmentStaffEducationCertificate(abAssessmentStaffEducationCertificatePath,assessmentBodyRegisterId);
	
		return abAssessmentStaffEducationCertificate;
	}
	
	/**
	 * Method to save letter of declaration of training partner
	 * @param undertakingTrainingPartner
	 * @param key
	 * @return
	 */
	public int saveUndertakingTrainingPartner(MultipartFile undertakingTrainingPartner, String key)
	{
		int status =0;
		try
		{
			int applicationId = getApplicationId();
			String fileSaved =  saveFile(key, applicationId, undertakingTrainingPartner , readApplicationConstants.getProfileCreationTrainingPartnerFolder());
			LOGGER.debug("Undertaking for application id : "+applicationId+ " has been saved at path " +fileSaved);
		}
		catch(Exception e)
		{
			LOGGER.debug("An exception occured whlie saving undertaking for training partner" + e);
		}
		
		return status;
	}
	
	/**
	 * Method to save letter of declaration of assessment body
	 * @param undertakingAssessmentBody
	 * @param key
	 * @return
	 */
	public int saveUndertakingAssessmentBody(MultipartFile undertakingAssessmentBody, String key)
	{
		int status = 0;
		try
		{
			int applicationId = getApplicationId();
			String assessmentBodyUndertakingPath = saveFile(key,applicationId,undertakingAssessmentBody,readApplicationConstants.getProfileCreationAssessmentBodyFolder());
			LOGGER.debug("Undertaking for application Id " + applicationId+ " has been saved at "+ assessmentBodyUndertakingPath);
		}
		catch(Exception e)
		{
			LOGGER.debug("An exception occured while saving undertaking of assessment body "+ e);
		}
		return status;
	}
	
	/**
	 * 
	 * @param key
	 * @param applicationId
	 * @param file
	 * @param pathToFolder
	 * @return
	 */
	private String saveFile(String key, int applicationId, MultipartFile file, String pathToFolder)
	{
		int folderCreated = 0;	
		String pathTillApplicationId = "";
		String pathOfUploadedFile = "";
		if(!file.isEmpty())
		{	
			String fileName=file.getOriginalFilename();
			int indexOfDot=fileName.indexOf(".");
			try
			{
				pathTillApplicationId = pathToFolder+ applicationId+ "//";
				File folder = new File (pathTillApplicationId);
				if(!folder.exists())
				{
						if(folder.mkdirs() || folder.canWrite())
						{
							folderCreated = 1;
							LOGGER.debug("File name is " + file.getOriginalFilename());
							LOGGER.debug("Directory "+ folder + " to store files created successfully");
						}
						else
						{
							folderCreated = -1;
							LOGGER.debug("Could not create or write to directory "+ pathTillApplicationId);
						}
				}
				byte[] bytes = file.getBytes();		                  
		         String fileNameToBeSaved= key + fileName.substring(indexOfDot);	
		         LOGGER.debug("fileNameToBeSaved" + fileNameToBeSaved);
		         
		         Path path = Paths.get( pathTillApplicationId + fileNameToBeSaved);       
		         LOGGER.debug( " pathToFolder + fileNameToBeSaved " +pathTillApplicationId + fileNameToBeSaved);
		         
		         //pathOfUploadedFile = pathToFolder + fileNameToBeSaved;
		         pathOfUploadedFile = path.toAbsolutePath().toString();
		         
		         LOGGER.debug(pathOfUploadedFile);
		         
		         Files.write(path, bytes);
			}
			
			catch(IOException e)
			{
				folderCreated = -1;
				LOGGER.error("An excpetion occured while saving file to location "+ pathTillApplicationId);
			}
			catch(Exception e)
			{
				folderCreated = -2;
				LOGGER.error("An exception occured while saving file to the disk at location " + pathTillApplicationId);
			}
	}
		return pathOfUploadedFile;

	}
	
	/*
	 * Method to save file with multiple folders inside*/
	private String saveFile(String key, int applicationId, MultipartFile file, String pathToFolder, String[] insideFolders)
	{
		int folderCreated = 0;	
		String pathTillApplicationId = "";
		String pathOfUploadedFile = "";
		if(!file.isEmpty())
		{	
			String fileName=file.getOriginalFilename();
			int indexOfDot=fileName.indexOf(".");
			try
			{
				pathTillApplicationId = pathToFolder+ applicationId+ "//";
				for(String item : insideFolders)
				{
					pathTillApplicationId = pathTillApplicationId + item + "//";
				}
				File folder = new File (pathTillApplicationId);
				if(!folder.exists())
				{
						if(folder.mkdirs() || folder.canWrite())
						{
							folderCreated = 1;
							LOGGER.debug("File name is " + file.getOriginalFilename());
							LOGGER.debug("Directory "+ folder + " to store files created successfully");
						}
						else
						{
							folderCreated = -1;
							LOGGER.debug("Could not create or write to directory "+ pathTillApplicationId);
						}
				}
				byte[] bytes = file.getBytes();		                  
		         String fileNameToBeSaved= key + fileName.substring(indexOfDot);	
		         LOGGER.debug("fileNameToBeSaved" + fileNameToBeSaved);
		         
		         Path path = Paths.get( pathTillApplicationId + fileNameToBeSaved);       
		         LOGGER.debug( " pathToFolder + fileNameToBeSaved " +pathTillApplicationId + fileNameToBeSaved);
		         
		         //pathOfUploadedFile = pathToFolder + fileNameToBeSaved;
		         pathOfUploadedFile = path.toAbsolutePath().toString();
		         
		         LOGGER.debug(pathOfUploadedFile);
		         
		         Files.write(path, bytes);
			}
			
			catch(IOException e)
			{
				folderCreated = -1;
				LOGGER.error("An excpetion occured while saving file to location "+ pathTillApplicationId);
			}
			catch(Exception e)
			{
				folderCreated = -2;
				LOGGER.error("An exception occured while saving file to the disk at location " + pathTillApplicationId);
			}
	}
		return pathOfUploadedFile;

	}
	
	/*
	 * Method to find application id of logged in user*/
	private int getApplicationId()
	{
		int applicationId = -10;
		applicationId = sessionUserUtility.getApplicationId(sessionUserUtility.getSessionMangementfromSession().getUsername());
		return applicationId;

	}
	
	/*
	 * Get training partner registration id*/
	private String getTrainingPartnerRegistrationId(int applicationId)
	{
		
		String trainingPartnerRegistrationId = null;
		try
		{
			trainingPartnerRegistrationId = profileCreationTrainingPartnerGetDataDao.profileCreationGetTrainingPartnerRegistrationIdUsingApplicationId(applicationId);
		}
		
		catch(Exception e)
		{
			LOGGER.error("An exception occured while finding registration Id for training partner " + e);
		}
		return trainingPartnerRegistrationId;
	}
	/*
	 * Get Assessment body registration id*/
	private String getAssessmentBodyRegistrationId(int applicationId)
	{
		String assessmentBodyRegistrationId = null;
		try{
			assessmentBodyRegistrationId = profileCreationAssessmentBodyGetDataDao.profileCreationGetAssessmentBodyRegistrationIdUsingApplicationId(applicationId);
		}
		catch(Exception e){
			LOGGER.error("An exception occured while finding assessment body registration Id " + e);
		}
		return assessmentBodyRegistrationId;
	}
}
