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
    	LOGGER.info("Request Received from Service");
		LOGGER.info("In DashboardPanelsDao - getTotalCandidateEnrolled");
				   	
		LOGGER.info("Getting total candidates enrolled");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Executing SQL query");
        Integer candidates= getJdbcTemplate().queryForObject(dashboardConfigSql.getSelectSqlTotalCandidatesEnrolled(), parameters, Integer.class);        
        if(candidates==null)
        	candidates=0;
        LOGGER.info("Returning response");
        return candidates;
    }

    public Integer getTotalCandidateAccessed() {
    	LOGGER.info("Request Received from Service");
		LOGGER.info("In DashboardPanelsDao - getTotalCandidateAccessed");
				   	
		LOGGER.info("Getting total candidates assessed");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Executing SQL query");
        Integer candidates= getJdbcTemplate().queryForObject(dashboardConfigSql.getSelectSqlTotalCandidatesAccessed(), parameters, Integer.class);        
        if(candidates==null)
        	candidates=0;
        LOGGER.info("Returning response");
        return candidates;
    }
    
    public Integer getTotalCandidateCertified() {
    	LOGGER.info("Request Received from Service");
		LOGGER.info("In DashboardPanelsDao - getTotalCandidateCertified");
				   	
		LOGGER.info("Getting total candidates certified");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Executing SQL query");
        Integer candidates= getJdbcTemplate().queryForObject(dashboardConfigSql.getSelectSqlTotalCandidatesCertified(), parameters, Integer.class);        
        if(candidates==null)
        	candidates=0;
        LOGGER.info("Returning response");
        return candidates;
    }
    
    public Integer getTotalTrainingPartners() {
    	LOGGER.info("Request Received from Service");
		LOGGER.info("In DashboardPanelsDao - getTotalTrainingPartners");
				   	
		LOGGER.info("Getting total Training Partners");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Executing SQL query and returning response");
		return getJdbcTemplate().queryForObject(dashboardConfigSql.getSelectSqlTotalTrainingPartners(), parameters, Integer.class);
    }
    
    public Integer getTotalTrainingCentersInIndia() {
    	LOGGER.info("Request Received from Service");
		LOGGER.info("In DashboardPanelsDao - getTotalTrainingCentersInIndia");
				   	
		LOGGER.info("Getting total Training Centers");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Executing SQL query and returning response");
		return getJdbcTemplate().queryForObject(dashboardConfigSql.getSelectSqlTotalTrainingCentersInIndia(), parameters, Integer.class);        
        
    }
    
}
 