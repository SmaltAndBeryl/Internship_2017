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

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(com.skill.India.service.NonAssignedBatchesService.class);
    @Autowired
    private NonAssignedBatchesDao updateDao;

    @Autowired
    private AlgorithmDao algorithmDao;

    AlgoPoc algoPoc = new AlgoPoc();


    public Collection<NonAssignedBatchesDto> getCollection() {
        LOGGER.info("Request Received from Controller");
        LOGGER.info("In NonAssignedBatchesService - getCollection");
        LOGGER.info("Making a Request to Dao to get data for Non assigned batches");

        String recommendedAB = "Default";
        ArrayList<String> rec = new ArrayList<>();
        Collection<NonAssignedBatchesDto> nonAssignedBatchesDtos = updateDao.getCollection(rec);

        for (NonAssignedBatchesDto nonAssignedBatchesDto : nonAssignedBatchesDtos) {
            ArrayList<Integer> agencyIdShowInterest = new ArrayList<>();
            System.out.println("Call to display list of interest bodies----------------------------------------------------------------------");
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
