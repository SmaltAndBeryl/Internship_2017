package com.skill.India.service;


import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.DashboardTotalCandidatesTrainedWithBatchTypeInLastThreeYearsDao;
import com.skill.India.dao.DashboardPanelsDao;
import com.skill.India.dao.DashboardTotalBatchesAccordingToJobRoleDao;
import com.skill.India.dao.DashboardTotalCandidatesCertifiedWithModeInLastThreeYearsDao;
import com.skill.India.dao.DashboardTopStatesWithMaxTrainingCentersDao;
import com.skill.India.dto.DashboardTotalCandidatesTrainedWithBatchTypeInLastThreeYearsDto;
import com.skill.India.dto.DashboardTotalBatchesAccordingToJobRoleDto;
import com.skill.India.dto.DashboardTotalCandidatesCertifiedWithModeInLastThreeYearsDto;
import com.skill.India.dto.DashboardTopStatesWithMaxTrainingCentersDto;


 

@Service
public class DashboardService  {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DashboardService.class);

	@Autowired
	private DashboardPanelsDao dashboardPanelsDao;
	
	@Autowired 
	DashboardTotalBatchesAccordingToJobRoleDao dashboardPieChartDao;
	
	@Autowired
	DashboardTopStatesWithMaxTrainingCentersDao dashboardTopStatesDao;
	
	@Autowired
	DashboardTotalCandidatesCertifiedWithModeInLastThreeYearsDao dashboardStackedColumnChartDao;
	
	@Autowired
	DashboardTotalCandidatesTrainedWithBatchTypeInLastThreeYearsDao dashboardColumnChartDao;
	
	
	public Integer getTotalCandidatesEnrolled() {
		LOGGER.info("Request Received from Controller");
		LOGGER.info("In DashboardService - getTotalCandidatesEnrolled");
		LOGGER.info("Making a Request to Dao to get data"); 
		return dashboardPanelsDao.getTotalCandidateEnrolled();
	}
	
	public Integer getTotalCandidatesAccessed() {
		LOGGER.info("Request Received from Controller");
		LOGGER.info("In DashboardService - getTotalCandidatesAccessed");
		LOGGER.info("Making a Request to Dao to get data");
		return dashboardPanelsDao.getTotalCandidateAccessed();
	}
	
	public Integer getTotalCandidatesCertified() {
		LOGGER.info("Request Received from Controller");
		LOGGER.info("In DashboardService - getTotalCandidatesCertified");
		LOGGER.info("Making a Request to Dao to get data");
		return dashboardPanelsDao.getTotalCandidateCertified();
	}
	
	public Integer getTotalTrainingCentersInIndia() {
		LOGGER.info("Request Received from Controller");
		LOGGER.info("In DashboardService - getTotalTrainingCentersInIndia");
		LOGGER.info("Making a Request to Dao to get data");
		return dashboardPanelsDao.getTotalTrainingCentersInIndia();
	}
	
	public Integer getTotalTrainingPartners() {
		LOGGER.info("Request Received from Controller");
		LOGGER.info("In DashboardService - getTotalTrainingPartners");
		LOGGER.info("Making a Request to Dao to get data");
		return dashboardPanelsDao.getTotalTrainingPartners();
	}
	
	public Collection<DashboardTotalBatchesAccordingToJobRoleDto> getTotalBatchesAccordingToJobRole() {
		LOGGER.info("Request Received from Controller");
		LOGGER.info("In DashboardService - getTotalBatchesAccordingToJobRole");
		LOGGER.info("Making a Request to Dao to get data");
		return dashboardPieChartDao.getTotalBatchesAccordingToJobRole();
	}
	
	
public Collection<DashboardTopStatesWithMaxTrainingCentersDto> getTopStatesWithMaxTrainingCenters() {
	LOGGER.info("Request Received from Controller");
	LOGGER.info("In DashboardService - getTopStatesWithMaxTrainingCenters");
	LOGGER.info("Making a Request to Dao to get data");
	return dashboardTopStatesDao.getTopStatesWithMaxTrainingCenters();
}

public Collection<DashboardTotalCandidatesCertifiedWithModeInLastThreeYearsDto> getTotalCandidatesCertifiedWithModeInLastThreeYears() {
	LOGGER.info("Request Received from Controller");
	LOGGER.info("In DashboardService - getTotalCandidatesCertifiedWithModeInLastThreeYears");
	LOGGER.info("Making a Request to Dao to get data");
	return dashboardStackedColumnChartDao.getTotalCandidatesCertifiedWithModeInLastThreeYears();
	
}

public Collection<DashboardTotalCandidatesTrainedWithBatchTypeInLastThreeYearsDto> getTotalCandidatesTrainedWithBatchTypeInLastThreeYears() {
	LOGGER.info("Request Received from Controller");
	LOGGER.info("In DashboardService - getTotalCandidatesTrainedWithBatchTypeInLastThreeYears");
	LOGGER.info("Making a Request to Dao to get data");
	return dashboardColumnChartDao.getTotalCandidatesTrainedWithBatchTypeInLastThreeYears();
}


	
}