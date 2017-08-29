package com.skill.India.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import net.sf.jasperreports.engine.JRException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.common.Privilege;
import com.skill.India.common.SessionUserUtility;
import com.skill.India.dto.ApproveRejectTableDto;
import com.skill.India.dto.CommentDto;
import com.skill.India.dto.DataBeanDto;
import com.skill.India.dto.ManageRegistrationApplicationDto;
import com.skill.India.dto.MessageDto;
import com.skill.India.service.ApproveRejectTableService;
import com.skill.India.service.DataBeanService;

@RestController
public class ManageRegistrationsController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ManageRegistrationsController.class);

	@Autowired
	private ApproveRejectTableService approveRejectTableService;
	
	@Autowired
	private SessionUserUtility sessionUser;
	
    @Autowired
    private DataBeanService dataBeanService;

	@Privilege(value={"SCGJ"})
	@RequestMapping("/approve")
	public HashMap<String, ArrayList<ApproveRejectTableDto>> approveRejectTableDtos() {
		LOGGER.info("In ManageRegistrationsController - approveRejectTableDtos");
		LOGGER.info("Request Received from front end to get data for Approve/Reject Table for Manage Registration");
		LOGGER.info("Trying to get Data from Application table");
		LOGGER.info("Sending Request to service");
		return approveRejectTableService.getUpdateRowMapper();
	}

	@Privilege(value={"SCGJ"})
	@RequestMapping(value = "/affiliationActionOfAnApplicant", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody MessageDto setAfflilationOfBody(
			@RequestBody ManageRegistrationApplicationDto manageRegistrationApplicationDto) {
		LOGGER.info("In ManageRegistrationsController - setAfflilationOfBody");
		LOGGER.info("Request Received from front end to set Affiliation of a Body");
		LOGGER.info("Parameters Received from front end are - 'manageRegistrationApplicationDto': "+manageRegistrationApplicationDto);
		LOGGER.info("Setting the UserId For the Affilation of a Body");
		manageRegistrationApplicationDto.setUserId(sessionUser.getSessionMangementfromSession().getUsername());
		MessageDto approveRegistartionMessage = new MessageDto();
		LOGGER.info("Trying to Affilate an Applicant.");
		int updatedAffilationOfAApplicant = 0;
		LOGGER.info("Sending Request to service");
		updatedAffilationOfAApplicant = approveRejectTableService
				.updateAffilationOfAApplicant(manageRegistrationApplicationDto);
		if (updatedAffilationOfAApplicant > 0)
		{

			LOGGER.info("Success");
			LOGGER.info("Setting up the Success Message");
			LOGGER.info("Sending request to Dao");
			approveRegistartionMessage.setSuccessMessage("Success");
			LOGGER.info("Response received from Dao");
		}
		else
		{
			LOGGER.info("Error");
			LOGGER.info("Setting up the Success Message");
			LOGGER.info("Sending request to Dao");
			approveRegistartionMessage.setErrorMessage("Error");
			LOGGER.info("Response received from Dao");
		}
		LOGGER.info("Sending Response back to Front End");
		return approveRegistartionMessage;

	}

	@Privilege(value={"SCGJ"})
	@RequestMapping(value = "/setManageRegistrationsComment", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody MessageDto setComment(@RequestBody CommentDto commentDto) {
		LOGGER.info("In ManageRegistrationsController - setComment");
		LOGGER.info("Request Received from front end to set comments for the process of Affiliation of a Body");
		LOGGER.info("Parameters Received from front end are - 'commentDto': "+commentDto);
		LOGGER.debug("Initializing a MessageDto");
		MessageDto approveRegistartionMessage = new MessageDto();
		LOGGER.info("Successfully initialized");
		try {
			LOGGER.info("Sending Request to service");
			String commentResult = approveRejectTableService
					.editUserApplication(commentDto.getApplicationId(),
							commentDto.getComment(),
							commentDto.getApplicationState());
			approveRegistartionMessage
					.setSuccessMessage("Changes made successfully");
			LOGGER.info("Result of inserting comments in Database is -"
					+ commentResult);
		} catch (Exception e) {
			approveRegistartionMessage
					.setErrorMessage("Exception inserting comments in Database");
			LOGGER.info("Exception in inserting comments to Database ", e);

		}
		return approveRegistartionMessage;

	}
	
	
	/*
	 * DataBeanController
	 */
	
	
    @Privilege(value={"SCGJ"})
    @RequestMapping("/cityData")
    public Collection<DataBeanDto> dataBeanDtoCollection()throws JRException{
    	LOGGER.info("In ManageRegistrationsController - dataBeanDtoCollection");
    	LOGGER.info("Request Received from front end to generate Collection from beans and get the required data for PDF creation");
    	LOGGER.info("Creating Collection to collect data for PDF creation");
    	LOGGER.info("Sending Request to Service");

        return dataBeanService.dataBeanDtoCollection();
    }

    @Privilege(value={"SCGJ"})
    @RequestMapping("/generatePdf")
    public void pdfBeanArrayList(){
    	LOGGER.info("In ManageRegistrationsController - pdfBeanArrayList");
    	LOGGER.info("Request Received from front end to generate PDF for the process of Affiliation of a Body");
    	LOGGER.info("Sending Request to Service");
//    	dataBeanService.generatePdf();
    	LOGGER.info("Exiting The Controller");
    }
		
}
