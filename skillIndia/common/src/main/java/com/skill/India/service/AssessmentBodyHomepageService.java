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
	
	public Collection<AssessmentBodyHomepageDto> getpastBatchesAssessmentBodyHomepageRowMapper(int applicationId){
		return assessmentBodyHomepageDao.getpastBatchesAssessmentBodyHomepageRowMapper(applicationId);
	}
	
	public Collection<AssessmentBodyHomepageDto> getupcomingBatchesAssessmentBodyHomepageRowMapper(int applicationId){
		return assessmentBodyHomepageDao.getupcomingBatchesAssessmentBodyHomepageRowMapper(applicationId);
	}
	
	public Collection<AssessmentBodyHomepageDto> getshownInterestAssessmentBodyHomepageRowMapper(int applicationId){
		return assessmentBodyHomepageDao.getshownInterestAssessmentBodyHomepageRowMapper(applicationId);
	}
	
	public Collection<AssessmentBodyHomepageDto> getassignedBatchesAssessmentBodyHomepageRowMapper(int applicationId){
		return assessmentBodyHomepageDao.getassignedBatchesAssessmentBodyHomepageRowMapper(applicationId);
	}
	
	public Collection<AssessmentBodyHomepageDto> getconfirmedBatchesAssessmentBodyHomepageRowMapper(int applicationId){
		return assessmentBodyHomepageDao.getconfirmedBatchesAssessmentBodyHomepageRowMapper(applicationId);
	}
	
	
}
