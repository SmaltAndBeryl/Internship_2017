package com.skill.India.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.common.ReadApplicationConstants;

@Service
public class DataImportCSVDownloadService {

	@Autowired
	private ReadApplicationConstants readApplicationConstants;


	public void DataImportCSVDownload(HttpServletResponse response,String fileName)
	{
	    try {
	    	String pathOfCSV=readApplicationConstants.getSaveCSVAtLocation()+fileName+".csv";
	        FileInputStream is = new FileInputStream(new File(pathOfCSV));
	        org.apache.commons.io.IOUtils.copy(is,response.getOutputStream());
	        response.setContentType("application/x-rar-compressed");
	        response.setHeader("Content-disposition", "attachment; filename="+ fileName+".csv");
	      } catch (IOException ex) {
	        throw new RuntimeException("IOError writing file to output stream");
	      }
	    catch (Exception e) {
			// ERROR PAGE 
		}

	}
}
