package com.skill.India.controller;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.common.Privilege;
import com.skill.India.common.SessionUserUtility;
import com.skill.India.dto.AssessmentBodyApplicationStatusDto;
import com.skill.India.dto.AssessmentBodyHomepageDto;
import com.skill.India.service.AssessmentBodyApplicationStatusService;
import com.skill.India.service.AssessmentBodyHomepageFunctionalitiesService;
import com.skill.India.service.AssessmentBodyHomepageService;

@RestController
public class AssessmentBodyController {
	
	@Autowired
	private AssessmentBodyApplicationStatusService assessmentBodyApplicationStatusService;

	@Autowired
	private AssessmentBodyHomepageService assessmentBodyHomepageService;
	
	@Autowired
	private AssessmentBodyHomepageFunctionalitiesService assessmentBodyHomepageFunctionalitiesService;

	@Autowired
	private SessionUserUtility sessionUserUtility;
	
	/*
	 * Getting ApplicationId from Session
	 */
	
	private int getApplicationId() {
		return sessionUserUtility.getApplicationId(sessionUserUtility
				.getSessionMangementfromSession().getUsername());
	}
	
	@Privilege(value={"AB"})
	@RequestMapping("/assessmentBodyApplicationStatus")
	public Collection<AssessmentBodyApplicationStatusDto> getAssessmentBodyApplicationStatusDto() {
	       
		return assessmentBodyApplicationStatusService
				.getUpdateRowMapper(getApplicationId());
	}
	
	
	/*
	 * AssessmentBodyHomepageController 
	 */
	
		@Privilege(value={"AB"})
		@RequestMapping("/getPastBatchesAssessmentBodyHomepage")
		public Collection<AssessmentBodyHomepageDto> getpastBatchesAssessmentBodyHomepageRowMapper() {
			return assessmentBodyHomepageService
					.getpastBatchesAssessmentBodyHomepageRowMapper(getApplicationId());
		}

		@Privilege(value={"AB"})
		@RequestMapping("/getUpcomingBatchesAssessmentBodyHomepage")
		public Collection<AssessmentBodyHomepageDto> getupcomingBatchesAssessmentBodyHomepageRowMapper() {
			return assessmentBodyHomepageService
					.getupcomingBatchesAssessmentBodyHomepageRowMapper(getApplicationId());
		}

		@Privilege(value={"AB"})
		@RequestMapping("/getShownInterestBatchesAssessmentBodyHomepage")
		public Collection<AssessmentBodyHomepageDto> getshownInterestAssessmentBodyHomepageRowMapper() {
			return assessmentBodyHomepageService
					.getshownInterestAssessmentBodyHomepageRowMapper(getApplicationId());
		}

		@Privilege(value={"AB"})
		@RequestMapping("/getAssignedBatchesAssessmentBodyHomepage")
		public Collection<AssessmentBodyHomepageDto> getassigneddBatchesAssessmentBodyHomepageRowMapper() {
			return assessmentBodyHomepageService
					.getassignedBatchesAssessmentBodyHomepageRowMapper(getApplicationId());
		}

		@Privilege(value={"AB"})
		@RequestMapping("/getConfirmedBatchesAssessmentBodyHomepage")
		public Collection<AssessmentBodyHomepageDto> getconfirmedBatchesAssessmentBodyHomepageRowMapper() {
			return assessmentBodyHomepageService
					.getconfirmedBatchesAssessmentBodyHomepageRowMapper(getApplicationId());
		}

		/*
		 * AssessmentBodyHomepageFunctionalititesController 
		 */
	
		
		@Privilege(value={"AB"})
		@RequestMapping(value="/showInterest",method=RequestMethod.POST)
		public int assessmentBodyHomepageFunctionalitiesUpdateShowInterest(@RequestParam("batchId") String batchId,@RequestParam("agencyId") String agencyId) {
			return assessmentBodyHomepageFunctionalitiesService.putShowInterest(batchId,agencyId);
		}

		@Privilege(value={"AB"})
		@RequestMapping(value="/approveAssignment",method=RequestMethod.POST)
		public int assessmentBodyHomepageFunctionalitiesApproveBatch(@RequestParam("batchId") String batchId) {
			return assessmentBodyHomepageFunctionalitiesService.putApproveBatch(batchId);
		}
		
		@Privilege(value={"AB"})
		@RequestMapping(value="/rejectAssignment",method=RequestMethod.POST)
		public int assessmentBodyHomepageFunctionalitiesRejectBatch(@RequestParam("batchId") String batchId) {
			return assessmentBodyHomepageFunctionalitiesService.putRejectBatch(batchId);
		}

	
	
}
