package com.skill.India.dto;

import com.skill.India.common.BaseDto;

/**
 * Created by Alkesh srivastav on 7/17/2017.
 */
public class AlgorithmDto extends BaseDto {
    private static final long serialVersionUID = 1L;

    private final int agencyId;
    private final String state;
    private final String district;

    public String getState() {
        return state;
    }

    public String getDistrict() {
        return district;
    }

    public int getAgencyId() {
        return agencyId;
    }



    public AlgorithmDto(int agencyId, String state, String district) {
        this.agencyId = agencyId;
        this.state = state;
        this.district = district;
    }
}
