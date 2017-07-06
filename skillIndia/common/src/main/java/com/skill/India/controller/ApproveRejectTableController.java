package com.skill.India.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.skill.India.common.ApplicationConstants;
import com.skill.India.dto.ApproveRejectTableDto;
import com.skill.India.dto.CommentDto;
import com.skill.India.service.ApproveRejectTableService;
	

	@RestController
	public class ApproveRejectTableController {
		
		@Autowired
		private ApproveRejectTableService approveRejectService;
		private ApproveRejectTableService manageRegistrationService;
		
		@RequestMapping("/approve")
		public Collection<ApproveRejectTableDto> approveRejectTableDtos(){
		return approveRejectService.getUpdateRowMapper();
		}
		
		 @RequestMapping(value= "/setManageRegistrationComment",method=RequestMethod.POST, consumes=MediaType.ALL_VALUE)
		 public @ResponseBody  String setComment(@RequestBody CommentDto commentDto, ApproveRejectTableService commentService){
			 
			
			 Boolean status= commentService.setComments(commentDto);
			 if(status)
				 return ApplicationConstants.successComment;
			 else
				 return ApplicationConstants.errorComment;
		 }
			 @RequestMapping("/approvebutton")
				public String getManageRegistrationDto() {
					int id=1234;
						return manageRegistrationService.putUpdateRowMapper(id);
		
	}
			 
			
			 }
	