package com.skill.India.controller;


import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.skill.India.dto.AssessmentBodyBatchesDto;
//import com.skill.India.service.AssessmentBodyBatchesService;
import com.skill.India.dto.AssessmentBodyApplicationStatusDto;
import com.skill.India.service.AssessmentBodyApplicationStatusService;

@RestController
public class AssessmentBodyController {
	
//	@Autowired
//	private AssessmentBodyBatchesService assessmentBodyBatchesService;
	
	@Autowired
	private AssessmentBodyApplicationStatusService assessmentBodyApplicationStatusService;
	
	
//	@RequestMapping("/assessmentBodyBatches")
//	public HashMap<String, ArrayList<AssessmentBodyBatchesDto>> getAssessmentBodyUpcomingTableDto () {
//			return assessmentBodyBatchesService.getUpdateRowMapper();
//	}
//	
			
	@RequestMapping("/assessmentBodyApplicationStatus")
	public Collection<AssessmentBodyApplicationStatusDto> getAssessmentBodyApplicationStatusDto () {
	       return assessmentBodyApplicationStatusService.getUpdateRowMapper();
	}
	
	
	
}
