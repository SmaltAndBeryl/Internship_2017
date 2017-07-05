/**
 * 
 */
package com.skill.India.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.skill.India.dao.TrainingPartnerbatchesDao;
import com.skill.India.dto.TrainingPartnerBatchesDto;


@Service
public class TrainingPartnerBatchesService {

	@Autowired
	private TrainingPartnerbatchesDao trainingPartnerBatchDao;
	public HashMap<String, ArrayList<TrainingPartnerBatchesDto>> getUpdateRowMapper(){
		//System.out.println("LIST 1 Code reached");
	
		ArrayList<TrainingPartnerBatchesDto> pastBatches= new ArrayList<TrainingPartnerBatchesDto>();
		ArrayList<TrainingPartnerBatchesDto> presentBatches= new ArrayList<TrainingPartnerBatchesDto>();
		
		 Collection<TrainingPartnerBatchesDto> trainingPartnerBatches= trainingPartnerBatchDao.getUpdateRowMapper();
		 
		 for(TrainingPartnerBatchesDto rowWiseData:trainingPartnerBatches)
			{
				Date currentSystemDate=rowWiseData.getCompletionDate();
				Date d=new Date();
				if(d.after(currentSystemDate))
					
					pastBatches.add(rowWiseData);
				else
					presentBatches.add(rowWiseData);
			}
		 
			HashMap<String, ArrayList<TrainingPartnerBatchesDto>> hmap= new HashMap<String, ArrayList<TrainingPartnerBatchesDto>>();
			hmap.put("Past Batches" ,pastBatches);
			hmap.put("Present Batches", presentBatches);
			return hmap;
	
	}
}
