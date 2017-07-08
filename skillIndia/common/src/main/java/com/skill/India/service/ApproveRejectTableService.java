package com.skill.India.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.ApproveRejectTableDao;
import com.skill.India.dao.CommentDao;

import com.skill.India.dao.ManageRegistrationDao;
import com.skill.India.dto.ApproveRejectTableDto;
import com.skill.India.dto.CommentDto;


@Service
public class ApproveRejectTableService {
	
	

	@Autowired
	private ApproveRejectTableDao approveRejectTableDao;
	
	@Autowired
	private CommentDao commentDao;
	
	@Autowired
	private ManageRegistrationDao ManageRegistrationAcceptDao;
	
	
	public Collection<ApproveRejectTableDto> getUpdateRowMapper(){
		return approveRejectTableDao.getUpdateRowMapper();
	}
	
	public boolean setComments(CommentDto commentDto){

		int status;
		status =commentDao.insertComment(commentDto);
		if(status == 0)
			return false;
		else
			return true;
		
	}
	
	public String putUpdateRowMapper(int id){
		return "success";
	
			
	}

	
}