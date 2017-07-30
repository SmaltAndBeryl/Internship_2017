package com.skill.India.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.common.ReadApplicationConstants;

@Service
public class DataImportDownloadCertificateService {

	@Autowired
	private ReadApplicationConstants readApplicationConstants;
	
	public void dataImportDownloadCertificate(HttpServletResponse response,String fileName)
	{
		try {
			String pathOfZipFile=readApplicationConstants.getSaveCertificateAtLocation()+fileName+".zip";
	    	FileInputStream is = new FileInputStream(new File(pathOfZipFile));
	    	response.setContentType("application/zip");
	    	response.setHeader("Content-disposition", "attachment; filename="+ fileName+".zip");
	    	org.apache.commons.io.IOUtils.copy(is,response.getOutputStream());
	    } 
		catch (IOException ex) { 	
	      throw new RuntimeException("IOError writing file to output stream");
	    }
		catch (Exception e) {
			// Error message 
		}
	}
}
