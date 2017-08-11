package com.skill.India.dto;

public class ProfileCreationTrainingPartnerInstituteGrantDto {

	private String nameOfMinistry;
	private String natureOfWork;
	private String remarks;
	
	
	
	
	/**
	 * 
	 */
	public ProfileCreationTrainingPartnerInstituteGrantDto() {
		super();
	}
	/**
	 * @param nameOfMinistry
	 * @param natureOfWork
	 * @param remarks
	 */
	public ProfileCreationTrainingPartnerInstituteGrantDto(String nameOfMinistry,
			String natureOfWork, String remarks) {
		super();
		this.nameOfMinistry = nameOfMinistry;
		this.natureOfWork = natureOfWork;
		this.remarks = remarks;
	}
	/**
	 * @return the nameOfMinistry
	 */
	public String getNameOfMinistry() {
		return nameOfMinistry;
	}
	/**
	 * @param nameOfMinistry the nameOfMinistry to set
	 */
	public void setNameOfMinistry(String nameOfMinistry) {
		this.nameOfMinistry = nameOfMinistry;
	}
	/**
	 * @return the natureOfWork
	 */
	public String getNatureOfWork() {
		return natureOfWork;
	}
	/**
	 * @param natureOfWork the natureOfWork to set
	 */
	public void setNatureOfWork(String natureOfWork) {
		this.natureOfWork = natureOfWork;
	}
	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}
