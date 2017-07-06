package com.skill.India.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

import com.skill.India.common.ValidationUtils;
import com.skill.India.dao.DataImportAssessorDao;
import com.skill.India.dto.ValidateAssessorCSVDto;
import com.skill.India.dto.ValidateCentreCSVDto;

@Service
public class ValidateAssessorCSVService {
	
	@Autowired
	private DataImportAssessorDao dataImportAssessorDao;
	
	public String validateAssessorCSV(String assessorCSVFileName) throws IOException{
		CSVReader assessorCSVReader=null;
		
		ArrayList<Map<String,Object>> arrayOfRecords=new ArrayList<Map<String,Object>>();
		try{
			ColumnPositionMappingStrategy strategy=new ColumnPositionMappingStrategy();
			strategy.setType(ValidateAssessorCSVDto.class);
			String [] assessorCSVColumns=new String[]{"assessorID","assessorName","district","state","agencyID"};
		strategy.setColumnMapping(assessorCSVColumns);
		//String assessorCSVFileName = "D:\\EclipseWorkspace\\Assessor.csv";
		assessorCSVReader=new CSVReader(new FileReader(assessorCSVFileName),',','"',2);
		CsvToBean<ValidateAssessorCSVDto> assessorCSVToBean=new CsvToBean<ValidateAssessorCSVDto>();
		List<ValidateAssessorCSVDto> assessorCSVDataList= assessorCSVToBean.parse(strategy,assessorCSVReader);
		int recordCount=0;
		int errorExist=0;
		String errorListAllRecords="";
		for(ValidateAssessorCSVDto assessorCSVData :assessorCSVDataList)
		{
			Map<String ,Object> record=new HashMap<String, Object>();
			recordCount++;
			int errorStatus=0;
			String errorString="";
			
			String assessorID=assessorCSVData.getAssessorID();
			String assessorName=assessorCSVData.getAssessorName();
			String agencyID=assessorCSVData.getAgencyID();
			String district=assessorCSVData.getDistrict();
			String state=assessorCSVData.getState();
			
			
			/*
			 * Checking for Mandatory fields 
			 */
			
			if(assessorID.equals("") || assessorName.equals("") || agencyID.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Mandatory fields cannot be Empty .";
			}
			
			/*
			 * Checking for error in assessorID column 
			 */
			
			if(!ValidationUtils.numbersCheck(assessorID))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'assessorID' column  ";
			}
			
			/*
			 * Checking for error in assessorName column 
			 */
			
			if(ValidationUtils.numbersCheck(assessorName))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'assessorName' column  ";
			}
			
			/*
			 * Checking for error in district column 
			 */
			
			if(!ValidationUtils.lettersCheck(district))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'district' column  ";
			}
			
			/*
			 * Checking for error in state column 
			 */
			
			if(!ValidationUtils.lettersCheck(state))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'state' column  ";
			}
			/*
			 * Checking for error in agencyID column 
			 */
			
			if(!ValidationUtils.numbersCheck(agencyID))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'agencyID' column  ";
			}
			
			if(errorStatus==1)
			{
				errorExist=1;
				errorString="Error in Record "+recordCount + "." + errorString;
				errorListAllRecords=errorListAllRecords+errorString;
				
			}
			else 
			{
				assessorName=assessorName.toLowerCase();
				district=district.toLowerCase();
				state=state.toLowerCase();
				
				record.put("assessorID",assessorID);
				record.put("assessorName",assessorName);
				record.put("district",district);
				record.put("state",state);
				record.put("agencyID",agencyID);
				arrayOfRecords.add(record);
				System.out.println(arrayOfRecords + "      " +record);
			}
			
			//System.out.println(arrayOfRecords);
		}
		System.out.println(arrayOfRecords);
		if(errorExist==1)
		{
		assessorCSVReader.close();
		File deleteUploadedFile = new File(assessorCSVFileName);
	    deleteUploadedFile.delete();
		return errorListAllRecords;
		}
		
		
		System.out.println("                        "+arrayOfRecords);
		
		}
		catch(Exception e)
		{
			assessorCSVReader.close();
			File deleteUploadedFile = new File(assessorCSVFileName);
			deleteUploadedFile.delete();
			e.printStackTrace();
			return "Error Occurred while Uploading the File";		
		}
			
		//System.out.println("                  "+arrayOfRecords);
		int statusOfForeignKey= dataImportAssessorDao.dataImportAssessorForeignKeyConstraintCheck(arrayOfRecords);
		
		
		if(statusOfForeignKey==0)
		{
			/*
			 * foreign key doesn't exist in Assessment Agency record 
			 * throw error  
			 */		

			return "Error in agencyID column. Kindly recheck the details ."
			+ "agencyID not found in Assessment Agency record .";
		}
		else if(statusOfForeignKey==1)
		{
			// forward control to check primary key constraint 
			return dataImportAssessorDao.dataImportAssessorPrimaryKeyConstraintCheck(arrayOfRecords);
				
		}
		else 
		{
			/*
			 * Exception occurs while checking foreign key constraint 
			 */
			return "Error storing data in Database .Kindly try again .";
		}
		
	//	return "Successfully Uploaded CSV File";
	}
}