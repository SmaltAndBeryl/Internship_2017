package com.skill.India.service;

import com.skill.India.dao.NonAssignedUpdateAgencyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Alkesh srivastav on 7/17/2017.
 */
@Service
public class NonAssignedUpdateAgencyService {
    @Autowired
    private NonAssignedUpdateAgencyDao nonAssignedUpdateAgencyDao;

    public int putAgencyId(String agencyId, String batchId, String responseType){
        return nonAssignedUpdateAgencyDao.putAgencyId(agencyId, batchId, responseType);
    }
}
