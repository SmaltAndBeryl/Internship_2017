/**
 * 
 */
package com.skill.India.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.dto.TrainingPartnerBatchesDto;
import com.skill.India.service.TrainingPartnerBatchesService;

/**
 * @author Rachit Goyal
 *
 */
@RestController
public class TrainingPartnerController {

	@Autowired
	private TrainingPartnerBatchesService trainingPartnerPastTableService;
	
	@RequestMapping("/trainingPartnerPastBatches")
	public HashMap<String, ArrayList<TrainingPartnerBatchesDto>> getTrainingPartnerPastTableDto (@RequestParam("applicationId")int applicationId) {
		
			return trainingPartnerPastTableService.getUpdateRowMapper(applicationId);
	}
}
