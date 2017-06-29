package com.skill.India.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.List;
import com.skill.India.service.DownloadExcelService;
import com.skill.India.dto.DownloadExcelDto;


@RestController
public class DownloadExcelController {
	
	@Autowired
	private DownloadExcelService downloadExcelService;
	
	@RequestMapping("/DownloadExcel")
	public Collection<DownloadExcelDto> getDownloadExcelDto () {
		return downloadExcelService.getUpdateRowMapper();
	}
//test
    //@RequestMapping(value = "/downloadCSV") CSVFileDownloadController
    public void downloadCSV(HttpServletResponse response) throws IOException {
 
        String csvFileName = "books.csv";
 
        response.setContentType("text/csv");
 
        // creates mock data
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                csvFileName);
        response.setHeader(headerKey, headerValue);
 
        ArrayList<DownloadExcelDto> listBooks = new ArrayList<DownloadExcelDto>();
 
        // uses the Super CSV API to generate CSV data from the model data
//        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
//                CsvPreference.STANDARD_PREFERENCE);
 
//        String[] header = { "Title", "Description", "Author", "Publisher",
//                "isbn", "PublishedDate", "Price" };
// 
//        csvWriter.writeHeader(header);
// 
//        for (Book aBook : listBooks) {
//            csvWriter.write(aBook, header);
//        }
// 
//        csvWriter.close();
//    }
}
}