package com.skill.India.controller;

import com.skill.India.service.NonAssignedBatchesService;
import com.skill.India.service.NonAssignedBatchesUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Alkesh srivastav on 7/12/2017.
 */
@RestController
public class NonAssignedBatchesUpdateController {
    @Autowired
    private NonAssignedBatchesUpdateService nonAssignedBatchesUpdateService;

    @RequestMapping("/nonUpdate")
    public int nonAssignedBatchesUpdate() {
        return nonAssignedBatchesUpdateService.putUpdateBatches();
    }
}
