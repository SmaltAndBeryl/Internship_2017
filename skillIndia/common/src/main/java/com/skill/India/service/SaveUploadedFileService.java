package com.skill.India.service;

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
		/*
		 * Referred http://www.mkyong.com/spring-boot/spring-boot-file-upload-example/
		 */
		
		
		/*
		 * Hard-code the path of file here		
		 */
		
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
           
           System.out.println("In save uploaded file ");
           return checkTypeOfService.checkTypeOfCSV(type, pathOfUploadedFile);
        

           /* for saving a message in session or on server side
           redirectAttributes.addFlashAttribute("message",
           "You successfully uploaded '" + file.getOriginalFilename() + "'");
			*/
           /*
           
           // CODE TO DELETE THE FILE 
           File file1 = new File(UPLOADED_FOLDER +fileNameToBeSaved);
           file1.delete();
           
           */
       } 
      catch (Exception e) {
       //    e.printStackTrace();
           return "Error uploading CSV File. Kindly try again.";
       }
    
	}

}
