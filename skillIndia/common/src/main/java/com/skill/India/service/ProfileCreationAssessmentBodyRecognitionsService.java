package com.skill.India.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.ProfileCreationAssessmentBodyDeleteDataDao;
import com.skill.India.dao.ProfileCreationAssessmentBodyInsertDataDao;
import com.skill.India.dao.ProfileCreationAssessmentBodyUpdateDataDao;
import com.skill.India.dto.ProfileCreationAssessmentBodyRecognitionsDto;

@Service
public class ProfileCreationAssessmentBodyRecognitionsService {

	@Autowired
	private ProfileCreationAssessmentBodyDeleteDataDao profileCreationAssessmentBodyDeleteDataDao;
	
	@Autowired
	private ProfileCreationAssessmentBodyUpdateDataDao profileCreationAssessmentBodyUpdateDataDao;
	
	@Autowired
	private ProfileCreationAssessmentBodyInsertDataDao profileCreationAssessmentBodyInsertDataDao;
}
