package com.skill.India.dto;

import com.skill.India.common.BaseDto;

/**
 * Created by Alkesh srivastav on 7/17/2017.
 */
public class AlgorithmDto extends BaseDto {
    private static final long serialVersionUID = 1L;
    private final int batchId;
    private final String state;
    private final String district;


    public int getBatchId() {
        return batchId;
    }

    public String getState() {
        return state;
    }

    public String getDistrict() {
        return district;
    }

    public AlgorithmDto(int batchId, String state, String district) {
        super();
        this.batchId = batchId;
        this.state = state;
        this.district = district;
    }
}
