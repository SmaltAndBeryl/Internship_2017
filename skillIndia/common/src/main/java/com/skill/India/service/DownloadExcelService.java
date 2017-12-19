package com.skill.India.service;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.DownloadExcelDao;
import com.skill.India.dto.DownloadExcelDto;

@Service
public class DownloadExcelService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DownloadExcelService.class);
	
	@Autowired
	private DownloadExcelDao updateDao;
	public String getUpdateRowMapper(){
		LOGGER.debug("Request Received from controller");
		LOGGER.debug("In DownloadExcelService - getUpdateRowMapper");
		
		LOGGER.debug("Creating Collection object");
		LOGGER.debug("Initializing object");
		LOGGER.debug("Making a Request to Dao to get data");
		Collection<DownloadExcelDto> dtoobj= updateDao.getUpateRowMapper() ;
		LOGGER.debug("Response received from Dao");
		
	for(DownloadExcelDto x:dtoobj)
		
	{
		LOGGER.debug("Iterating object data");
		String abc=x.getCSVLocation();
	}
	
	
	return "success";
	}
}