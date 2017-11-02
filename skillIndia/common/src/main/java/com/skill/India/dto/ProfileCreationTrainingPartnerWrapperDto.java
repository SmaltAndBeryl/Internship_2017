package com.skill.India.dto;

import java.util.Collection;

public class ProfileCreationTrainingPartnerWrapperDto {

	private String type;
	private ProfileCreationTrainingPartnerOrganizationDetailsDto profileCreationTrainingPartnerOrganizationDetailsDto;
	private Collection<ProfileCreationTrainingPartnerCenterDetailsDto> profileCreationTrainingPartnerCenterDetailsDto;
	private Collection<ProfileCreationTrainingPartnerInstituteGrantDto> profileCreationTrainingPartnerInstituteGrantDto;
	private Collection<ProfileCreationTrainingPartnerInstituteRecognitionDto> profileCreationTrainingPartnerInstituteRecognitionDto;
	private Collection<ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto> profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto;
	private Collection <ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto> profileCreationTrainingPartnerPriorExperienceInSkillTrainingDto;
	
	public ProfileCreationTrainingPartnerWrapperDto()
	{
		super();
	}
	
	public ProfileCreationTrainingPartnerWrapperDto(String type, 
			ProfileCreationTrainingPartnerOrganizationDetailsDto profileCreationTrainingPartnerOrganizationDetailsDto,
			Collection<ProfileCreationTrainingPartnerCenterDetailsDto> profileCreationTrainingPartnerCenterDetailsDto,
			Collection<ProfileCreationTrainingPartnerInstituteGrantDto> profileCreationTrainingPartnerInstituteGrantDto,
			Collection<ProfileCreationTrainingPartnerInstituteRecognitionDto> profileCreationTrainingPartnerInstituteRecognitionDto,
			Collection<ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto> profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto,
			Collection <ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto> profileCreationTrainingPartnerPriorExperienceInSkillTrainingDto)
	{
		super();
		this.type = type;
		this.profileCreationTrainingPartnerOrganizationDetailsDto = profileCreationTrainingPartnerOrganizationDetailsDto;
		this.profileCreationTrainingPartnerCenterDetailsDto = profileCreationTrainingPartnerCenterDetailsDto;
		this.profileCreationTrainingPartnerInstituteGrantDto = profileCreationTrainingPartnerInstituteGrantDto;
		this.profileCreationTrainingPartnerInstituteRecognitionDto = profileCreationTrainingPartnerInstituteRecognitionDto;
		this.profileCreationTrainingPartnerPriorExperienceInSkillTrainingDto = profileCreationTrainingPartnerPriorExperienceInSkillTrainingDto;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ProfileCreationTrainingPartnerOrganizationDetailsDto getProfileCreationTrainingPartnerOrganizationDetailsDto() {
		return profileCreationTrainingPartnerOrganizationDetailsDto;
	}
	public void setProfileCreationTrainingPartnerOrganizationDetailsDto(
			ProfileCreationTrainingPartnerOrganizationDetailsDto profileCreationTrainingPartnerOrganizationDetailsDto) {
		this.profileCreationTrainingPartnerOrganizationDetailsDto = profileCreationTrainingPartnerOrganizationDetailsDto;
	}
	public Collection<ProfileCreationTrainingPartnerCenterDetailsDto> getProfileCreationTrainingPartnerCenterDetailsDto() {
		return profileCreationTrainingPartnerCenterDetailsDto;
	}
	public void setProfileCreationTrainingPartnerCenterDetailsDto(
			Collection<ProfileCreationTrainingPartnerCenterDetailsDto> profileCreationTrainingPartnerCenterDetailsDto) {
		this.profileCreationTrainingPartnerCenterDetailsDto = profileCreationTrainingPartnerCenterDetailsDto;
	}
	public Collection<ProfileCreationTrainingPartnerInstituteGrantDto> getProfileCreationTrainingPartnerInstituteGrantDto() {
		return profileCreationTrainingPartnerInstituteGrantDto;
	}
	public void setProfileCreationTrainingPartnerInstituteGrantDto(
			Collection<ProfileCreationTrainingPartnerInstituteGrantDto> profileCreationTrainingPartnerInstituteGrantDto) {
		this.profileCreationTrainingPartnerInstituteGrantDto = profileCreationTrainingPartnerInstituteGrantDto;
	}
	public Collection<ProfileCreationTrainingPartnerInstituteRecognitionDto> getProfileCreationTrainingPartnerInstituteRecognitionDto() {
		return profileCreationTrainingPartnerInstituteRecognitionDto;
	}
	public void setProfileCreationTrainingPartnerInstituteRecognitionDto(
			Collection<ProfileCreationTrainingPartnerInstituteRecognitionDto> profileCreationTrainingPartnerInstituteRecognitionDto) {
		this.profileCreationTrainingPartnerInstituteRecognitionDto = profileCreationTrainingPartnerInstituteRecognitionDto;
	}
	public Collection<ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto> getProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto() {
		return profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto;
	}
	public void setProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto(
			Collection<ProfileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto> profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto) {
		this.profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto = profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto;
	}
	public Collection <ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto> getProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto() {
		return profileCreationTrainingPartnerPriorExperienceInSkillTrainingDto;
	}
	public void setProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto(
			Collection <ProfileCreationTrainingPartnerPriorExperienceInSkillTrainingDto> profileCreationTrainingPartnerPriorExperienceInSkillTrainingDto) {
		this.profileCreationTrainingPartnerPriorExperienceInSkillTrainingDto = profileCreationTrainingPartnerPriorExperienceInSkillTrainingDto;
	}
	
	
}
