package com.example.Leavemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Leavemanagement.entity.Employee;
import com.example.Leavemanagement.entity.Totalleaves;
import com.example.Leavemanagement.repo.Total_leavesrepo;

@Service
public class Total_leaveservice {
	
	@Autowired
	Total_leavesrepo totalrepo;
//	
	public void setvalues(Employee emp_id) {
	Totalleaves total = totalrepo.getallleaves(emp_id);
	Integer taken= total.getLeave_applied();
	total.setLeaves_taken(++taken);
	
	System.out.println(taken);
		totalrepo.save(total);
		
	}
}
