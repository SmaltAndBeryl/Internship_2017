package com.skill.India.controller;

import com.skill.India.common.Privilege;
import com.skill.India.dto.NonAssignedBatchesDto;
import com.skill.India.service.NonAssignedBatchesService;
import com.skill.India.service.NonAssignedBatchesUpdateService;
import com.skill.India.service.NonAssignedUpdateAgencyService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by Alkesh on 7/12/2017.
 */
@RestController
public class NonAssignedBatchesController {

	private static final Logger LOGGER = LoggerFactory.getLogger(NonAssignedBatchesController.class);
	
    @Autowired
    private NonAssignedBatchesService nonAssignedBatchesService;

    @Autowired
    private NonAssignedBatchesUpdateService nonAssignedBatchesUpdateService;
    
    @Autowired
    private NonAssignedUpdateAgencyService nonAssignedUpdateAgencyService;
    
    @Privilege(value={"SCGJ"})
    @RequestMapping("/non")
    public Collection<NonAssignedBatchesDto> getNonAssignedBatchesDto(){
    	LOGGER.info("In NonAssignedBatchesController - getNonAssignedBatchesDto");
    	LOGGER.info("Request Received from front end to get data for all non assigned Batches For Batch assignment");
		return nonAssignedBatchesService.getCollection();
    }
    
    /*
     * NonAssignedBatchesUpdateController
     */
    
    @Privilege(value={"SCGJ"})
    @RequestMapping(method = RequestMethod.POST, value = "/nonUpdate")
    public int nonAssignedBatchesUpdate(@RequestParam("batchId") String batchId, @RequestParam("agencyId") String agencyId,  @RequestParam("responseType") String responseType) {
    	LOGGER.info("In NonAssignedBatchesController - nonAssignedBatchesUpdate");
    	LOGGER.info("Request Received from front end to set proposed agency for corresponding Batch Id For Batch assignment");
    	LOGGER.info("Parameters Received from front end are - 'batchId': "+batchId+" 'agencyId':"+agencyId+" 'responseType':",responseType);
    	return nonAssignedBatchesUpdateService.putUpdateBatches(batchId, agencyId,responseType);
    }
    
    
    /*
     * NonAssignedUpdateAgencyController
     */
    
    @Privilege(value={"SCGJ"})
    @RequestMapping(method = RequestMethod.POST, value = "/agencyUpdate")
    public int agencyUpdate(@RequestParam("agencyId") String agencyId, @RequestParam String batchId,@RequestParam("responseType") String responseType){
    	LOGGER.info("In NonAssignedBatchesController - agencyUpdate");
    	LOGGER.info("Request Received from front end to set agency for corresponding Batch For Batch assignment");
    	LOGGER.info("Parameters Received from front end are - 'batchId': "+batchId+" 'agencyId':"+agencyId+" 'responseType':",responseType);
    	
    	return nonAssignedUpdateAgencyService.putAgencyId(agencyId, batchId, responseType);
    }
    
}
