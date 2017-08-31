package com.skill.India.dto;

public class AssessmentStaffDetailsDto {
    private final String name;
    private final String jobRoleCode;
    private final String designation;
    private final String contactNumber;
    private final String emailId;
    private final String district;
    private final String state;
    private final String educationalQualification;
    private final String experience;

    public AssessmentStaffDetailsDto(String name, String jobRoleCode, String designation, String contactNumber, String emailId, String district, String state, String educationalQualification, String experience) {

        this.name = name;
        this.jobRoleCode = jobRoleCode;
        this.designation = designation;
        this.contactNumber = contactNumber;
        this.emailId = emailId;
        this.district = district;
        this.state = state;
        this.educationalQualification = educationalQualification;
        this.experience = experience;
    }
}
