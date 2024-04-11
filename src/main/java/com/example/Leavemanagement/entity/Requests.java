package com.example.Leavemanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name="Requests")
public class Requests {
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	@Column(name="first_name")
	private String first_name;
	@Column(name="middle_name")
	private String middle_name;
	@Column(name="last_name")
	private String last_name;
	@Column(name="email")
	private String email;
	@Column(name="joining_date")
	private java.util.Date joining_date;
	@Column(name="home_town")
	private String Hometown;
	@Column(name = "current_address")
	private String current_address;
	@Column(name="Adharcard")
	private String adhaarcard;
	@Column(name="Gender")
	private String gender;
	@Column(name="phonenumber")
	private String phonenumber;
	@Column(name="emergency_contact")
	private String emergency_contact;
	@Column(name="Dob")
	private java.util.Date Dob;
	@Column(name="department")
	private String Department;
	@Column(name="martial_status")
	private String martial_status;
	@Column(name="Bloodgroup")
	private String Bloodgroup;
	@Column(name="ROLE")
	private String Roles;
	@Column(name="password")
	private String password;
	@Column(name="approved")
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
	public java.util.Date getJoining_date() {
		return joining_date;
	}
	public void setJoining_date(java.util.Date joining_date) {
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
	public java.util.Date getDob() {
		return Dob;
	}
	public void setDob(java.util.Date dob) {
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
	public Requests() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
