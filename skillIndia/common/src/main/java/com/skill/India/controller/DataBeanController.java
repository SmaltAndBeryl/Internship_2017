package com.skill.India.controller;

import com.skill.India.dto.DataBeanDto;
import com.skill.India.service.DataBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by Alkesh srivastav on 7/13/2017.
 */
@RestController
public class DataBeanController {

    @Autowired
    private DataBeanService dataBeanService;

    @RequestMapping("/cityData")
    public Collection<DataBeanDto> dataBeanDtoCollection(){
        return dataBeanService.dataBeanDtoCollection();
    }
}
