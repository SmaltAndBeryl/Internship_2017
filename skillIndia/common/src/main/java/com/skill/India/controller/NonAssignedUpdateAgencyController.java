package com.skill.India.controller;

import com.skill.India.dao.NonAssignedUpdateAgencyDao;
import com.skill.India.service.NonAssignedUpdateAgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Alkesh srivastav on 7/17/2017.
 */
@RestController
public class NonAssignedUpdateAgencyController {
    @Autowired
    private NonAssignedUpdateAgencyService nonAssignedUpdateAgencyService;

    @RequestMapping(method = RequestMethod.POST, value = "/agencyUpdate")
    public int agencyUpdate(@RequestParam("agencyId") String agencyId, @RequestParam String batchId){
        return nonAssignedUpdateAgencyService.putAgencyId(agencyId, batchId);
    }
}
