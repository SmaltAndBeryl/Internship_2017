package com.skill.India.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.skill.India.dto.ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto;

@Service
public class ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingService {

	public String setTrainingPartnerPriorExperienceInSkillTraining(HashMap<String, HashMap<String, String>> trainingPartnerPriorExperienceInSkillTraining)
	{
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
		
		return null;
	}
}
