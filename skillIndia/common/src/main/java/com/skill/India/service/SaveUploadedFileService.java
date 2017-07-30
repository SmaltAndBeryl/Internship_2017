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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.skill.India.common.ReadApplicationConstants;

@Service
public class SaveUploadedFileService {
	
	@Autowired
	private CheckTypeOfCSVService checkTypeOfService;
	
	@Autowired
	private ReadApplicationConstants readApplicationConstants;

	public String saveUploadedFile(MultipartFile file,String type,String userId)
	{	 
		String UPLOADED_FOLDER = readApplicationConstants.getSaveCSVAtLocation();
		
		if (file.isEmpty()) {
            return "Uploaded file is empty. Kindly upload a valid file";
        }
		
		try {
			LocalDateTime getDateAndTime = LocalDateTime.now();
			int year = getDateAndTime.getYear();
			int month = getDateAndTime.getMonthValue();
			int day = getDateAndTime.getDayOfMonth();
			int hours = getDateAndTime.getHour();
			int minutes = getDateAndTime.getMinute();
			int seconds = getDateAndTime.getSecond();
			
	           String fileNameReceived=file.getOriginalFilename();
	           int indexOfDot=fileNameReceived.indexOf(".");
	           
	           byte[] bytes = file.getBytes();
	           
	       String[] fileNameArray={fileNameReceived.substring(0, indexOfDot),
        		   fileNameReceived.substring(indexOfDot)};
	                  
           String fileNameToBeSaved=fileNameArray[0]+"-"+ year+ "-" + month + "-" + day + 
        		   "-" + hours + "-" + minutes + "-" + seconds +fileNameArray[1];
           
           Path path = Paths.get(UPLOADED_FOLDER +fileNameToBeSaved);
           
           String pathOfUploadedFile=UPLOADED_FOLDER+fileNameToBeSaved;
           
           try{
           Files.write(path, bytes);
           }
           catch(Exception e)
           {
        	   return "Error Saving file on Local Machine.Try Again later ";
           }
           
           return checkTypeOfService.checkTypeOfCSV(type,pathOfUploadedFile,userId,fileNameToBeSaved);
        
           /* for saving a message in session or on server side
           redirectAttributes.addFlashAttribute("message",
           "You successfully uploaded '" + file.getOriginalFilename() + "'");
			*/
           
       } 
      catch (Exception e) {
           e.printStackTrace();
           return "Error uploading CSV File. Kindly try again.";
       }
    
	}

}
