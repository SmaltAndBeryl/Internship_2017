package com.skill.India.common;

import com.skill.India.dto.Algorithm2Dto;
import com.skill.India.dto.AlgorithmDto;
import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiValueMap;
import org.slf4j.LoggerFactory;

import java.util.*;

public class RecommendationAlgorithm {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(RecommendationAlgorithm.class);

    public String getAgencyShowInterest(String stateBatch, String districtBatch, Collection<AlgorithmDto> algorithmDtos) {
        int key = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (AlgorithmDto algorithmDto : algorithmDtos){
            int marks = 0;

            if(algorithmDto.getState().equalsIgnoreCase(stateBatch)){
                marks += 10;
            }

            if (algorithmDto.getDistrict().equalsIgnoreCase(districtBatch)){
                marks += 50;
            }

            if(map.get(algorithmDto.getAgencyId()) != null){
                map.put(algorithmDto.getAgencyId(), map.get(algorithmDto.getAgencyId())+marks);
            }
            else{
                map.put(algorithmDto.getAgencyId(), marks);
            }

            key++;
        }

        printMultiMap(map);

        Integer maxValue = getMaxValue(map);
        Object maxKey = getKeyByValue(map, maxValue);
        LOGGER.info("MAXIMUM VALUE IS ////// "+ maxValue + "MAXIMUM KEY IS ''''' " + maxKey);
        return String.valueOf(maxKey);
    }

    public String getAgency(String stateBatch, String districtBatch, Collection<Algorithm2Dto> algorithm2Dtos) {
        int key = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (Algorithm2Dto algorithm2Dto : algorithm2Dtos){
            int marks = 0;

            if(algorithm2Dto.getState().equalsIgnoreCase(stateBatch)){
                marks += 10;
            }

            if (algorithm2Dto.getDistrict().equalsIgnoreCase(districtBatch)){
                marks += 50;
            }

            if(map.get(algorithm2Dto.getAgencyId()) != null){
                map.put(algorithm2Dto.getAgencyId(), map.get(algorithm2Dto.getAgencyId())+marks);
            }
            else{
                map.put(algorithm2Dto.getAgencyId(), marks);
            }

            key++;
        }

        printMultiMap(map);
        Integer maxValue = getMaxValue(map);
        Object maxKey = getKeyByValue(map, maxValue);
        LOGGER.info("MAXIMUM VALUE IS ////// "+ maxValue + "MAXIMUM KEY IS ''''' " + maxKey);

        return String.valueOf(maxKey);
    }

    private Object getKeyByValue(Map<Integer, Integer> map, Integer maxValue) {
        for(Object o : map.keySet()){
            if(map.get(o).equals(maxValue)){
                return o;
            }
        }
        return 0;
    }

    private Integer getMaxValue(Map<Integer, Integer> map) {
        Integer maxValue = Collections.max(map.values());
        return maxValue;
    }

    private <K,V> void printMultiMap(Map<Integer, Integer> multiMap) {
        for(Map.Entry<Integer, Integer> entry:multiMap.entrySet()){
            LOGGER.info("VALUES FROM THE MULTIMAP ARE " + entry.getKey() + " " + entry.getValue());
        }
    }


}
