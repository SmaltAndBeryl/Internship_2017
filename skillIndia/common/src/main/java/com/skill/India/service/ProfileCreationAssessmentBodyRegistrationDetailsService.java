package com.skill.India.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.skill.India.dto.ProfileCreationAssessmentBodyRegistrationDetailsDto;

@Service
public class ProfileCreationAssessmentBodyRegistrationDetailsService {

	public String setAssessmentBodyRegistrationDetails(HashMap<String, HashMap<String, String>> assessmentBodyRegistrationDetails)
	{

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

		
		
		return null;
	}
}
