package com.skill.India.service;

import com.skill.India.dao.DataBeanListDao;
import com.skill.India.dto.DataBeanDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Alkesh srivastav on 7/13/2017.
 */
@Service
public class DataBeanService {
    @Autowired
    private DataBeanListDao dataBeanListDao;

    public Collection<DataBeanDto> dataBeanDtoCollection(){
        return dataBeanListDao.dataBeanDtoCollection();
    }
}
