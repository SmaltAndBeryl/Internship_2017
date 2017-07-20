package com.skill.India.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.service.UserIdtoApplicationIdService;

@RestController
public class UserIdtoApplicationIdController {
	
	@Autowired
	private UserIdtoApplicationIdService userIdtoApplicationIdService;

	 private static final Logger LOGGER = LoggerFactory.getLogger(UserIdtoApplicationIdController.class);
	 
	 @RequestMapping(value="/userIdtoApplicationId", method=RequestMethod.POST)
	 public int getApplicationId(@RequestParam("userId") String userId ) 
		{	
	    	LOGGER.info("Get the application id corresponding to the user id");
			return userIdtoApplicationIdService.getApplicationId(userId);		
		}	
		
}
