package com.skill.India.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.common.AbstractDatasource;
import com.skill.India.dao.LoginDao;
import com.skill.India.dto.LoginDto;
import com.skill.India.service.DashboardService;
import com.skill.India.service.LoginService;

@RestController
public class LoginController {
	
	
	//private LoginDao logindao;
	@Autowired
		private LoginService loginService;
	
	@RequestMapping("/loginurl")
	public Collection<LoginDto> getLoginDto(@RequestBody String userName, String passWord) 
	{
//		String userName="bhaskar@gmail.com";
//		String passWord="123abc";
		
//		 return logindao.getLoginRowMapper();
		 return loginService.getusername(userName,passWord);
	}	
	 

	

}
