package com.skill.India.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.dto.AssignedBatchesDto;
import com.skill.India.service.AssignedBatchesService;

@RestController
public class AssignedBatchesController {
	
	
	@Autowired
	private AssignedBatchesService assignedbatchesService;
	
	@RequestMapping("/assignedbatches")
	public Collection<AssignedBatchesDto> getAssignedBatchesDto() 
	{

		 return assignedbatchesService.getUpdateRowMapper();
	}	
}