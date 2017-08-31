package com.skill.India.dto;

public class AssessmentExperienceInTechnicalDomainDto {
    private final String domain;
    private final String numberOfAssessmentsDone;

    public String getDomain() {
        return domain;
    }

    public String getNumberOfAssessmentsDone() {
        return numberOfAssessmentsDone;
    }

    public AssessmentExperienceInTechnicalDomainDto(String domain, String numberOfAssessmentsDone) {

        this.domain = domain;
        this.numberOfAssessmentsDone = numberOfAssessmentsDone;
    }
}
