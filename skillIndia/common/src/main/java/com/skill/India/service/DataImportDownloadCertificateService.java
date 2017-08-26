package com.skill.India.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.common.ReadApplicationConstants;

@Service
public class DataImportDownloadCertificateService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataImportDownloadCertificateService.class);
	
	@Autowired
	private ReadApplicationConstants readApplicationConstants;
	
	public void dataImportDownloadCertificate(HttpServletResponse response,String fileName)
	{
		LOGGER.info("Request Received from Controller");
		LOGGER.info("In DataImportDownloadCertificateService - dataImportDownloadCertificate");
		try 
		{
			LOGGER.info("In TRY block");
			LOGGER.info("Creating path to download the ZIP certificates");
			String pathOfZipFile=readApplicationConstants.getSaveCertificateAtLocation()+fileName+".zip";
			LOGGER.info("Path created is : ",pathOfZipFile);
			LOGGER.info("Creating FileInputStream object");
			FileInputStream is = new FileInputStream(new File(pathOfZipFile));
			LOGGER.info("Successfully Created and Initialized");
			LOGGER.info("Setting the contentType to : application/zip");
	    	response.setContentType("application/zip");
	    	LOGGER.info("Setting the Header - Content-disposition", "attachment; filename="+ fileName+".zip");
	    	response.setHeader("Content-disposition", "attachment; filename="+ fileName+".zip");
	    	LOGGER.info("Successfully Created and Initialized");
	    	LOGGER.info("Sending the OutputStream of the file - ZIP certificates");
	    	org.apache.commons.io.IOUtils.copy(is,response.getOutputStream());
			LOGGER.info("Exiting TRY block");
	    } 
		catch (IOException ex) 
		{
			LOGGER.info("In CATCH block");
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Throwing new RuntimeException");
			LOGGER.error("Exception is :"+ex);
			
	      throw new RuntimeException("IOError writing file to output stream");
	    }
		catch (Exception e) {
			LOGGER.info("In CATCH block");
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is :"+e);
			
			// Error message 
		}
	}
}
