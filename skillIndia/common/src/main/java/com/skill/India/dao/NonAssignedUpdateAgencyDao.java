package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.NonAssignedBatchesConfigSql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alkesh srivastav on 7/17/2017.
 */
@Repository
public class NonAssignedUpdateAgencyDao extends AbstractTransactionalDao{
    @Autowired
    public NonAssignedBatchesConfigSql configSql;
    public int putAgencyId(String agencyId, String batchId){
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("agencyId", agencyId);
        parameters.put("batchId", batchId);
        return getJdbcTemplate().update(configSql.getUpdateSqlProposeAgency(), parameters);
    }
}
