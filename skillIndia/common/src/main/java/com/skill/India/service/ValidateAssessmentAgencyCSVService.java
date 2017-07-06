package com.skill.India.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

import com.skill.India.common.ValidationUtils;
import com.skill.India.dao.DataImportAssessmentAgencyDao;
import com.skill.India.dto.ValidateAssessmentAgencyCSVDto;
import com.skill.India.dto.ValidateCentreCSVDto;

@Service
public class ValidateAssessmentAgencyCSVService {
	
	@Autowired
	private DataImportAssessmentAgencyDao dataImportAssessmentAgencyDao;
	
	public String validateAssessmentAgencyCSV(String assessmentAgencyCSVFileName) throws IOException{
		CSVReader assessmentAgencyCSVReader=null;
		System.out.println("In service");
		Map<String,Object> record=new HashMap<String, Object>();
		ArrayList<Map<String,Object>> arrayOfRecords= new ArrayList<Map<String,Object>>();
		try{
			System.out.println("In try of service");
			ColumnPositionMappingStrategy strategy=new ColumnPositionMappingStrategy();
			strategy.setType(ValidateAssessmentAgencyCSVDto.class);
			String [] assessmentAgencyCSVColumns=new String[]{"agencyID","agencyName"};
		strategy.setColumnMapping(assessmentAgencyCSVColumns);
		System.out.println("In try of after column mapping service");
	//	String assessmentAgencyCSVFileName = "D:\\EclipseWorkspace\\Assessment_Agency.csv";
		assessmentAgencyCSVReader=new CSVReader(new FileReader(assessmentAgencyCSVFileName),',','"',2);
		CsvToBean<ValidateAssessmentAgencyCSVDto> assessmentAgencyCSVToBean=new CsvToBean<ValidateAssessmentAgencyCSVDto>();
		List<ValidateAssessmentAgencyCSVDto> assessmentAgencyCSVDataList= assessmentAgencyCSVToBean.parse(strategy,assessmentAgencyCSVReader);
		int recordCount=0;
		int errorExist=0;
		String errorListAllRecords="";
		System.out.println("In try of service before for");
		for(ValidateAssessmentAgencyCSVDto assessmentAgencyCSVData :assessmentAgencyCSVDataList)
		{
			recordCount++;
			int errorStatus=0;
			String errorString="";
			
			String agencyID=assessmentAgencyCSVData.getAgencyID();
			String agencyName=assessmentAgencyCSVData.getAgencyName();
			
			/*
			 * Checking for Mandatory fields 
			 */
			
			System.out.println("In try of service in for");
			
			if(agencyID.equals("") || agencyName.equals(""))
			{
				errorStatus=1;
				errorString=errorString + "Mandatory fields cannot be Empty ";	
			}
			
			/*
			 * Checking for error in agencyID column 
			 */
			
			if(!ValidationUtils.numbersCheck(agencyID))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'agencyID' column ";
			}
			
			/*
			 * Checking for error in agencyName column 
			 */
			
			if(ValidationUtils.numbersCheck(agencyName))
			{
				errorStatus=1;
				errorString=errorString + "Error in 'agencyName' column ";
			}
			
			if(errorStatus==1)
			{
				errorExist=1;
				errorString="Error in Record "+recordCount + "." + errorString;
				errorListAllRecords=errorListAllRecords+errorString;
				
			}
			else 
			{
				agencyName=agencyName.toLowerCase();
				
				record.put("agencyID",agencyID);
				record.put("agencyName",agencyName);
				arrayOfRecords.add(record);
			}
		}  // end of for 
		
		/*
		 * If error exist then throw error else transport data to DAO to insert into database
		 */
		
		if(errorExist==1)
			{
			assessmentAgencyCSVReader.close();
			File deleteUploadedFile = new File(assessmentAgencyCSVFileName);
			deleteUploadedFile.delete();
			return errorListAllRecords;
			}
		else
		{
		  return dataImportAssessmentAgencyDao.dataImportAssessmentAgency(arrayOfRecords);
		}
		
		} // end of try 
		
		catch(Exception e)
		{
			assessmentAgencyCSVReader.close();
			File deleteUploadedFile = new File(assessmentAgencyCSVFileName);
			deleteUploadedFile.delete();
			e.printStackTrace();
			return "Error Occurred while Uploading the File";
		}
		
		//return "Successfully Uploaded CSV File";
	}
}
