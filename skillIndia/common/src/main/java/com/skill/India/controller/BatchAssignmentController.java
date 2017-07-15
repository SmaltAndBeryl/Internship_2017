package com.skill.India.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.dto.BatchAssignmentDto;
import com.skill.India.service.BatchAssignmentService;



@RestController
public class BatchAssignmentController {
	
	@Autowired
	private BatchAssignmentService batchAssignmentService;
	
	@RequestMapping("/getProposedBatchesBatchAssignment")
	public Collection<BatchAssignmentDto> getproposedBatchesBatchAssignmentRowMapper(){
		return batchAssignmentService.getproposedBatchesBatchAssignmentRowMapper();
	}
	
	@RequestMapping("/getApprovedBatchesBatchAssignment")
	public Collection<BatchAssignmentDto> getapprovedBatchesBatchAssignmentRowMapper(){
		return batchAssignmentService.getapprovedBatchesBatchAssignmentRowMapper();
	}
	
	@RequestMapping("/getRejectedBatchesBatchAssignment")
	public Collection<BatchAssignmentDto> getrejectedBatchesBatchAssignmentRowMapper(){
		return batchAssignmentService.getrejectedBatchesBatchAssignmentRowMapper();
	}
	

}
