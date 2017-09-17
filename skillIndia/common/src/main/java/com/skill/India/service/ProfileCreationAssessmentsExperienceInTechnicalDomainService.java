package com.skill.India.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.skill.India.dto.ProfileCreationAssessmentsExperienceInTechnicalDomainDto;

@Service
public class ProfileCreationAssessmentsExperienceInTechnicalDomainService {

	public String setAssessmentsExperienceInTechnicalDomain(HashMap<String, HashMap<String, String>> assessmentsExperienceInTechnicalDomain)
	{
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
		
		
		
		return null;
	}
}
