package com.skill.India.controller;

//import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.service.DownloadExcelService;
//import com.skill.India.dto.DownloadExcelDto;


@RestController
public class DownloadExcelController {
	
	@Autowired
	private DownloadExcelService downloadExcelService;
	
	@RequestMapping("/DownloadExcel")
	public String getDownloadExcelDto () {
		return downloadExcelService.getUpdateRowMapper();
	}
	

}