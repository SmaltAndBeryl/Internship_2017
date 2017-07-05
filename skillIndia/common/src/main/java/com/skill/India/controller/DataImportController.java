package com.skill.India.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.service.DataImportServices;




import com.skill.India.dto.DataImportHistoryDto;

@RestController
public class DataImportController{
	@Autowired
	private DataImportServices dataImportServices;
	
	@RequestMapping("/importHistory")
	public Collection<DataImportHistoryDto> getdataImportHistorydto(){
	return dataImportServices.getUpdateHistory();
}
}
