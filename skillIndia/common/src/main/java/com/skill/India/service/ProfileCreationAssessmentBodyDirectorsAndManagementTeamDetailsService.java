package com.skill.India.service;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.skill.India.dao.ProfileCreationAssessmentBodyDeleteDataDao;
import com.skill.India.dao.ProfileCreationAssessmentBodyInsertDataDao;
import com.skill.India.dao.ProfileCreationAssessmentBodyUpdateDataDao;
import com.skill.India.dto.ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto;

@Service
public class ProfileCreationAssessmentBodyDirectorsAndManagementTeamDetailsService {

	@Autowired
	private ProfileCreationAssessmentBodyDeleteDataDao profileCreationAssessmentBodyDeleteDataDao;
	
	@Autowired
	private ProfileCreationAssessmentBodyUpdateDataDao profileCreationAssessmentBodyUpdateDataDao;
	
	@Autowired
	private ProfileCreationAssessmentBodyInsertDataDao profileCreationAssessmentBodyInsertDataDao;

	@Autowired
	private ProfileCreationSaveFile profileCreationSaveFile;
	

}
