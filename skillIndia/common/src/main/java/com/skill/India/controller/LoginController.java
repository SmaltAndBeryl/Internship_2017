package com.skill.India.controller;

import java.security.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    	LOGGER.info("In LoginController - getLoginDto");
		LOGGER.info("Request Received from front end to Validate User For the login process");
		LOGGER.info("Parameters Received from front end are - 'loginReceiveDataDto': ",loginReceiveDataDto);
		return loginService.checkUser(loginReceiveDataDto);
		
	}	
	
	@RequestMapping(value="/signup", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public SignUpInsertedUserDto signUp(@RequestBody SignUpReceiveDataDto signUpReceiveDataDto){
		LOGGER.info("In LoginController - signUp");
		LOGGER.info("Request Received from front end to Validate User For the SignUp process");
		LOGGER.info("Parameters Received from front end are - 'signUpReceiveDataDto': ",signUpReceiveDataDto);
		return signUpService.signUp(signUpReceiveDataDto);
	  
	}
	
	@RequestMapping("/getSPOCName")
	public String getSPOCName()  {
		LOGGER.info("In LoginController - getSPOCName");
		LOGGER.info("Request Received from front end to get SPOC Name of the Validated User");
		String userId=sessionUserUtility
				.getSessionMangementfromSession().getUsername();
		return getSPOCNameService.getSPOCNameService(userId); 
	}
	
	@RequestMapping("/getApplicationState")
	public ApplicationDto getApplicationState()  {
		LOGGER.info("In LoginController - getApplicationState");
		LOGGER.info("Request Received from front end to get Application state of the Validated User ");
		String userId=sessionUserUtility
				.getSessionMangementfromSession().getUsername();
		return getApplicationStateService.getApplicationStateService(userId) ; 
	}
	
	
	@RequestMapping("/getUserDetails")
	public Principal user(Principal user) {
		LOGGER.info("In LoginController - user");
		LOGGER.info("Parameters Received from front end are - 'user': ",user);
		try{
		System.out.println("hey  : " +user);
		return user;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
