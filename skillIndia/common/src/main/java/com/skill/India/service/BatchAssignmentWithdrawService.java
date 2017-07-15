package com.skill.India.service;

import com.skill.India.dao.BatchAssignmentWithdrawDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Priyanshu Pandey on 7/13/2017.
 */
@Service
public class BatchAssignmentWithdrawService {
    @Autowired
    private BatchAssignmentWithdrawDao batchAssignmentWithdrawDao;

    public int putUpdateBatches(String batchId){
        return batchAssignmentWithdrawDao.putUpdateBatches(batchId);
    }
}
