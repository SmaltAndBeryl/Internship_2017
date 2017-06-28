package com.skill.India.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.service.ShowInterestUpcomingBatchesService;
@RestController
public class ShowInterestUpcomingBatchesController {

@Autowired
	private ShowInterestUpcomingBatchesService ShowInterestUpcomingTableService;
	
	@RequestMapping(value = "/ShowInterestupcomingtable", method = RequestMethod.GET, headers = "Accept=application/json")
	public String postShowInterestUpcomingTableDto () {
		int id=5;					//Make this value dynamic
			return ShowInterestUpcomingTableService.putInsertRowMapper(id);
	}
}
