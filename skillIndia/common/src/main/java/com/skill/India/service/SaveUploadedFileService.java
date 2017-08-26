package com.skill.India.service;
/*
 * Author 		: Ruchit Jain
 * Description  : This file stores the uploaded csv on local machine whose path is 
 * 				  hard coded (name of file is changed, timestamp appended). 
 * 
 */
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.skill.India.common.ReadApplicationConstants;

@Service
public class SaveUploadedFileService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SaveUploadedFileService.class);
	
	@Autowired
	private CheckTypeOfCSVService checkTypeOfService;
	
	@Autowired
	private ReadApplicationConstants readApplicationConstants;

	public String saveUploadedFile(MultipartFile file,String type,String userId)
	{	 
		LOGGER.info("Request Received from Controller");
		LOGGER.info("In SaveUploadedFileService - saveUploadedFile");
		LOGGER.info("Parameters Received from front end are - 'file': "+file+" 'type': "+type+" 'userId': ",userId);
		LOGGER.info("Setting CONSTANT path for saving the uploaded file on local machine");
		String UPLOADED_FOLDER = readApplicationConstants.getSaveCSVAtLocation();
		
		if (file.isEmpty()) {
			LOGGER.info("The inputted file is empty");
			LOGGER.info("Returning with error message as String");
            return "Uploaded file is empty. Kindly upload a valid file";
        }
		
		try {
			LOGGER.info("In TRY block");
			LOGGER.info("Creating LocalDateTime object");
			LocalDateTime getDateAndTime = LocalDateTime.now();
			LOGGER.info("Successfully created and initialized");
			int year = getDateAndTime.getYear();
			int month = getDateAndTime.getMonthValue();
			int day = getDateAndTime.getDayOfMonth();
			int hours = getDateAndTime.getHour();
			int minutes = getDateAndTime.getMinute();
			int seconds = getDateAndTime.getSecond();
			
	           String fileNameReceived=file.getOriginalFilename();
	           int indexOfDot=fileNameReceived.indexOf(".");
	           LOGGER.info("Creating byte array object to write file");
	           byte[] bytes = file.getBytes();
	           LOGGER.info("Successfully Created and Initialized");
	           
	           
	       String[] fileNameArray={fileNameReceived.substring(0, indexOfDot),
        		   fileNameReceived.substring(indexOfDot)};
	                  
           String fileNameToBeSaved=fileNameArray[0]+"-"+ year+ "-" + month + "-" + day + 
        		   "-" + hours + "-" + minutes + "-" + seconds +fileNameArray[1];
           
           Path path = Paths.get(UPLOADED_FOLDER +fileNameToBeSaved);
           
           String pathOfUploadedFile=UPLOADED_FOLDER+fileNameToBeSaved;
           
           try
           {
        	   LOGGER.info("Inside TRY block");
        	   LOGGER.info("Writing file");
        	   Files.write(path, bytes);
        	   LOGGER.info("Exiting TRY block");
           }
           catch(Exception e)
           {
        	   LOGGER.info("In CATCH block");
        	   LOGGER.error("ERROR: Encountered an Exception - ",e);
   			   return "Error Saving file on Local Machine.Try Again later ";
           }
           LOGGER.info("Sending Request to service to check its type");
           return checkTypeOfService.checkTypeOfCSV(type,pathOfUploadedFile,userId,fileNameToBeSaved);
        
           /* for saving a message in session or on server side
           redirectAttributes.addFlashAttribute("message",
           "You successfully uploaded '" + file.getOriginalFilename() + "'");
			*/
           
       } 
      catch (Exception e) {
    	  	LOGGER.info("In CATCH block");
			LOGGER.error("ERROR: Encountered an Exception - ",e);
			e.printStackTrace();
			return "Error uploading CSV File. Kindly try again.";
       }
    
	}

}
