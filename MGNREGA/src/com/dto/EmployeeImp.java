package com.dto;

import java.time.LocalDate;

public class EmployeeImp implements Employee{
	private String name;
	private String email;
	private String contact;
	private LocalDate dob;
	private int eid;
	private int epid;
	private LocalDate joiningDate ;
	private double wages;
	
	public EmployeeImp() {}

	public EmployeeImp(String name, String email, String contact, LocalDate dob) {
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.dob = dob;
	}
	
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public int getEpid() {
		return epid;
	}

	public void setEpid(int epid) {
		this.epid = epid;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public double getWages() {
		return wages;
	}

	public void setWages(double wages) {
		this.wages = wages;
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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Employee Id = " + eid + ", Name = " + name + ", Emai = " + email + ", Contact = " + contact + 
			   ", DOB = " + dob + ", Joining Date = " + joiningDate + ", Wages = " + wages + ", Project id = " + epid;
	}
	
	
}
