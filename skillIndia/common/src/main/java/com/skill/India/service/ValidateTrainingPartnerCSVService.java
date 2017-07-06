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
import com.skill.India.dto.ValidateTrainingPartnerCSVDto;

@Service
public class ValidateTrainingPartnerCSVService {

	public static String validateTrainingPartnerCSV(String trainingPartnerCSVFileName) throws IOException{
		CSVReader trainingPartnerCSVReader=null;
		try{
			ColumnPositionMappingStrategy strategy=new ColumnPositionMappingStrategy();
			strategy.setType(ValidateTrainingPartnerCSVDto.class);
			String [] trainingPartnerCSVColumns=new String[]{"trainingPartnerID","applicationID","trainingPartnerName"};
		strategy.setColumnMapping(trainingPartnerCSVColumns);
		//String trainingPartnerCSVFileName = "D:\\EclipseWorkspace\\Training_Partner.csv";
		trainingPartnerCSVReader=new CSVReader(new FileReader(trainingPartnerCSVFileName),',','"',2);
		CsvToBean<ValidateTrainingPartnerCSVDto> trainingPartnerCSVToBean=new CsvToBean<ValidateTrainingPartnerCSVDto>();
		List<ValidateTrainingPartnerCSVDto> trainingPartnerCSVDataList= trainingPartnerCSVToBean.parse(strategy,trainingPartnerCSVReader);
		int recordCount=0;
		int errorExist=0;
		String errorListAllRecords="";
		for(ValidateTrainingPartnerCSVDto trainingPartnerCSVData :trainingPartnerCSVDataList)
		{
			recordCount++;
			int errorStatus=0;
			String errorString="";
			
			String trainingPartnerID=trainingPartnerCSVData.getTrainingPartnerID();
			String applicationID=trainingPartnerCSVData.getApplicationID();
			String trainingPartnerName=trainingPartnerCSVData.getTrainingPartnerName();
		
			
			/*
			 * Checking for Mandatory fields 
			 */
			
			if(trainingPartnerID.equals("") || applicationID.equals("") ||
					trainingPartnerName.equals("")){
				errorStatus=1;
				errorString=errorString+"Mandatory fields cannot be Empty ";
			}
			
			
			/*
			 * Checking for error in trainingPartnerID column 
			 */
			
			
			if(!ValidationUtils.numbersCheck(trainingPartnerID))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'trainingPartnerID column '";
			}
			
			/*
			 * Checking for error in applicationID column 
			 */
			
			if(!ValidationUtils.numbersCheck(applicationID))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'applicationID' column ";
			}
			
			/*
			 * Checking for error in trainingPartnerName column 
			 */
			
			if(ValidationUtils.numbersCheck(trainingPartnerName))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'trainingPartnerName' column ";
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
		trainingPartnerCSVReader.close();
		File deleteUploadedFile = new File(trainingPartnerCSVFileName);
	    deleteUploadedFile.delete();
		return errorListAllRecords;
		}
		}
		catch(Exception e){
			trainingPartnerCSVReader.close();
			File deleteUploadedFile = new File(trainingPartnerCSVFileName);
			deleteUploadedFile.delete();
			e.printStackTrace();
			return "Error Occurred while Uploading the File";
		}
		
		return "Successfully Uploaded CSV File";
	}
}