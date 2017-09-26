package com.skill.India.controller;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.skill.India.common.SessionUserUtility;
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
	
	@RequestMapping(value="/saveAsDraftAndSubmit" , method = RequestMethod.POST)
	public void saveAsDraftAndSubmitController(@RequestBody String type, @RequestBody HashMap<String, HashMap<String, HashMap<String, String>>> userData,  @RequestBody HashMap<String, HashMap<String, HashMap<String, MultipartFile>>> userUploads,  @RequestBody HashMap<String, HashMap<String, HashMap<String, String>>> userDeletes)
	{
		LOGGER.debug("User type received from front end is"+ type);
		LOGGER.debug("User type received from front end is"+ userData.toString());
		LOGGER.debug("User type received from front end is"+ userUploads.toString());
		LOGGER.debug("User type received from front end is"+ userDeletes.toString());
		String result = profileCreationSaveAsDraftAndSubmitService.profileCreationSaveAsDraftAndSubmit(type,userData, userUploads, userDeletes);
		LOGGER.info("Response Received from Service" + result);
		
	}

	
}

