package com.skill.India.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.common.ReadApplicationConstants;
import com.skill.India.common.SessionUserUtility;
import com.skill.India.dao.GetUserRoleDao;
import com.skill.India.dao.ProfileCreationTPABCommonDao;
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
			
			/*
			 * ProfileCreationAssessmentBodyRegistrationDetailsDto Setting Starts
			 */
			
			ArrayList<ProfileCreationAssessmentBodyRegistrationDetailsDto> assessmentBodyRegistrationDetailsList = new ArrayList<ProfileCreationAssessmentBodyRegistrationDetailsDto>();
			
			for(Map.Entry<String, HashMap<String, String>> profileCreationAssessmentBodyRegistrationDetailsIterator : assessmentBodyRegistrationDetails.entrySet())
			{
			HashMap<String, String> setProfileCreationAssessmentBodyRegistrationDetailsDto = new HashMap<String, String>();
			setProfileCreationAssessmentBodyRegistrationDetailsDto=profileCreationAssessmentBodyRegistrationDetailsIterator.getValue();
			assessmentBodyRegistrationDetailsList.add(new ProfileCreationAssessmentBodyRegistrationDetailsDto(
					setProfileCreationAssessmentBodyRegistrationDetailsDto.get("assessmentBodyRegistrationId"),
					setProfileCreationAssessmentBodyRegistrationDetailsDto.get("applicationId"),
					setProfileCreationAssessmentBodyRegistrationDetailsDto.get("organizationName"),
					setProfileCreationAssessmentBodyRegistrationDetailsDto.get("sPOCName"),
					setProfileCreationAssessmentBodyRegistrationDetailsDto.get("address"),
					setProfileCreationAssessmentBodyRegistrationDetailsDto.get("city"),
					setProfileCreationAssessmentBodyRegistrationDetailsDto.get("state"),
					setProfileCreationAssessmentBodyRegistrationDetailsDto.get("pincode"),
					setProfileCreationAssessmentBodyRegistrationDetailsDto.get("mobileNumber"),
					setProfileCreationAssessmentBodyRegistrationDetailsDto.get("alternateMobileNumber"),
					setProfileCreationAssessmentBodyRegistrationDetailsDto.get("landlineNumber"),
					setProfileCreationAssessmentBodyRegistrationDetailsDto.get("alternateLandlineNumber"),
					setProfileCreationAssessmentBodyRegistrationDetailsDto.get("faxNumber"),
					setProfileCreationAssessmentBodyRegistrationDetailsDto.get("websites"),
					setProfileCreationAssessmentBodyRegistrationDetailsDto.get("yearOfEstablishment"),
					setProfileCreationAssessmentBodyRegistrationDetailsDto.get("priorAssessmentExperience"),
					setProfileCreationAssessmentBodyRegistrationDetailsDto.get("panNumber"),
					setProfileCreationAssessmentBodyRegistrationDetailsDto.get("panNumberPath"),
					setProfileCreationAssessmentBodyRegistrationDetailsDto.get("tanNumber"),
					setProfileCreationAssessmentBodyRegistrationDetailsDto.get("tanNumberPath"),
					setProfileCreationAssessmentBodyRegistrationDetailsDto.get("insituteReceivedAnyRecognition"),
					setProfileCreationAssessmentBodyRegistrationDetailsDto.get("numberOfTechnicalAssessors"),
					setProfileCreationAssessmentBodyRegistrationDetailsDto.get("numberOfNonTechnicalAssessors"),
					setProfileCreationAssessmentBodyRegistrationDetailsDto.get("affiliatedToAnySectorSkillCouncil")
					));
			}
			
			/*
			 * Setting of ProfileCreationAssessmentBodyRegistrationDetailsDto Ends Here
			 */

			
			
			/*
			 * ProfileCreationAssessmentBodyRecognitionsDto Setting Starts
			 */
			
			ArrayList<ProfileCreationAssessmentBodyRecognitionsDto> assessmentBodyRecognitionsList = new ArrayList<ProfileCreationAssessmentBodyRecognitionsDto>();
			
			for(Map.Entry<String, HashMap<String, String>> profileCreationAssessmentBodyRecognitionsIterator : assessmentBodyRecognitions.entrySet())
			{
			HashMap<String, String> setProfileCreationAssessmentBodyRecognitionsDto = new HashMap<String, String>();
			setProfileCreationAssessmentBodyRecognitionsDto=profileCreationAssessmentBodyRecognitionsIterator.getValue();
			assessmentBodyRecognitionsList.add(new ProfileCreationAssessmentBodyRecognitionsDto(
					setProfileCreationAssessmentBodyRecognitionsDto.get("assessmentBodyRecognitionId"),
					setProfileCreationAssessmentBodyRecognitionsDto.get("assessmentBodyRegistrationId"),
					setProfileCreationAssessmentBodyRecognitionsDto.get("nameOfRecognitionBody"),
					setProfileCreationAssessmentBodyRecognitionsDto.get("recognitionNumber"),
					setProfileCreationAssessmentBodyRecognitionsDto.get("yearOfRecognition"),
					setProfileCreationAssessmentBodyRecognitionsDto.get("validityOfRecognition")
					));
			}
			
			/*
			 * Setting of ProfileCreationAssessmentBodyRecognitionsDto Ends Here
			 */
			
			
			
			/*
			 * ProfileCreationAssessmentsExperienceInTechnicalDomainDto Setting Starts
			 */
			
			ArrayList<ProfileCreationAssessmentsExperienceInTechnicalDomainDto> assessmentsExperienceInTechnicalDomainList = new ArrayList<ProfileCreationAssessmentsExperienceInTechnicalDomainDto>();
			
			for(Map.Entry<String, HashMap<String, String>> profileCreationAssessmentsExperienceInTechnicalDomainIterator : assessmentsExperienceInTechnicalDomain.entrySet())
			{
			HashMap<String, String> setProfileCreationAssessmentsExperienceInTechnicalDomainDto = new HashMap<String, String>();
			setProfileCreationAssessmentsExperienceInTechnicalDomainDto=profileCreationAssessmentsExperienceInTechnicalDomainIterator.getValue();
			assessmentsExperienceInTechnicalDomainList.add(new ProfileCreationAssessmentsExperienceInTechnicalDomainDto(
					setProfileCreationAssessmentsExperienceInTechnicalDomainDto.get("assessmentExperienceId"),
					setProfileCreationAssessmentsExperienceInTechnicalDomainDto.get("assessmentBodyRegistrationId"),
					setProfileCreationAssessmentsExperienceInTechnicalDomainDto.get("domain"),
					setProfileCreationAssessmentsExperienceInTechnicalDomainDto.get("numberOfAssessmentsDone")
					));
			}
			
			/*
			 * Setting of ProfileCreationAssessmentsExperienceInTechnicalDomainDto Ends Here
			 */
			
			
			
			/*
			 * ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto Setting Starts
			 */
			
			ArrayList<ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto> assessmentBodyDirectorsAndManagementTeamDetailsList = new ArrayList<ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto>();
			
			for(Map.Entry<String, HashMap<String, String>> profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsIterator : assessmentBodyDirectorsAndManagementTeamDetail.entrySet())
			{
			HashMap<String, String> setProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto = new HashMap<String, String>();
			setProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto=profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsIterator.getValue();
			assessmentBodyDirectorsAndManagementTeamDetailsList.add(new ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto(
					setProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto.get("directorsAndManagementId"),
					setProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto.get("assessmentBodyRegistrationId"),
					setProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto.get("name"),
					setProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto.get("designation"),
					setProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto.get("contactNumber"),
					setProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto.get("emailId"),
					setProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto.get("educationalQualification"),
					setProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto.get("experience"),
					setProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto.get("cVPath")
					));
			}
			
			/*
			 * Setting of ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto Ends Here
			 */
			
			
			/*
			 * ProfileCreationAssessmentStaffDetailsDto Setting Starts
			 */
			
			ArrayList<ProfileCreationAssessmentStaffDetailsDto> assessmentStaffDetailsList = new ArrayList<ProfileCreationAssessmentStaffDetailsDto>();
			
			for(Map.Entry<String, HashMap<String, String>> profileCreationAssessmentStaffDetailsIterator : assessmentStaffDetails.entrySet())
			{
			HashMap<String, String> setProfileCreationAssessmentStaffDetailsDto = new HashMap<String, String>();
			setProfileCreationAssessmentStaffDetailsDto=profileCreationAssessmentStaffDetailsIterator.getValue();
			assessmentStaffDetailsList.add(new ProfileCreationAssessmentStaffDetailsDto(
					setProfileCreationAssessmentStaffDetailsDto.get("assessmentStaffId"),
					setProfileCreationAssessmentStaffDetailsDto.get("assessmentBodyRegistrationId"),
					setProfileCreationAssessmentStaffDetailsDto.get("name"),
					setProfileCreationAssessmentStaffDetailsDto.get("jobRoleCode"),
					setProfileCreationAssessmentStaffDetailsDto.get("designation"),
					setProfileCreationAssessmentStaffDetailsDto.get("contactNumber"),
					setProfileCreationAssessmentStaffDetailsDto.get("emailId"),
					setProfileCreationAssessmentStaffDetailsDto.get("state"),
					setProfileCreationAssessmentStaffDetailsDto.get("city"),
					setProfileCreationAssessmentStaffDetailsDto.get("educationalQualification"),
					setProfileCreationAssessmentStaffDetailsDto.get("experience"),
					setProfileCreationAssessmentStaffDetailsDto.get("cVPath"),
					setProfileCreationAssessmentStaffDetailsDto.get("certificatePath")
					));
			}
			
			/*
			 * Setting of ProfileCreationAssessmentStaffDetailsDto Ends Here
			 */
			
			
			
			/*
			 * ProfileCreationAssessmentBodyRegionalOfficeDetailsDto Setting Starts
			 */
			
			ArrayList<ProfileCreationAssessmentBodyRegionalOfficeDetailsDto> assessmentBodyRegionalOfficeDetailsList = new ArrayList<ProfileCreationAssessmentBodyRegionalOfficeDetailsDto>();
			
			for(Map.Entry<String, HashMap<String, String>> profileCreationAssessmentBodyRegionalOfficeDetailsIterator : assessmentBodyRegionalOfficeDetails.entrySet())
			{
			HashMap<String, String> setProfileCreationAssessmentBodyRegionalOfficeDetailsDto = new HashMap<String, String>();
			setProfileCreationAssessmentBodyRegionalOfficeDetailsDto=profileCreationAssessmentBodyRegionalOfficeDetailsIterator.getValue();
			assessmentBodyRegionalOfficeDetailsList.add(new ProfileCreationAssessmentBodyRegionalOfficeDetailsDto(
					setProfileCreationAssessmentBodyRegionalOfficeDetailsDto.get("regionalOfficeId"),
					setProfileCreationAssessmentBodyRegionalOfficeDetailsDto.get("assessmentBodyRegistrationId"),
					setProfileCreationAssessmentBodyRegionalOfficeDetailsDto.get("address"),
					setProfileCreationAssessmentBodyRegionalOfficeDetailsDto.get("state"),
					setProfileCreationAssessmentBodyRegionalOfficeDetailsDto.get("pincode"),
					setProfileCreationAssessmentBodyRegionalOfficeDetailsDto.get("contactNumber"),
					setProfileCreationAssessmentBodyRegionalOfficeDetailsDto.get("alternateContactNumber")
					));
			}
			
			/*
			 * Setting of ProfileCreationAssessmentBodyRegionalOfficeDetailsDto Ends Here
			 */
			
			
			/*
			 * ProfileCreationAssessmentBodyAffiliationDetailsDto Setting Starts
			 */
			
			ArrayList<ProfileCreationAssessmentBodyAffiliationDetailsDto> assessmentBodyAffiliationDetailsList = new ArrayList<ProfileCreationAssessmentBodyAffiliationDetailsDto>();
			
			for(Map.Entry<String, HashMap<String, String>> profileCreationAssessmentBodyAffiliationDetailsIterator : assessmentBodyAffiliationDetails.entrySet())
			{
			HashMap<String, String> setProfileCreationAssessmentBodyAffiliationDetailsDto = new HashMap<String, String>();
			setProfileCreationAssessmentBodyAffiliationDetailsDto=profileCreationAssessmentBodyAffiliationDetailsIterator.getValue();
			assessmentBodyAffiliationDetailsList.add(new ProfileCreationAssessmentBodyAffiliationDetailsDto(
					setProfileCreationAssessmentBodyAffiliationDetailsDto.get("affiliationId"),
					setProfileCreationAssessmentBodyAffiliationDetailsDto.get("assessmentBodyRegistrationId"),
					setProfileCreationAssessmentBodyAffiliationDetailsDto.get("nameOfSectorSkillCouncil")

					));
			}
			
			/*
			 * Setting of ProfileCreationAssessmentBodyAffiliationDetailsDto Ends Here
			 */
			
			/*
			 * Creating Folder Structure for saving files 
			 */
			
			if(userRole.equalsIgnoreCase("TP"))
			{
				File createTrainingPartnerFolder = new File(readApplicationConstants.getProfileCreationTrainingPartnerFolder()+"//"+ applicationId);
				File createModelOfInstitutionFolder = new File(createTrainingPartnerFolder.getAbsolutePath()+"//ModelOfInstitution");
				File createInstituteGrantFolder = new File(createTrainingPartnerFolder.getAbsolutePath()+"//InstituteGrant");
				File createDirectorsAndManagementTeamMembersFolder = new File(createTrainingPartnerFolder.getAbsolutePath()+"//DirectorsAndManagementTeamMembers");
				File createTrainingStaffFolder = new File(createTrainingPartnerFolder.getAbsolutePath()+"//TrainingStaff");
				
			}
			else if (userRole.equalsIgnoreCase("AB")) 
			{
				
			}
			else
			{
				/*
				 * Error Throw user Out
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
