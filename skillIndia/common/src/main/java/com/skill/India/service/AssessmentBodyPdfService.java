package com.skill.India.service;

import com.skill.India.dao.AssessmentBodyRegistrationDetailsDao;
import com.skill.India.dto.AssessmentBodyRegistrationDetailsDto;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AssessmentBodyPdfService {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(com.skill.India.service.AssessmentBodyPdfService.class);

    @Autowired
    private AssessmentBodyRegistrationDetailsDao assessmentBodyRegistrationDetailsDao;

    public Collection<AssessmentBodyRegistrationDetailsDto> dataBeanCollection(){
        return assessmentBodyRegistrationDetailsDao.dataBeanDtoCollectionAssessmentBodyRegistrationDetails();
    }
}
