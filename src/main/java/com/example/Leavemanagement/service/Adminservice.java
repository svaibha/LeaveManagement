package com.example.Leavemanagement.service;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Leavemanagement.Model.Employeerequestmodel;
import com.example.Leavemanagement.entity.Employee;
import com.example.Leavemanagement.entity.Manager;
import com.example.Leavemanagement.repo.Employeerepo;
import com.example.Leavemanagement.repo.Managerrepo;

@Service
public class Adminservice {
	
	@Autowired
	Employeerepo emprepo;
	@Autowired
	Managerrepo managerrepo;
	
		public void mapping(Integer Manager_id,List<Integer> employee_id) {
		Optional<Manager> manager = managerrepo.findById(Manager_id);
		List<Integer> employee = emprepo.findbyList(employee_id);
		
		
		if(manager != null && !employee.isEmpty()) {
			ListIterator<Integer> itr = employee.listIterator();
			while(itr.hasNext()) {
				emprepo.updatemapping(manager,itr.next());
			}
		}
		
	
		
//		ListIterator<Integer> itr = employee.listIterator();
//		while(itr.hasNext()) {
//			System.out.println(itr.next());
//		}
		
	}
		
		public List<Employee> Manager(String Admin) {
			return emprepo.findallexcpetadmin(Admin);
		}
		
		
		public void roleupdate(Employeerequestmodel empreq,String email) {
			Employee emp = emprepo.findByEmail(email);
			emp.setRoles(empreq.getRoles());
			System.out.println(empreq.getRoles());
			if(empreq.getRoles().contains("Manager")) {
			Manager manager = new Manager();
			manager.setFirst_name(emp.getFirst_name());
			manager.setEmail(emp.getEmail());
			manager.setDob(emp.getDob());
			manager.setJoinig_date(emp.getJoining_date());
			manager.setLast_name(manager.getLast_name());
			manager.setMiddle_name(emp.getMiddle_name());
			managerrepo.save(manager);
			emprepo.save(emp);				
			}
			
		}
		public void employeeupdate(Employeerequestmodel empreq,String email) {
			Manager manager = managerrepo.findByEmail(email);
			managerrepo.delete(manager);
			Employee emp = emprepo.findByEmail(email);
			emp.setRoles(empreq.getRoles());
			emprepo.save(emp);
		}
		
		public List<Employee> authenticate() {
			   List<Employee> employee = emprepo.findallNotApprov();
			   System.out.println(employee);
			return employee;
			
		}
		
		
		
}
