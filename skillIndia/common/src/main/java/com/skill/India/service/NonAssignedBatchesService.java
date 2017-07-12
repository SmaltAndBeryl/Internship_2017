package com.skill.India.service;

import com.skill.India.dao.NonAssignedBatchesDao;
import com.skill.India.dto.NonAssignedBatchesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Alkesh on 7/12/2017.
 */
@Service
public class NonAssignedBatchesService {

    @Autowired
    private NonAssignedBatchesDao updateDao;

    public Collection<NonAssignedBatchesDto> getCollection(){
        return updateDao.getCollection();
    }
}
