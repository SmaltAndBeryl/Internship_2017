package com.skill.India.dto;

import java.util.Collection;

public class ProfileCreationAssessmentBodyWrapperDto {
	private String type;
	private ProfileCreationAssessmentBodyRegistrationDetailsDto profileCreationAssessmentBodyRegistrationDetailsDto;
	private Collection<ProfileCreationAssessmentBodyAffiliationDetailsDto> profileCreationAssessmentBodyAffiliationDetailsDto;
	private Collection<ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto> profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto;
	private Collection<ProfileCreationAssessmentBodyRecognitionsDto> profileCreationAssessmentBodyRecognitionsDto;
	private Collection<ProfileCreationAssessmentBodyRegionalOfficeDetailsDto> profileCreationAssessmentBodyRegionalOfficeDetailsDto;
	private Collection<ProfileCreationAssessmentsExperienceInTechnicalDomainDto> profileCreationAssessmentsExperienceInTechnicalDomainDto;
	private Collection<ProfileCreationAssessmentStaffDetailsDto> profileCreationAssessmentStaffDetailsDto;
	
	
	public ProfileCreationAssessmentBodyWrapperDto()
	{
		super();
	}
	
	public ProfileCreationAssessmentBodyWrapperDto(String type,
			Collection<ProfileCreationAssessmentBodyAffiliationDetailsDto> profileCreationAssessmentBodyAffiliationDetailsDto,
			Collection<ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto> profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto,
			Collection<ProfileCreationAssessmentBodyRecognitionsDto> profileCreationAssessmentBodyRecognitionsDto,
			Collection<ProfileCreationAssessmentBodyRegionalOfficeDetailsDto> profileCreationAssessmentBodyRegionalOfficeDetailsDto,
			ProfileCreationAssessmentBodyRegistrationDetailsDto profileCreationAssessmentBodyRegistrationDetailsDto,
			Collection<ProfileCreationAssessmentsExperienceInTechnicalDomainDto> profileCreationAssessmentsExperienceInTechnicalDomainDto,
			Collection<ProfileCreationAssessmentStaffDetailsDto> profileCreationAssessmentStaffDetailsDto)
	{
		super();
		this.type = type;
		this.profileCreationAssessmentBodyAffiliationDetailsDto = profileCreationAssessmentBodyAffiliationDetailsDto;
		this.profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto = profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto;
		this.profileCreationAssessmentBodyRecognitionsDto = profileCreationAssessmentBodyRecognitionsDto;
		this.profileCreationAssessmentBodyRegionalOfficeDetailsDto = profileCreationAssessmentBodyRegionalOfficeDetailsDto;
		this.profileCreationAssessmentBodyRegistrationDetailsDto = profileCreationAssessmentBodyRegistrationDetailsDto;
		this.profileCreationAssessmentsExperienceInTechnicalDomainDto = profileCreationAssessmentsExperienceInTechnicalDomainDto;
		this.profileCreationAssessmentStaffDetailsDto = profileCreationAssessmentStaffDetailsDto;
		
		
	}

	public ProfileCreationAssessmentBodyRegistrationDetailsDto getProfileCreationAssessmentBodyRegistrationDetailsDto() {
		return profileCreationAssessmentBodyRegistrationDetailsDto;
	}

	public void setProfileCreationAssessmentBodyRegistrationDetailsDto(
			ProfileCreationAssessmentBodyRegistrationDetailsDto profileCreationAssessmentBodyRegistrationDetailsDto) {
		this.profileCreationAssessmentBodyRegistrationDetailsDto = profileCreationAssessmentBodyRegistrationDetailsDto;
	}

	public Collection<ProfileCreationAssessmentBodyAffiliationDetailsDto> getProfileCreationAssessmentBodyAffiliationDetailsDto() {
		return profileCreationAssessmentBodyAffiliationDetailsDto;
	}

	public void setProfileCreationAssessmentBodyAffiliationDetailsDto(
			Collection<ProfileCreationAssessmentBodyAffiliationDetailsDto> profileCreationAssessmentBodyAffiliationDetailsDto) {
		this.profileCreationAssessmentBodyAffiliationDetailsDto = profileCreationAssessmentBodyAffiliationDetailsDto;
	}

	public Collection<ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto> getProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto() {
		return profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto;
	}

	public void setProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto(
			Collection<ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto> profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto) {
		this.profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto = profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto;
	}

	public Collection<ProfileCreationAssessmentBodyRecognitionsDto> getProfileCreationAssessmentBodyRecognitionsDto() {
		return profileCreationAssessmentBodyRecognitionsDto;
	}

	public void setProfileCreationAssessmentBodyRecognitionsDto(
			Collection<ProfileCreationAssessmentBodyRecognitionsDto> profileCreationAssessmentBodyRecognitionsDto) {
		this.profileCreationAssessmentBodyRecognitionsDto = profileCreationAssessmentBodyRecognitionsDto;
	}

	public Collection<ProfileCreationAssessmentBodyRegionalOfficeDetailsDto> getProfileCreationAssessmentBodyRegionalOfficeDetailsDto() {
		return profileCreationAssessmentBodyRegionalOfficeDetailsDto;
	}

	public void setProfileCreationAssessmentBodyRegionalOfficeDetailsDto(
			Collection<ProfileCreationAssessmentBodyRegionalOfficeDetailsDto> profileCreationAssessmentBodyRegionalOfficeDetailsDto) {
		this.profileCreationAssessmentBodyRegionalOfficeDetailsDto = profileCreationAssessmentBodyRegionalOfficeDetailsDto;
	}

	public Collection<ProfileCreationAssessmentsExperienceInTechnicalDomainDto> getProfileCreationAssessmentsExperienceInTechnicalDomainDto() {
		return profileCreationAssessmentsExperienceInTechnicalDomainDto;
	}

	public void setProfileCreationAssessmentsExperienceInTechnicalDomainDto(
			Collection<ProfileCreationAssessmentsExperienceInTechnicalDomainDto> profileCreationAssessmentsExperienceInTechnicalDomainDto) {
		this.profileCreationAssessmentsExperienceInTechnicalDomainDto = profileCreationAssessmentsExperienceInTechnicalDomainDto;
	}

	public Collection<ProfileCreationAssessmentStaffDetailsDto> getProfileCreationAssessmentStaffDetailsDto() {
		return profileCreationAssessmentStaffDetailsDto;
	}

	public void setProfileCreationAssessmentStaffDetailsDto(
			Collection<ProfileCreationAssessmentStaffDetailsDto> profileCreationAssessmentStaffDetailsDto) {
		this.profileCreationAssessmentStaffDetailsDto = profileCreationAssessmentStaffDetailsDto;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

}
