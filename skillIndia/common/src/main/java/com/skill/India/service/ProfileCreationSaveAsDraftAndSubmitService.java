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
import com.skill.India.dto.ProfileCreationAssessmentBodyWrapperDto;
import com.skill.India.dto.ProfileCreationAssessmentStaffDetailsDto;
import com.skill.India.dto.ProfileCreationAssessmentsExperienceInTechnicalDomainDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerCenterDetailsDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerInstituteGrantDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerInstituteRecognitionDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto;
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
	
	//To save the complete object to database
	public int SaveAssessmentBody(ProfileCreationAssessmentBodyWrapperDto profileCreationAssessmentBodyWrapperDto)
	{
		int returnStatus = 0, applicationTableStatus =0 , status =0, affiliationInsertionStatus =0, directorsAndManagementId = 0, assessmentBodyRecognition = 0, assessmentBodyRegionalOffice =0, assessmentBodyExperienceinTechnical =0, assessmentStaff =0;
		int userExists=getApplicationId();
		//New user
		if (userExists == -1)
		{
			applicationTableStatus = profileCreationTPABCommonDao.insertIntoApplication(profileCreationAssessmentBodyWrapperDto.getType());
			status=profileCreationAssessmentBodyInsertDataDao.insertIntoAssessmentBodyRegistrationDetails(profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentBodyRegistrationDetailsDto());
			if(!profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentBodyAffiliationDetailsDto().isEmpty())
			{
				for (ProfileCreationAssessmentBodyAffiliationDetailsDto profileCreationAssessmentBodyAffiliationDetailsDto:profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentBodyAffiliationDetailsDto())
				affiliationInsertionStatus = profileCreationAssessmentBodyInsertDataDao.insertIntoAssessmentBodyAffiliationDetails(profileCreationAssessmentBodyAffiliationDetailsDto);
			}
			if (! profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto().isEmpty())
			{
				for (ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto item : profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto())
				{
					directorsAndManagementId = profileCreationAssessmentBodyInsertDataDao.insertIntoAssessmentBodyDirectorsAndManagementTeamDetails(item);
				}
			}
			if(!profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentBodyRecognitionsDto().isEmpty())
			{
				for(ProfileCreationAssessmentBodyRecognitionsDto item : profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentBodyRecognitionsDto())
				{
					assessmentBodyRecognition = profileCreationAssessmentBodyInsertDataDao.insertIntoAssessmentBodyRecognitions(item);
				}
				
			}
			if(!profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentBodyRegionalOfficeDetailsDto().isEmpty())
			{
				for (ProfileCreationAssessmentBodyRegionalOfficeDetailsDto item : profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentBodyRegionalOfficeDetailsDto())
				{
					assessmentBodyRegionalOffice = profileCreationAssessmentBodyInsertDataDao.insertIntoAssessmentBodyRegionalOfficeDetails(item);
				}
			}
			if(!profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentsExperienceInTechnicalDomainDto().isEmpty())
			{
				for(ProfileCreationAssessmentsExperienceInTechnicalDomainDto item : profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentsExperienceInTechnicalDomainDto())
				{
					assessmentBodyExperienceinTechnical =profileCreationAssessmentBodyInsertDataDao.insertIntoAssessmentsExperienceInTechnicalDomain(item);
				}
				
			}
			
			if(!profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentStaffDetailsDto().isEmpty())
			{
				for(ProfileCreationAssessmentStaffDetailsDto item : profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentStaffDetailsDto())
				{
					assessmentStaff = profileCreationAssessmentBodyInsertDataDao.insertIntoAssessmentStaffDetails(item);
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
			status = profileCreationAssessmentBodyUpdateDataDao.updateIntoAssessmentBodyRegistrationDetails(profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentBodyRegistrationDetailsDto());
			
			/* Assessment Body Affiliation Details */
			if(!profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentBodyAffiliationDetailsDto().isEmpty())
			{
				for(ProfileCreationAssessmentBodyAffiliationDetailsDto item : profileCreationAssessmentBodyWrapperDto.getProfileCreationAssessmentBodyAffiliationDetailsDto())
				{
					 int affiliationPresent = profileCreationAssessmentBodyGetDataDao.isAffiliationPresent(item.getAssessmentBodyRegistrationId(), item.getAffiliationId());
					if(affiliationPresent == 0)
					{
						LOGGER.debug("AffiliationId" + item.getAffiliationId());
						LOGGER.debug("abregId" + item.getAssessmentBodyRegistrationId());
						LOGGER.debug("sector skil council" + item.getNameOfSectorSkillCouncil());
						profileCreationAssessmentBodyInsertDataDao.insertIntoAssessmentBodyAffiliationDetails(item);
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
						int managmentStatus = profileCreationAssessmentBodyGetDataDao.isManagementPresent(item.getAssessmentBodyRegistrationId(), item.getDirectorsAndManagementId());	
						if(managmentStatus == 0)
						{
							profileCreationAssessmentBodyInsertDataDao.insertIntoAssessmentBodyDirectorsAndManagementTeamDetails(item);
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
					LOGGER.debug("recognitionID" + item.getAssessmentBodyRecognitionId());
					LOGGER.debug("registrationId" + item.getAssessmentBodyRegistrationId());
					int recognitionABStatus = profileCreationAssessmentBodyGetDataDao.isRecognitionPresent(item.getAssessmentBodyRegistrationId(), item.getAssessmentBodyRecognitionId());
					if(recognitionABStatus == 0)
					{
						assessmentBodyRecognition = profileCreationAssessmentBodyInsertDataDao.insertIntoAssessmentBodyRecognitions(item);
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
					int regionalOfficeStatus = profileCreationAssessmentBodyGetDataDao.isRegionalOfficePresent(item.getAssessmentBodyRegistrationId(), item.getRegionalOfficeId());
					LOGGER.debug("Regional office check value is " +regionalOfficeStatus);
					if(regionalOfficeStatus == 0)
					{
						assessmentBodyRegionalOffice = profileCreationAssessmentBodyInsertDataDao.insertIntoAssessmentBodyRegionalOfficeDetails(item);
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
					int experienceinTechnical = profileCreationAssessmentBodyGetDataDao.isExperiencePresent(item.getAssessmentBodyRegistrationId(), item.getAssessmentExperienceId());
					if(experienceinTechnical == 0)
					{
						LOGGER.debug("Experience does not exist, need to create new entry in database");
						assessmentBodyExperienceinTechnical =profileCreationAssessmentBodyInsertDataDao.insertIntoAssessmentsExperienceInTechnicalDomain(item);
						
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
					int assessmentStaffPresent = profileCreationAssessmentBodyGetDataDao.isStaffPresent(item.getAssessmentBodyRegistrationId(), item.getAssessmentStaffId());
					if(assessmentStaffPresent == 0)
					{
						assessmentStaff = profileCreationAssessmentBodyInsertDataDao.insertIntoAssessmentStaffDetails(item);
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
		int status =0 , applicationTableStatus =0, trainingPartnerCenterDetails = 0, trainingPartnerInstituteGrant =0,trainingPartnerRecognition =0, trainingStaff =0, experienceInTraining =0;
		int userExists=getApplicationId();
		
		//New User
		if(userExists == -1)
		{
			applicationTableStatus = profileCreationTPABCommonDao.insertIntoApplication(profileCreationTrainingPartnerWrapperDto.getType());
			status = profileCreationTrainingPartnerInsertDataDao.insertIntoTrainingPartnerOrganizationDetails(profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerOrganizationDetailsDto());
			if(!profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerCenterDetailsDto().isEmpty())
			{
			
				for(ProfileCreationTrainingPartnerCenterDetailsDto item : profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerCenterDetailsDto())
				{
					trainingPartnerCenterDetails = profileCreationTrainingPartnerInsertDataDao.insertIntoTrainingPartnerCenterLevelDetails(item);
				}
			}
			
			if(! profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerInstituteGrantDto().isEmpty())
			{
				
				for(ProfileCreationTrainingPartnerInstituteGrantDto item :profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerInstituteGrantDto())
				{
					trainingPartnerInstituteGrant = profileCreationTrainingPartnerInsertDataDao.insertIntoTrainingPartnerInstituteGrant(item);					
				}
			}
			if(!profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerInstituteRecognitionDto().isEmpty())
			{
				for(ProfileCreationTrainingPartnerInstituteRecognitionDto item :profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerInstituteRecognitionDto())
				{
					trainingPartnerRecognition = profileCreationTrainingPartnerInsertDataDao.insertIntoTrainingPartnerInstituteRecognition(item);
				}
				
			}
			if(!profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto().isEmpty())
			{
				for(ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto item : profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto())
				{
					trainingStaff = profileCreationTrainingPartnerInsertDataDao.insertIntoTrainingPartnerManagementAndStaffAndOfficialsDetails(item);
				}
			}
			
			if(!profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto().isEmpty())
			{
				for(ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto item :profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto())
				{
					experienceInTraining = profileCreationTrainingPartnerInsertDataDao.insertIntoTrainingPartnerPriorExperienceInSkillTraining(item);
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
			applicationTableStatus = profileCreationTPABCommonDao.updateIntoApplication(profileCreationTrainingPartnerWrapperDto.getType());
			status = profileCreationTrainingPartnerUpdateDataDao.updateIntoTrainingPartnerOrganizationDetails(profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerOrganizationDetailsDto());
			/*
			 * Training Center Details*/
			if(!profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerCenterDetailsDto().isEmpty())
			{
				int doesTrainingCenterExists = 10;
				for(ProfileCreationTrainingPartnerCenterDetailsDto item : profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerCenterDetailsDto())
				{
					doesTrainingCenterExists = profileCreationTrainingPartnerGetDataDao.isTrainingCenterPresent(item.getTrainingPartnerRegistrationId(), item.getTrainingPartnerCenterId());
					if(doesTrainingCenterExists == 0)
					{
						trainingPartnerCenterDetails = profileCreationTrainingPartnerInsertDataDao.insertIntoTrainingPartnerCenterLevelDetails(item);
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
					doesInstitueGrantExists = profileCreationTrainingPartnerGetDataDao.isInstituteGrantPresent(item.getTrainingPartnerRegistrationId(), item.getInstituteGrantId());
					if(doesInstitueGrantExists == 0)
					{
						trainingPartnerInstituteGrant = profileCreationTrainingPartnerInsertDataDao.insertIntoTrainingPartnerInstituteGrant(item);
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
						LOGGER.debug("Do nothing");
					}
										
				}
			}
			/*Training Partner Institute recognitions details*/
			if(!profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerInstituteRecognitionDto().isEmpty())
			{
				int doesRecognitionExists = 0; 
				for(ProfileCreationTrainingPartnerInstituteRecognitionDto item :profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerInstituteRecognitionDto())
				{
					doesRecognitionExists = profileCreationTrainingPartnerGetDataDao.isInstituteRecognitionPresent(item.getTrainingPartnerRegistrationId(),item.getInstituteRecognitionId());
					if(doesRecognitionExists ==0)
					{
						LOGGER.debug("Returned 0");
						trainingPartnerRecognition = profileCreationTrainingPartnerInsertDataDao.insertIntoTrainingPartnerInstituteRecognition(item);
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
			
			/*Training Partner Training staff details*/
			if(!profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto().isEmpty())
			{
				int doesTrainingStaffExists =10;
				for(ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto item : profileCreationTrainingPartnerWrapperDto.getProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto())
				{
					doesTrainingStaffExists = profileCreationTrainingPartnerGetDataDao.isTrainingStaffPresent(item.getTrainingPartnerRegistrationId(), item.getManagementAndStaffId());
					if(doesTrainingStaffExists == 0)
					{
						trainingStaff = profileCreationTrainingPartnerInsertDataDao.insertIntoTrainingPartnerManagementAndStaffAndOfficialsDetails(item);
					}
					else if(doesTrainingStaffExists == 1)
					{
						trainingStaff = profileCreationTrainingPartnerUpdateDataDao.updateIntoTrainingPartnerManagementAndStaffAndOfficialsDetails(item);
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
					doesExperienceExists = profileCreationTrainingPartnerGetDataDao.isTrainingExperiencePresent(item.getTrainingPartnerRegistrationId(), item.getPriorExperienceInSkillTrainingId());
					if(doesExperienceExists == 0)
					{
						experienceInTraining = profileCreationTrainingPartnerInsertDataDao.insertIntoTrainingPartnerPriorExperienceInSkillTraining(item);
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
			
		}
		return status;
	}
	
	/*Method to save TAN of Training Partner*/
	public int saveTPTAN(MultipartFile TrainingPartnerTan, String key)
	{
		int tanPathUpdated = 0, status =0, applicationId =0;
		applicationId = getApplicationId();
		if(applicationId > 0)
		{
			String tpTanPath = saveFile(key, applicationId, TrainingPartnerTan);
			tanPathUpdated = profileCreationTrainingPartnerUpdateDataDao.updateTanPath(tpTanPath,applicationId);
		}
		return tanPathUpdated;
	}
	
	/*Method to save PAN of Training Partner*/
	public int saveTPPAN(MultipartFile TrainingPartnerPan, String key)
	{
		int panPathUpdated = 0;
		String panPath = "";
		int applicationId = getApplicationId();
		try
		{
			panPath = saveFile(key, applicationId, TrainingPartnerPan);
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
		String certificatePath = "";
		int applicationId = getApplicationId();
		try
		{
			certificatePath = saveFile(key, applicationId, nsdcCertificate);
			LOGGER.debug("nsdc certificate path is " + certificatePath);
		}
		catch(Exception e)
		{
			LOGGER.error("An exception occured while saving file " + e);
		}
		
		nsdcCertifiacte = profileCreationTrainingPartnerUpdateDataDao.updateNsdcCertificatePath(certificatePath, applicationId);
		return nsdcCertifiacte;
	}
	
	/*Method to get application Id from userId*/
	private int getApplicationId()
	{
		int applicationId = sessionUserUtility.getApplicationId(sessionUserUtility.getSessionMangementfromSession().getUsername());
		return applicationId;
	}
	
	
	/*Method to save file */
	private String saveFile(String key, int applicationId, MultipartFile file)
	{
		int folderCreated = 0;		
		String pathToFolder ="", pathOfUploadedFile = "";
		if(!file.isEmpty())
		{	
			String fileName=file.getOriginalFilename();
			int indexOfDot=fileName.indexOf(".");
			try
			{
				pathToFolder = readApplicationConstants.getProfileCreationTrainingPartnerFolder() + applicationId+ "//";
				File folder = new File (pathToFolder);
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
							LOGGER.debug("Could not create or write to directory "+ pathToFolder);
						}
				}
				byte[] bytes = file.getBytes();		                  
		         String fileNameToBeSaved= key + fileName.substring(indexOfDot);	
		         LOGGER.debug("fileNameToBeSaved" + fileNameToBeSaved);
		         
		         Path path = Paths.get( pathToFolder + fileNameToBeSaved);       
		         LOGGER.debug( " pathToFolder + fileNameToBeSaved " +pathToFolder + fileNameToBeSaved);
		         
		         //pathOfUploadedFile = pathToFolder + fileNameToBeSaved;
		         pathOfUploadedFile = path.toAbsolutePath().toString();
		         
		         LOGGER.debug(pathOfUploadedFile);
		         
		         Files.write(path, bytes);
			}
			
			catch(IOException e)
			{
				folderCreated = -1;
				LOGGER.error("An excpetion occured while saving file to location "+ pathToFolder);
			}
			catch(Exception e)
			{
				folderCreated = -2;
				LOGGER.error("An exception occured while saving file to the disk at location " + pathToFolder);
			}
	}
		return pathOfUploadedFile;

	}
}
