package com.skill.India.controller;

import com.skill.India.service.NonAssignedBatchesService;
import com.skill.India.service.NonAssignedBatchesUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Alkesh srivastav on 7/12/2017.
 */
@RestController
public class NonAssignedBatchesUpdateController {
    @Autowired
    private NonAssignedBatchesUpdateService nonAssignedBatchesUpdateService;

    @RequestMapping(method = RequestMethod.POST, value = "/nonUpdate")
    public int nonAssignedBatchesUpdate(@RequestParam("batchId") String batchId) {
        return nonAssignedBatchesUpdateService.putUpdateBatches(batchId);
    }
}
