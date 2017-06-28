package com.skill.India.controller;

import com.skill.India.dto.CommentDto;
import com.skill.India.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
public class CommentController {
		
		@Autowired
		private CommentService commentService;
		
		 @RequestMapping(value="/setManageRegistrationComment",method=RequestMethod.POST, consumes=MediaType.ALL_VALUE)
		 public @ResponseBody  String setComment(@RequestBody CommentDto commentDto,UriComponentsBuilder ucBuilder){
			 
			
			 Boolean status= commentService.setComments(commentDto);
			 if(status)
				 return "comment updated succesfully";
			 else
				 return "comment not updated: some error";
			 
		 }
		  
					 
		 }
		 
		 
	
	

