package com.skill.India.service;
/*
 * Author 		: Ruchit Jain
 * Description  : For Centre .CSV Uploaded by user, This file :
 * 				 1) Checks for mandatory fields of Centre sheet
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
import com.skill.India.dao.DataImportCentreDao;
import com.skill.India.dto.ValidateCentreCSVDto;

@Service
public class ValidateCentreCSVService {

	@Autowired
	private DataImportCentreDao dataImportCentreDao;
	
	public String validateCentreCSV(String centreCSVFileName) throws IOException{
		CSVReader centreCSVReader=null;
		/*
		 * Create Array List to store the data of csv read (in Hashmap's) 
		 */
		ArrayList<Map<String,Object>> arrayOfRecords=new ArrayList<Map<String,Object>>();
		try{
		ColumnPositionMappingStrategy strategy=new ColumnPositionMappingStrategy();
		strategy.setType(ValidateCentreCSVDto.class);
		String [] centreCSVColumns=new String[]{"centreId","centreName","centrePOCContactname","centreAddress","district","state","trainingPartnerId"};
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
			/*
			 *  Map to store data of each row of csv read and then added to arraylist
			 */
			
			Map<String ,Object> record=new HashMap<String, Object>();
			
			recordCount++;
			int errorStatus=0;
			String errorString="";
			
			String centreId=centreCSVData.getCentreId(); 
			String centreName=centreCSVData.getCentreName();
			String centrePOCContactName=centreCSVData.getCentrePOCContactname();
			String centreAddress=centreCSVData.getCentreAddress();
			String district=centreCSVData.getDistrict();
			String state=centreCSVData.getState();
			String trainingPartnerId=centreCSVData.getTrainingPartnerId();
		
			/*
			 * Checking for Mandatory fields 
			 */
			
			if(centreId.equals("") || centreName.equals("") || centrePOCContactName.equals("")
					|| centreAddress.equals("") || district.equals("") || state.equals("") ||
					trainingPartnerId.equals("")){
				
				errorStatus=1;
				errorString=errorString+ "Mandatory fields cannot be Empty";
			}
			
			

			/*
			 * Checking for error in centreId column 
			 */
			
			if(!ValidationUtils.numbersCheck(centreId))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'centerId' column ";
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
			
			if(ValidationUtils.numbersCheck(centrePOCContactName))
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
			 * Checking for error in trainingPartnerId column 
			 */
			
			if(!ValidationUtils.numbersCheck(trainingPartnerId))
			{
				errorStatus=1;
				errorString=errorString+ "Error in 'trainingPartnerId' column ";
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
				
				centreName=centreName.toLowerCase();
				centrePOCContactName=centrePOCContactName.toLowerCase();
				centreAddress=centreAddress.toLowerCase();
				district=district.toLowerCase();
				state=state.toLowerCase();
				
				/*
				  * Inserting row wise data in HashMap
				  */
				
				record.put("centreId",centreId);
				record.put("centreName",centreName);
				record.put("centrePOCContactName",centrePOCContactName);
				record.put("centreAddress",centreAddress);
				record.put("district",district);
				record.put("state",state);
				record.put("trainingPartnerId",trainingPartnerId);
			
				arrayOfRecords.add(record);
			}
		}
	
		if(errorExist==1)
			{
			centreCSVReader.close();
			File deleteUploadedFile = new File(centreCSVFileName);
		    deleteUploadedFile.delete();
			return errorListAllRecords;
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

		/*
		 * Checking for foreign key constraint of batchId & employerId
		 */
		
		try{				
			for(Map<String, Object> getRecord:arrayOfRecords)
				{	
				int status=dataImportCentreDao.dataImportCentreForeignKeyConstraintCheck(getRecord);
				if(status==0 || status==2)
				{
				throw new Exception();	
				}
				
				} 	//end of for  
			}	// end of try
			catch(Exception e)
			{	
				centreCSVReader.close();
				File deleteUploadedFile = new File(centreCSVFileName);
				deleteUploadedFile.delete();
				e.printStackTrace();
				return "Error in trainingPartnerId column. Kindly recheck the details ."
			+ "trainingPartnerId not found in Training Partner record .";
			}
		
		/*
		 * Checking primary key Constraints and performing respective actions  
		 */
		
			  try{				
				for(Map<String, Object> getRecord:arrayOfRecords)
				{
				int status=dataImportCentreDao.dataImportCentrePrimaryKeyConstraintCheck(getRecord);
				if(status==0)
				{
					/*
					 * If primary key doesn't exists in DB then run insert query
					 */
					int insertDataStatus=dataImportCentreDao.insertDataInCentre(getRecord);
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
					int updateDataStatus=dataImportCentreDao.updateDataInCentre(getRecord);
					if(!(updateDataStatus>0))
					{
						throw new Exception();
					}
				}
				
				else
					throw new Exception();
					
				}	// end of for loop 
				
				centreCSVReader.close();
				return "Data Successfully inserted in Database .";
				
			  }	// end of try
				catch(Exception e)
				{
					centreCSVReader.close();
					File deleteUploadedFile = new File(centreCSVFileName);
					deleteUploadedFile.delete();
					e.printStackTrace();
					return "Error Inserting or Updating data .Kindly try again .";
				}		

	}
}

