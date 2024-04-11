package com.example.Leavemanagement.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Total_leaves")
public class Totalleaves implements Serializable{
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	private Integer total_leaves;
	private Integer Casual;
	private Integer Sick;
	private Integer Emergency;
	private Integer Maternity;
	private Integer Paternity;
	private Integer leaves_taken;
	private Integer Remaining_leaves;
	private Integer leave_applied;
	@OneToOne
	@JoinColumn(name="emp_id",referencedColumnName = "Id")
	private Employee emp_id;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Integer getTotal_leaves() {
		return total_leaves;
	}
	public void setTotal_leaves(Integer total_leaves) {
		this.total_leaves = total_leaves;
	}
	public Integer getCasual() {
		return Casual;
	}
	public void setCasual(Integer casual) {
		Casual = casual;
	}
	public Integer getSick() {
		return Sick;
	}
	public void setSick(Integer sick) {
		Sick = sick;
	}
	public Integer getEmergency() {
		return Emergency;
	}
	public void setEmergency(Integer emergency) {
		Emergency = emergency;
	}
	public Integer getMaternity() {
		return Maternity;
	}
	public void setMaternity(Integer maternity) {
		Maternity = maternity;
	}
	public Integer getPaternity() {
		return Paternity;
	}
	public void setPaternity(Integer paternity) {
		Paternity = paternity;
	}
	public Employee getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(Employee emp_id) {
		this.emp_id = emp_id;
	}
	public Totalleaves(Integer id, Integer total_leaves, Integer casual, Integer sick, Integer emergency,
			Integer maternity, Integer paternity, Employee emp_id) {
		super();
		Id = id;
		this.total_leaves = total_leaves;
		Casual = casual;
		Sick = sick;
		Emergency = emergency;
		Maternity = maternity;
		Paternity = paternity;
		this.emp_id = emp_id;
	}
	public Totalleaves() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getLeaves_taken() {
		return leaves_taken;
	}
	public void setLeaves_taken(Integer leaves_taken) {
		this.leaves_taken = leaves_taken;
	}
	public Integer getRemaining_leaves() {
		return Remaining_leaves;
	}
	public void setRemaining_leaves(Integer remaining_leaves) {
		Remaining_leaves = remaining_leaves;
	}
	public Integer getLeave_applied() {
		return leave_applied;
	}
	public void setLeave_applied(Integer leave_applied) {
		this.leave_applied = leave_applied;
	}
	
	
	
	
	
}
