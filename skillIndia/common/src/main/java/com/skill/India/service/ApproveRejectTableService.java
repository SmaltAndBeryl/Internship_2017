package com.skill.India.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.ApproveRejectTableDao;
import com.skill.India.dao.ManageRegistrationActionDao;
import com.skill.India.dto.ApproveRejectTableDto;
import com.skill.India.dto.ManageRegistrationActionDto;
import com.skill.India.dto.ManageRegistrationApplicationDto;

@Service
public class ApproveRejectTableService {
	
	

	@Autowired
	private ApproveRejectTableDao approveRejectTableDao;
	
	@Autowired
	private ManageRegistrationActionDao manageRegistrationActionDao;
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(ApproveRejectTableService.class);
	
	public HashMap<String, ArrayList<ApproveRejectTableDto>> getUpdateRowMapper(){
		LOGGER.info("Creating row mapper for applicationState : "  );
		return approveRejectTableDao.getUpdateRowMapper();
	}
	
	public String editUserApplication(int applicationId, String comment, String applicationState) throws SQLException
	{
		try
		{
			int commentsExists = manageRegistrationActionDao.checkCommentExistence(applicationId);
			System.out.println("commentExists = " + commentsExists);
			if(commentsExists == 1)
			{
				int i=manageRegistrationActionDao.updateCommentsOnAction(applicationId);
				System.out.println("I IS "+i);
			}
			int insertSuccessful=manageRegistrationActionDao.insertCommentsOnAction(applicationId, comment);
			System.out.println("insertApplicationId:"+insertSuccessful);
			manageRegistrationActionDao.updateApplicationStateonAction(applicationId,applicationState);
			System.out.println("IN THE IF BLOCK");
			return "Comment Captured Successful";
		}
		catch(Exception ex)
		{
			return "Failed to Insert Comment : Exception is "+ex;
		}
		
	}
	
	public int updateAffilationOfAApplicant(ManageRegistrationApplicationDto manageRegistrationApplicationDto)
	{
		return manageRegistrationActionDao.updateAffilationOfAApplicant(manageRegistrationApplicationDto);
	
	}
	
}
	
			
	

	
