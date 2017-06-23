package com.skill.India.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.AssessmentBodyUpcomingBatchDao;
import com.skill.India.dto.AssessmentBodyUpcomingBatchDto;

@Service
public class AssessmentBodyUpcomingBatchService {
	
	@Autowired
	private AssessmentBodyUpcomingBatchDao updateDao;
	
	public Collection<AssessmentBodyUpcomingBatchDto> getUpdateRowMapper(){
		return updateDao.getUpateRowMapper() ;
	}

}