package com.skill.India.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.dto.LoginReceiveDataDto;
import com.skill.India.dto.SignUpInsertedUserDto;
import com.skill.India.dto.SignUpReceiveDataDto;
import com.skill.India.service.LoginService;
import com.skill.India.service.SignUpService;


@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
    public String userRedirectPage;
    @Autowired
	private SignUpService signUpService;
    
    
	@RequestMapping(value="/loginUrl", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public String getLoginDto(@RequestBody LoginReceiveDataDto loginReceiveDataDto) 
	{	
      int loginServiceResponse=loginService.checkUser(loginReceiveDataDto);
      if(loginServiceResponse==0)
      {
    	  userRedirectPage= "login";
      }
      else if(loginServiceResponse==1)
      {
    	  userRedirectPage= "ProfileCreationTrainingPartner";
      }
      else if(loginServiceResponse==2)
      {
    	  userRedirectPage="ProfileCreationTrainingPartner";
      }
      else if(loginServiceResponse==3)
      {
    	  userRedirectPage= "HomepageTrainingPartner";
      }
      else if(loginServiceResponse==4)
      {
    	  userRedirectPage= "HomepageTrainingPartner";
      }
      else if(loginServiceResponse==5)
      {
    	  userRedirectPage= "pieHighchart";
      }
		return userRedirectPage;
		
		
		
	}	
	
	@PostMapping(value="/signup", consumes=MediaType.APPLICATION_JSON_VALUE)
	public SignUpInsertedUserDto signUp(@RequestBody SignUpReceiveDataDto signUpReceiveDataDto){
			
	return signUpService.signUp(signUpReceiveDataDto);
	

	}
	 

	

}
