package com.skill.India.POC;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import au.com.bytecode.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

@Controller
public class OpenCSVController {
	@RequestMapping("/importcsv")
	public String ImportCSV() {
		CSVReader csvReader = null;
		//HeaderColumnNameTranslateMappingStrategy strategy = new HeaderColumnNameTranslateMappingStrategy();
		try{
			//HeaderColumnNameTranslateMappingStrategy strategy = new HeaderColumnNameTranslateMappingStrategy();
			ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();  
			strategy.setType(CSVData.class);
			//Map<String, String> columnMapping = new HashMap<String, String>();
			//columnMapping.put("Candidate ID ","candidateID"); 
			//columnMapping.put("Candidate Name","candidateName");
			//columnMapping.put("Enrollment Number","candidateEnrollmentNumber");
			//columnMapping.put("Gender","candidateGender");
			String[] columns = new String[]{"candidateID","candidateName","candidateEnrollmentNumber"};
			strategy.setColumnMapping(columns);
			//strategy.setColumnMapping(columnMapping);
		
			String csvFileName = "D:\\Myworkspace\\Sample.csv";
			csvReader = new CSVReader(new FileReader(csvFileName),',','"',1);
			//csvReader = new CSVReader(new FileReader(csvFileName),',','"',1);
			CsvToBean<CSVData> csv = new CsvToBean<CSVData>();
			List<CSVData> csvDataList = csv.parse(strategy, csvReader);	
			for(CSVData csvdata: csvDataList){
				//System.out.println("Candidate Id -"+csvdata.getCandidateID());
				//System.out.println("Candidate Enrollment Number -"+csvdata.getCandidateEnrollmentNumber());
				//System.out.println("Candidate Name"+csvdata.getCandidateName());
				//System.out.println("Candidate Gender"+ csvdata.getCandidateGender());
			return "ID: "+csvdata.getCandidateID();
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				//closing the reader
				csvReader.close();
				return "importCSV";
			}
			catch(Exception ee)
			{
				ee.printStackTrace();
			}
		}
	return "importCSV";
	}

}
