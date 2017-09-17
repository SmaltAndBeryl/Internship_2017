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

            LOGGER.info("THE USER ROLE IS "+ userRole + " AND APPLICATION ID IS " + applicationId);

            if(userRole.equalsIgnoreCase("TP")){
                LOGGER.info("PRINTING THE trainingPartnerRegistrationId for each user of the Training Partner");
                if(!trainingPartnerRegistrationIdDtos.isEmpty()){
                    LOGGER.info("THE trainingPartnerRegistrationIdDtos are not empty and have a size " + trainingPartnerRegistrationIdDtos.size());
                    for(TrainingPartnerRegistrationIdDto beanDto : trainingPartnerRegistrationIdDtos){
                        String trainingPartnerRegistrationId = beanDto.getTrainingPartnerRegistrationId();
                        LOGGER.info("TRAINING PARTNER ID IS " + beanDto.getTrainingPartnerRegistrationId());
                        success = dataBeanService.dataBeanDtoCollection(trainingPartnerRegistrationId);
                    }
                }
                else {
                    LOGGER.info("THE training partner registration ID Dtos are empty with size " + trainingPartnerRegistrationIdDtos.size());
                    success = 2;
                }
            }

            else if(userRole.equalsIgnoreCase("AB")){
                LOGGER.info("THE USER IS ASSESSMENT BODY");
                if(!assessmentBodyRegistrationIdDtos.isEmpty()){
                    for(AssessmentBodyRegistrationIdDto beanDto : assessmentBodyRegistrationIdDtos){
                        String assessmentBodyRegistrationId = beanDto.getAssessmentBodyRegistrationId();
                        LOGGER.info("ASSESSMENT BODY REGISTRATION ID IS " + beanDto.getAssessmentBodyRegistrationId());
                        success = assessmentBodyPdfService.dataBeanCollection(assessmentBodyRegistrationId);
                    }
                }
                else {
                    LOGGER.info("The assessment body Id dtos are empty with size " + assessmentBodyRegistrationIdDtos.size());
                    success = 2;
                }
            }

        }
        LOGGER.info("THE success value being returned is "+ success);
        return success;
    }
}
