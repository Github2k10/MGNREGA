package com.dto;

import java.time.LocalDate;

public class EmployeeImp {
	private int eid;
	private String name;
	private String email;
	private int working_day;
	private int pid;
	private LocalDate dob;
	private int gid;
	public EmployeeImp(int eid, String name, String email, int working_day, int pid, LocalDate dob, int gid) {
		this.eid = eid;
		this.name = name;
		this.email = email;
		this.working_day = working_day;
		this.pid = pid;
		this.dob = dob;
		this.gid = gid;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getWorking_day() {
		return working_day;
	}
	public void setWorking_day(int working_day) {
		this.working_day = working_day;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	
	@Override
	public String toString() {
		return "Employee Id = " + eid + ", Name = " + name + ", Email = " + email + ", Working days = " + working_day
				+ ", DOB = " + dob;
	}
	
	
	
}
