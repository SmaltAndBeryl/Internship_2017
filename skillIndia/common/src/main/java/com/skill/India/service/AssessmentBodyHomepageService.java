package com.skill.India.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.skill.India.dao.AssessmentBodyHomepageDao;
import com.skill.India.dto.AssessmentBodyHomepageDto;


@Service
public class AssessmentBodyHomepageService {

	@Autowired
	private AssessmentBodyHomepageDao assessmentBodyHomepageDao;
	
	public Collection<AssessmentBodyHomepageDto> getpastBatchesAssessmentBodyHomepageRowMapper(){
		return assessmentBodyHomepageDao.getpastBatchesAssessmentBodyHomepageRowMapper();
	}
	
	public Collection<AssessmentBodyHomepageDto> getupcomingBatchesAssessmentBodyHomepageRowMapper(){
		return assessmentBodyHomepageDao.getupcomingBatchesAssessmentBodyHomepageRowMapper();
	}
	
	public Collection<AssessmentBodyHomepageDto> getassignedBatchesAssessmentBodyHomepageRowMapper(){
		return assessmentBodyHomepageDao.getassignedBatchesAssessmentBodyHomepageRowMapper();
	}
	
	public Collection<AssessmentBodyHomepageDto> getconfirmedBatchesAssessmentBodyHomepageRowMapper(){
		return assessmentBodyHomepageDao.getconfirmedBatchesAssessmentBodyHomepageRowMapper();
	}
	
	
}
