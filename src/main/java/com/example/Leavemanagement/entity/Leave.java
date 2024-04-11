package com.example.Leavemanagement.entity;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Leave")
public class Leave {
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	@Column(name="Reason")
	private String Reason;
	@Column(name="From_date")
	private String From_date;
	@Column(name="To_date")
	private String To_date;
	@Column(name="no_of_days")
	private String no_of_days;
	@Column(name = "status")
	private String Status;
	@Column(name="type_of_leave")
	private String type_of_leave;
	@ManyToOne
	@JoinColumn(name="emp_Id")
	private Employee empid;
	@ManyToOne
	@JoinColumn(name="manager_id")
	private Manager manager_id;
	
	
	
	
	
	public String getFrom_date() {
		return From_date;
	}


	public void setFrom_date(String from_date) {
		From_date = from_date;
	}


	public String getTo_date() {
		return To_date;
	}


	public void setTo_date(String to_date) {
		To_date = to_date;
	}


	public Employee getEmpid() {
		return empid;
	}


	public void setEmpid(Employee empid) {
		this.empid = empid;
	}


	public Manager getManager_id() {
		return manager_id;
	}


	public void setManager_id(Manager manager_id) {
		this.manager_id = manager_id;
	}


	public Integer getId() {
		return Id;
	}
	
	
	


	public void setId(Integer id) {
		Id = id;
	}
	public String getReason() {
		return Reason;
	}
	public void setReason(String reason) {
		Reason = reason;
	}
	public String getFrom() {
		return From_date;
	}
	public void setFrom(String from) {
		From_date = from;
	}
	public String getTo() {
		return To_date;
	}
	public void setTo(String to) {
		To_date = to;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String Status) {
		this.Status = Status;
	}
	@Override
	public String toString() {
		return "Leave [Id=" + Id + ", Reason=" + Reason + ", From=" + From_date + ", To=" + To_date + ", no_of_days=" + no_of_days
				+ ", Status=" + Status + "]";
	}
	
	public Leave() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getNo_of_days() {
		return no_of_days;
	}


	public void setNo_of_days(String no_of_days) {
		this.no_of_days = no_of_days;
	}


	public String getType_of_leave() {
		return type_of_leave;
	}


	public void setType_of_leave(String type_of_leave) {
		this.type_of_leave = type_of_leave;
	}


	public Leave(Integer id, String reason, String from_date, String to_date, String no_of_days, String status,
			String type_of_leave, Employee empid, Manager manager_id) {
		super();
		Id = id;
		Reason = reason;
		From_date = from_date;
		To_date = to_date;
		this.no_of_days = no_of_days;
		Status = status;
		this.type_of_leave = type_of_leave;
		this.empid = empid;
		this.manager_id = manager_id;
	}


	
	
	
	
	
}
