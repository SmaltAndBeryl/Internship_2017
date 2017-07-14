package com.skill.India.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skill.India.service.DataImportServices;




import com.skill.India.dto.DataImportHistoryDto;

@RestController
public class DataImportController{
	@Autowired
	private DataImportServices dataImportServices;
	
	@RequestMapping("/importHistory")
	public Collection<DataImportHistoryDto> getdataImportHistorydto(){
	return dataImportServices.getUpdateHistory();
}
	@RequestMapping(value = "/files/{file_name}", method = RequestMethod.GET)
	public void getFile(@PathVariable("file_name") String fileName, 
	    HttpServletResponse response) {
	    try {
	      // get your file as InputStream
	     
	     FileInputStream is = new FileInputStream(new File("D://New folder//trunk//skillIndia//server//src//main//resources//static//sheets.csv"));
	     //FileInputStream is = new FileInputStream(new File("http://www.colorado.edu/conflict/peace/download/peace.zip"));
	     
	     // copy it to response's OutputStream
	      org.apache.commons.io.IOUtils.copy(is,response.getOutputStream());
	      response.setContentType("application/x-rar-compressed");
	      response.setHeader("Content-disposition", "attachment; filename="+ fileName+".csv");
	      //response.flushBuffer();
	      System.out.println(response.getOutputStream());
	      //return response;
	    } catch (IOException ex) {
	      //.info("Error writing file to output stream. Filename was '{}'", fileName, ex);
	      throw new RuntimeException("IOError writing file to output stream");
	    }

	    
	    
	    
	}
	
}
