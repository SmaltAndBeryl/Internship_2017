package com.skill.India.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.common.SessionUserUtility;
import com.skill.India.dto.AssessmentBodyHomepageDto;
import com.skill.India.dto.SessionManagementDto;
import com.skill.India.service.AssessmentBodyHomepageService;

@RestController
public class AssessmentBodyHomepageController {

	@Autowired
	private SessionUserUtility sessionUserUtility;

	@Autowired
	private AssessmentBodyHomepageService assessmentBodyHomepageService;

	// @RequestMapping("/getPastBatchesAssessmentBodyHomepage")
	// public Collection<AssessmentBodyHomepageDto>
	// getpastBatchesAssessmentBodyHomepageRowMapper(@RequestParam("getApplicationId()")int
	// getApplicationId()){
	//
	// //System.out.println("CGCxhsvdcvdhcbdkb kdb............."+getApplicationId());
	// return
	// assessmentBodyHomepageService.getpastBatchesAssessmentBodyHomepageRowMapper(getApplicationId());
	// }

	@RequestMapping("/getPastBatchesAssessmentBodyHomepage")
	public Collection<AssessmentBodyHomepageDto> getpastBatchesAssessmentBodyHomepageRowMapper() {

		// System.out.println("CGCxhsvdcvdhcbdkb kdb............."+getApplicationId());
		return assessmentBodyHomepageService
				.getpastBatchesAssessmentBodyHomepageRowMapper(getApplicationId());
	}

	// @RequestMapping("/getUpcomingBatchesAssessmentBodyHomepage")
	// public Collection<AssessmentBodyHomepageDto>
	// getupcomingBatchesAssessmentBodyHomepageRowMapper(@RequestParam("getApplicationId()")int
	// getApplicationId()){
	// return
	// assessmentBodyHomepageService.getupcomingBatchesAssessmentBodyHomepageRowMapper(getApplicationId());
	// }

	@RequestMapping("/getUpcomingBatchesAssessmentBodyHomepage")
	public Collection<AssessmentBodyHomepageDto> getupcomingBatchesAssessmentBodyHomepageRowMapper() {
		return assessmentBodyHomepageService
				.getupcomingBatchesAssessmentBodyHomepageRowMapper(getApplicationId());
	}

	// @RequestMapping("/getShownInterestBatchesAssessmentBodyHomepage")
	// public Collection<AssessmentBodyHomepageDto>
	// getshownInterestAssessmentBodyHomepageRowMapper(@RequestParam("getApplicationId()")int
	// getApplicationId()){
	// return
	// assessmentBodyHomepageService.getshownInterestAssessmentBodyHomepageRowMapper(getApplicationId());
	// }

	@RequestMapping("/getShownInterestBatchesAssessmentBodyHomepage")
	public Collection<AssessmentBodyHomepageDto> getshownInterestAssessmentBodyHomepageRowMapper() {
		return assessmentBodyHomepageService
				.getshownInterestAssessmentBodyHomepageRowMapper(getApplicationId());
	}

	// @RequestMapping("/getAssignedBatchesAssessmentBodyHomepage")
	// public Collection<AssessmentBodyHomepageDto>
	// getassigneddBatchesAssessmentBodyHomepageRowMapper(@RequestParam("getApplicationId()")int
	// getApplicationId()){
	// return
	// assessmentBodyHomepageService.getassignedBatchesAssessmentBodyHomepageRowMapper(getApplicationId());
	// }

	@RequestMapping("/getAssignedBatchesAssessmentBodyHomepage")
	public Collection<AssessmentBodyHomepageDto> getassigneddBatchesAssessmentBodyHomepageRowMapper() {
		return assessmentBodyHomepageService
				.getassignedBatchesAssessmentBodyHomepageRowMapper(getApplicationId());
	}

	// @RequestMapping("/getConfirmedBatchesAssessmentBodyHomepage")
	// public Collection<AssessmentBodyHomepageDto>
	// getconfirmedBatchesAssessmentBodyHomepageRowMapper(@RequestParam("getApplicationId()")int
	// getApplicationId()){
	// return
	// assessmentBodyHomepageService.getconfirmedBatchesAssessmentBodyHomepageRowMapper(getApplicationId());
	// }

	@RequestMapping("/getConfirmedBatchesAssessmentBodyHomepage")
	public Collection<AssessmentBodyHomepageDto> getconfirmedBatchesAssessmentBodyHomepageRowMapper() {
		return assessmentBodyHomepageService
				.getconfirmedBatchesAssessmentBodyHomepageRowMapper(getApplicationId());
	}

	private int getApplicationId() {
		return sessionUserUtility.getApplicationId(sessionUserUtility
				.getSessionMangementfromSession().getUsername());
	}
}
