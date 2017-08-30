package com.skill.India.service;

import com.skill.India.common.RecommendationAlgorithm;
import com.skill.India.dao.Algorithm2Dao;
import com.skill.India.dao.Algorithm3Dao;
import com.skill.India.dao.AlgorithmDao;
import com.skill.India.dao.NonAssignedBatchesDao;
import com.skill.India.dto.Algorithm2Dto;
import com.skill.India.dto.Algorithm3Dto;
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

    @Autowired
    private Algorithm2Dao algorithm2Dao;

    @Autowired
    private Algorithm3Dao algorithm3Dao;

   RecommendationAlgorithm recommendationAlgorithm = new RecommendationAlgorithm();


    public Collection<NonAssignedBatchesDto> getCollection() {
        LOGGER.info("Request Received from Controller");
        LOGGER.info("In NonAssignedBatchesService - getCollection");
        
        String recommendedAB = "Default";
        
        LOGGER.info("Creating ArrayList object");

        ArrayList<String> rec = new ArrayList<>();

        LOGGER.info("Successfully created");
        
        LOGGER.info("Creating Collection object");
        LOGGER.info("Making a Request to Dao to get data for Non assigned batches");
        String recommendedAgency = "";

        Collection<NonAssignedBatchesDto> nonAssignedBatchesDtos = updateDao.getCollection();
        Collection<NonAssignedBatchesDto> nonAssignedBatchesDtoCollection = new ArrayList<>();
        LOGGER.info("Received Response from Dao");
        LOGGER.info("Successfully initialized");


        for(NonAssignedBatchesDto beanDto : nonAssignedBatchesDtos){
            LOGGER.info("The state and district for >>>>>>>>>>>>>>>>>>>>>>>>>>" + beanDto.getBatchID() + " are " +beanDto.getState() + " " + beanDto.getDistrict());
            String batchId = beanDto.getBatchID();
            String stateBatch = beanDto.getState();
            String districtBatch = beanDto.getDistrict();


            //Collection to store the agencies who have shown interest
            Collection<AlgorithmDto> algorithmDtos = algorithmDao.algorithmDtoCollection(Integer.parseInt(batchId));

            if(!algorithmDtos.isEmpty()){
                for(AlgorithmDto algorithmDto : algorithmDtos){
                    LOGGER.info("The agencies who have shown interest are >>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + algorithmDto.getAgencyId() + " " + algorithmDto.getState() + " " + algorithmDto.getDistrict());
                }

                recommendedAgency = recommendationAlgorithm.getAgencyShowInterest(stateBatch, districtBatch, algorithmDtos);
                LOGGER.info("recommended agency is "+ recommendedAgency);
            }

            else {
                LOGGER.info("No one has shown INTEREST -*-*-*-*-*-*-*-* ");
                //Proceed to next step
                Collection<Algorithm2Dto> algorithm2Dtos = algorithm2Dao.getAgencyIdCollection();

                for (Algorithm2Dto algorithm2Dto : algorithm2Dtos){
                    LOGGER.info("Displaying all agencies cause no one has shown interest" + algorithm2Dto.getAgencyId() + " " + algorithm2Dto.getState() + " " + algorithm2Dto.getDistrict());
                }


                recommendedAgency = recommendationAlgorithm.getAgency(stateBatch, districtBatch, algorithm2Dtos);
                LOGGER.info("recommended agency is "+ recommendedAgency);
            }

            LOGGER.info("The agency name is " + String.valueOf(algorithm3Dao.getAssessorIdCollection(recommendedAgency)));
            String recommendedAgencyName = "";
            for(Algorithm3Dto dto : algorithm3Dao.getAssessorIdCollection(recommendedAgency)){
                recommendedAgencyName = dto.getAgencyName();
                LOGGER.info("RECOMMENDED AGENCY IS " + recommendedAgencyName);
            }

            nonAssignedBatchesDtoCollection.add(new NonAssignedBatchesDto(batchId, stateBatch, districtBatch, beanDto.getBatchEndDate(), beanDto.getAssessmentDate(), recommendedAgencyName));
        }
        return nonAssignedBatchesDtoCollection;
    }
}
