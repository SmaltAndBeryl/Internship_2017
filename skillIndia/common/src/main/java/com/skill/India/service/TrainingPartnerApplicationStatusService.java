package com.skill.India.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.TrainingPartnerApplicationStatusDao;
import com.skill.India.dto.TrainingPartnerApplicationStatusDto;

@Service
public class TrainingPartnerApplicationStatusService {

	@Autowired
	private TrainingPartnerApplicationStatusDao updateDao;
	
	public Collection<TrainingPartnerApplicationStatusDto> getUpdateRowMapper(){
		return updateDao.getUpateRowMapper() ;
	}
}
