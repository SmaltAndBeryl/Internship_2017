package com.skill.India.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.AssignedBatchesDao;

import com.skill.India.dto.AssignedBatchesDto;


@Service
public class AssignedBatchesService {

	@Autowired
	private AssignedBatchesDao updateDao;
	
	public Collection<AssignedBatchesDto> getUpdateRowMapper()
	{
		
		return updateDao.getupdateRowMapper();
	}
	
	
	
}



