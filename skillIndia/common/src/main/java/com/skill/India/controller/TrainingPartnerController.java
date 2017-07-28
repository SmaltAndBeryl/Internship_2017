/**
 * 
 */
package com.skill.India.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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

	@Autowired
	private TrainingPartnerBatchesService trainingPartnerPastTableService;
	
	@Autowired
	private SessionUserUtility sessionUserUtility;
	
	@Autowired
	private TrainingPartnerApplicationStatusService trainingPartnerApplicationStatusService;
	
	
//	@RequestMapping("/trainingPartnerPastBatches")
//	public HashMap<String, ArrayList<TrainingPartnerBatchesDto>> getTrainingPartnerPastTableDto (@RequestParam("applicationId")int applicationId) {
//		
//			return trainingPartnerPastTableService.getUpdateRowMapper(applicationId);
//	}

	@Privilege(value={"TP"})
	@RequestMapping("/trainingPartnerPastBatches")
	public HashMap<String, ArrayList<TrainingPartnerBatchesDto>> getTrainingPartnerPastTableDto () {
		
			return trainingPartnerPastTableService.getUpdateRowMapper(sessionUserUtility
					.getApplicationId(sessionUserUtility
							.getSessionMangementfromSession().getUsername()));
	}
	
	
	/*
	 * TrainingPartnerStatusController 
	 */
	
	// @RequestMapping("/trainingPartnerApplicationStatus")
		// public Collection<TrainingPartnerApplicationStatusDto>
		// gettrainingPartnerApplicationStatusDto (@RequestParam("applicationId")int
		// applicationId) {
		// return
		// trainingPartnerApplicationStatusService.getUpdateRowMapper(applicationId);
		// }
	@Privilege(value={"TP"})
	@RequestMapping("/trainingPartnerApplicationStatus")
	public Collection<TrainingPartnerApplicationStatusDto> gettrainingPartnerApplicationStatusDto() {
		return trainingPartnerApplicationStatusService
				.getUpdateRowMapper(sessionUserUtility
						.getApplicationId(sessionUserUtility
								.getSessionMangementfromSession().getUsername()));
	}
	
}
