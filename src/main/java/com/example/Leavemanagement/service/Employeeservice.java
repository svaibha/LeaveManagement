package com.example.Leavemanagement.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Leavemanagement.Model.Employeerequestmodel;
import com.example.Leavemanagement.Model.Employeeresponsemodel;
import com.example.Leavemanagement.entity.Employee;
import com.example.Leavemanagement.entity.Manager;
import com.example.Leavemanagement.entity.Totalleaves;
import com.example.Leavemanagement.repo.Employeerepo;
import com.example.Leavemanagement.repo.Managerrepo;
import com.example.Leavemanagement.repo.Total_leavesrepo;

@Service
public class Employeeservice implements UserDetailsService {
	
	@Autowired
	Employeerepo emprepo;
	
	@Autowired
	Managerrepo managerrepo;
	
	@Autowired
	Total_leavesrepo totalleaves;

	
	public Employeeresponsemodel addemployee(Employeerequestmodel empreq,Date datereq,Date dobDate) throws ParseException {
		Employeeresponsemodel response;
		
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();	
	
	
	        Totalleaves total = new Totalleaves();
			Employee employee = new Employee();			
			employee.setFirst_name(empreq.getFirst_name());
			employee.setMiddle_name(empreq.getMiddle_name());
			employee.setLast_name(empreq.getLast_name());
			employee.setEmail(empreq.getEmail());
			employee.setAdhaarcard(empreq.getAdhaarcard());
			employee.setCurrent_Address(empreq.getCurrent_Address());
			employee.setHometown(empreq.getHometown());
			employee.setDepartment(empreq.getDepartment());
			employee.setGender(empreq.getGender());
			employee.setPassword(encoder.encode(empreq.getPassword()));
            employee.setJoining_date(datereq);
			employee.setPhonenumber(empreq.getPhonenumber());
			employee.setMartialstatus(empreq.getMartial_status());
			employee.setBloodgroup(empreq.getBloodgroup());
			employee.setRoles("Employee");
 			employee.setDob(dobDate);
			employee.setEmergency_contact(empreq.getEmergencycontact());
		    employee.setApproved(0);
			total.setTotal_leaves(32);
			total.setEmergency(0);
			total.setCasual(0);
			total.setMaternity(0);
			total.setPaternity(0);
			total.setSick(0);
			total.setLeave_applied(0);
			total.setLeaves_taken(0);
			total.setRemaining_leaves(32);
			total.setEmp_id(employee);
			
			
			emprepo.save(employee);
			totalleaves.save(total);
			return response = new Employeeresponsemodel(empreq.getId(), empreq.getFirst_name(), empreq.getMiddle_name(), empreq.getLast_name(), empreq.getEmail(), empreq.getJoining_date(), empreq.getHometown(), empreq.getCurrent_Address(), empreq.getAdhaarcard(), empreq.getGender(), empreq.getPhonenumber(), empreq.getEmergencycontact(), empreq.getDob(), empreq.getDepartment(), employee.getMartialstatus(), empreq.getBloodgroup(), empreq.getRoles());
			}

     

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return emprepo.findByEmail(email);		
	}
	
	public boolean emailexist(String email) {
		
	 Employee response = emprepo.findByEmail(email);
	 if(response == null) {
		 return false;
	 }
	  return true;
	}
	public Boolean Adharexists(String adhar) {
	 List<Employee> employee = 	emprepo.findByAdhar(adhar);
	 if(employee.isEmpty()) {
		 return false;
	 }else {
		 return true;
	 }
	}
	
	
}
