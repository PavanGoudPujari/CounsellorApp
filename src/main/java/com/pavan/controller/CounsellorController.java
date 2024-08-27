package com.pavan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.pavan.dto.DashboardResponse;
import com.pavan.entity.Counsellor;
import com.pavan.service.CounsellorService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CounsellorController {
	
	private CounsellorService counsellorService;
	
	public CounsellorController(CounsellorService counsellorService) {
		
		this.counsellorService=counsellorService;
	}
    
	@GetMapping("/")
	public String index(Model model) {
		
		Counsellor cobj = new 	Counsellor();
		
		
		//sending data from controller to UI
		model.addAttribute("counsellor",cobj);
		
		
		//returning view name
		return "index";
	}
	
	@PostMapping("/login")
	public String handleLoginBtn(Counsellor counsellor,HttpServletRequest request, Model model) {
		
		Counsellor c=counsellorService.login(counsellor.getEmail(), counsellor.getPwd());
		if(c == null) {
			model.addAttribute("emsg","Invalid Credentials");
			return "index";
		}else {
			
			//valid login, store counsellorid in session for future purpose like add enq, view enq
			
			//for every login, one session object created
			
			//session will available , until we logout
			
			HttpSession session = request.getSession(true);// true means create a new session object
			session.setAttribute("counsellorId", c.getCounsellorId());
			
			return "redirect:/dashboard";
			
//			DashboardResponse dbobj = counsellorService.getDashboardInfo(counsellor.getCounsellorId());
//		    model.addAttribute("dashboardInfo", dbobj);
//			return "dashboard";
		}
		
	}
	@GetMapping("/dashboard")
	public String displayDashboard(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession(false);// true means create a new session object
		Integer counsellorId =(Integer) session.getAttribute("counsellorId");
		
		
		DashboardResponse dbobj = counsellorService.getDashboardInfo(counsellorId);
	    model.addAttribute("dashboardInfo", dbobj);
		return "dashboard";
	}
	
	@GetMapping("/register")
	public  String registerPage(Model model) {
		
Counsellor cobj = new 	Counsellor();
		
		
		//sending data from controller to UI
		model.addAttribute("counsellor",cobj);
		return "register";
	}
	
	@PostMapping("/register")
	public String handleRegistration(Counsellor counsellor, Model model) {
	
		
		Counsellor byEmail=counsellorService.findByEmail(counsellor.getEmail());
		 if(byEmail !=null) {
			 model.addAttribute("emsg", "Duplicate Email");
			 return "register";
		 }
		
		boolean isRegistered =counsellorService.register(counsellor);
   if(isRegistered) {
	   model.addAttribute("smsg", "Registration Sucess..!!");
   }else {
	   model.addAttribute("emsg", "Registration Failed..!!");
   }
		 return "register";		
		
	}
	@GetMapping("/logout")
	public String logout(HttpServletRequest req) {
		//get existing session and invalidate it
		HttpSession session = req.getSession(false);
		
		session.invalidate();
		
		//redirect to login page
		return "redirect:/";
		
	}
	
	
}
