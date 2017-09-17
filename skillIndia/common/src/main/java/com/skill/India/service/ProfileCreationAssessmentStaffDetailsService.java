package com.skill.India.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.skill.India.dto.ProfileCreationAssessmentStaffDetailsDto;

@Service
public class ProfileCreationAssessmentStaffDetailsService {

	public String setAssessmentStaffDetails(HashMap<String, HashMap<String, String>> assessmentStaffDetails)
	{
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
		
		
		
		return null;
	}
}
