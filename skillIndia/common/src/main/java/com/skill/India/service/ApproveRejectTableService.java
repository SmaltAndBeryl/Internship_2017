package com.skill.India.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.ApproveRejectTableDao;

import com.skill.India.dto.ApproveRejectTableDto;


@Service
public class ApproveRejectTableService {
	
	@Autowired
	private ApproveRejectTableDao approveRejectTableDao;
	
	public Collection<ApproveRejectTableDto> getUpdateRowMapper(){
		return approveRejectTableDao.getUpdateRowMapper();
	}

}