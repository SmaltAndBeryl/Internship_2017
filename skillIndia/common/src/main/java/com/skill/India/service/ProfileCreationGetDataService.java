package com.skill.India.service;

import java.util.Collection;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.common.SessionUserUtility;
import com.skill.India.dao.GetUserRoleDao;
import com.skill.India.dao.ProfileCreationAssessmentBodyGetDataDao;
import com.skill.India.dao.ProfileCreationTPABCommonDao;
import com.skill.India.dao.ProfileCreationTrainingPartnerGetDataDao;
import com.skill.India.dto.ProfileCreationAssessmentBodyAffiliationDetailsDto;
import com.skill.India.dto.ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto;
import com.skill.India.dto.ProfileCreationAssessmentBodyRecognitionsDto;
import com.skill.India.dto.ProfileCreationAssessmentBodyRegionalOfficeDetailsDto;
import com.skill.India.dto.ProfileCreationAssessmentBodyRegistrationDetailsDto;
import com.skill.India.dto.ProfileCreationAssessmentStaffDetailsDto;
import com.skill.India.dto.ProfileCreationAssessmentsExperienceInTechnicalDomainDto;
import com.skill.India.dto.ProfileCreationGetDataFromUserDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerCenterDetailsDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerInstituteGrantDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerInstituteRecognitionDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerOrganizationDetailsDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto;

@Service
public class ProfileCreationGetDataService {
	
	@Autowired
	private SessionUserUtility sessionUserUtility;
	
	@Autowired
	private GetUserRoleDao getUserRoleDao;
	
	@Autowired
	private ProfileCreationTPABCommonDao profileCreationTPABCommonDao;
	
	@Autowired
	private ProfileCreationTrainingPartnerGetDataDao profileCreationTrainingPartnerGetDataDao;
	
	@Autowired
	private ProfileCreationAssessmentBodyGetDataDao profileCreationAssessmentBodyGetDataDao;
 	
	public HashMap<String, Object> profileCreationGetData(int applicationId)
	{
		HashMap<String , Object> userData = new HashMap<String, Object>();
		try{
			
		//int applicationId = sessionUserUtility.getApplicationId("Gagan.bhargav@sebiz.net");
		/*
		 *  -1 is returned if appId doesn't exist for particular userId
		 */
		if(applicationId== -1)
		{
			/*
			 * Get data from user table
			 */
			
			Collection<ProfileCreationGetDataFromUserDto> profileCreationGetDataFromUserDto = profileCreationTPABCommonDao.profileCreationGetDataFromUser();
			userData.put("userTableData", profileCreationGetDataFromUserDto);
			return userData;
			
		}
		else if(applicationId == -2)
		{
			/*
			 * Exception occurred while getting application Id corresponding userId
			 *  
			 */
			
			return null;
		}
		else
		{
			/*
			 * If control comes here then user already filled his/her profile once
			 */
			
			String userRole=getUserRoleDao.getUserRole(sessionUserUtility.getSessionMangementfromSession().getUsername());
			
			if(userRole.equalsIgnoreCase("TP"))
			{
				/*
				 * Get trainingPartnerRegistrationId using applicationId 
				 */
				
				String trainingPartnerRegistrationId= profileCreationTrainingPartnerGetDataDao.profileCreationGetTrainingPartnerRegistrationIdUsingApplicationId(applicationId);
				
				/*
				 * Get data from Training Partner Tables 
				 */
				
				Collection<ProfileCreationTrainingPartnerOrganizationDetailsDto> profileCreationOrganizationLevelDetails=profileCreationTrainingPartnerGetDataDao.profileCreationGetDataFromTrainingPartnerOrganizationDetails(applicationId);
				Collection<ProfileCreationTrainingPartnerCenterDetailsDto> profileCreationTrainingPartnerCenterDetails=profileCreationTrainingPartnerGetDataDao.profileCreationGetDataFromTrainingPartnerCenterLevelDetails(trainingPartnerRegistrationId);
				Collection<ProfileCreationTrainingPartnerInstituteGrantDto> profileCreationTrainingPartnerInstituteGrant =profileCreationTrainingPartnerGetDataDao.profileCreationGetDataFromTrainingPartnerInstituteGrant(trainingPartnerRegistrationId);
				Collection<ProfileCreationTrainingPartnerInstituteRecognitionDto> profileCreationTrainingPartnerInstituteRecognition=profileCreationTrainingPartnerGetDataDao.profileCreationGetDataFromTrainingPartnerInstituteRecognition(trainingPartnerRegistrationId);
				Collection<ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto> profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetails =profileCreationTrainingPartnerGetDataDao.profileCreationGetDataFromTrainingPartnerManagementAndStaffAndOfficialsDetails(trainingPartnerRegistrationId);
				Collection<ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto> profileCreationTrainingPartnerPriorExperienceInSkillTraining =profileCreationTrainingPartnerGetDataDao.profileCreationGetDataFromTrainingPartnerPriorExperienceInSkillTraining(trainingPartnerRegistrationId);
				
				userData.put("TrainingPartnerOrganizationDetails", profileCreationOrganizationLevelDetails);
				userData.put("TrainingPartnerCenterDetails", profileCreationTrainingPartnerCenterDetails);
				userData.put("InstituteGrantDetails", profileCreationTrainingPartnerInstituteGrant);
				userData.put("InstituteRecognitionDetails", profileCreationTrainingPartnerInstituteRecognition);
				userData.put("ManagementAndStaffAndOfficialDetails", profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetails);
				userData.put("PriorExperienceDetails", profileCreationTrainingPartnerPriorExperienceInSkillTraining);
				return userData;
			}
			
			
			else if(userRole.equalsIgnoreCase("AB"))
			{
				/*
				 * get AssessmentBodyRegistrationId using ApplicationId
				 */
				
				String assessmentBodyRegistrationId = profileCreationAssessmentBodyGetDataDao.profileCreationGetAssessmentBodyRegistrationIdUsingApplicationId(applicationId);
				
				Collection<ProfileCreationAssessmentBodyRegistrationDetailsDto> profileCreationAssessmentBodyRegistrationDetails=profileCreationAssessmentBodyGetDataDao.profileCreationGetDataFromAssessmentBodyRegistrationDetails(applicationId);;
				Collection<ProfileCreationAssessmentBodyRecognitionsDto> profileCreationAssessmentBodyRecognitions=profileCreationAssessmentBodyGetDataDao.profileCreationGetDataFromAssessmentBodyRecognitions(assessmentBodyRegistrationId);
				Collection<ProfileCreationAssessmentsExperienceInTechnicalDomainDto> profileCreationAssessmentsExperienceInTechnicalDomain=profileCreationAssessmentBodyGetDataDao.profileCreationGetDataFromAssessmentsExperienceInTechnicalDomain(assessmentBodyRegistrationId);
				Collection<ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto> profileCreationAssessmentBodyDirectorsAndManagementTeamDetails=profileCreationAssessmentBodyGetDataDao.profileCreationGetDataFromAssessmentBodyDirectorsAndManagementTeamDetails(assessmentBodyRegistrationId);
				Collection<ProfileCreationAssessmentStaffDetailsDto> profileCreationAssessmentStaffDetails=profileCreationAssessmentBodyGetDataDao.profileCreationGetDataFromAssessmentStaffDetails(assessmentBodyRegistrationId);
				Collection<ProfileCreationAssessmentBodyRegionalOfficeDetailsDto> profileCreationAssessmentBodyRegionalOfficeDetails=profileCreationAssessmentBodyGetDataDao.profileCreationGetDataFromAssessmentBodyRegionalOfficeDetails(assessmentBodyRegistrationId);
				Collection<ProfileCreationAssessmentBodyAffiliationDetailsDto> profileCreationAssessmentBodyAffiliationDetails=profileCreationAssessmentBodyGetDataDao.profileCreationGetDataFromAssessmentBodyAffiliationDetails(assessmentBodyRegistrationId);

				userData.put("AssessmentBodyRegistrationDetails", profileCreationAssessmentBodyRegistrationDetails);
				userData.put("AssessmentBodyRecognitions", profileCreationAssessmentBodyRecognitions);
				userData.put("AssessmentsExperienceInTechnicalDomain", profileCreationAssessmentsExperienceInTechnicalDomain);
				userData.put("AssessmentBodyDirectorsAndManagementTeamDetails", profileCreationAssessmentBodyDirectorsAndManagementTeamDetails);
				userData.put("AssessmentStaffDetails", profileCreationAssessmentStaffDetails);
				userData.put("AssessmentBodyRegionalOfficeDetails",profileCreationAssessmentBodyRegionalOfficeDetails );			
				userData.put("AssessmentBodyAffiliationDetails", profileCreationAssessmentBodyAffiliationDetails);
				return userData;
			}
			else
			{
				/*
				 * UserRole Not AB/TP (Problem in finding user role ) 
				 */
				return null;
			}

		}
			
		}
		catch(Exception e)
		{
			/*
			 * Error occurred while getting data from User/TP/AB tables
			 */
			e.printStackTrace();
			return null;
		}
	}

}
