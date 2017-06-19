package com.skill.India.POC;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.dao.PetPOCDao;
import com.skill.India.dto.PetDto;

@RestController
public class DatabasePOCController {

	@Autowired
	private PetPOCDao pocDao;
	private static final Logger LOG = LoggerFactory.getLogger(DatabasePOCController.class);
	@RequestMapping(value = "/pet", method = RequestMethod.GET)
	public Collection<PetDto> getPetDto () {
		int key = pocDao.insertPOC();
		LOG.info("Key is : {}", key);
		return pocDao.getPetRowMapper();
	}	
}
