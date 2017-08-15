package com.skill.India.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.dto.ProfileCreationTrainingPartnerDto;
import com.skill.India.service.ProfileCreationTrainingPartnerService;
import com.skill.India.service.SaveAsDraftAndSubmitService;


@RestController
public class ProfileCreationController {

	@Autowired
	private ProfileCreationTrainingPartnerService profileCreationTrainingPartnerService;

	@Autowired
	private SaveAsDraftAndSubmitService saveAsDraftAndSubmitService;

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

	@RequestMapping(value="/getTrainingPartnerData")
	public ProfileCreationTrainingPartnerDto profileCreationTrainingPartnerController()
	{
		LOGGER.info("In ProfileCreationController - profileCreationTrainingPartnerController");
		LOGGER.info("Request Received from front end to get data of Training Partner for Profile Creation");
		LOGGER.info("Sending Request to service");
		return profileCreationTrainingPartnerService.profileCreationTrainingPartner();
	}

	@RequestMapping(value="/saveAsDraftAndSubmit")
	public String saveAsDraftAndSubmitController(@RequestBody ProfileCreationTrainingPartnerDto profileCreationTrainingPartnerDto)
	{
		LOGGER.info("In ProfileCreationController - saveAsDraftAndSubmitController");
		LOGGER.info("Request Received from front end to save and submit data data of Training Partner/Assessment Body for Profile Creation");
		LOGGER.info("Parameters Received from front end are - 'profileCreationTrainingPartnerDto': ",profileCreationTrainingPartnerDto);
		LOGGER.info("Data"+ profileCreationTrainingPartnerDto.getOrganizationName()+profileCreationTrainingPartnerDto.getUserId() + profileCreationTrainingPartnerDto.getType());
		LOGGER.info("Sending Request to service");
		saveAsDraftAndSubmitService.saveAsDraftAndSubmit(profileCreationTrainingPartnerDto,profileCreationTrainingPartnerDto.getType());
		LOGGER.info("Response Received from Service");
		return null;
	}

}

