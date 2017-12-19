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
		
		LOGGER.debug("Request Received from Controller");
		LOGGER.debug("In TrainingPartnerBatchesService - getUpdateRowMapper");
		LOGGER.debug("Parameters Received from Controller are - 'applicationId': "+applicationId);
		//System.out.println("LIST 1 Code reached");
	
		LOGGER.debug("Creating Array List to hold data for Past Batches");
		ArrayList<TrainingPartnerBatchesDto> pastBatches= new ArrayList<TrainingPartnerBatchesDto>();
		LOGGER.debug("Successfully Created Array List for Past Batches");
		LOGGER.debug("Creating Array List to hold data for Present Batches");
		ArrayList<TrainingPartnerBatchesDto> presentBatches= new ArrayList<TrainingPartnerBatchesDto>();
		LOGGER.debug("Successfully Created Array List for Present Batches");
		LOGGER.debug("Making a Request to Dao to get data");
		 Collection<TrainingPartnerBatchesDto> trainingPartnerBatches= trainingPartnerBatchDao.getUpdateRowMapper(applicationId);
		 LOGGER.debug("Response received from Dao");
		 LOGGER.debug("Data Received Successfully");
		 
		 LOGGER.debug("Now Seperating the data of Present and Past Batches");
		 for(TrainingPartnerBatchesDto rowWiseData:trainingPartnerBatches)
			{
				Date currentSystemDate=rowWiseData.getCompletionDate();
				Date d=new Date();
				if(d.after(currentSystemDate))
					
					pastBatches.add(rowWiseData);
				else
					presentBatches.add(rowWiseData);
			}
		 LOGGER.debug("Successfully sepearted data of Present and Past Batches");
		 LOGGER.debug("Creating Hash Map for Sending the Seperated data ");
			HashMap<String, ArrayList<TrainingPartnerBatchesDto>> hmap= new HashMap<String, ArrayList<TrainingPartnerBatchesDto>>();
			LOGGER.debug("Hash Map created Successfully");
			LOGGER.debug("Inserting Past Batches data");
			hmap.put("PastBatches" ,pastBatches);
			LOGGER.debug("Successfully inserted Past Batches data");
			LOGGER.debug("Inserting Present Batches data");
			hmap.put("PresentBatches", presentBatches);
			LOGGER.debug("Successfully inserted Present Batches data");
			LOGGER.debug("Returning the Hash Map created");
			return hmap;
		}
}
