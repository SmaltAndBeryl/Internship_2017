package com.skill.India.controller;

import com.skill.India.service.BatchAssignmentWithdrawService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Priyanshu Pandey on 7/12/2017.
 */
@RestController
public class BatchAssignmentWithdrawController {
    @Autowired
    private BatchAssignmentWithdrawService batchAssignmentWithdrawService;

    @RequestMapping(value = "/withdrawAssignment",method=RequestMethod.POST)
    public int batchAssignmentWithdrawUpdate(@RequestParam("batchId") String batchId) {
        return batchAssignmentWithdrawService.putUpdateBatches(batchId);
    }
}
