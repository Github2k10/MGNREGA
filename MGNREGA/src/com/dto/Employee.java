package com.dto;

import java.time.LocalDate;

public interface Employee {
	public String getName();

	public void setName(String name);

	public String getEmail();

	public void setEmail(String email);

	public String getContact() ;

	public void setContact(String contact) ;

	public LocalDate getDob();

	public void setDob(LocalDate dob);
	
	public int getEid();

	public void setEid(int eid);

	public int getEpid();

	public void setEpid(int epid);

	public LocalDate getJoiningDate();

	public void setJoiningDate(LocalDate joiningDate);

	public double getWages();
	
	public void setWages(double wages);
	
}
