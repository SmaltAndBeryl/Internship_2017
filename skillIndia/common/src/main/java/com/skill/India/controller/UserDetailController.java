package com.skill.India.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.service.UserDetailService;

@RestController
public class UserDetailController {
	
	@Autowired
	private UserDetailService userDetailService;
	
	 @RequestMapping("/user")
	  public  UserDetails user(Principal user) {
	    return userDetailService.getUser(user.getName());
	  }

}
