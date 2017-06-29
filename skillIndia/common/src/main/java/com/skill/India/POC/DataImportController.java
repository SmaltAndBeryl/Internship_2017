package com.skill.India.POC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DataImportController {

	@RequestMapping("/dataImport")
	public String data() {
		return "dataImport" ;
	}
}
