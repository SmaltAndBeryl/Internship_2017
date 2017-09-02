package com.skill.India.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Alkesh srivastav on 7/13/2017.
 */
@Component
@ConfigurationProperties(prefix = "pdfData", locations = "classpath:sql/pdfData.yml")
public class PdfDataConfigSql {
    private String selectSql;
    private String selectSqlInstitutionGrant;
    private String selectSqlCenterLevel;
    private String selectSqlInstitutionRecognition;
    private String selectSqlPriorExperience;
    private String selectSqlDirector;
    private String selectUserRoleApplicationId;

    private String selectTrainingPartnerRegistrationId;

    private String selectAssessmentBodyRegistrationId;

    private String selectAssessmentBodyRegistrationDetails;
    private String selectAssessmentsExperienceInTechnicalDomain;
    private String selectAssessmentBodyDirectorsAndManagementTeamDetails;
    private String selectAssessmentStaffDetails;
    private String selectRegionalOfficeDetails;
    private String selectassessmentbodyaffiliationdetails;

    public String getSelectassessmentbodyaffiliationdetails() {
        return selectassessmentbodyaffiliationdetails;
    }

    public void setSelectassessmentbodyaffiliationdetails(String selectassessmentbodyaffiliationdetails) {
        this.selectassessmentbodyaffiliationdetails = selectassessmentbodyaffiliationdetails;
    }

    public String getSelectAssessmentBodyRegistrationId() {
        return selectAssessmentBodyRegistrationId;
    }

    public void setSelectAssessmentBodyRegistrationId(String selectAssessmentBodyRegistrationId) {
        this.selectAssessmentBodyRegistrationId = selectAssessmentBodyRegistrationId;
    }

    public String getSelectAssessmentStaffDetails() {
        return selectAssessmentStaffDetails;
    }

    public void setSelectAssessmentStaffDetails(String selectAssessmentStaffDetails) {
        this.selectAssessmentStaffDetails = selectAssessmentStaffDetails;
    }

    public String getSelectRegionalOfficeDetails() {
        return selectRegionalOfficeDetails;
    }

    public void setSelectRegionalOfficeDetails(String selectRegionalOfficeDetails) {
        this.selectRegionalOfficeDetails = selectRegionalOfficeDetails;
    }

    public String getSelectAssessmentBodyRegistrationDetails() {
        return selectAssessmentBodyRegistrationDetails;
    }

    public void setSelectAssessmentBodyRegistrationDetails(String selectAssessmentBodyRegistrationDetails) {
        this.selectAssessmentBodyRegistrationDetails = selectAssessmentBodyRegistrationDetails;
    }

    public String getSelectAssessmentsExperienceInTechnicalDomain() {
        return selectAssessmentsExperienceInTechnicalDomain;
    }

    public void setSelectAssessmentsExperienceInTechnicalDomain(String selectAssessmentsExperienceInTechnicalDomain) {
        this.selectAssessmentsExperienceInTechnicalDomain = selectAssessmentsExperienceInTechnicalDomain;
    }

    public String getSelectAssessmentBodyDirectorsAndManagementTeamDetails() {
        return selectAssessmentBodyDirectorsAndManagementTeamDetails;
    }

    public void setSelectAssessmentBodyDirectorsAndManagementTeamDetails(String selectAssessmentBodyDirectorsAndManagementTeamDetails) {
        this.selectAssessmentBodyDirectorsAndManagementTeamDetails = selectAssessmentBodyDirectorsAndManagementTeamDetails;
    }

    public String getSelectTrainingPartnerRegistrationId() {
        return selectTrainingPartnerRegistrationId;
    }

    public void setSelectTrainingPartnerRegistrationId(String selectTrainingPartnerRegistrationId) {
        this.selectTrainingPartnerRegistrationId = selectTrainingPartnerRegistrationId;
    }

    public String getSelectUserRoleApplicationId() {
        return selectUserRoleApplicationId;
    }

    public void setSelectUserRoleApplicationId(String selectUserRoleApplicationId) {
        this.selectUserRoleApplicationId = selectUserRoleApplicationId;
    }

    private String selectSqlTrainingPartnerRegistrationId;

    public String getSelectSqlTrainingPartnerRegistrationId() {
        return selectSqlTrainingPartnerRegistrationId;
    }

    public void setSelectSqlTrainingPartnerRegistrationId(String selectSqlTrainingPartnerRegistrationId) {
        this.selectSqlTrainingPartnerRegistrationId = selectSqlTrainingPartnerRegistrationId;
    }

    public String getSelectSqlDirector() {
        return selectSqlDirector;
    }

    public void setSelectSqlDirector(String selectSqlDirector) {
        this.selectSqlDirector = selectSqlDirector;
    }

    public String getSelectSqlPriorExperience() {
        return selectSqlPriorExperience;
    }

    public void setSelectSqlPriorExperience(String selectSqlPriorExperience) {
        this.selectSqlPriorExperience = selectSqlPriorExperience;
    }

    public String getSelectSqlInstitutionRecognition() {
        return selectSqlInstitutionRecognition;
    }

    public void setSelectSqlInstitutionRecognition(String selectSqlInstitutionRecognition) {
        this.selectSqlInstitutionRecognition = selectSqlInstitutionRecognition;
    }

    public String getSelectSqlCenterLevel() {
        return selectSqlCenterLevel;
    }

    public void setSelectSqlCenterLevel(String selectSqlCenterLevel) {
        this.selectSqlCenterLevel = selectSqlCenterLevel;
    }

    public String getSelectSqlInstitutionGrant() {
        return selectSqlInstitutionGrant;
    }

    public void setSelectSqlInstitutionGrant(String selectSqlInstitutionGrant) {
        this.selectSqlInstitutionGrant = selectSqlInstitutionGrant;
    }

    public String getSelectSql() {
        return selectSql;
    }

    public void setSelectSql(String selectSql) {
        this.selectSql = selectSql;
    }
}
