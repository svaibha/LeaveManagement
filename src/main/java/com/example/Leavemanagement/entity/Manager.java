package com.example.Leavemanagement.entity;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Manager")
public class Manager {
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	@Column(name = "manager_id")
	private Integer Manager_Id;
	@Column(name="first_name")
	private String first_name;
	@Column(name="middle_name")
	private String middle_name;
	@Column(name="last_name")
	private String last_name;
	@Column(name="email")
	private String email;
	@Column(name="joining_date")
	private java.util.Date joinig_date;
	@Column(name="dob")
	private java.util.Date dob;
	@OneToMany(mappedBy = "manager")
	private List<Employee> employee;
	@OneToMany(mappedBy = "manager_id")
	private List<Leave> leaves;
	
	public Integer getId() {
		return Manager_Id;
	}
	public void setId(Integer id) {
		Manager_Id = id;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public java.util.Date getJoinig_date() {
		return joinig_date;
	}
	public void setJoinig_date(java.util.Date joinig_date) {
		this.joinig_date = joinig_date;
	}
	public java.util.Date getDob() {
		return dob;
	}
	public void setDob(java.util.Date date) {
		this.dob = date;
	}
	@Override
	public String toString() {
		return "Manager [Id=" + Manager_Id + ", email=" + email + ", joinig_date=" + joinig_date + ", dob="
				+ dob + "]";
	}

	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getMiddle_name() {
		return middle_name;
	}
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Manager(Integer id, String first_name, String middle_name, String last_name, String email, java.util.Date joinig_date,
			java.util.Date dob) {
		super();
		Manager_Id = id;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.email = email;
		this.joinig_date = joinig_date;
		this.dob = dob;
	}
	public Integer getManager_Id() {
		return Manager_Id;
	}
	public void setManager_Id(Integer manager_Id) {
		Manager_Id = manager_Id;
	}
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	
	
	
	
	
}
