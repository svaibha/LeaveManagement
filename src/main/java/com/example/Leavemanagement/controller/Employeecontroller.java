package com.example.Leavemanagement.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.Leavemanagement.Model.Employeerequestmodel;
import com.example.Leavemanagement.Model.Employeeresponsemodel;
import com.example.Leavemanagement.entity.Employee;
import com.example.Leavemanagement.service.Employeeservice;

import jakarta.validation.Valid;

@RestController
public class Employeecontroller {
	
	@Autowired
	Employeeservice empservice;
	
	
//	@PostMapping("/employee")
//	public  String addemployee(@ModelAttribute("employee") Employeerequestmodel empreq) throws ParseException{
//		
//////		Date dateBefore = new Date();
//////		dateBefore.setYear(2005);
//////		Date dateAfter = new Date();
//////		System.out.println(dateAfter);
////		
//            return "Hello";
////		System.out.println(empreq.getDob());
//////		ModelAndView view = new ModelAndView("Registration");
////     	Employeeresponsemodel response = new Employeeresponsemodel();
////     	if(empreq.getFirst_name().isBlank() || empreq.getFirst_name().matches("[0-9]+")) {
////     		response.setMsg("First Name is empty");
////     		//view.addObject("errorName",response.getMsg());
////     		response.setStatus("FAILURE");
////     		return "FAILURE";
////     	}
////     	if(empreq.getLast_name().isBlank() || empreq.getFirst_name().matches("[0-9]+")) {
////     		response.setMsg("Last Name is empty");
////     		//view.addObject("errorLastName",response.getMsg());
////     		response.setStatus("FAILURE");
////     		return response.getMsg();
////     	}
////     	if(empreq.getEmail().isBlank() && !empreq.getEmail().contains("@") && !empreq.getEmail().contains(".com") ) {
////     		response.setMsg("Check Email Again");
////     		//view.addObject("errorEmail",response.getMsg());
////     		response.setStatus("FAILURE");
////     		return response.getMsg();
////     	}
////     	if(empservice.emailexist(empreq.getEmail())) {
////     		response.setMsg("Email Already exists");
////     		//view.addObject("errorCheck",response.getMsg());
////     		response.setStatus("FAILURE");
////     		return response.getMsg();
////     	}
////     	if(empreq.getAdhaarcard().isBlank() ||empreq.getAdhaarcard().length()<12 || empreq.getAdhaarcard().length() >12 || empreq.getAdhaarcard().matches("[a-zA-Z_]+")) {
////     		response.setMsg("Inavalid adharcard");
////     		//view.addObject("errorAdhar",response.getMsg());
////     		response.setStatus("FAILURE");
////     		return response.getMsg();
////     	}
////     	if(empservice.Adharexists(empreq.getAdhaarcard())){
////     		response.setMsg("Adharcard already exists");
////     		//view.addObject("errorAdharExists",response.getMsg());
////     		response.setStatus("FAILURE");
////     		return response.getMsg();
////     	}
////     	if(empreq.getCurrent_Address().isBlank() || empreq.getCurrent_Address().length() > 30) {
////     		response.setMsg("Address too long");
////     		//view.addObject("errorAddress",response.getMsg());
////     		response.setStatus("FAILURE");
////     		return response.getMsg();
////     	}
////     	if(empreq.getEmergencycontact().isBlank()) { 
////     		response.setMsg("Check your Emergency contact");
////     		//view.addObject("errorEcontact",response.getMsg());
////     		response.setStatus("FAILURE");
////     		return response.getMsg();
////     	}
////     	if(empreq.getEmergencycontact().length()>10) { 
////     		response.setMsg("Emergency contact is not valid");
////     		//view.addObject("errorEcontactLength",response.getMsg());
////     		response.setStatus("FAILURE");
////     		return response.getMsg();
////     	}
////     	if(empreq.getEmergencycontact() == empreq.getPhonenumber()) {
////     		response.setMsg("Your emergency contact and Phone number can't be same");
////     		//view.addObject("errorSame",response.getMsg());
////     		response.setStatus("FAILURE");
////     		return response.getMsg();
////     	}
////     	if(empreq.getGender().isBlank()) {
////     		response.setMsg("Your Gender can't be null");
////     		//view.addObject("errorGender",response.getMsg());
////     		response.setStatus("FAILURE");
////     		return response.getMsg();
////     	}
////     	if(empreq.getHometown().isBlank()) {
////     		response.setMsg("Your Hometown can't be Blank");
////     		//view.addObject("errorTown",response.getMsg());
////     		response.setStatus("FAILURE");
////     		return response.getMsg();
////     	}
////     	if(empreq.getDepartment().isBlank()) {
////     		response.setMsg("Your Department can't be null");
////     		//view.addObject("errorDepartment",response.getMsg());
////     		response.setStatus("FAILURE");
////     		return response.getMsg();
////     	}
////     	if(empreq.getDob().isBlank()) {
//// 			response.setMsg("Check DOB Again");
//// 			//view.addObject("errorParsingDOB",response.getMsg());
//// 			response.setStatus("FAILURE");
//// 			return response.getMsg();
//// 		}
////     		if(empreq.getJoining_date().isBlank()) {
////     			response.setMsg("Check Joining date Again");
////     			//view.addObject("errorParsing",response.getMsg());
////     			response.setStatus("FAILURE");
////     			return response.getMsg();
////     		}
////     		String date = empreq.getJoining_date();
////     		String dob = empreq.getDob();
////     		
////     		DateFormat dateformat = new SimpleDateFormat("yyyy-mm-dd");
////     		Date DOB =  dateformat.parse(dob);
////     		Date DATE = dateformat.parse(date);
////     	
//////     	if(DOB.before(dateBefore)) {
//////     		response.setMsg("Check your  DOB Again");
//////     		view.addObject("errorDobBefore",response.getMsg());
//////     		return view;
//////     	}
//////     	if(DOB.after(dateAfter)) {
//////     		response.setMsg("Check your  DOB Again");
//////     		view.addObject("errorDobAfter",response.getMsg());
//////     		return view;
//////     	}
//////     	if(DATE.after(dateAfter)) {
//////     		response.setMsg("Your Joining Date can't be this");
//////     		view.addObject("errorJdateAfter",response.getMsg());
//////     		return view;
//////     	}
////     	if(empreq.getPhonenumber().length()>10) {
////     		response.setMsg("Your Phone Number is not valid");
////     		//view.addObject("errorPhone",response.getMsg());
////     		response.setStatus("FAILURE");
////     		return response.getMsg();
////     	}
////     	if(empreq.getPhonenumber().length()<10) {
////     		response.setMsg("Your Phone Number is not valid");
////     		//view.addObject("errorPhoneLength",response.getMsg());
////     		response.setStatus("FAILURE");
////     		return response.getMsg();
////     	}
////     	if(empreq.getMartial_status().isBlank()) {
////     		response.setMsg("Your Phone Number is not valid");
////     		//view.addObject("errorPhoneBlank",response.getMsg());
////     		response.setStatus("FAILURE");
////     		return response.getMsg();
////     	}
////     	if(empreq.getPassword().isBlank()){
////     		response.setMsg("Your Password is not valid");
////     		//view.addObject("errorPassword",response.getMsg());
////     		response.setStatus("FAILURE");
////     		return response.getMsg();
////     	}
////     	response.setStatus("SUCCESS");
////     	return response.getMsg();
//     	
//     
//     	
//	}
//        //empservice.addemployee(empreq,DOB,DATE);	
////	@PostMapping("/login")
////	public String login() {
////		return "login.html";
////	}
//	
	
	
}
