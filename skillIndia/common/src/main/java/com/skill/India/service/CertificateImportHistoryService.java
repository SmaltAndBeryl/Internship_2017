/**
 * 
 */
package com.skill.India.service;

import java.util.Collection;

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

	@Autowired
	private CertificateImportHistorydao certificateImportHistoryDao;
	public Collection<CertificateImportHistorydto> getUpdateHistory(){
		return certificateImportHistoryDao.getUpdateHistory();
	}
}
