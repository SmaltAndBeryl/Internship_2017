package com.skill.India.dto;

public class AssessmentBodyDirectorsDto {
    private final String name;
    private final String designation;
    private final String contactNumber;
    private final String emailId;
    private final String educationalQualification;
    private final String experience;

    public String getName() {
        return name;
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

    public String getEducationalQualification() {
        return educationalQualification;
    }

    public String getExperience() {
        return experience;
    }

    public AssessmentBodyDirectorsDto(String name, String designation, String contactNumber, String emailId, String educationalQualification, String experience) {

        this.name = name;
        this.designation = designation;
        this.contactNumber = contactNumber;
        this.emailId = emailId;
        this.educationalQualification = educationalQualification;
        this.experience = experience;
    }
}
