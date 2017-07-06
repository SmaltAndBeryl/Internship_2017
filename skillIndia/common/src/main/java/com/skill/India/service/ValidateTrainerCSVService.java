package com.skill.India.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

import com.skill.India.common.ValidationUtils;
import com.skill.India.dto.ValidateCentreCSVDto;
import com.skill.India.dto.ValidateTrainerCSVDto;

@Service
public class ValidateTrainerCSVService {
	
	public static String validateTrainerCSV(String trainerCSVFileName) throws IOException{
		CSVReader trainerCSVReader=null;
		try{
			ColumnPositionMappingStrategy strategy=new ColumnPositionMappingStrategy();
			strategy.setType(ValidateTrainerCSVDto.class);
			String [] trainerCSVColumns=new String[]{"trainerID","trainerName","designation","trainingPartnerID"};
		strategy.setColumnMapping(trainerCSVColumns);
		// String trainerCSVFileName = "D:\\EclipseWorkspace\\Trainer.csv";
		trainerCSVReader=new CSVReader(new FileReader(trainerCSVFileName),',','"',2);
		CsvToBean<ValidateTrainerCSVDto> trainerCSVToBean=new CsvToBean<ValidateTrainerCSVDto>();
		List<ValidateTrainerCSVDto> trainerCSVDataList= trainerCSVToBean.parse(strategy,trainerCSVReader);
		int recordCount=0;
		int errorExist=0;
		String errorListAllRecords="";
		for(ValidateTrainerCSVDto trainerCSVData :trainerCSVDataList)
		{
			recordCount++;
			int errorStatus=0;
			String errorString="";
			
			String trainerID=trainerCSVData.getTrainerID();
			String trainerName=trainerCSVData.getTrainerName();
			String designation=trainerCSVData.getDesignation();
			String trainingPartnerID=trainerCSVData.getTrainingPartnerID();
		
		
			/*
			 * Checking for Empty fields 
			 */
			if(trainerID.equals("") || trainerName.equals("") || designation.equals("")
					|| trainingPartnerID.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Mandatory fields cannot be Empty ";
			}
			
			/*
			 * Checking for error in trainerID column 
			 */
			
			if(!ValidationUtils.numbersCheck(trainerID))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'trainerID' column .";
			}
			
			/*
			 * Checking for error in trainerName column 
			 */
			
			if(ValidationUtils.numbersCheck(trainerName))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'trainerName' column .";
			}
			
			/*
			 * Checking for error in designation column 
			 */
			
			if(ValidationUtils.numbersCheck(designation))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'designation' column .";
			}
			
			/*
			 * Checking for error in trainingPartnerID column 
			 */
			
			if(!ValidationUtils.numbersCheck(trainingPartnerID))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'trainingPartnerID' column .";
			}
			if(errorStatus==1)
			{
				errorExist=1;
				errorString="Error in Record "+recordCount + "." + errorString;
				errorListAllRecords=errorListAllRecords+errorString;
				
			}
			
		}
		
		if(errorExist==1)
		{
		trainerCSVReader.close();
		File deleteUploadedFile = new File(trainerCSVFileName);
	    deleteUploadedFile.delete();
		return errorListAllRecords;
		}
		}
		catch(Exception e)
		{
			trainerCSVReader.close();
			File deleteUploadedFile = new File(trainerCSVFileName);
			deleteUploadedFile.delete();
			e.printStackTrace();
			return "Error Occurred while Uploading the File";
		}
		return "Successfully Uploaded CSV File";
	}
}