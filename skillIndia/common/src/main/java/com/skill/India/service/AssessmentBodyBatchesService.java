package com.skill.India.service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.assertj.core.extractor.Extractors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.thymeleaf.expression.Lists;






//import com.ibm.icu.text.DateFormat;
//import com.ibm.icu.text.SimpleDateFormat;
//import com.lowagie.text.List;
import com.skill.India.dao.AssessmentBodyBatchesDao;
import com.skill.India.dto.AssessmentBodyBatchesDto;

@Service
public class AssessmentBodyBatchesService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AssessmentBodyBatchesService.class);
	
	@Autowired
	private AssessmentBodyBatchesDao updateDao;
	
//	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//	Date date = new Date();
//	System.out.println(dateFormat.format(date));
	
	public HashMap<String, ArrayList<AssessmentBodyBatchesDto>> getUpdateRowMapper(){
		//System.out.println("LIST 1 Code reached");
		LOGGER.info("Request Received from controller");
		LOGGER.info("In AssessmentBodyBatchesService - getUpdateRowMapper");
			
		LOGGER.info("Creating ArrayList object for past batches");
		ArrayList<AssessmentBodyBatchesDto> pastBatches= new ArrayList<AssessmentBodyBatchesDto>();
		LOGGER.info("Successfully created");
		
		LOGGER.info("Creating ArrayList object for upcoming batches");
		ArrayList<AssessmentBodyBatchesDto> upcomingBatches= new ArrayList<AssessmentBodyBatchesDto>();
		LOGGER.info("Successfully created");
		
		LOGGER.info("Creating collection object");
		LOGGER.info("Initializing object");
		LOGGER.info("Making a Request to Dao to get data");
		Collection<AssessmentBodyBatchesDto> ab= updateDao.getUpdateRowMapper();
		LOGGER.info("Response received from Dao");
		
		
		for(AssessmentBodyBatchesDto x:ab)
		{
			LOGGER.info("Iterating collection object");
			LOGGER.info("Creating and initializing date object");
			Date da=x.getAssessmentDate();
			LOGGER.info("Successfully initialized");
			LOGGER.info("Creating and initializing date object with present date");
			Date d=new Date();
			LOGGER.info("Successfully initialized");
			if(d.after(da))
			{
				LOGGER.info("Inserting data into past batches");
				pastBatches.add(x);
				LOGGER.info("Successfully inserted");
			}
			else
			{
				//upcoming 
				LOGGER.info("Inserting data into Upcoming batches");
				upcomingBatches.add(x);
				LOGGER.info("Successfully inserted");
			}
		}
		
		LOGGER.info("Creating HashMap object");	
		HashMap<String, ArrayList<AssessmentBodyBatchesDto>> hmap= new HashMap<String, ArrayList<AssessmentBodyBatchesDto>>();
		LOGGER.info("Successfully created");
		LOGGER.info("Inserting data into HashMap object");
		LOGGER.info("Inserting data of past batches");
		hmap.put("pastBatches", pastBatches);
		LOGGER.info("Successfully inserted");
		LOGGER.info("Inserting data of Upcoming batches");
		hmap.put("upcomingBatches", upcomingBatches);
		LOGGER.info("Successfully inserted");
		
		LOGGER.info("Returning HashMap object");
		return hmap;
		
		
		
		
	}
}

       