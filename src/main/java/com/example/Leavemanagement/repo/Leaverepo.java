package com.example.Leavemanagement.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Leavemanagement.entity.Employee;
import com.example.Leavemanagement.entity.Leave;
import com.example.Leavemanagement.entity.Manager;

@Repository
public interface Leaverepo extends JpaRepository<Leave, Integer>{

	
	@Query("SELECT l FROM Leave l WHERE l.manager_id =:manager_id AND l.Status=:status")
	List<Leave> findformananger(Manager manager_id,String status);
	
	
	@Query("SELECT l FROM Leave l WHERE l.empid =:empid")
	List<Leave> getallapplied(@Param(value="empid") Employee empid,Pageable pageable);
}
