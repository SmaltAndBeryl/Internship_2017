package com.skill.India.dto;

public class AssessmentStaffDetailsDto {
    private final String name;
    private final String jobRoleCode;
    private final String designation;
    private final String contactNumber;
    private final String emailId;
    private final String city;
    private final String state;
    private final String educationalQualification;
    private final String experience;

    public String getName() {
        return name;
    }

    public String getJobRoleCode() {
        return jobRoleCode;
    }

    public String getDesignation() {
        return designation;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getEducationalQualification() {
        return educationalQualification;
    }

    public String getExperience() {
        return experience;
    }

    public AssessmentStaffDetailsDto(String name, String jobRoleCode, String designation, String contactNumber, String emailId, String city, String state, String educationalQualification, String experience) {

        this.name = name;
        this.jobRoleCode = jobRoleCode;
        this.designation = designation;
        this.contactNumber = contactNumber;
        this.emailId = emailId;
        this.city = city;
        this.state = state;
        this.educationalQualification = educationalQualification;
        this.experience = experience;
    }
}
