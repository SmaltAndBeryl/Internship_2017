package com.skill.India.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.dto.ApproveRejectTableDto;
import com.skill.India.dto.CommentDto;
import com.skill.India.dto.ManageRegistrationApplicationDto;
import com.skill.India.service.ApproveRejectTableService;
	

	@RestController
	public class ApproveRejectTableController
	{
		
		private static final Logger LOGGER = LoggerFactory.getLogger(ApproveRejectTableController.class);
		@Autowired
		private ApproveRejectTableService approveRejectTableService;
			
		
		@RequestMapping("/approve")
		public Collection<ApproveRejectTableDto> approveRejectTableDtos()
		{
			LOGGER.info("Trying to get Data from Application table");
		return approveRejectTableService.getUpdateRowMapper();
		}
		
		@RequestMapping(value="/affiliationActionOfAnApplicant",method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
		public String setAfflilationOfBody(@RequestBody ManageRegistrationApplicationDto manageRegistrationApplicationDto)
		{
			LOGGER.info("Trying to Affilate an Applicant."); 
			int updatedAffilationOfAApplicant=0;
			 
				  updatedAffilationOfAApplicant = approveRejectTableService.updateAffilationOfAApplicant(manageRegistrationApplicationDto);
				  if(updatedAffilationOfAApplicant>0)
					{
						return "SUCCESS: Updated Application Status Of the Applicant.";
					}
				  else
				  {
					  return "ERROR: Error Encountered while updating the changes in database.";
				  }
			
		 }
		
		 @RequestMapping(value= "/setManageRegistrationsComment",method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
		 public @ResponseBody  String setComment(@RequestBody CommentDto commentDto){
			 try
			 {
				
				 String commentResult = approveRejectTableService.editUserApplication(commentDto.getApplicationId(), commentDto.getComment());
				 LOGGER.info("Result of inserting comments in Database is -",commentResult);
				 return commentResult;
			 }
			 catch(Exception e)
			 {
				 LOGGER.info("Exception in inserting comments to Database ", e);
				 return "ERROR : Unable to update the comment for applicationId";
			 }
			
		 }
		 	 
		 
		 
		  
		 
	}
		 
	 