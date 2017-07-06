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
import com.skill.India.dto.ValidateEmployerCSVDto;

@Service
public class ValidateEmployerCSVService {

	public static String validateEmployerCSV( String employerCSVFileName) throws IOException{
		CSVReader employerCSVReader=null;
		try{
			ColumnPositionMappingStrategy strategy=new ColumnPositionMappingStrategy();
			strategy.setType(ValidateEmployerCSVDto.class);
			String [] employerCSVColumns=new String[]{"employerID","employerName","locationOfEmployer","locationOfEmployerDistrict","locationOfEmployerState"};
		strategy.setColumnMapping(employerCSVColumns);
		//String employerCSVFileName = "D:\\EclipseWorkspace\\Employer.csv";
		employerCSVReader=new CSVReader(new FileReader(employerCSVFileName),',','"',2);
		CsvToBean<ValidateEmployerCSVDto> employerCSVToBean=new CsvToBean<ValidateEmployerCSVDto>();
		List<ValidateEmployerCSVDto> employerCSVDataList= employerCSVToBean.parse(strategy,employerCSVReader);
		int recordCount=0;
		int errorExist=0;
		String errorListAllRecords="";
		for(ValidateEmployerCSVDto employerCSVData :employerCSVDataList)
		{	
			recordCount++;
			int errorStatus=0;
			String errorString="";
		
			String employerID=employerCSVData.getEmployerID();
			String employerName=employerCSVData.getEmployerName();
			String locationOfEmployer=employerCSVData.getLocationOfEmployer();
			String locationOfEmployerDistrict=employerCSVData.getLocationOfEmployerDistrict();
			String locationOfEmployerState=employerCSVData.getLocationOfEmployerState();
			
			/*
			 * Checking for Mandatory fields 
			 */
			
			if(employerID.equals("") || employerName.equals("") || locationOfEmployer.equals("")
			|| locationOfEmployerDistrict.equals("") || locationOfEmployerState.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Mandatory fields cannot be Empty ";
			}
			
			/*
			 * Checking for error in employerID column 
			 */
			
			if(!ValidationUtils.numbersCheck(employerID))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'employerID' column ";
			}
			
			/*
			 * Checking for error in employerName column 
			 */

			if(!ValidationUtils.lettersCheck(employerName))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'employerName' column ";
			}

			/*
			 * Checking for error in locationOfEmployerDistrict column 
			 */

			if(!ValidationUtils.lettersCheck(locationOfEmployerDistrict))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'locationOfEmployerDistrict' column ";
			}
			
			/*
			 * Checking for error in locationOfEmployerState column 
			 */
			
			if(!ValidationUtils.lettersCheck(locationOfEmployerState))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'locationOfEmployerState' column ";
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
		employerCSVReader.close();
		File deleteUploadedFile = new File(employerCSVFileName);
	    deleteUploadedFile.delete();
		return errorListAllRecords;
		}
		}
		catch(Exception e)
		{
			employerCSVReader.close();
			File deleteUploadedFile = new File(employerCSVFileName);
			deleteUploadedFile.delete();
			e.printStackTrace();
			return "Error Occurred while Uploading the File";
		}
		return "Successfully Uploaded CSV File";
	}
}