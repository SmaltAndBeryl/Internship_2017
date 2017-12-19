package com.skill.India.service;

import com.skill.India.dao.AssessmentBodyRegistrationIdDao;
import com.skill.India.dao.TrainingPartnerRegistrationIdDao;
import com.skill.India.dao.UserRoleApplicationIdDao;
import com.skill.India.dto.AssessmentBodyRegistrationIdDto;
import com.skill.India.dto.TrainingPartnerRegistrationIdDto;
import com.skill.India.dto.UserRoleApplicationIdDto;
import net.sf.jasperreports.engine.JRException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collection;

@Service
public class UserRoleApplicationIdService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(com.skill.India.service.UserRoleApplicationIdService.class);
    @Autowired
    UserRoleApplicationIdDao userRoleApplicationIdDao;

    @Autowired
    TrainingPartnerRegistrationIdDao trainingPartnerRegistrationIdDao;

    @Autowired
    AssessmentBodyRegistrationIdDao assessmentBodyRegistrationIdDao;

    @Autowired
    DataBeanService dataBeanService;

    @Autowired
    AssessmentBodyPdfService assessmentBodyPdfService;

    public int userRoleApplicationIdDtos(String applicationId) throws IOException, JRException {
        Collection<UserRoleApplicationIdDto> userRoleApplicationIdDtos = userRoleApplicationIdDao.dataBeanCollectionUserRoleApplicationId(applicationId);

        Collection<TrainingPartnerRegistrationIdDto> trainingPartnerRegistrationIdDtos = trainingPartnerRegistrationIdDao.trainingPartnerRegistrationId(applicationId);
        Collection<AssessmentBodyRegistrationIdDto> assessmentBodyRegistrationIdDtos = assessmentBodyRegistrationIdDao.assessmentBodyRegistrationIdRegistrationIdDtos(applicationId);

        int success = 0;
        for(UserRoleApplicationIdDto userRoleApplicationIdDto : userRoleApplicationIdDtos){
            String userRole = userRoleApplicationIdDto.getUserRole();

            LOGGER.debug("THE USER ROLE IS "+ userRole + " AND APPLICATION ID IS " + applicationId);

            if(userRole.equalsIgnoreCase("TP")){
                LOGGER.debug("PRINTING THE trainingPartnerRegistrationId for each user of the Training Partner");
                if(!trainingPartnerRegistrationIdDtos.isEmpty()){
                    LOGGER.debug("THE trainingPartnerRegistrationIdDtos are not empty and have a size " + trainingPartnerRegistrationIdDtos.size());
                    for(TrainingPartnerRegistrationIdDto beanDto : trainingPartnerRegistrationIdDtos){
                        String trainingPartnerRegistrationId = beanDto.getTrainingPartnerRegistrationId();
                        LOGGER.debug("TRAINING PARTNER ID IS " + beanDto.getTrainingPartnerRegistrationId());
                        success = dataBeanService.dataBeanDtoCollection(trainingPartnerRegistrationId);
                    }
                }
                else {
                    LOGGER.debug("THE training partner registration ID Dtos are empty with size " + trainingPartnerRegistrationIdDtos.size());
                    success = 2;
                }
            }

            else if(userRole.equalsIgnoreCase("AB")){
                LOGGER.debug("THE USER IS ASSESSMENT BODY");
                if(!assessmentBodyRegistrationIdDtos.isEmpty()){
                    for(AssessmentBodyRegistrationIdDto beanDto : assessmentBodyRegistrationIdDtos){
                        String assessmentBodyRegistrationId = beanDto.getAssessmentBodyRegistrationId();
                        LOGGER.debug("ASSESSMENT BODY REGISTRATION ID IS " + beanDto.getAssessmentBodyRegistrationId());
                        success = assessmentBodyPdfService.dataBeanCollection(assessmentBodyRegistrationId);
                    }
                }
                else {
                    LOGGER.debug("The assessment body Id dtos are empty with size " + assessmentBodyRegistrationIdDtos.size());
                    success = 2;
                }
            }

        }
        LOGGER.debug("THE success value being returned is "+ success);
        return success;
    }
}
