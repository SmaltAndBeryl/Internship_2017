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
import com.skill.India.dto.Algorithm2Dto;
import com.skill.India.dto.Algorithm3Dto;
import com.skill.India.dto.AlgorithmDto;
import com.skill.India.dto.AssignedBatchesDto;
import com.skill.India.dto.BatchAssignmentDto;
import com.skill.India.dto.BatchAssignmentSearchDto;
import com.skill.India.dto.DropdownDto;
import com.skill.India.service.AlgorithmService;
import com.skill.India.service.AssignedBatchesService;
import com.skill.India.service.BatchAssignmentSearchService;
import com.skill.India.service.BatchAssignmentService;
import com.skill.India.service.BatchAssignmentWithdrawService;
import com.skill.India.service.DropdownService;

@RestController
public class BatchAssignmentController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BatchAssignmentController.class);
	
	@Autowired
	private BatchAssignmentService batchAssignmentService;
	
	@Autowired
	private BatchAssignmentSearchService batchAssignmentSearchService;
	
	@Autowired
	private BatchAssignmentWithdrawService batchAssignmentWithdrawService;
    
	@Autowired
    private AlgorithmService algorithmService;
	
    @Autowired
    private DropdownService dropdownService;
    
    @Autowired
	private AssignedBatchesService assignedbatchesService;
	
	@Privilege(value={"SCGJ"})
	@RequestMapping("/getProposedBatchesBatchAssignment")
	public Collection<BatchAssignmentDto> getproposedBatchesBatchAssignmentRowMapper(){
		LOGGER.info("In BatchAssignmentController - getproposedBatchesBatchAssignmentRowMapper");
		LOGGER.info("Request Received from backend to get data for Proposed Batches Table");
		return batchAssignmentService.getproposedBatchesBatchAssignmentRowMapper();
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping("/getApprovedBatchesBatchAssignment")
	public Collection<BatchAssignmentDto> getapprovedBatchesBatchAssignmentRowMapper(){
		LOGGER.info("In BatchAssignmentController - getapprovedBatchesBatchAssignmentRowMapper");
		LOGGER.info("Request Received from backend to get data for Approved Batches table");
		return batchAssignmentService.getapprovedBatchesBatchAssignmentRowMapper();
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping("/getRejectedBatchesBatchAssignment")
	public Collection<BatchAssignmentDto> getrejectedBatchesBatchAssignmentRowMapper(){
		LOGGER.info("In BatchAssignmentController - getrejectedBatchesBatchAssignmentRowMapper");
		LOGGER.info("Request Received from backend to get data for Rejected Batches table");
		return batchAssignmentService.getrejectedBatchesBatchAssignmentRowMapper();
	}
	
	/*
	 * BatchAssignmentSearchController
	 */
	
	@Privilege(value={"SCGJ"})
	@RequestMapping(value ="/getInformationOfTheBatchId", method=RequestMethod.POST)
	public Collection<BatchAssignmentSearchDto> getInformationOfTheBatchId(@RequestParam("batchId") Integer batchId)
	{
		LOGGER.info("In BatchAssignmentController - getInformationOfTheBatchId");
		LOGGER.info("Request Received from backend to get Information for a particular Batch");
		LOGGER.info("Parameters Received from backend are - 'batchId': ",batchId);
		return batchAssignmentSearchService.getBatchDataForAssignmentService(batchId);

	}
	
	
	/*
	 * BatchAssignmentWithdrawController
	 */
	
	@Privilege(value={"SCGJ"})
    @RequestMapping(value = "/withdrawAssignment",method=RequestMethod.POST)
    public int batchAssignmentWithdrawUpdate(@RequestParam("batchId") String batchId) {
		LOGGER.info("In BatchAssignmentController - batchAssignmentWithdrawUpdate");
		LOGGER.info("Request Received from backend to Withdraw a particular Batch");
		LOGGER.info("Parameters Received from backend are - 'batchId': ",batchId);
		return batchAssignmentWithdrawService.putUpdateBatches(batchId);
    }
	
	/*
	 * AlgorithmController
	 */
	
	@Privilege(value={"SCGJ"})
    @RequestMapping(method = RequestMethod.POST, value = "/getBatchId")
    public Collection<AlgorithmDto> getAlgorithmDto(@RequestParam("batchId") String batchId){
		LOGGER.info("In BatchAssignmentController - getAlgorithmDto");
		LOGGER.info("Request Received from backend to get Proposed Assessment Body for a particular Batch - Part-1");
		LOGGER.info("Parameters Received from backend are - 'batchId': ",batchId);
		return algorithmService.getBatchIdCollection(batchId);
    }

    @Privilege(value={"SCGJ"})
    @RequestMapping(method = RequestMethod.POST, value = "/getAgencyId")
    public Collection<Algorithm2Dto> getAlgorithm2Dto(@RequestParam("batchId") int batchId){
    	LOGGER.info("In BatchAssignmentController - getAlgorithm2Dto");
    	LOGGER.info("Request Received from backend to get Proposed Assessment Body for a particular Batch - Part-2");
		LOGGER.info("Parameters Received from backend are - 'batchId': ",batchId);
    	return algorithmService.getAgencyIdCollection(batchId);
    }

    @Privilege(value={"SCGJ"})
    @RequestMapping("/getAssessorState")
    public Collection<Algorithm3Dto> getAlgorithm3Dto(){
    	LOGGER.info("In BatchAssignmentController - getAlgorithm3Dto");
    	LOGGER.info("Request Received from backend to get Proposed Assessment Body for a particular Batch - Part-3");
    	return algorithmService.getAssessorIdCollecion();
    }

    @Privilege(value={"SCGJ"})
    @RequestMapping(value = "/getAgencyName", method = RequestMethod.GET, produces = "application/JSON")
    public String getSelectedAgency(){
    	LOGGER.info("In BatchAssignmentController - getSelectedAgency");
    	LOGGER.info("Request Received from backend to get Proposed Agency Name for a particular Batch - Part-4");
        return algorithmService.printStates();
    }
    
    /*
     * DropDownController
     */
    
    @Privilege(value={"SCGJ"})
    @RequestMapping("/dropdown")
    public Collection<DropdownDto> getDropdownDto(){
    	LOGGER.info("In BatchAssignmentController - getDropdownDto");
    	LOGGER.info("Request Received from backend to get drop down options for All Assessment Body");
		return dropdownService.getCollection();
    }
    
    /*
     * AssignedBatchesController
     */
    
    @Privilege(value={"SCGJ"})
	@RequestMapping("/assignedbatches")
	public Collection<AssignedBatchesDto> getAssignedBatchesDto() 
	{
    	LOGGER.info("In BatchAssignmentController - getAssignedBatchesDto");
    	LOGGER.info("Request Received from backend to get Assigned Batches ");
		 return assignedbatchesService.getUpdateRowMapper();
	}	

}
