package com.skill.India.service;

import com.skill.India.dao.NonAssignedBatchesUpdateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Alkesh on 7/12/2017.
 */
@Service
public class NonAssignedBatchesUpdateService {
    @Autowired
    private NonAssignedBatchesUpdateDao updateDao;

    public int putUpdateBatches(String batchId){
        return updateDao.putUpdateBatches(batchId);
    }
}
