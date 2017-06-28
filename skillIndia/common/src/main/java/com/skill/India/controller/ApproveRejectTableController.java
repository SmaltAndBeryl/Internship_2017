package com.skill.India.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





import com.skill.India.dto.ApproveRejectTableDto;
import com.skill.India.service.ApproveRejectTableService;
	

	@RestController
	public class ApproveRejectTableController {
		
		@Autowired
		private ApproveRejectTableService approveRejectService;
		@RequestMapping("/approve")
		public Collection<ApproveRejectTableDto> approveRejectTableDtos(){
		return approveRejectService.getUpdateRowMapper();
		}
		
		
	}
	
