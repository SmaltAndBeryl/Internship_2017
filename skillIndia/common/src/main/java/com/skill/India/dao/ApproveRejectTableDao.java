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
		LOGGER.info("Request Received from Service");
		LOGGER.info("In ApproveRejectTableDao - getUpdateRowMapper");
		
		LOGGER.info("Creating ArrayList object for approved Applications");
		ArrayList<ApproveRejectTableDto> approvedApplications = new ArrayList<ApproveRejectTableDto>();
		LOGGER.info("Successfully created");
		
		LOGGER.info("Creating ArrayList object for rejected Applications");
		ArrayList<ApproveRejectTableDto> rejectedApplications = new ArrayList<ApproveRejectTableDto>();
		LOGGER.info("Successfully created");
		
		LOGGER.info("Creating ArrayList object for Submitted Applications");
		ArrayList<ApproveRejectTableDto> submittedApplications = new ArrayList<ApproveRejectTableDto>();
		LOGGER.info("Successfully created");
		
		LOGGER.info("Creating ArrayList object for incomplete Applications");
		ArrayList<ApproveRejectTableDto> incompleteApplications = new ArrayList<ApproveRejectTableDto>();
		LOGGER.info("Successfully created");
		
		LOGGER.info("Creating HashMap object");
		Map<String, Object> parameters = new HashMap<>();
		LOGGER.info("object created successfully");
		
		LOGGER.info("Creating Collection object of type ApproveRejectTableDto");
		LOGGER.info("Initializing the object");
		
		LOGGER.info("Executing SQL query");
        Collection<ApproveRejectTableDto> manageRegistrationsTable =  getJdbcTemplate().query(config.getSelectSql(), parameters,
				ROW_MAPPER);
        LOGGER.info("Response received and initialized in object");
        
       
		for(ApproveRejectTableDto rowWiseData:manageRegistrationsTable)
		{
			 LOGGER.info("Iterating the object");
		switch (rowWiseData.getapplicationState())
		{
			case "Approved" :
			{
				LOGGER.info("Inside Approved case");
				LOGGER.info("Adding data into approved ArrayList object");
				approvedApplications.add(rowWiseData);
				LOGGER.info("Successfully added");
				break;
			}
			case "Rejected":
			{
				LOGGER.info("Inside Rejected case");
				LOGGER.info("Adding data into rejected ArrayList object");
				rejectedApplications.add(rowWiseData);
				LOGGER.info("Successfully added");
				break;
			}
			case "Submit":
			{
				LOGGER.info("Inside Submit case");
				LOGGER.info("Adding data into Submitted ArrayList object");
				submittedApplications.add(rowWiseData);
				LOGGER.info("Successfully added");
				break;
			}
			case "Incomplete":
			{
				LOGGER.info("Inside Incomplete case");
				LOGGER.info("Adding data into incomplete ArrayList object");
				incompleteApplications.add(rowWiseData);
				LOGGER.info("Successfully added");
				break;
			}
		}
	}
		LOGGER.info("Creating HashMap object");
		HashMap<String,ArrayList<ApproveRejectTableDto>> manageRegistrationsDataMap = new HashMap<String,ArrayList<ApproveRejectTableDto>>();
		LOGGER.info("Successfully created");
		
		LOGGER.info("Initializing the object");
		manageRegistrationsDataMap.put("submitted", submittedApplications);
		manageRegistrationsDataMap.put("approved", approvedApplications);
		manageRegistrationsDataMap.put("rejected", rejectedApplications);
		manageRegistrationsDataMap.put("incomplete", incompleteApplications);
		LOGGER.info("Successfully initialized");
		
		LOGGER.info("Returning response");
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