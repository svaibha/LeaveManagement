package com.example.Leavemanagement.Model;

import java.util.Date;



import jakarta.persistence.Column;

public class Leaverequestbody {

	private Integer Id;
	private String Reason;
	private String From;
	private String To;
	private String no_of_days;
	private String type_of_leave;
//	private String Status;
	private String message;
	

	
	
	
	
//	public String getStatus() {
//		return Status;
//	}
//	public void setStatus(String status) {
//		Status = status;
//	}
	public String getNo_of_days() {
		return no_of_days;
	}
	public void setNo_of_days(String no_of_days) {
		this.no_of_days = no_of_days;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Leaverequestbody(String message) {
		super();
		this.message = message;
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
		return From;
	}
	public void setFrom(String from) {
		From = from;
	}
	public String getTo() {
		return To;
	}
	public void setTo(String to) {
		To = to;
	}
	
	
	public Leaverequestbody() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getType_of_leave() {
		return type_of_leave;
	}
	public void setType_of_leave(String type_of_leave) {
		this.type_of_leave = type_of_leave;
	}
	public Leaverequestbody(Integer id, String reason, String from, String to, String no_of_days, String type_of_leave,
			String message) {
		super();
		Id = id;
		Reason = reason;
		From = from;
		To = to;
		this.no_of_days = no_of_days;
		this.type_of_leave = type_of_leave;
		this.message = message;
	}
	
	
	
	
	
	
}
