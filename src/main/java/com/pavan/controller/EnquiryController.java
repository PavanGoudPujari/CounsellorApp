package com.pavan.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pavan.dto.DashboardResponse;
import com.pavan.dto.ViewEnqFilterRequest;
import com.pavan.entity.Enquiry;
import com.pavan.service.EnquiryService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EnquiryController {
	
	private EnquiryService enquiryService;
	
	public EnquiryController(EnquiryService enqService) {
		this.enquiryService=enqService;
	}

	@GetMapping("/enquiry")
	public String addEnquiryPage(Model model) {
		
		Enquiry enqObj = new Enquiry();
		model.addAttribute("enq",enqObj);
		return "enquiryForm";
	}
	
	@GetMapping("/editEnq")
	public String editEnquiry(@RequestParam("enqId")Integer enqId, Model model) {
		Enquiry enquiry=enquiryService.getEnquiryById(enqId);
		model.addAttribute("enq", enquiry);
		return "enquiryForm";
	}
	
	@PostMapping("/filter-enqs")
	public String filterEnquiries(ViewEnqFilterRequest viewEnqFilterRequest, HttpServletRequest req, Model model) {
		  HttpSession session =req.getSession(false);
			
			Integer counsellorId =(Integer) session.getAttribute("counsellorId");
			
			List<Enquiry> enqsList=enquiryService.getEnquiresWithFilter(viewEnqFilterRequest, counsellorId);
			
			model.addAttribute("enquiries", enqsList);
			
			return "viewEnqPage";	
	}
	@GetMapping("/view-enquiries")
	public String getEnquries(HttpServletRequest request, Model model) {
      HttpSession session =request.getSession(false);
		
		Integer counsellorId =(Integer) session.getAttribute("counsellorId");
		
       List<Enquiry> enqList = enquiryService.getAllEnquiries(counsellorId);
       
       model.addAttribute("enquiries", enqList);
       
       //Search form binding object
       ViewEnqFilterRequest filterReq= new ViewEnqFilterRequest();
       
       model.addAttribute("viewEnqFilterRequest", filterReq);
       
       
       return "viewEnqPage";
	}
	
	
	@PostMapping("/addEnq")
	public String handleAddEnquiry(Enquiry enquiry, HttpServletRequest req, Model model) throws Exception {
		
		//get existing session obj
		HttpSession session =req.getSession(false);
		
		Integer counsellorId =(Integer) session.getAttribute("counsellorId");
		boolean isSaved=enquiryService.addEnquiry(enquiry, counsellorId);
		
		if(isSaved) {
			model.addAttribute("smsg", "Enquiry Added");
		}else {
			model.addAttribute("emsg", "Enquiry Failed");
		}
		
		enquiry = new Enquiry();
		model.addAttribute("enq", enquiry);
		return "enquiryForm";
	}
}
