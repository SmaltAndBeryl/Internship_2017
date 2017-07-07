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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class SaveUploadedFileService {
	
	@Autowired
	private CheckTypeOfCSVService checkTypeOfService;

	public String saveUploadedFile(MultipartFile file,String type)
	{	 
		String UPLOADED_FOLDER = "D://EclipseWorkspace//";
		
		if (file.isEmpty()) {
            return "Uploaded file is empty. Kindly upload a valid file";
        }
		
		try {
			Timestamp timeStamp=new Timestamp(System.currentTimeMillis());
	           int seconds=timeStamp.getSeconds();
	           int minutes=timeStamp.getMinutes();
	           int hours=timeStamp.getHours();
	           int day=timeStamp.getDay();
	           int month=timeStamp.getMonth();
	           int year=timeStamp.getYear();
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
           
           return checkTypeOfService.checkTypeOfCSV(type, pathOfUploadedFile);
        
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
