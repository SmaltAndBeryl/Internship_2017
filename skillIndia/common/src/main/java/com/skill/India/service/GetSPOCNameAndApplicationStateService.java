package com.skill.India.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.GetSPOCNameAndApplicationStateDao;
import com.skill.India.dto.GetSPOCNameAndApplicationStateDto;

@Service
public class GetSPOCNameAndApplicationStateService {

	@Autowired
	private GetSPOCNameAndApplicationStateDao getSPOCNameDaoAndApplicationState;
	
	public Collection<GetSPOCNameAndApplicationStateDto> getSPOCNameAndApplicationStateService(String userId){
		try{
		return getSPOCNameDaoAndApplicationState.getSPOCNameAndApplicationState(userId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return  null;
		}
	}
	
}
