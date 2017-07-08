package com.skill.India.controller;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.dto.ProfileCreationTpDto;

import com.skill.India.service.ProfileCreationTpService;


@RestController
public class ProfileCreationTpController {

	
	@Autowired
	private ProfileCreationTpService profileCreationTpService;
	
	 @RequestMapping(value= "/setprofilecreation",method=RequestMethod.POST, consumes=MediaType.ALL_VALUE)
	 public @ResponseBody String  set(@RequestBody ProfileCreationTpDto profileCreationTpDto)
	 {
		 
		
		 Boolean status= profileCreationTpService.set(profileCreationTpDto);
		 if(status)
			 return "save as draft successfull";
		 else
			 return "error";
		
	 }
}

