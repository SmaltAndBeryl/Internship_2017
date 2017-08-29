package com.skill.India.dto;

public class InstitutionGrantDto {
    private final String nameOfMinistry;
    private final String natureOfWork;
    private final String remarks;

    public String getNameOfMinistry() {
        return nameOfMinistry;
    }

    public String getNatureOfWork() {
        return natureOfWork;
    }

    public String getRemarks() {
        return remarks;
    }


    public InstitutionGrantDto(String nameOfMinistry, String natureOfWork, String remarks) {
        this.nameOfMinistry = nameOfMinistry;
        this.natureOfWork = natureOfWork;
        this.remarks = remarks;
    }
}
