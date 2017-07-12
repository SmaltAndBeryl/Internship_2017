package com.skill.India.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.skill.India.dao.BatchAssignmentSearchDao;
import com.skill.India.dto.BatchAssignmentSearchDto;



@Service
public class BatchAssignmentSearchService {
	
	@Autowired
	private BatchAssignmentSearchDao updateDao;
	
	public Collection<BatchAssignmentSearchDto> getBatchDataForAssignmentService(int batchId){
		return updateDao.executeSearch(batchId);
	}

}


