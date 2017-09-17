package com.skill.India.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.skill.India.dto.ProfileCreationTrainingPartnerCenterDetailsDto;

@Service
public class ProfileCreationTrainingPartnerCenterDetailsService {
	
	
	
	public String setTrainingPartnerCenterDetails(HashMap<String, HashMap<String, String>> trainingPartnerCenterLevelDetails)
	{

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
		
		
		return null;
	}

}
