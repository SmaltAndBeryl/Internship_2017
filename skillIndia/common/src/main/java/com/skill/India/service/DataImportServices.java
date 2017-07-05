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

	public Collection<DataImportHistoryDto> getUpdateHistory() {
	   return dataImportHistoryDao.getUpdateHistory();
	}

}
