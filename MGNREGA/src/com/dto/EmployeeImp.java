package com.dto;

import java.time.LocalDate;

public class EmployeeImp {
	private int eid;
	private String name;
	private String email;
	private LocalDate joining_Date;
	private double wages;
	private LocalDate dob;
	private int epid;
	private int egpmid;
	
	public EmployeeImp() {}
	
	public EmployeeImp(int eid, String name, String email, LocalDate joining_Date, double wages, int epid, LocalDate dob, int egpmid) {
		this.eid = eid;
		this.name = name;
		this.email = email;
		this.joining_Date = joining_Date;
		this.wages = wages;
		this.epid = epid;
		this.dob = dob;
		this.egpmid = egpmid;
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
	
	public int getPid() {
		return epid;
	}
	public void setPid(int epid) {
		this.epid = epid;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public int getGid() {
		return egpmid;
	}
	public void setGid(int egpmid) {
		this.egpmid = egpmid;
	}
	
	public LocalDate getJoining_Date() {
		return joining_Date;
	}

	public void setJoining_Date(LocalDate joining_Date) {
		this.joining_Date = joining_Date;
	}

	public double getWages() {
		return wages;
	}

	public void setWages(double wages) {
		this.wages = wages;
	}

	@Override
	public String toString() {
		return "Employee Id = " + eid + ", Name = " + name + ", Email = " + email 
				+ ", DOB = " + dob + ", Joining Date = " + joining_Date + ", Wages = " + wages; 
	}
	
	
	
}
