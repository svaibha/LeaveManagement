package com.example.Leavemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.Leavemanagement.Model.Employeerequestmodel;
import com.example.Leavemanagement.entity.Employee;
import com.example.Leavemanagement.repo.Employeerepo;
import com.example.Leavemanagement.service.Adminservice;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@RestController
public class Admincontroller {
	
	@Autowired
	Adminservice adminservice;
	@Autowired
	Employeerepo emprepo;
	

	@PostMapping("/admin/mapping")
	public void mapping(@RequestParam Integer manager_id,@RequestParam List<Integer> id) {
		 adminservice.mapping(manager_id, id);
		
	}
	
	@GetMapping("/Admindashboard/assign")
	public ModelAndView assign() {
		ModelAndView view = new ModelAndView("Assign");
		return view;
	}
	
	@GetMapping("/Admindashboard/manager")
	public ModelAndView manager(Model model) {
		ModelAndView list = new ModelAndView("Role","employees",adminservice.Manager("Admin"));
		return list;
	
	}
	@GetMapping("/Admindashboard/edit/{email}")
	public ModelAndView update(@PathVariable("email") String email ) {
		Employee employee = emprepo.findByEmail(email);
		System.out.println(employee.getEmail());
		ModelAndView view = new ModelAndView("updateRole","employee",employee);
		return view;
	}
	
	@PostMapping("/Admindashboard/update/{email}")
	public ModelAndView updaterole(@ModelAttribute Employeerequestmodel empreq,@PathVariable("email") String email ) {
		System.out.println(empreq.getRoles());
		if(empreq.getRoles().contains("Manager")) 
		     adminservice.roleupdate(empreq, email);
		     ModelAndView list = new ModelAndView("Role","employees",adminservice.Manager("Admin"));
//	}else {
//		    	 adminservice.employeeupdate(empreq, email);
//		    	 ModelAndView list = new ModelAndView("Role","employees",adminservice.Manager("Admin"));
//			     return list;
//		     }
		
		     
		     return new ModelAndView("redirect:/Admindashboard/manager");
		
	}
	@GetMapping("/approve")
	public ModelAndView approve() {
		
		ModelAndView view = new ModelAndView("approve","employee",adminservice.authenticate());
		//List<Employee> emp =  adminservice.authenticate();
		//view.addObject("list",emp);
		//System.out.println(emp);
		return view;
		
	}
	
}
