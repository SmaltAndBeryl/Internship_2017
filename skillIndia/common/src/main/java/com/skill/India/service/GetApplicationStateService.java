package com.skill.India.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.GetApplicationStateDao;

@Service
public class GetApplicationStateService {

	@Autowired
	private GetApplicationStateDao getApplicationStateDao;
	
	public String getApplicationStateService(String userId){
		try{
			System.out.println(getApplicationStateDao.getApplicationState(userId));
		return getApplicationStateDao.getApplicationState(userId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return  null;
		}
	}
	
}
