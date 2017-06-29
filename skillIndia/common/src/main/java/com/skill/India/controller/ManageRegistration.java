package com.skill.India.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.skill.India.service.ManageRegistrationService;

	

	@RestController
	public class ManageRegistration {

		@Autowired
		private ManageRegistrationService manageRegistrationService;
		
		@RequestMapping("/MR_Approve_Table")
		public String getManageRegistrationDto () {
			int id=1234;
				return manageRegistrationService.putUpdateRowMapper(id);
		}

	}

	