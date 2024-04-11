package com.example.Leavemanagement.service;

import java.util.Date;
import java.util.List;

import org.hibernate.query.spi.Limit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.Leavemanagement.Model.Leaverequestbody;
import com.example.Leavemanagement.Model.Leaveresponsebody;
import com.example.Leavemanagement.entity.Employee;
import com.example.Leavemanagement.entity.Leave;
import com.example.Leavemanagement.entity.Manager;
import com.example.Leavemanagement.entity.Totalleaves;
import com.example.Leavemanagement.repo.Employeerepo;
import com.example.Leavemanagement.repo.Leaverepo;
import com.example.Leavemanagement.repo.Managerrepo;
import com.example.Leavemanagement.repo.Total_leavesrepo;

import ch.qos.logback.core.util.Duration;

@Service
public class Leaveservice {
	@Autowired
	Leaverepo leaverepo;
	@Autowired
	Employeerepo emprepo;
	@Autowired
	Managerrepo managerepo;
	@Autowired
	Total_leavesrepo totalleavesrepo;
	
//	public Integer No_of__days(Date from, Date To) {
//		if(from.getYear() == To.getYear()) {
//		Integer days = Math.abs(from.getDate() - To.getDate());
//		return days+1;
//		}else if(from.getMonth()!= To.getMonth()) {
//			Integer days
//		}
//		
//	}
	
	public Leaveresponsebody applyleave(Leaverequestbody leavereq,String user) {
		Leaveresponsebody response;
		//Long days = No_of__days(leavereq.getFrom(), leavereq.getTo());
		
		Employee employee =   emprepo.findByEmail(user);
		Manager manager =  employee.getManager();
		Leave leave = new Leave();
		leave.setReason(leavereq.getReason());
		leave.setFrom(leavereq.getFrom());
		leave.setTo(leavereq.getTo());
		leave.setNo_of_days(leavereq.getNo_of_days());
		leave.setType_of_leave(leavereq.getType_of_leave());
		leave.setStatus("PENDING");
		leave.setEmpid(employee);
		leave.setManager_id(manager);
		
		Totalleaves Ltotal = totalleavesrepo.getallleaves(employee);
		Integer applied = Ltotal.getLeave_applied();
		Ltotal.setLeave_applied(++applied);
		leaverepo.save(leave);
		totalleavesrepo.save(Ltotal);
		
	return response = new Leaveresponsebody(leavereq.getId(), leavereq.getReason(), leavereq.getFrom(), leavereq.getTo(),leave.getNo_of_days(),leave.getStatus());
		
	}
	
//	public Leaveresponsebody requests(String manager) {
//		Leaveresponsebody response = new Leaveresponsebody();
//		Integer manager_id = managerepo.findId(manager);
//		
//		Leave leave = leaverepo.findformananger(manager_id);
//		return response;
//	}
	
	public List<Leave> applied(Employee Id) {
		Pageable pageable = PageRequest.of(0, 10);
		return leaverepo.getallapplied(Id,pageable);
	}
	
	
	public void accept(Integer Id) {
		Leave leave = leaverepo.findById(Id).get();
		leave.setStatus("APPROVED");
		Totalleaves total_leave=  totalleavesrepo.getallleaves(leave.getEmpid());
		System.out.println(total_leave.getLeaves_taken());
		if(leave.getType_of_leave().contains("SICK")) {
			int sick = total_leave.getSick();
			total_leave.setSick(++sick);
		}if(leave.getType_of_leave().contains("EMERGENCY")) {
			int emergency = total_leave.getEmergency();
			total_leave.setSick(++emergency);
		}
		if(leave.getType_of_leave().contains("PATERNITY")) {
			int paternity = total_leave.getPaternity();
			total_leave.setSick(++paternity);
		}
		if(leave.getType_of_leave().contains("MATERNITY")) {
			int maternity = total_leave.getMaternity();
			total_leave.setSick(++maternity);
		}
		int applied=  total_leave.getLeave_applied();
		total_leave.setLeave_applied(--applied);
		
		int taken=  total_leave.getLeaves_taken();
		System.out.println("Taken"+""+taken);
		total_leave.setLeaves_taken(++taken);
		
		int remaning = total_leave.getRemaining_leaves();
		total_leave.setRemaining_leaves(--remaning);
		
		leaverepo.save(leave);
	}
	
	public void deny(Integer Id) {
		Leave leave = leaverepo.findById(Id).get();
		leave.getEmpid();
		leave.setStatus("DENIED");
		leaverepo.save(leave);
	}
}
