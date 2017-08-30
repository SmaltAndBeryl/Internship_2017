package com.skill.India.service;

import com.skill.India.dao.TrainingPartnerRegistrationIdDao;
import com.skill.India.dto.TrainingPartnerRegistrationIdDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TrainingPartnerRegistrationIdService {

    @Autowired
    TrainingPartnerRegistrationIdDao trainingPartnerRegistrationIdDao;

    public Collection<TrainingPartnerRegistrationIdDto> trainingPartnerRegistrationId(String applicationId){
       return trainingPartnerRegistrationIdDao.trainingPartnerRegistrationId(applicationId);
    }
}
