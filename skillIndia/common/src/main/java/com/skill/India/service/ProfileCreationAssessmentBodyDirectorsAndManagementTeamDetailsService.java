package com.skill.India.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.skill.India.dto.ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto;

@Service
public class ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsService {

	public String setAssessmentBodyDirectorsAndManagementTeamDetails(HashMap<String, HashMap<String, String>> assessmentBodyDirectorsAndManagementTeamDetail)
	{

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
		
		return null;
	}
}
