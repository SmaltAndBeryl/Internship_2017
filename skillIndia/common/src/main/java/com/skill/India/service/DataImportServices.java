package com.skill.India.service;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dto.DataImportHistoryDto;

import com.skill.India.dao.DataImportHistoryDao;




@Service
public class DataImportServices {
	
	@Autowired
	private DataImportHistoryDao dataImportHistoryDao;
	public Collection<DataImportHistoryDto> getUpdateHistory(){
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

