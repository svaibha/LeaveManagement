package com.example.Leavemanagement.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.Leavemanagement.Model.Leaverequestbody;
import com.example.Leavemanagement.Model.Leaveresponsebody;
import com.example.Leavemanagement.entity.Employee;
import com.example.Leavemanagement.entity.Leave;
import com.example.Leavemanagement.entity.Totalleaves;
import com.example.Leavemanagement.repo.Employeerepo;
import com.example.Leavemanagement.repo.Total_leavesrepo;
import com.example.Leavemanagement.service.Leaveservice;
import com.example.Leavemanagement.service.Total_leaveservice;

@RestController
public class Leavecontroller {
	
	@Autowired
	Leaveservice leaveservice;
	@Autowired
	Employeerepo emprepo;
	@Autowired
	Total_leavesrepo totalleave;
	
	@Autowired
	Total_leaveservice totalservice;
	
	

	
	@PostMapping("/dashboard")
	public ModelAndView applyleave(@ModelAttribute Leaverequestbody request,Principal principal) {
		String email = principal.getName();
		Employee user = emprepo.findByEmail(email);
		ModelAndView view = new ModelAndView("Userdashboard");
		ModelAndView view2 = new ModelAndView("ManagerDashboard");
		Leaveresponsebody response = new Leaveresponsebody();
		
		System.out.println(request.getType_of_leave());
	
		//leaveservice.applyleave(request, email);
		
		
		Leave leave = new Leave();
		String gender = emprepo.findGender(email);
		Integer emp_id = user.getId();
		List<Leave> leaveapplied = leaveservice.applied(user);
	    Totalleaves total_leaves = totalleave.getallleaves(user);
		view.addObject("leave",leave);
		view.addObject("user", user);
		view.addObject("leaveapplied",leaveapplied);
		view.addObject("total_leaves",total_leaves);
		
		
		
		return new ModelAndView("redirect:/dashboard");
	}
	@GetMapping("leaveform")
	public ModelAndView leaveform() {
		ModelAndView view = new ModelAndView("leaveform");
		return view;
	}
	
}
