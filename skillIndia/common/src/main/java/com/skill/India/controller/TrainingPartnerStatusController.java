package com.skill.India.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.common.SessionUserUtility;
import com.skill.India.dto.SessionManagementDto;
import com.skill.India.dto.TrainingPartnerApplicationStatusDto;
import com.skill.India.service.TrainingPartnerApplicationStatusService;
import com.skill.India.service.TrainingPartnerBatchesService;

@RestController
public class TrainingPartnerStatusController {
	@Autowired
	private TrainingPartnerApplicationStatusService trainingPartnerApplicationStatusService;

	@Autowired
	private TrainingPartnerBatchesService trainingPartnerPastTableService;

	@Autowired
	private SessionUserUtility sessionUserUtility;

	// @RequestMapping("/trainingPartnerApplicationStatus")
	// public Collection<TrainingPartnerApplicationStatusDto>
	// gettrainingPartnerApplicationStatusDto (@RequestParam("applicationId")int
	// applicationId) {
	// return
	// trainingPartnerApplicationStatusService.getUpdateRowMapper(applicationId);
	// }

	@RequestMapping("/trainingPartnerApplicationStatus")
	public Collection<TrainingPartnerApplicationStatusDto> gettrainingPartnerApplicationStatusDto() {
		return trainingPartnerApplicationStatusService
				.getUpdateRowMapper(sessionUserUtility
						.getApplicationId(sessionUserUtility
								.getSessionMangementfromSession().getUsername()));
	}
}
