package com.skill.India.dto;

public class DirectorDto {
    private final String name;
    private final String designation;
    private final String emailId;
    private final String contactNumber;
    private final String educationalQualification;
    private final String experience;

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEducationalQualification() {
        return educationalQualification;
    }

    public String getExperience() {
        return experience;
    }

    public DirectorDto(String name, String designation, String emailId, String contactNumber, String educationalQualification, String experience) {

        this.name = name;
        this.designation = designation;
        this.emailId = emailId;
        this.contactNumber = contactNumber;
        this.educationalQualification = educationalQualification;
        this.experience = experience;
    }
}
