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

@Service
public class ValidateCentreCSVService {

	public static String validateCentreCSV(String centreCSVFileName) throws IOException{
		CSVReader centreCSVReader=null;
		try{
			ColumnPositionMappingStrategy strategy=new ColumnPositionMappingStrategy();
			strategy.setType(ValidateCentreCSVDto.class);
			String [] centreCSVColumns=new String[]{"centreID","centreName","centrePOCContactname","centreAddress","district","state","trainingPartnerID"};
		strategy.setColumnMapping(centreCSVColumns);
		//String centreCSVFileName = "D:\\EclipseWorkspace\\Centre.csv";
		centreCSVReader=new CSVReader(new FileReader(centreCSVFileName),',','"',2);
		CsvToBean<ValidateCentreCSVDto> centreCSVToBean=new CsvToBean<ValidateCentreCSVDto>();
		List<ValidateCentreCSVDto> centreCSVDataList= centreCSVToBean.parse(strategy,centreCSVReader);
		int recordCount=0;
		int errorExist=0;
		String errorListAllRecords="";
		for(ValidateCentreCSVDto centreCSVData :centreCSVDataList)
		{
			recordCount++;
			int errorStatus=0;
			String errorString="";
			
			String centreID=centreCSVData.getCentreID(); 
			String centreName=centreCSVData.getCentreName();
			String centrePOCContactname=centreCSVData.getCentrePOCContactname();
			String centreAddress=centreCSVData.getCentreAddress();
			String district=centreCSVData.getDistrict();
			String state=centreCSVData.getState();
			String trainingPartnerID=centreCSVData.getTrainingPartnerID();
		

			/*
			 * Checking for Mandatory fields 
			 */
			
			if(centreID.equals("") || centreName.equals("") || centrePOCContactname.equals("")
					|| centreAddress.equals("") || district.equals("") || state.equals("") ||
					trainingPartnerID.equals("")){
				
				errorStatus=1;
				errorString=errorString+ "Mandatory fields cannot be Empty";
			}
			
			

			/*
			 * Checking for error in centreID column 
			 */
			
			if(!ValidationUtils.numbersCheck(centreID))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'centerID' column ";
			}

			/*
			 * Checking for error in centreName column 
			 */
			
			if(ValidationUtils.numbersCheck(centreName))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'centreName' column ";
			}
			
			/*
			 * Checking for error in centrePOCContactName column 
			 */
			
			if(ValidationUtils.numbersCheck(centrePOCContactname))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'centrePOCContactName' column ";
			}
			
			/*
			 * Checking for error in district column 
			 */
			
			if(!ValidationUtils.lettersCheck(district))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'district' column ";
			}

			/*
			 * Checking for error in state column 
			 */
			
			if(!ValidationUtils.lettersCheck(state))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'state' column ";
			}
			
			/*
			 * Checking for error in trainingPartnerID column 
			 */
			
			if(!ValidationUtils.numbersCheck(trainingPartnerID))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'trainingPartnerID' column ";
			}
			
			if(errorExist==1)
			{
			centreCSVReader.close();
			File deleteUploadedFile = new File(centreCSVFileName);
		    deleteUploadedFile.delete();
			return errorListAllRecords;
			}
			
		}
		}
		catch(Exception e)
		{
			centreCSVReader.close();
			File deleteUploadedFile = new File(centreCSVFileName);
			deleteUploadedFile.delete();
			e.printStackTrace();
			return "Error Occurred while Uploading the File";
		}
		return "Successfully Uploaded CSV File";
	}
}

