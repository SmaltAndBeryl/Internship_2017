package com.skill.India.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.common.SessionUserUtility;
import com.skill.India.dao.GetUserRoleDao;
import com.skill.India.dao.ProfileCreationTPABCommonDao;
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
	private ProfileCreationTrainingPartnerOrganizationDetailsDto profileCreationTrainingPartnerOrganizationDetailsDto; 
	
	public String profileCreationSaveAsDraftAndSubmit(String type,HashMap<String, HashMap<String, HashMap<String, String>>> userData)
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
			HashMap<String, HashMap<String, String>> trainingPartnerCenterLevelDetails=userData.get("TrainingPartnerCenterLevelDetails");
			HashMap<String, HashMap<String, String>> trainingPartnerInstituteGrant=userData.get("TrainingPartnerInstituteGrant");
			HashMap<String, HashMap<String, String>> trainingPartnerInstituteRecognition=userData.get("TrainingPartnerInstituteRecognition");
			HashMap<String, HashMap<String, String>> trainingPartnerPriorExperienceInSkillTraining=userData.get("TrainingPartnerPriorExperienceInSkillTraining");
			HashMap<String, HashMap<String, String>> trainingPartnerManagementAndStaffAndOfficialsDetails=userData.get("TrainingPartnerManagementAndStaffAndOfficialsDetails");
			
			/*
			 * Setting different Dto's
			 */
			
			
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
			 * ProfileCreationTrainingPartnerInstituteGrantDto Setting Starts
			 */
			
			ArrayList<ProfileCreationTrainingPartnerInstituteGrantDto> trainingPartnerInstituteGrantList = new ArrayList<ProfileCreationTrainingPartnerInstituteGrantDto>();
			
			for(Map.Entry<String, HashMap<String, String>> profileCreationTrainingPartnerInstituteGrantIterator : trainingPartnerInstituteGrant.entrySet())
			{
				/*
				 * Setting the incoming data in  respective DTO's ProfileCreationTrainingPartnerInstituteGrantDto
				 */
				HashMap<String, String> setProfileCreationTrainingPartnerInstituteGrantDto=new HashMap<String, String>();
				setProfileCreationTrainingPartnerInstituteGrantDto=profileCreationTrainingPartnerInstituteGrantIterator.getValue();
				trainingPartnerInstituteGrantList.add(new ProfileCreationTrainingPartnerInstituteGrantDto(
						setProfileCreationTrainingPartnerInstituteGrantDto.get("instituteGrantId"),
						setProfileCreationTrainingPartnerInstituteGrantDto.get("trainingPartnerRegistrationId"),
						setProfileCreationTrainingPartnerInstituteGrantDto.get("nameOfMinistry"),
						setProfileCreationTrainingPartnerInstituteGrantDto.get("natureOfWork"),
						setProfileCreationTrainingPartnerInstituteGrantDto.get("remarks")
						));	
			}
			
			/*
			 * Setting of ProfileCreationTrainingPartnerInstituteGrantDto ends
			 */
			
			
			/*
			 *ProfileCreationTrainingPartnerInstituteRecognitionDto Setting Starts 
			 */
			
			ArrayList<ProfileCreationTrainingPartnerInstituteRecognitionDto> trainingPartnerInstituteRecognitionList=new ArrayList<ProfileCreationTrainingPartnerInstituteRecognitionDto>();
			
			for(Map.Entry<String, HashMap<String, String>> profileCreationTrainingPartnerInstituteRecognitionIterator : trainingPartnerInstituteRecognition.entrySet())
			{
				HashMap<String, String> setProfileCreationTrainingPartnerInstituteRecognitionDto = new HashMap<String, String>();
				setProfileCreationTrainingPartnerInstituteRecognitionDto=profileCreationTrainingPartnerInstituteRecognitionIterator.getValue();
				trainingPartnerInstituteRecognitionList.add(new ProfileCreationTrainingPartnerInstituteRecognitionDto(
						setProfileCreationTrainingPartnerInstituteRecognitionDto.get("instituteRecognitionId"),
						setProfileCreationTrainingPartnerInstituteRecognitionDto.get("trainingPartnerRegistrationId"),
						setProfileCreationTrainingPartnerInstituteRecognitionDto.get("nameOfRecognizingBody"),
						setProfileCreationTrainingPartnerInstituteRecognitionDto.get("recognitionNumber"),
						setProfileCreationTrainingPartnerInstituteRecognitionDto.get("yearOfRecognition"),
						setProfileCreationTrainingPartnerInstituteRecognitionDto.get("validityOfRecognition")
						));
			}
			
			/*
			 * Setting of ProfileCreationTrainingPartnerInstituteRecognitionDto ends 
			 */
			
			/*
			 * ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto Setting Starts
			 */
			
			ArrayList<ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto> trainingPartnerPriorExperienceInSkillTrainingList = new ArrayList<ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto>();
			
			for(Map.Entry<String, HashMap<String, String>> profileCreationTrainingPartnerPriorExperienceInSkillTrainingIterator : trainingPartnerPriorExperienceInSkillTraining.entrySet())
			{
			HashMap<String, String> setProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto = new HashMap<String, String>();
			setProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto=profileCreationTrainingPartnerPriorExperienceInSkillTrainingIterator.getValue();
			trainingPartnerPriorExperienceInSkillTrainingList.add(new ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto(
					setProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto.get("priorExperienceInSkillTrainingId"),
					setProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto.get("trainingPartnerRegistrationId"),
					setProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto.get("courseName"),
					setProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto.get("numberOfBatchesPerYear"),
					setProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto.get("numberOfStudentsInEachBatch")	
					));
			}
			
			/*
			 * Setting of ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto Ends
			 */
			
			
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
			 * Setting of Dto's Ends here
			 */
			
			
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
