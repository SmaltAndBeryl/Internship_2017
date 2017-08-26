package com.skill.India.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.skill.India.common.ReadApplicationConstants;
import com.skill.India.dao.DataImportCertificateDao;

@Service
public class SaveCertificateFileService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SaveCertificateFileService.class);

	@Autowired
	private DataImportCertificateDao dataImportCertificateDao;
	
	@Autowired
	private ReadApplicationConstants readApplicationConstants;
	
	public String saveUploadedFile(MultipartFile file,Integer batchId,String userId)
	{
		LOGGER.info("Request Received from Controller");
		LOGGER.info("In SaveCertificateFileService - saveUploadedFile");
		LOGGER.info("Parameters Received from front end are - 'batchId': "+batchId+" 'MultipartFile': "+file+ " 'userId': ",userId);
		LOGGER.info("Initializing the default path for uploading certificates");
		String UPLOADED_FOLDER = readApplicationConstants.getSaveCertificateAtLocation();
		LOGGER.info("Successfully Initialized");
		String pathOfUploadedFile="";
		String fileNameReceived="";
		String fileNameToBeSaved="";
		
	try {
			LOGGER.info("In TRY block");
			
           fileNameReceived=file.getOriginalFilename();
           int indexOfDot=fileNameReceived.indexOf(".");
           
          
           
       String[] fileNameArray={fileNameReceived.substring(0, indexOfDot),
    		   fileNameReceived.substring(indexOfDot)};
                  
       fileNameToBeSaved=fileNameArray[0]+ batchId +fileNameArray[1];
       if(!fileNameArray[1].equals(".zip"))
       {
    	   LOGGER.info("Inside IF block");
    	   LOGGER.error("Uploaded file is not in ZIP format");
    	   LOGGER.info("Returning ERROR message string : Kindly Upload a .zip file");
    	   return "Kindly Upload a .zip file";
       }
       
       Path path = Paths.get(UPLOADED_FOLDER +fileNameToBeSaved);
       LOGGER.info("Initializing the full path with file name for uploading certificates file");
       pathOfUploadedFile=UPLOADED_FOLDER+fileNameToBeSaved;
       LOGGER.info("Path is - ",pathOfUploadedFile);
       LOGGER.info("Creating File object");
       File checkFileExistence = new File(pathOfUploadedFile);
       LOGGER.info("Successfully Created and Initialized");
       LOGGER.info("Checking if file already exists");
       if(checkFileExistence.exists() && !checkFileExistence.isDirectory()) 
       {
    	   LOGGER.info("Creating File object for deleting file");
        File deleteUploadedFile = new File(pathOfUploadedFile);
        LOGGER.info("Successfully Created and Initialized");
        LOGGER.info("Initializing delete request");
        deleteUploadedFile.delete();
        LOGGER.info("Successfully Deleted");
       }
       
       LOGGER.info("Creating byte array object to write file");
       byte[] bytes = file.getBytes();
       LOGGER.info("Successfully Created and Initialized");
       try{
    	   LOGGER.info("Inside TRY block");
    	   LOGGER.info("Writing file");
       Files.write(path, bytes);
       LOGGER.info("Exiting TRY block");
       }
       catch(Exception e)
       {
    	   LOGGER.info("In CATCH block");
			LOGGER.error("ERROR: Encountered an Exception - ",e);
			e.printStackTrace();
    	   return "Error Saving file on Local Machine.Try Again later ";
       }
       
	}
	catch (Exception e) {
	       e.printStackTrace();
	       LOGGER.info("Creating File object for deleting file");
	       File deleteUploadedFile = new File(pathOfUploadedFile);
	       LOGGER.info("Initializing delete request");
	       deleteUploadedFile.delete();
	       LOGGER.info("Successfully Deleted");
	       return "Error uploading Zip File. Kindly try again.";
	   }
        
		/*
		 * Inserting data in csvUploaded  Table
		 */		
		
	try{
		LOGGER.info("Inside TRY block");
		LOGGER.info("Creating Date object");
		Date date=new Date(System.currentTimeMillis());
		LOGGER.info("Successfully created and initialized");
		LOGGER.info("Creating HashMap object");
		Map<String,Object> uploadedFileInfo= new HashMap<String, Object>();
		LOGGER.info("Successfully created");
		LOGGER.info("Inserting data into HashMap created");
		uploadedFileInfo.put("certificateName",fileNameToBeSaved);
		uploadedFileInfo.put("batchId",batchId);
		uploadedFileInfo.put("certificateUploadDate",date);
		uploadedFileInfo.put("userId",userId);
		
		
		/*
		 * Checking for valid UserId (Foreign key constraint)
		 */
		LOGGER.info("Making a Request to Dao to get data");
		int status=dataImportCertificateDao.dataImportCertificateForeignKeyConstraintCheck(uploadedFileInfo);
		LOGGER.info("Response received from Dao");
		if(status==0 || status==2)
		{
			LOGGER.info("Foreign Key Constraint check Failed");
			LOGGER.info("Creating File object for deleting file");
		File deleteUploadedFile = new File(pathOfUploadedFile);
		LOGGER.info("Successfully created and initialized");
		LOGGER.info("Initializing delete request");
		deleteUploadedFile.delete();	
		LOGGER.info("Successfully Deleted");
		return "Invalid User or BatchId Id . Action Aborted";	
		}
		
		LOGGER.info("Making a Request to Dao to get data");
		int insertDataStatus=dataImportCertificateDao.insertDataInCertificate(uploadedFileInfo);
		LOGGER.info("Response received from Dao");
		if(!(insertDataStatus>0))
		{
			LOGGER.info("Unable to insert the details into table - deleting file");
			LOGGER.info("Creating File object for deleting file");
		
		File deleteUploadedFile = new File(pathOfUploadedFile);
		LOGGER.info("Successfully created and initialized");
		LOGGER.info("Initializing delete request");
		deleteUploadedFile.delete();
		LOGGER.info("Successfully Deleted");
		return "Some Error occured while inserting data in 'certificate uploaded by' table . Kindly try again ."; 
		}
		
		return "Certificate successfully uploaded .";	
   } 
	
		catch(Exception e)
		{
			LOGGER.info("In CATCH block");
			LOGGER.error("ERROR: Encountered an Exception - ",e);
						e.printStackTrace();
			LOGGER.info("Creating File object for deleting file");
			File deleteUploadedFile = new File(pathOfUploadedFile);
			LOGGER.info("Successfully created and initialized");
			LOGGER.info("Initializing delete request");
			deleteUploadedFile.delete();
			LOGGER.info("Successfully Deleted");
			return "Error updating data of Uploader .Kindly try again .";
		}
}
}
