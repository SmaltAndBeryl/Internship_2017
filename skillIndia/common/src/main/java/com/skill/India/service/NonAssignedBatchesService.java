package com.skill.India.service;

import com.skill.India.POC.AlgoPoc;
import com.skill.India.dao.AlgorithmDao;
import com.skill.India.dao.NonAssignedBatchesDao;
import com.skill.India.dto.AlgorithmDto;
import com.skill.India.dto.NonAssignedBatchesDto;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Alkesh on 7/12/2017.
 */
@Service
public class NonAssignedBatchesService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(NonAssignedBatchesService.class);
    
    @Autowired
    private NonAssignedBatchesDao updateDao;

    @Autowired
    private AlgorithmDao algorithmDao;

    AlgoPoc algoPoc = new AlgoPoc();


    public Collection<NonAssignedBatchesDto> getCollection() {
        LOGGER.info("Request Received from Controller");
        LOGGER.info("In NonAssignedBatchesService - getCollection");
        
        String recommendedAB = "Default";
        
        LOGGER.info("Creating ArrayList object");
        ArrayList<String> rec = new ArrayList<>();
        LOGGER.info("Successfully created");
        
        LOGGER.info("Creating Collection object");
        LOGGER.info("Making a Request to Dao to get data for Non assigned batches");
        Collection<NonAssignedBatchesDto> nonAssignedBatchesDtos = updateDao.getCollection(rec);
        LOGGER.info("Received Response from Dao");
        LOGGER.info("Successfully initialized");
        
        LOGGER.info("Iterating Collection object");
        for (NonAssignedBatchesDto nonAssignedBatchesDto : nonAssignedBatchesDtos) {
        	LOGGER.info("Creating ArrayList object");
            ArrayList<Integer> agencyIdShowInterest = new ArrayList<>();
            LOGGER.info("Successfully initialized");
//            System.out.println("Call to display list of interest bodies----------------------------------------------------------------------");
            
           
            for (AlgorithmDto algorithmDto : algorithmDao.algorithmDtoCollection(Integer.parseInt(nonAssignedBatchesDto.getBatchID()))) {
                agencyIdShowInterest.add(algorithmDto.getAgencyId());
                LOGGER.info("Add successful..");
            }

            LOGGER.info("The best match is -=-=-=-=-====================-=-=-=-=");
            recommendedAB = algoPoc.recommendedAgencyName(agencyIdShowInterest);
            LOGGER.info("Best match = " + recommendedAB);
            LOGGER.info("Adding to rec array list");
            rec.add(recommendedAB);
        }
        return updateDao.getCollection(rec);
    }
}
