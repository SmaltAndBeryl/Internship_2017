package com.skill.India.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.skill.India.dto.ProfileCreationAssessmentBodyRegionalOfficeDetailsDto;

@Service
public class ProfileCreationAssessmentBodyRegionalOfficeDetailsService {

	public String setAssessmentBodyRegionalOfficeDetails(HashMap<String, HashMap<String, String>> assessmentBodyRegionalOfficeDetails)
	{
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
		
		
		return null;
	}
}
