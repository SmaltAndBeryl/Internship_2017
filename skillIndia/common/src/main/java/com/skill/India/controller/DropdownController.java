package com.skill.India.controller;

import com.skill.India.dto.DropdownDto;
import com.skill.India.service.DropdownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by Alkesh srivastav on 7/17/2017.
 */
@RestController
public class DropdownController {
    @Autowired
    private DropdownService dropdownService;

    @RequestMapping("/dropdown")
    public Collection<DropdownDto> getDropdownDto(){
        return dropdownService.getCollection();
    }
}
