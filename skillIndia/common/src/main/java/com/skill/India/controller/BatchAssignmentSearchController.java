package com.skill.India.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.service.BatchAssignmentSearchService;
import com.skill.India.dto.BatchAssignmentSearchDto;



@RestController
public class BatchAssignmentSearchController{
	
	
	@Autowired
	private BatchAssignmentSearchService batchAssignmentSearchService;
	
	@RequestMapping(value ="/getInformationOfTheBatchId", method=RequestMethod.POST)
	public Collection<BatchAssignmentSearchDto> getInformationOfTheBatchId(@RequestParam("batchId") Integer batchId)
	{
		return batchAssignmentSearchService.getBatchDataForAssignmentService(batchId);

	}
}


