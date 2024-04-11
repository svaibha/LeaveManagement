package com.example.Leavemanagement.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Leavemanagement.entity.Employee;
import com.example.Leavemanagement.entity.Manager;

@Repository
public interface Managerrepo extends JpaRepository<Manager, Integer> {

	
	
//	@org.springframework.transaction.annotation.Transactional
//	@Query("SELECT FROM manager m WHERE m.manager_id=:manager_id")
//	void findbylong(Long manager_id);
	
	@Query("SELECT m.id FROM Manager m WHERE m.email =:email")
	Integer findId(@Param(value = "email") String email);
	
	Manager findByEmail(String email);
	
}

