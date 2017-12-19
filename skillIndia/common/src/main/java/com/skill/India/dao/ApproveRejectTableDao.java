package com.skill.India.dao;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.ApproveRejectTableConfigSql;
import com.skill.India.dto.ApproveRejectTableDto;


@Repository
public class ApproveRejectTableDao extends AbstractTransactionalDao {
    
	private static final Logger LOGGER = LoggerFactory.getLogger(ApproveRejectTableDao.class);

	@Autowired
	public ApproveRejectTableConfigSql config;

	private static final ApproveRejectSelectRowMapper ROW_MAPPER = new ApproveRejectSelectRowMapper();
	
	public HashMap<String, ArrayList<ApproveRejectTableDto>> getUpdateRowMapper() {
		LOGGER.debug("Request Received from Service");
		LOGGER.debug("In ApproveRejectTableDao - getUpdateRowMapper");
		
		LOGGER.debug("Creating ArrayList object for approved Applications");
		ArrayList<ApproveRejectTableDto> approvedApplications = new ArrayList<ApproveRejectTableDto>();
		LOGGER.debug("Successfully created");
		
		LOGGER.debug("Creating ArrayList object for rejected Applications");
		ArrayList<ApproveRejectTableDto> rejectedApplications = new ArrayList<ApproveRejectTableDto>();
		LOGGER.debug("Successfully created");
		
		LOGGER.debug("Creating ArrayList object for Submitted Applications");
		ArrayList<ApproveRejectTableDto> submittedApplications = new ArrayList<ApproveRejectTableDto>();
		LOGGER.debug("Successfully created");
		
		LOGGER.debug("Creating ArrayList object for incomplete Applications");
		ArrayList<ApproveRejectTableDto> incompleteApplications = new ArrayList<ApproveRejectTableDto>();
		LOGGER.debug("Successfully created");
		
		LOGGER.debug("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.debug("object created successfully");
		
		LOGGER.debug("Creating Collection object of type ApproveRejectTableDto");
		LOGGER.debug("Initializing the object");
		
		LOGGER.debug("Executing SQL query");
        Collection<ApproveRejectTableDto> manageRegistrationsTable =  getJdbcTemplate().query(config.getSelectSql(), parameters,
				ROW_MAPPER);
        LOGGER.debug("Response received and initialized in object");
        
       
		for(ApproveRejectTableDto rowWiseData:manageRegistrationsTable)
		{
			 LOGGER.debug("Iterating the object");
		switch (rowWiseData.getapplicationState())
		{
			case "Approved" :
			{
				LOGGER.debug("Inside Approved case");
				LOGGER.debug("Adding data into approved ArrayList object");
				approvedApplications.add(rowWiseData);
				LOGGER.debug("Successfully added");
				break;
			}
			case "Rejected":
			{
				LOGGER.debug("Inside Rejected case");
				LOGGER.debug("Adding data into rejected ArrayList object");
				rejectedApplications.add(rowWiseData);
				LOGGER.debug("Successfully added");
				break;
			}
			case "Submit":
			{
				LOGGER.debug("Inside Submit case");
				LOGGER.debug("Adding data into Submitted ArrayList object");
				submittedApplications.add(rowWiseData);
				LOGGER.debug("Successfully added");
				break;
			}
			case "Incomplete":
			{
				LOGGER.debug("Inside Incomplete case");
				LOGGER.debug("Adding data into incomplete ArrayList object");
				incompleteApplications.add(rowWiseData);
				LOGGER.debug("Successfully added");
				break;
			}
		}
	}
		LOGGER.debug("Creating HashMap object");
		HashMap<String,ArrayList<ApproveRejectTableDto>> manageRegistrationsDataMap = new HashMap<String,ArrayList<ApproveRejectTableDto>>();
		LOGGER.debug("Successfully created");
		
		LOGGER.debug("Initializing the object");
		manageRegistrationsDataMap.put("submitted", submittedApplications);
		manageRegistrationsDataMap.put("approved", approvedApplications);
		manageRegistrationsDataMap.put("rejected", rejectedApplications);
		manageRegistrationsDataMap.put("incomplete", incompleteApplications);
		LOGGER.debug("Successfully initialized");
		
		LOGGER.debug("Returning response");
		return manageRegistrationsDataMap;
	}

 private static class ApproveRejectSelectRowMapper implements RowMapper<ApproveRejectTableDto> {

		@Override
		public ApproveRejectTableDto mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {
			Integer applicationId = resultSet.getInt("applicationId");
		    String applicationState= resultSet.getString("applicationState");
		    Boolean activeFlag = resultSet.getBoolean("activeFlag");
			Date dateOfSubmission = resultSet.getDate("dateOfSubmission");
            String userRole = resultSet.getString("userRole");
            String organizationName = resultSet.getString("organizationName");

			return new ApproveRejectTableDto(applicationId, applicationState, activeFlag, dateOfSubmission,organizationName,userRole);
		}

	
 }
}