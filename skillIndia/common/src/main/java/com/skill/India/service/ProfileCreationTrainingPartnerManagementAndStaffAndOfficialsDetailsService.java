package com.skill.India.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.skill.India.dto.ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto;

@Service
public class ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsService {

	public String setTrainingPartnerManagementAndStaffAndOfficialsDetails(HashMap<String, HashMap<String, String>> trainingPartnerManagementAndStaffAndOfficialsDetails)
	{

		/*
		 * ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto Setting Starts
		 */
		
		ArrayList<ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto> trainingPartnerManagementAndStaffAndOfficialsDetailsList = new ArrayList<ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto>();
		
		for(Map.Entry<String, HashMap<String, String>> profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsIterator : trainingPartnerManagementAndStaffAndOfficialsDetails.entrySet())
		{
		HashMap<String, String> setProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto = new HashMap<String, String>();
		setProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto=profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsIterator.getValue();
		trainingPartnerManagementAndStaffAndOfficialsDetailsList.add(new ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto(
				setProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.get("managementAndStaffId"),
				setProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.get("trainingPartnerRegistrationId"),
				setProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.get("trainingPartnerCenterId"),
				setProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.get("type"),
				setProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.get("name"),
				setProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.get("designation"),
				setProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.get("emailId"),
				setProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.get("contactNumber"),
				setProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.get("educationalQualification"),
				setProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.get("regularOrVisiting"),
				setProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.get("experience"),
				setProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.get("cVPath"),
				setProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto.get("certificatePath")					
				));
		}
		
		/*
		 * Setting of ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto Ends
		 */
		
		return null;
	}
}
