package com.skill.India.service;

import com.skill.India.dao.DropdownDao;
import com.skill.India.dto.DropdownDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Alkesh srivastav on 7/17/2017.
 */
@Service
public class DropdownService {
    @Autowired
    private DropdownDao dropdownDao;

    public Collection<DropdownDto> getCollection(){
        return dropdownDao.getCollection();
    }
}
