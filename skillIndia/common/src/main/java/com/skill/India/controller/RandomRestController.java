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
		LOGGER.info("In RandomRestController - singleFileUpload123");
		try{
			int i=0;
		for(MultipartFile m:file)
		{
		
			 byte[] bytes = m.getBytes();
			 System.out.println(m.getName());
			 Path path = Paths.get("D://"+m.getOriginalFilename()+i+".csv");
			 i++;
			 Files.write(path, bytes);
		System.out.println("LOL"+file);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "Here In Controller";
	}
}
