package com.example.Leavemanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Leavemanagement.entity.Employee;
import com.example.Leavemanagement.entity.Totalleaves;

@Repository
public interface Total_leavesrepo extends JpaRepository<Totalleaves, Integer> {
	
	@Query("SELECT t FROM Totalleaves t WHERE t.emp_id=:emp_id")
	  Totalleaves getallleaves(@Param("emp_id") Employee emp_id);

}
