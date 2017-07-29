package com.skill.India.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.GetSPOCNameDao;

@Service
public class GetSPOCNameService {

	@Autowired
	private GetSPOCNameDao getSPOCNameDao;
	
	public String getSPOCNameService(String userId){
		try{
		return getSPOCNameDao.getSPOCName(userId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return  null;
		}
	}
	
}
