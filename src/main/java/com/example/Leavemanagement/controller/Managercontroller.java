package com.example.Leavemanagement.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.Leavemanagement.Model.Leaveresponsebody;
import com.example.Leavemanagement.service.Leaveservice;

@Controller
public class Managercontroller {
	
	@Autowired
	Leaveservice leaveservice;
	
//	@GetMapping("/requests")
//	public Leaveresponsebody applied(Principal principal){
//		String manager = principal.getName();
//		return leaveservice.requests(manager);
//	}
	
	@GetMapping("/accept/{Id}")
	public ModelAndView accept(@PathVariable("Id") Integer Id) {
		leaveservice.accept(Id);
		return new ModelAndView("redirect:/Managerdashboard/requests");
	}
	@GetMapping("/deny/{Id}")
	public ModelAndView deny(@PathVariable("Id") Integer Id) {
		leaveservice.deny(Id);
		return new ModelAndView("redirect:/Managerdashboard/requests");
	}
}
