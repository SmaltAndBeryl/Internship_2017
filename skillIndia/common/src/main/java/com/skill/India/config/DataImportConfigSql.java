package com.skill.India.config;
/*
 * Author 		: Ruchit Jain 
 * Description  : This file contains Getters and Setters to fetch corresponding SQL 
 * 				  from .yml file .
 */
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix="DataImport",locations="classpath:sql/DataImport.yml")
public class DataImportConfigSql {

		/*
		 * For Assessor
		 */
		private String agencyIdExistsForAssessor;
		private String insertIntoAssessorSql;
		private String assessorIdExistsForAssessor;
		private String updateIntoAssessorSql;
	
		/*
		 * For Candidate
		 */
				
		private String batchIdemployerIdExistsForCandidate;
		private String candidateDeatilsIdExistsForCandidate;
		private String insertIntoCandidateSql;
		private String updateIntoCandidateSql;
		
		/*
		 * For Batch
		 */
		
		private String trainingPartnerIdExistsForBatch;
		private String centreIdExistsForBatch;
		private String trainerIdExistsForBatch;
		private String agencyIdExistsForBatch;
		private String assessorIdExistsForBatch;
		private String batchIdExistsForBatch;
		private String insertIntoBatchSql;
		private String updateIntoBatchSql;
		
		/*
		 * For Agency
		*/
		
		private String applicationIdExistsForAgency;
		private String agencyIdExistsForAgency;
		private String insertIntoAgencySql;
		private String updateIntoAgencySql;
		
		/*
		 * For Centre
		 */
		
		private String trainingPartnerIdExistsForCentre;
		private String centreIdExistsForCentre;
		private String insertIntoCentreSql;
		private String updateIntoCentreSql;
		
		/*
		 * For Employer
		 */
		
		private String employerIdExistsForEmployer;
		private String insertIntoEmployer;
		private String updateIntoEmployer;
		
		/*
		 * For Trainer
		 */
		
		private String trainingPartnerIdExistsForTrainer;
		private String trainerIdExistsForTrainer;
		private String insertIntoTrainer;
		private String updateIntoTrainer;
		
		/*
		 * For Training Partner
		 */
		
		private String applicationIdExistsForTrainingPartner;
		private String trainingPartnerIdExistsForTrainingPartner;
		private String insertIntoTrainingPartner;
		private String updateIntoTrainingPartner;
		
		
		/*
		 * For csvuploaded
		 */
		
		private String userIdExistsForCSVUploaded;;
		private String insertIntoCSVUploaded;
		
		/*
		 * For Certificate
		 */
		
		private String userIdBatchIdExistsForCertificate;
		private String insertIntoCertificate;
		private String batchInfoUsingBatchId;
		
		
		
		
		
		
		
		/**
		 * @return the trainingPartnerIdExistsForBatch
		 */
		public String getTrainingPartnerIdExistsForBatch() {
			return trainingPartnerIdExistsForBatch;
		}

		/**
		 * @param trainingPartnerIdExistsForBatch the trainingPartnerIdExistsForBatch to set
		 */
		public void setTrainingPartnerIdExistsForBatch(
				String trainingPartnerIdExistsForBatch) {
			this.trainingPartnerIdExistsForBatch = trainingPartnerIdExistsForBatch;
		}

		/**
		 * @return the centreIdExistsForBatch
		 */
		public String getCentreIdExistsForBatch() {
			return centreIdExistsForBatch;
		}

		/**
		 * @param centreIdExistsForBatch the centreIdExistsForBatch to set
		 */
		public void setCentreIdExistsForBatch(String centreIdExistsForBatch) {
			this.centreIdExistsForBatch = centreIdExistsForBatch;
		}

		/**
		 * @return the trainerIdExistsForBatch
		 */
		public String getTrainerIdExistsForBatch() {
			return trainerIdExistsForBatch;
		}

		/**
		 * @param trainerIdExistsForBatch the trainerIdExistsForBatch to set
		 */
		public void setTrainerIdExistsForBatch(String trainerIdExistsForBatch) {
			this.trainerIdExistsForBatch = trainerIdExistsForBatch;
		}

		/**
		 * @return the agencyIdExistsForBatch
		 */
		public String getAgencyIdExistsForBatch() {
			return agencyIdExistsForBatch;
		}

		/**
		 * @param agencyIdExistsForBatch the agencyIdExistsForBatch to set
		 */
		public void setAgencyIdExistsForBatch(String agencyIdExistsForBatch) {
			this.agencyIdExistsForBatch = agencyIdExistsForBatch;
		}

		/**
		 * @return the assessorIdExistsForBatch
		 */
		public String getAssessorIdExistsForBatch() {
			return assessorIdExistsForBatch;
		}

		/**
		 * @param assessorIdExistsForBatch the assessorIdExistsForBatch to set
		 */
		public void setAssessorIdExistsForBatch(String assessorIdExistsForBatch) {
			this.assessorIdExistsForBatch = assessorIdExistsForBatch;
		}

		/**
		 * @return the batchInfoUsingBatchId
		 */
		public String getBatchInfoUsingBatchId() {
			return batchInfoUsingBatchId;
		}

		/**
		 * @param batchInfoUsingBatchId the batchInfoUsingBatchId to set
		 */
		public void setBatchInfoUsingBatchId(String batchInfoUsingBatchId) {
			this.batchInfoUsingBatchId = batchInfoUsingBatchId;
		}

		/**
		 * @return the userIdBatchIdExistsForCertificate
		 */
		public String getUserIdBatchIdExistsForCertificate() {
			return userIdBatchIdExistsForCertificate;
		}

		/**
		 * @param userIdBatchIdExistsForCertificate the userIdBatchIdExistsForCertificate to set
		 */
		public void setUserIdBatchIdExistsForCertificate(
				String userIdBatchIdExistsForCertificate) {
			this.userIdBatchIdExistsForCertificate = userIdBatchIdExistsForCertificate;
		}

		/**
		 * @return the insertIntoCertificate
		 */
		public String getInsertIntoCertificate() {
			return insertIntoCertificate;
		}

		/**
		 * @param insertIntoCertificate the insertIntoCertificate to set
		 */
		public void setInsertIntoCertificate(String insertIntoCertificate) {
			this.insertIntoCertificate = insertIntoCertificate;
		}

		/**
		 * @return the userIdExistsForCSVUploaded
		 */
		public String getUserIdExistsForCSVUploaded() {
			return userIdExistsForCSVUploaded;
		}

		/**
		 * @param userIdExistsForCSVUploaded the userIdExistsForCSVUploaded to set
		 */
		public void setUserIdExistsForCSVUploaded(String userIdExistsForCSVUploaded) {
			this.userIdExistsForCSVUploaded = userIdExistsForCSVUploaded;
		}

		/**
		 * @return the insertIntoCSVUploaded
		 */
		public String getInsertIntoCSVUploaded() {
			return insertIntoCSVUploaded;
		}

		/**
		 * @param insertIntoCSVUploaded the insertIntoCSVUploaded to set
		 */
		public void setInsertIntoCSVUploaded(String insertIntoCSVUploaded) {
			this.insertIntoCSVUploaded = insertIntoCSVUploaded;
		}

		/**
		 * @return the applicationIdExistsForTrainingPartner
		 */
		public String getApplicationIdExistsForTrainingPartner() {
			return applicationIdExistsForTrainingPartner;
		}

		/**
		 * @param applicationIdExistsForTrainingPartner the applicationIdExistsForTrainingPartner to set
		 */
		public void setApplicationIdExistsForTrainingPartner(
				String applicationIdExistsForTrainingPartner) {
			this.applicationIdExistsForTrainingPartner = applicationIdExistsForTrainingPartner;
		}

		
		/**
		 * @return the trainingPartnerIdExistsForTrainingPartner
		 */
		public String getTrainingPartnerIdExistsForTrainingPartner() {
			return trainingPartnerIdExistsForTrainingPartner;
		}

		/**
		 * @param trainingPartnerIdExistsForTrainingPartner the trainingPartnerIdExistsForTrainingPartner to set
		 */
		public void setTrainingPartnerIdExistsForTrainingPartner(
				String trainingPartnerIdExistsForTrainingPartner) {
			this.trainingPartnerIdExistsForTrainingPartner = trainingPartnerIdExistsForTrainingPartner;
		}

		/**
		 * @return the insertIntoTrainingPartner
		 */
		public String getInsertIntoTrainingPartner() {
			return insertIntoTrainingPartner;
		}

		/**
		 * @param insertIntoTrainingPartner the insertIntoTrainingPartner to set
		 */
		public void setInsertIntoTrainingPartner(String insertIntoTrainingPartner) {
			this.insertIntoTrainingPartner = insertIntoTrainingPartner;
		}

		/**
		 * @return the updateIntoTrainingPartner
		 */
		public String getUpdateIntoTrainingPartner() {
			return updateIntoTrainingPartner;
		}

		/**
		 * @param updateIntoTrainingPartner the updateIntoTrainingPartner to set
		 */
		public void setUpdateIntoTrainingPartner(String updateIntoTrainingPartner) {
			this.updateIntoTrainingPartner = updateIntoTrainingPartner;
		}

		/**
		 * @return the trainingPartnerIdExistsForTrainer
		 */
		public String getTrainingPartnerIdExistsForTrainer() {
			return trainingPartnerIdExistsForTrainer;
		}

		/**
		 * @param trainingPartnerIdExistsForTrainer the trainingPartnerIdExistsForTrainer to set
		 */
		public void setTrainingPartnerIdExistsForTrainer(
				String trainingPartnerIdExistsForTrainer) {
			this.trainingPartnerIdExistsForTrainer = trainingPartnerIdExistsForTrainer;
		}

		/**
		 * @return the trainerIdExistsForTrainer
		 */
		public String getTrainerIdExistsForTrainer() {
			return trainerIdExistsForTrainer;
		}

		/**
		 * @param trainerIdExistsForTrainer the trainerIdExistsForTrainer to set
		 */
		public void setTrainerIdExistsForTrainer(String trainerIdExistsForTrainer) {
			this.trainerIdExistsForTrainer = trainerIdExistsForTrainer;
		}

		/**
		 * @return the insertIntoTrainer
		 */
		public String getInsertIntoTrainer() {
			return insertIntoTrainer;
		}

		/**
		 * @param insertIntoTrainer the insertIntoTrainer to set
		 */
		public void setInsertIntoTrainer(String insertIntoTrainer) {
			this.insertIntoTrainer = insertIntoTrainer;
		}

		/**
		 * @return the updateIntoTrainer
		 */
		public String getUpdateIntoTrainer() {
			return updateIntoTrainer;
		}

		/**
		 * @param updateIntoTrainer the updateIntoTrainer to set
		 */
		public void setUpdateIntoTrainer(String updateIntoTrainer) {
			this.updateIntoTrainer = updateIntoTrainer;
		}

		/**
		 * @return the employerIdExistsForEmployer
		 */
		public String getEmployerIdExistsForEmployer() {
			return employerIdExistsForEmployer;
		}

		/**
		 * @param employerIdExistsForEmployer the employerIdExistsForEmployer to set
		 */
		public void setEmployerIdExistsForEmployer(String employerIdExistsForEmployer) {
			this.employerIdExistsForEmployer = employerIdExistsForEmployer;
		}

		/**
		 * @return the insertIntoEmployer
		 */
		public String getInsertIntoEmployer() {
			return insertIntoEmployer;
		}

		/**
		 * @param insertIntoEmployer the insertIntoEmployer to set
		 */
		public void setInsertIntoEmployer(String insertIntoEmployer) {
			this.insertIntoEmployer = insertIntoEmployer;
		}

		/**
		 * @return the updateIntoEmployer
		 */
		public String getUpdateIntoEmployer() {
			return updateIntoEmployer;
		}

		/**
		 * @param updateIntoEmployer the updateIntoEmployer to set
		 */
		public void setUpdateIntoEmployer(String updateIntoEmployer) {
			this.updateIntoEmployer = updateIntoEmployer;
		}

		/**
		 * @return the trainingPartnerIdExistsForCentre
		 */
		public String getTrainingPartnerIdExistsForCentre() {
			return trainingPartnerIdExistsForCentre;
		}

		/**
		 * @param trainingPartnerIdExistsForCentre the trainingPartnerIdExistsForCentre to set
		 */
		public void setTrainingPartnerIdExistsForCentre(
				String trainingPartnerIdExistsForCentre) {
			this.trainingPartnerIdExistsForCentre = trainingPartnerIdExistsForCentre;
		}

		/**
		 * @return the centreIdExistsForCentre
		 */
		public String getCentreIdExistsForCentre() {
			return centreIdExistsForCentre;
		}

		/**
		 * @param centreIdExistsForCentre the centreIdExistsForCentre to set
		 */
		public void setCentreIdExistsForCentre(String centreIdExistsForCentre) {
			this.centreIdExistsForCentre = centreIdExistsForCentre;
		}

		/**
		 * @return the insertIntoCentreSql
		 */
		public String getInsertIntoCentreSql() {
			return insertIntoCentreSql;
		}

		/**
		 * @param insertIntoCentreSql the insertIntoCentreSql to set
		 */
		public void setInsertIntoCentreSql(String insertIntoCentreSql) {
			this.insertIntoCentreSql = insertIntoCentreSql;
		}

		/**
		 * @return the updateIntoCentreSql
		 */
		public String getUpdateIntoCentreSql() {
			return updateIntoCentreSql;
		}

		/**
		 * @param updateIntoCentreSql the updateIntoCentreSql to set
		 */
		public void setUpdateIntoCentreSql(String updateIntoCentreSql) {
			this.updateIntoCentreSql = updateIntoCentreSql;
		}

		/**
		 * @return the applicationIdExistsForAgency
		 */
		public String getApplicationIdExistsForAgency() {
			return applicationIdExistsForAgency;
		}

		/**
		 * @param applicationIdExistsForAgency the applicationIdExistsForAgency to set
		 */
		public void setApplicationIdExistsForAgency(String applicationIdExistsForAgency) {
			this.applicationIdExistsForAgency = applicationIdExistsForAgency;
		}

		/**
		 * @return the agencyIdExistsForAgency
		 */
		public String getAgencyIdExistsForAgency() {
			return agencyIdExistsForAgency;
		}

		/**
		 * @param agencyIdExistsForAgency the agencyIdExistsForAgency to set
		 */
		public void setAgencyIdExistsForAgency(String agencyIdExistsForAgency) {
			this.agencyIdExistsForAgency = agencyIdExistsForAgency;
		}

		/**
		 * @return the insertIntoAgencySql
		 */
		public String getInsertIntoAgencySql() {
			return insertIntoAgencySql;
		}

		/**
		 * @param insertIntoAgencySql the insertIntoAgencySql to set
		 */
		public void setInsertIntoAgencySql(String insertIntoAgencySql) {
			this.insertIntoAgencySql = insertIntoAgencySql;
		}

		/**
		 * @return the updateIntoAgencySql
		 */
		public String getUpdateIntoAgencySql() {
			return updateIntoAgencySql;
		}

		/**
		 * @param updateIntoAgencySql the updateIntoAgencySql to set
		 */
		public void setUpdateIntoAgencySql(String updateIntoAgencySql) {
			this.updateIntoAgencySql = updateIntoAgencySql;
		}

		/**
		 * @return the batchIdExistsForCandidate
		 */
		public String getBatchIdExistsForBatch() {
			return batchIdExistsForBatch;
		}

		/**
		 * @param batchIdExistsForCandidate the batchIdExistsForCandidate to set
		 */
		public void setBatchIdExistsForBatch(String batchIdExistsForBatch) {
			this.batchIdExistsForBatch = batchIdExistsForBatch;
		}

		/**
		 * @return the insertIntoBatchSql
		 */
		public String getInsertIntoBatchSql() {
			return insertIntoBatchSql;
		}

		/**
		 * @param insertIntoBatchSql the insertIntoBatchSql to set
		 */
		public void setInsertIntoBatchSql(String insertIntoBatchSql) {
			this.insertIntoBatchSql = insertIntoBatchSql;
		}

		/**
		 * @return the updateIntoBatchSql
		 */
		public String getUpdateIntoBatchSql() {
			return updateIntoBatchSql;
		}

		/**
		 * @param updateIntoBatchSql the updateIntoBatchSql to set
		 */
		public void setUpdateIntoBatchSql(String updateIntoBatchSql) {
			this.updateIntoBatchSql = updateIntoBatchSql;
		}

		/**
		 * @return the candidateDeatilsIdExistsForCandidate
		 */
		public String getCandidateDeatilsIdExistsForCandidate() {
			return candidateDeatilsIdExistsForCandidate;
		}

		/**
		 * @param candidateDeatilsIdExistsForCandidate the candidateDeatilsIdExistsForCandidate to set
		 */
		public void setCandidateDeatilsIdExistsForCandidate(
				String candidateDeatilsIdExistsForCandidate) {
			this.candidateDeatilsIdExistsForCandidate = candidateDeatilsIdExistsForCandidate;
		}

		/**
		 * @return the insertIntoCandidateSql
		 */
		public String getInsertIntoCandidateSql() {
			return insertIntoCandidateSql;
		}

		/**
		 * @param insertIntoCandidateSql the insertIntoCandidateSql to set
		 */
		public void setInsertIntoCandidateSql(String insertIntoCandidateSql) {
			this.insertIntoCandidateSql = insertIntoCandidateSql;
		}

		/**
		 * @return the updateIntoCandidateSql
		 */
		public String getUpdateIntoCandidateSql() {
			return updateIntoCandidateSql;
		}

		/**
		 * @param updateIntoCandidateSql the updateIntoCandidateSql to set
		 */
		public void setUpdateIntoCandidateSql(String updateIntoCandidateSql) {
			this.updateIntoCandidateSql = updateIntoCandidateSql;
		}

		/**
		 * @return the batchIdemployerIdExistsForCandidate
		 */
		public String getBatchIdemployerIdExistsForCandidate() {
			return batchIdemployerIdExistsForCandidate;
		}

		/**
		 * @param batchIdemployerIdExistsForCandidate the batchIdemployerIdExistsForCandidate to set
		 */
		public void setBatchIdemployerIdExistsForCandidate(
				String batchIdemployerIdExistsForCandidate) {
			this.batchIdemployerIdExistsForCandidate = batchIdemployerIdExistsForCandidate;
		}

		/**
		 * @return the updateIntoAssessorSql
		 */
		public String getUpdateIntoAssessorSql() {
			return updateIntoAssessorSql;
		}

		/**
		 * @param updateIntoAssessorSql the updateIntoAssessorSql to set
		 */
		public void setUpdateIntoAssessorSql(String updateIntoAssessorSql) {
			this.updateIntoAssessorSql = updateIntoAssessorSql;
		}

		/**
		 * @return the assessorIdExistsForAssessor
		 */
		public String getAssessorIdExistsForAssessor() {
			return assessorIdExistsForAssessor;
		}

		/**
		 * @param assessorIdExistsForAssessor the assessorIdExistsForAssessor to set
		 */
		public void setAssessorIdExistsForAssessor(String assessorIdExistsForAssessor) {
			this.assessorIdExistsForAssessor = assessorIdExistsForAssessor;
		}

		/**
		 * @return the insertIntoAssessorSql
		 */
		public String getInsertIntoAssessorSql() {
			return insertIntoAssessorSql;
		}

		/**
		 * @param insertIntoAssessorSql the insertIntoAssessorSql to set
		 */
		public void setInsertIntoAssessorSql(String insertIntoAssessorSql) {
			this.insertIntoAssessorSql = insertIntoAssessorSql;
		}

		/**
		 * @return the selectAgencyIdFromAssessor
		 */
		public String getAgencyIdExistsForAssessor() {
			return agencyIdExistsForAssessor;
		}

		/**
		 * @param selectAgencyIdFromAssessor the selectAgencyIdFromAssessor to set
		 */
		public void setAgencyIdExistsForAssessor(String agencyIdExistsForAssessor) {
			this.agencyIdExistsForAssessor = agencyIdExistsForAssessor;
		}


}
