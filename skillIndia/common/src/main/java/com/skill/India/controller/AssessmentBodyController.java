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
		LOGGER.info("In AssessmentBodyController - getApplicationId");
		LOGGER.info("Trying to get ApplicationId ");
		LOGGER.info("Sending Request to service");
		return sessionUserUtility.getApplicationId(sessionUserUtility
				.getSessionMangementfromSession().getUsername());
	}
	
	
	@Privilege(value={"AB"})
	@RequestMapping("/assessmentBodyApplicationStatus")
	public Collection<AssessmentBodyApplicationStatusDto> getAssessmentBodyApplicationStatusDto() {
		LOGGER.info("In AssessmentBodyController - getAssessmentBodyApplicationStatusDto");   
		LOGGER.info("Request received from front end to get Assessment Body Application Status");
		LOGGER.info("Sending Request to service");
		return assessmentBodyApplicationStatusService
				.getUpdateRowMapper(getApplicationId());
	}
	
	
	/*
	 * AssessmentBodyHomepageController 
	 */
	
		@Privilege(value={"AB"})
		@RequestMapping("/getPastBatchesAssessmentBodyHomepage")
		public Collection<AssessmentBodyHomepageDto> getpastBatchesAssessmentBodyHomepageRowMapper() {
			LOGGER.info("In AssessmentBodyController - getpastBatchesAssessmentBodyHomepageRowMapper");	
			LOGGER.info("Request Received from front end to get Past Batches For Assessment Body");
			LOGGER.info("Sending Request to service");
			return assessmentBodyHomepageService
					.getpastBatchesAssessmentBodyHomepageRowMapper(getApplicationId());
		}

		@Privilege(value={"AB"})
		@RequestMapping("/getUpcomingBatchesAssessmentBodyHomepage")
		public Collection<AssessmentBodyHomepageDto> getupcomingBatchesAssessmentBodyHomepageRowMapper() {
			LOGGER.info("In AssessmentBodyController - getupcomingBatchesAssessmentBodyHomepageRowMapper");
			LOGGER.info("Request Received from front end to get Upcoming Batches For Assessment Body");
			LOGGER.info("Sending Request to service");
			return assessmentBodyHomepageService
					.getupcomingBatchesAssessmentBodyHomepageRowMapper(getApplicationId());
		}

		@Privilege(value={"AB"})
		@RequestMapping("/getShownInterestBatchesAssessmentBodyHomepage")
		public Collection<AssessmentBodyHomepageDto> getshownInterestAssessmentBodyHomepageRowMapper() {
			LOGGER.info("In AssessmentBodyController - getshownInterestAssessmentBodyHomepageRowMapper");
			LOGGER.info("Request Received from front end to get shown interest Batches For Assessment Body");
			LOGGER.info("Sending Request to service");
			return assessmentBodyHomepageService
					.getshownInterestAssessmentBodyHomepageRowMapper(getApplicationId());
		}

		@Privilege(value={"AB"})
		@RequestMapping("/getAssignedBatchesAssessmentBodyHomepage")
		public Collection<AssessmentBodyHomepageDto> getassigneddBatchesAssessmentBodyHomepageRowMapper() {
			LOGGER.info("In AssessmentBodyController - getassigneddBatchesAssessmentBodyHomepageRowMapper");
			LOGGER.info("Request Received from front end to get Assigned Batches For Assessment Body");
			LOGGER.info("Sending Request to service");
			return assessmentBodyHomepageService
					.getassignedBatchesAssessmentBodyHomepageRowMapper(getApplicationId());
		}

		@Privilege(value={"AB"})
		@RequestMapping("/getConfirmedBatchesAssessmentBodyHomepage")
		public Collection<AssessmentBodyHomepageDto> getconfirmedBatchesAssessmentBodyHomepageRowMapper() {
			LOGGER.info("In AssessmentBodyController - getconfirmedBatchesAssessmentBodyHomepageRowMapper");
			LOGGER.info("Request Received from front end to get Confirmed Batches For Assessment Body");
			LOGGER.info("Sending Request to service");
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
			LOGGER.info("In AssessmentBodyController - assessmentBodyHomepageFunctionalitiesUpdateShowInterest");
			LOGGER.info("Request Received from front end to show Interest For Particular Batch For Assessment Body");
			LOGGER.info("Parameters Received from front end are - 'batchId': "+batchId +" 'agencyId':"+applicationId);
			LOGGER.info("Sending Request to service");
			
			return assessmentBodyHomepageFunctionalitiesService.putShowInterest(batchId,applicationId);
		}

		@Privilege(value={"AB"})
		@RequestMapping(value="/approveAssignment",method=RequestMethod.POST)
		public int assessmentBodyHomepageFunctionalitiesApproveBatch(@RequestParam("batchId") String batchId) {
			int applicationId = getApplicationId();
			LOGGER.info("In AssessmentBodyController - assessmentBodyHomepageFunctionalitiesApproveBatch");
			LOGGER.info("Request Received from front end to Approve the Batch For Assessment Body");
			LOGGER.info("Parameters Received from front end are - 'batchId': "+batchId);
			LOGGER.info("Sending Request to service");
			return assessmentBodyHomepageFunctionalitiesService.putApproveBatch(batchId, applicationId);
		}
		
		@Privilege(value={"AB"})
		@RequestMapping(value="/rejectAssignment",method=RequestMethod.POST)
		public int assessmentBodyHomepageFunctionalitiesRejectBatch(@RequestParam("batchId") String batchId) {
			int applicationId = getApplicationId();
			LOGGER.info("In AssessmentBodyController - assessmentBodyHomepageFunctionalitiesRejectBatch");
			LOGGER.info("Request Received from front end to Reject the Batch For Assessment Body");
			LOGGER.info("Parameters Received from front end are - 'batchId': "+batchId);
			LOGGER.info("Sending Request to service");
			return assessmentBodyHomepageFunctionalitiesService.putRejectBatch(batchId,applicationId);
		}

	
	
}
