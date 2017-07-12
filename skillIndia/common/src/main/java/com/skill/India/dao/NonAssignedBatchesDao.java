package com.skill.India.dao;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.NonAssignedBatchesConfigSql;
import com.skill.India.dto.NonAssignedBatchesDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;




import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alkesh on 7/12/2017.
 */
@Repository
public class NonAssignedBatchesDao extends AbstractTransactionalDao{

    @Autowired
    private NonAssignedBatchesConfigSql nonAssignedBatchesConfigSql;

    private static NonAssignedBatchesDaoRowMapper ROW_MAPPER = new NonAssignedBatchesDaoRowMapper();

    public Collection<NonAssignedBatchesDto> getCollection() {
        Map<String, Object> parameters = new HashMap<>();
        return getJdbcTemplate().query(nonAssignedBatchesConfigSql.getSelectSqlNonAssignedBatches(), parameters, ROW_MAPPER);
    }

    private static class NonAssignedBatchesDaoRowMapper implements RowMapper<NonAssignedBatchesDto> {

        
    	@Override
        public NonAssignedBatchesDto mapRow(ResultSet resultSet, int rowNum)throws SQLException{
            
    		String batchID = resultSet.getString("batchId");
    	    String state = resultSet.getString("state");
    	    String batchEndDate = resultSet.getString("batchEndDate");
    	    String assessmentDate = resultSet.getString("assessmentDate");
    		    
    		return new NonAssignedBatchesDto(batchID, state, batchEndDate, assessmentDate);
    		
    	}
    }
}
