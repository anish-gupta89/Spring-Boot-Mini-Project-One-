package com.ag.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ag.dto.SearchRequest;
import com.ag.runner.DataLoader;
import com.ag.service.ReportService;
import com.ag.utils.EmailDetails;
import com.ag.utils.EmailUtils;
import com.ag.utils.ExcelGenerator;
import com.ag.utils.PdfGenerator;
import com.lowagie.text.DocumentException;

@Controller
public class ReportsController {

	private static final Logger log = LoggerFactory.getLogger(ReportsController.class);

	@Autowired
	ReportService serviceObj;

	@Autowired
	DataLoader dataLoader;
	
	@Autowired
	EmailUtils email;
	
	@Autowired
	ExcelGenerator excelGenerator;

	@GetMapping("/")
	public String getIndexPage(Model model) {
		log.info("getIndexPage method called");
		List<String> planList = serviceObj.getListOfPlans();
		List<String> planStaus = serviceObj.getListOfPlanStatus();
		model.addAttribute("planlist", planList);
		model.addAttribute("planstatus", planStaus);
		model.addAttribute("gender", dataLoader.getGender());
		model.addAttribute("searchdata", new SearchRequest());
		return "index";
	}

	@PostMapping("/search")
	public String searchInsurance(SearchRequest criteria, Model model) {
		log.info("Criteria " + criteria.toString());
		List<SearchRequest> matchedSearchRqst = serviceObj.getMatchedSearchRqst(criteria);
		model.addAttribute("data", matchedSearchRqst);
		return getIndexPage(model);
	}

	@GetMapping("/export")
	public String exportToPDF(HttpServletResponse response,@RequestParam String type, Model model) throws DocumentException, IOException{
		if(type.equals("pdf")) {
			response.setContentType("application/pdf");
			DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
			String currentDateTime = dateFormatter.format(new Date());
			String headerKey = "Content-Disposition";
			String fileName = "reports_" + currentDateTime + ".pdf";
			String headerValue = "attachment; filename="+fileName;
			response.setHeader(headerKey, headerValue);
			
			List<SearchRequest> listUsers = serviceObj.getAllReports();
			
			PdfGenerator exporter = new PdfGenerator(listUsers);
			exporter.export(response);
			EmailDetails details =  new EmailDetails();
			details.setRecipient("anishkumars.gupta@gmail.com");
			details.setSubject("Email With Attachement");
			details.setMsgBody("PFA");
			details.setAttachment("C:\\Users\\Thread Java\\Downloads\\"+fileName);
			email.sendMailWithAttachment(details);
		} else {
			List<SearchRequest> listUsers = serviceObj.getAllReports();
			DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
			String currentDateTime = dateFormatter.format(new Date());
			String fileName = "reports_" + currentDateTime + ".csv";
			excelGenerator.writeDataLineByLine("C:\\Users\\Thread Java\\Downloads\\"+fileName, listUsers);
			EmailDetails details =  new EmailDetails();
			details.setRecipient("anishkumars.gupta@gmail.com");
			details.setSubject("Email With Attachement");
			details.setMsgBody("PFA");
			details.setAttachment("C:\\Users\\Thread Java\\Downloads\\"+fileName);
			email.sendMailWithAttachment(details);
		}
		return getIndexPage(model);
	}

}
