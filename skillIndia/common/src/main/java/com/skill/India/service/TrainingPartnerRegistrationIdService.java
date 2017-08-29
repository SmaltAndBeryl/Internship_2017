package com.skill.India.service;

import com.skill.India.dao.TrainingPartnerRegistrationIdDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingPartnerRegistrationIdService {

    @Autowired
    TrainingPartnerRegistrationIdDao trainingPartnerRegistrationIdDao;

    public String trainingPartnerRegistrationId(String organizationName){
        return String.valueOf(trainingPartnerRegistrationIdDao.trainingPartnerRegistrationId(organizationName));
    }
}
