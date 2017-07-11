package com.skill.India.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.dto.LoginDto;
import com.skill.India.dto.LoginReceiveDataDto;
import com.skill.India.dto.ProfileCreationDataPopulateDto;
import com.skill.India.dto.SignUpInsertedUserDto;
import com.skill.India.dto.SignUpReceiveDataDto;
import com.skill.India.service.LoginService;
import com.skill.India.service.ProfileCreationDataPopulateService;
import com.skill.India.service.SignUpService;


@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
    public String userRedirectPage;
    @Autowired
	private SignUpService signUpService;
    
    @Autowired
    private ProfileCreationDataPopulateService profileCreationDataPopulateService;
    
    
	@RequestMapping(value="/loginUrl", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public int getLoginDto(@RequestBody LoginReceiveDataDto loginReceiveDataDto) 
	{	
		
		System.out.println(loginReceiveDataDto.password+loginReceiveDataDto.userId);
		
	 return loginService.checkUser(loginReceiveDataDto);
      
		
	}	
	
	@RequestMapping(value="/signup", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public SignUpInsertedUserDto signUp(@RequestBody SignUpReceiveDataDto signUpReceiveDataDto){
			
	return signUpService.signUp(signUpReceiveDataDto);
	

	}
	
	@RequestMapping(value="/profileCreationDataPopulate", method=RequestMethod.POST)
	public ProfileCreationDataPopulateDto profileCreationDataPopulate(@RequestParam ("userId") String userId){	
	

		return profileCreationDataPopulateService.getDataToPopulate(userId);
		
	}
	
	
	
	
	 

	

}
