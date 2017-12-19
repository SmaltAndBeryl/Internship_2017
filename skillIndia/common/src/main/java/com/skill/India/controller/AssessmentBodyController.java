package com.skill.India.controller;


import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AssessmentBodyController.class);
	
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
		
		LOGGER.debug("Trying to get ApplicationId ");
		
		return sessionUserUtility.getApplicationId(sessionUserUtility
				.getSessionMangementfromSession().getUsername());
	}
	
	
	@Privilege(value={"AB"})
	@RequestMapping("/assessmentBodyApplicationStatus")
	public Collection<AssessmentBodyApplicationStatusDto> getAssessmentBodyApplicationStatusDto() {
		   
		LOGGER.debug("Request received from front end to get Assessment Body Application Status");
		
		return assessmentBodyApplicationStatusService
				.getUpdateRowMapper(getApplicationId());
	}
	
	
	/*
	 * AssessmentBodyHomepageController 
	 */
	
		@Privilege(value={"AB"})
		@RequestMapping("/getPastBatchesAssessmentBodyHomepage")
		public Collection<AssessmentBodyHomepageDto> getpastBatchesAssessmentBodyHomepageRowMapper() {
				
			LOGGER.debug("Request Received from front end to get Past Batches For Assessment Body");
			
			return assessmentBodyHomepageService
					.getpastBatchesAssessmentBodyHomepageRowMapper(getApplicationId());
		}

		@Privilege(value={"AB"})
		@RequestMapping("/getUpcomingBatchesAssessmentBodyHomepage")
		public Collection<AssessmentBodyHomepageDto> getupcomingBatchesAssessmentBodyHomepageRowMapper() {
			
			LOGGER.debug("Request Received from front end to get Upcoming Batches For Assessment Body");
			
			return assessmentBodyHomepageService
					.getupcomingBatchesAssessmentBodyHomepageRowMapper(getApplicationId());
		}

		@Privilege(value={"AB"})
		@RequestMapping("/getShownInterestBatchesAssessmentBodyHomepage")
		public Collection<AssessmentBodyHomepageDto> getshownInterestAssessmentBodyHomepageRowMapper() {
			
			LOGGER.debug("Request Received from front end to get shown interest Batches For Assessment Body");
			
			return assessmentBodyHomepageService
					.getshownInterestAssessmentBodyHomepageRowMapper(getApplicationId());
		}

		@Privilege(value={"AB"})
		@RequestMapping("/getAssignedBatchesAssessmentBodyHomepage")
		public Collection<AssessmentBodyHomepageDto> getassigneddBatchesAssessmentBodyHomepageRowMapper() {
			
			LOGGER.debug("Request Received from front end to get Assigned Batches For Assessment Body");
			
			return assessmentBodyHomepageService
					.getassignedBatchesAssessmentBodyHomepageRowMapper(getApplicationId());
		}

		@Privilege(value={"AB"})
		@RequestMapping("/getConfirmedBatchesAssessmentBodyHomepage")
		public Collection<AssessmentBodyHomepageDto> getconfirmedBatchesAssessmentBodyHomepageRowMapper() {
			
			LOGGER.debug("Request Received from front end to get Confirmed Batches For Assessment Body");
			
			return assessmentBodyHomepageService
					.getconfirmedBatchesAssessmentBodyHomepageRowMapper(getApplicationId());
		}

		/*
		 * AssessmentBodyHomepageFunctionalititesController 
		 */
	
		
		@Privilege(value={"AB"})
		@RequestMapping(value="/showInterest",method=RequestMethod.POST)
		public int assessmentBodyHomepageFunctionalitiesUpdateShowInterest(@RequestParam("batchId") String batchId) {
			int applicationId = getApplicationId();
			
			LOGGER.debug("Request Received from front end to show Interest For Particular Batch For Assessment Body");
			LOGGER.debug("Parameters Received from front end are - 'batchId': "+batchId +" 'agencyId':"+applicationId);
						
			return assessmentBodyHomepageFunctionalitiesService.putShowInterest(batchId,applicationId);
		}

		@Privilege(value={"AB"})
		@RequestMapping(value="/approveAssignment",method=RequestMethod.POST)
		public int assessmentBodyHomepageFunctionalitiesApproveBatch(@RequestParam("batchId") String batchId) {
			int applicationId = getApplicationId();
			
			LOGGER.debug("Request Received from front end to Approve the Batch For Assessment Body");
			LOGGER.debug("Parameters Received from front end are - 'batchId': "+batchId);
			
			return assessmentBodyHomepageFunctionalitiesService.putApproveBatch(batchId, applicationId);
		}
		
		@Privilege(value={"AB"})
		@RequestMapping(value="/rejectAssignment",method=RequestMethod.POST)
		public int assessmentBodyHomepageFunctionalitiesRejectBatch(@RequestParam("batchId") String batchId) {
			int applicationId = getApplicationId();
			
			LOGGER.debug("Request Received from front end to Reject the Batch For Assessment Body");
			LOGGER.debug("Parameters Received from front end are - 'batchId': "+batchId);
			
			return assessmentBodyHomepageFunctionalitiesService.putRejectBatch(batchId,applicationId);
		}

	
	
}
