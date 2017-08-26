/**
 * 
 */
package com.skill.India.service;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.CertificateImportHistorydao;
import com.skill.India.dto.CertificateImportHistorydto;


/**
 * @author Rachit Goyal
 *
 */
@Service
public class CertificateImportHistoryService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CertificateImportHistoryService.class);
	
	@Autowired
	private CertificateImportHistorydao certificateImportHistoryDao;
	public Collection<CertificateImportHistorydto> getUpdateHistory(){
		LOGGER.info("Request Received from Controller");
		LOGGER.info("In CertificateImportHistoryService - getUpdateHistory");
		LOGGER.info("Sending Request to service");
		return certificateImportHistoryDao.getUpdateHistory();
	}
}
