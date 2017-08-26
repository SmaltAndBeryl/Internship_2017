package com.skill.India.service;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dto.DataImportHistoryDto;

import com.skill.India.dao.DataImportHistoryDao;




@Service
public class DataImportServices {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DataImportServices.class);
	
	@Autowired
	private DataImportHistoryDao dataImportHistoryDao;
	
	public Collection<DataImportHistoryDto> getUpdateHistory(){
		LOGGER.info("Request Received from Controller");
		LOGGER.info("In DataImportServices - getUpdateHistory");
		LOGGER.info("Making a Request to Dao to get data");
//	Collection<DataImportHistoryDto> dtoobj=dataImportHistoryDao.getUpdateHistory();
//	String Path=null;
//	 for(DataImportHistoryDto x:dtoobj)
//	  
//	 {
//	  String FileName=x.getCSVName();
//	  Path = ("C:\\Users\\Rachit goyal\\Desktop\\").concat(FileName);
//	 }
	 return dataImportHistoryDao.getUpdateHistory();
//	 return (Path);
		}
}

