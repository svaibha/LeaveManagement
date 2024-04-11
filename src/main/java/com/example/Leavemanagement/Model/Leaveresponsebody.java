package com.example.Leavemanagement.Model;

import java.util.Date;

import jakarta.persistence.Column;

public class Leaveresponsebody {
	private Integer Id;
	private String Reason;
	private String From;
	private String To;
	private String no_of_days;
	private String Status;
	private String toleave;
	private String msg;
	
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
	public String getNo_of_days() {
		return no_of_days;
	}
	public void setNo_of_days(String no_of_days) {
		this.no_of_days = no_of_days;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	@Override
	public String toString() {
		return "Leaveresponsebody [Id=" + Id + ", Reason=" + Reason + ", From=" + From + ", To=" + To + ", no_of_days="
				+ no_of_days + ", Status=" + Status + "]";
	}
	
	public Leaveresponsebody(Integer id, String reason, String from, String to, String no_of_days, String status) {
		super();
		Id = id;
		Reason = reason;
		From = from;
		To = to;
		this.no_of_days = no_of_days;
		Status = status;
	}
	public Leaveresponsebody() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Leaveresponsebody(Integer id, String reason, String from, String to, String no_of_days, String status,
			String toleave) {
		super();
		Id = id;
		Reason = reason;
		From = from;
		To = to;
		this.no_of_days = no_of_days;
		Status = status;
		this.toleave = toleave;
	}
	public Leaveresponsebody(String msg) {
		super();
		this.msg = msg;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
	
	

}
