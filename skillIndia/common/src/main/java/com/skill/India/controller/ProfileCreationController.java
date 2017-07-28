package com.skill.India.controller;
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
		return profileCreationTrainingPartnerService.profileCreationTrainingPartner();
	}
	
	@RequestMapping(value="/saveAsDraftAndSubmit")
	public String saveAsDraftAndSubmitController(@RequestBody ProfileCreationTrainingPartnerDto profileCreationTrainingPartnerDto)
	{
		System.out.println("In save as Draft controller");
		saveAsDraftAndSubmitService.saveAsDraftAndSubmit(profileCreationTrainingPartnerDto);
		return null;
	}
	
}

