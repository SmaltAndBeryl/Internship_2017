package com.skill.India.dto;

import com.skill.India.common.BaseDto;

/**
 * Created by Alkesh srivastav on 7/17/2017.
 */
public class AlgorithmDto extends BaseDto {
    private static final long serialVersionUID = 1L;

    public int getAgencyId() {
        return agencyId;
    }

    private final int agencyId;

    public AlgorithmDto(int agencyId) {
        this.agencyId = agencyId;
    }
}
