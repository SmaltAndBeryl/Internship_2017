package com.skill.India.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.skill.India.dto.ProfileCreationAssessmentBodyAffiliationDetailsDto;

@Service
public class ProfileCreationAssessmentBodyAffiliationDetailsService {

	public String setAssessmentBodyAffiliationDetails(HashMap<String, HashMap<String, String>> assessmentBodyAffiliationDetails)
	{
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
		
		return null;
	}
}
