package com.skill.India.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.skill.India.service.DataImportCSVDownloadService;
import com.skill.India.service.DataImportDownloadCertificateService;
import com.skill.India.service.DataImportServices;




import com.skill.India.service.FindBatchUsingBatchIdService;
import com.skill.India.service.SaveCertificateFileService;
import com.skill.India.service.SaveUploadedFileService;
import com.skill.India.dto.DataImportGetBatchInfoDto;
import com.skill.India.dto.DataImportHistoryDto;

@RestController
public class DataImportController{
	@Autowired
	private DataImportServices dataImportServices;
	
	@Autowired
	private DataImportDownloadCertificateService dataImportDownloadCertificateService;
	
	@Autowired
	private DataImportCSVDownloadService dataImportCSVDownloadService;
	
	@Autowired
	private FindBatchUsingBatchIdService findBatchUsingBatchIdService;
	
	@Autowired
	private SaveCertificateFileService saveCertificateFileService;

	@Autowired 
	private SaveUploadedFileService saveUploadedFileService;

	
	@RequestMapping("/importHistory")
	public Collection<DataImportHistoryDto> getdataImportHistorydto(){
	return dataImportServices.getUpdateHistory();
}
	
		
@RequestMapping(value = "/downloadCertificate/{file_name}", method = RequestMethod.GET)
public void getCertificateFile(@PathVariable("file_name") String fileName, 
    HttpServletResponse response) {
    
	dataImportDownloadCertificateService.dataImportDownloadCertificate(response, fileName);
    
}
	

@RequestMapping(value = "/downloadCSVFile/{file_name}", method = RequestMethod.GET)
public void getFile(@PathVariable("file_name") String fileName, 
    HttpServletResponse response) {
	dataImportCSVDownloadService.DataImportCSVDownload(response, fileName);
}


@RequestMapping(value="/findBatch",method=RequestMethod.POST)

public Collection<DataImportGetBatchInfoDto> dataImportFindBatch(@RequestParam("batchId") Integer batchId){
	
	System.out.println("HERE");
	return findBatchUsingBatchIdService.findBatchUsingBatchId(batchId.toString());
	
}


@RequestMapping(value = "/uploadCertificate", method = { RequestMethod.GET, RequestMethod.POST },consumes=MediaType.ALL_VALUE)
public String singleFileUpload(@RequestParam("file") MultipartFile file,@RequestParam("batchId") Integer batchId, @RequestParam("userId") String userId){
//	String batchId="0";
//	String userId="0";

	return saveCertificateFileService.saveUploadedFile(file, batchId, userId);
	

}


@RequestMapping(value = "/upload", method = { RequestMethod.GET, RequestMethod.POST },consumes=MediaType.ALL_VALUE)
   public String singleFileUpload(@RequestParam("file") MultipartFile file,@RequestParam("csvType") String type) 
{
  String userId="1";
//  String type="batch";
  return saveUploadedFileService.saveUploadedFile(file,type,userId);
}


}