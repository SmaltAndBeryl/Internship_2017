package com.skill.India.controller;

import com.skill.India.common.Privilege;
import com.skill.India.dto.NonAssignedBatchesDto;
import com.skill.India.service.NonAssignedBatchesService;
import com.skill.India.service.NonAssignedBatchesUpdateService;
import com.skill.India.service.NonAssignedUpdateAgencyService;

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

    @Autowired
    private NonAssignedBatchesService nonAssignedBatchesService;

    @Autowired
    private NonAssignedBatchesUpdateService nonAssignedBatchesUpdateService;
    
    @Autowired
    private NonAssignedUpdateAgencyService nonAssignedUpdateAgencyService;
    
    @Privilege(value={"SCGJ"})
    @RequestMapping("/non")
    public Collection<NonAssignedBatchesDto> getNonAssignedBatchesDto(){

        return nonAssignedBatchesService.getCollection();
    }
    
    /*
     * NonAssignedBatchesUpdateController
     */
    
    @Privilege(value={"SCGJ"})
    @RequestMapping(method = RequestMethod.POST, value = "/nonUpdate")
    public int nonAssignedBatchesUpdate(@RequestParam("batchId") String batchId) {
        return nonAssignedBatchesUpdateService.putUpdateBatches(batchId);
    }
    
    
    /*
     * NonAssignedUpdateAgencyController
     */
    
    @Privilege(value={"SCGJ"})
    @RequestMapping(method = RequestMethod.POST, value = "/agencyUpdate")
    public int agencyUpdate(@RequestParam("agencyId") String agencyId, @RequestParam String batchId){
        return nonAssignedUpdateAgencyService.putAgencyId(agencyId, batchId);
    }
    
}
