package com.skill.India.service;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.AssessmentBodyUpcomingBatchDao;
import com.skill.India.dao.ShowInterestUpcomingBatchesDao;
import com.skill.India.dto.AssessmentBodyUpcomingBatchDto;
import com.skill.India.dto.ShowInterestUpcomingBatchesDto;

@Service
public class ShowInterestUpcomingBatchesService {

	@Autowired
	private ShowInterestUpcomingBatchesDao insertDao;
	
	public String putInsertRowMapper(int id){
		int i=insertDao.insertShowInterestUpcomingBatches(id);
		if(i>0)
			
			return ("Successfully record inserted");
		else 
			return "Record not inserted";
	}
}
