package com.skill.India.controller;

import java.util.Collection;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.dto.TrainingPartnerApplicationStatusDto;
import com.skill.India.service.TrainingPartnerApplicationStatusService;

@RestController
public class TrainingPartnerStatusController
{
	@Autowired
	private TrainingPartnerApplicationStatusService trainingPartnerApplicationStatusService;
			
	@RequestMapping("/trainingPartnerApplicationStatus")
	public Collection<TrainingPartnerApplicationStatusDto> gettrainingPartnerApplicationStatusDto () {
	       return trainingPartnerApplicationStatusService.getUpdateRowMapper();
	}

}
