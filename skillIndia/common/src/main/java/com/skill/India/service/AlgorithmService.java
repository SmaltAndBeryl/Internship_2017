//package com.skill.India.service;
//
//import com.skill.India.dao.Algorithm2Dao;
//import com.skill.India.dao.Algorithm3Dao;
//import com.skill.India.dao.AlgorithmDao;
//import com.skill.India.dto.Algorithm2Dto;
//import com.skill.India.dto.Algorithm3Dto;
//import com.skill.India.dto.AlgorithmDto;
//import javafx.util.Pair;
//import org.apache.commons.collections.MultiMap;
//import org.apache.commons.collections.map.MultiValueMap;
//import org.apache.commons.collections4.IterableMap;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Set;
//import java.util.logging.Logger;
//
///**
// * Created by Alkesh srivastav on 7/17/2017.
// */
//@Service
//public class AlgorithmService {
//    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(AlgorithmService.class);
//    @Autowired
//    private AlgorithmDao algorithmDao;
//
//    @Autowired
//    private Algorithm2Dao algorithm2Dao;
//
//    @Autowired
//    private Algorithm3Dao algorithm3Dao;
//
//    public int batchIdVar;
//    public String stateVar;
//    public String districtVar;
//
//    //Change to dynamic array length
//    public int agencyIdVar[] = new int[10];
//    public String agencyNameVar[] = new String[10];
//    public String stateCmpVar[] = new String[10];
//    public String districtCmpVar[] = new String[10];
//    public String agencyCmpVar[] = new String[10];
//    public int count = 0;
//
//    public String selectedAgencyName = "";
//    public Collection<AlgorithmDto> getBatchIdCollection(String batchId){
//        Collection<AlgorithmDto> dtos = algorithmDao.getBatchIdCollection(batchId);
//        for(AlgorithmDto dto : dtos){
//            batchIdVar = dto.getBatchId();
//            stateVar = dto.getState();
//            districtVar = dto.getDistrict();
//        }
//        LOGGER.info("The state for batchId " + batchId + " is " + stateVar + " " + districtVar);
//        return algorithmDao.getBatchIdCollection(batchId);
//    }
//
//    public Collection<Algorithm2Dto> getAgencyIdCollection(int batchId){
//        Collection<Algorithm2Dto> dtos = algorithm2Dao.getAgencyIdCollection(batchId);
//        int i = 0;
//        LOGGER.info("The agencies who have shown interest are >>");
//        for(Algorithm2Dto dto : dtos){
//            agencyIdVar[i] = dto.getAgencyId();
//            agencyNameVar[i] =dto.getAgencyName();
//
//            LOGGER.info(String.valueOf("The agency id is" + agencyIdVar[i]) +" and agency name is " + agencyNameVar[i]);
//            i++;
//        }
//        LOGGER.info("The above bodies have shown interest");
//        return algorithm2Dao.getAgencyIdCollection(batchId);
//    }
//
//
//
//
//    public Collection<Algorithm3Dto> getAssessorIdCollecion(){
//        Collection<Algorithm3Dto> dtos = algorithm3Dao.getAssessorIdCollection();
//        int i=0;
//
//        // Store all the states into two 1D arrays
//        for(Algorithm3Dto dto : dtos){
//            stateCmpVar[i] = dto.getState();
////            LOGGER.info("The states are " + stateCmpVar[i]);
//            districtCmpVar[i] = dto.getDistrict();
//            agencyCmpVar[i] = dto.getAgencyName();
//            i++;
//        }
//
//        AlgorithmService algorithmService = new AlgorithmService();
//        algorithmService.printStates();
//
//        return algorithm3Dao.getAssessorIdCollection();
//    }
//
//    //Function to compare states and allot marks
//    public String printStates(){
//        MultiMap multiMap = new MultiValueMap();
//        int key = 0;
//        int counter = 0;
//        int marks = 0;
//        int highest = 0;
//        int largestKey = 0;
//        LOGGER.info("The state and district of the batch is >> " + stateCmpVar + " " + districtCmpVar);
//
//        while(stateCmpVar[counter] != null && !stateCmpVar[counter].isEmpty()) {
//            LOGGER.info("Adding the states.." + counter);
//
//            //Allot points on the basis of location
//            if(stateCmpVar[counter].equalsIgnoreCase(stateVar)) {
//                marks += 20;
//                if(districtCmpVar[counter].equalsIgnoreCase(districtVar)){
//                    marks += 30;
//                }
//            }
//            else {
//                LOGGER.info("Neither any of the states nor any districts match..");
//            }
//            multiMap.put(key, agencyCmpVar[counter]);
////            multiMap.put(key, stateCmpVar[counter]);
////            multiMap.put(key, districtCmpVar[counter]);
////            multiMap.put(key, marks);
//            if(marks > highest){
//                highest = marks;
//                largestKey = key;
//            }
//            counter++;
//            key++;
//            marks = 0;
//        }
//
//        LOGGER.info("Printing the number of states..");
//        Set<Integer> keys = multiMap.keySet();
//        for (Integer integer : keys){
//            LOGGER.info("The states and district are " + multiMap.get(integer));
//        }
//
//        LOGGER.info("The location with the highest score is >> " + multiMap.get(largestKey));
//        //Return the agencyID
////        Collection<Object> objects = (Collection<Object>) multiMap.get(largestKey);
//
//        if(multiMap.size()==0){
//            LOGGER.info("No one has shown interest and neither of the assessment bodies are located nearby.");
//            selectedAgencyName = "No Recommendations";
//        }
//
//        else {
//            selectedAgencyName = String.valueOf(multiMap.get(largestKey));
//            LOGGER.info("The location with the highest score is >> " + selectedAgencyName);
//        }
//        return selectedAgencyName;
//    }
//}
