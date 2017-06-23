package com.skill.India.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.dto.AssessmentBodyUpcomingBatchDto;
import com.skill.India.service.AssessmentBodyUpcomingBatchService;


@RestController
public class AssessmentBodyController {
	
	@Autowired
	private AssessmentBodyUpcomingBatchService assessmentBodyUpcomingTableService;
	
	@RequestMapping("/AB_upcoming_table")
	public Collection<AssessmentBodyUpcomingBatchDto> getAssessmentBodyUpcomingTableDto () {
			return assessmentBodyUpcomingTableService.getUpdateRowMapper();
	}
	

}
