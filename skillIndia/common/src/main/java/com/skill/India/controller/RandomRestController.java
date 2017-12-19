package com.skill.India.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class RandomRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RandomRestController.class);
	
	@RequestMapping(value = "/a", method = { RequestMethod.GET, RequestMethod.POST },consumes=MediaType.ALL_VALUE)
	public String singleFileUpload123(@RequestParam("uplo") MultipartFile[] file) 
	{
		LOGGER.debug("In RandomRestController - singleFileUpload123");
		LOGGER.debug("Request received from front end ");
		LOGGER.debug("Parameters Received from front end are - 'MultipartFile': "+file);
		
		try{
			LOGGER.debug("Inside TRY block");
			int i=0;
		for(MultipartFile m:file)
		{
			 LOGGER.debug("Iterating file array to get all files");
			 LOGGER.debug("Creating byte array object");
			 byte[] bytes = m.getBytes();
			 LOGGER.debug("Successfully created and initialized");
//			 System.out.println(m.getName());
			 LOGGER.debug("Creating Path object");
			 Path path = Paths.get("D://"+m.getOriginalFilename()+i+".csv");
			 LOGGER.debug("Successfully created and initialized");
			 i++;
			 LOGGER.debug("Writing the file on path");
			 Files.write(path, bytes);
			 LOGGER.debug("Successfully completed");
//		System.out.println("LOL"+file);
		}
		}
		catch(Exception e)
		{
			LOGGER.debug("In CATCH block");
			LOGGER.error("ERROR: Encountered an exception.");
			LOGGER.error("Exception is : "+e);
//			e.printStackTrace();
		}
		return "Here In Controller";
	}
}
