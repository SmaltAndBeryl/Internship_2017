package com.skill.India.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.DataImportFindBatchUsingBatchId;
import com.skill.India.dto.DataImportGetBatchInfoDto;

@Service
public class FindBatchUsingBatchIdService {

	@Autowired
	private DataImportFindBatchUsingBatchId dataImportFindBatchUsingBatchId;
	
	public Collection<DataImportGetBatchInfoDto> findBatchUsingBatchId(String batchId){
		
		return dataImportFindBatchUsingBatchId.getDataOfBatchUsingBatchId(batchId);
		
	}
}
