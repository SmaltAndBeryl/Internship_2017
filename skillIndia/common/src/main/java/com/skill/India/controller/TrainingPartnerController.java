/**
 * 
 */
package com.skill.India.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.common.Privilege;
import com.skill.India.common.SessionUserUtility;
import com.skill.India.dto.TrainingPartnerApplicationStatusDto;
import com.skill.India.dto.TrainingPartnerBatchesDto;
import com.skill.India.service.TrainingPartnerApplicationStatusService;
import com.skill.India.service.TrainingPartnerBatchesService;

/**
 * @author Rachit Goyal
 *
 */
@RestController
public class TrainingPartnerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TrainingPartnerController.class);
	
	@Autowired
	private TrainingPartnerBatchesService trainingPartnerPastTableService;
	
	@Autowired
	private SessionUserUtility sessionUserUtility;
	
	@Autowired
	private TrainingPartnerApplicationStatusService trainingPartnerApplicationStatusService;
	
	@Privilege(value={"TP"})
	@RequestMapping("/trainingPartnerPastBatches")
	public HashMap<String, ArrayList<TrainingPartnerBatchesDto>> getTrainingPartnerPastTableDto () {
			LOGGER.debug("In TrainingPartnerController - getTrainingPartnerPastTableDto");
			LOGGER.debug("Request Received from front end to get data for Past Batches For Training Partner");
	    	LOGGER.debug("Sending Request to service");	    	
			return trainingPartnerPastTableService.getUpdateRowMapper(sessionUserUtility
					.getApplicationId(sessionUserUtility
							.getSessionMangementfromSession().getUsername()));
	}
	
	/*
	 * TrainingPartnerStatusController 
	 */
	
	@Privilege(value={"TP"})
	@RequestMapping("/trainingPartnerApplicationStatus")
	public Collection<TrainingPartnerApplicationStatusDto> gettrainingPartnerApplicationStatusDto() {
		LOGGER.debug("In TrainingPartnerController - gettrainingPartnerApplicationStatusDto");
		LOGGER.debug("Request Received from front end to get data for Application status table for Training Partner");
		LOGGER.debug("Sending Request to service");
		return trainingPartnerApplicationStatusService
				.getUpdateRowMapper(sessionUserUtility
						.getApplicationId(sessionUserUtility
								.getSessionMangementfromSession().getUsername()));
	}
	
}
