package com.example.Leavemanagement.Model;

import java.util.Date;

import jakarta.persistence.Column;

public class Requestmodel {

	private Integer Id;
	private String first_name;
	private String middle_name;
	private String last_name;
	private String email;
	private String joining_date;
	private String Hometown;
	private String current_address;
	private String adhaarcard;
	private String gender;
	private String phonenumber;
	private String emergency_contact;
	private String Dob;
	private String Department;
	private String martial_status;
	private String Bloodgroup;
	private String Roles;
	private String password;
	private Integer approved;
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
	public String getCurrent_address() {
		return current_address;
	}
	public void setCurrent_address(String current_address) {
		this.current_address = current_address;
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
	public String getEmergency_contact() {
		return emergency_contact;
	}
	public void setEmergency_contact(String emergency_contact) {
		this.emergency_contact = emergency_contact;
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
	public String getMartial_status() {
		return martial_status;
	}
	public void setMartial_status(String martial_status) {
		this.martial_status = martial_status;
	}
	public String getBloodgroup() {
		return Bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		Bloodgroup = bloodgroup;
	}
	public String getRoles() {
		return Roles;
	}
	public void setRoles(String roles) {
		Roles = roles;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getApproved() {
		return approved;
	}
	public void setApproved(Integer approved) {
		this.approved = approved;
	}
	public Requestmodel(Integer id, String first_name, String middle_name, String last_name, String email,
			String joining_date, String hometown, String current_address, String adhaarcard, String gender,
			String phonenumber, String emergency_contact, String dob, String department, String martial_status,
			String bloodgroup, String roles, String password, Integer approved) {
		super();
		Id = id;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.email = email;
		this.joining_date = joining_date;
		Hometown = hometown;
		this.current_address = current_address;
		this.adhaarcard = adhaarcard;
		this.gender = gender;
		this.phonenumber = phonenumber;
		this.emergency_contact = emergency_contact;
		Dob = dob;
		Department = department;
		this.martial_status = martial_status;
		Bloodgroup = bloodgroup;
		Roles = roles;
		this.password = password;
		this.approved = approved;
	}
	public Requestmodel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
