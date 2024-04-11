package com.example.Leavemanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Leavemanagement.entity.Employee;
import com.example.Leavemanagement.entity.Manager;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface Employeerepo extends JpaRepository<Employee, Integer>{
	
//	 @Query(value = "select e from Employee e where e.email = ?1", nativeQuery = true)
//	Optional<Employee>  findByEmailLogin(String email);
	 
	Employee  findByEmail(String email);
	
	
	@Modifying
	@org.springframework.transaction.annotation.Transactional
	@Query("Update Employee e set e.manager = :manager_id WHERE e.id IN (:emp_id)")
	void updatemapping(Optional<Manager> manager_id,Integer emp_id);
	
	
	//@org.springframework.transaction.annotation.Transactional
	@Query("SELECT e.id FROM Employee e WHERE e.id IN :id")
	List<Integer> findbyList(List<Integer> id);
	
	@Query("SELECT e.gender FROM Employee e WHERE e.email=:email")
	String findGender(@Param("email") String email);
	
	@Query("SELECT e FROM Employee e WHERE e.Roles!=:Admin")
	List<Employee> findallexcpetadmin(@Param("Admin")String Admin);
	
//	@Query("SELECT e.first_name,e.middle_name,e.last_name,e.email FROM Employee e")
//	List<String> getinfo();
	
	@Query("SELECT e FROM Employee e WHERE e.adhaarcard =:adharcard")
	List<Employee> findByAdhar(@Param("adharcard") String adharcard);
	
	
	@Query("SELECT e FROM Employee e WHERE e.approved = 0")
	List<Employee> findallNotApprov();
	
	
}
