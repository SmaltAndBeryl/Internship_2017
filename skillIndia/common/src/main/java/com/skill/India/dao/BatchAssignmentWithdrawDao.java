package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.BatchAssignmentConfigSql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Priyanshu Pandey on 7/15/2017.
 */
@Repository
public class BatchAssignmentWithdrawDao extends AbstractTransactionalDao{
    @Autowired
    public BatchAssignmentConfigSql batchAssignmentConfigSql;

    public int putUpdateBatches(String from){

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("batchId",from);
        return getJdbcTemplate().update(batchAssignmentConfigSql.getUpdateSqlBatchAssignment(),parameters);
    }
}