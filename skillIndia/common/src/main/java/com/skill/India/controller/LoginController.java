package com.skill.India.controller;




import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.dto.LoginDto;
import com.skill.India.dto.LoginReceiveDataDto;
import com.skill.India.service.LoginService;


@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	
	@RequestMapping(value="/loginUrl", method=RequestMethod.POST)
	public Collection<LoginDto> getLoginDto(@RequestBody LoginReceiveDataDto loginReceiveDataDto) 
	{	
       return loginService.checkUser(loginReceiveDataDto);
		
	}	
	 

	

}
