package com.skill.India.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.skill.India.dto.ProfileCreationTrainingPartnerInstituteRecognitionDto;

@Service
public class ProfileCreationTrainingPartnerInstituteRecognitionService {

	public String setTrainingPartnerInstituteRecognition(HashMap<String, HashMap<String, String>> trainingPartnerInstituteRecognition)
	{
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
		
		return null;
	}
}
