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
		
		LOGGER.info("Request Received from Controller");
		LOGGER.info("In ApproveRejectTableService - getUpdateRowMapper");
		LOGGER.info("Creating row mapper for application table : "  );
		LOGGER.info("Making a Request to Dao to get data");
		return approveRejectTableDao.getUpdateRowMapper();
	}
	
	public String editUserApplication(int applicationId, String comment, String applicationState) throws SQLException
	{
		LOGGER.info("Request Received from Controller");
		LOGGER.info("In ApproveRejectTableService - editUserApplication");
		LOGGER.info("Parameters Received from Controller are - 'applicationId': "+applicationId+" 'comment':"+comment+" 'applicationState':"+applicationState);
		try
		{
			LOGGER.info("Inside TRY block");
			LOGGER.info("Checking If a comment exists");
			LOGGER.info("Making a Request to Dao");
			int commentsExists = manageRegistrationActionDao.checkCommentExistence(applicationId);
			LOGGER.info("Response received from Dao");
			System.out.println("commentExists = " + commentsExists);
			if(commentsExists == 1)
			{
				LOGGER.info("Comment Already Exists");
				LOGGER.info("Setting the FLAG for old commment as False");
				LOGGER.info("Making a Request to Dao");
				int i=manageRegistrationActionDao.updateCommentsOnAction(applicationId);
				LOGGER.info("Response received from Dao");
				System.out.println("I IS "+i);
			}
			LOGGER.info("Inserting Comment");
			LOGGER.info("Parameters Received from Controller are - 'applicationId': "+applicationId+" 'comment': "+comment);
			LOGGER.info("Making a Request to Dao");
			int insertSuccessful=manageRegistrationActionDao.insertCommentsOnAction(applicationId, comment);
			LOGGER.info("Response received from Dao");
			LOGGER.info("Successfully inserted");
			System.out.println("insertApplicationId:"+insertSuccessful);
			LOGGER.info("Now Updating Application State");
			LOGGER.info("Parameters Received from Controller are - 'applicationId': "+applicationId+" 'applicationState': "+applicationState);
			LOGGER.info("Making a Request to Dao");
			manageRegistrationActionDao.updateApplicationStateonAction(applicationId,applicationState);
			LOGGER.info("Response received from Dao");
			LOGGER.info("Exiting TRY block");
			return "Comment Captured Successful";
		}
		catch(Exception ex)
		{
			LOGGER.info("Inside CATCH block");
			LOGGER.info("Error: Encountered Exception - "+ex);
			return "Failed to Insert Comment ";
		}
		
	}
	
	public int updateAffilationOfAApplicant(ManageRegistrationApplicationDto manageRegistrationApplicationDto)
	{
		LOGGER.info("Request Received from Controller");
		LOGGER.info("In ApproveRejectTableService - updateAffilationOfAApplicant");
		LOGGER.info("Parameters Received from Controller are - 'manageRegistrationApplicationDto': "+manageRegistrationApplicationDto);
		LOGGER.info("Making a Request to Dao");
		return manageRegistrationActionDao.updateAffilationOfAApplicant(manageRegistrationApplicationDto);
	
	}
	
}