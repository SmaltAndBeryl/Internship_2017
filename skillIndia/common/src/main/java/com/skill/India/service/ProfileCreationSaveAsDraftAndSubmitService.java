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
import com.skill.India.dao.ProfileCreationAssessmentBodyGetDataDao;
import com.skill.India.dao.ProfileCreationAssessmentBodyInsertDataDao;
import com.skill.India.dao.ProfileCreationAssessmentBodyUpdateDataDao;
import com.skill.India.dao.ProfileCreationTPABCommonDao;
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

	@Autowired
	private ProfileCreationAssessmentBodyInsertDataDao profileCreationAssessmentBodyInsertDataDao;
	
	@Autowired
	private ProfileCreationAssessmentBodyUpdateDataDao profileCreationAssessmentBodyUpdateDataDao;
	
	//To save the complete object to database
	public int SaveAssessmentBody(ProfileCreationAssessmentBodyWrapperDto profileCreationAssessmentBodyWrapperDto)
	{
		int returnStatus = 0, applicationTableStatus =0 , status =0, affiliationInsertionStatus =0, directorsAndManagementId =0;
		int userExists=sessionUserUtility.getApplicationId(sessionUserUtility.getSessionMangementfromSession().getUsername());
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
				
			}
			if (status == -1 || applicationTableStatus == -1 || affiliationInsertionStatus == -1 || directorsAndManagementId == -1)
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
						LOGGER.info("AffiliationId" + item.getAffiliationId());
						LOGGER.info("abregId" + item.getAssessmentBodyRegistrationId());
						LOGGER.info("sector skil council" + item.getNameOfSectorSkillCouncil());
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
			
			/* Return status as -1 */
			if (applicationTableStatus == -1 || status == -1)
			{
				returnStatus = -1;
			}
		}
		
		return returnStatus;
	}

	
	private void SaveAssessmentBodyRegistrationData(ProfileCreationAssessmentBodyRegistrationDetailsDto profileCreationAssessmentBodyRegistrationDetailsDto)
	{
		//profileCreationAssessmentBodyInsertDataDao.insertIntoAssessmentBodyRegistrationDetails(profileCreationAssessmentBodyRegistrationDetailsDto, getPaths)
	}
	private void SaveAssessmentBodyRecognitionData(Collection<ProfileCreationAssessmentBodyRecognitionsDto> profileCreationAssessmentBodyRecognitionsDto)
	{
		
	}
	
	private void SaveAssessmentBodyManagmentStaffData(Collection<ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto> ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto)
	{
		
	}
	private void SaveAssessmentBodyAssessmentStaffData(Collection<ProfileCreationAssessmentStaffDetailsDto> ProfileCreationAssessmentStaffDetailsDto)
	{
		
	}
	private void SaveAssessmentBodyExperienceInTechnicalDomainData()
	{
		
	}
	private void SaveAssessmentBodyRegionalOfficeData()
	{
		
	}

}
