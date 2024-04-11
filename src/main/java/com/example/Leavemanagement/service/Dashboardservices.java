package com.example.Leavemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Leavemanagement.Model.Employeeresponsemodel;
import com.example.Leavemanagement.entity.Employee;
import com.example.Leavemanagement.repo.Employeerepo;
import com.example.Leavemanagement.repo.Managerrepo;

@Service
public class Dashboardservices {
	
	@Autowired
	Employeerepo emprepo;
	
	@Autowired
	Managerrepo managerepo;

	public Employeeresponsemodel dashboard(String email) {
		  Employeeresponsemodel response ;
	Employee emp =	emprepo.findByEmail(email);
		return response = new Employeeresponsemodel("Done");		
	}
}
