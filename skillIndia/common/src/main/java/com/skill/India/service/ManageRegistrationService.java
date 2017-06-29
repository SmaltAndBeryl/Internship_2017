package com.skill.India.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.skill.India.dao.ManageRegistrationDao;

@Service
	public class ManageRegistrationService {
			
			@Autowired
			private ManageRegistrationDao updateDao;
			public String putUpdateRowMapper(int id){
				 int i = updateDao.putUpdateRowMapper(id);
				if(i>0)
					return "success";
				else
					return "fail";
			}
			
			}
