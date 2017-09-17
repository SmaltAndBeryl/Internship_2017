package com.skill.India.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.skill.India.dto.ProfileCreationAssessmentBodyRecognitionsDto;

@Service
public class ProfileCreationAssessmentBodyRecognitionsService {

	public String setAssessmentBodyRecognitions(HashMap<String, HashMap<String, String>> assessmentBodyRecognitions)
	{
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
		
		
		
		
		return null;
	}
}
