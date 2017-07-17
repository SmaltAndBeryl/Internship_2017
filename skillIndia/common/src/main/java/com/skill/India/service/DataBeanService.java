package com.skill.India.service;

import com.skill.India.POC.DataBean;
import com.skill.India.dao.DataBeanListDao;
import com.skill.India.dto.DataBeanDto;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

/**
 * Created by Alkesh srivastav on 7/13/2017.
 */
@Service
public class DataBeanService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(DataBeanService.class);
    @Autowired
    private DataBeanListDao dataBeanListDao;
        public Collection<DataBeanDto> dataBeanDtoCollection(){
            return dataBeanListDao.dataBeanDtoCollection();
    }
}
