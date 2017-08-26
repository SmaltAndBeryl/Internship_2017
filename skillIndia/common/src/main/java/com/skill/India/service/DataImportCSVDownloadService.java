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
public class DataImportCSVDownloadService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DataImportCSVDownloadService.class);

	@Autowired
	private ReadApplicationConstants readApplicationConstants;


	public void DataImportCSVDownload(HttpServletResponse response,String fileName)
	{
		LOGGER.info("Request Received from Controller");
		LOGGER.info("In DataImportCSVDownloadService - DataImportCSVDownload");
		
	    try {
	    	LOGGER.info("In TRY block");
			LOGGER.info("Creating path to download the CSV");
			String pathOfCSV=readApplicationConstants.getSaveCSVAtLocation()+fileName+".csv";
			LOGGER.info("Path created is : ",pathOfCSV);
			LOGGER.info("Creating FileInputStream object");
			FileInputStream is = new FileInputStream(new File(pathOfCSV));
			LOGGER.info("Successfully Created and Initialized");
			LOGGER.info("Sending the OutputStream of the file - csv");
	        org.apache.commons.io.IOUtils.copy(is,response.getOutputStream());
	        LOGGER.info("Setting the contentType to : application/x-rar-compressed");
	        response.setContentType("application/x-rar-compressed");
	        LOGGER.info("Setting the Header - Content-disposition", "attachment; filename="+ fileName+".csv");
	    	response.setHeader("Content-disposition", "attachment; filename="+ fileName+".csv");
	    	LOGGER.info("Exiting TRY block");
	      } 
	    catch (IOException ex) {
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
			// ERROR PAGE 
		}

	}
}
