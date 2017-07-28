package com.skill.India.controller;

import java.util.Collection;

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
		return batchAssignmentService.getproposedBatchesBatchAssignmentRowMapper();
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping("/getApprovedBatchesBatchAssignment")
	public Collection<BatchAssignmentDto> getapprovedBatchesBatchAssignmentRowMapper(){
		return batchAssignmentService.getapprovedBatchesBatchAssignmentRowMapper();
	}
	
	@Privilege(value={"SCGJ"})
	@RequestMapping("/getRejectedBatchesBatchAssignment")
	public Collection<BatchAssignmentDto> getrejectedBatchesBatchAssignmentRowMapper(){
		return batchAssignmentService.getrejectedBatchesBatchAssignmentRowMapper();
	}
	
	/*
	 * BatchAssignmentSearchController
	 */
	
	@Privilege(value={"SCGJ"})
	@RequestMapping(value ="/getInformationOfTheBatchId", method=RequestMethod.POST)
	public Collection<BatchAssignmentSearchDto> getInformationOfTheBatchId(@RequestParam("batchId") Integer batchId)
	{
		return batchAssignmentSearchService.getBatchDataForAssignmentService(batchId);

	}
	
	
	/*
	 * BatchAssignmentWithdrawController
	 */
	
	@Privilege(value={"SCGJ"})
    @RequestMapping(value = "/withdrawAssignment",method=RequestMethod.POST)
    public int batchAssignmentWithdrawUpdate(@RequestParam("batchId") String batchId) {
        return batchAssignmentWithdrawService.putUpdateBatches(batchId);
    }
	
	/*
	 * AlgorithmController
	 */
	
	@Privilege(value={"SCGJ"})
    @RequestMapping(method = RequestMethod.POST, value = "/getBatchId")
    public Collection<AlgorithmDto> getAlgorithmDto(@RequestParam("batchId") String batchId){
        return algorithmService.getBatchIdCollection(batchId);
    }

    @Privilege(value={"SCGJ"})
    @RequestMapping(method = RequestMethod.POST, value = "/getAgencyId")
    public Collection<Algorithm2Dto> getAlgorithm2Dto(@RequestParam("batchId") int batchId){
        return algorithmService.getAgencyIdCollection(batchId);
    }

    @Privilege(value={"SCGJ"})
    @RequestMapping("/getAssessorState")
    public Collection<Algorithm3Dto> getAlgorithm3Dto(){
        return algorithmService.getAssessorIdCollecion();
    }

    @Privilege(value={"SCGJ"})
    @RequestMapping(value = "/getAgencyName", method = RequestMethod.GET, produces = "application/JSON")
    public String getSelectedAgency(){
        return algorithmService.printStates();
    }
    
    /*
     * DropDownController
     */
    
    @Privilege(value={"SCGJ"})
    @RequestMapping("/dropdown")
    public Collection<DropdownDto> getDropdownDto(){
        return dropdownService.getCollection();
    }
    
    /*
     * AssignedBatchesController
     */
    
    @Privilege(value={"SCGJ"})
	@RequestMapping("/assignedbatches")
	public Collection<AssignedBatchesDto> getAssignedBatchesDto() 
	{
		 return assignedbatchesService.getUpdateRowMapper();
	}	

}
