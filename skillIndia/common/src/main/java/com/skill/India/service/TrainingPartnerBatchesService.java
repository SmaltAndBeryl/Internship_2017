/**
 * 
 */
package com.skill.India.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.skill.India.dao.TrainingPartnerbatchesDao;
import com.skill.India.dto.TrainingPartnerBatchesDto;


@Service
public class TrainingPartnerBatchesService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TrainingPartnerBatchesService.class);
	
	@Autowired
	private TrainingPartnerbatchesDao trainingPartnerBatchDao;
	public HashMap<String, ArrayList<TrainingPartnerBatchesDto>> getUpdateRowMapper(int applicationId){
		
		LOGGER.info("Request Received from Controller");
		LOGGER.info("In TrainingPartnerBatchesService - getUpdateRowMapper");
		LOGGER.info("Parameters Received from Controller are - 'applicationId': ",applicationId);
		//System.out.println("LIST 1 Code reached");
	
		LOGGER.info("Creating Array List to hold data for Past Batches");
		ArrayList<TrainingPartnerBatchesDto> pastBatches= new ArrayList<TrainingPartnerBatchesDto>();
		LOGGER.info("Successfully Created Array List for Past Batches");
		LOGGER.info("Creating Array List to hold data for Present Batches");
		ArrayList<TrainingPartnerBatchesDto> presentBatches= new ArrayList<TrainingPartnerBatchesDto>();
		LOGGER.info("Successfully Created Array List for Present Batches");
		LOGGER.info("Making a Request to Dao to get data");
		 Collection<TrainingPartnerBatchesDto> trainingPartnerBatches= trainingPartnerBatchDao.getUpdateRowMapper(applicationId);
		 LOGGER.info("Response received from Dao");
		 LOGGER.info("Data Received Successfully");
		 
		 LOGGER.info("Now Seperating the data of Present and Past Batches");
		 for(TrainingPartnerBatchesDto rowWiseData:trainingPartnerBatches)
			{
				Date currentSystemDate=rowWiseData.getCompletionDate();
				Date d=new Date();
				if(d.after(currentSystemDate))
					
					pastBatches.add(rowWiseData);
				else
					presentBatches.add(rowWiseData);
			}
		 LOGGER.info("Successfully sepearted data of Present and Past Batches");
		 LOGGER.info("Creating Hash Map for Sending the Seperated data ");
			HashMap<String, ArrayList<TrainingPartnerBatchesDto>> hmap= new HashMap<String, ArrayList<TrainingPartnerBatchesDto>>();
			LOGGER.info("Hash Map created Successfully");
			LOGGER.info("Inserting Past Batches data");
			hmap.put("PastBatches" ,pastBatches);
			LOGGER.info("Successfully inserted Past Batches data");
			LOGGER.info("Inserting Present Batches data");
			hmap.put("PresentBatches", presentBatches);
			LOGGER.info("Successfully inserted Present Batches data");
			LOGGER.info("Returning the Hash Map created");
			return hmap;
		}
}
