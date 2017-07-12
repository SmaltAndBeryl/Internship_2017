package com.skill.India.controller;

import com.skill.India.dto.NonAssignedBatchesDto;
import com.skill.India.service.NonAssignedBatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by Alkesh on 7/12/2017.
 */
@RestController
public class NonAssignedBatchesController {

    @Autowired
    private NonAssignedBatchesService nonAssignedBatchesService;

    @RequestMapping("/non")
    public Collection<NonAssignedBatchesDto> getNonAssignedBatchesDto(){

        return nonAssignedBatchesService.getCollection();
    }
}
