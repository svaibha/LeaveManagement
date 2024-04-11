package com.example.Leavemanagement.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Leavemanagement.Model.Requestmodel;
import com.example.Leavemanagement.entity.Requests;
import com.example.Leavemanagement.repo.Requestrepo;

@Service
public class RequestService {
	
	@Autowired
	Requestrepo requestrepo;
	
	public void addReuest(Requestmodel requestsmodel) throws ParseException {
		
		String date = requestsmodel.getJoining_date();
		String dob = requestsmodel.getDob();
		
		DateFormat dateformat = new SimpleDateFormat("yyyy-mm-dd");
		Date DOB =  dateformat.parse(dob);
		Date DATE = dateformat.parse(date);
		
		Requests request = new Requests();
		request.setFirst_name(requestsmodel.getFirst_name());
		request.setAdhaarcard(requestsmodel.getAdhaarcard());
		request.setBloodgroup(requestsmodel.getBloodgroup());
		request.setCurrent_address(requestsmodel.getCurrent_address());
		request.setDob(DOB);
		request.setEmail(requestsmodel.getEmail());
		request.setEmergency_contact(requestsmodel.getEmergency_contact());
		request.setFirst_name(requestsmodel.getFirst_name());
		request.setGender(requestsmodel.getGender());
		request.setHometown(requestsmodel.getHometown());
		request.setJoining_date(DATE);
		request.setRoles(requestsmodel.getRoles());
		request.setDepartment(requestsmodel.getDepartment());
		request.setLast_name(requestsmodel.getLast_name());
		request.setMartial_status(requestsmodel.getMartial_status());
		request.setMiddle_name(request.getMiddle_name());
		request.setPhonenumber(requestsmodel.getPhonenumber());
		request.setPassword(requestsmodel.getPassword());
		request.setApproved(0);
		
		requestrepo.save(request);
	}
	
	
}
