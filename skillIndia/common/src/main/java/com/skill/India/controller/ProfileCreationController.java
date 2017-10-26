package com.skill.India.controller;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.skill.India.common.SessionUserUtility;
import com.skill.India.dto.ProfileCreationABTPDto;
import com.skill.India.dto.ProfileCreationAssessmentBodyWrapperDto;
import com.skill.India.dto.ProfileCreationTrainingPartnerDto;
import com.skill.India.service.ProfileCreationGetDataService;
import com.skill.India.service.ProfileCreationSaveAsDraftAndSubmitService;
import com.skill.India.service.ProfileCreationTrainingPartnerService;
import com.skill.India.service.SaveAsDraftAndSubmitService;


@RestController
public class ProfileCreationController {

	@Autowired
	private ProfileCreationTrainingPartnerService profileCreationTrainingPartnerService;

	@Autowired
	private SaveAsDraftAndSubmitService saveAsDraftAndSubmitService;
	
	@Autowired
	private ProfileCreationGetDataService profileCreationGetDataService;
	
	@Autowired
	private SessionUserUtility sessionUserUtility;

	@Autowired
	private ProfileCreationSaveAsDraftAndSubmitService profileCreationSaveAsDraftAndSubmitService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProfileCreationController.class);
	/*	@Autowired
	private ProfileCreationTpService profileCreationTpService;
*/
/*	 @RequestMapping(value= "/setprofilecreation",method=RequestMethod.POST, consumes=MediaType.ALL_VALUE)
	 public @ResponseBody String  set(@RequestBody ProfileCreationTpDto profileCreationTpDto)
	 {


		 Boolean status= profileCreationTpService.set(profileCreationTpDto);
		 if(status)
			 return "save as draft successfull ";
		 else
			 return "error";

	 }*/

//	@RequestMapping(value="/getTrainingPartnerData")
//	public ProfileCreationTrainingPartnerDto profileCreationTrainingPartnerController()
//	{
//		LOGGER.info("In ProfileCreationController - profileCreationTrainingPartnerController");
//		LOGGER.info("Request Received from front end to get data of Training Partner for Profile Creation");
//		LOGGER.info("Sending Request to service");
//		return profileCreationTrainingPartnerService.profileCreationTrainingPartner();
//	}
	/*
	 * Method to get data for Profile creation of assessment body and training partner
	 * */
	
	@RequestMapping(value="/getDataNewUserProfileCreation")
	public HashMap<String,Object> getData()
	{
		return profileCreationGetDataService.profileCreationGetData(sessionUserUtility
				.getApplicationId(sessionUserUtility
						.getSessionMangementfromSession().getUsername()));
	}
	
	/*
	 * Method to implement save as draft and submit functionalities
	 * */
	
	
	@RequestMapping(value="/saveAsDraftAndSubmit" , method = RequestMethod.POST, consumes =MediaType.ALL_VALUE )
	public void saveAsDraftAndSubmitController(@RequestBody ProfileCreationABTPDto profileCreationABTPDto)
	{
		
		LOGGER.info("User type received from front end is"+ profileCreationABTPDto.getType().toString());
		LOGGER.info("User type received from front end is"+ profileCreationABTPDto.getUserData().toString());
//		LOGGER.info("User type received from front end is"+ profileCreationABTPDto.getUserUploads());
		LOGGER.info("User type received from front end is"+ profileCreationABTPDto.getUserDeletes().toString());
		//LOGGER.info("Name is :" +profileCreationTestDto.getName());
		//String result = profileCreationSaveAsDraftAndSubmitService.profileCreationSaveAsDraftAndSubmit(profileCreationABTPDto.getType(),profileCreationABTPDto.getUserData(), profileCreationABTPDto.getUserUploads(), profileCreationABTPDto.getUserDeletes());
		//LOGGER.info("Response Received from Service" + result);
		
	}
	
	@RequestMapping(value="/saveAsDraftAndSubmitAB", method = RequestMethod.POST)
	public int saveAsDraftABController(@RequestBody ProfileCreationAssessmentBodyWrapperDto profileCreationAssessmentBodyWrapperDto)
	{
		int status = profileCreationSaveAsDraftAndSubmitService.SaveAssessmentBody(profileCreationAssessmentBodyWrapperDto);
		return status;
		
	}

	
}

