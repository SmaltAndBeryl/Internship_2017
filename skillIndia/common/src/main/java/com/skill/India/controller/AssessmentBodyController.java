package com.skill.India.controller;


import java.util.Collection;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.common.SessionUserUtility;
import com.skill.India.dto.AssessmentBodyApplicationStatusDto;
import com.skill.India.dto.SessionManagementDto;
import com.skill.India.service.AssessmentBodyApplicationStatusService;

@RestController
public class AssessmentBodyController {
	
	@Autowired
	private AssessmentBodyApplicationStatusService assessmentBodyApplicationStatusService;
	
	@Autowired
	private SessionUserUtility sessionUserUtility;
	
//	@RequestMapping("/assessmentBodyApplicationStatus")
//	public Collection<AssessmentBodyApplicationStatusDto> getAssessmentBodyApplicationStatusDto (@RequestParam("applicationId")int applicationId) {
//	       
//		return assessmentBodyApplicationStatusService.getUpdateRowMapper(applicationId);
//	}
	
	@RequestMapping("/assessmentBodyApplicationStatus")
	public Collection<AssessmentBodyApplicationStatusDto> getAssessmentBodyApplicationStatusDto() {
	       
		return assessmentBodyApplicationStatusService
				.getUpdateRowMapper(sessionUserUtility
						.getApplicationId(sessionUserUtility
								.getSessionMangementfromSession().getUsername()));
	}
	
}
