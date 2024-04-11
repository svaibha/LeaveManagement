package com.example.Leavemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Leavemanagement.Model.Leaveresponsebody;
import com.example.Leavemanagement.entity.Leave;
import com.example.Leavemanagement.entity.Manager;
import com.example.Leavemanagement.repo.Leaverepo;
import com.example.Leavemanagement.repo.Total_leavesrepo;

@Service
public class ManagerService {
	
	@Autowired
	Total_leavesrepo totalrepo;
	
	@Autowired
	Leaverepo leaverepo;
	
	public List<Leave> getleaveassigned(Manager manager) {
		Leaveresponsebody response;
		
		List<Leave> leave = leaverepo.findformananger(manager,"PENDING");
		return leave;
		
		
	}
}
