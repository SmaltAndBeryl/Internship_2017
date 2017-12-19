package com.skill.India.dao;


import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.DashboardConfigSql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by aashish on 6/24/17.
 */
@Repository
public class DashboardPanelsDao extends AbstractTransactionalDao{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DashboardPanelsDao.class);
	
    @Autowired
    public DashboardConfigSql dashboardConfigSql;

    public Integer getTotalCandidateEnrolled() {
    	LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DashboardPanelsDao - getTotalCandidateEnrolled");
				   	
		LOGGER.debug("Getting total candidates enrolled");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Executing SQL query");
        Integer candidates= getJdbcTemplate().queryForObject(dashboardConfigSql.getSelectSqlTotalCandidatesEnrolled(), parameters, Integer.class);        
        if(candidates==null)
        	candidates=0;
        LOGGER.debug("Returning response");
        return candidates;
    }

    public Integer getTotalCandidateAccessed() {
    	LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DashboardPanelsDao - getTotalCandidateAccessed");
				   	
		LOGGER.debug("Getting total candidates assessed");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Executing SQL query");
        Integer candidates= getJdbcTemplate().queryForObject(dashboardConfigSql.getSelectSqlTotalCandidatesAccessed(), parameters, Integer.class);        
        if(candidates==null)
        	candidates=0;
        LOGGER.debug("Returning response");
        return candidates;
    }
    
    public Integer getTotalCandidateCertified() {
    	LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DashboardPanelsDao - getTotalCandidateCertified");
				   	
		LOGGER.debug("Getting total candidates certified");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Executing SQL query");
        Integer candidates= getJdbcTemplate().queryForObject(dashboardConfigSql.getSelectSqlTotalCandidatesCertified(), parameters, Integer.class);        
        if(candidates==null)
        	candidates=0;
        LOGGER.debug("Returning response");
        return candidates;
    }
    
    public Integer getTotalTrainingPartners() {
    	LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DashboardPanelsDao - getTotalTrainingPartners");
				   	
		LOGGER.debug("Getting total Training Partners");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Executing SQL query and returning response");
		return getJdbcTemplate().queryForObject(dashboardConfigSql.getSelectSqlTotalTrainingPartners(), parameters, Integer.class);
    }
    
    public Integer getTotalTrainingCentersInIndia() {
    	LOGGER.debug("Request Received from Service");
		LOGGER.debug("In DashboardPanelsDao - getTotalTrainingCentersInIndia");
				   	
		LOGGER.debug("Getting total Training Centers");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Executing SQL query and returning response");
		return getJdbcTemplate().queryForObject(dashboardConfigSql.getSelectSqlTotalTrainingCentersInIndia(), parameters, Integer.class);        
        
    }
    
}
 