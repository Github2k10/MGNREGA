package com.dto;

import java.time.LocalDate;

public interface Employee {
	public int getEid();
	
	public void setEid(int eid);
	
	public String getName();
	
	public void setName(String name);
	
	public String getEmail();
	
	public void setEmail(String email);
	
	public LocalDate getJoining_Date();

	public void setJoining_Date(LocalDate joining_Date);
	
	public int getPid();
	
	public void setPid(int epid);
	
	public LocalDate getDob() ;
	
	public void setDob(LocalDate dob) ;
	
	public int getGid();
	
	public void setGid(int egpmid);
}
