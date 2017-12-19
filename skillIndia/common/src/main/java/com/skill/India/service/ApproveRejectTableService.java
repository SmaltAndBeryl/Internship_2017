package com.skill.India.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.ApproveRejectTableDao;
import com.skill.India.dao.ManageRegistrationActionDao;
import com.skill.India.dto.ApproveRejectTableDto;
import com.skill.India.dto.ManageRegistrationApplicationDto;

@Service
public class ApproveRejectTableService {
	
	@Autowired
	private ApproveRejectTableDao approveRejectTableDao;
	
	@Autowired
	private ManageRegistrationActionDao manageRegistrationActionDao;
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(ApproveRejectTableService.class);
	
	public HashMap<String, ArrayList<ApproveRejectTableDto>> getUpdateRowMapper(){
		
		LOGGER.debug("Request Received from Controller");
		LOGGER.debug("In ApproveRejectTableService - getUpdateRowMapper");
		LOGGER.debug("Creating row mapper for application table : "  );
		LOGGER.debug("Making a Request to Dao to get data");
		return approveRejectTableDao.getUpdateRowMapper();
	}
	
	public String editUserApplication(int applicationId, String comment, String applicationState) throws SQLException
	{
		LOGGER.debug("Request Received from Controller");
		LOGGER.debug("In ApproveRejectTableService - editUserApplication");
		LOGGER.debug("Parameters Received from Controller are - 'applicationId': "+applicationId+" 'comment':"+comment+" 'applicationState':"+applicationState);
		try
		{
			LOGGER.debug("Inside TRY block");
			LOGGER.debug("Checking If a comment exists");
			LOGGER.debug("Making a Request to Dao");
			int commentsExists = manageRegistrationActionDao.checkCommentExistence(applicationId);
			LOGGER.debug("Response received from Dao");
			System.out.println("commentExists = " + commentsExists);
			if(commentsExists == 1)
			{
				LOGGER.debug("Comment Already Exists");
				LOGGER.debug("Setting the FLAG for old commment as False");
				LOGGER.debug("Making a Request to Dao");
				int i=manageRegistrationActionDao.updateCommentsOnAction(applicationId);
				LOGGER.debug("Response received from Dao");
				System.out.println("I IS "+i);
			}
			LOGGER.debug("Inserting Comment");
			LOGGER.debug("Parameters Received from Controller are - 'applicationId': "+applicationId+" 'comment': "+comment);
			LOGGER.debug("Making a Request to Dao");
			int insertSuccessful=manageRegistrationActionDao.insertCommentsOnAction(applicationId, comment);
			LOGGER.debug("Response received from Dao");
			LOGGER.debug("Successfully inserted");
			System.out.println("insertApplicationId:"+insertSuccessful);
			LOGGER.debug("Now Updating Application State");
			LOGGER.debug("Parameters Received from Controller are - 'applicationId': "+applicationId+" 'applicationState': "+applicationState);
			LOGGER.debug("Making a Request to Dao");
			manageRegistrationActionDao.updateApplicationStateonAction(applicationId,applicationState);
			LOGGER.debug("Response received from Dao");
			LOGGER.debug("Exiting TRY block");
			return "Comment Captured Successful";
		}
		catch(Exception ex)
		{
			LOGGER.debug("Inside CATCH block");
			LOGGER.debug("Error: Encountered Exception - "+ex);
			return "Failed to Insert Comment ";
		}
		
	}
	
	public int updateAffilationOfAApplicant(ManageRegistrationApplicationDto manageRegistrationApplicationDto)
	{
		LOGGER.debug("Request Received from Controller");
		LOGGER.debug("In ApproveRejectTableService - updateAffilationOfAApplicant");
		LOGGER.debug("Parameters Received from Controller are - 'manageRegistrationApplicationDto': "+manageRegistrationApplicationDto);
		LOGGER.debug("Making a Request to Dao");
		return manageRegistrationActionDao.updateAffilationOfAApplicant(manageRegistrationApplicationDto);
	
	}
	
}