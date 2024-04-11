package com.example.Leavemanagement.Model;

import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.example.Leavemanagement.entity.Manager;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Employeerequestmodel {
	
	
	private Integer Id;
	private String first_name;
	private String middle_name;
	private String last_name;
	private String email;
	private String joining_date;
	private String Hometown;
	private String current_Address;
	public String adhaarcard;
	public String gender;
	private String phonenumber;
	private String emergencycontact;
	private String Dob;
	private String Department;
	private String martial_status;
	private String Bloodgroup;
	private String Roles;
	private String password;
	private Manager manager;
	
	
	
	
	public Manager getManager() {
		return manager;
	}
	public void setManage(Manager manager) {
		this.manager = manager;
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
		return emergencycontact;
	}
	public void setEmergencycontact(String emergencycontact) {
		this.emergencycontact = emergencycontact;
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
	
	
	public Employeerequestmodel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Employeerequestmodel [Id=" + Id + ", first_name=" + first_name + ", middle_name=" + middle_name
				+ ", last_name=" + last_name + ", email=" + email + ", joining_date=" + joining_date + ", Hometown="
				+ Hometown + ", current_Address=" + current_Address + ", adhaarcard=" + adhaarcard + ", gender="
				+ gender + ", phonenumber=" + phonenumber + ", emergencycontact=" + emergencycontact + ", Dob=" + Dob
				+ ", Department=" + Department + ", martial_status=" + martial_status + ", Bloodgroup=" + Bloodgroup
				+ ", Roles=" + Roles + ", password=" + password + ", manager=" + manager + "]";
	}
	public String getRoles() {
		return Roles;
	}
	public void setRoles(String roles) {
		Roles = roles;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public Employeerequestmodel(Integer id, String first_name, String middle_name, String last_name, String email,
			String joining_date, String hometown, String current_Address, String adhaarcard, String gender,
			String phonenumber, String emergencycontact, String dob, String department, String martial_status,
			String bloodgroup, String roles, String password, Manager manager) {
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
		this.emergencycontact = emergencycontact;
		Dob = dob;
		Department = department;
		this.martial_status = martial_status;
		Bloodgroup = bloodgroup;
		Roles = roles;
		this.password = password;
		this.manager = manager;
	}
	public String getDob() {
		return Dob;
	}
	public void setDob(String dob) {
		Dob = dob;
	}
	
	
	

}
