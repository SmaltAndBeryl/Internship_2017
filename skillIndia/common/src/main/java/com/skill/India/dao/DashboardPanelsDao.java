package com.skill.India.dao;


import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.DashboardConfigSql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by aashish on 6/24/17.
 */
@Repository
public class DashboardPanelsDao extends AbstractTransactionalDao{
	
	

    @Autowired
    public DashboardConfigSql dashboardConfigSql;

    public Integer getTotalCandidateEnrolled() {
    	Map<String, Object> parameters = new HashMap<>();
        Integer candidates= getJdbcTemplate().queryForObject(dashboardConfigSql.getSelectSqlTotalCandidatesEnrolled(), parameters, Integer.class);        
        if(candidates==null)
        	candidates=0;
        return candidates;
    }

    public Integer getTotalCandidateAccessed() {
    	Map<String, Object> parameters = new HashMap<>();
    	Integer candidates= getJdbcTemplate().queryForObject(dashboardConfigSql.getSelectSqlTotalCandidatesAccessed(), parameters, Integer.class);        
        if(candidates==null)
        	candidates=0;
        return candidates;
    }
    
    public Integer getTotalCandidateCertified() {
    	Map<String, Object> parameters = new HashMap<>();
    	Integer candidates= getJdbcTemplate().queryForObject(dashboardConfigSql.getSelectSqlTotalCandidatesCertified(), parameters, Integer.class);        
        if(candidates==null)
        	candidates=0;
        return candidates;
    }
    
    public Integer getTotalTrainingPartners() {
    	Map<String, Object> parameters = new HashMap<>();
        return getJdbcTemplate().queryForObject(dashboardConfigSql.getSelectSqlTotalTrainingPartners(), parameters, Integer.class);        
        
    }
    
    public Integer getTotalTrainingCentersInIndia() {
    	Map<String, Object> parameters = new HashMap<>();
        return getJdbcTemplate().queryForObject(dashboardConfigSql.getSelectSqlTotalTrainingCentersInIndia(), parameters, Integer.class);        
        
    }
    
}
 