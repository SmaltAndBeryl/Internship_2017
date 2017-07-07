package com.skill.India.service;
/*
 * Author 		: Ruchit Jain
 * Description  : For Assessor .CSV Uploaded by user, This file :
 * 				 1) Checks for mandatory fields of Assessor sheet
 * 				 2) Validates the data inserted in it by the user
 * 				 3) Checks for foreign key,primary key constraint	
 */
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
		/*
		 * Create Array List to store the data of csv read (in Hashmap's)
		 */
		ArrayList<Map<String,Object>> arrayOfRecords=new ArrayList<Map<String,Object>>();
		try{
		ColumnPositionMappingStrategy strategy=new ColumnPositionMappingStrategy();
		strategy.setType(ValidateAssessorCSVDto.class);
		String [] assessorCSVColumns=new String[]{"assessorId","assessorName","district","state","agencyId"};
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
			/*
			 * Map to store data of each row of csv read and then added to arraylist
			 */
			Map<String ,Object> record=new HashMap<String, Object>();
			
			recordCount++;
			int errorStatus=0;
			String errorString="";
			
			String assessorId=assessorCSVData.getAssessorId();
			String assessorName=assessorCSVData.getAssessorName();
			String agencyId=assessorCSVData.getAgencyId();
			String district=assessorCSVData.getDistrict();
			String state=assessorCSVData.getState();
			
			
			/*
			 * Checking for Mandatory fields 
			 */
			
			if(assessorId.equals("") || assessorName.equals("") || agencyId.equals(""))
			{
				errorStatus=1;
				errorString=errorString+ "Mandatory fields cannot be Empty .";
			}
			
			/*
			 * Checking for error in assessorId column 
			 */
			
			if(!ValidationUtils.numbersCheck(assessorId))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'assessorId' column  ";
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
			 * Checking for error in agencyId column 
			 */
			
			if(!ValidationUtils.numbersCheck(agencyId))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'agencyId' column  ";
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
				
				record.put("assessorId",assessorId);
				record.put("assessorName",assessorName);
				record.put("district",district);
				record.put("state",state);
				record.put("agencyId",agencyId);
				arrayOfRecords.add(record);
				
			}			
		}
		
		if(errorExist==1)
		{
		assessorCSVReader.close();
		File deleteUploadedFile = new File(assessorCSVFileName);
	    deleteUploadedFile.delete();
		return errorListAllRecords;
		}
				
		}
		catch(Exception e)
		{
			assessorCSVReader.close();
			File deleteUploadedFile = new File(assessorCSVFileName);
			deleteUploadedFile.delete();
			e.printStackTrace();
			return "Error Occurred while Uploading the File";		
		}
			
		/*
		 * checking for foreign key constraint on agencyId in Assessment Agency
		 */
		
		try{				
			for(Map<String, Object> getRecord:arrayOfRecords)
				{
				int status=dataImportAssessorDao.dataImportAssessorForeignKeyConstraintCheck(getRecord);					
				if(status==0 || status==2)
					{
					throw new Exception();
					}
				} 	//end of for  
			}	// end of try
			catch(Exception e)
			{	
				assessorCSVReader.close();
				File deleteUploadedFile = new File(assessorCSVFileName);
				deleteUploadedFile.delete();
				e.printStackTrace();
				return "Error in agencyId column. Kindly recheck the details ."
			+ "agencyId not found in Assessment Agency record .";
			}

		/*
		 * Checking primary key Constraint and performing respective actions 
		 */
			
			  try{				
				for(Map<String, Object> getRecord:arrayOfRecords)
				{			
				int status=dataImportAssessorDao.dataImportAssessorPrimaryKeyConstraintCheck(getRecord);
				if(status==0)
				{
					/*
					 * If primary key doesn't exists in DB then run insert query
					 */
					int insertDataStatus=dataImportAssessorDao.insertDataInAssessor(getRecord);
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
					int updateDataStatus=dataImportAssessorDao.updateDataInAssessor(getRecord);
					if(!(updateDataStatus>0))
					{
						throw new Exception();
					}
				}
				
				else
					throw new Exception();
				
				}	// end of for loop 
				assessorCSVReader.close();
				return "Data Successfully inserted in Database .";
				}	// end of try
				catch(Exception e)
				{
					assessorCSVReader.close();
					File deleteUploadedFile = new File(assessorCSVFileName);
					deleteUploadedFile.delete();
					e.printStackTrace();
					return "Error Inserting or Updating data in Assessor table .Kindly try again .";
				}		

	}
}