package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.NonAssignedBatchesConfigSql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alkesh srivastav on 7/12/2017.
 */
@Repository
public class NonAssignedBatchesUpdateDao extends AbstractTransactionalDao{
    @Autowired
    public NonAssignedBatchesConfigSql batchesConfigSql;

    public int putUpdateBatches(){
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("batchId","Alkesh");
        return getJdbcTemplate().update(batchesConfigSql.getUpdateSqlNonAssignedBatches(),parameters);
    }
}
