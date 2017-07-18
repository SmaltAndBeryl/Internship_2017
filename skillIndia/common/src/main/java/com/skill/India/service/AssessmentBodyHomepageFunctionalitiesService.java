package com.skill.India.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.AssessmentBodyHomepageFunctionalitiesDao;

@Service
public class AssessmentBodyHomepageFunctionalitiesService {
	@Autowired
	private AssessmentBodyHomepageFunctionalitiesDao assessmentBodyHomepageFunctionalitiesDao;
	
	public int putShowInterest(String batchId,String agencyId){
		System.out.println("THIS IS THE BATCH id"+batchId+agencyId);
		return assessmentBodyHomepageFunctionalitiesDao.putShowInterest(batchId,agencyId);
	}
	
	public int putApproveBatch(String batchId){
		System.out.println("THIS IS THE BATCH id"+batchId);
		return assessmentBodyHomepageFunctionalitiesDao.putApproveBatch(batchId);
	}
	
	public int putRejectBatch(String batchId){
		return assessmentBodyHomepageFunctionalitiesDao.putRejectBatch(batchId);
	}
}
