package com.skill.India.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.AssessmentBodyApplicationStatusDao;
import com.skill.India.dto.AssessmentBodyApplicationStatusDto;



@Service
public class AssessmentBodyApplicationStatusService {
	
	@Autowired
	private AssessmentBodyApplicationStatusDao updateDao;
	
	public Collection<AssessmentBodyApplicationStatusDto> getUpdateRowMapper(){
		return updateDao.getUpateRowMapper() ;
	}

}
