package com.skill.India.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.skill.India.service.AssessmentBodyHomepageFunctionalitiesService;

@RestController
public class AssessmentBodyHomepageFunctionalitiesController {
	@Autowired
	private AssessmentBodyHomepageFunctionalitiesService assessmentBodyHomepageFunctionalitiesService;
	
	@RequestMapping(value="/showInterest",method=RequestMethod.POST)
	public int assessmentBodyHomepageFunctionalitiesUpdateShowInterest(@RequestParam("batchId") String batchId,@RequestParam("agencyId") String agencyId) {
		return assessmentBodyHomepageFunctionalitiesService.putShowInterest(batchId,agencyId);
	}

	@RequestMapping(value="/approveAssignment",method=RequestMethod.POST)
	public int assessmentBodyHomepageFunctionalitiesApproveBatch(@RequestParam("batchId") String batchId) {
		System.out.println("THIS IS THE BATCH id"+batchId);
		return assessmentBodyHomepageFunctionalitiesService.putApproveBatch(batchId);
	}
	
	@RequestMapping(value="/rejectAssignment",method=RequestMethod.POST)
	public int assessmentBodyHomepageFunctionalitiesRejectBatch(@RequestParam("batchId") String batchId) {
		return assessmentBodyHomepageFunctionalitiesService.putRejectBatch(batchId);
	}

}
