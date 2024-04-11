package com.example.Leavemanagement.Model;

import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;

public class Employeeresponsemodel {
	
	private Integer Id;
	private String first_name;
	private String middle_name;
	private String last_name;
	private String email;
	private String  joining_date;
	private String Hometown;
	private String current_Address;
	public String adhaarcard;
	public String gender;
	private String phonenumber;
	private String Emergencycontact;
	private String Nationality;
	private String Dob;
	private String Department;
	private String martial_status;
	private String Bloodgroup;
	private String ROLE;
	private String password;
	private String msg;
	private String status;
	private Object resultSet;
	
	
	
	
	
	public Object getResultSet() {
		return resultSet;
	}
	public void setResultSet(Object resultSet) {
		this.resultSet = resultSet;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMartial_status() {
		return martial_status;
	}
	public void setMartial_status(String martial_status) {
		this.martial_status = martial_status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJoining_date() {
		return joining_date;
	}
	public void setJoining_date(String joining_date) {
		this.joining_date = joining_date;
	}
	public String getHometown() {
		return Hometown;
	}
	public void setHometown(String hometown) {
		Hometown = hometown;
	}
	public String getCurrent_Address() {
		return current_Address;
	}
	public void setCurrent_Address(String current_Address) {
		this.current_Address = current_Address;
	}
	public String getAdhaarcard() {
		return adhaarcard;
	}
	public void setAdhaarcard(String adhaarcard) {
		this.adhaarcard = adhaarcard;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getEmergencycontact() {
		return Emergencycontact;
	}
	public void setEmergencycontact(String emergencycontact) {
		Emergencycontact = emergencycontact;
	}
	public String getNationality() {
		return Nationality;
	}
	public void setNationality(String nationality) {
		Nationality = nationality;
	}
	public String getDob() {
		return Dob;
	}
	public void setDob(String dob) {
		Dob = dob;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public String getMartialstatus() {
		return martial_status;
	}
	public void setMartialstatus(String martial_status) {
		this.martial_status = martial_status;
	}
	public String getBloodgroup() {
		return Bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		Bloodgroup = bloodgroup;
	}
	public String getROLE() {
		return ROLE;
	}
	public void setROLE(String rOLE) {
		ROLE = rOLE;
	}
	public Employeeresponsemodel(Integer id, String first_name, String middle_name, String last_name, String email,
			String joining_date, String hometown, String current_Address, String adhaarcard, String gender,
			String phonenumber, String emergencycontact,  String dob, String department,
			String martial_status, String bloodgroup, String rOLE) {
		super();
		Id = id;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.email = email;
		this.joining_date = joining_date;
		Hometown = hometown;
		this.current_Address = current_Address;
		this.adhaarcard = adhaarcard;
		this.gender = gender;
		this.phonenumber = phonenumber;
		Emergencycontact = emergencycontact;
		Dob = dob;
		Department = department;
		this.martial_status = martial_status;
		Bloodgroup = bloodgroup;
		ROLE = rOLE;
	}
	public Employeeresponsemodel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EmployeeresponseBody [Id=" + Id + ", first_name=" + first_name + ", middle_name=" + middle_name
				+ ", last_name=" + last_name + ", email=" + email + ", joining_date=" + joining_date + ", Hometown="
				+ Hometown + ", current_Address=" + current_Address + ", adhaarcard=" + adhaarcard + ", gender="
				+ gender + ", phonenumber=" + phonenumber + ", Emergencycontact=" + Emergencycontact + ", Nationality="
				+ Nationality + ", Dob=" + Dob + ", Department=" + Department + ", Martialstatus=" + martial_status
				+ ", Bloodgroup=" + Bloodgroup + ", ROLE=" + ROLE + "]";
	}
	
	public Employeeresponsemodel(String msg) {
		super();
		this.msg = msg;
	}
	
	
	
	
	
	
	
}
