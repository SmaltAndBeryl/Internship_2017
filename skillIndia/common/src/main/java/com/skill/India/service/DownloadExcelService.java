package com.skill.India.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.DownloadExcelDao;
import com.skill.India.dto.DownloadExcelDto;

@Service
public class DownloadExcelService {
	@Autowired
	private DownloadExcelDao updateDao;
	public Collection<DownloadExcelDto> getUpdateRowMapper(){
		return updateDao.getUpateRowMapper() ;
	}
}