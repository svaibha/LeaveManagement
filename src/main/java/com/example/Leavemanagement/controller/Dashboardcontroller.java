package com.example.Leavemanagement.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.boot.web.servlet.server.Session.Cookie;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.Leavemanagement.Model.Leaveresponsebody;
import com.example.Leavemanagement.entity.Employee;
import com.example.Leavemanagement.entity.Leave;
import com.example.Leavemanagement.entity.Manager;
import com.example.Leavemanagement.entity.Totalleaves;
import com.example.Leavemanagement.repo.Employeerepo;
import com.example.Leavemanagement.repo.Leaverepo;
import com.example.Leavemanagement.repo.Managerrepo;
import com.example.Leavemanagement.repo.Total_leavesrepo;
import com.example.Leavemanagement.service.Dashboardservices;
import com.example.Leavemanagement.service.Employeeservice;
import com.example.Leavemanagement.service.Leaveservice;
import com.example.Leavemanagement.service.ManagerService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class Dashboardcontroller {
	
	@Autowired
	Dashboardservices service;
	@Autowired
	Employeeservice empservice;
	@Autowired 
	Employeerepo emprepo;
	@Autowired
	Managerrepo managerrepo;
	@Autowired
	Leaveservice leaveservice;
	@Autowired
	ManagerService managerservice;
	@Autowired
	Total_leavesrepo totalleave;
	
	@GetMapping("/dashboard")
	public ModelAndView dashboard(Principal principal,HttpServletRequest request ) {
		//request.setS
		//System.out.println(username);
		//session.setAttribute("emp", principal.getName());
		String email = principal.getName();
		Leave leave = new Leave();
		Employee user = emprepo.findByEmail(email);
		String gender = emprepo.findGender(email);
		Integer emp_id = user.getId();
		//System.out.println(session.getCreationTime());
		//List<String> messages =  (List<String>) request.getSession().getAttribute("MY_SESSION_MSG");
//		if(messages == null) {
//			messages = new ArrayList<>();
//		 request.getSession().setAttribute("MY_SESSION_MSG", messages);
//		}
//		messages.add(email);
//		request.getSession().setAttribute("MY_SESSION_MSG", messages);
//	    Totalleaves total_leaves = totalleave.getallleaves(user);
//		System.out.println(user);
//		System.out.println(gender);
//		System.out.println(leave);
//		System.out.println(leave.getStatus());
//		System.out.println(emp_id);
//		System.out.println(total_leaves);
	   // Pageable pageable = Pagereq
	List<Leave>  leaveapplied = leaveservice.applied(user);
	
//	for(int i=0;i<leaveapplied.size();i++) {
//		System.out.println(leaveapplied.get(i));
//	}
//	System.out.println(leaveapplied);
		//List<GrantedAuthority> role = user.getROLE();
		if(user.getRoles().contains("Manager")) {
			//ModelAndView Mdashboard = new ModelAndView("ManagerDashboard");
//			Mdashboard.addObject("user",user);
//			Mdashboard.addObject("leave",leave);
//			Mdashboard.addObject("leaveapplied",leaveapplied);
//			Mdashboard.addObject("total_leaves",total_leaves);
			return new ModelAndView("redirect:/Managerdashboard");
		}else if(user.getRoles().contains("Employee")) {
			//ModelAndView Edashboard = new ModelAndView("Userdashboard");
//			Edashboard.addObject("user",user);
//			Edashboard.addObject("leave",leave);
//			Edashboard.addObject("leaveapplied",leaveapplied);
//			Edashboard.addObject("total_leaves",total_leaves);
			return new ModelAndView("redirect:/Userdashboard");
		}else {
			return new ModelAndView("redirect:/Admindashboard");
		}
		
	}
	
	@GetMapping("/Managerdashboard/requests")
	public ModelAndView requests(Principal principal) { 
		String email = principal.getName();
		Manager user = managerrepo.findByEmail(email);
		//System.out.println(user.getId());
		List<Leave> response = managerservice.getleaveassigned(user);
		ModelAndView view = new ModelAndView("Requests");
		view.addObject("user",user);
		view.addObject("leave",response);
		return view;
	}
	
	@GetMapping("/Managerdashboard")
	public ModelAndView managerview( Principal principal) {
		ModelAndView Mdashboard = new ModelAndView("ManagerDashboard");
		
		String email = principal.getName();
		Leave leave = new Leave();
		Employee user = emprepo.findByEmail(email);
		String gender = emprepo.findGender(email);
		Integer emp_id = user.getId();
		List<Leave>  leaveapplied = leaveservice.applied(user);
		Totalleaves total_leaves = totalleave.getallleaves(user);
		
		Mdashboard.addObject("user",user);
		Mdashboard.addObject("leave",leave);
		Mdashboard.addObject("leaveapplied",leaveapplied);
		Mdashboard.addObject("total_leaves",total_leaves);
		Mdashboard.addObject("allleaves",total_leaves.getTotal_leaves());
		return Mdashboard;
	}
	
	@GetMapping("/Userdashboard")
	public ModelAndView userview( Principal principal,HttpSession session) {
		ModelAndView Edashboard = new ModelAndView("Userdashboard");
		System.out.println(session.getCreationTime());
		String email = principal.getName();
		Leave leave = new Leave();
		Employee user = emprepo.findByEmail(email);
		String gender = emprepo.findGender(email);
		Integer emp_id = user.getId();
		List<Leave>  leaveapplied = leaveservice.applied(user);
		Totalleaves total_leaves = totalleave.getallleaves(user);
		
		//ModelAndView Edashboard = new ModelAndView("Userdashboard");
		Edashboard.addObject("user",user);
		Edashboard.addObject("leave",leave);
		Edashboard.addObject("leaveapplied",leaveapplied);
		Edashboard.addObject("total_leaves",total_leaves);
		return Edashboard;
	}
	@GetMapping("/Admindashboard")
	public ModelAndView adminboard(Principal principal) {
		ModelAndView Adminboard = new ModelAndView("Admindashboard");
		return Adminboard;
	}
		
	
	@GetMapping("/Managerdashboard/account")
	public ModelAndView Maccount(Principal principal) {
		String email = principal.getName();
//		System.out.println();
		Employee employee = emprepo.findByEmail(email);
		Totalleaves total = totalleave.getallleaves(employee);
		ModelAndView view = new ModelAndView("Account");
		view.addObject("employee",employee);
		view.addObject("total",total);
		return view;
	}
	@GetMapping("/Userdashboard/account")
	public ModelAndView Uaccount(Principal principal) {
		String email = principal.getName();
		Employee employee = emprepo.findByEmail(email);
		Totalleaves total = totalleave.getallleaves(employee);
		ModelAndView view = new ModelAndView("Account");
		view.addObject("employee",employee);
		view.addObject("total",total);
		return view;
	}
	
	}

