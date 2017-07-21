package com.skill.India.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.skill.India.dao.DataImportCertificateDao;

@Service
public class SaveCertificateFileService {
	
	@Autowired
	private DataImportCertificateDao dataImportCertificateDao;
	
	public String saveUploadedFile(MultipartFile file,Integer batchId,String userId)
	{
	String UPLOADED_FOLDER = "E://EclipseWorkspace//";
	String pathOfUploadedFile="";
	String fileNameReceived="";
	String fileNameToBeSaved="";
	
	try {

           fileNameReceived=file.getOriginalFilename();
           int indexOfDot=fileNameReceived.indexOf(".");
           
          
           
       String[] fileNameArray={fileNameReceived.substring(0, indexOfDot),
    		   fileNameReceived.substring(indexOfDot)};
                  
       fileNameToBeSaved=fileNameArray[0]+ batchId +fileNameArray[1];
       if(!fileNameArray[1].equals(".zip"))
       {
    	   return "Kindly Upload a .zip file";
       }
       
       Path path = Paths.get(UPLOADED_FOLDER +fileNameToBeSaved);
       pathOfUploadedFile=UPLOADED_FOLDER+fileNameToBeSaved;
       
       File checkFileExistence = new File(pathOfUploadedFile);
       if(checkFileExistence.exists() && !checkFileExistence.isDirectory()) 
       { 
        File deleteUploadedFile = new File(pathOfUploadedFile);
        deleteUploadedFile.delete();
       }
       
       
       byte[] bytes = file.getBytes();
       try{
       Files.write(path, bytes);
       }
       catch(Exception e)
       {
    	   e.printStackTrace();
    	   return "Error Saving file on Local Machine.Try Again later ";
       }
       
	}
	catch (Exception e) {
	       e.printStackTrace();
	       File deleteUploadedFile = new File(pathOfUploadedFile);
   		   deleteUploadedFile.delete();
	       return "Error uploading Zip File. Kindly try again.";
	   }
        
		/*
		 * Inserting data in csvUploaded  Table
		 */		
		
	try{
	   	Date date=new Date(System.currentTimeMillis());
		
		Map<String,Object> uploadedFileInfo= new HashMap<String, Object>();
		
		uploadedFileInfo.put("certificateName",fileNameToBeSaved);
		uploadedFileInfo.put("batchId",batchId);
		uploadedFileInfo.put("certificateUploadDate",date);
		uploadedFileInfo.put("userId",userId);
		
		
		/*
		 * Checking for valid UserId (Foreign key constraint)
		 */
		
		int status=dataImportCertificateDao.dataImportCertificateForeignKeyConstraintCheck(uploadedFileInfo);
		if(status==0 || status==2)
		{
		File deleteUploadedFile = new File(pathOfUploadedFile);
		deleteUploadedFile.delete();	
		return "Invalid User or BatchId Id . Action Aborted";	
		}
			
		int insertDataStatus=dataImportCertificateDao.insertDataInCertificate(uploadedFileInfo);
		if(!(insertDataStatus>0))
		{
		File deleteUploadedFile = new File(pathOfUploadedFile);
		deleteUploadedFile.delete();
		return "Some Error occured while inserting data in 'certificate uploaded by' table . Kindly try again ."; 
		}
		
		return "Certificate successfully uploaded .";	
   } 
	
		catch(Exception e)
		{
			e.printStackTrace();
			File deleteUploadedFile = new File(pathOfUploadedFile);
	   		deleteUploadedFile.delete();
			return "Error updating data of Uploader .Kindly try again .";
		}
}
}
