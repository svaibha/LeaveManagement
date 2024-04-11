package com.example.Leavemanagement.controller;

import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.Leavemanagement.Model.Requestmodel;
import com.example.Leavemanagement.entity.Employee;
import com.example.Leavemanagement.entity.Requests;
import com.example.Leavemanagement.service.Adminservice;
import com.example.Leavemanagement.service.RequestService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class BasicController {
	
	@Autowired
	Adminservice adminservice;
	
	@Autowired
	RequestService requestservice;
	
	
	@GetMapping("/Registration")
	public ModelAndView register() {
		Requests requests = new Requests();
		ModelAndView mav = new ModelAndView("Registration");
		mav.addObject("employee", requests);
		return mav;
	}
	
	
	@GetMapping("/Login")
	public ModelAndView login(@RequestParam(value="invalid-session",defaultValue = "false") boolean invalidSession,
			                  @RequestParam(value="expired-session",defaultValue = "false") boolean expiredSession,
			                  HttpServletRequest request)
			               { 
		
//	          HttpSession session =  request.getSession();
//	          
//	          session.setAttribute("username", request.getUserPrincipal());

		
		ModelAndView model = new ModelAndView("Login");
//		session.setAttribute("sessionType", session.getClass().getName());
//		System.out.println(session.getClass().getName());
//		//System.out.println(session.setAttribute("sessionType", session.getClass().getName()));
		if(invalidSession) {
			model.addObject("invalidsession","session expired");
		}
		if(expiredSession) {
			model.addObject("expiredSession","Alredy Login");
		}
		return model;
	
	}
	
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView home = new ModelAndView("home");
		return home;
	}
	
	@PostMapping("/logout")
	public String performLogout() {
	    // .. perform logout
	    return "redirect:/Login";
	}
	
	@GetMapping("/expired-session")
	public String expiredsession() {
		return "Already Login somewhere";
	}
	
	@PostMapping("/reuested")
	public String requested(@ModelAttribute("request") Requestmodel request) throws ParseException {
		Date dateBefore = new Date();
	dateBefore.setYear(2005);
	Date dateAfter = new Date();
	System.out.println(dateAfter);
	System.out.println(request.getDob());
	ModelAndView view = new ModelAndView("Registration");
	requestservice.addReuest(request);
	return "Done";
	}
	
}
