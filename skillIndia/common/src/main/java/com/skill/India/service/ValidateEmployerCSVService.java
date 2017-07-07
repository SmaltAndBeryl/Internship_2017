package com.skill.India.service;
/*
 * Author 		: Ruchit Jain
 * Description  : For Employer .CSV Uploaded by user, This file :
 * 				 1) Checks for mandatory fields of Employer sheet
 * 				 2) Validates the data inserted in it by the user
 * 				 3) Checks for foreign key,primary key constraint	 	
 */
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
import com.skill.India.dao.DataImportEmployerDao;
import com.skill.India.dto.ValidateEmployerCSVDto;

@Service
public class ValidateEmployerCSVService {

	@Autowired
	private DataImportEmployerDao dataImportEmployerDao;
	
	public String validateEmployerCSV( String employerCSVFileName) throws IOException{
		CSVReader employerCSVReader=null;
		/*
		 * Create Array List to store the data of csv read (in Hashmap's) 
		 */
		ArrayList<Map<String,Object>> arrayOfRecords=new ArrayList<Map<String,Object>>();
		try{
		ColumnPositionMappingStrategy strategy=new ColumnPositionMappingStrategy();
		strategy.setType(ValidateEmployerCSVDto.class);
		String [] employerCSVColumns=new String[]{"employerId","employerName","locationOfEmployer","locationOfEmployerDistrict","locationOfEmployerState"};
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
			/*
			 *  Map to store data of each row of csv read and then added to arraylist
			 */
			Map<String ,Object> record=new HashMap<String, Object>();
			recordCount++;
			int errorStatus=0;
			String errorString="";
		
			String employerId=employerCSVData.getEmployerId();
			String employerName=employerCSVData.getEmployerName();
			String locationOfEmployer=employerCSVData.getLocationOfEmployer();
			String locationOfEmployerDistrict=employerCSVData.getLocationOfEmployerDistrict();
			String locationOfEmployerState=employerCSVData.getLocationOfEmployerState();
			
			/*
			 * Checking for Mandatory fields 
			 */
			
			if(employerId.equals("") || employerName.equals("") || locationOfEmployer.equals("")
			|| locationOfEmployerDistrict.equals("") || locationOfEmployerState.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Mandatory fields cannot be Empty ";
			}
			
			/*
			 * Checking for error in employerId column 
			 */
			
			if(!ValidationUtils.numbersCheck(employerId))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'employerId' column ";
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
			else 
			{
				/*
				 * Keeping database consistent by inserting only lowercase values in it
				 */
				
				employerName=employerName.toLowerCase();
				locationOfEmployer=locationOfEmployer.toLowerCase();
				locationOfEmployerDistrict=locationOfEmployerDistrict.toLowerCase();
				locationOfEmployerState=locationOfEmployerState.toLowerCase();
				
				 /*
				  * Inserting row wise data in HashMap
				  */
				
				record.put("employerId",employerId);
				record.put("employerName",employerName);
				record.put("locationOfEmployer",locationOfEmployer);
				record.put("locationOfEmployerDistrict",locationOfEmployerDistrict);
				record.put("locationOfEmployerState",locationOfEmployerState);
				
				arrayOfRecords.add(record);
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

		/*
		 * Checking primary key Constraints and performing respective actions  
		 */
			  try{				
				for(Map<String, Object> getRecord:arrayOfRecords)
				{
				int status=dataImportEmployerDao.dataImportEmployerPrimaryKeyConstraintCheck(getRecord);
				if(status==0)
				{
					/*
					 * If primary key doesn't exists in DB then run insert query
					 */
					int insertDataStatus=dataImportEmployerDao.insertDataInEmployer(getRecord);
					if(!(insertDataStatus>0))
					{
						throw new Exception();
					}
				}
				else if(status==1)
				{
					/*
					 * If primary key exists in DB then run update query
					 */
					int updateDataStatus=dataImportEmployerDao.updateDataInEmployer(getRecord);
					if(!(updateDataStatus>0))
					{
						throw new Exception();
					}
				}
				
				else
					throw new Exception();
					
				}	// end of for loop 
				
				employerCSVReader.close();
				return "Data Successfully inserted in Database .";
				
			  }	// end of try
				catch(Exception e)
				{
					employerCSVReader.close();
					File deleteUploadedFile = new File(employerCSVFileName);
					deleteUploadedFile.delete();
					e.printStackTrace();
					return "Error Inserting or Updating data .Kindly try again .";
				}				
		
			}

		}