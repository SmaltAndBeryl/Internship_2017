package com.skill.India.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.common.SessionUserUtility;
import com.skill.India.dto.ApplicationDto;
import com.skill.India.dto.LoginDto;
import com.skill.India.dto.LoginReceiveDataDto;
import com.skill.India.dto.SignUpInsertedUserDto;
import com.skill.India.dto.SignUpReceiveDataDto;
import com.skill.India.service.GetApplicationStateService;
import com.skill.India.service.GetSPOCNameService;
import com.skill.India.service.LoginService;
import com.skill.India.service.SignUpService;


@RestController
public class LoginController {
	
	  private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;
    public String userRedirectPage;
    
    @Autowired
	private SignUpService signUpService;    
  
    
    @Autowired
    private GetSPOCNameService getSPOCNameService; 
    
    @Autowired
    private SessionUserUtility sessionUserUtility;
    
    @Autowired
    private GetApplicationStateService getApplicationStateService; 
    
    @RequestMapping(value="/loginUrl", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public LoginDto getLoginDto(@RequestBody LoginReceiveDataDto loginReceiveDataDto) 
	{	
    	LOGGER.debug("In LoginController - getLoginDto");
		LOGGER.debug("Request Received from front end to Validate User For the login process");
		LOGGER.debug("Parameters Received from front end are - 'loginReceiveDataDto': "+ loginReceiveDataDto);
		LOGGER.debug("Sending Request to service");
		return loginService.checkUser(loginReceiveDataDto);
		
	}	
	
	@RequestMapping(value="/signup", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody int signUp(@RequestBody SignUpReceiveDataDto signUpReceiveDataDto)
	{
		int status =0;
		LOGGER.debug("Sending Request to service");
		status = signUpService.signUp(signUpReceiveDataDto);
		LOGGER.debug("Status is " + status);
		return status;
	  
	}
	
	@RequestMapping("/getSPOCName")
	public String getSPOCName() 
	{
		LOGGER.debug("In LoginController - getSPOCName");
		LOGGER.debug("Request Received from front end to get SPOC Name of the Validated User");
		String userId=sessionUserUtility
				.getSessionMangementfromSession().getUsername();
		LOGGER.debug("Sending Request to service");
		return getSPOCNameService.getSPOCNameService(userId); 
	}
	
	@RequestMapping("/getApplicationState")
	public ApplicationDto getApplicationState()  {
		LOGGER.debug("In LoginController - getApplicationState");
		LOGGER.debug("Request Received from front end to get Application state of the Validated User ");
		String userId=sessionUserUtility
				.getSessionMangementfromSession().getUsername();
		LOGGER.debug("Sending Request to service");
		return getApplicationStateService.getApplicationStateService(userId) ; 
	}
	
	
	@RequestMapping("/getUserDetails")
	public Principal user(Principal user) {
		LOGGER.debug("In LoginController - user");
		LOGGER.debug("Parameters Received from front end are - 'user': "+user);
		try{
		//System.out.println("hey  : " +user);
		return user;
		}
		catch(Exception e)
		{
			LOGGER.error("An exception occured while finding user details " + e );
			//e.printStackTrace();
			return null;
		}
	}
}
