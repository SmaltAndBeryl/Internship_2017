package com.skill.India.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.skill.India.service.CertificateImportHistoryService;
import com.skill.India.service.DataImportCSVDownloadService;
import com.skill.India.service.DataImportDownloadCertificateService;
import com.skill.India.service.DataImportServices;




import com.skill.India.service.FindBatchUsingBatchIdService;
import com.skill.India.service.SaveCertificateFileService;
import com.skill.India.service.SaveUploadedFileService;
import com.skill.India.common.FileExistsUtility;
import com.skill.India.common.Privilege;
import com.skill.India.common.ReadApplicationConstants;
import com.skill.India.common.SessionUserUtility;
import com.skill.India.dto.CertificateImportHistorydto;
import com.skill.India.dto.DataImportGetBatchInfoDto;
import com.skill.India.dto.DataImportHistoryDto;

@RestController
public class DataImportController{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DataImportController.class);
	
	@Autowired
	private FileExistsUtility fileExistsUtility;
	
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

	@Autowired
	private CertificateImportHistoryService certificateImportHistoryService;
	
	@Autowired
	private SessionUserUtility sessionUserUtility; 
	
	
	@Autowired
	private ReadApplicationConstants readApplicationConstants;
	
@Privilege(value={"SCGJ"})
@RequestMapping("/importHistory")
public Collection<DataImportHistoryDto> getdataImportHistorydto(){

LOGGER.debug("Request Received from front end to get Data for Import History Table in Data Import");

return dataImportServices.getUpdateHistory();
}
	
		
@Privilege(value={"SCGJ"})	
@RequestMapping(value = "/downloadCertificate/{file_name}", method = RequestMethod.GET)
public void getCertificateFile(@PathVariable("file_name") String fileName, 
    HttpServletResponse response) {
	
	LOGGER.debug("Request Received from front end to download Certificate For a particular Batch in Data Import");
	LOGGER.debug("Parameters Received from front end are - 'file_name': "+fileName+" 'response':"+response);
	
	dataImportDownloadCertificateService.dataImportDownloadCertificate(response, fileName);
    
}
	
@Privilege(value={"SCGJ"})
@RequestMapping(value = "/downloadCSVFile/{file_name}", method = RequestMethod.GET)
public void getFile(@PathVariable("file_name") String fileName, 
    HttpServletResponse response) {
	
	LOGGER.debug("Calling service to download file " + fileName );
	
	dataImportCSVDownloadService.DataImportCSVDownload(response, fileName);
}

@Privilege(value={"SCGJ"})
@RequestMapping(value = "/checkFile")
public int checkFile(@RequestParam("file_name") String fileName) {
	int status = 0;
	
	LOGGER.debug("trying to call file exists utility to confirm ist existence" );
	//dataImportCSVDownloadService.DataImportCSVDownload(response, fileName);
	status = fileExistsUtility.checkFileExistence(readApplicationConstants.getSaveCSVAtLocation(), fileName);
	return status;
}


@Privilege(value={"SCGJ"})
@RequestMapping(value="/findBatch",method=RequestMethod.POST)
public Collection<DataImportGetBatchInfoDto> dataImportFindBatch(@RequestParam("batchId") Integer batchId){
	
	LOGGER.debug("Request Received from front end to find information about a particular Batch in Data Import");
	LOGGER.debug("Parameters Received from front end are - 'batchId': "+batchId);
//	System.out.println("HELLO" + batchId);
	
	return findBatchUsingBatchIdService.findBatchUsingBatchId(batchId.toString());
	
}

@Privilege(value={"SCGJ"})
@RequestMapping(value = "/uploadCertificate", method = { RequestMethod.GET, RequestMethod.POST },consumes=MediaType.ALL_VALUE)
public String singleFileUploadCertificate(@RequestParam("file") MultipartFile file,@RequestParam("batchId") String batchId){
	
	LOGGER.debug("Request Received from front end to Upload Certificate For a particular Batch in Data Import");
	LOGGER.debug("Parameters Received from front end are - 'file': "+file+" 'batchId':"+batchId);
	LOGGER.debug("Sending Request to get User Id from Session");
	String userId=sessionUserUtility
			.getSessionMangementfromSession().getUsername();
	LOGGER.debug("User Logged in is : "+ userId);
	LOGGER.debug("Sending Request to service to upload the CSV file");
	return saveCertificateFileService.saveUploadedFile(file, batchId, userId);
	

}

@Privilege(value={"SCGJ"})
@RequestMapping(value = "/upload", method = { RequestMethod.GET, RequestMethod.POST },consumes=MediaType.ALL_VALUE)
   public String singleFileUpload(@RequestParam("file") MultipartFile file,@RequestParam("csvType") String type) 
{
	
	LOGGER.debug("Request Received from front end to Upload Csv File in Data Import");
	LOGGER.debug("Parameters Received from front end are - 'file': "+file+" 'csvType':"+type);
	LOGGER.debug("Sending Request to get User Id from Session");
	String userId=sessionUserUtility
			.getSessionMangementfromSession().getUsername();
	LOGGER.debug("User Logged in is : "+ userId);
	LOGGER.debug("Sending Request to service to upload the CSV file");
  return saveUploadedFileService.saveUploadedFile(file,type,userId);
}

/*
 * CertificateImportHistoryController
 */

@Privilege(value={"SCGJ"})
@RequestMapping("/certificateImportHistory")
public Collection<CertificateImportHistorydto> getcertificateImportHistorydto(){
	
	LOGGER.debug("Request Received from front end to get data for Certificate Import History Table in Data Import");
	
	return certificateImportHistoryService.getUpdateHistory();
}


}