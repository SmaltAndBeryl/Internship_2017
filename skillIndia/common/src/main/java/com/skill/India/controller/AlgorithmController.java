package com.skill.India.controller;

import com.skill.India.dto.Algorithm2Dto;
import com.skill.India.dto.Algorithm3Dto;
import com.skill.India.dto.AlgorithmDto;
import com.skill.India.service.AlgorithmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by Alkesh srivastav on 7/17/2017.
 */
@RestController
public class AlgorithmController {
    @Autowired
    private AlgorithmService algorithmService;

    @RequestMapping(method = RequestMethod.POST, value = "/getBatchId")
    public Collection<AlgorithmDto> getAlgorithmDto(@RequestParam("batchId") String batchId){
        return algorithmService.getBatchIdCollection(batchId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/getAgencyId")
    public Collection<Algorithm2Dto> getAlgorithm2Dto(@RequestParam("batchId") int batchId){
        return algorithmService.getAgencyIdCollection(batchId);
    }

    @RequestMapping("/getAssessorState")
    public Collection<Algorithm3Dto> getAlgorithm3Dto(){
        return algorithmService.getAssessorIdCollecion();
    }

    @RequestMapping(value = "/getAgencyName", method = RequestMethod.GET, produces = "application/JSON")
    public String getSelectedAgency(){
        return algorithmService.printStates();
    }
}
